/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesICMS
/*     */ {
/* 157 */   private ICMS00 ICMS00 = null;
/*     */ 
/* 165 */   private ICMS40 ICMS40 = null;
/*     */ 
/* 170 */   private ICMSSN102 ICMSSN102 = null;
/*     */ 
/* 175 */   private ICMSSN900 ICMSSN900 = null;
/*     */ 
/*     */   public InformacoesICMS(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ICMS00"))
/*     */       {
/*  23 */         this.ICMS00 = new ICMS00(filhoAtual);
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ICMS40"))
/*     */       {
/*  27 */         this.ICMS40 = new ICMS40(filhoAtual);
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ICMSSN102"))
/*     */       {
/*  31 */         this.ICMSSN102 = new ICMSSN102(filhoAtual);
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ICMSSN900"))
/*     */       {
/*  35 */         this.ICMSSN900 = new ICMSSN900(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public InformacoesICMS(ICMS00 ICMS00)
/*     */   {
/*  42 */     this.ICMS00 = ICMS00;
/*     */   }
/*     */ 
/*     */   public InformacoesICMS(ICMS40 ICMS40)
/*     */   {
/*  47 */     this.ICMS40 = ICMS40;
/*     */   }
/*     */ 
/*     */   public InformacoesICMS(ICMSSN102 ICMSSN102)
/*     */   {
/*  52 */     this.ICMSSN102 = ICMSSN102;
/*     */   }
/*     */ 
/*     */   public InformacoesICMS(ICMSSN900 ICMSSN900)
/*     */   {
/*  57 */     this.ICMSSN900 = ICMSSN900;
/*     */   }
/*     */ 
/*     */   public ICMS00 getICMS00()
/*     */   {
/*  65 */     return this.ICMS00;
/*     */   }
/*     */ 
/*     */   public void setICMS00(ICMS00 ICMS00CFe)
/*     */   {
/*  73 */     this.ICMS00 = ICMS00CFe;
/*     */   }
/*     */ 
/*     */   public ICMS40 getICMS40()
/*     */   {
/*  81 */     return this.ICMS40;
/*     */   }
/*     */ 
/*     */   public void setICMS40(ICMS40 ICMS40CFe)
/*     */   {
/*  89 */     this.ICMS40 = ICMS40CFe;
/*     */   }
/*     */ 
/*     */   public ICMSSN102 getICMSSN102()
/*     */   {
/*  97 */     return this.ICMSSN102;
/*     */   }
/*     */ 
/*     */   public void getICMSSN102(ICMSSN102 ICMSSN102CFe)
/*     */   {
/* 105 */     this.ICMSSN102 = ICMSSN102CFe;
/*     */   }
/*     */ 
/*     */   public ICMSSN900 getICMSSN900()
/*     */   {
/* 113 */     return this.ICMSSN900;
/*     */   }
/*     */ 
/*     */   public void getICMSSN900(ICMSSN900 ICMSSN900CFe)
/*     */   {
/* 121 */     this.ICMSSN900 = ICMSSN900CFe;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 126 */     if (this.ICMS00 != null)
/*     */     {
/* 128 */       retorno.append("<ICMS00>");
/* 129 */       this.ICMS00.toString(retorno);
/* 130 */       retorno.append("</ICMS00>");
/*     */     }
/* 132 */     if (this.ICMS40 != null)
/*     */     {
/* 134 */       retorno.append("<ICMS40>");
/* 135 */       this.ICMS40.toString(retorno);
/* 136 */       retorno.append("</ICMS40>");
/*     */     }
/* 138 */     if (this.ICMSSN102 != null)
/*     */     {
/* 140 */       retorno.append("<ICMSSN102>");
/* 141 */       this.ICMSSN102.toString(retorno);
/* 142 */       retorno.append("</ICMSSN102>");
/*     */     }
/* 144 */     if (this.ICMSSN900 != null)
/*     */     {
/* 146 */       retorno.append("<ICMSSN900>");
/* 147 */       this.ICMSSN900.toString(retorno);
/* 148 */       retorno.append("</ICMSSN900>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesICMS
 * JD-Core Version:    0.6.2
 */