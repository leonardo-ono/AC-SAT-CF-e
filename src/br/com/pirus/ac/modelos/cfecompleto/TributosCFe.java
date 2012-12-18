/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class TributosCFe
/*     */ {
/* 231 */   private InformacoesICMS ICMS = null;
/*     */ 
/* 234 */   private InformacoesPIS PIS = null;
/*     */ 
/* 237 */   private InformacoesPISST PISST = null;
/*     */ 
/* 240 */   private InformacoesCOFINS COFINS = null;
/*     */ 
/* 243 */   private InformacoesCOFINSST COFINSST = null;
/*     */ 
/* 246 */   private InformacoesISSQN ISSQN = null;
/*     */ 
/*     */   public TributosCFe(Node no)
/*     */   {
/*  27 */     NodeList filhos = no.getChildNodes();
/*  28 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  30 */       Node filhoAtual = filhos.item(i);
/*  31 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ICMS"))
/*     */       {
/*  33 */         this.ICMS = new InformacoesICMS(filhoAtual);
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PIS"))
/*     */       {
/*  37 */         this.PIS = new InformacoesPIS(filhoAtual);
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISST"))
/*     */       {
/*  41 */         this.PISST = new InformacoesPISST(filhoAtual);
/*     */       }
/*  43 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINS"))
/*     */       {
/*  45 */         this.COFINS = new InformacoesCOFINS(filhoAtual);
/*     */       }
/*  47 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSST"))
/*     */       {
/*  49 */         this.COFINSST = new InformacoesCOFINSST(filhoAtual);
/*     */       }
/*  51 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ISSQN"))
/*     */       {
/*  53 */         this.ISSQN = new InformacoesISSQN(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public InformacoesICMS getICMS()
/*     */   {
/*  63 */     return this.ICMS;
/*     */   }
/*     */ 
/*     */   public void setICMS(InformacoesICMS ICMS)
/*     */   {
/*  71 */     this.ICMS = ICMS;
/*     */   }
/*     */ 
/*     */   public void setPIS(InformacoesPIS PIS)
/*     */   {
/*  79 */     this.PIS = PIS;
/*     */   }
/*     */ 
/*     */   public InformacoesPIS getPIS()
/*     */   {
/*  87 */     return this.PIS;
/*     */   }
/*     */ 
/*     */   public void setPISST(InformacoesPISST PISST)
/*     */   {
/*  95 */     this.PISST = PISST;
/*     */   }
/*     */ 
/*     */   public InformacoesPISST getPISST()
/*     */   {
/* 103 */     return this.PISST;
/*     */   }
/*     */ 
/*     */   public void setCOFINS(InformacoesCOFINS COFINS)
/*     */   {
/* 111 */     this.COFINS = COFINS;
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINS getCOFINS()
/*     */   {
/* 119 */     return this.COFINS;
/*     */   }
/*     */ 
/*     */   public void setCOFINSST(InformacoesCOFINSST COFINSST)
/*     */   {
/* 127 */     this.COFINSST = COFINSST;
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINSST getCOFINSST()
/*     */   {
/* 135 */     return this.COFINSST;
/*     */   }
/*     */ 
/*     */   public void setISSQN(InformacoesISSQN ISSQN)
/*     */   {
/* 143 */     this.ISSQN = ISSQN;
/*     */   }
/*     */ 
/*     */   public InformacoesISSQN getISSQN()
/*     */   {
/* 151 */     return this.ISSQN;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 156 */     String resultado = "1000";
/* 157 */     if (((this.ICMS == null) && (this.ISSQN == null)) || ((this.ICMS != null) && (this.ISSQN != null)))
/*     */     {
/* 159 */       resultado = "1999";
/*     */     }
/* 161 */     else if (this.PIS == null)
/*     */     {
/* 163 */       resultado = "1999";
/*     */     }
/* 165 */     else if (this.COFINS == null)
/*     */     {
/* 167 */       resultado = "1999";
/*     */     }
/* 169 */     else if ((this.ICMS == null) || ((resultado = this.ICMS.validar()).equals("1000")))
/*     */     {
/* 172 */       if ((resultado = this.PIS.validar()).equals("1000"))
/*     */       {
/* 175 */         if ((this.PISST == null) || ((resultado = this.PISST.validar()).equals("1000")))
/*     */         {
/* 178 */           if ((resultado = this.COFINS.validar()).equals("1000"))
/*     */           {
/* 181 */             if ((this.COFINSST == null) || ((resultado = this.COFINSST.validar()).equals("1000")))
/*     */             {
/* 184 */               if (this.ISSQN != null) (resultado = this.ISSQN.validar()).equals("1000"); 
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 187 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 192 */     if (this.ICMS != null)
/*     */     {
/* 194 */       retorno.append("<ICMS>");
/* 195 */       this.ICMS.toString(retorno);
/* 196 */       retorno.append("</ICMS>");
/*     */     }
/* 198 */     if (this.PIS != null)
/*     */     {
/* 200 */       retorno.append("<PIS>");
/* 201 */       this.PIS.toString(retorno);
/* 202 */       retorno.append("</PIS>");
/*     */     }
/* 204 */     if (this.PISST != null)
/*     */     {
/* 206 */       retorno.append("<PISST>");
/* 207 */       this.PISST.toString(retorno);
/* 208 */       retorno.append("</PISST>");
/*     */     }
/* 210 */     if (this.COFINS != null)
/*     */     {
/* 212 */       retorno.append("<COFINS>");
/* 213 */       this.COFINS.toString(retorno);
/* 214 */       retorno.append("</COFINS>");
/*     */     }
/* 216 */     if (this.COFINSST != null)
/*     */     {
/* 218 */       retorno.append("<COFINSST>");
/* 219 */       this.COFINSST.toString(retorno);
/* 220 */       retorno.append("</COFINSST>");
/*     */     }
/* 222 */     if (this.ISSQN != null)
/*     */     {
/* 224 */       retorno.append("<ISSQN>");
/* 225 */       this.ISSQN.toString(retorno);
/* 226 */       retorno.append("</ISSQN>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.TributosCFe
 * JD-Core Version:    0.6.2
 */