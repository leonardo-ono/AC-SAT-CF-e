/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ICMSSN900
/*     */ {
/* 107 */   private String orig = null;
/*     */ 
/* 110 */   private String CSOSN = null;
/*     */ 
/* 113 */   private String pICMS = null;
/*     */ 
/*     */   public ICMSSN900(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*     */       {
/*  23 */         this.orig = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CSOSN"))
/*     */       {
/*  27 */         this.CSOSN = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pICMS"))
/*     */       {
/*  31 */         this.pICMS = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public ICMSSN900(String orig, String CSOSN, String pICMS)
/*     */   {
/*  38 */     this.orig = orig;
/*  39 */     this.CSOSN = CSOSN;
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
/*     */   public String getCSOSN()
/*     */   {
/*  64 */     return this.CSOSN;
/*     */   }
/*     */ 
/*     */   public void setCSOSN(String CSOSN)
/*     */   {
/*  72 */     this.CSOSN = CSOSN;
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
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  93 */     if (this.orig != null)
/*  94 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/*  95 */     if (this.CSOSN != null)
/*  96 */       retorno.append("<CSOSN>").append(this.CSOSN).append("</CSOSN>");
/*  97 */     if (this.pICMS != null)
/*  98 */       retorno.append("<pICMS>").append(this.pICMS).append("</pICMS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ICMSSN900
 * JD-Core Version:    0.6.2
 */