/*     */ package info.gridworld.actor;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.world.World;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class ActorWorld extends World<Actor>
/*     */ {
/*     */   private static final String DEFAULT_MESSAGE = "Click on a grid location to construct or manipulate an actor.";
/*     */ 
/*     */   public ActorWorld()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ActorWorld(Grid<Actor> grid)
/*     */   {
/*  47 */     super(grid);
/*     */   }
/*     */ 
/*     */   public void show()
/*     */   {
/*  52 */     if (getMessage() == null)
/*  53 */       setMessage("Click on a grid location to construct or manipulate an actor.");
/*  54 */     super.show();
/*     */   }
/*     */ 
/*     */   public void step()
/*     */   {
/*  59 */     Grid gr = getGrid();
/*  60 */     ArrayList actors = new ArrayList();
/*  61 */     for (Location loc : gr.getOccupiedLocations()) {
/*  62 */       actors.add(gr.get(loc));
/*     */     }
/*  64 */     for (Actor a : actors)
/*     */     {
/*  67 */       if (a.getGrid() == gr)
/*  68 */         a.act();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void add(Location loc, Actor occupant)
/*     */   {
/*  79 */     occupant.putSelfInGrid(getGrid(), loc);
/*     */   }
/*     */ 
/*     */   public void add(Actor occupant)
/*     */   {
/*  88 */     Location loc = getRandomEmptyLocation();
/*  89 */     if (loc != null)
/*  90 */       add(loc, occupant);
/*     */   }
/*     */ 
/*     */   public Actor remove(Location loc)
/*     */   {
/* 101 */     Actor occupant = (Actor)getGrid().get(loc);
/* 102 */     if (occupant == null)
/* 103 */       return null;
/* 104 */     occupant.removeSelfFromGrid();
/* 105 */     return occupant;
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.actor.ActorWorld
 * JD-Core Version:    0.6.0
 */