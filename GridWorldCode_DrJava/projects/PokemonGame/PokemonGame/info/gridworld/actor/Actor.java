/*     */ package info.gridworld.actor;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import java.awt.Color;
/*     */ 
/*     */ public class Actor
/*     */ {
/*     */   private Grid<Actor> grid;
/*     */   private Location location;
/*     */   private int direction;
/*     */   private Color color;
/*     */ 
/*     */   public Actor()
/*     */   {
/*  41 */     this.color = Color.BLUE;
/*  42 */     this.direction = 0;
/*  43 */     this.grid = null;
/*  44 */     this.location = null;
/*     */   }
/*     */ 
/*     */   public Color getColor()
/*     */   {
/*  53 */     return this.color;
/*     */   }
/*     */ 
/*     */   public void setColor(Color newColor)
/*     */   {
/*  62 */     this.color = newColor;
/*     */   }
/*     */ 
/*     */   public int getDirection()
/*     */   {
/*  71 */     return this.direction;
/*     */   }
/*     */ 
/*     */   public void setDirection(int newDirection)
/*     */   {
/*  82 */     this.direction = (newDirection % 360);
/*  83 */     if (this.direction < 0)
/*  84 */       this.direction += 360;
/*     */   }
/*     */ 
/*     */   public Grid<Actor> getGrid()
/*     */   {
/*  94 */     return this.grid;
/*     */   }
/*     */ 
/*     */   public Location getLocation()
/*     */   {
/* 104 */     return this.location;
/*     */   }
/*     */ 
/*     */   public void putSelfInGrid(Grid<Actor> gr, Location loc)
/*     */   {
/* 117 */     if (this.grid != null) {
/* 118 */       throw new IllegalStateException("This actor is already contained in a grid.");
/*     */     }
/*     */ 
/* 121 */     Actor actor = (Actor)gr.get(loc);
/* 122 */     if (actor != null)
/* 123 */       actor.removeSelfFromGrid();
/* 124 */     gr.put(loc, this);
/* 125 */     this.grid = gr;
/* 126 */     this.location = loc;
/*     */   }
/*     */ 
/*     */   public void removeSelfFromGrid()
/*     */   {
/* 135 */     if (this.grid == null) {
/* 136 */       throw new IllegalStateException("This actor is not contained in a grid.");
/*     */     }
/* 138 */     if (this.grid.get(this.location) != this) {
/* 139 */       throw new IllegalStateException("The grid contains a different actor at location " + this.location + ".");
/*     */     }
/*     */ 
/* 143 */     this.grid.remove(this.location);
/* 144 */     this.grid = null;
/* 145 */     this.location = null;
/*     */   }
/*     */ 
/*     */   public void moveTo(Location newLocation)
/*     */   {
/* 157 */     if (this.grid == null)
/* 158 */       throw new IllegalStateException("This actor is not in a grid.");
/* 159 */     if (this.grid.get(this.location) != this) {
/* 160 */       throw new IllegalStateException("The grid contains a different actor at location " + this.location + ".");
/*     */     }
/*     */ 
/* 163 */     if (!this.grid.isValid(newLocation)) {
/* 164 */       throw new IllegalArgumentException("Location " + newLocation + " is not valid.");
/*     */     }
/*     */ 
/* 167 */     if (newLocation.equals(this.location))
/* 168 */       return;
/* 169 */     this.grid.remove(this.location);
/* 170 */     Actor other = (Actor)this.grid.get(newLocation);
/* 171 */     if (other != null)
/* 172 */       other.removeSelfFromGrid();
/* 173 */     this.location = newLocation;
/* 174 */     this.grid.put(this.location, this);
/*     */   }
/*     */ 
/*     */   public void act()
/*     */   {
/* 184 */     setDirection(getDirection() + 180);
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 193 */     return getClass().getName() + "[location=" + this.location + ",direction=" + this.direction + ",color=" + this.color + "]";
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.actor.Actor
 * JD-Core Version:    0.6.0
 */