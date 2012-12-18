/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesPIS
/*     */ {
/* 214 */   private PISAliq PISAliq = null;
/*     */ 
/* 217 */   private PISQtde PISQtde = null;
/*     */ 
/* 220 */   private PISNT PISNT = null;
/*     */ 
/* 223 */   private PISSN PISSN = null;
/*     */ 
/* 226 */   private PISOutr PISOutr = null;
/*     */ 
/*     */   public InformacoesPIS(Node no)
/*     */   {
/*  27 */     NodeList filhos = no.getChildNodes();
/*  28 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  30 */       Node filhoAtual = filhos.item(i);
/*  31 */       if (filhoAtual.getNodeName().equalsIgnoreCase("PISAliq"))
/*     */       {
/*  33 */         this.PISAliq = new PISAliq(filhoAtual);
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISQtde"))
/*     */       {
/*  37 */         this.PISQtde = new PISQtde(filhoAtual);
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISNT"))
/*     */       {
/*  41 */         this.PISNT = new PISNT(filhoAtual);
/*     */       }
/*  43 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISSN"))
/*     */       {
/*  45 */         this.PISSN = new PISSN(filhoAtual);
/*     */       }
/*  47 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISOutr"))
/*     */       {
/*  49 */         this.PISOutr = new PISOutr(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public PISAliq getPISAliq()
/*     */   {
/*  59 */     return this.PISAliq;
/*     */   }
/*     */ 
/*     */   public void setPISAliq(PISAliq PISAliqCFe)
/*     */   {
/*  67 */     this.PISAliq = PISAliqCFe;
/*     */   }
/*     */ 
/*     */   public PISQtde getPISQTde()
/*     */   {
/*  75 */     return this.PISQtde;
/*     */   }
/*     */ 
/*     */   public void setPISQTde(PISQtde PISQtdeCFe)
/*     */   {
/*  83 */     this.PISQtde = PISQtdeCFe;
/*     */   }
/*     */ 
/*     */   public PISNT getPISNT()
/*     */   {
/*  91 */     return this.PISNT;
/*     */   }
/*     */ 
/*     */   public void getPISNT(PISNT PISNTCFe)
/*     */   {
/*  99 */     this.PISNT = PISNTCFe;
/*     */   }
/*     */ 
/*     */   public PISSN getPISSN()
/*     */   {
/* 107 */     return this.PISSN;
/*     */   }
/*     */ 
/*     */   public void setPISSN(PISSN PISSNCFe)
/*     */   {
/* 115 */     this.PISSN = PISSNCFe;
/*     */   }
/*     */ 
/*     */   public PISOutr getPISOutr()
/*     */   {
/* 123 */     return this.PISOutr;
/*     */   }
/*     */ 
/*     */   public void getPISOutr(PISOutr PISOutrCFe)
/*     */   {
/* 131 */     this.PISOutr = PISOutrCFe;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 136 */     String resultado = "1000";
/* 137 */     if ((this.PISAliq == null) && (this.PISQtde == null) && (this.PISNT == null) && (this.PISSN == null) && (this.PISOutr == null))
/*     */     {
/* 139 */       resultado = "1999";
/*     */     }
/* 141 */     else if ((this.PISAliq != null) && ((this.PISQtde != null) || (this.PISNT != null) || (this.PISSN != null) || (this.PISOutr != null)))
/*     */     {
/* 143 */       resultado = "1999";
/*     */     }
/* 145 */     else if ((this.PISQtde != null) && ((this.PISAliq != null) || (this.PISNT != null) || (this.PISSN != null) || (this.PISOutr != null)))
/*     */     {
/* 147 */       resultado = "1999";
/*     */     }
/* 149 */     else if ((this.PISNT != null) && ((this.PISAliq != null) || (this.PISQtde != null) || (this.PISSN != null) || (this.PISOutr != null)))
/*     */     {
/* 151 */       resultado = "1999";
/*     */     }
/* 153 */     else if ((this.PISSN != null) && ((this.PISAliq != null) || (this.PISQtde != null) || (this.PISNT != null) || (this.PISOutr != null)))
/*     */     {
/* 155 */       resultado = "1999";
/*     */     }
/* 157 */     else if ((this.PISOutr != null) && ((this.PISAliq != null) || (this.PISQtde != null) || (this.PISNT != null) || (this.PISSN != null)))
/*     */     {
/* 159 */       resultado = "1999";
/*     */     }
/* 161 */     else if ((this.PISAliq == null) || ((resultado = this.PISAliq.validar()).equals("1000")))
/*     */     {
/* 164 */       if ((this.PISQtde == null) || ((resultado = this.PISQtde.validar()).equals("1000")))
/*     */       {
/* 167 */         if ((this.PISNT == null) || ((resultado = this.PISNT.validar()).equals("1000")))
/*     */         {
/* 170 */           if ((this.PISSN == null) || ((resultado = this.PISSN.validar()).equals("1000")))
/*     */           {
/* 173 */             if (this.PISOutr != null) (resultado = this.PISOutr.validar()).equals("1000"); 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 176 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 181 */     if (this.PISAliq != null)
/*     */     {
/* 183 */       retorno.append("<PISAliq>");
/* 184 */       this.PISAliq.toString(retorno);
/* 185 */       retorno.append("</PISAliq>");
/*     */     }
/* 187 */     if (this.PISQtde != null)
/*     */     {
/* 189 */       retorno.append("<PISQtde>");
/* 190 */       this.PISQtde.toString(retorno);
/* 191 */       retorno.append("</PISQtde>");
/*     */     }
/* 193 */     if (this.PISNT != null)
/*     */     {
/* 195 */       retorno.append("<PISNT>");
/* 196 */       this.PISNT.toString(retorno);
/* 197 */       retorno.append("</PISNT>");
/*     */     }
/* 199 */     if (this.PISSN != null)
/*     */     {
/* 201 */       retorno.append("<PISSN>");
/* 202 */       this.PISSN.toString(retorno);
/* 203 */       retorno.append("</PISSN>");
/*     */     }
/* 205 */     if (this.PISOutr != null)
/*     */     {
/* 207 */       retorno.append("<PISOutr>");
/* 208 */       this.PISOutr.toString(retorno);
/* 209 */       retorno.append("</PISOutr>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesPIS
 * JD-Core Version:    0.6.2
 */