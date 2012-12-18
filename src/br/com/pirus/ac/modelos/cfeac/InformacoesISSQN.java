/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesISSQN
/*     */ {
/* 183 */   private String vDeducISSQN = null;
/*     */ 
/* 186 */   private String vAliq = null;
/*     */ 
/* 189 */   private String cMunFG = null;
/*     */ 
/* 192 */   private String cListServ = null;
/*     */ 
/* 195 */   private String cServTribMun = null;
/*     */ 
/* 208 */   private String cNatOp = null;
/*     */ 
/* 215 */   private String indIncFisc = null;
/*     */ 
/*     */   public InformacoesISSQN(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vDeducISSQN"))
/*     */       {
/*  23 */         this.vDeducISSQN = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliq"))
/*     */       {
/*  27 */         this.vAliq = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cMunFG"))
/*     */       {
/*  31 */         this.cMunFG = filhoAtual.getTextContent();
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cListServ"))
/*     */       {
/*  35 */         this.cListServ = filhoAtual.getTextContent();
/*     */       }
/*  37 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cServTribMun"))
/*     */       {
/*  39 */         this.cServTribMun = filhoAtual.getTextContent();
/*     */       }
/*  41 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cNatOp"))
/*     */       {
/*  43 */         this.cNatOp = filhoAtual.getTextContent();
/*     */       }
/*  45 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("indIncFisc"))
/*     */       {
/*  47 */         this.indIncFisc = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvDeducISSQN()
/*     */   {
/*  57 */     return this.vDeducISSQN;
/*     */   }
/*     */ 
/*     */   public void setvDeducISSQN(String vDeducISSQN)
/*     */   {
/*  65 */     this.vDeducISSQN = vDeducISSQN;
/*     */   }
/*     */ 
/*     */   public String getvAliq()
/*     */   {
/*  73 */     return this.vAliq;
/*     */   }
/*     */ 
/*     */   public void setvAliq(String vAliq)
/*     */   {
/*  81 */     this.vAliq = vAliq;
/*     */   }
/*     */ 
/*     */   public String getcMunFG()
/*     */   {
/*  89 */     return this.cMunFG;
/*     */   }
/*     */ 
/*     */   public void setcMunFG(String cMunFG)
/*     */   {
/*  97 */     this.cMunFG = cMunFG;
/*     */   }
/*     */ 
/*     */   public String getcListServ()
/*     */   {
/* 105 */     return this.cListServ;
/*     */   }
/*     */ 
/*     */   public void setcListServ(String cListServ)
/*     */   {
/* 113 */     this.cListServ = cListServ;
/*     */   }
/*     */ 
/*     */   public String getcServTribMun()
/*     */   {
/* 121 */     return this.cServTribMun;
/*     */   }
/*     */ 
/*     */   public void setcServTribMun(String cServTribMun)
/*     */   {
/* 129 */     this.cServTribMun = cServTribMun;
/*     */   }
/*     */ 
/*     */   public String getcNatOp()
/*     */   {
/* 137 */     return this.cNatOp;
/*     */   }
/*     */ 
/*     */   public void setcNatOp(String cNatOp)
/*     */   {
/* 145 */     this.cNatOp = cNatOp;
/*     */   }
/*     */ 
/*     */   public String getIndIncFisc()
/*     */   {
/* 153 */     return this.indIncFisc;
/*     */   }
/*     */ 
/*     */   public void setIndIncFisc(String indIncFisc)
/*     */   {
/* 161 */     this.indIncFisc = indIncFisc;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 166 */     if (this.vDeducISSQN != null)
/* 167 */       retorno.append("<vDeducISSQN>").append(this.vDeducISSQN).append("</vDeducISSQN>");
/* 168 */     if (this.vAliq != null)
/* 169 */       retorno.append("<vAliq>").append(this.vAliq).append("</vAliq>");
/* 170 */     if (this.cMunFG != null)
/* 171 */       retorno.append("<cMunFG>").append(this.cMunFG).append("</cMunFG>");
/* 172 */     if (this.cListServ != null)
/* 173 */       retorno.append("<cListServ>").append(this.cListServ).append("</cListServ>");
/* 174 */     if (this.cServTribMun != null)
/* 175 */       retorno.append("<cServTribMun>").append(this.cServTribMun).append("</cServTribMun>");
/* 176 */     if (this.cNatOp != null)
/* 177 */       retorno.append("<cNatOp>").append(this.cNatOp).append("</cNatOp>");
/* 178 */     if (this.indIncFisc != null)
/* 179 */       retorno.append("<indIncFisc>").append(this.indIncFisc).append("</indIncFisc>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesISSQN
 * JD-Core Version:    0.6.2
 */