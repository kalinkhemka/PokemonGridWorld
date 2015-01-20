/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Ivysaur extends Pokemon
/*    */ {
/*    */   public Ivysaur(int level)
/*    */   {
/*  9 */     super(60, 62, 63, 80, 80, 60, 142, level, "grass");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new TakeDown());
/* 12 */     atks.add(new RazorLeaf());
/* 13 */     atks.add(new SludgeBomb());
/* 14 */     atks.add(new SolarBeam());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Ivysaur");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Ivysaur
 * JD-Core Version:    0.6.0
 */