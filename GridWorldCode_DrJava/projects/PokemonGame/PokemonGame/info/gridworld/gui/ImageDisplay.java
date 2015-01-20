/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.image.FilteredImageSource;
/*     */ import java.awt.image.RGBImageFilter;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class ImageDisplay extends AbstractDisplay
/*     */ {
/*     */   private Class cl;
/*     */   private String imageFilename;
/*     */   private static final String imageExtension = ".gif";
/*  49 */   private Map<String, Image> tintedVersions = new HashMap();
/*     */ 
/*     */   public ImageDisplay(Class cl)
/*     */     throws IOException
/*     */   {
/*  58 */     this.cl = cl;
/*  59 */     this.imageFilename = cl.getName().replace('.', '/');
/*  60 */     URL url = cl.getClassLoader().getResource(this.imageFilename + ".gif");
/*     */ 
/*  63 */     if (url == null) {
/*  64 */       throw new FileNotFoundException(this.imageFilename + ".gif" + " not found.");
/*     */     }
/*  66 */     this.tintedVersions.put("", ImageIO.read(url));
/*     */   }
/*     */ 
/*     */   public void draw(Object obj, Component comp, Graphics2D g2)
/*     */   {
/*     */     Color color;
/*     */     Color color;
/*  79 */     if (obj == null)
/*  80 */       color = null;
/*     */     else
/*  82 */       color = (Color)getProperty(obj, "color");
/*  83 */     String imageSuffix = (String)getProperty(obj, "imageSuffix");
/*  84 */     if (imageSuffix == null) {
/*  85 */       imageSuffix = "";
/*     */     }
/*  87 */     Image tinted = (Image)this.tintedVersions.get(color + imageSuffix);
/*  88 */     if (tinted == null)
/*     */     {
/*  90 */       Image untinted = (Image)this.tintedVersions.get(imageSuffix);
/*  91 */       if (untinted == null)
/*     */       {
/*     */         try
/*     */         {
/*  95 */           URL url = this.cl.getClassLoader().getResource(this.imageFilename + imageSuffix + ".gif");
/*     */ 
/*  97 */           if (url == null) {
/*  98 */             throw new FileNotFoundException(this.imageFilename + imageSuffix + ".gif" + " not found.");
/*     */           }
/* 100 */           untinted = ImageIO.read(url);
/* 101 */           this.tintedVersions.put(imageSuffix, untinted);
/*     */         }
/*     */         catch (IOException ex)
/*     */         {
/* 105 */           untinted = (Image)this.tintedVersions.get("");
/*     */         }
/*     */       }
/* 108 */       if (color == null) {
/* 109 */         tinted = untinted;
/*     */       }
/*     */       else {
/* 112 */         FilteredImageSource src = new FilteredImageSource(untinted.getSource(), new TintFilter(color));
/*     */ 
/* 114 */         tinted = comp.createImage(src);
/*     */ 
/* 117 */         this.tintedVersions.put(color + imageSuffix, tinted);
/*     */       }
/*     */     }
/* 120 */     int width = tinted.getWidth(null);
/* 121 */     int height = tinted.getHeight(null);
/* 122 */     int size = Math.max(width, height);
/*     */ 
/* 125 */     g2.scale(1.0D / size, 1.0D / size);
/* 126 */     g2.clip(new Rectangle(-width / 2, -height / 2, width, height));
/* 127 */     g2.drawImage(tinted, -width / 2, -height / 2, null);
/*     */   }
/*     */ 
/*     */   private static class TintFilter extends RGBImageFilter
/*     */   {
/*     */     private int tintR;
/*     */     private int tintG;
/*     */     private int tintB;
/*     */ 
/*     */     public TintFilter(Color color)
/*     */     {
/* 144 */       this.canFilterIndexColorModel = true;
/* 145 */       int rgb = color.getRGB();
/* 146 */       this.tintR = (rgb >> 16 & 0xFF);
/* 147 */       this.tintG = (rgb >> 8 & 0xFF);
/* 148 */       this.tintB = (rgb & 0xFF);
/*     */     }
/*     */ 
/*     */     public int filterRGB(int x, int y, int argb)
/*     */     {
/* 154 */       int alpha = argb >> 24 & 0xFF;
/* 155 */       int red = argb >> 16 & 0xFF;
/* 156 */       int green = argb >> 8 & 0xFF;
/* 157 */       int blue = argb & 0xFF;
/*     */ 
/* 159 */       double lum = (0.2989D * red + 0.5866D * green + 0.1144D * blue) / 255.0D;
/*     */ 
/* 173 */       double scale = 1.0D - 4.0D * ((lum - 0.5D) * (lum - 0.5D));
/*     */ 
/* 175 */       red = (int)(this.tintR * scale + red * (1.0D - scale));
/* 176 */       green = (int)(this.tintG * scale + green * (1.0D - scale));
/* 177 */       blue = (int)(this.tintB * scale + blue * (1.0D - scale));
/* 178 */       return alpha << 24 | red << 16 | green << 8 | blue;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.ImageDisplay
 * JD-Core Version:    0.6.0
 */