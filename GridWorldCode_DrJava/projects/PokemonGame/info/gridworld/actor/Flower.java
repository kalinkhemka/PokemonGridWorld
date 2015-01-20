/*    */ package info.gridworld.actor;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class Flower extends Actor
/*    */ {
/* 29 */   private static final Color DEFAULT_COLOR = Color.PINK;
/*    */   private static final double DARKENING_FACTOR = 0.05D;
/*    */ 
/*    */   public Flower()
/*    */   {
/* 39 */     setColor(DEFAULT_COLOR);
/*    */   }
/*    */ 
/*    */   public Flower(Color initialColor)
/*    */   {
/* 48 */     setColor(initialColor);
/*    */   }
/*    */ 
/*    */   public void act()
/*    */   {
/* 56 */     Color c = getColor();
/* 57 */     int red = (int)(c.getRed() * 0.95D);
/* 58 */     int green = (int)(c.getGreen() * 0.95D);
/* 59 */     int blue = (int)(c.getBlue() * 0.95D);
/*    */ 
/* 61 */     setColor(new Color(red, green, blue));
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.actor.Flower
 * JD-Core Version:    0.6.0
 */