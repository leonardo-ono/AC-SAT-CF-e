/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesCOFINS
/*     */ {
/* 134 */   private COFINSAliq COFINSAliq = null;
/*     */ 
/* 137 */   private COFINSQtde COFINSQtde = null;
/*     */ 
/* 140 */   private COFINSNT COFINSNT = null;
/*     */ 
/* 143 */   private COFINSSN COFINSSN = null;
/*     */ 
/* 146 */   private COFINSOutr COFINSOutr = null;
/*     */ 
/*     */   public InformacoesCOFINS(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSAliq"))
/*     */       {
/*  23 */         this.COFINSAliq = new COFINSAliq(filhoAtual);
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSQtde"))
/*     */       {
/*  27 */         this.COFINSQtde = new COFINSQtde(filhoAtual);
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSNT"))
/*     */       {
/*  31 */         this.COFINSNT = new COFINSNT(filhoAtual);
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSSN"))
/*     */       {
/*  35 */         this.COFINSSN = new COFINSSN(filhoAtual);
/*     */       }
/*  37 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSOutr"))
/*     */       {
/*  39 */         this.COFINSOutr = new COFINSOutr(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINS(COFINSAliq COFINSAliq)
/*     */   {
/*  46 */     this.COFINSAliq = COFINSAliq;
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINS(COFINSQtde COFINSQtde)
/*     */   {
/*  51 */     this.COFINSQtde = COFINSQtde;
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINS(COFINSNT COFINSNT)
/*     */   {
/*  56 */     this.COFINSNT = COFINSNT;
/*     */   }
/*     */ 
/*     */   public COFINSAliq getCOFINSAliq()
/*     */   {
/*  64 */     return this.COFINSAliq;
/*     */   }
/*     */ 
/*     */   public COFINSQtde getCOFINSQTde()
/*     */   {
/*  72 */     return this.COFINSQtde;
/*     */   }
/*     */ 
/*     */   public COFINSNT getCOFINSNT()
/*     */   {
/*  80 */     return this.COFINSNT;
/*     */   }
/*     */ 
/*     */   public COFINSSN getCOFINSSN()
/*     */   {
/*  88 */     return this.COFINSSN;
/*     */   }
/*     */ 
/*     */   public COFINSOutr getCOFINSOutr()
/*     */   {
/*  96 */     return this.COFINSOutr;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 101 */     if (this.COFINSAliq != null)
/*     */     {
/* 103 */       retorno.append("<COFINSAliq>");
/* 104 */       this.COFINSAliq.toString(retorno);
/* 105 */       retorno.append("</COFINSAliq>");
/*     */     }
/* 107 */     if (this.COFINSQtde != null)
/*     */     {
/* 109 */       retorno.append("<COFINSQtde>");
/* 110 */       this.COFINSQtde.toString(retorno);
/* 111 */       retorno.append("</COFINSQtde>");
/*     */     }
/* 113 */     if (this.COFINSNT != null)
/*     */     {
/* 115 */       retorno.append("<COFINSNT>");
/* 116 */       this.COFINSNT.toString(retorno);
/* 117 */       retorno.append("</COFINSNT>");
/*     */     }
/* 119 */     if (this.COFINSSN != null)
/*     */     {
/* 121 */       retorno.append("<COFINSSN>");
/* 122 */       this.COFINSSN.toString(retorno);
/* 123 */       retorno.append("</COFINSSN>");
/*     */     }
/* 125 */     if (this.COFINSOutr != null)
/*     */     {
/* 127 */       retorno.append("<COFINSOutr>");
/* 128 */       this.COFINSOutr.toString(retorno);
/* 129 */       retorno.append("</COFINSOutr>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesCOFINS
 * JD-Core Version:    0.6.2
 */