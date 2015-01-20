/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Mew extends Pokemon
/*    */ {
/*    */   public Mew(int level)
/*    */   {
/*  9 */     super(100, 100, 100, 100, 100, 100, 169, level, "psychic");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Pound());
/* 12 */     atks.add(new MegaPunch());
/* 13 */     atks.add(new ShadowBall());
/* 14 */     atks.add(new Psychic());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Mew");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Mew
 * JD-Core Version:    0.6.0
 */