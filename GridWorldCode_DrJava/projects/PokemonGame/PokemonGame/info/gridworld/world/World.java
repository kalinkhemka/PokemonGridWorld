/*     */ package info.gridworld.world;
/*     */ 
/*     */ import info.gridworld.grid.BoundedGrid;
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.gui.WorldFrame;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class World<T>
/*     */ {
/*     */   private Grid<T> gr;
/*     */   private Set<String> occupantClassNames;
/*     */   private Set<String> gridClassNames;
/*     */   private String message;
/*     */   private JFrame frame;
/*  44 */   private static Random generator = new Random();
/*     */   private static final int DEFAULT_ROWS = 10;
/*     */   private static final int DEFAULT_COLS = 10;
/*     */ 
/*     */   public World()
/*     */   {
/*  51 */     this(new BoundedGrid(10, 10));
/*  52 */     this.message = null;
/*     */   }
/*     */ 
/*     */   public World(Grid<T> g)
/*     */   {
/*  57 */     this.gr = g;
/*  58 */     this.gridClassNames = new TreeSet();
/*  59 */     this.occupantClassNames = new TreeSet();
/*  60 */     addGridClass("info.gridworld.grid.BoundedGrid");
/*  61 */     addGridClass("info.gridworld.grid.UnboundedGrid");
/*     */   }
/*     */ 
/*     */   public void show()
/*     */   {
/*  69 */     if (this.frame == null)
/*     */     {
/*  71 */       this.frame = new WorldFrame(this);
/*  72 */       this.frame.setVisible(true);
/*     */     }
/*     */     else {
/*  75 */       this.frame.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Grid<T> getGrid()
/*     */   {
/*  84 */     return this.gr;
/*     */   }
/*     */ 
/*     */   public void setGrid(Grid<T> newGrid)
/*     */   {
/*  93 */     this.gr = newGrid;
/*  94 */     repaint();
/*     */   }
/*     */ 
/*     */   public void setMessage(String newMessage)
/*     */   {
/* 103 */     this.message = newMessage;
/* 104 */     repaint();
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/* 113 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void step()
/*     */   {
/* 122 */     repaint();
/*     */   }
/*     */ 
/*     */   public boolean locationClicked(Location loc)
/*     */   {
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean keyPressed(String description, Location loc)
/*     */   {
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */   public Location getRandomEmptyLocation()
/*     */   {
/* 159 */     Grid gr = getGrid();
/* 160 */     int rows = gr.getNumRows();
/* 161 */     int cols = gr.getNumCols();
/*     */ 
/* 163 */     if ((rows > 0) && (cols > 0))
/*     */     {
/* 166 */       ArrayList emptyLocs = new ArrayList();
/* 167 */       for (int i = 0; i < rows; i++)
/* 168 */         for (int j = 0; j < cols; j++)
/*     */         {
/* 170 */           Location loc = new Location(i, j);
/* 171 */           if ((gr.isValid(loc)) && (gr.get(loc) == null))
/* 172 */             emptyLocs.add(loc);
/*     */         }
/* 174 */       if (emptyLocs.size() == 0)
/* 175 */         return null;
/* 176 */       int r = generator.nextInt(emptyLocs.size());
/* 177 */       return (Location)emptyLocs.get(r);
/*     */     }
/*     */     while (true)
/*     */     {
/*     */       int r;
/*     */       int r;
/* 186 */       if (rows < 0)
/* 187 */         r = (int)(10.0D * generator.nextGaussian());
/*     */       else
/* 189 */         r = generator.nextInt(rows);
/*     */       int c;
/*     */       int c;
/* 191 */       if (cols < 0)
/* 192 */         c = (int)(10.0D * generator.nextGaussian());
/*     */       else
/* 194 */         c = generator.nextInt(cols);
/* 195 */       Location loc = new Location(r, c);
/* 196 */       if ((gr.isValid(loc)) && (gr.get(loc) == null))
/* 197 */         return loc;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void add(Location loc, T occupant)
/*     */   {
/* 209 */     getGrid().put(loc, occupant);
/* 210 */     repaint();
/*     */   }
/*     */ 
/*     */   public T remove(Location loc)
/*     */   {
/* 220 */     Object r = getGrid().remove(loc);
/* 221 */     repaint();
/* 222 */     return r;
/*     */   }
/*     */ 
/*     */   public void addGridClass(String className)
/*     */   {
/* 231 */     this.gridClassNames.add(className);
/*     */   }
/*     */ 
/*     */   public void addOccupantClass(String className)
/*     */   {
/* 240 */     this.occupantClassNames.add(className);
/*     */   }
/*     */ 
/*     */   public Set<String> getGridClasses()
/*     */   {
/* 250 */     return this.gridClassNames;
/*     */   }
/*     */ 
/*     */   public Set<String> getOccupantClasses()
/*     */   {
/* 260 */     return this.occupantClassNames;
/*     */   }
/*     */ 
/*     */   private void repaint()
/*     */   {
/* 265 */     if (this.frame != null)
/* 266 */       this.frame.repaint();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 274 */     String s = "";
/* 275 */     Grid gr = getGrid();
/*     */ 
/* 277 */     int rmin = 0;
/* 278 */     int rmax = gr.getNumRows() - 1;
/* 279 */     int cmin = 0;
/* 280 */     int cmax = gr.getNumCols() - 1;
/* 281 */     if ((rmax < 0) || (cmax < 0))
/*     */     {
/* 283 */       for (Location loc : gr.getOccupiedLocations())
/*     */       {
/* 285 */         int r = loc.getRow();
/* 286 */         int c = loc.getCol();
/* 287 */         if (r < rmin)
/* 288 */           rmin = r;
/* 289 */         if (r > rmax)
/* 290 */           rmax = r;
/* 291 */         if (c < cmin)
/* 292 */           cmin = c;
/* 293 */         if (c > cmax) {
/* 294 */           cmax = c;
/*     */         }
/*     */       }
/*     */     }
/* 298 */     for (int i = rmin; i <= rmax; i++)
/*     */     {
/* 300 */       for (int j = cmin; j < cmax; j++)
/*     */       {
/* 302 */         Object obj = gr.get(new Location(i, j));
/* 303 */         if (obj == null)
/* 304 */           s = s + " ";
/*     */         else
/* 306 */           s = s + obj.toString().substring(0, 1);
/*     */       }
/* 308 */       s = s + "\n";
/*     */     }
/* 310 */     return s;
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.world.World
 * JD-Core Version:    0.6.0
 */