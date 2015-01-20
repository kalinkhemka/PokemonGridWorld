/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Kangaskhan extends Pokemon
/*    */ {
/*    */   public Kangaskhan(int level)
/*    */   {
/*  9 */     super(105, 95, 80, 40, 80, 90, 172, level, "normal");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new MegaPunch());
/* 12 */     atks.add(new ShadowBall());
/* 13 */     atks.add(new GigaImpact());
/* 14 */     atks.add(new ZenHeadbutt());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Kanghaskhan");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Kangaskhan
 * JD-Core Version:    0.6.0
 */