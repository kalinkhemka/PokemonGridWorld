/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Togepi extends Pokemon
/*    */ {
/*    */   public Togepi(int level)
/*    */   {
/*  9 */     super(35, 20, 65, 40, 65, 20, 49, level, "normal");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new LastResort());
/* 12 */     atks.add(new Psychic());
/* 13 */     atks.add(new ShadowBall());
/* 14 */     atks.add(new Tackle());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Togepi");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Togepi
 * JD-Core Version:    0.6.0
 */