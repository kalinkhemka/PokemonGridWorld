/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ public abstract class AbstractDisplay
/*     */   implements Display
/*     */ {
/*     */   public abstract void draw(Object paramObject, Component paramComponent, Graphics2D paramGraphics2D);
/*     */ 
/*     */   public void draw(Object obj, Component comp, Graphics2D g2, Rectangle rect)
/*     */   {
/*  62 */     float scaleFactor = Math.min(rect.width, rect.height);
/*  63 */     g2 = (Graphics2D)g2.create();
/*     */ 
/*  66 */     g2.translate(rect.x + rect.width / 2.0D, rect.y + rect.height / 2.0D);
/*     */ 
/*  70 */     if (obj != null)
/*     */     {
/*  72 */       Integer direction = (Integer)getProperty(obj, "direction");
/*  73 */       int rotationInDegrees = direction == null ? 0 : direction.intValue();
/*     */ 
/*  75 */       g2.rotate(Math.toRadians(rotationInDegrees));
/*     */     }
/*     */ 
/*  78 */     g2.scale(scaleFactor, scaleFactor);
/*  79 */     g2.setStroke(new BasicStroke(1.0F / scaleFactor));
/*  80 */     draw(obj, comp, g2);
/*     */   }
/*     */ 
/*     */   public static Object getProperty(Object obj, String propertyName)
/*     */   {
/*  85 */     if (obj == null)
/*  86 */       return null;
/*     */     try
/*     */     {
/*  89 */       BeanInfo info = Introspector.getBeanInfo(obj.getClass());
/*  90 */       PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
/*  91 */       for (int i = 0; i < descriptors.length; i++)
/*     */       {
/*  93 */         if (!descriptors[i].getName().equals(propertyName))
/*     */           continue;
/*  95 */         Method getter = descriptors[i].getReadMethod();
/*  96 */         if (getter == null)
/*  97 */           return null;
/*     */         try {
/*  99 */           return getter.invoke(obj, new Object[0]);
/*     */         } catch (Exception ex) {
/* 101 */           System.out.println(descriptors[i].getName());
/* 102 */           return null;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 109 */       ex.printStackTrace();
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.AbstractDisplay
 * JD-Core Version:    0.6.0
 */