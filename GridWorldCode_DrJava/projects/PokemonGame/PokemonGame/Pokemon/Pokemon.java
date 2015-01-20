/*     */ package Pokemon;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public abstract class Pokemon
/*     */ {
/*     */   protected String name;
/*     */   protected String type;
/*     */   protected ArrayList<Attack> attacks;
/*     */   protected int level;
/*     */   protected int maxHP;
/*     */   protected int remainHP;
/*     */   protected int attack;
/*     */   protected int defense;
/*     */   protected int speed;
/*     */   protected int sattack;
/*     */   protected int sdefense;
/*     */   protected int exp;
/*     */   protected int expNext;
/*     */   protected int baseHP;
/*     */   protected int baseAtk;
/*     */   protected int baseDef;
/*     */   protected int baseSAtk;
/*     */   protected int baseSDef;
/*     */   protected int baseSpd;
/*     */   protected int baseEXP;
/*     */   protected double accuracy;
/*     */   protected boolean fainted;
/*  13 */   protected double[][] typeMult = { { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.5D, 1.0D, 0.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D }, { 2.0D, 1.0D, 0.5D, 0.5D, 1.0D, 2.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.5D, 2.0D, 0.0D, 1.0D }, { 1.0D, 2.0D, 1.0D, 1.0D, 1.0D, 0.5D, 2.0D, 1.0D, 1.0D, 1.0D, 2.0D, 0.5D, 1.0D, 1.0D, 1.0D }, { 1.0D, 1.0D, 1.0D, 0.5D, 0.5D, 0.5D, 2.0D, 0.5D, 1.0D, 1.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D }, { 1.0D, 1.0D, 0.0D, 2.0D, 1.0D, 2.0D, 0.5D, 1.0D, 2.0D, 1.0D, 0.5D, 2.0D, 1.0D, 1.0D, 1.0D }, { 1.0D, 0.5D, 2.0D, 1.0D, 0.5D, 1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D, 2.0D, 1.0D }, { 1.0D, 0.5D, 0.5D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.5D, 1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 1.0D }, { 0.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.0D, 1.0D, 1.0D }, { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.5D, 2.0D, 1.0D, 0.5D, 0.5D, 2.0D, 1.0D, 1.0D, 2.0D, 0.5D }, { 1.0D, 1.0D, 1.0D, 1.0D, 2.0D, 2.0D, 1.0D, 1.0D, 2.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D, 0.5D }, { 1.0D, 1.0D, 0.5D, 0.5D, 2.0D, 2.0D, 0.5D, 1.0D, 0.5D, 2.0D, 0.5D, 1.0D, 1.0D, 1.0D, 0.5D }, { 1.0D, 1.0D, 2.0D, 1.0D, 0.0D, 1.0D, 1.0D, 1.0D, 1.0D, 2.0D, 0.5D, 0.5D, 1.0D, 1.0D, 0.5D }, { 1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.5D, 1.0D, 1.0D }, { 1.0D, 1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.5D, 2.0D, 1.0D, 1.0D, 0.5D, 2.0D }, { 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 2.0D } };
/*     */ 
/*     */   public Pokemon(int baseHP, int baseAtk, int baseDef, int baseSAtk, int baseSDef, int baseSpd, int baseEXP, int l, String t)
/*     */   {
/*  30 */     this.baseHP = baseHP;
/*  31 */     this.baseAtk = baseAtk;
/*  32 */     this.baseDef = baseDef;
/*  33 */     this.baseSAtk = baseSAtk;
/*  34 */     this.baseSDef = baseSDef;
/*  35 */     this.baseSpd = baseSpd;
/*  36 */     this.type = t;
/*  37 */     this.maxHP = (int)((2 * baseHP + 121.25D) * l / 100.0D + 10.0D);
/*  38 */     this.remainHP = this.maxHP;
/*  39 */     this.attack = (int)((2 * baseAtk + 121.25D) * l / 100.0D + 5.0D);
/*  40 */     this.defense = (int)((2 * baseDef + 121.25D) * l / 100.0D + 5.0D);
/*  41 */     this.sattack = (int)((2 * baseSAtk + 121.25D) * l / 100.0D + 5.0D);
/*  42 */     this.sdefense = (int)((2 * baseDef + 121.25D) * l / 100.0D + 5.0D);
/*  43 */     this.speed = (int)((2 * baseSpd + 121.25D) * l / 100.0D + 5.0D);
/*  44 */     this.exp = (int)(4.0D * Math.pow(l, 2.0D) / 5.0D);
/*  45 */     this.baseEXP = baseEXP;
/*  46 */     this.expNext = (int)(4.0D * Math.pow(l + 1, 2.0D) / 5.0D);
/*  47 */     this.level = l;
/*  48 */     this.fainted = false;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  52 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String nickname) {
/*  56 */     this.name = nickname;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  60 */     return this.type;
/*     */   }
/*     */ 
/*     */   public ArrayList<Attack> getAttacks() {
/*  64 */     return this.attacks;
/*     */   }
/*     */ 
/*     */   public void setAttacks(ArrayList<Attack> atk) {
/*  68 */     this.attacks = atk;
/*     */   }
/*     */ 
/*     */   public double getAccuracy() {
/*  72 */     return this.accuracy;
/*     */   }
/*     */ 
/*     */   public int getLevel() {
/*  76 */     return this.level;
/*     */   }
/*     */ 
/*     */   public int getHPMax() {
/*  80 */     return this.maxHP;
/*     */   }
/*     */ 
/*     */   public int getHPRemain() {
/*  84 */     return this.remainHP;
/*     */   }
/*     */ 
/*     */   public int getAttack() {
/*  88 */     return this.attack;
/*     */   }
/*     */ 
/*     */   public int getDefense() {
/*  92 */     return this.defense;
/*     */   }
/*     */ 
/*     */   public int getSpeed() {
/*  96 */     return this.speed;
/*     */   }
/*     */ 
/*     */   public int getSAttack() {
/* 100 */     return this.sattack;
/*     */   }
/*     */ 
/*     */   public int getSDefense() {
/* 104 */     return this.sdefense;
/*     */   }
/*     */ 
/*     */   public int getEXP() {
/* 108 */     return this.exp;
/*     */   }
/*     */ 
/*     */   public int getBaseEXP() {
/* 112 */     return this.baseEXP;
/*     */   }
/*     */ 
/*     */   public int getEXPNext() {
/* 116 */     return this.expNext;
/*     */   }
/*     */ 
/*     */   public void setEXPNext() {
/* 120 */     this.expNext = (int)(4.0D * Math.pow(this.level + 1, 2.0D) / 5.0D);
/*     */   }
/*     */ 
/*     */   public int getNextEXPAmount() {
/* 124 */     return this.expNext - this.exp;
/*     */   }
/*     */ 
/*     */   public int getEXPReceived() {
/* 128 */     return this.baseEXP * this.level / 7;
/*     */   }
/*     */ 
/*     */   public void levelUp() {
/* 132 */     this.level += 1;
/* 133 */     this.maxHP = (int)((2 * this.baseHP + 121.25D) * this.level / 100.0D + 10.0D);
/* 134 */     this.remainHP = this.maxHP;
/* 135 */     this.attack = (int)((2 * this.baseAtk + 121.25D) * this.level / 100.0D + 5.0D);
/* 136 */     this.defense = (int)((2 * this.baseDef + 121.25D) * this.level / 100.0D + 5.0D);
/* 137 */     this.sattack = (int)((2 * this.baseSAtk + 121.25D) * this.level / 100.0D + 5.0D);
/* 138 */     this.sdefense = (int)((2 * this.baseDef + 121.25D) * this.level / 100.0D + 5.0D);
/* 139 */     this.speed = (int)((2 * this.baseSpd + 121.25D) * this.level / 100.0D + 5.0D);
/* 140 */     setEXPNext();
/*     */   }
/*     */ 
/*     */   public void addEXP(Pokemon p) {
/* 144 */     if (p.getEXPReceived() > getNextEXPAmount()) {
/* 145 */       this.exp += p.getEXPReceived();
/* 146 */       while (this.expNext < this.exp) {
/* 147 */         levelUp();
/*     */       }
/*     */     }
/*     */ 
/* 151 */     this.exp += p.getEXPReceived();
/*     */   }
/*     */ 
/*     */   public void decrementHP(int amount) {
/* 155 */     this.remainHP -= amount;
/* 156 */     if (this.remainHP <= 0)
/* 157 */       this.fainted = true;
/*     */   }
/*     */ 
/*     */   private int convertType(String type) {
/* 161 */     if (type.equals("normal"))
/* 162 */       return 0;
/* 163 */     if (type.equals("fight"))
/* 164 */       return 1;
/* 165 */     if (type.equals("flying"))
/* 166 */       return 2;
/* 167 */     if (type.equals("poison"))
/* 168 */       return 3;
/* 169 */     if (type.equals("ground"))
/* 170 */       return 4;
/* 171 */     if (type.equals("rock"))
/* 172 */       return 5;
/* 173 */     if (type.equals("bug"))
/* 174 */       return 6;
/* 175 */     if (type.equals("ghost"))
/* 176 */       return 7;
/* 177 */     if (type.equals("fire"))
/* 178 */       return 8;
/* 179 */     if (type.equals("water"))
/* 180 */       return 9;
/* 181 */     if (type.equals("grass"))
/* 182 */       return 10;
/* 183 */     if (type.equals("electric"))
/* 184 */       return 11;
/* 185 */     if (type.equals("psychic"))
/* 186 */       return 12;
/* 187 */     if (type.equals("ice"))
/* 188 */       return 13;
/* 189 */     if (type.equals("dragon")) {
/* 190 */       return 14;
/*     */     }
/* 192 */     return 0;
/*     */   }
/*     */ 
/*     */   private double getWeakness(Attack a, Pokemon p) {
/* 196 */     String atype = a.getType().toLowerCase();
/* 197 */     String ptype = p.getType().toLowerCase();
/* 198 */     int row = convertType(atype);
/* 199 */     int col = convertType(ptype);
/* 200 */     return this.typeMult[row][col];
/*     */   }
/*     */ 
/*     */   public boolean HitMiss(Attack a) {
/* 204 */     boolean hit = a.HitMiss(this.accuracy);
/*     */ 
/* 206 */     return hit;
/*     */   }
/*     */ 
/*     */   public int fight(Attack a, Pokemon p)
/*     */   {
/* 212 */     double stab = 1.0D;
/* 213 */     double weakness = getWeakness(a, p);
/* 214 */     int damage = 0;
/* 215 */     if (getType().equals(a.getType()))
/* 216 */       stab = 1.5D;
/* 217 */     if (a.getSpecial())
/* 218 */       damage = (int)(((2.0D * this.level / 5.0D + 2.0D) * this.sattack * a.getStrength() / p.getSDefense() / 50.0D + 2.0D) * stab * weakness * Math.random() / 100.0D);
/*     */     else
/* 220 */       damage = (int)(((2.0D * this.level / 5.0D + 2.0D) * this.attack * a.getStrength() / p.getDefense() / 50.0D + 2.0D) * stab * weakness * Math.random() / 100.0D);
/* 221 */     return damage;
/*     */   }
/*     */   public void revive() {
/* 224 */     this.remainHP = this.maxHP;
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     Pokemon.Pokemon
 * JD-Core Version:    0.6.0
 */