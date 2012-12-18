/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ICMS00
/*     */ {
/* 136 */   private String orig = null;
/*     */ 
/* 143 */   private String CST = null;
/*     */ 
/* 146 */   private String pICMS = null;
/*     */ 
/*     */   public ICMS00(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*     */       {
/*  23 */         this.orig = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  27 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pICMS"))
/*     */       {
/*  31 */         this.pICMS = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public ICMS00(String orig, String CST, String pICMS)
/*     */   {
/*  38 */     this.orig = orig;
/*  39 */     this.CST = CST;
/*  40 */     this.pICMS = pICMS;
/*     */   }
/*     */ 
/*     */   public String getOrig()
/*     */   {
/*  48 */     return this.orig;
/*     */   }
/*     */ 
/*     */   public void setOrig(String orig)
/*     */   {
/*  56 */     this.orig = orig;
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  64 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  72 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getpICMS()
/*     */   {
/*  80 */     return this.pICMS;
/*     */   }
/*     */ 
/*     */   public void setpICMS(String pICMS)
/*     */   {
/*  88 */     this.pICMS = pICMS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/*  93 */     String resultado = "1000";
/*  94 */     if (this.orig == null)
/*     */     {
/*  96 */       resultado = "1999";
/*     */     }
/*  98 */     else if (this.CST == null)
/*     */     {
/* 100 */       resultado = "1999";
/*     */     }
/* 102 */     else if (this.pICMS == null)
/*     */     {
/* 104 */       resultado = "1999";
/*     */     }
/* 106 */     else if ((!this.orig.equals("0")) && (!this.orig.equals("1")) && (!this.orig.equals("2")))
/*     */     {
/* 108 */       resultado = "1471";
/*     */     }
/* 110 */     else if ((!this.CST.equals("00")) && (!this.CST.equals("20")) && (!this.CST.equals("90")))
/*     */     {
/* 112 */       resultado = "1472";
/*     */     }
/* 114 */     else if (Double.parseDouble(this.pICMS) < 0.0D)
/*     */     {
/* 116 */       resultado = "1473";
/*     */     }
/* 118 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 123 */     if (this.orig != null)
/* 124 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/* 125 */     if (this.CST != null)
/* 126 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 127 */     if (this.pICMS != null)
/* 128 */       retorno.append("<pICMS>").append(this.pICMS).append("</pICMS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ICMS00
 * JD-Core Version:    0.6.2
 */