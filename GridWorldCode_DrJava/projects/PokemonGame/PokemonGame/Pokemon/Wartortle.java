/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Wartortle extends Pokemon
/*    */ {
/*    */   public Wartortle(int level)
/*    */   {
/*  9 */     super(59, 63, 80, 65, 80, 58, 142, level, "water");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new WaterPulse());
/* 12 */     atks.add(new IceBeam());
/* 13 */     atks.add(new MuddyWater());
/* 14 */     atks.add(new ZenHeadbutt());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Wartortle");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Wartortle
 * JD-Core Version:    0.6.0
 */