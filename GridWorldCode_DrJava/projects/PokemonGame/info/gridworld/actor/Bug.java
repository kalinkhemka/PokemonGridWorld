/*     */ package info.gridworld.actor;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import java.awt.Color;
/*     */ 
/*     */ public class Bug extends Actor
/*     */ {
/*     */   public Bug()
/*     */   {
/*  36 */     setColor(Color.RED);
/*     */   }
/*     */ 
/*     */   public Bug(Color bugColor)
/*     */   {
/*  45 */     setColor(bugColor);
/*     */   }
/*     */ 
/*     */   public void act()
/*     */   {
/*  53 */     if (canMove())
/*  54 */       move();
/*     */     else
/*  56 */       turn();
/*     */   }
/*     */ 
/*     */   public void turn()
/*     */   {
/*  64 */     setDirection(getDirection() + 45);
/*     */   }
/*     */ 
/*     */   public void move()
/*     */   {
/*  73 */     Grid gr = getGrid();
/*  74 */     if (gr == null)
/*  75 */       return;
/*  76 */     Location loc = getLocation();
/*  77 */     Location next = loc.getAdjacentLocation(getDirection());
/*  78 */     if (gr.isValid(next))
/*  79 */       moveTo(next);
/*     */     else
/*  81 */       removeSelfFromGrid();
/*  82 */     Flower flower = new Flower(getColor());
/*  83 */     flower.putSelfInGrid(gr, loc);
/*     */   }
/*     */ 
/*     */   public boolean canMove()
/*     */   {
/*  93 */     Grid gr = getGrid();
/*  94 */     if (gr == null)
/*  95 */       return false;
/*  96 */     Location loc = getLocation();
/*  97 */     Location next = loc.getAdjacentLocation(getDirection());
/*  98 */     if (!gr.isValid(next))
/*  99 */       return false;
/* 100 */     Actor neighbor = (Actor)gr.get(next);
/* 101 */     return (neighbor == null) || ((neighbor instanceof Flower));
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.actor.Bug
 * JD-Core Version:    0.6.0
 */