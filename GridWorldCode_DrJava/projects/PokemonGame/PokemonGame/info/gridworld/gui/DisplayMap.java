/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.util.HashMap;
/*     */ import javax.swing.Icon;
/*     */ 
/*     */ public class DisplayMap
/*     */ {
/*     */   private HashMap<Class, Display> map;
/*     */   private Display defaultDisplay;
/*     */ 
/*     */   public DisplayMap()
/*     */   {
/*  40 */     this.map = new HashMap();
/*  41 */     this.defaultDisplay = new DefaultDisplay();
/*     */   }
/*     */ 
/*     */   private Display createDisplay(Class cl)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       String className = cl.getName();
/*  55 */       Class dcl = Class.forName(className + "Display");
/*  56 */       if (Display.class.isAssignableFrom(dcl))
/*     */       {
/*  58 */         Display display = (Display)dcl.newInstance();
/*  59 */         this.map.put(cl, display);
/*  60 */         return display;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  70 */       ImageDisplay display = new ImageDisplay(cl);
/*  71 */       this.map.put(cl, display);
/*  72 */       return display;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */   public Display findDisplayFor(Class cl)
/*     */   {
/*  91 */     if (cl == Object.class)
/*  92 */       return this.defaultDisplay;
/*  93 */     Display display = (Display)this.map.get(cl);
/*  94 */     if (display != null)
/*  95 */       return display;
/*  96 */     display = createDisplay(cl);
/*  97 */     if (display != null)
/*     */     {
/*  99 */       this.map.put(cl, display);
/* 100 */       return display;
/*     */     }
/* 102 */     display = findDisplayFor(cl.getSuperclass());
/* 103 */     this.map.put(cl, display);
/* 104 */     return display;
/*     */   }
/*     */ 
/*     */   public Icon getIcon(Class cl, int w, int h)
/*     */   {
/* 116 */     return new DisplayIcon(cl, w, h);
/*     */   }
/*     */   private class DisplayIcon implements Icon {
/*     */     private Display displayObj;
/*     */     private int width;
/*     */     private int height;
/*     */ 
/* 126 */     public DisplayIcon(Class cl, int w, int h) { this.displayObj = DisplayMap.this.findDisplayFor(cl);
/* 127 */       this.width = w;
/* 128 */       this.height = h;
/*     */     }
/*     */ 
/*     */     public int getIconWidth()
/*     */     {
/* 133 */       return this.width;
/*     */     }
/*     */ 
/*     */     public int getIconHeight()
/*     */     {
/* 138 */       return this.height;
/*     */     }
/*     */ 
/*     */     public void paintIcon(Component comp, Graphics g, int x, int y)
/*     */     {
/* 143 */       Graphics2D g2 = (Graphics2D)g;
/* 144 */       AffineTransform savedTransform = g2.getTransform();
/* 145 */       this.displayObj.draw(null, comp, g2, new Rectangle(x, y, getIconWidth(), getIconHeight()));
/*     */ 
/* 147 */       g2.setTransform(savedTransform);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.DisplayMap
 * JD-Core Version:    0.6.0
 */