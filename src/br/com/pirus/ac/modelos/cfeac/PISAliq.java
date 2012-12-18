/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class PISAliq
/*     */ {
/* 106 */   private String CST = null;
/*     */ 
/* 109 */   private String pPIS = null;
/*     */ 
/* 112 */   private String vBC = null;
/*     */ 
/*     */   public PISAliq(Node no)
/*     */   {
/*  18 */     NodeList filhos = no.getChildNodes();
/*  19 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  21 */       Node filhoAtual = filhos.item(i);
/*  22 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  24 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  26 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  28 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  30 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pPIS"))
/*     */       {
/*  32 */         this.pPIS = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public PISAliq(String CST, String vBC, String pPIS)
/*     */   {
/*  39 */     this.CST = CST;
/*  40 */     this.vBC = vBC;
/*  41 */     this.pPIS = pPIS;
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  49 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  57 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getpPIS()
/*     */   {
/*  65 */     return this.pPIS;
/*     */   }
/*     */ 
/*     */   public void setpPIS(String pPIS)
/*     */   {
/*  73 */     this.pPIS = pPIS;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  81 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  89 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  94 */     if (this.CST != null)
/*  95 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*  96 */     if (this.vBC != null)
/*  97 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/*  98 */     if (this.pPIS != null)
/*  99 */       retorno.append("<pPIS>").append(this.pPIS).append("</pPIS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.PISAliq
 * JD-Core Version:    0.6.2
 */