/*     */ package info.gridworld.grid;
/*     */ 
/*     */ public class Location
/*     */   implements Comparable
/*     */ {
/*     */   private int row;
/*     */   private int col;
/*     */   public static final int LEFT = -90;
/*     */   public static final int RIGHT = 90;
/*     */   public static final int HALF_LEFT = -45;
/*     */   public static final int HALF_RIGHT = 45;
/*     */   public static final int FULL_CIRCLE = 360;
/*     */   public static final int HALF_CIRCLE = 180;
/*     */   public static final int AHEAD = 0;
/*     */   public static final int NORTH = 0;
/*     */   public static final int NORTHEAST = 45;
/*     */   public static final int EAST = 90;
/*     */   public static final int SOUTHEAST = 135;
/*     */   public static final int SOUTH = 180;
/*     */   public static final int SOUTHWEST = 225;
/*     */   public static final int WEST = 270;
/*     */   public static final int NORTHWEST = 315;
/*     */ 
/*     */   public Location(int r, int c)
/*     */   {
/* 102 */     this.row = r;
/* 103 */     this.col = c;
/*     */   }
/*     */ 
/*     */   public int getRow()
/*     */   {
/* 112 */     return this.row;
/*     */   }
/*     */ 
/*     */   public int getCol()
/*     */   {
/* 121 */     return this.col;
/*     */   }
/*     */ 
/*     */   public Location getAdjacentLocation(int direction)
/*     */   {
/* 133 */     int adjustedDirection = (direction + 22) % 360;
/* 134 */     if (adjustedDirection < 0) {
/* 135 */       adjustedDirection += 360;
/*     */     }
/* 137 */     adjustedDirection = adjustedDirection / 45 * 45;
/* 138 */     int dc = 0;
/* 139 */     int dr = 0;
/* 140 */     if (adjustedDirection == 90) {
/* 141 */       dc = 1;
/* 142 */     } else if (adjustedDirection == 135)
/*     */     {
/* 144 */       dc = 1;
/* 145 */       dr = 1;
/*     */     }
/* 147 */     else if (adjustedDirection == 180) {
/* 148 */       dr = 1;
/* 149 */     } else if (adjustedDirection == 225)
/*     */     {
/* 151 */       dc = -1;
/* 152 */       dr = 1;
/*     */     }
/* 154 */     else if (adjustedDirection == 270) {
/* 155 */       dc = -1;
/* 156 */     } else if (adjustedDirection == 315)
/*     */     {
/* 158 */       dc = -1;
/* 159 */       dr = -1;
/*     */     }
/* 161 */     else if (adjustedDirection == 0) {
/* 162 */       dr = -1;
/* 163 */     } else if (adjustedDirection == 45)
/*     */     {
/* 165 */       dc = 1;
/* 166 */       dr = -1;
/*     */     }
/* 168 */     return new Location(getRow() + dr, getCol() + dc);
/*     */   }
/*     */ 
/*     */   public int getDirectionToward(Location target)
/*     */   {
/* 180 */     int dx = target.getCol() - getCol();
/* 181 */     int dy = target.getRow() - getRow();
/*     */ 
/* 183 */     int angle = (int)Math.toDegrees(Math.atan2(-dy, dx));
/*     */ 
/* 187 */     int compassAngle = 90 - angle;
/*     */ 
/* 189 */     compassAngle += 22;
/*     */ 
/* 191 */     if (compassAngle < 0) {
/* 192 */       compassAngle += 360;
/*     */     }
/* 194 */     return compassAngle / 45 * 45;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 207 */     if (!(other instanceof Location)) {
/* 208 */       return false;
/*     */     }
/* 210 */     Location otherLoc = (Location)other;
/* 211 */     return (getRow() == otherLoc.getRow()) && (getCol() == otherLoc.getCol());
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 220 */     return getRow() * 3737 + getCol();
/*     */   }
/*     */ 
/*     */   public int compareTo(Object other)
/*     */   {
/* 236 */     Location otherLoc = (Location)other;
/* 237 */     if (getRow() < otherLoc.getRow())
/* 238 */       return -1;
/* 239 */     if (getRow() > otherLoc.getRow())
/* 240 */       return 1;
/* 241 */     if (getCol() < otherLoc.getCol())
/* 242 */       return -1;
/* 243 */     if (getCol() > otherLoc.getCol())
/* 244 */       return 1;
/* 245 */     return 0;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 255 */     return "(" + getRow() + ", " + getCol() + ")";
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.grid.Location
 * JD-Core Version:    0.6.0
 */