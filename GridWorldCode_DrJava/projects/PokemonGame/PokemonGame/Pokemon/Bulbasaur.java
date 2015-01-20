/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Bulbasaur extends Pokemon
/*    */ {
/*    */   public Bulbasaur(int level)
/*    */   {
/*  9 */     super(45, 49, 49, 65, 65, 45, 64, level, "grass");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Tackle());
/* 12 */     atks.add(new VineWhip());
/* 13 */     atks.add(new RazorLeaf());
/* 14 */     atks.add(new Sludge());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Bulbasaur");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Bulbasaur
 * JD-Core Version:    0.6.0
 */