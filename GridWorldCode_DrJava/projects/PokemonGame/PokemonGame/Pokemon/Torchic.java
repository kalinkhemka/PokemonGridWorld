/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Torchic extends Pokemon
/*    */ {
/*    */   public Torchic(int level)
/*    */   {
/*  9 */     super(45, 60, 40, 70, 50, 45, 62, level, "fire");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Ember());
/* 12 */     atks.add(new Peck());
/* 13 */     atks.add(new FlameCharge());
/* 14 */     atks.add(new Bounce());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Torchic");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Torchic
 * JD-Core Version:    0.6.0
 */