/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Shape;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.LineMetrics;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JToolTip;
/*     */ import javax.swing.JViewport;
/*     */ import javax.swing.Scrollable;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.ToolTipManager;
/*     */ 
/*     */ public class GridPanel extends JPanel
/*     */   implements Scrollable, PseudoInfiniteViewport.Pannable
/*     */ {
/*     */   private static final int MIN_CELL_SIZE = 12;
/*     */   private static final int DEFAULT_CELL_SIZE = 48;
/*     */   private static final int DEFAULT_CELL_COUNT = 10;
/*     */   private static final int TIP_DELAY = 1000;
/*     */   private Grid<?> grid;
/*     */   private int numRows;
/*     */   private int numCols;
/*     */   private int originRow;
/*     */   private int originCol;
/*     */   private int cellSize;
/*     */   private boolean toolTipsEnabled;
/*  73 */   private Color backgroundColor = Color.WHITE;
/*     */   private ResourceBundle resources;
/*     */   private DisplayMap displayMap;
/*     */   private Location currentLocation;
/*     */   private Timer tipTimer;
/*     */   private JToolTip tip;
/*     */   private JPanel glassPane;
/*     */ 
/*     */   public GridPanel(DisplayMap map, ResourceBundle res)
/*     */   {
/*  87 */     this.displayMap = map;
/*  88 */     this.resources = res;
/*  89 */     setToolTipsEnabled(true);
/*     */   }
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  98 */     Graphics2D g2 = (Graphics2D)g;
/*     */ 
/* 100 */     super.paintComponent(g2);
/* 101 */     if (this.grid == null) {
/* 102 */       return;
/*     */     }
/* 104 */     Insets insets = getInsets();
/* 105 */     g2.setColor(this.backgroundColor);
/* 106 */     g2.fillRect(insets.left, insets.top, this.numCols * (this.cellSize + 1) + 1, this.numRows * (this.cellSize + 1) + 1);
/*     */ 
/* 109 */     drawWatermark(g2);
/* 110 */     drawGridlines(g2);
/* 111 */     drawOccupants(g2);
/* 112 */     drawCurrentLocation(g2);
/*     */   }
/*     */ 
/*     */   private void drawOccupant(Graphics2D g2, int xleft, int ytop, Object obj)
/*     */   {
/* 129 */     Rectangle cellToDraw = new Rectangle(xleft, ytop, this.cellSize, this.cellSize);
/*     */ 
/* 133 */     if (cellToDraw.intersects(g2.getClip().getBounds()))
/*     */     {
/* 135 */       Graphics2D g2copy = (Graphics2D)g2.create();
/* 136 */       g2copy.clip(cellToDraw);
/*     */ 
/* 138 */       Display displayObj = this.displayMap.findDisplayFor(obj.getClass());
/* 139 */       displayObj.draw(obj, this, g2copy, cellToDraw);
/* 140 */       g2copy.dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawGridlines(Graphics2D g2)
/*     */   {
/* 151 */     Rectangle curClip = g2.getClip().getBounds();
/* 152 */     int top = getInsets().top; int left = getInsets().left;
/*     */ 
/* 154 */     int miny = Math.max(0, (curClip.y - top) / (this.cellSize + 1)) * (this.cellSize + 1) + top;
/* 155 */     int minx = Math.max(0, (curClip.x - left) / (this.cellSize + 1)) * (this.cellSize + 1) + left;
/* 156 */     int maxy = Math.min(this.numRows, (curClip.y + curClip.height - top + this.cellSize) / (this.cellSize + 1)) * (this.cellSize + 1) + top;
/*     */ 
/* 159 */     int maxx = Math.min(this.numCols, (curClip.x + curClip.width - left + this.cellSize) / (this.cellSize + 1)) * (this.cellSize + 1) + left;
/*     */ 
/* 163 */     g2.setColor(Color.GRAY);
/* 164 */     for (int y = miny; y <= maxy; y += this.cellSize + 1) {
/* 165 */       for (int x = minx; x <= maxx; x += this.cellSize + 1)
/*     */       {
/* 167 */         Location loc = locationForPoint(new Point(x + this.cellSize / 2, y + this.cellSize / 2));
/*     */ 
/* 169 */         if ((loc != null) && (!this.grid.isValid(loc)))
/* 170 */           g2.fillRect(x + 1, y + 1, this.cellSize, this.cellSize);
/*     */       }
/*     */     }
/* 173 */     g2.setColor(Color.BLACK);
/* 174 */     for (int y = miny; y <= maxy; y += this.cellSize + 1)
/*     */     {
/* 176 */       g2.drawLine(minx, y, maxx, y);
/*     */     }
/* 178 */     for (int x = minx; x <= maxx; x += this.cellSize + 1)
/*     */     {
/* 180 */       g2.drawLine(x, miny, x, maxy);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawOccupants(Graphics2D g2)
/*     */   {
/* 189 */     ArrayList occupantLocs = this.grid.getOccupiedLocations();
/* 190 */     for (int index = 0; index < occupantLocs.size(); index++)
/*     */     {
/* 192 */       Location loc = (Location)occupantLocs.get(index);
/*     */ 
/* 194 */       int xleft = colToXCoord(loc.getCol());
/* 195 */       int ytop = rowToYCoord(loc.getRow());
/* 196 */       drawOccupant(g2, xleft, ytop, this.grid.get(loc));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawCurrentLocation(Graphics2D g2)
/*     */   {
/* 206 */     if ("hide".equals(System.getProperty("info.gridworld.gui.selection")))
/* 207 */       return;
/* 208 */     if (this.currentLocation != null)
/*     */     {
/* 210 */       Point p = pointForLocation(this.currentLocation);
/* 211 */       g2.drawRect(p.x - this.cellSize / 2 - 2, p.y - this.cellSize / 2 - 2, this.cellSize + 3, this.cellSize + 3);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawWatermark(Graphics2D g2)
/*     */   {
/* 222 */     if ("hide".equals(System.getProperty("info.gridworld.gui.watermark")))
/* 223 */       return;
/* 224 */     g2 = (Graphics2D)g2.create();
/* 225 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/* 227 */     Rectangle rect = getBounds();
/* 228 */     g2.setPaint(new Color(227, 211, 211));
/* 229 */     int WATERMARK_FONT_SIZE = 100;
/* 230 */     String s = this.resources.getString("version.id");
/* 231 */     if ("1.0".compareTo(s) <= 0) return;
/* 232 */     g2.setFont(new Font("SansSerif", 1, 100));
/* 233 */     FontRenderContext frc = g2.getFontRenderContext();
/* 234 */     Rectangle2D bounds = g2.getFont().getStringBounds(s, frc);
/* 235 */     float centerX = rect.x + rect.width / 2;
/* 236 */     float centerY = rect.y + rect.height / 2;
/* 237 */     float leftX = centerX - (float)bounds.getWidth() / 2.0F;
/* 238 */     LineMetrics lm = g2.getFont().getLineMetrics(s, frc);
/* 239 */     float baselineY = centerY - lm.getHeight() / 2.0F + lm.getAscent();
/* 240 */     g2.drawString(s, leftX, baselineY);
/*     */   }
/*     */ 
/*     */   public void setToolTipsEnabled(boolean flag)
/*     */   {
/* 250 */     if ("hide".equals(System.getProperty("info.gridworld.gui.tooltips")))
/* 251 */       flag = false;
/* 252 */     if (flag)
/* 253 */       ToolTipManager.sharedInstance().registerComponent(this);
/*     */     else
/* 255 */       ToolTipManager.sharedInstance().unregisterComponent(this);
/* 256 */     this.toolTipsEnabled = flag;
/*     */   }
/*     */ 
/*     */   public void setGrid(Grid<?> gr)
/*     */   {
/* 267 */     this.currentLocation = new Location(0, 0);
/* 268 */     JViewport vp = getEnclosingViewport();
/*     */ 
/* 270 */     if (vp != null) {
/* 271 */       vp.setViewPosition(new Point(0, 0));
/*     */     }
/* 273 */     this.grid = gr;
/* 274 */     this.originRow = (this.originCol = 0);
/*     */ 
/* 276 */     if ((this.grid.getNumRows() == -1) && (this.grid.getNumCols() == -1))
/*     */     {
/* 278 */       this.numRows = (this.numCols = 2000);
/*     */     }
/*     */     else
/*     */     {
/* 283 */       this.numRows = this.grid.getNumRows();
/* 284 */       this.numCols = this.grid.getNumCols();
/*     */     }
/* 286 */     recalculateCellSize(12);
/*     */   }
/*     */ 
/*     */   private int extraWidth()
/*     */   {
/* 292 */     return getInsets().left + getInsets().right;
/*     */   }
/*     */ 
/*     */   private int extraHeight()
/*     */   {
/* 297 */     return getInsets().top + getInsets().left;
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize()
/*     */   {
/* 306 */     return new Dimension(this.numCols * (this.cellSize + 1) + 1 + extraWidth(), this.numRows * (this.cellSize + 1) + 1 + extraHeight());
/*     */   }
/*     */ 
/*     */   public Dimension getMinimumSize()
/*     */   {
/* 316 */     return new Dimension(this.numCols * 13 + 1 + extraWidth(), this.numRows * 13 + 1 + extraHeight());
/*     */   }
/*     */ 
/*     */   public void zoomIn()
/*     */   {
/* 325 */     this.cellSize *= 2;
/* 326 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void zoomOut()
/*     */   {
/* 334 */     this.cellSize = Math.max(this.cellSize / 2, 12);
/* 335 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void recenter(Location loc)
/*     */   {
/* 344 */     this.originRow = loc.getRow();
/* 345 */     this.originCol = loc.getCol();
/* 346 */     repaint();
/* 347 */     JViewport vp = getEnclosingViewport();
/* 348 */     if (vp != null)
/*     */     {
/* 350 */       if ((!isPannableUnbounded()) || (!(vp instanceof PseudoInfiniteViewport)))
/*     */       {
/* 352 */         vp.setViewPosition(pointForLocation(loc));
/*     */       }
/* 354 */       else showPanTip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Location locationForPoint(Point p)
/*     */   {
/* 368 */     return new Location(yCoordToRow(p.y), xCoordToCol(p.x));
/*     */   }
/*     */ 
/*     */   public Point pointForLocation(Location loc)
/*     */   {
/* 373 */     return new Point(colToXCoord(loc.getCol()) + this.cellSize / 2, rowToYCoord(loc.getRow()) + this.cellSize / 2);
/*     */   }
/*     */ 
/*     */   private int xCoordToCol(int xCoord)
/*     */   {
/* 380 */     return (xCoord - 1 - getInsets().left) / (this.cellSize + 1) + this.originCol;
/*     */   }
/*     */ 
/*     */   private int yCoordToRow(int yCoord)
/*     */   {
/* 385 */     return (yCoord - 1 - getInsets().top) / (this.cellSize + 1) + this.originRow;
/*     */   }
/*     */ 
/*     */   private int colToXCoord(int col)
/*     */   {
/* 390 */     return (col - this.originCol) * (this.cellSize + 1) + 1 + getInsets().left;
/*     */   }
/*     */ 
/*     */   private int rowToYCoord(int row)
/*     */   {
/* 395 */     return (row - this.originRow) * (this.cellSize + 1) + 1 + getInsets().top;
/*     */   }
/*     */ 
/*     */   public String getToolTipText(MouseEvent evt)
/*     */   {
/* 409 */     Location loc = locationForPoint(evt.getPoint());
/* 410 */     return getToolTipText(loc);
/*     */   }
/*     */ 
/*     */   private String getToolTipText(Location loc)
/*     */   {
/* 415 */     if ((!this.toolTipsEnabled) || (loc == null) || (!this.grid.isValid(loc)))
/* 416 */       return null;
/* 417 */     Object f = this.grid.get(loc);
/* 418 */     if (f != null) {
/* 419 */       return MessageFormat.format(this.resources.getString("cell.tooltip.nonempty"), new Object[] { loc, f });
/*     */     }
/*     */ 
/* 423 */     return MessageFormat.format(this.resources.getString("cell.tooltip.empty"), new Object[] { loc, f });
/*     */   }
/*     */ 
/*     */   public void setCurrentLocation(Location loc)
/*     */   {
/* 434 */     this.currentLocation = loc;
/*     */   }
/*     */ 
/*     */   public Location getCurrentLocation()
/*     */   {
/* 443 */     return this.currentLocation;
/*     */   }
/*     */ 
/*     */   public void moveLocation(int dr, int dc)
/*     */   {
/* 453 */     Location newLocation = new Location(this.currentLocation.getRow() + dr, this.currentLocation.getCol() + dc);
/*     */ 
/* 455 */     if (!this.grid.isValid(newLocation)) {
/* 456 */       return;
/*     */     }
/* 458 */     this.currentLocation = newLocation;
/*     */ 
/* 460 */     JViewport viewPort = getEnclosingViewport();
/* 461 */     if (isPannableUnbounded())
/*     */     {
/* 463 */       if (this.originRow > this.currentLocation.getRow())
/* 464 */         this.originRow = this.currentLocation.getRow();
/* 465 */       if (this.originCol > this.currentLocation.getCol())
/* 466 */         this.originCol = this.currentLocation.getCol();
/* 467 */       Dimension dim = viewPort.getSize();
/* 468 */       int rows = dim.height / (this.cellSize + 1);
/* 469 */       int cols = dim.width / (this.cellSize + 1);
/* 470 */       if (this.originRow + rows - 1 < this.currentLocation.getRow())
/* 471 */         this.originRow = (this.currentLocation.getRow() - rows + 1);
/* 472 */       if (this.originCol + rows - 1 < this.currentLocation.getCol())
/* 473 */         this.originCol = (this.currentLocation.getCol() - cols + 1);
/*     */     }
/* 475 */     else if (viewPort != null)
/*     */     {
/* 477 */       int dx = 0;
/* 478 */       int dy = 0;
/* 479 */       Point p = pointForLocation(this.currentLocation);
/* 480 */       Rectangle locRect = new Rectangle(p.x - this.cellSize / 2, p.y - this.cellSize / 2, this.cellSize + 1, this.cellSize + 1);
/*     */ 
/* 483 */       Rectangle viewRect = viewPort.getViewRect();
/* 484 */       if (!viewRect.contains(locRect))
/*     */       {
/* 486 */         while (locRect.x < viewRect.x + dx)
/* 487 */           dx -= this.cellSize + 1;
/* 488 */         while (locRect.y < viewRect.y + dy)
/* 489 */           dy -= this.cellSize + 1;
/* 490 */         while (locRect.getMaxX() > viewRect.getMaxX() + dx)
/* 491 */           dx += this.cellSize + 1;
/* 492 */         while (locRect.getMaxY() > viewRect.getMaxY() + dy) {
/* 493 */           dy += this.cellSize + 1;
/*     */         }
/* 495 */         Point pt = viewPort.getViewPosition();
/* 496 */         pt.x += dx;
/* 497 */         pt.y += dy;
/* 498 */         viewPort.setViewPosition(pt);
/*     */       }
/*     */     }
/* 501 */     repaint();
/* 502 */     showTip(getToolTipText(this.currentLocation), pointForLocation(this.currentLocation));
/*     */   }
/*     */ 
/*     */   public void showTip(String tipText, Point pt)
/*     */   {
/* 513 */     if (getRootPane() == null) {
/* 514 */       return;
/*     */     }
/* 516 */     if (this.glassPane == null)
/*     */     {
/* 518 */       getRootPane().setGlassPane(this.glassPane = new JPanel());
/* 519 */       this.glassPane.setOpaque(false);
/* 520 */       this.glassPane.setLayout(null);
/* 521 */       this.glassPane.add(this.tip = new JToolTip());
/* 522 */       this.tipTimer = new Timer(1000, new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent evt)
/*     */         {
/* 526 */           GridPanel.this.glassPane.setVisible(false);
/*     */         }
/*     */       });
/* 529 */       this.tipTimer.setRepeats(false);
/*     */     }
/* 531 */     if (tipText == null) {
/* 532 */       return;
/*     */     }
/*     */ 
/* 535 */     this.tip.setTipText(tipText);
/*     */ 
/* 538 */     this.tip.setLocation(SwingUtilities.convertPoint(this, pt, this.glassPane));
/* 539 */     this.tip.setSize(this.tip.getPreferredSize());
/*     */ 
/* 542 */     this.glassPane.setVisible(true);
/* 543 */     this.glassPane.repaint();
/*     */ 
/* 546 */     this.tipTimer.restart();
/*     */   }
/*     */ 
/*     */   private void recalculateCellSize(int minSize)
/*     */   {
/* 557 */     if ((this.numRows == 0) || (this.numCols == 0))
/*     */     {
/* 559 */       this.cellSize = 0;
/*     */     }
/*     */     else
/*     */     {
/* 563 */       JViewport vp = getEnclosingViewport();
/* 564 */       Dimension viewableSize = vp != null ? vp.getSize() : getSize();
/* 565 */       int desiredCellSize = Math.min((viewableSize.height - extraHeight()) / this.numRows, (viewableSize.width - extraWidth()) / this.numCols) - 1;
/*     */ 
/* 570 */       this.cellSize = 48;
/* 571 */       if (this.cellSize <= desiredCellSize) {
/* 572 */         while (2 * this.cellSize <= desiredCellSize)
/* 573 */           this.cellSize *= 2;
/*     */       }
/* 575 */       while (this.cellSize / 2 >= Math.max(desiredCellSize, 12))
/* 576 */         this.cellSize /= 2;
/*     */     }
/* 578 */     revalidate();
/*     */   }
/*     */ 
/*     */   private JViewport getEnclosingViewport()
/*     */   {
/* 584 */     Component parent = getParent();
/* 585 */     return (parent instanceof JViewport) ? (JViewport)parent : null;
/*     */   }
/*     */ 
/*     */   public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
/*     */   {
/* 594 */     return this.cellSize + 1;
/*     */   }
/*     */ 
/*     */   public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
/*     */   {
/* 600 */     if (orientation == 1) {
/* 601 */       return (int)(visibleRect.height * 0.9D);
/*     */     }
/* 603 */     return (int)(visibleRect.width * 0.9D);
/*     */   }
/*     */ 
/*     */   public boolean getScrollableTracksViewportWidth()
/*     */   {
/* 608 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean getScrollableTracksViewportHeight()
/*     */   {
/* 613 */     return false;
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredScrollableViewportSize()
/*     */   {
/* 618 */     return new Dimension(491 + extraWidth(), 491 + extraHeight());
/*     */   }
/*     */ 
/*     */   public void panBy(int hDelta, int vDelta)
/*     */   {
/* 628 */     this.originCol += hDelta / (this.cellSize + 1);
/* 629 */     this.originRow += vDelta / (this.cellSize + 1);
/* 630 */     repaint();
/*     */   }
/*     */ 
/*     */   public boolean isPannableUnbounded()
/*     */   {
/* 635 */     return (this.grid != null) && ((this.grid.getNumRows() == -1) || (this.grid.getNumCols() == -1));
/*     */   }
/*     */ 
/*     */   public void showPanTip()
/*     */   {
/* 645 */     String tipText = null;
/* 646 */     Point upperLeft = new Point(0, 0);
/* 647 */     JViewport vp = getEnclosingViewport();
/* 648 */     if ((!isPannableUnbounded()) && (vp != null))
/* 649 */       upperLeft = vp.getViewPosition();
/* 650 */     Location loc = locationForPoint(upperLeft);
/* 651 */     if (loc != null) {
/* 652 */       tipText = getToolTipText(loc);
/*     */     }
/* 654 */     showTip(tipText, getLocation());
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.GridPanel
 * JD-Core Version:    0.6.0
 */