/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Blaziken extends Pokemon
/*    */ {
/*    */   public Blaziken(int level)
/*    */   {
/*  9 */     super(80, 120, 70, 110, 70, 80, 239, level, "fire");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new FirePunch());
/* 12 */     atks.add(new Overheat());
/* 13 */     atks.add(new SkyUppercut());
/* 14 */     atks.add(new FocusBlast());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Blaziken");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Blaziken
 * JD-Core Version:    0.6.0
 */