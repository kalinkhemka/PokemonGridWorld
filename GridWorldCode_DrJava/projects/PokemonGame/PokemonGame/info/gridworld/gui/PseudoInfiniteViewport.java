/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Point;
/*     */ import javax.swing.JScrollBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JViewport;
/*     */ 
/*     */ public class PseudoInfiniteViewport extends JViewport
/*     */ {
/*     */   private JScrollPane scrollParent;
/*  52 */   private Point panPoint = new Point(0, 0);
/*     */ 
/*     */   public PseudoInfiniteViewport(JScrollPane parent)
/*     */   {
/*  60 */     this.scrollParent = parent;
/*  61 */     setBackground(Color.lightGray);
/*     */   }
/*     */ 
/*     */   public void setViewPosition(Point pt)
/*     */   {
/*  71 */     boolean isAdjusting = (this.scrollParent.getVerticalScrollBar().getValueIsAdjusting()) || (this.scrollParent.getHorizontalScrollBar().getValueIsAdjusting());
/*     */ 
/*  74 */     boolean changed = true;
/*     */ 
/*  76 */     if (viewIsUnbounded())
/*     */     {
/*  78 */       int hDelta = pt.x - this.panPoint.x;
/*  79 */       int vDelta = pt.y - this.panPoint.y;
/*  80 */       if ((hDelta != 0) && (vDelta == 0))
/*  81 */         getPannableView().panBy(hDelta, vDelta);
/*  82 */       else if ((vDelta != 0) && (hDelta == 0))
/*  83 */         getPannableView().panBy(hDelta, vDelta);
/*     */       else
/*  85 */         changed = false;
/*  86 */       this.panPoint = pt;
/*  87 */       if ((!this.panPoint.equals(getPanCenterPoint())) && (!isAdjusting))
/*     */       {
/*  89 */         this.panPoint = getPanCenterPoint();
/*  90 */         fireStateChanged();
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  96 */       changed = !getViewPosition().equals(pt);
/*  97 */       super.setViewPosition(pt);
/*     */     }
/*  99 */     if ((changed) || (isAdjusting))
/* 100 */       getPannableView().showPanTip();
/*     */   }
/*     */ 
/*     */   public Point getViewPosition()
/*     */   {
/* 109 */     return viewIsUnbounded() ? getPanCenterPoint() : super.getViewPosition();
/*     */   }
/*     */ 
/*     */   public Dimension getViewSize()
/*     */   {
/* 119 */     return viewIsUnbounded() ? getView().getPreferredSize() : super.getViewSize();
/*     */   }
/*     */ 
/*     */   private Pannable getPannableView()
/*     */   {
/* 127 */     return (Pannable)getView();
/*     */   }
/*     */ 
/*     */   private boolean viewIsUnbounded()
/*     */   {
/* 132 */     Pannable p = getPannableView();
/* 133 */     return (p != null) && (p.isPannableUnbounded());
/*     */   }
/*     */ 
/*     */   private Point getPanCenterPoint()
/*     */   {
/* 138 */     Dimension size = getViewSize();
/* 139 */     return new Point(size.width / 2, size.height / 2);
/*     */   }
/*     */ 
/*     */   public static abstract interface Pannable
/*     */   {
/*     */     public abstract void panBy(int paramInt1, int paramInt2);
/*     */ 
/*     */     public abstract boolean isPannableUnbounded();
/*     */ 
/*     */     public abstract void showPanTip();
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.PseudoInfiniteViewport
 * JD-Core Version:    0.6.0
 */