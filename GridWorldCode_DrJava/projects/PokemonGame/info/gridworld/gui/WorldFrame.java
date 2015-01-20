/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.world.World;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.KeyEventDispatcher;
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.net.URL;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.event.HyperlinkEvent;
/*     */ import javax.swing.event.HyperlinkEvent.EventType;
/*     */ import javax.swing.event.HyperlinkListener;
/*     */ 
/*     */ public class WorldFrame<T> extends JFrame
/*     */ {
/*     */   private GUIController<T> control;
/*     */   private GridPanel display;
/*     */   private JTextArea messageArea;
/*     */   private ArrayList<JMenuItem> menuItemsDisabledDuringRun;
/*     */   private World<T> world;
/*     */   private ResourceBundle resources;
/*     */   private DisplayMap displayMap;
/*     */   private Set<Class> gridClasses;
/*     */   private JMenu newGridMenu;
/*  88 */   private static int count = 0;
/*     */ 
/*     */   public WorldFrame(World<T> world)
/*     */   {
/*  96 */     this.world = world;
/*  97 */     count += 1;
/*  98 */     this.resources = ResourceBundle.getBundle(getClass().getName() + "Resources");
/*     */     try
/*     */     {
/* 103 */       System.setProperty("sun.awt.exception.handler", GUIExceptionHandler.class.getName());
/*     */     }
/*     */     catch (SecurityException ex)
/*     */     {
/*     */     }
/*     */ 
/* 111 */     addWindowListener(new WindowAdapter()
/*     */     {
/*     */       public void windowClosing(WindowEvent event)
/*     */       {
/* 115 */         WorldFrame.access$010();
/* 116 */         if (WorldFrame.count == 0)
/* 117 */           System.exit(0);
/*     */       }
/*     */     });
/* 121 */     this.displayMap = new DisplayMap();
/* 122 */     String title = System.getProperty("info.gridworld.gui.frametitle");
/* 123 */     if (title == null) title = this.resources.getString("frame.title");
/* 124 */     setTitle(title);
/* 125 */     setLocation(25, 15);
/*     */ 
/* 127 */     URL appIconUrl = getClass().getResource("GridWorld.gif");
/* 128 */     ImageIcon appIcon = new ImageIcon(appIconUrl);
/* 129 */     setIconImage(appIcon.getImage());
/*     */ 
/* 131 */     makeMenus();
/*     */ 
/* 133 */     JPanel content = new JPanel();
/* 134 */     content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
/* 135 */     content.setLayout(new BorderLayout());
/* 136 */     setContentPane(content);
/*     */ 
/* 138 */     this.display = new GridPanel(this.displayMap, this.resources);
/*     */ 
/* 140 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher()
/*     */     {
/*     */       public boolean dispatchKeyEvent(KeyEvent event)
/*     */       {
/* 145 */         if (WorldFrame.this.getFocusOwner() == null) return false;
/* 146 */         String text = KeyStroke.getKeyStrokeForEvent(event).toString();
/* 147 */         String PRESSED = "pressed ";
/* 148 */         int n = text.indexOf("pressed ");
/* 149 */         if (n < 0) return false;
/*     */ 
/* 151 */         if ((event.getKeyChar() == 65535) && (!event.isActionKey()))
/* 152 */           return false;
/* 153 */         text = text.substring(0, n) + text.substring(n + "pressed ".length());
/* 154 */         boolean consumed = WorldFrame.this.getWorld().keyPressed(text, WorldFrame.this.display.getCurrentLocation());
/* 155 */         if (consumed) WorldFrame.this.repaint();
/* 156 */         return consumed;
/*     */       }
/*     */     });
/* 160 */     JScrollPane scrollPane = new JScrollPane();
/* 161 */     scrollPane.setViewport(new PseudoInfiniteViewport(scrollPane));
/* 162 */     scrollPane.setViewportView(this.display);
/* 163 */     content.add(scrollPane, "Center");
/*     */ 
/* 165 */     this.gridClasses = new TreeSet(new Comparator()
/*     */     {
/*     */       public int compare(Class a, Class b)
/*     */       {
/* 169 */         return a.getName().compareTo(b.getName());
/*     */       }
/*     */     });
/* 172 */     for (String name : world.getGridClasses()) {
/*     */       try
/*     */       {
/* 175 */         this.gridClasses.add(Class.forName(name));
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 179 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 182 */     Grid gr = world.getGrid();
/* 183 */     this.gridClasses.add(gr.getClass());
/*     */ 
/* 185 */     makeNewGridMenu();
/*     */ 
/* 187 */     this.control = new GUIController(this, this.display, this.displayMap, this.resources);
/* 188 */     content.add(this.control.controlPanel(), "South");
/*     */ 
/* 190 */     this.messageArea = new JTextArea(2, 35);
/* 191 */     this.messageArea.setEditable(false);
/* 192 */     this.messageArea.setFocusable(false);
/* 193 */     this.messageArea.setBackground(new Color(16448210));
/* 194 */     content.add(new JScrollPane(this.messageArea), "North");
/*     */ 
/* 196 */     pack();
/* 197 */     repaint();
/* 198 */     this.display.setGrid(gr);
/*     */   }
/*     */ 
/*     */   public void repaint()
/*     */   {
/* 203 */     String message = getWorld().getMessage();
/* 204 */     if (message == null)
/* 205 */       message = this.resources.getString("message.default");
/* 206 */     this.messageArea.setText(message);
/* 207 */     this.messageArea.repaint();
/* 208 */     this.display.repaint();
/* 209 */     super.repaint();
/*     */   }
/*     */ 
/*     */   public World<T> getWorld()
/*     */   {
/* 218 */     return this.world;
/*     */   }
/*     */ 
/*     */   public void setGrid(Grid<T> newGrid)
/*     */   {
/* 228 */     Grid oldGrid = this.world.getGrid();
/* 229 */     Map occupants = new HashMap();
/* 230 */     for (Location loc : oldGrid.getOccupiedLocations()) {
/* 231 */       occupants.put(loc, this.world.remove(loc));
/*     */     }
/* 233 */     this.world.setGrid(newGrid);
/* 234 */     for (Location loc : occupants.keySet())
/*     */     {
/* 236 */       if (newGrid.isValid(loc)) {
/* 237 */         this.world.add(loc, occupants.get(loc));
/*     */       }
/*     */     }
/* 240 */     this.display.setGrid(newGrid);
/* 241 */     repaint();
/*     */   }
/*     */ 
/*     */   public void showError(Throwable t, String resource)
/*     */   {
/*     */     String text;
/*     */     try
/*     */     {
/* 255 */       text = this.resources.getString(resource + ".text");
/*     */     }
/*     */     catch (MissingResourceException e)
/*     */     {
/* 259 */       text = this.resources.getString("error.text");
/*     */     }
/*     */     String title;
/*     */     try
/*     */     {
/* 265 */       title = this.resources.getString(resource + ".title");
/*     */     }
/*     */     catch (MissingResourceException e)
/*     */     {
/* 269 */       title = this.resources.getString("error.title");
/*     */     }
/*     */ 
/* 272 */     String reason = this.resources.getString("error.reason");
/* 273 */     String message = text + "\n" + MessageFormat.format(reason, new Object[] { t });
/*     */ 
/* 277 */     JOptionPane.showMessageDialog(this, message, title, 0);
/*     */   }
/*     */ 
/*     */   private JMenu makeMenu(String resource)
/*     */   {
/* 285 */     JMenu menu = new JMenu();
/* 286 */     configureAbstractButton(menu, resource);
/* 287 */     return menu;
/*     */   }
/*     */ 
/*     */   private JMenuItem makeMenuItem(String resource, ActionListener listener)
/*     */   {
/* 292 */     JMenuItem item = new JMenuItem();
/* 293 */     configureMenuItem(item, resource, listener);
/* 294 */     return item;
/*     */   }
/*     */ 
/*     */   private void configureMenuItem(JMenuItem item, String resource, ActionListener listener)
/*     */   {
/* 300 */     configureAbstractButton(item, resource);
/* 301 */     item.addActionListener(listener);
/*     */     try
/*     */     {
/* 304 */       String accel = this.resources.getString(resource + ".accel");
/* 305 */       String metaPrefix = "@";
/* 306 */       if (accel.startsWith(metaPrefix))
/*     */       {
/* 308 */         int menuMask = getToolkit().getMenuShortcutKeyMask();
/* 309 */         KeyStroke key = KeyStroke.getKeyStroke(KeyStroke.getKeyStroke(accel.substring(metaPrefix.length())).getKeyCode(), menuMask);
/*     */ 
/* 312 */         item.setAccelerator(key);
/*     */       }
/*     */       else
/*     */       {
/* 316 */         item.setAccelerator(KeyStroke.getKeyStroke(accel));
/*     */       }
/*     */     }
/*     */     catch (MissingResourceException ex)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void configureAbstractButton(AbstractButton button, String resource)
/*     */   {
/* 327 */     String title = this.resources.getString(resource);
/* 328 */     int i = title.indexOf('&');
/* 329 */     int mnemonic = 0;
/* 330 */     if (i >= 0)
/*     */     {
/* 332 */       mnemonic = title.charAt(i + 1);
/* 333 */       title = title.substring(0, i) + title.substring(i + 1);
/* 334 */       button.setText(title);
/* 335 */       button.setMnemonic(Character.toUpperCase(mnemonic));
/* 336 */       button.setDisplayedMnemonicIndex(i);
/*     */     }
/*     */     else {
/* 339 */       button.setText(title);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void makeMenus() {
/* 344 */     JMenuBar mbar = new JMenuBar();
/*     */ 
/* 347 */     this.menuItemsDisabledDuringRun = new ArrayList();
/*     */     JMenu menu;
/* 349 */     mbar.add(menu = makeMenu("menu.file"));
/*     */ 
/* 351 */     this.newGridMenu = makeMenu("menu.file.new");
/* 352 */     menu.add(this.newGridMenu);
/* 353 */     this.menuItemsDisabledDuringRun.add(this.newGridMenu);
/*     */ 
/* 355 */     menu.add(makeMenuItem("menu.file.quit", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 359 */         System.exit(0);
/*     */       }
/*     */     }));
/* 363 */     mbar.add(menu = makeMenu("menu.view"));
/*     */ 
/* 365 */     menu.add(makeMenuItem("menu.view.up", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 369 */         WorldFrame.this.display.moveLocation(-1, 0);
/*     */       }
/*     */     }));
/* 372 */     menu.add(makeMenuItem("menu.view.down", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 376 */         WorldFrame.this.display.moveLocation(1, 0);
/*     */       }
/*     */     }));
/* 379 */     menu.add(makeMenuItem("menu.view.left", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 383 */         WorldFrame.this.display.moveLocation(0, -1);
/*     */       }
/*     */     }));
/* 386 */     menu.add(makeMenuItem("menu.view.right", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 390 */         WorldFrame.this.display.moveLocation(0, 1);
/*     */       }
/*     */     }));
/*     */     JMenuItem viewEditMenu;
/* 395 */     menu.add(viewEditMenu = makeMenuItem("menu.view.edit", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 400 */         WorldFrame.this.control.editLocation();
/*     */       }
/*     */     }));
/* 403 */     this.menuItemsDisabledDuringRun.add(viewEditMenu);
/*     */     JMenuItem viewDeleteMenu;
/* 406 */     menu.add(viewDeleteMenu = makeMenuItem("menu.view.delete", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 411 */         WorldFrame.this.control.deleteLocation();
/*     */       }
/*     */     }));
/* 414 */     this.menuItemsDisabledDuringRun.add(viewDeleteMenu);
/*     */ 
/* 416 */     menu.add(makeMenuItem("menu.view.zoomin", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 420 */         WorldFrame.this.display.zoomIn();
/*     */       }
/*     */     }));
/* 424 */     menu.add(makeMenuItem("menu.view.zoomout", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 428 */         WorldFrame.this.display.zoomOut();
/*     */       }
/*     */     }));
/* 432 */     mbar.add(menu = makeMenu("menu.help"));
/* 433 */     menu.add(makeMenuItem("menu.help.about", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 437 */         WorldFrame.this.showAboutPanel();
/*     */       }
/*     */     }));
/* 440 */     menu.add(makeMenuItem("menu.help.help", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 444 */         WorldFrame.this.showHelp();
/*     */       }
/*     */     }));
/* 447 */     menu.add(makeMenuItem("menu.help.license", new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 451 */         WorldFrame.this.showLicense();
/*     */       }
/*     */     }));
/* 455 */     setRunMenuItemsEnabled(true);
/* 456 */     setJMenuBar(mbar);
/*     */   }
/*     */ 
/*     */   private void makeNewGridMenu()
/*     */   {
/* 461 */     this.newGridMenu.removeAll();
/* 462 */     MenuMaker maker = new MenuMaker(this, this.resources, this.displayMap);
/* 463 */     maker.addConstructors(this.newGridMenu, this.gridClasses);
/*     */   }
/*     */ 
/*     */   public void setRunMenuItemsEnabled(boolean enable)
/*     */   {
/* 473 */     for (JMenuItem item : this.menuItemsDisabledDuringRun)
/* 474 */       item.setEnabled(enable);
/*     */   }
/*     */ 
/*     */   private void showAboutPanel()
/*     */   {
/* 482 */     String html = MessageFormat.format(this.resources.getString("dialog.about.text"), new Object[] { this.resources.getString("version.id") });
/*     */ 
/* 485 */     String[] props = { "java.version", "java.vendor", "java.home", "os.name", "os.arch", "os.version", "user.name", "user.home", "user.dir" };
/* 486 */     html = html + "<table border='1'>";
/* 487 */     for (String prop : props)
/*     */     {
/*     */       try
/*     */       {
/* 491 */         String value = System.getProperty(prop);
/* 492 */         html = html + "<tr><td>" + prop + "</td><td>" + value + "</td></tr>";
/*     */       }
/*     */       catch (SecurityException ex)
/*     */       {
/*     */       }
/*     */     }
/*     */ 
/* 499 */     html = html + "</table>";
/* 500 */     html = "<html>" + html + "</html>";
/* 501 */     JOptionPane.showMessageDialog(this, new JLabel(html), this.resources.getString("dialog.about.title"), 1);
/*     */   }
/*     */ 
/*     */   private void showHelp()
/*     */   {
/* 512 */     JDialog dialog = new JDialog(this, this.resources.getString("dialog.help.title"));
/*     */ 
/* 514 */     JEditorPane helpText = new JEditorPane();
/*     */     try
/*     */     {
/* 517 */       URL url = getClass().getResource("GridWorldHelp.html");
/*     */ 
/* 519 */       helpText.setPage(url);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 523 */       helpText.setText(this.resources.getString("dialog.help.error"));
/*     */     }
/* 525 */     helpText.setEditable(false);
/* 526 */     helpText.addHyperlinkListener(new HyperlinkListener(helpText)
/*     */     {
/*     */       public void hyperlinkUpdate(HyperlinkEvent ev)
/*     */       {
/* 530 */         if (ev.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
/*     */           try
/*     */           {
/* 533 */             this.val$helpText.setPage(ev.getURL());
/*     */           }
/*     */           catch (Exception ex)
/*     */           {
/*     */           }
/*     */       }
/*     */     });
/* 540 */     JScrollPane sp = new JScrollPane(helpText);
/* 541 */     sp.setPreferredSize(new Dimension(650, 500));
/* 542 */     dialog.getContentPane().add(sp);
/* 543 */     dialog.setLocation(getX() + getWidth() - 200, getY() + 50);
/* 544 */     dialog.pack();
/* 545 */     dialog.setVisible(true);
/*     */   }
/*     */ 
/*     */   private void showLicense()
/*     */   {
/* 553 */     JDialog dialog = new JDialog(this, this.resources.getString("dialog.license.title"));
/*     */ 
/* 555 */     JEditorPane text = new JEditorPane();
/*     */     try
/*     */     {
/* 558 */       URL url = getClass().getResource("GNULicense.txt");
/*     */ 
/* 560 */       text.setPage(url);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 564 */       text.setText(this.resources.getString("dialog.license.error"));
/*     */     }
/* 566 */     text.setEditable(false);
/* 567 */     JScrollPane sp = new JScrollPane(text);
/* 568 */     sp.setPreferredSize(new Dimension(650, 500));
/* 569 */     dialog.getContentPane().add(sp);
/* 570 */     dialog.setLocation(getX() + getWidth() - 200, getY() + 50);
/* 571 */     dialog.pack();
/* 572 */     dialog.setVisible(true);
/*     */   }
/*     */ 
/*     */   public class GUIExceptionHandler
/*     */   {
/*     */     public GUIExceptionHandler()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void handle(Throwable e)
/*     */     {
/* 584 */       e.printStackTrace();
/*     */ 
/* 586 */       JTextArea area = new JTextArea(10, 40);
/* 587 */       StringWriter writer = new StringWriter();
/* 588 */       e.printStackTrace(new PrintWriter(writer));
/* 589 */       area.setText(writer.toString());
/* 590 */       area.setCaretPosition(0);
/* 591 */       String copyOption = WorldFrame.this.resources.getString("dialog.error.copy");
/* 592 */       JOptionPane pane = new JOptionPane(new JScrollPane(area), 0, 0, null, new String[] { copyOption, WorldFrame.access$600(WorldFrame.this).getString("cancel") });
/*     */ 
/* 596 */       pane.createDialog(WorldFrame.this, e.toString()).setVisible(true);
/* 597 */       if (copyOption.equals(pane.getValue()))
/*     */       {
/* 599 */         area.setSelectionStart(0);
/* 600 */         area.setSelectionEnd(area.getText().length());
/* 601 */         area.copy();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.WorldFrame
 * JD-Core Version:    0.6.0
 */