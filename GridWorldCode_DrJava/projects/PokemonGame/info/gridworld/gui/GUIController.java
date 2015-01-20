/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.world.World;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Comparator;
/*     */ import java.util.ResourceBundle;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.InputMap;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ public class GUIController<T>
/*     */ {
/*     */   public static final int INDEFINITE = 0;
/*     */   public static final int FIXED_STEPS = 1;
/*     */   public static final int PROMPT_STEPS = 2;
/*     */   private static final int MIN_DELAY_MSECS = 10;
/*     */   private static final int MAX_DELAY_MSECS = 1000;
/*     */   private static final int INITIAL_DELAY = 505;
/*     */   private Timer timer;
/*     */   private JButton stepButton;
/*     */   private JButton runButton;
/*     */   private JButton stopButton;
/*     */   private JComponent controlPanel;
/*     */   private GridPanel display;
/*     */   private WorldFrame<T> parentFrame;
/*     */   private int numStepsToRun;
/*     */   private int numStepsSoFar;
/*     */   private ResourceBundle resources;
/*     */   private DisplayMap displayMap;
/*     */   private boolean running;
/*     */   private Set<Class> occupantClasses;
/*     */ 
/*     */   public GUIController(WorldFrame<T> parent, GridPanel disp, DisplayMap displayMap, ResourceBundle res)
/*     */   {
/*  77 */     this.resources = res;
/*  78 */     this.display = disp;
/*  79 */     this.parentFrame = parent;
/*  80 */     this.displayMap = displayMap;
/*  81 */     makeControls();
/*     */ 
/*  83 */     this.occupantClasses = new TreeSet(new Comparator()
/*     */     {
/*     */       public int compare(Class a, Class b)
/*     */       {
/*  87 */         return a.getName().compareTo(b.getName());
/*     */       }
/*     */     });
/*  91 */     World world = this.parentFrame.getWorld();
/*  92 */     Grid gr = world.getGrid();
/*  93 */     for (Location loc : gr.getOccupiedLocations())
/*  94 */       addOccupant(gr.get(loc));
/*  95 */     for (String name : world.getOccupantClasses()) {
/*     */       try
/*     */       {
/*  98 */         this.occupantClasses.add(Class.forName(name));
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 102 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 105 */     this.timer = new Timer(505, new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent evt)
/*     */       {
/* 109 */         GUIController.this.step();
/*     */       }
/*     */     });
/* 113 */     this.display.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent evt)
/*     */       {
/* 117 */         Grid gr = GUIController.this.parentFrame.getWorld().getGrid();
/* 118 */         Location loc = GUIController.this.display.locationForPoint(evt.getPoint());
/* 119 */         if ((loc != null) && (gr.isValid(loc)) && (!GUIController.this.isRunning()))
/*     */         {
/* 121 */           GUIController.this.display.setCurrentLocation(loc);
/* 122 */           GUIController.this.locationClicked();
/*     */         }
/*     */       }
/*     */     });
/* 126 */     stop();
/*     */   }
/*     */ 
/*     */   public void step()
/*     */   {
/* 134 */     this.parentFrame.getWorld().step();
/* 135 */     this.parentFrame.repaint();
/* 136 */     if (++this.numStepsSoFar == this.numStepsToRun)
/* 137 */       stop();
/* 138 */     Grid gr = this.parentFrame.getWorld().getGrid();
/*     */ 
/* 140 */     for (Location loc : gr.getOccupiedLocations())
/* 141 */       addOccupant(gr.get(loc));
/*     */   }
/*     */ 
/*     */   private void addOccupant(T occupant)
/*     */   {
/* 146 */     Class cl = occupant.getClass();
/*     */     do
/*     */     {
/* 149 */       if ((cl.getModifiers() & 0x400) == 0)
/* 150 */         this.occupantClasses.add(cl);
/* 151 */       cl = cl.getSuperclass();
/*     */     }
/* 153 */     while (cl != Object.class);
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 164 */     this.display.setToolTipsEnabled(false);
/* 165 */     this.parentFrame.setRunMenuItemsEnabled(false);
/* 166 */     this.stopButton.setEnabled(true);
/* 167 */     this.stepButton.setEnabled(false);
/* 168 */     this.runButton.setEnabled(false);
/* 169 */     this.numStepsSoFar = 0;
/* 170 */     this.timer.start();
/* 171 */     this.running = true;
/*     */   }
/*     */ 
/*     */   public void stop()
/*     */   {
/* 179 */     this.display.setToolTipsEnabled(true);
/* 180 */     this.parentFrame.setRunMenuItemsEnabled(true);
/* 181 */     this.timer.stop();
/* 182 */     this.stopButton.setEnabled(false);
/* 183 */     this.runButton.setEnabled(true);
/* 184 */     this.stepButton.setEnabled(true);
/* 185 */     this.running = false;
/*     */   }
/*     */ 
/*     */   public boolean isRunning()
/*     */   {
/* 190 */     return this.running;
/*     */   }
/*     */ 
/*     */   private void makeControls()
/*     */   {
/* 199 */     this.controlPanel = new JPanel();
/* 200 */     this.stepButton = new JButton(this.resources.getString("button.gui.step"));
/* 201 */     this.runButton = new JButton(this.resources.getString("button.gui.run"));
/* 202 */     this.stopButton = new JButton(this.resources.getString("button.gui.stop"));
/*     */ 
/* 204 */     this.controlPanel.setLayout(new BoxLayout(this.controlPanel, 0));
/* 205 */     this.controlPanel.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 207 */     Dimension spacer = new Dimension(5, this.stepButton.getPreferredSize().height + 10);
/*     */ 
/* 209 */     this.controlPanel.add(Box.createRigidArea(spacer));
/*     */ 
/* 211 */     this.controlPanel.add(this.stepButton);
/* 212 */     this.controlPanel.add(Box.createRigidArea(spacer));
/* 213 */     this.controlPanel.add(this.runButton);
/* 214 */     this.controlPanel.add(Box.createRigidArea(spacer));
/* 215 */     this.controlPanel.add(this.stopButton);
/* 216 */     this.runButton.setEnabled(false);
/* 217 */     this.stepButton.setEnabled(false);
/* 218 */     this.stopButton.setEnabled(false);
/*     */ 
/* 220 */     this.controlPanel.add(Box.createRigidArea(spacer));
/* 221 */     this.controlPanel.add(new JLabel(this.resources.getString("slider.gui.slow")));
/* 222 */     JSlider speedSlider = new JSlider(10, 1000, 505);
/*     */ 
/* 224 */     speedSlider.setInverted(true);
/* 225 */     speedSlider.setPreferredSize(new Dimension(100, speedSlider.getPreferredSize().height));
/*     */ 
/* 227 */     speedSlider.setMaximumSize(speedSlider.getPreferredSize());
/*     */ 
/* 231 */     InputMap map = speedSlider.getInputMap();
/* 232 */     while (map != null)
/*     */     {
/* 234 */       map.remove(KeyStroke.getKeyStroke("control PAGE_UP"));
/* 235 */       map.remove(KeyStroke.getKeyStroke("control PAGE_DOWN"));
/* 236 */       map = map.getParent();
/*     */     }
/*     */ 
/* 239 */     this.controlPanel.add(speedSlider);
/* 240 */     this.controlPanel.add(new JLabel(this.resources.getString("slider.gui.fast")));
/* 241 */     this.controlPanel.add(Box.createRigidArea(new Dimension(5, 0)));
/*     */ 
/* 243 */     this.stepButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 247 */         GUIController.this.step();
/*     */       }
/*     */     });
/* 250 */     this.runButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 254 */         GUIController.this.run();
/*     */       }
/*     */     });
/* 257 */     this.stopButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 261 */         GUIController.this.stop();
/*     */       }
/*     */     });
/* 264 */     speedSlider.addChangeListener(new ChangeListener()
/*     */     {
/*     */       public void stateChanged(ChangeEvent evt)
/*     */       {
/* 268 */         GUIController.this.timer.setDelay(((JSlider)evt.getSource()).getValue());
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public JComponent controlPanel()
/*     */   {
/* 279 */     return this.controlPanel;
/*     */   }
/*     */ 
/*     */   private void locationClicked()
/*     */   {
/* 287 */     World world = this.parentFrame.getWorld();
/* 288 */     Location loc = this.display.getCurrentLocation();
/* 289 */     if ((loc != null) && (!world.locationClicked(loc)))
/* 290 */       editLocation();
/* 291 */     this.parentFrame.repaint();
/*     */   }
/*     */ 
/*     */   public void editLocation()
/*     */   {
/* 300 */     World world = this.parentFrame.getWorld();
/*     */ 
/* 302 */     Location loc = this.display.getCurrentLocation();
/* 303 */     if (loc != null)
/*     */     {
/* 305 */       Object occupant = world.getGrid().get(loc);
/* 306 */       if (occupant == null)
/*     */       {
/* 308 */         MenuMaker maker = new MenuMaker(this.parentFrame, this.resources, this.displayMap);
/*     */ 
/* 310 */         JPopupMenu popup = maker.makeConstructorMenu(this.occupantClasses, loc);
/*     */ 
/* 312 */         Point p = this.display.pointForLocation(loc);
/* 313 */         popup.show(this.display, p.x, p.y);
/*     */       }
/*     */       else
/*     */       {
/* 317 */         MenuMaker maker = new MenuMaker(this.parentFrame, this.resources, this.displayMap);
/*     */ 
/* 319 */         JPopupMenu popup = maker.makeMethodMenu(occupant, loc);
/* 320 */         Point p = this.display.pointForLocation(loc);
/* 321 */         popup.show(this.display, p.x, p.y);
/*     */       }
/*     */     }
/* 324 */     this.parentFrame.repaint();
/*     */   }
/*     */ 
/*     */   public void deleteLocation()
/*     */   {
/* 333 */     World world = this.parentFrame.getWorld();
/* 334 */     Location loc = this.display.getCurrentLocation();
/* 335 */     if (loc != null)
/*     */     {
/* 337 */       world.remove(loc);
/* 338 */       this.parentFrame.repaint();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.GUIController
 * JD-Core Version:    0.6.0
 */