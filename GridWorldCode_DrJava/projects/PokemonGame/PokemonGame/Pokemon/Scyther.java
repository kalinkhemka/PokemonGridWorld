/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Scyther extends Pokemon
/*    */ {
/*    */   public Scyther(int level)
/*    */   {
/*  9 */     super(70, 110, 80, 55, 80, 105, 100, level, "bug");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new AirSlash());
/* 12 */     atks.add(new BugBuzz());
/* 13 */     atks.add(new HyperBeam());
/* 14 */     atks.add(new BugBite());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Scyther");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Scyther
 * JD-Core Version:    0.6.0
 */