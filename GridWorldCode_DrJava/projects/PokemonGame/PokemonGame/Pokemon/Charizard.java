/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Charizard extends Pokemon
/*    */ {
/*    */   public Charizard(int level)
/*    */   {
/*  9 */     super(78, 84, 78, 109, 85, 100, 240, level, "fire");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new AirSlash());
/* 12 */     atks.add(new BlastBurn());
/* 13 */     atks.add(new DragonRush());
/* 14 */     atks.add(new GigaImpact());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Charizard");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Charizard
 * JD-Core Version:    0.6.0
 */