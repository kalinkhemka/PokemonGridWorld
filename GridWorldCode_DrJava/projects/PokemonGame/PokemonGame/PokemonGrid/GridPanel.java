/*     */ package PokemonGrid;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.gui.Display;
/*     */ import info.gridworld.gui.DisplayMap;
/*     */ import info.gridworld.gui.PseudoInfiniteViewport;
/*     */ import info.gridworld.gui.PseudoInfiniteViewport.Pannable;
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
/*  76 */   private Color backgroundColor = Color.WHITE;
/*     */   private ResourceBundle resources;
/*     */   private DisplayMap displayMap;
/*     */   private Location currentLocation;
/*     */   private Timer tipTimer;
/*     */   private JToolTip tip;
/*     */   private JPanel glassPane;
/*     */ 
/*     */   public GridPanel(DisplayMap map, ResourceBundle res)
/*     */   {
/*  90 */     this.displayMap = map;
/*  91 */     this.resources = res;
/*  92 */     setToolTipsEnabled(true);
/*     */   }
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/* 102 */     Graphics2D g2 = (Graphics2D)g;
/*     */ 
/* 104 */     super.paintComponent(g2);
/* 105 */     if (this.grid == null) {
/* 106 */       return;
/*     */     }
/* 108 */     Insets insets = getInsets();
/* 109 */     g2.setColor(this.backgroundColor);
/* 110 */     g2.fillRect(insets.left, insets.top, this.numCols * (this.cellSize + 1) + 1, this.numRows * (this.cellSize + 1) + 1);
/*     */ 
/* 113 */     drawWatermark(g2);
/* 114 */     drawGridlines(g2);
/* 115 */     drawOccupants(g2);
/* 116 */     drawCurrentLocation(g2);
/*     */   }
/*     */ 
/*     */   private void drawOccupant(Graphics2D g2, int xleft, int ytop, Object obj)
/*     */   {
/* 133 */     Rectangle cellToDraw = new Rectangle(xleft, ytop, this.cellSize + 1, this.cellSize + 1);
/*     */ 
/* 137 */     if (cellToDraw.intersects(g2.getClip().getBounds()))
/*     */     {
/* 139 */       Graphics2D g2copy = (Graphics2D)g2.create();
/* 140 */       g2copy.clip(cellToDraw);
/*     */ 
/* 142 */       Display displayObj = this.displayMap.findDisplayFor(obj.getClass());
/* 143 */       displayObj.draw(obj, this, g2copy, cellToDraw);
/* 144 */       g2copy.dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawGridlines(Graphics2D g2)
/*     */   {
/* 155 */     Rectangle curClip = g2.getClip().getBounds();
/* 156 */     int top = getInsets().top; int left = getInsets().left;
/*     */ 
/* 158 */     int miny = Math.max(0, (curClip.y - top) / (this.cellSize + 1)) * (this.cellSize + 1) + top;
/* 159 */     int minx = Math.max(0, (curClip.x - left) / (this.cellSize + 1)) * (this.cellSize + 1) + left;
/* 160 */     int maxy = Math.min(this.numRows, (curClip.y + curClip.height - top + this.cellSize) / (this.cellSize + 1)) * (this.cellSize + 1) + top;
/*     */ 
/* 163 */     int maxx = Math.min(this.numCols, (curClip.x + curClip.width - left + this.cellSize) / (this.cellSize + 1)) * (this.cellSize + 1) + left;
/*     */ 
/* 167 */     g2.setColor(null);
/* 168 */     for (int y = miny; y <= maxy; y += this.cellSize + 1) {
/* 169 */       for (int x = minx; x <= maxx; x += this.cellSize + 1)
/*     */       {
/* 171 */         Location loc = locationForPoint(new Point(x + this.cellSize / 2, y + this.cellSize / 2));
/*     */ 
/* 173 */         if ((loc != null) && (!this.grid.isValid(loc)))
/* 174 */           g2.fillRect(x + 1, y + 1, this.cellSize, this.cellSize);
/*     */       }
/*     */     }
/* 177 */     g2.setColor(null);
/* 178 */     for (int y = miny; y <= maxy; y += this.cellSize + 1)
/*     */     {
/* 180 */       g2.drawLine(minx, y, maxx, y);
/*     */     }
/* 182 */     for (int x = minx; x <= maxx; x += this.cellSize + 1)
/*     */     {
/* 184 */       g2.drawLine(x, miny, x, maxy);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawOccupants(Graphics2D g2)
/*     */   {
/* 193 */     ArrayList occupantLocs = this.grid.getOccupiedLocations();
/* 194 */     for (int index = 0; index < occupantLocs.size(); index++)
/*     */     {
/* 196 */       Location loc = (Location)occupantLocs.get(index);
/*     */ 
/* 198 */       int xleft = colToXCoord(loc.getCol());
/* 199 */       int ytop = rowToYCoord(loc.getRow());
/* 200 */       drawOccupant(g2, xleft, ytop, this.grid.get(loc));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawCurrentLocation(Graphics2D g2)
/*     */   {
/* 210 */     if ("hide".equals(System.getProperty("info.gridworld.gui.selection")))
/* 211 */       return;
/* 212 */     if (this.currentLocation != null)
/*     */     {
/* 214 */       Point p = pointForLocation(this.currentLocation);
/* 215 */       g2.drawRect(p.x - this.cellSize / 2 - 2, p.y - this.cellSize / 2 - 2, this.cellSize + 3, this.cellSize + 3);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void drawWatermark(Graphics2D g2)
/*     */   {
/* 226 */     if ("hide".equals(System.getProperty("info.gridworld.gui.watermark")))
/* 227 */       return;
/* 228 */     g2 = (Graphics2D)g2.create();
/* 229 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/* 231 */     Rectangle rect = getBounds();
/* 232 */     g2.setPaint(new Color(227, 211, 211));
/* 233 */     int WATERMARK_FONT_SIZE = 100;
/* 234 */     String s = this.resources.getString("version.id");
/* 235 */     if ("1.0".compareTo(s) <= 0) return;
/* 236 */     g2.setFont(new Font("SansSerif", 1, 100));
/* 237 */     FontRenderContext frc = g2.getFontRenderContext();
/* 238 */     Rectangle2D bounds = g2.getFont().getStringBounds(s, frc);
/* 239 */     float centerX = rect.x + rect.width / 2;
/* 240 */     float centerY = rect.y + rect.height / 2;
/* 241 */     float leftX = centerX - (float)bounds.getWidth() / 2.0F;
/* 242 */     LineMetrics lm = g2.getFont().getLineMetrics(s, frc);
/* 243 */     float baselineY = centerY - lm.getHeight() / 2.0F + lm.getAscent();
/* 244 */     g2.drawString(s, leftX, baselineY);
/*     */   }
/*     */ 
/*     */   public void setToolTipsEnabled(boolean flag)
/*     */   {
/* 254 */     if ("hide".equals(System.getProperty("info.gridworld.gui.tooltips")))
/* 255 */       flag = false;
/* 256 */     if (flag)
/* 257 */       ToolTipManager.sharedInstance().registerComponent(this);
/*     */     else
/* 259 */       ToolTipManager.sharedInstance().unregisterComponent(this);
/* 260 */     this.toolTipsEnabled = flag;
/*     */   }
/*     */ 
/*     */   public void setGrid(Grid<?> gr)
/*     */   {
/* 271 */     this.currentLocation = new Location(0, 0);
/* 272 */     JViewport vp = getEnclosingViewport();
/*     */ 
/* 274 */     if (vp != null) {
/* 275 */       vp.setViewPosition(new Point(0, 0));
/*     */     }
/* 277 */     this.grid = gr;
/* 278 */     this.originRow = (this.originCol = 0);
/*     */ 
/* 280 */     if ((this.grid.getNumRows() == -1) && (this.grid.getNumCols() == -1))
/*     */     {
/* 282 */       this.numRows = (this.numCols = 2000);
/*     */     }
/*     */     else
/*     */     {
/* 287 */       this.numRows = this.grid.getNumRows();
/* 288 */       this.numCols = this.grid.getNumCols();
/*     */     }
/* 290 */     recalculateCellSize(12);
/*     */   }
/*     */ 
/*     */   private int extraWidth()
/*     */   {
/* 296 */     return getInsets().left + getInsets().right;
/*     */   }
/*     */ 
/*     */   private int extraHeight()
/*     */   {
/* 301 */     return getInsets().top + getInsets().left;
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize()
/*     */   {
/* 311 */     return new Dimension(this.numCols * (this.cellSize + 1) + 1 + extraWidth(), this.numRows * (this.cellSize + 1) + 1 + extraHeight());
/*     */   }
/*     */ 
/*     */   public Dimension getMinimumSize()
/*     */   {
/* 322 */     return new Dimension(this.numCols * 13 + 1 + extraWidth(), this.numRows * 13 + 1 + extraHeight());
/*     */   }
/*     */ 
/*     */   public void zoomIn()
/*     */   {
/* 331 */     this.cellSize *= 2;
/* 332 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void zoomOut()
/*     */   {
/* 340 */     this.cellSize = Math.max(this.cellSize / 2, 12);
/* 341 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void recenter(Location loc)
/*     */   {
/* 350 */     this.originRow = loc.getRow();
/* 351 */     this.originCol = loc.getCol();
/* 352 */     repaint();
/* 353 */     JViewport vp = getEnclosingViewport();
/* 354 */     if (vp != null)
/*     */     {
/* 356 */       if ((!isPannableUnbounded()) || (!(vp instanceof PseudoInfiniteViewport)))
/*     */       {
/* 358 */         vp.setViewPosition(pointForLocation(loc));
/*     */       }
/* 360 */       else showPanTip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Location locationForPoint(Point p)
/*     */   {
/* 374 */     return new Location(yCoordToRow(p.y), xCoordToCol(p.x));
/*     */   }
/*     */ 
/*     */   public Point pointForLocation(Location loc)
/*     */   {
/* 379 */     return new Point(colToXCoord(loc.getCol()) + this.cellSize / 2, rowToYCoord(loc.getRow()) + this.cellSize / 2);
/*     */   }
/*     */ 
/*     */   private int xCoordToCol(int xCoord)
/*     */   {
/* 386 */     return (xCoord - 1 - getInsets().left) / (this.cellSize + 1) + this.originCol;
/*     */   }
/*     */ 
/*     */   private int yCoordToRow(int yCoord)
/*     */   {
/* 391 */     return (yCoord - 1 - getInsets().top) / (this.cellSize + 1) + this.originRow;
/*     */   }
/*     */ 
/*     */   private int colToXCoord(int col)
/*     */   {
/* 396 */     return (col - this.originCol) * (this.cellSize + 1) + 1 + getInsets().left;
/*     */   }
/*     */ 
/*     */   private int rowToYCoord(int row)
/*     */   {
/* 401 */     return (row - this.originRow) * (this.cellSize + 1) + 1 + getInsets().top;
/*     */   }
/*     */ 
/*     */   public String getToolTipText(MouseEvent evt)
/*     */   {
/* 416 */     Location loc = locationForPoint(evt.getPoint());
/* 417 */     return getToolTipText(loc);
/*     */   }
/*     */ 
/*     */   private String getToolTipText(Location loc)
/*     */   {
/* 422 */     if ((!this.toolTipsEnabled) || (loc == null) || (!this.grid.isValid(loc)))
/* 423 */       return null;
/* 424 */     Object f = this.grid.get(loc);
/* 425 */     if (f != null) {
/* 426 */       return MessageFormat.format(this.resources.getString("cell.tooltip.nonempty"), new Object[] { loc, f });
/*     */     }
/*     */ 
/* 430 */     return MessageFormat.format(this.resources.getString("cell.tooltip.empty"), new Object[] { loc, f });
/*     */   }
/*     */ 
/*     */   public void setCurrentLocation(Location loc)
/*     */   {
/* 441 */     this.currentLocation = loc;
/*     */   }
/*     */ 
/*     */   public Location getCurrentLocation()
/*     */   {
/* 450 */     return this.currentLocation;
/*     */   }
/*     */ 
/*     */   public void moveLocation(int dr, int dc)
/*     */   {
/* 460 */     Location newLocation = new Location(this.currentLocation.getRow() + dr, this.currentLocation.getCol() + dc);
/*     */ 
/* 462 */     if (!this.grid.isValid(newLocation)) {
/* 463 */       return;
/*     */     }
/* 465 */     this.currentLocation = newLocation;
/*     */ 
/* 467 */     JViewport viewPort = getEnclosingViewport();
/* 468 */     if (isPannableUnbounded())
/*     */     {
/* 470 */       if (this.originRow > this.currentLocation.getRow())
/* 471 */         this.originRow = this.currentLocation.getRow();
/* 472 */       if (this.originCol > this.currentLocation.getCol())
/* 473 */         this.originCol = this.currentLocation.getCol();
/* 474 */       Dimension dim = viewPort.getSize();
/* 475 */       int rows = dim.height / (this.cellSize + 1);
/* 476 */       int cols = dim.width / (this.cellSize + 1);
/* 477 */       if (this.originRow + rows - 1 < this.currentLocation.getRow())
/* 478 */         this.originRow = (this.currentLocation.getRow() - rows + 1);
/* 479 */       if (this.originCol + rows - 1 < this.currentLocation.getCol())
/* 480 */         this.originCol = (this.currentLocation.getCol() - cols + 1);
/*     */     }
/* 482 */     else if (viewPort != null)
/*     */     {
/* 484 */       int dx = 0;
/* 485 */       int dy = 0;
/* 486 */       Point p = pointForLocation(this.currentLocation);
/* 487 */       Rectangle locRect = new Rectangle(p.x - this.cellSize / 2, p.y - this.cellSize / 2, this.cellSize + 1, this.cellSize + 1);
/*     */ 
/* 490 */       Rectangle viewRect = viewPort.getViewRect();
/* 491 */       if (!viewRect.contains(locRect))
/*     */       {
/* 493 */         while (locRect.x < viewRect.x + dx)
/* 494 */           dx -= this.cellSize + 1;
/* 495 */         while (locRect.y < viewRect.y + dy)
/* 496 */           dy -= this.cellSize + 1;
/* 497 */         while (locRect.getMaxX() > viewRect.getMaxX() + dx)
/* 498 */           dx += this.cellSize + 1;
/* 499 */         while (locRect.getMaxY() > viewRect.getMaxY() + dy) {
/* 500 */           dy += this.cellSize + 1;
/*     */         }
/* 502 */         Point pt = viewPort.getViewPosition();
/* 503 */         pt.x += dx;
/* 504 */         pt.y += dy;
/* 505 */         viewPort.setViewPosition(pt);
/*     */       }
/*     */     }
/* 508 */     repaint();
/* 509 */     showTip(getToolTipText(this.currentLocation), pointForLocation(this.currentLocation));
/*     */   }
/*     */ 
/*     */   public void showTip(String tipText, Point pt)
/*     */   {
/* 520 */     if (getRootPane() == null) {
/* 521 */       return;
/*     */     }
/* 523 */     if (this.glassPane == null)
/*     */     {
/* 525 */       getRootPane().setGlassPane(this.glassPane = new JPanel());
/* 526 */       this.glassPane.setOpaque(false);
/* 527 */       this.glassPane.setLayout(null);
/* 528 */       this.glassPane.add(this.tip = new JToolTip());
/* 529 */       this.tipTimer = new Timer(1000, new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent evt)
/*     */         {
/* 533 */           GridPanel.this.glassPane.setVisible(false);
/*     */         }
/*     */       });
/* 536 */       this.tipTimer.setRepeats(false);
/*     */     }
/* 538 */     if (tipText == null) {
/* 539 */       return;
/*     */     }
/*     */ 
/* 542 */     this.tip.setTipText(tipText);
/*     */ 
/* 545 */     this.tip.setLocation(SwingUtilities.convertPoint(this, pt, this.glassPane));
/* 546 */     this.tip.setSize(this.tip.getPreferredSize());
/*     */ 
/* 549 */     this.glassPane.setVisible(true);
/* 550 */     this.glassPane.repaint();
/*     */ 
/* 553 */     this.tipTimer.restart();
/*     */   }
/*     */ 
/*     */   private void recalculateCellSize(int minSize)
/*     */   {
/* 564 */     if ((this.numRows == 0) || (this.numCols == 0))
/*     */     {
/* 566 */       this.cellSize = 0;
/*     */     }
/*     */     else
/*     */     {
/* 570 */       JViewport vp = getEnclosingViewport();
/* 571 */       Dimension viewableSize = vp != null ? vp.getSize() : getSize();
/* 572 */       int desiredCellSize = Math.min((viewableSize.height - extraHeight()) / this.numRows, (viewableSize.width - extraWidth()) / this.numCols) - 1;
/*     */ 
/* 577 */       this.cellSize = 48;
/* 578 */       if (this.cellSize <= desiredCellSize) {
/* 579 */         while (2 * this.cellSize <= desiredCellSize)
/* 580 */           this.cellSize *= 2;
/*     */       }
/* 582 */       while (this.cellSize / 2 >= Math.max(desiredCellSize, 12))
/* 583 */         this.cellSize /= 2;
/*     */     }
/* 585 */     revalidate();
/*     */   }
/*     */ 
/*     */   private JViewport getEnclosingViewport()
/*     */   {
/* 591 */     Component parent = getParent();
/* 592 */     return (parent instanceof JViewport) ? (JViewport)parent : null;
/*     */   }
/*     */ 
/*     */   public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
/*     */   {
/* 601 */     return this.cellSize + 1;
/*     */   }
/*     */ 
/*     */   public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
/*     */   {
/* 607 */     if (orientation == 1) {
/* 608 */       return (int)(visibleRect.height * 0.9D);
/*     */     }
/* 610 */     return (int)(visibleRect.width * 0.9D);
/*     */   }
/*     */ 
/*     */   public boolean getScrollableTracksViewportWidth()
/*     */   {
/* 615 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean getScrollableTracksViewportHeight()
/*     */   {
/* 620 */     return false;
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredScrollableViewportSize()
/*     */   {
/* 625 */     return new Dimension(491 + extraWidth(), 491 + extraHeight());
/*     */   }
/*     */ 
/*     */   public void panBy(int hDelta, int vDelta)
/*     */   {
/* 635 */     this.originCol += hDelta / (this.cellSize + 1);
/* 636 */     this.originRow += vDelta / (this.cellSize + 1);
/* 637 */     repaint();
/*     */   }
/*     */ 
/*     */   public boolean isPannableUnbounded()
/*     */   {
/* 642 */     return (this.grid != null) && ((this.grid.getNumRows() == -1) || (this.grid.getNumCols() == -1));
/*     */   }
/*     */ 
/*     */   public void showPanTip()
/*     */   {
/* 652 */     String tipText = null;
/* 653 */     Point upperLeft = new Point(0, 0);
/* 654 */     JViewport vp = getEnclosingViewport();
/* 655 */     if ((!isPannableUnbounded()) && (vp != null))
/* 656 */       upperLeft = vp.getViewPosition();
/* 657 */     Location loc = locationForPoint(upperLeft);
/* 658 */     if (loc != null) {
/* 659 */       tipText = getToolTipText(loc);
/*     */     }
/* 661 */     showTip(tipText, getLocation());
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     PokemonGrid.GridPanel
 * JD-Core Version:    0.6.0
 */