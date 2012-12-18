/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ICMS40
/*     */ {
/* 126 */   private String orig = null;
/*     */ 
/* 134 */   private String CST = null;
/*     */ 
/*     */   public ICMS40(Node no)
/*     */   {
/*  40 */     NodeList filhos = no.getChildNodes();
/*  41 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  43 */       Node filhoAtual = filhos.item(i);
/*  44 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*     */       {
/*  46 */         this.orig = filhoAtual.getTextContent();
/*     */       }
/*  48 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  50 */         this.CST = filhoAtual.getTextContent();
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
/*     */   public String getCST()
/*     */   {
/*  76 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  84 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/*  89 */     String resultado = "1000";
/*  90 */     if (this.orig == null)
/*     */     {
/*  92 */       resultado = "1999";
/*     */     }
/*  94 */     else if (this.CST == null)
/*     */     {
/*  96 */       resultado = "1999";
/*     */     }
/*  98 */     else if ((!this.orig.equals("0")) && (!this.orig.equals("1")) && (!this.orig.equals("2")))
/*     */     {
/* 100 */       resultado = "1471";
/*     */     }
/* 102 */     else if (this.CST.length() != 2)
/*     */     {
/* 104 */       resultado = "1999";
/*     */     }
/* 106 */     else if ((!this.CST.equals("40")) && (!this.CST.equals("41")) && (!this.CST.equals("50")) && (!this.CST.equals("60")))
/*     */     {
/* 108 */       resultado = "1475";
/*     */     }
/* 110 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 115 */     if (this.orig != null)
/* 116 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/* 117 */     if (this.CST != null)
/* 118 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ICMS40
 * JD-Core Version:    0.6.2
 */