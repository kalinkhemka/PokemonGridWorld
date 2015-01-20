/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JComboBox;
/*     */ 
/*     */ public class ColorEditor extends PropertyEditorSupport
/*     */ {
/*     */   private JComboBox combo;
/* 141 */   private static Color[] colorValues = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
/*     */ 
/* 150 */   private static ColorIcon[] colorIcons = new ColorIcon[colorValues.length + 1];
/*     */ 
/*     */   public ColorEditor()
/*     */   {
/*  39 */     this.combo = new JComboBox(colorIcons);
/*     */   }
/*     */ 
/*     */   public Object getValue()
/*     */   {
/*  44 */     ColorIcon value = (ColorIcon)this.combo.getSelectedItem();
/*  45 */     return value.getColor();
/*     */   }
/*     */ 
/*     */   public boolean supportsCustomEditor()
/*     */   {
/*  50 */     return true;
/*     */   }
/*     */ 
/*     */   public Component getCustomEditor()
/*     */   {
/*  55 */     this.combo.setSelectedItem(Integer.valueOf(0));
/*  56 */     return this.combo;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 151 */     colorIcons[0] = new RandomColorIcon(null);
/* 152 */     for (int i = 0; i < colorValues.length; i++)
/* 153 */       colorIcons[(i + 1)] = new SolidColorIcon(colorValues[i]);
/*     */   }
/*     */ 
/*     */   private static class RandomColorIcon
/*     */     implements ColorEditor.ColorIcon
/*     */   {
/*     */     public Color getColor()
/*     */     {
/* 108 */       return new Color((int)(Math.random() * 256.0D * 256.0D * 256.0D));
/*     */     }
/*     */ 
/*     */     public int getIconWidth()
/*     */     {
/* 113 */       return 120;
/*     */     }
/*     */ 
/*     */     public int getIconHeight()
/*     */     {
/* 118 */       return 20;
/*     */     }
/*     */ 
/*     */     public void paintIcon(Component c, Graphics g, int x, int y)
/*     */     {
/* 123 */       Rectangle r = new Rectangle(x, y, 119, 19);
/* 124 */       Graphics2D g2 = (Graphics2D)g;
/* 125 */       Color oldColor = g2.getColor();
/* 126 */       Rectangle r1 = new Rectangle(x, y, 30, 19);
/* 127 */       for (int i = 0; i < 4; i++)
/*     */       {
/* 129 */         g2.setColor(getColor());
/* 130 */         g2.fill(r1);
/* 131 */         r1.translate(30, 0);
/*     */       }
/* 133 */       g2.setColor(Color.BLACK);
/* 134 */       g2.draw(r);
/* 135 */       g2.setColor(oldColor);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static class SolidColorIcon
/*     */     implements ColorEditor.ColorIcon
/*     */   {
/*     */     private Color color;
/*     */ 
/*     */     public Color getColor()
/*     */     {
/*  73 */       return this.color;
/*     */     }
/*     */ 
/*     */     public SolidColorIcon(Color c)
/*     */     {
/*  78 */       this.color = c;
/*     */     }
/*     */ 
/*     */     public int getIconWidth()
/*     */     {
/*  83 */       return 120;
/*     */     }
/*     */ 
/*     */     public int getIconHeight()
/*     */     {
/*  88 */       return 20;
/*     */     }
/*     */ 
/*     */     public void paintIcon(Component c, Graphics g, int x, int y)
/*     */     {
/*  93 */       Rectangle r = new Rectangle(x, y, 119, 19);
/*  94 */       Graphics2D g2 = (Graphics2D)g;
/*  95 */       Color oldColor = g2.getColor();
/*  96 */       g2.setColor(this.color);
/*  97 */       g2.fill(r);
/*  98 */       g2.setColor(Color.BLACK);
/*  99 */       g2.draw(r);
/* 100 */       g2.setColor(oldColor);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static abstract interface ColorIcon extends Icon
/*     */   {
/*     */     public static final int WIDTH = 120;
/*     */     public static final int HEIGHT = 20;
/*     */ 
/*     */     public abstract Color getColor();
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.ColorEditor
 * JD-Core Version:    0.6.0
 */