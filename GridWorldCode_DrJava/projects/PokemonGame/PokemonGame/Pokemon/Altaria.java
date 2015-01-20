/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Altaria extends Pokemon
/*    */ {
/*    */   public Altaria(int level)
/*    */   {
/*  9 */     super(75, 70, 90, 70, 105, 80, 172, level, "dragon");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new DragonPulse());
/* 12 */     atks.add(new SkyAttack());
/* 13 */     atks.add(new DragonMeteor());
/* 14 */     atks.add(new HeatWave());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Altaria");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Altaria
 * JD-Core Version:    0.6.0
 */