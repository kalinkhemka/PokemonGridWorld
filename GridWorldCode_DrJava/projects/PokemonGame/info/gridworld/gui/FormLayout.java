/*    */ package info.gridworld.gui;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Insets;
/*    */ import java.awt.LayoutManager;
/*    */ 
/*    */ public class FormLayout
/*    */   implements LayoutManager
/*    */ {
/*    */   private int left;
/*    */   private int right;
/*    */   private int height;
/*    */   private static final int GAP = 6;
/*    */ 
/*    */   public Dimension preferredLayoutSize(Container parent)
/*    */   {
/* 31 */     Component[] components = parent.getComponents();
/* 32 */     this.left = 0;
/* 33 */     this.right = 0;
/* 34 */     this.height = 0;
/* 35 */     for (int i = 0; i < components.length; i += 2)
/*    */     {
/* 37 */       Component cleft = components[i];
/* 38 */       Component cright = components[(i + 1)];
/*    */ 
/* 40 */       Dimension dleft = cleft.getPreferredSize();
/* 41 */       Dimension dright = cright.getPreferredSize();
/* 42 */       this.left = Math.max(this.left, dleft.width);
/* 43 */       this.right = Math.max(this.right, dright.width);
/* 44 */       this.height += Math.max(dleft.height, dright.height);
/*    */     }
/* 46 */     return new Dimension(this.left + 6 + this.right, this.height);
/*    */   }
/*    */ 
/*    */   public Dimension minimumLayoutSize(Container parent)
/*    */   {
/* 51 */     return preferredLayoutSize(parent);
/*    */   }
/*    */ 
/*    */   public void layoutContainer(Container parent)
/*    */   {
/* 56 */     preferredLayoutSize(parent);
/*    */ 
/* 58 */     Component[] components = parent.getComponents();
/*    */ 
/* 60 */     Insets insets = parent.getInsets();
/* 61 */     int xcenter = insets.left + this.left;
/* 62 */     int y = insets.top;
/*    */ 
/* 64 */     for (int i = 0; i < components.length; i += 2)
/*    */     {
/* 66 */       Component cleft = components[i];
/* 67 */       Component cright = components[(i + 1)];
/*    */ 
/* 69 */       Dimension dleft = cleft.getPreferredSize();
/* 70 */       Dimension dright = cright.getPreferredSize();
/*    */ 
/* 72 */       int height = Math.max(dleft.height, dright.height);
/*    */ 
/* 74 */       cleft.setBounds(xcenter - dleft.width, y + (height - dleft.height) / 2, dleft.width, dleft.height);
/*    */ 
/* 77 */       cright.setBounds(xcenter + 6, y + (height - dright.height) / 2, dright.width, dright.height);
/*    */ 
/* 79 */       y += height;
/*    */     }
/*    */   }
/*    */ 
/*    */   public void addLayoutComponent(String name, Component comp)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void removeLayoutComponent(Component comp)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.FormLayout
 * JD-Core Version:    0.6.0
 */