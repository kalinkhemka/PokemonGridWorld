/*     */ package Trainer;
/*     */ 
/*     */ import Pokemon.Blastoise;
/*     */ import Pokemon.Charizard;
/*     */ import Pokemon.Charmander;
/*     */ import Pokemon.Charmeleon;
/*     */ import Pokemon.Corsola;
/*     */ import Pokemon.Kangaskhan;
/*     */ import Pokemon.Mew;
/*     */ import Pokemon.Onix;
/*     */ import Pokemon.Phanphy;
/*     */ import Pokemon.Pidgeot;
/*     */ import Pokemon.Pidgeotto;
/*     */ import Pokemon.Pidgey;
/*     */ import Pokemon.Pikachu;
/*     */ import Pokemon.Pokemon;
/*     */ import Pokemon.PokemonGenerator;
/*     */ import Pokemon.Scyther;
/*     */ import Pokemon.Snorlax;
/*     */ import Pokemon.Squirtle;
/*     */ import Pokemon.Togepi;
/*     */ import Pokemon.Venusaur;
/*     */ import Pokemon.Wartortle;
/*     */ import PokemonGrid.Cave33;
/*     */ import PokemonGrid.Cave43;
/*     */ import PokemonGrid.Green;
/*     */ import PokemonGrid.Path;
/*     */ import PokemonGrid.PokemonGrid;
/*     */ import PokemonGrid.TallGrass;
/*     */ import info.gridworld.actor.Actor;
/*     */ import info.gridworld.actor.Bug;
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.gui.GUIController;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JOptionPane;
/*     */ import pokebattleinterface.PokeBattleInterfaceApp;
/*     */ 
/*     */ public class Trainer extends Bug
/*     */ {
/*     */   private int idleMoveCount;
/*     */   private String name;
/*  15 */   private ArrayList<Pokemon> pokemonBag = new ArrayList();
/*     */   private static final int MAX_POKEMON = 6;
/*     */   protected String directionSuffix;
/*  18 */   Actor oldActor = null;
/*     */   Actor nextActor;
/*  19 */   private boolean world2 = false; private boolean worlds = false; private boolean switched = false;
/*     */   private GUIController control;
/*     */ 
/*     */   public Trainer(String name)
/*     */   {
/*  23 */     this.name = name;
/*     */ 
/*  26 */     this.pokemonBag.add(new Blastoise((int)(1.0D + Math.random() * 100.0D)));
/*     */ 
/*  29 */     this.pokemonBag.add(new Charizard((int)(1.0D + Math.random() * 100.0D)));
/*  30 */     this.pokemonBag.add(new Charmander((int)(1.0D + Math.random() * 100.0D)));
/*  31 */     this.pokemonBag.add(new Charmeleon((int)(1.0D + Math.random() * 100.0D)));
/*     */ 
/*  33 */     this.pokemonBag.add(new Corsola((int)(1.0D + Math.random() * 100.0D)));
/*     */ 
/*  37 */     this.pokemonBag.add(new Kangaskhan((int)(1.0D + Math.random() * 100.0D)));
/*  38 */     this.pokemonBag.add(new Mew((int)(1.0D + Math.random() * 100.0D)));
/*  39 */     this.pokemonBag.add(new Onix((int)(1.0D + Math.random() * 100.0D)));
/*  40 */     this.pokemonBag.add(new Phanphy((int)(1.0D + Math.random() * 100.0D)));
/*  41 */     this.pokemonBag.add(new Pidgeot((int)(1.0D + Math.random() * 100.0D)));
/*  42 */     this.pokemonBag.add(new Pidgeotto((int)(1.0D + Math.random() * 100.0D)));
/*  43 */     this.pokemonBag.add(new Pidgey((int)(1.0D + Math.random() * 100.0D)));
/*  44 */     this.pokemonBag.add(new Pikachu((int)(1.0D + Math.random() * 100.0D)));
/*  45 */     this.pokemonBag.add(new Scyther((int)(1.0D + Math.random() * 100.0D)));
/*  46 */     this.pokemonBag.add(new Snorlax((int)(1.0D + Math.random() * 100.0D)));
/*  47 */     this.pokemonBag.add(new Squirtle((int)(1.0D + Math.random() * 100.0D)));
/*     */ 
/*  49 */     this.pokemonBag.add(new Togepi((int)(1.0D + Math.random() * 100.0D)));
/*     */ 
/*  51 */     this.pokemonBag.add(new Venusaur((int)(1.0D + Math.random() * 100.0D)));
/*  52 */     this.pokemonBag.add(new Wartortle((int)(1.0D + Math.random() * 100.0D)));
/*     */ 
/*  54 */     setColor(null);
/*  55 */     this.idleMoveCount = 50;
/*     */   }
/*     */   public void setControl(GUIController c) {
/*  58 */     this.control = c;
/*     */   }
/*     */   public ArrayList<Pokemon> getBag() {
/*  61 */     return this.pokemonBag;
/*     */   }
/*     */   public String getDirectionSuffix() {
/*  64 */     return this.directionSuffix;
/*     */   }
/*     */   public void ChangeDirectionSuffix(String ds) {
/*  67 */     this.directionSuffix = ds;
/*     */   }
/*     */   public void getOldActor(Grid gr, Location loc) {
/*  70 */     this.oldActor = ((Actor)(Actor)gr.get(new Location(6, 10)));
/*     */   }
/*     */   public void capturePokemon(Pokemon p) {
/*  73 */     this.pokemonBag.add(p);
/*     */   }
/*     */ 
/*     */   public void move() {
/*  77 */     Grid gr = getGrid();
/*  78 */     if (gr == null)
/*  79 */       return;
/*  80 */     Location loc = getLocation();
/*  81 */     Location next = loc.getAdjacentLocation(getDirection());
/*  82 */     if (gr.isValid(next)) {
/*  83 */       this.nextActor = ((Actor)gr.get(next));
/*  84 */       moveTo(next);
/*  85 */       if (this.oldActor != null)
/*  86 */         this.oldActor.putSelfInGrid(gr, loc);
/*  87 */       this.oldActor = this.nextActor;
/*     */     }
/*     */     else {
/*  90 */       removeSelfFromGrid();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getImageSuffix() {
/*  94 */     return "_" + this.directionSuffix;
/*     */   }
/*     */ 
/*     */   public boolean canMove()
/*     */   {
/* 100 */     Grid gr = getGrid();
/* 101 */     if (gr == null)
/* 102 */       return false;
/* 103 */     Location loc = getLocation();
/* 104 */     Location next = loc.getAdjacentLocation(getDirection());
/* 105 */     if (!gr.isValid(next))
/* 106 */       return false;
/* 107 */     Actor neighbor = (Actor)gr.get(next);
/* 108 */     return (neighbor == null) || ((neighbor instanceof TallGrass)) || ((neighbor instanceof Green)) || ((neighbor instanceof Path)) || ((neighbor instanceof Cave43)) || ((neighbor instanceof Cave33));
/*     */   }
/*     */ 
/*     */   public void act()
/*     */   {
/* 114 */     Grid gr = getGrid();
/* 115 */     Location location = new Location(6, 0);
/* 116 */     Location rightLoc = new Location(6, 19);
/* 117 */     if ((this.oldActor instanceof Cave33)) {
/* 118 */       if (getLocation().equals(new Location(3, 15))) {
/* 119 */         removeSelfFromGrid();
/* 120 */         this.oldActor.putSelfInGrid(gr, new Location(3, 15));
/* 121 */         this.oldActor = ((Actor)gr.get(new Location(11, 10)));
/* 122 */         putSelfInGrid(gr, new Location(11, 10));
/*     */       }
/* 125 */       else if (getLocation().equals(new Location(10, 10))) {
/* 126 */         removeSelfFromGrid();
/* 127 */         this.oldActor.putSelfInGrid(gr, new Location(10, 10));
/* 128 */         this.oldActor = ((Actor)gr.get(new Location(4, 15)));
/* 129 */         putSelfInGrid(gr, new Location(4, 15));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 134 */     if (getLocation().equals(location)) {
/* 135 */       if ((!this.world2) && (!this.switched)) {
/* 136 */         ((PokemonGrid)gr).fillWorld2();
/* 137 */         this.oldActor = ((Actor)gr.get(new Location(6, 19)));
/* 138 */         putSelfInGrid(gr, new Location(6, 19));
/* 139 */         this.world2 = true;
/* 140 */         this.switched = true;
/*     */       }
/*     */     }
/* 143 */     else if (getLocation().equals(rightLoc)) {
/* 144 */       if ((this.world2 == true) && (!this.switched)) {
/* 145 */         ((PokemonGrid)gr).fillWorld1();
/* 146 */         this.oldActor = ((Actor)gr.get(new Location(6, 0)));
/* 147 */         putSelfInGrid(gr, new Location(6, 0));
/* 148 */         this.world2 = false;
/* 149 */         this.switched = true;
/*     */       }
/*     */     } else this.switched = false;
/*     */ 
/* 153 */     this.idleMoveCount -= 1;
/*     */ 
/* 155 */     PokemonGenerator p = new PokemonGenerator(this.pokemonBag);
/*     */ 
/* 158 */     if (this.idleMoveCount <= 0) {
/* 159 */       JOptionPane.showMessageDialog(null, "You've Been Attacked!!!");
/* 160 */       PokeBattleInterfaceApp.battle(this.pokemonBag, p.gen());
/* 161 */       this.idleMoveCount = (int)(this.idleMoveCount + (1.0D + Math.random() * 1000.0D));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Trainer.Trainer
 * JD-Core Version:    0.6.0
 */