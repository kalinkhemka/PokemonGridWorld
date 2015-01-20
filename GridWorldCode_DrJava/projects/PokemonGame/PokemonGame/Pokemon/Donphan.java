/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Donphan extends Pokemon
/*    */ {
/*    */   public Donphan(int level)
/*    */   {
/*  9 */     super(90, 120, 120, 60, 60, 50, 175, level, "ground");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new FireFang());
/* 12 */     atks.add(new ThunderFang());
/* 13 */     atks.add(new HeadSmash());
/* 14 */     atks.add(new Earthquake());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Donphan");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Donphan
 * JD-Core Version:    0.6.0
 */