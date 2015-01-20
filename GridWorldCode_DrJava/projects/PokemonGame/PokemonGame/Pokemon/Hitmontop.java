/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Hitmontop extends Pokemon
/*    */ {
/*    */   public Hitmontop(int level)
/*    */   {
/*  9 */     super(50, 95, 95, 35, 110, 70, 159, level, "fighting");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Revenge());
/* 12 */     atks.add(new CloseCombat());
/* 13 */     atks.add(new HiJumpKick());
/* 14 */     atks.add(new MachPunch());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Hitmontio");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Hitmontop
 * JD-Core Version:    0.6.0
 */