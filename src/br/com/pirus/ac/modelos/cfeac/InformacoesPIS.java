/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesPIS
/*     */ {
/* 174 */   private PISAliq PISAliq = null;
/*     */ 
/* 177 */   private PISQtde PISQtde = null;
/*     */ 
/* 180 */   private PISNT PISNT = null;
/*     */ 
/* 183 */   private PISSN PISSN = null;
/*     */ 
/* 186 */   private PISOutr PISOutr = null;
/*     */ 
/*     */   public InformacoesPIS(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("PISAliq"))
/*     */       {
/*  23 */         this.PISAliq = new PISAliq(filhoAtual);
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISQtde"))
/*     */       {
/*  27 */         this.PISQtde = new PISQtde(filhoAtual);
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISNT"))
/*     */       {
/*  31 */         this.PISNT = new PISNT(filhoAtual);
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISSN"))
/*     */       {
/*  35 */         this.PISSN = new PISSN(filhoAtual);
/*     */       }
/*  37 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISOutr"))
/*     */       {
/*  39 */         this.PISOutr = new PISOutr(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public InformacoesPIS(PISAliq PISAliq)
/*     */   {
/*  46 */     this.PISAliq = PISAliq;
/*     */   }
/*     */ 
/*     */   public InformacoesPIS(PISQtde PISQtde)
/*     */   {
/*  51 */     this.PISQtde = PISQtde;
/*     */   }
/*     */ 
/*     */   public InformacoesPIS(PISNT PISNT)
/*     */   {
/*  56 */     this.PISNT = PISNT;
/*     */   }
/*     */ 
/*     */   public PISAliq getPISAliq()
/*     */   {
/*  64 */     return this.PISAliq;
/*     */   }
/*     */ 
/*     */   public void setPISAliq(PISAliq PISAliqCFe)
/*     */   {
/*  72 */     this.PISAliq = PISAliqCFe;
/*     */   }
/*     */ 
/*     */   public PISQtde getPISQTde()
/*     */   {
/*  80 */     return this.PISQtde;
/*     */   }
/*     */ 
/*     */   public void setPISQTde(PISQtde PISQtdeCFe)
/*     */   {
/*  88 */     this.PISQtde = PISQtdeCFe;
/*     */   }
/*     */ 
/*     */   public PISNT getPISNT()
/*     */   {
/*  96 */     return this.PISNT;
/*     */   }
/*     */ 
/*     */   public void getPISNT(PISNT PISNTCFe)
/*     */   {
/* 104 */     this.PISNT = PISNTCFe;
/*     */   }
/*     */ 
/*     */   public PISSN getPISSN()
/*     */   {
/* 112 */     return this.PISSN;
/*     */   }
/*     */ 
/*     */   public void setPISSN(PISSN PISSNCFe)
/*     */   {
/* 120 */     this.PISSN = PISSNCFe;
/*     */   }
/*     */ 
/*     */   public PISOutr getPISOutr()
/*     */   {
/* 128 */     return this.PISOutr;
/*     */   }
/*     */ 
/*     */   public void getPISOutr(PISOutr PISOutrCFe)
/*     */   {
/* 136 */     this.PISOutr = PISOutrCFe;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 141 */     if (this.PISAliq != null)
/*     */     {
/* 143 */       retorno.append("<PISAliq>");
/* 144 */       this.PISAliq.toString(retorno);
/* 145 */       retorno.append("</PISAliq>");
/*     */     }
/* 147 */     if (this.PISQtde != null)
/*     */     {
/* 149 */       retorno.append("<PISQtde>");
/* 150 */       this.PISQtde.toString(retorno);
/* 151 */       retorno.append("</PISQtde>");
/*     */     }
/* 153 */     if (this.PISNT != null)
/*     */     {
/* 155 */       retorno.append("<PISNT>");
/* 156 */       this.PISNT.toString(retorno);
/* 157 */       retorno.append("</PISNT>");
/*     */     }
/* 159 */     if (this.PISSN != null)
/*     */     {
/* 161 */       retorno.append("<PISSN>");
/* 162 */       this.PISSN.toString(retorno);
/* 163 */       retorno.append("</PISSN>");
/*     */     }
/* 165 */     if (this.PISOutr != null)
/*     */     {
/* 167 */       retorno.append("<PISOutr>");
/* 168 */       this.PISOutr.toString(retorno);
/* 169 */       retorno.append("</PISOutr>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesPIS
 * JD-Core Version:    0.6.2
 */