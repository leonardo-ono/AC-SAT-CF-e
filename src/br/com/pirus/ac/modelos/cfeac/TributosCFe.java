/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class TributosCFe
/*     */ {
/* 194 */   private InformacoesICMS ICMS = null;
/*     */ 
/* 197 */   private InformacoesPIS PIS = null;
/*     */ 
/* 200 */   private InformacoesPISST PISST = null;
/*     */ 
/* 203 */   private InformacoesCOFINS COFINS = null;
/*     */ 
/* 206 */   private InformacoesCOFINSST COFINSST = null;
/*     */ 
/* 209 */   private InformacoesISSQN ISSQN = null;
/*     */ 
/*     */   public TributosCFe(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ICMS"))
/*     */       {
/*  23 */         this.ICMS = new InformacoesICMS(filhoAtual);
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PIS"))
/*     */       {
/*  27 */         this.PIS = new InformacoesPIS(filhoAtual);
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("PISST"))
/*     */       {
/*  31 */         this.PISST = new InformacoesPISST(filhoAtual);
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINS"))
/*     */       {
/*  35 */         this.COFINS = new InformacoesCOFINS(filhoAtual);
/*     */       }
/*  37 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("COFINSST"))
/*     */       {
/*  39 */         this.COFINSST = new InformacoesCOFINSST(filhoAtual);
/*     */       }
/*  41 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ISSQN"))
/*     */       {
/*  43 */         this.ISSQN = new InformacoesISSQN(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public TributosCFe(InformacoesICMS ICMS, InformacoesPIS PIS, InformacoesPISST PISST, InformacoesCOFINS COFINS, InformacoesCOFINSST COFINSST)
/*     */   {
/*  50 */     this.ICMS = ICMS;
/*  51 */     this.PIS = PIS;
/*  52 */     this.PISST = PISST;
/*  53 */     this.COFINS = COFINS;
/*  54 */     this.COFINSST = COFINSST;
/*     */   }
/*     */ 
/*     */   public InformacoesICMS getICMS()
/*     */   {
/*  62 */     return this.ICMS;
/*     */   }
/*     */ 
/*     */   public void setICMS(InformacoesICMS ICMS)
/*     */   {
/*  70 */     this.ICMS = ICMS;
/*     */   }
/*     */ 
/*     */   public void setPIS(InformacoesPIS PIS)
/*     */   {
/*  78 */     this.PIS = PIS;
/*     */   }
/*     */ 
/*     */   public InformacoesPIS getPIS()
/*     */   {
/*  86 */     return this.PIS;
/*     */   }
/*     */ 
/*     */   public void setPISST(InformacoesPISST PISST)
/*     */   {
/*  94 */     this.PISST = PISST;
/*     */   }
/*     */ 
/*     */   public InformacoesPISST getPISST()
/*     */   {
/* 102 */     return this.PISST;
/*     */   }
/*     */ 
/*     */   public void setCOFINS(InformacoesCOFINS COFINS)
/*     */   {
/* 110 */     this.COFINS = COFINS;
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINS getCOFINS()
/*     */   {
/* 118 */     return this.COFINS;
/*     */   }
/*     */ 
/*     */   public void setCOFINSST(InformacoesCOFINSST COFINSST)
/*     */   {
/* 126 */     this.COFINSST = COFINSST;
/*     */   }
/*     */ 
/*     */   public InformacoesCOFINSST getCOFINSST()
/*     */   {
/* 134 */     return this.COFINSST;
/*     */   }
/*     */ 
/*     */   public void setISSQN(InformacoesISSQN ISSQN)
/*     */   {
/* 142 */     this.ISSQN = ISSQN;
/*     */   }
/*     */ 
/*     */   public InformacoesISSQN getISSQN()
/*     */   {
/* 150 */     return this.ISSQN;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 155 */     if (this.ICMS != null)
/*     */     {
/* 157 */       retorno.append("<ICMS>");
/* 158 */       this.ICMS.toString(retorno);
/* 159 */       retorno.append("</ICMS>");
/*     */     }
/* 161 */     if (this.PIS != null)
/*     */     {
/* 163 */       retorno.append("<PIS>");
/* 164 */       this.PIS.toString(retorno);
/* 165 */       retorno.append("</PIS>");
/*     */     }
/* 167 */     if (this.PISST != null)
/*     */     {
/* 169 */       retorno.append("<PISST>");
/* 170 */       this.PISST.toString(retorno);
/* 171 */       retorno.append("</PISST>");
/*     */     }
/* 173 */     if (this.COFINS != null)
/*     */     {
/* 175 */       retorno.append("<COFINS>");
/* 176 */       this.COFINS.toString(retorno);
/* 177 */       retorno.append("</COFINS>");
/*     */     }
/* 179 */     if (this.COFINSST != null)
/*     */     {
/* 181 */       retorno.append("<COFINSST>");
/* 182 */       this.COFINSST.toString(retorno);
/* 183 */       retorno.append("</COFINSST>");
/*     */     }
/* 185 */     if (this.ISSQN != null)
/*     */     {
/* 187 */       retorno.append("<ISSQN>");
/* 188 */       this.ISSQN.toString(retorno);
/* 189 */       retorno.append("</ISSQN>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.TributosCFe
 * JD-Core Version:    0.6.2
 */