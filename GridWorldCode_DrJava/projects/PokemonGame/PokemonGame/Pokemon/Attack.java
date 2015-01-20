/*    */ package Pokemon;
/*    */ 
/*    */ public class Attack
/*    */ {
/*    */   private String name;
/*    */   private String type;
/*    */   private int strength;
/*    */   private double accuracy;
/*    */   private boolean sp;
/*    */ 
/*    */   public Attack(String n, String t, double a, int s, boolean special)
/*    */   {
/* 11 */     this.name = n;
/* 12 */     this.accuracy = a;
/* 13 */     this.strength = s;
/* 14 */     this.type = t;
/* 15 */     this.sp = special;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 19 */     return this.name;
/*    */   }
/*    */ 
/*    */   public double getAccuray() {
/* 23 */     return this.accuracy;
/*    */   }
/*    */ 
/*    */   public int getStrength() {
/* 27 */     return this.strength;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 31 */     return this.type;
/*    */   }
/*    */ 
/*    */   public boolean getSpecial() {
/* 35 */     return this.sp;
/*    */   }
/*    */ 
/*    */   public boolean HitMiss(double acc) {
/* 39 */     double prob = acc * this.accuracy;
/*    */ 
/* 41 */     return Math.random() <= prob;
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Attack
 * JD-Core Version:    0.6.0
 */