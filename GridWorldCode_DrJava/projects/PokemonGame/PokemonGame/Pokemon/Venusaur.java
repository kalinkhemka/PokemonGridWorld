/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Venusaur extends Pokemon
/*    */ {
/*    */   public Venusaur(int level)
/*    */   {
/*  9 */     super(80, 82, 83, 100, 100, 80, 236, level, "grass");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Earthquake());
/* 12 */     atks.add(new PetalDance());
/* 13 */     atks.add(new LeafStorm());
/* 14 */     atks.add(new FrenzyPlant());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Venusaur");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Venusaur
 * JD-Core Version:    0.6.0
 */