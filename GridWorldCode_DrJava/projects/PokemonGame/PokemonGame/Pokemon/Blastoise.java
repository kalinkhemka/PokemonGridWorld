/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Blastoise extends Pokemon
/*    */ {
/*    */   public Blastoise(int level)
/*    */   {
/*  9 */     super(79, 83, 100, 85, 105, 78, 239, level, "water");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new HydroCannon());
/* 12 */     atks.add(new Blizzard());
/* 13 */     atks.add(new GigaImpact());
/* 14 */     atks.add(new ZenHeadbutt());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Blastoise");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Blastoise
 * JD-Core Version:    0.6.0
 */