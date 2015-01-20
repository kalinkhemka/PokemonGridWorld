/*    */ package Pokemon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PokemonGenerator
/*    */ {
/*    */   private int level;
/*    */ 
/*    */   public PokemonGenerator(ArrayList<Pokemon> bag)
/*    */   {
/*  8 */     int highestLevel = ((Pokemon)bag.get(0)).getLevel();
/*  9 */     for (int i = 0; i < bag.size(); i++) {
/* 10 */       if (((Pokemon)bag.get(i)).getLevel() > highestLevel) {
/* 11 */         highestLevel = ((Pokemon)bag.get(i)).getLevel();
/*    */       }
/*    */     }
/* 14 */     this.level = (1 + (int)(highestLevel * Math.random()));
/*    */   }
/*    */ 
/*    */   public PokemonGenerator(int l) {
/* 18 */     this.level = l;
/*    */   }
/*    */ 
/*    */   public Pokemon gen() {
/* 22 */     Pokemon[] allPossiblePokemon = { new Blastoise(this.level), new Charizard(this.level), new Charmander(this.level), new Charmeleon(this.level), new Corsola(this.level), new Kangaskhan(this.level), new Mew(this.level), new Onix(this.level), new Phanphy(this.level), new Pidgeot(this.level), new Pikachu(this.level), new Scyther(this.level), new Snorlax(this.level), new Squirtle(this.level), new Togepi(this.level), new Venusaur(this.level), new Wartortle(this.level) };
/* 23 */     return allPossiblePokemon[(int)(allPossiblePokemon.length * Math.random())];
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.PokemonGenerator
 * JD-Core Version:    0.6.0
 */