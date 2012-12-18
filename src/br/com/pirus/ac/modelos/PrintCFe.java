/*     */ package br.com.pirus.ac.modelos;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Printable;
/*     */ import java.io.PrintStream;
/*     */ import javax.print.Doc;
/*     */ import javax.print.DocFlavor;
/*     */ import javax.print.DocFlavor.SERVICE_FORMATTED;
/*     */ import javax.print.DocPrintJob;
/*     */ import javax.print.PrintException;
/*     */ import javax.print.PrintService;
/*     */ import javax.print.PrintServiceLookup;
/*     */ import javax.print.SimpleDoc;
/*     */ import javax.print.attribute.HashPrintRequestAttributeSet;
/*     */ import javax.print.attribute.PrintRequestAttributeSet;
/*     */ import javax.print.attribute.standard.Copies;
/*     */ import javax.print.attribute.standard.JobName;
/*     */ import javax.print.attribute.standard.OrientationRequested;
/*     */ import org.jbars.Barcode;
/*     */ import org.jbars.Barcode128;
/*     */ 
/*     */ public class PrintCFe
/*     */   implements Printable
/*     */ {
/*     */   private String[][] book;
/*     */   private String codigo;
/* 127 */   private boolean imprimirSoCodigo = false;
/*     */ 
/*     */   public PrintCFe(String texto, String codigo)
/*     */   {
/*  36 */     String[] linhas = ControleDados.quebrarString(texto, "\r\n");
/*  37 */     String[][] doc = new String[(linhas.length + 44) / 45][];
/*  38 */     int j = 0;
/*  39 */     for (int k = 0; k < doc.length; k++)
/*     */     {
/*  41 */       if (linhas.length - j > 45)
/*  42 */         doc[k] = new String[45];
/*     */       else
/*  44 */         doc[k] = new String[linhas.length - j];
/*  45 */       for (int i = 0; (i < 45) && (j < linhas.length); j++)
/*     */       {
/*  47 */         doc[k][i] = linhas[j];
/*     */ 
/*  45 */         i++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  50 */     this.book = doc;
/*  51 */     this.codigo = codigo;
/*  52 */     DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
/*  53 */     PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
/*  54 */     aset.add(OrientationRequested.PORTRAIT);
/*  55 */     aset.add(new Copies(1));
/*  56 */     aset.add(new JobName("Impressao CFe", null));
/*  57 */     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
/*  58 */     DocPrintJob pj = service.createPrintJob();
/*     */     try
/*     */     {
/*  61 */       Doc ptintDoc = new SimpleDoc(this, flavor, null);
/*  62 */       pj.print(ptintDoc, aset);
/*     */     }
/*     */     catch (PrintException e)
/*     */     {
/*  66 */       System.out.println(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int print(Graphics g, PageFormat pf, int pageIndex)
/*     */   {
/*  72 */     if (this.imprimirSoCodigo)
/*     */     {
/*  74 */       Graphics2D g2d = (Graphics2D)g;
/*  75 */       Image img = getCodigoBarras();
/*  76 */       g2d.drawImage(img, 0, 20, null);
/*  77 */       this.imprimirSoCodigo = false;
/*  78 */       return 0;
/*     */     }
/*  80 */     if (pageIndex <= this.book.length - 1)
/*     */     {
/*  82 */       Graphics2D g2d = (Graphics2D)g;
/*  83 */       g2d.translate(pf.getImageableX(), pf.getImageableY());
/*  84 */       g2d.setColor(Color.black);
/*  85 */       String[] pagina = this.book[pageIndex];
/*  86 */       FontMetrics fm = g2d.getFontMetrics();
/*  87 */       Rectangle2D stringBound = fm.getStringBounds(pagina[0], g2d);
/*  88 */       double tamanho = stringBound.getHeight();
/*  89 */       for (int i = 0; i < pagina.length; i++)
/*     */       {
/*  91 */         g2d.drawString(pagina[i], 0, 20 + (int)(i * tamanho));
/*     */       }
/*  93 */       if (pageIndex == this.book.length - 1)
/*     */       {
/*  95 */         if (pagina.length > 40) {
/*  96 */           this.imprimirSoCodigo = true;
/*     */         }
/*     */         else {
/*  99 */           Image img = getCodigoBarras();
/* 100 */           g2d.drawImage(img, 0, 20 + (int)(pagina.length * tamanho), null);
/*     */         }
/*     */       }
/* 103 */       return 0;
/*     */     }
/*     */ 
/* 106 */     return 1;
/*     */   }
/*     */ 
/*     */   private Image getCodigoBarras()
/*     */   {
/* 111 */     Barcode128 bc128 = new Barcode128();
/* 112 */     boolean generateChecksum = false;
/* 113 */     boolean checksumText = false;
/* 114 */     boolean transparent = true;
/* 115 */     boolean shotText = false;
/* 116 */     bc128.setShowText(shotText);
/* 117 */     bc128.setTransparent(transparent);
/* 118 */     bc128.setChecksumText(checksumText);
/* 119 */     bc128.setGenerateChecksum(generateChecksum);
/* 120 */     bc128.setCode(this.codigo);
/* 121 */     bc128.setX(1.0F);
/* 122 */     bc128.setN(2.0F);
/* 123 */     Image img = Barcode.createImage("CODE128", bc128.getCode(), 60.0F, null, 0, true, 0, 0, Color.black, Color.black, 0);
/* 124 */     return img;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.PrintCFe
 * JD-Core Version:    0.6.2
 */