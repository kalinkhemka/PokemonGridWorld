/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Pidgeotto extends Pokemon
/*    */ {
/*    */   public Pidgeotto(int level)
/*    */   {
/*  9 */     super(63, 60, 55, 50, 50, 71, 122, level, "flying");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new AirSlash());
/* 12 */     atks.add(new QuickAttack());
/* 13 */     atks.add(new Hurricane());
/* 14 */     atks.add(new OminousWind());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Pidgeotto");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Pidgeotto
 * JD-Core Version:    0.6.0
 */