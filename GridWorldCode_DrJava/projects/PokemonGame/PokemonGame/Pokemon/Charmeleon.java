/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Charmeleon extends Pokemon
/*    */ {
/*    */   public Charmeleon(int level)
/*    */   {
/*  9 */     super(58, 64, 58, 80, 65, 80, 142, level, "fire");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new FlameBurst());
/* 12 */     atks.add(new Flamethrower());
/* 13 */     atks.add(new MegaKick());
/* 14 */     atks.add(new Crunch());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Charmeleon");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Charmeleon
 * JD-Core Version:    0.6.0
 */