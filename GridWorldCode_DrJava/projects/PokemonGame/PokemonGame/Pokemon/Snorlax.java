/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Snorlax extends Pokemon
/*    */ {
/*    */   public Snorlax(int level)
/*    */   {
/*  9 */     super(160, 110, 65, 65, 110, 30, 189, level, "normal");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new BodySlam());
/* 12 */     atks.add(new Earthquake());
/* 13 */     atks.add(new Lick());
/* 14 */     atks.add(new LastResort());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Snorlax");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Snorlax
 * JD-Core Version:    0.6.0
 */