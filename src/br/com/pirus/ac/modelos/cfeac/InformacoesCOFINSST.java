/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesCOFINSST
/*     */ {
/* 122 */   private String vBC = null;
/*     */ 
/* 125 */   private String pCOFINS = null;
/*     */ 
/* 128 */   private String qBCProd = null;
/*     */ 
/* 131 */   private String vAliqProd = null;
/*     */ 
/*     */   public InformacoesCOFINSST(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  23 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pCOFINS"))
/*     */       {
/*  27 */         this.pCOFINS = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  31 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  35 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINSST()
/*     */   {
/*  42 */     this.vBC = "1.00";
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  50 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  58 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getpCOFINS()
/*     */   {
/*  66 */     return this.pCOFINS;
/*     */   }
/*     */ 
/*     */   public void setpCOFINS(String pCOFINS)
/*     */   {
/*  74 */     this.pCOFINS = pCOFINS;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/*  82 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/*  90 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/*  98 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 106 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 111 */     if (this.vBC != null)
/* 112 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 113 */     if (this.pCOFINS != null)
/* 114 */       retorno.append("<pCOFINS>").append(this.pCOFINS).append("</pCOFINS>");
/* 115 */     if (this.qBCProd != null)
/* 116 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 117 */     if (this.vAliqProd != null)
/* 118 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesCOFINSST
 * JD-Core Version:    0.6.2
 */