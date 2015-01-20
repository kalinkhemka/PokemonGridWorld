/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Swablu extends Pokemon
/*    */ {
/*    */   public Swablu(int level)
/*    */   {
/*  9 */     super(45, 40, 60, 40, 75, 50, 62, level, "flying");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Peck());
/* 12 */     atks.add(new Astonish());
/* 13 */     atks.add(new IceBeam());
/* 14 */     atks.add(new Bounce());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Swablu");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Swablu
 * JD-Core Version:    0.6.0
 */