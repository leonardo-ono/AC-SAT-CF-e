/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesCOFINS
/*     */ {
/* 179 */   private COFINSAliq COFINSAliq = null;
/*     */ 
/* 182 */   private COFINSQtde COFINSQtde = null;
/*     */ 
/* 185 */   private COFINSNT COFINSNT = null;
/*     */ 
/* 188 */   private COFINSSN COFINSSN = null;
/*     */ 
/* 191 */   private COFINSOutr COFINSOutr = null;
/*     */ 
/*     */   public InformacoesCOFINS(Node no)
/*     */   {
/*  32 */     NodeList filhos = no.getChildNodes();
/*  33 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  35 */       Node filhoAtual = filhos.item(i);
/*  36 */       if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSAliq"))
/*     */       {
/*  38 */         this.COFINSAliq = new COFINSAliq(filhoAtual);
/*     */       }
/*  40 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSQtde"))
/*     */       {
/*  42 */         this.COFINSQtde = new COFINSQtde(filhoAtual);
/*     */       }
/*  44 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSNT"))
/*     */       {
/*  46 */         this.COFINSNT = new COFINSNT(filhoAtual);
/*     */       }
/*  48 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSSN"))
/*     */       {
/*  50 */         this.COFINSSN = new COFINSSN(filhoAtual);
/*     */       }
/*  52 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSOutr"))
/*     */       {
/*  54 */         this.COFINSOutr = new COFINSOutr(filhoAtual);
/*     */       }
/*     */     }
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
/*     */   public String validar()
/*     */   {
/* 101 */     String resultado = "1000";
/* 102 */     if ((this.COFINSAliq == null) && (this.COFINSQtde == null) && (this.COFINSNT == null) && (this.COFINSSN == null) && (this.COFINSOutr == null))
/*     */     {
/* 104 */       resultado = "1999";
/*     */     }
/* 106 */     else if ((this.COFINSAliq != null) && ((this.COFINSQtde != null) || (this.COFINSNT != null) || (this.COFINSSN != null) || (this.COFINSOutr != null)))
/*     */     {
/* 108 */       resultado = "1999";
/*     */     }
/* 110 */     else if ((this.COFINSQtde != null) && ((this.COFINSAliq != null) || (this.COFINSNT != null) || (this.COFINSSN != null) || (this.COFINSOutr != null)))
/*     */     {
/* 112 */       resultado = "1999";
/*     */     }
/* 114 */     else if ((this.COFINSNT != null) && ((this.COFINSAliq != null) || (this.COFINSQtde != null) || (this.COFINSSN != null) || (this.COFINSOutr != null)))
/*     */     {
/* 116 */       resultado = "1999";
/*     */     }
/* 118 */     else if ((this.COFINSSN != null) && ((this.COFINSAliq != null) || (this.COFINSQtde != null) || (this.COFINSNT != null) || (this.COFINSOutr != null)))
/*     */     {
/* 120 */       resultado = "1999";
/*     */     }
/* 122 */     else if ((this.COFINSOutr != null) && ((this.COFINSAliq != null) || (this.COFINSQtde != null) || (this.COFINSNT != null) || (this.COFINSSN != null)))
/*     */     {
/* 124 */       resultado = "1999";
/*     */     }
/* 126 */     else if ((this.COFINSAliq == null) || ((resultado = this.COFINSAliq.validar()).equals("1000")))
/*     */     {
/* 129 */       if ((this.COFINSQtde == null) || ((resultado = this.COFINSQtde.validar()).equals("1000")))
/*     */       {
/* 132 */         if ((this.COFINSNT == null) || ((resultado = this.COFINSNT.validar()).equals("1000")))
/*     */         {
/* 135 */           if ((this.COFINSSN == null) || ((resultado = this.COFINSSN.validar()).equals("1000")))
/*     */           {
/* 138 */             if (this.COFINSOutr != null) (resultado = this.COFINSOutr.validar()).equals("1000"); 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 141 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 146 */     if (this.COFINSAliq != null)
/*     */     {
/* 148 */       retorno.append("<COFINSAliq>");
/* 149 */       this.COFINSAliq.toString(retorno);
/* 150 */       retorno.append("</COFINSAliq>");
/*     */     }
/* 152 */     if (this.COFINSQtde != null)
/*     */     {
/* 154 */       retorno.append("<COFINSQtde>");
/* 155 */       this.COFINSQtde.toString(retorno);
/* 156 */       retorno.append("</COFINSQtde>");
/*     */     }
/* 158 */     if (this.COFINSNT != null)
/*     */     {
/* 160 */       retorno.append("<COFINSNT>");
/* 161 */       this.COFINSNT.toString(retorno);
/* 162 */       retorno.append("</COFINSNT>");
/*     */     }
/* 164 */     if (this.COFINSSN != null)
/*     */     {
/* 166 */       retorno.append("<COFINSSN>");
/* 167 */       this.COFINSSN.toString(retorno);
/* 168 */       retorno.append("</COFINSSN>");
/*     */     }
/* 170 */     if (this.COFINSOutr != null)
/*     */     {
/* 172 */       retorno.append("<COFINSOutr>");
/* 173 */       this.COFINSOutr.toString(retorno);
/* 174 */       retorno.append("</COFINSOutr>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesCOFINS
 * JD-Core Version:    0.6.2
 */