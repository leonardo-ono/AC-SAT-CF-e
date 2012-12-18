/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class COFINSAliq
/*     */ {
/* 105 */   private String CST = null;
/*     */ 
/* 108 */   private String pCOFINS = null;
/*     */ 
/* 111 */   private String vBC = null;
/*     */ 
/*     */   public COFINSAliq(Node no)
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
/*     */     }
/*     */   }
/*     */ 
/*     */   public COFINSAliq(String CST, String vBC, String pCOFINS)
/*     */   {
/*  38 */     this.CST = CST;
/*  39 */     this.vBC = vBC;
/*  40 */     this.pCOFINS = pCOFINS;
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
/*     */   public String getpCOFINS()
/*     */   {
/*  64 */     return this.pCOFINS;
/*     */   }
/*     */ 
/*     */   public void setpCOFINS(String pCOFINS)
/*     */   {
/*  72 */     this.pCOFINS = pCOFINS;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  80 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  88 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  93 */     if (this.CST != null)
/*  94 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*  95 */     if (this.vBC != null)
/*  96 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/*  97 */     if (this.pCOFINS != null)
/*  98 */       retorno.append("<pCOFINS>").append(this.pCOFINS).append("</pCOFINS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.COFINSAliq
 * JD-Core Version:    0.6.2
 */