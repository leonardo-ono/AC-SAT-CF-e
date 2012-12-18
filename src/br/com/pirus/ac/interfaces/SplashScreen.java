/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.Window;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ 
/*     */ public final class SplashScreen extends Frame
/*     */ {
/*     */   private static final long serialVersionUID = -2159892691242131213L;
/*     */   private final String fImageId;
/*     */   private MediaTracker fMediaTracker;
/*     */   private Image fImage;
/*  86 */   private static final ImageObserver NO_OBSERVER = null;
/*     */   private static final int IMAGE_ID = 0;
/*     */ 
/*     */   public SplashScreen(String aImageId)
/*     */   {
/*  42 */     if ((aImageId == null) || (aImageId.trim().length() == 0))
/*     */     {
/*  44 */       throw new IllegalArgumentException("Image Id does not have content.");
/*     */     }
/*  46 */     this.fImageId = aImageId;
/*     */   }
/*     */ 
/*     */   public void splash()
/*     */   {
/*  60 */     initImageAndTracker();
/*  61 */     setSize(this.fImage.getWidth(NO_OBSERVER), this.fImage.getHeight(NO_OBSERVER));
/*  62 */     center();
/*  63 */     this.fMediaTracker.addImage(this.fImage, 0);
/*     */     try
/*     */     {
/*  66 */       this.fMediaTracker.waitForID(0);
/*     */     }
/*     */     catch (InterruptedException ex)
/*     */     {
/*  70 */       System.out.println("Cannot track image load.");
/*     */     }
/*  72 */     new SplashWindow(this, this.fImage);
/*     */   }
/*     */ 
/*     */   public void disable()
/*     */   {
/*  77 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void initImageAndTracker()
/*     */   {
/*  92 */     this.fMediaTracker = new MediaTracker(this);
/*  93 */     URL imageURL = SplashScreen.class.getResource(this.fImageId);
/*  94 */     this.fImage = Toolkit.getDefaultToolkit().getImage(imageURL);
/*     */   }
/*     */ 
/*     */   private void center()
/*     */   {
/* 108 */     Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
/* 109 */     Rectangle frame = getBounds();
/* 110 */     setLocation((screen.width - frame.width) / 2, (screen.height - frame.height) / 2);
/*     */   }
/*     */ 
/*     */   public static void main(String[] aArgs)
/*     */   {
/* 145 */     SplashScreen splashScreen = new SplashScreen("splash.gif");
/* 146 */     splashScreen.splash();
/*     */     try
/*     */     {
/* 149 */       Thread.sleep(20000L);
/*     */     }
/*     */     catch (InterruptedException ex)
/*     */     {
/* 153 */       System.out.println(ex);
/*     */     }
/* 155 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   private class SplashWindow extends Window
/*     */   {
/*     */     private static final long serialVersionUID = 2525462850892691668L;
/*     */     private Image fImage;
/*     */ 
/*     */     SplashWindow(Frame aParent, Image aImage)
/*     */     {
/* 119 */       super(aParent);
/* 120 */       this.fImage = aImage;
/* 121 */       setSize(this.fImage.getWidth(SplashScreen.NO_OBSERVER), this.fImage.getHeight(SplashScreen.NO_OBSERVER));
/* 122 */       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
/* 123 */       Rectangle window = getBounds();
/* 124 */       setLocation((screen.width - window.width) / 2, (screen.height - window.height) / 2);
/* 125 */       setVisible(true);
/*     */     }
/*     */ 
/*     */     public void paint(Graphics graphics)
/*     */     {
/* 130 */       if (this.fImage != null)
/*     */       {
/* 132 */         graphics.drawImage(this.fImage, 0, 0, this);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.SplashScreen
 * JD-Core Version:    0.6.2
 */