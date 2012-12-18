/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class PISQtde
/*     */ {
/* 102 */   private String CST = null;
/*     */ 
/* 105 */   private String qBCProd = null;
/*     */ 
/* 108 */   private String vAliqProd = null;
/*     */ 
/*     */   public PISQtde(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  23 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  27 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  31 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public PISQtde(String CST, String qBCProd, String vAliqProd)
/*     */   {
/*  38 */     this.CST = CST;
/*  39 */     this.qBCProd = qBCProd;
/*  40 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  48 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  56 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/*  64 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/*  72 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/*  80 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/*  88 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  93 */     if (this.CST != null)
/*  94 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*  95 */     if (this.qBCProd != null)
/*  96 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/*  97 */     if (this.vAliqProd != null)
/*  98 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.PISQtde
 * JD-Core Version:    0.6.2
 */