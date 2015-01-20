/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Phanphy extends Pokemon
/*    */ {
/*    */   public Phanphy(int level)
/*    */   {
/*  9 */     super(90, 60, 60, 40, 40, 40, 66, level, "ground");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Rollout());
/* 12 */     atks.add(new TakeDown());
/* 13 */     atks.add(new RockTomb());
/* 14 */     atks.add(new Bulldoze());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Phanphy");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Phanphy
 * JD-Core Version:    0.6.0
 */