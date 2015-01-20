/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Squirtle extends Pokemon
/*    */ {
/*    */   public Squirtle(int level)
/*    */   {
/*  9 */     super(44, 48, 65, 50, 64, 43, 63, level, "water");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new WaterGun());
/* 12 */     atks.add(new SkullBash());
/* 13 */     atks.add(new MudSlap());
/* 14 */     atks.add(new ZenHeadbutt());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Squirtle");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Squirtle
 * JD-Core Version:    0.6.0
 */