/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Onix extends Pokemon
/*    */ {
/*    */   public Onix(int level)
/*    */   {
/*  9 */     super(35, 45, 160, 30, 45, 70, 77, level, "rock");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new RockThrow());
/* 12 */     atks.add(new StoneEdge());
/* 13 */     atks.add(new Earthquake());
/* 14 */     atks.add(new DragonRush());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Onix");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Onix
 * JD-Core Version:    0.6.0
 */