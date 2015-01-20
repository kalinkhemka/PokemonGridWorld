/*     */ package info.gridworld.grid;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class BoundedGrid<E> extends AbstractGrid<E>
/*     */ {
/*     */   private Object[][] occupantArray;
/*     */ 
/*     */   public BoundedGrid(int rows, int cols)
/*     */   {
/*  41 */     if (rows <= 0)
/*  42 */       throw new IllegalArgumentException("rows <= 0");
/*  43 */     if (cols <= 0)
/*  44 */       throw new IllegalArgumentException("cols <= 0");
/*  45 */     this.occupantArray = new Object[rows][cols];
/*     */   }
/*     */ 
/*     */   public int getNumRows()
/*     */   {
/*  50 */     return this.occupantArray.length;
/*     */   }
/*     */ 
/*     */   public int getNumCols()
/*     */   {
/*  57 */     return this.occupantArray[0].length;
/*     */   }
/*     */ 
/*     */   public boolean isValid(Location loc)
/*     */   {
/*  62 */     return (0 <= loc.getRow()) && (loc.getRow() < getNumRows()) && (0 <= loc.getCol()) && (loc.getCol() < getNumCols());
/*     */   }
/*     */ 
/*     */   public ArrayList<Location> getOccupiedLocations()
/*     */   {
/*  68 */     ArrayList theLocations = new ArrayList();
/*     */ 
/*  71 */     for (int r = 0; r < getNumRows(); r++)
/*     */     {
/*  73 */       for (int c = 0; c < getNumCols(); c++)
/*     */       {
/*  76 */         Location loc = new Location(r, c);
/*  77 */         if (get(loc) != null) {
/*  78 */           theLocations.add(loc);
/*     */         }
/*     */       }
/*     */     }
/*  82 */     return theLocations;
/*     */   }
/*     */ 
/*     */   public E get(Location loc)
/*     */   {
/*  87 */     if (!isValid(loc)) {
/*  88 */       throw new IllegalArgumentException("Location " + loc + " is not valid");
/*     */     }
/*  90 */     return this.occupantArray[loc.getRow()][loc.getCol()];
/*     */   }
/*     */ 
/*     */   public E put(Location loc, E obj)
/*     */   {
/*  95 */     if (!isValid(loc)) {
/*  96 */       throw new IllegalArgumentException("Location " + loc + " is not valid");
/*     */     }
/*  98 */     if (obj == null) {
/*  99 */       throw new NullPointerException("obj == null");
/*     */     }
/*     */ 
/* 102 */     Object oldOccupant = get(loc);
/* 103 */     this.occupantArray[loc.getRow()][loc.getCol()] = obj;
/* 104 */     return oldOccupant;
/*     */   }
/*     */ 
/*     */   public E remove(Location loc)
/*     */   {
/* 109 */     if (!isValid(loc)) {
/* 110 */       throw new IllegalArgumentException("Location " + loc + " is not valid");
/*     */     }
/*     */ 
/* 114 */     Object r = get(loc);
/* 115 */     this.occupantArray[loc.getRow()][loc.getCol()] = null;
/* 116 */     return r;
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.grid.BoundedGrid
 * JD-Core Version:    0.6.0
 */