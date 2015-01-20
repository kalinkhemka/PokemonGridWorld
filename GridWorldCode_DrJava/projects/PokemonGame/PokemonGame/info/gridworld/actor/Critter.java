/*     */ package info.gridworld.actor;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class Critter extends Actor
/*     */ {
/*     */   public void act()
/*     */   {
/*  40 */     if (getGrid() == null)
/*  41 */       return;
/*  42 */     ArrayList actors = getActors();
/*  43 */     processActors(actors);
/*  44 */     ArrayList moveLocs = getMoveLocations();
/*  45 */     Location loc = selectMoveLocation(moveLocs);
/*  46 */     makeMove(loc);
/*     */   }
/*     */ 
/*     */   public ArrayList<Actor> getActors()
/*     */   {
/*  58 */     return getGrid().getNeighbors(getLocation());
/*     */   }
/*     */ 
/*     */   public void processActors(ArrayList<Actor> actors)
/*     */   {
/*  73 */     for (Actor a : actors)
/*     */     {
/*  75 */       if ((!(a instanceof Rock)) && (!(a instanceof Critter)))
/*  76 */         a.removeSelfFromGrid();
/*     */     }
/*     */   }
/*     */ 
/*     */   public ArrayList<Location> getMoveLocations()
/*     */   {
/*  90 */     return getGrid().getEmptyAdjacentLocations(getLocation());
/*     */   }
/*     */ 
/*     */   public Location selectMoveLocation(ArrayList<Location> locs)
/*     */   {
/* 106 */     int n = locs.size();
/* 107 */     if (n == 0)
/* 108 */       return getLocation();
/* 109 */     int r = (int)(Math.random() * n);
/* 110 */     return (Location)locs.get(r);
/*     */   }
/*     */ 
/*     */   public void makeMove(Location loc)
/*     */   {
/* 127 */     if (loc == null)
/* 128 */       removeSelfFromGrid();
/*     */     else
/* 130 */       moveTo(loc);
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.actor.Critter
 * JD-Core Version:    0.6.0
 */