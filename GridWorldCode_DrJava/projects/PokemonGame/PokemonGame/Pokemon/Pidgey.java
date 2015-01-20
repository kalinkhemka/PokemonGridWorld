/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Pidgey extends Pokemon
/*    */ {
/*    */   public Pidgey(int level)
/*    */   {
/*  9 */     super(40, 45, 40, 35, 35, 56, 50, level, "flying");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Gust());
/* 12 */     atks.add(new QuickAttack());
/* 13 */     atks.add(new Twister());
/* 14 */     atks.add(new WingAttack());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Pidgey");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Pidgey
 * JD-Core Version:    0.6.0
 */