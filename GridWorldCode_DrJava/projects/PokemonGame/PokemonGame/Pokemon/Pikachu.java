/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Pikachu extends Pokemon
/*    */ {
/*    */   public Pikachu(int level)
/*    */   {
/*  9 */     super(35, 55, 30, 50, 40, 90, 105, level, "electric");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new ChargeBeam());
/* 12 */     atks.add(new Thunder());
/* 13 */     atks.add(new FocusBlast());
/* 14 */     atks.add(new QuickAttack());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Pikachu");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Pikachu
 * JD-Core Version:    0.6.0
 */