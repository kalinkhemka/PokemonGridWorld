/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Pidgeot extends Pokemon
/*    */ {
/*    */   public Pidgeot(int level)
/*    */   {
/*  9 */     super(83, 80, 75, 70, 70, 91, 211, level, "flying");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Hurricane());
/* 12 */     atks.add(new SkyAttack());
/* 13 */     atks.add(new HeatWave());
/* 14 */     atks.add(new Twister());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Pidgeot");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Pidgeot
 * JD-Core Version:    0.6.0
 */