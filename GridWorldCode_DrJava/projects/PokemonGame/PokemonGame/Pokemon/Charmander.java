/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Charmander extends Pokemon
/*    */ {
/*    */   public Charmander(int level)
/*    */   {
/*  9 */     super(39, 52, 43, 60, 50, 65, 62, level, "fire");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Scratch());
/* 12 */     atks.add(new Ember());
/* 13 */     atks.add(new Flamethrower());
/* 14 */     atks.add(new ShadowClaw());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Charmander");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Charmander
 * JD-Core Version:    0.6.0
 */