/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Corsola extends Pokemon
/*    */ {
/*    */   public Corsola(int level)
/*    */   {
/*  9 */     super(55, 55, 85, 85, 65, 85, 133, level, "water");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Bubble());
/* 12 */     atks.add(new PowerGem());
/* 13 */     atks.add(new IceBeam());
/* 14 */     atks.add(new MuddyWater());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Corsola");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Corsola
 * JD-Core Version:    0.6.0
 */