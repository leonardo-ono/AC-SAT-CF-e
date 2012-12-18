/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class COFINSOutr
/*     */ {
/* 139 */   private String CST = null;
/*     */ 
/* 142 */   private String pCOFINS = null;
/*     */ 
/* 145 */   private String qBCProd = null;
/*     */ 
/* 148 */   private String vBC = null;
/*     */ 
/* 151 */   private String vAliqProd = null;
/*     */ 
/*     */   public COFINSOutr(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  23 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  27 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pCOFINS"))
/*     */       {
/*  31 */         this.pCOFINS = filhoAtual.getTextContent();
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  35 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  37 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  39 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
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
/*     */   public String getvBC()
/*     */   {
/*  65 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  73 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getpCOFINS()
/*     */   {
/*  81 */     return this.pCOFINS;
/*     */   }
/*     */ 
/*     */   public void setpCOFINS(String pCOFINS)
/*     */   {
/*  89 */     this.pCOFINS = pCOFINS;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/*  97 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/* 105 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/* 113 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 121 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 126 */     if (this.CST != null)
/* 127 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 128 */     if (this.vBC != null)
/* 129 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 130 */     if (this.pCOFINS != null)
/* 131 */       retorno.append("<pCOFINS>").append(this.pCOFINS).append("</pCOFINS>");
/* 132 */     if (this.qBCProd != null)
/* 133 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 134 */     if (this.vAliqProd != null)
/* 135 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.COFINSOutr
 * JD-Core Version:    0.6.2
 */