/*     */ package PokemonGrid;
/*     */ 
/*     */ import info.gridworld.grid.BoundedGrid;
/*     */ import info.gridworld.grid.Location;
/*     */ 
/*     */ public class PokemonGrid extends BoundedGrid
/*     */ {
/*     */   public PokemonGrid()
/*     */   {
/*  10 */     super(20, 20);
/*     */   }
/*     */ 
/*     */   public void fillWorld1()
/*     */   {
/*  16 */     for (int i = 0; i < getNumRows(); i++)
/*     */     {
/*  18 */       for (int j = 0; j < getNumCols(); j++)
/*     */       {
/*  20 */         putIn(new Location(i, j), new Green());
/*     */       }
/*     */     }
/*     */ 
/*  24 */     for (int i = 0; i < 5; i++)
/*     */     {
/*  26 */       for (int j = 0; j < 9; j++)
/*     */       {
/*  28 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/*  32 */     for (int i = 9; i < getNumCols(); i++)
/*     */     {
/*  34 */       putIn(new Location(0, i), new TallGrass());
/*     */     }
/*     */ 
/*  37 */     for (int i = 9; i < getNumCols(); i++)
/*     */     {
/*  39 */       putIn(new Location(getNumRows() - 1, i), new TallGrass());
/*     */     }
/*     */ 
/*  42 */     for (int i = 0; i < getNumCols(); i++)
/*     */     {
/*  44 */       putIn(new Location(6, i), new Path());
/*     */     }
/*  46 */     for (int i = 2; i < getNumRows() - 2; i++)
/*     */     {
/*  48 */       putIn(new Location(i, 10), new Path());
/*     */     }
/*     */ 
/*  52 */     putIn(new Location(1, 12), new WaterCorner(0));
/*  53 */     putIn(new Location(2, 12), new WaterSide(0));
/*  54 */     putIn(new Location(3, 12), new WaterSide(0));
/*  55 */     putIn(new Location(4, 12), new WaterCorner(270));
/*  56 */     for (int i = 13; i < 20; i++)
/*     */     {
/*  58 */       putIn(new Location(1, i), new WaterSide(90));
/*  59 */       putIn(new Location(2, i), new Water());
/*  60 */       putIn(new Location(3, i), new Water());
/*  61 */       putIn(new Location(4, i), new WaterSide(270));
/*     */     }
/*     */ 
/*  65 */     for (int i = 2; i < 15; i++)
/*     */     {
/*  67 */       putIn(new Location(i, 15), new Path());
/*     */     }
/*  69 */     putIn(new Location(2, 14), new Path());
/*  70 */     putIn(new Location(2, 16), new Path());
/*  71 */     putIn(new Location(3, 14), new Path());
/*  72 */     putIn(new Location(3, 16), new Path());
/*     */ 
/*  75 */     for (int i = 8; i < getNumRows(); i++)
/*     */     {
/*  77 */       for (int j = 0; j < 9; j++)
/*     */       {
/*  79 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/*  83 */     putIn(new Location(11, 0), new WaterCorner(0));
/*  84 */     for (int i = 12; i < getNumRows() - 1; i++)
/*     */     {
/*  86 */       putIn(new Location(i, 0), new WaterSide(0));
/*     */     }
/*  88 */     putIn(new Location(getNumRows() - 1, 0), new WaterCorner(270));
/*  89 */     for (int i = 1; i < 5; i++)
/*     */     {
/*  91 */       putIn(new Location(11, i), new WaterSide(90));
/*  92 */       for (int j = 12; j < getNumRows() - 1; j++)
/*     */       {
/*  94 */         putIn(new Location(j, i), new Water());
/*     */       }
/*  96 */       putIn(new Location(getNumRows() - 1, i), new WaterSide(270));
/*     */     }
/*  98 */     putIn(new Location(11, 5), new WaterCorner(90));
/*  99 */     for (int i = 12; i < getNumRows() - 1; i++)
/*     */     {
/* 101 */       putIn(new Location(i, 5), new WaterSide(180));
/*     */     }
/* 103 */     putIn(new Location(getNumRows() - 1, 5), new WaterCorner(180));
/*     */ 
/* 105 */     for (int i = 8; i < getNumRows(); i++)
/*     */     {
/* 107 */       putIn(new Location(i, 12), new TallGrass());
/* 108 */       putIn(new Location(i, 13), new TallGrass());
/* 109 */       putIn(new Location(i, 17), new TallGrass());
/* 110 */       putIn(new Location(i, 18), new TallGrass());
/* 111 */       putIn(new Location(i, 19), new TallGrass());
/*     */     }
/* 113 */     for (int i = 16; i < getNumRows(); i++)
/*     */     {
/* 115 */       putIn(new Location(i, 14), new TallGrass());
/* 116 */       putIn(new Location(i, 15), new TallGrass());
/* 117 */       putIn(new Location(i, 16), new TallGrass());
/*     */     }
/*     */ 
/* 120 */     putIn(new Location(17, 15), new WaterCorner(0));
/* 121 */     putIn(new Location(17, 16), new WaterSide(90));
/* 122 */     putIn(new Location(17, 17), new WaterCorner(90));
/* 123 */     putIn(new Location(18, 15), new WaterCorner(270));
/* 124 */     putIn(new Location(18, 16), new WaterSide(270));
/* 125 */     putIn(new Location(18, 17), new WaterCorner(180));
/*     */   }
/*     */ 
/*     */   public void fillWorld2()
/*     */   {
/* 131 */     for (int i = 0; i < getNumRows(); i++)
/*     */     {
/* 133 */       for (int j = 0; j < getNumCols(); j++)
/*     */       {
/* 135 */         putIn(new Location(i, j), new Green());
/*     */       }
/*     */     }
/*     */ 
/* 139 */     for (int i = 0; i < 5; i++)
/*     */     {
/* 141 */       for (int j = 0; j < 10; j++)
/*     */       {
/* 143 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/* 147 */     for (int i = 8; i < getNumRows(); i++)
/*     */     {
/* 149 */       for (int j = 16; j < getNumCols(); j++)
/*     */       {
/* 151 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/* 155 */     for (int i = 0; i < 6; i++)
/*     */     {
/* 157 */       for (int j = 12; j < 19; j++)
/*     */       {
/* 159 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/* 163 */     putIn(new Location(5, 15), new Path());
/*     */ 
/* 165 */     for (int i = 7; i < 13; i++)
/*     */     {
/* 167 */       for (int j = 7; j < 15; j++)
/*     */       {
/* 169 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/* 173 */     for (int i = 8; i < getNumRows(); i++)
/*     */     {
/* 175 */       for (int j = 0; j < 5; j++)
/*     */       {
/* 177 */         putIn(new Location(i, j), new TallGrass());
/*     */       }
/*     */     }
/*     */ 
/* 181 */     for (int i = 0; i < getNumCols(); i++)
/*     */     {
/* 183 */       putIn(new Location(6, i), new Path());
/*     */     }
/*     */ 
/* 186 */     for (int i = 0; i < 6; i++)
/*     */     {
/* 188 */       putIn(new Location(i, 11), new Path());
/*     */     }
/* 190 */     for (int i = 0; i < 6; i++)
/*     */     {
/* 192 */       putIn(new Location(i, getNumCols() - 1), new Path());
/*     */     }
/*     */ 
/* 195 */     for (int j = 6; j < 14; j++)
/*     */     {
/* 197 */       putIn(new Location(j, 6), new Path());
/*     */     }
/*     */ 
/* 200 */     for (int j = 6; j < 14; j++)
/*     */     {
/* 202 */       putIn(new Location(j, 14), new Path());
/*     */     }
/*     */ 
/* 205 */     for (int i = 6; i < 15; i++)
/*     */     {
/* 207 */       putIn(new Location(13, i), new Path());
/*     */     }
/* 209 */     putIn(new Location(12, 10), new Path());
/*     */ 
/* 211 */     putIn(new Location(1, 0), new WaterCorner(90));
/* 212 */     putIn(new Location(2, 0), new WaterSide(180));
/* 213 */     putIn(new Location(3, 0), new WaterSide(180));
/* 214 */     putIn(new Location(4, 0), new WaterCorner(180));
/*     */ 
/* 216 */     putIn(new Location(8, 8), new Cave11());
/* 217 */     putIn(new Location(8, 9), new Cave12());
/* 218 */     putIn(new Location(8, 10), new Cave13());
/* 219 */     putIn(new Location(8, 11), new Cave14());
/* 220 */     putIn(new Location(8, 12), new Cave15());
/* 221 */     putIn(new Location(9, 8), new Cave21());
/* 222 */     putIn(new Location(9, 9), new Cave22());
/* 223 */     putIn(new Location(9, 10), new Cave23());
/* 224 */     putIn(new Location(9, 11), new Cave24());
/* 225 */     putIn(new Location(9, 12), new Cave25());
/* 226 */     putIn(new Location(10, 8), new Cave31());
/* 227 */     putIn(new Location(10, 9), new Cave32());
/* 228 */     putIn(new Location(10, 10), new Cave33());
/* 229 */     putIn(new Location(10, 11), new Cave34());
/* 230 */     putIn(new Location(10, 12), new Cave35());
/* 231 */     putIn(new Location(11, 8), new Cave41());
/* 232 */     putIn(new Location(11, 9), new Cave42());
/* 233 */     putIn(new Location(11, 10), new Cave43());
/* 234 */     putIn(new Location(11, 11), new Cave44());
/* 235 */     putIn(new Location(11, 12), new Cave45());
/*     */ 
/* 237 */     putIn(new Location(1, 13), new Cave11());
/* 238 */     putIn(new Location(1, 14), new Cave12());
/* 239 */     putIn(new Location(1, 15), new Cave13());
/* 240 */     putIn(new Location(1, 16), new Cave14());
/* 241 */     putIn(new Location(1, 17), new Cave15());
/* 242 */     putIn(new Location(2, 13), new Cave21());
/* 243 */     putIn(new Location(2, 14), new Cave22());
/* 244 */     putIn(new Location(2, 15), new Cave23());
/* 245 */     putIn(new Location(2, 16), new Cave24());
/* 246 */     putIn(new Location(2, 17), new Cave25());
/* 247 */     putIn(new Location(3, 13), new Cave31());
/* 248 */     putIn(new Location(3, 14), new Cave32());
/* 249 */     putIn(new Location(3, 15), new Cave33());
/* 250 */     putIn(new Location(3, 16), new Cave34());
/* 251 */     putIn(new Location(3, 17), new Cave35());
/* 252 */     putIn(new Location(4, 13), new Cave41());
/* 253 */     putIn(new Location(4, 14), new Cave42());
/* 254 */     putIn(new Location(4, 15), new Cave43());
/* 255 */     putIn(new Location(4, 16), new Cave44());
/* 256 */     putIn(new Location(4, 17), new Cave45());
/*     */ 
/* 258 */     for (int i = 0; i < getNumCols(); i++)
/*     */     {
/* 260 */       putIn(new Location(14, i), new TallGrass());
/*     */     }
/*     */ 
/* 263 */     putIn(new Location(15, 5), new WaterCorner(0));
/* 264 */     for (int i = 16; i < getNumRows() - 1; i++)
/*     */     {
/* 266 */       putIn(new Location(i, 5), new WaterSide(0));
/*     */     }
/* 268 */     putIn(new Location(getNumRows() - 1, 5), new WaterCorner(270));
/* 269 */     for (int i = 6; i < getNumCols() - 1; i++)
/*     */     {
/* 271 */       putIn(new Location(15, i), new WaterSide(90));
/* 272 */       for (int j = 16; j < getNumRows() - 1; j++)
/*     */       {
/* 274 */         putIn(new Location(j, i), new Water());
/*     */       }
/* 276 */       putIn(new Location(getNumRows() - 1, i), new WaterSide(270));
/*     */     }
/* 278 */     putIn(new Location(15, getNumCols() - 1), new WaterCorner(90));
/* 279 */     for (int i = 16; i < getNumRows() - 1; i++)
/*     */     {
/* 281 */       putIn(new Location(i, getNumCols() - 1), new WaterSide(180));
/*     */     }
/* 283 */     putIn(new Location(getNumRows() - 1, getNumCols() - 1), new WaterCorner(180));
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, WaterCorner a)
/*     */   {
/* 290 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, WaterSide a) {
/* 294 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Water a) {
/* 298 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Path a) {
/* 302 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Green a) {
/* 306 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, TallGrass a) {
/* 310 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave11 a) {
/* 314 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave12 a) {
/* 318 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave13 a) {
/* 322 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave14 a) {
/* 326 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave15 a) {
/* 330 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave21 a) {
/* 334 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave22 a) {
/* 338 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave23 a) {
/* 342 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave24 a) {
/* 346 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave25 a) {
/* 350 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave31 a) {
/* 354 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave32 a) {
/* 358 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave33 a) {
/* 362 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave34 a) {
/* 366 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave35 a) {
/* 370 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave41 a) {
/* 374 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave42 a) {
/* 378 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave43 a) {
/* 382 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave44 a) {
/* 386 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ 
/*     */   public void putIn(Location loc, Cave45 a) {
/* 390 */     a.putSelfInGrid(this, loc);
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     PokemonGrid.PokemonGrid
 * JD-Core Version:    0.6.0
 */