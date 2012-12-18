/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ICMSSN102
/*     */ {
/* 123 */   private String orig = null;
/*     */ 
/* 130 */   private String CSOSN = null;
/*     */ 
/*     */   public ICMSSN102(Node no)
/*     */   {
/*  40 */     NodeList filhos = no.getChildNodes();
/*  41 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  43 */       Node filhoAtual = filhos.item(i);
/*  44 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*     */       {
/*  46 */         this.orig = filhoAtual.getTextContent();
/*     */       }
/*  48 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CSOSN"))
/*     */       {
/*  50 */         this.CSOSN = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getOrig()
/*     */   {
/*  60 */     return this.orig;
/*     */   }
/*     */ 
/*     */   public void setOrig(String orig)
/*     */   {
/*  68 */     this.orig = orig;
/*     */   }
/*     */ 
/*     */   public String getCSOSN()
/*     */   {
/*  76 */     return this.CSOSN;
/*     */   }
/*     */ 
/*     */   public void setCSOSN(String cSOSN)
/*     */   {
/*  84 */     this.CSOSN = cSOSN;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/*  89 */     String resultado = "1000";
/*  90 */     if (this.orig == null)
/*     */     {
/*  92 */       resultado = "1999";
/*     */     }
/*  94 */     else if (this.CSOSN == null)
/*     */     {
/*  96 */       resultado = "1999";
/*     */     }
/*  98 */     else if ((!this.orig.equals("0")) && (!this.orig.equals("1")) && (!this.orig.equals("2")))
/*     */     {
/* 100 */       resultado = "1471";
/*     */     }
/* 102 */     else if ((!this.CSOSN.equals("102")) && (!this.CSOSN.equals("300")) && (!this.CSOSN.equals("500")))
/*     */     {
/* 104 */       resultado = "1476";
/*     */     }
/* 106 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 111 */     if (this.orig != null)
/* 112 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/* 113 */     if (this.CSOSN != null)
/* 114 */       retorno.append("<CSOSN>").append(this.CSOSN).append("</CSOSN>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ICMSSN102
 * JD-Core Version:    0.6.2
 */