/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Combusken extends Pokemon
/*    */ {
/*    */   public Combusken(int level)
/*    */   {
/*  9 */     super(60, 85, 60, 85, 60, 55, 142, level, "fire");
/* 10 */     ArrayList atks = new ArrayList();
/* 11 */     atks.add(new Ember());
/* 12 */     atks.add(new FlareBlitz());
/* 13 */     atks.add(new BrickBreak());
/* 14 */     atks.add(new Bounce());
/* 15 */     setAttacks(atks);
/* 16 */     setName("Combusken");
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Combusken
 * JD-Core Version:    0.6.0
 */