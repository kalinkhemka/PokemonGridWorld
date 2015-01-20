/*    */ package info.gridworld.grid;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public abstract class AbstractGrid<E>
/*    */   implements Grid<E>
/*    */ {
/*    */   public ArrayList<E> getNeighbors(Location loc)
/*    */   {
/* 30 */     ArrayList neighbors = new ArrayList();
/* 31 */     for (Location neighborLoc : getOccupiedAdjacentLocations(loc))
/* 32 */       neighbors.add(get(neighborLoc));
/* 33 */     return neighbors;
/*    */   }
/*    */ 
/*    */   public ArrayList<Location> getValidAdjacentLocations(Location loc)
/*    */   {
/* 38 */     ArrayList locs = new ArrayList();
/*    */ 
/* 40 */     int d = 0;
/* 41 */     for (int i = 0; i < 8; i++)
/*    */     {
/* 43 */       Location neighborLoc = loc.getAdjacentLocation(d);
/* 44 */       if (isValid(neighborLoc))
/* 45 */         locs.add(neighborLoc);
/* 46 */       d += 45;
/*    */     }
/* 48 */     return locs;
/*    */   }
/*    */ 
/*    */   public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
/*    */   {
/* 53 */     ArrayList locs = new ArrayList();
/* 54 */     for (Location neighborLoc : getValidAdjacentLocations(loc))
/*    */     {
/* 56 */       if (get(neighborLoc) == null)
/* 57 */         locs.add(neighborLoc);
/*    */     }
/* 59 */     return locs;
/*    */   }
/*    */ 
/*    */   public ArrayList<Location> getOccupiedAdjacentLocations(Location loc)
/*    */   {
/* 64 */     ArrayList locs = new ArrayList();
/* 65 */     for (Location neighborLoc : getValidAdjacentLocations(loc))
/*    */     {
/* 67 */       if (get(neighborLoc) != null)
/* 68 */         locs.add(neighborLoc);
/*    */     }
/* 70 */     return locs;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 81 */     String s = "{";
/* 82 */     for (Location loc : getOccupiedLocations())
/*    */     {
/* 84 */       if (s.length() > 1)
/* 85 */         s = s + ", ";
/* 86 */       s = s + loc + "=" + get(loc);
/*    */     }
/* 88 */     return s + "}";
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.grid.AbstractGrid
 * JD-Core Version:    0.6.0
 */