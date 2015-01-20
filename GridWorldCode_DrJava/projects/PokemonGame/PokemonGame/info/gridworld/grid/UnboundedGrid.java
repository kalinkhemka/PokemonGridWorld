/*    */ package info.gridworld.grid;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class UnboundedGrid<E> extends AbstractGrid<E>
/*    */ {
/*    */   private Map<Location, E> occupantMap;
/*    */ 
/*    */   public UnboundedGrid()
/*    */   {
/* 40 */     this.occupantMap = new HashMap();
/*    */   }
/*    */ 
/*    */   public int getNumRows()
/*    */   {
/* 45 */     return -1;
/*    */   }
/*    */ 
/*    */   public int getNumCols()
/*    */   {
/* 50 */     return -1;
/*    */   }
/*    */ 
/*    */   public boolean isValid(Location loc)
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */ 
/*    */   public ArrayList<Location> getOccupiedLocations()
/*    */   {
/* 60 */     ArrayList a = new ArrayList();
/* 61 */     for (Location loc : this.occupantMap.keySet())
/* 62 */       a.add(loc);
/* 63 */     return a;
/*    */   }
/*    */ 
/*    */   public E get(Location loc)
/*    */   {
/* 68 */     if (loc == null)
/* 69 */       throw new NullPointerException("loc == null");
/* 70 */     return this.occupantMap.get(loc);
/*    */   }
/*    */ 
/*    */   public E put(Location loc, E obj)
/*    */   {
/* 75 */     if (loc == null)
/* 76 */       throw new NullPointerException("loc == null");
/* 77 */     if (obj == null)
/* 78 */       throw new NullPointerException("obj == null");
/* 79 */     return this.occupantMap.put(loc, obj);
/*    */   }
/*    */ 
/*    */   public E remove(Location loc)
/*    */   {
/* 84 */     if (loc == null)
/* 85 */       throw new NullPointerException("loc == null");
/* 86 */     return this.occupantMap.remove(loc);
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.grid.UnboundedGrid
 * JD-Core Version:    0.6.0
 */