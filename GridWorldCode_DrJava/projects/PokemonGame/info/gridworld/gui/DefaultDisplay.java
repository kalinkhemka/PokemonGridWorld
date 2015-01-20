/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.LineMetrics;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ 
/*     */ public class DefaultDisplay
/*     */   implements Display
/*     */ {
/*     */   private static final int MAX_TEXT_LENGTH = 8;
/*     */ 
/*     */   public void draw(Object obj, Component comp, Graphics2D g2, Rectangle rect)
/*     */   {
/*  58 */     Color color = (Color)AbstractDisplay.getProperty(obj, "color");
/*  59 */     if ((color == null) && ((obj instanceof Color)))
/*  60 */       color = (Color)obj;
/*  61 */     Color textColor = (Color)AbstractDisplay.getProperty(obj, "textColor");
/*  62 */     if (textColor == null) textColor = Color.BLACK;
/*  63 */     if (color != null)
/*     */     {
/*  65 */       g2.setPaint(color);
/*  66 */       g2.fill(rect);
/*     */ 
/*  68 */       if (color.equals(textColor))
/*     */       {
/*  70 */         textColor = new Color(255 - textColor.getRed(), 255 - textColor.getGreen(), 255 - textColor.getBlue());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  76 */     String text = (String)AbstractDisplay.getProperty(obj, "text");
/*  77 */     if ((text == null) && (!(obj instanceof Color)))
/*     */     {
/*  79 */       text = "" + obj;
/*     */     }
/*  81 */     if (text == null) return;
/*  82 */     if (text.length() > 8)
/*  83 */       text = text.substring(0, 8) + "...";
/*  84 */     paintCenteredText(g2, text, rect, 0.8D, textColor);
/*     */   }
/*     */ 
/*     */   protected void paintCenteredText(Graphics2D g2, String s, Rectangle rect, double fontHeight, Color color)
/*     */   {
/*  99 */     g2 = (Graphics2D)g2.create();
/* 100 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/* 102 */     g2.setPaint(color);
/* 103 */     Rectangle2D bounds = null;
/* 104 */     LineMetrics lm = null;
/* 105 */     boolean done = false;
/*     */ 
/* 107 */     while (!done)
/*     */     {
/* 109 */       g2.setFont(new Font("SansSerif", 1, (int)(fontHeight * rect.height)));
/*     */ 
/* 111 */       FontRenderContext frc = g2.getFontRenderContext();
/* 112 */       bounds = g2.getFont().getStringBounds(s, frc);
/* 113 */       if (bounds.getWidth() > rect.getWidth()) {
/* 114 */         fontHeight = fontHeight * Math.sqrt(2.0D) / 2.0D;
/*     */       }
/*     */       else {
/* 117 */         done = true;
/* 118 */         lm = g2.getFont().getLineMetrics(s, frc);
/*     */       }
/*     */     }
/* 121 */     float centerX = rect.x + rect.width / 2;
/* 122 */     float centerY = rect.y + rect.height / 2;
/* 123 */     float leftX = centerX - (float)bounds.getWidth() / 2.0F;
/* 124 */     float baselineY = centerY - lm.getHeight() / 2.0F + lm.getAscent();
/* 125 */     g2.drawString(s, leftX, baselineY);
/* 126 */     g2.dispose();
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.DefaultDisplay
 * JD-Core Version:    0.6.0
 */