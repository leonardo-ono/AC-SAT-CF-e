/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesISSQN
/*     */ {
/* 314 */   private String vDeducISSQN = null;
/*     */ 
/* 317 */   private String vBC = null;
/*     */ 
/* 320 */   private String vAliq = null;
/*     */ 
/* 323 */   private String vISSQN = null;
/*     */ 
/* 326 */   private String cMunFG = null;
/*     */ 
/* 329 */   private String cListServ = null;
/*     */ 
/* 332 */   private String cServTribMun = null;
/*     */ 
/* 345 */   private String cNatOp = null;
/*     */ 
/* 352 */   private String indIncFisc = null;
/*     */ 
/*     */   public InformacoesISSQN(Node no)
/*     */   {
/*  58 */     NodeList filhos = no.getChildNodes();
/*  59 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  61 */       Node filhoAtual = filhos.item(i);
/*  62 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vDeducISSQN"))
/*     */       {
/*  64 */         this.vDeducISSQN = filhoAtual.getTextContent();
/*     */       }
/*  66 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliq"))
/*     */       {
/*  68 */         this.vAliq = filhoAtual.getTextContent();
/*     */       }
/*  70 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cMunFG"))
/*     */       {
/*  72 */         this.cMunFG = filhoAtual.getTextContent();
/*     */       }
/*  74 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cListServ"))
/*     */       {
/*  76 */         this.cListServ = filhoAtual.getTextContent();
/*     */       }
/*  78 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cServTribMun"))
/*     */       {
/*  80 */         this.cServTribMun = filhoAtual.getTextContent();
/*     */       }
/*  82 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cNatOp"))
/*     */       {
/*  84 */         this.cNatOp = filhoAtual.getTextContent();
/*     */       }
/*  86 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("indIncFisc"))
/*     */       {
/*  88 */         this.indIncFisc = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvDeducISSQN()
/*     */   {
/*  98 */     return this.vDeducISSQN;
/*     */   }
/*     */ 
/*     */   public void setvDeducISSQN(String vDeducISSQN)
/*     */   {
/* 106 */     this.vDeducISSQN = vDeducISSQN;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/* 114 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/* 122 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getvAliq()
/*     */   {
/* 130 */     return this.vAliq;
/*     */   }
/*     */ 
/*     */   public void setvAliq(String vAliq)
/*     */   {
/* 138 */     this.vAliq = vAliq;
/*     */   }
/*     */ 
/*     */   public String getvISSQN()
/*     */   {
/* 146 */     return this.vISSQN;
/*     */   }
/*     */ 
/*     */   public void setvISSQN(String vISSQN)
/*     */   {
/* 154 */     this.vISSQN = vISSQN;
/*     */   }
/*     */ 
/*     */   public String getcMunFG()
/*     */   {
/* 162 */     return this.cMunFG;
/*     */   }
/*     */ 
/*     */   public void setcMunFG(String cMunFG)
/*     */   {
/* 170 */     this.cMunFG = cMunFG;
/*     */   }
/*     */ 
/*     */   public String getcListServ()
/*     */   {
/* 178 */     return this.cListServ;
/*     */   }
/*     */ 
/*     */   public void setcListServ(String cListServ)
/*     */   {
/* 186 */     this.cListServ = cListServ;
/*     */   }
/*     */ 
/*     */   public String getcServTribMun()
/*     */   {
/* 194 */     return this.cServTribMun;
/*     */   }
/*     */ 
/*     */   public void setcServTribMun(String cServTribMun)
/*     */   {
/* 202 */     this.cServTribMun = cServTribMun;
/*     */   }
/*     */ 
/*     */   public String getcNatOp()
/*     */   {
/* 210 */     return this.cNatOp;
/*     */   }
/*     */ 
/*     */   public void setcNatOp(String cNatOp)
/*     */   {
/* 218 */     this.cNatOp = cNatOp;
/*     */   }
/*     */ 
/*     */   public String getIndIncFisc()
/*     */   {
/* 226 */     return this.indIncFisc;
/*     */   }
/*     */ 
/*     */   public void setIndIncFisc(String indIncFisc)
/*     */   {
/* 234 */     this.indIncFisc = indIncFisc;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 239 */     String resultado = "1000";
/* 240 */     if (this.cMunFG == null)
/*     */     {
/* 242 */       resultado = "1999";
/*     */     }
/* 244 */     else if (this.cNatOp == null)
/*     */     {
/* 246 */       resultado = "1999";
/*     */     }
/* 248 */     else if (this.indIncFisc == null)
/*     */     {
/* 250 */       resultado = "1999";
/*     */     }
/* 252 */     else if ((this.vDeducISSQN != null) && (!ControleDados.validarDouble(1, 15, 2, this.vDeducISSQN)))
/*     */     {
/* 254 */       resultado = "1999";
/*     */     }
/* 256 */     else if ((this.vAliq != null) && (!ControleDados.validarDouble(1, 5, 2, this.vAliq)))
/*     */     {
/* 258 */       resultado = "1999";
/*     */     }
/* 260 */     else if ((this.cListServ != null) && (this.cListServ.length() != 5))
/*     */     {
/* 262 */       resultado = "1999";
/*     */     }
/* 264 */     else if ((this.cServTribMun != null) && (this.cServTribMun.length() != 20))
/*     */     {
/* 266 */       resultado = "1509";
/*     */     }
/* 268 */     else if ((this.vDeducISSQN != null) && (Double.parseDouble(this.vDeducISSQN) < 0.0D))
/*     */     {
/* 270 */       resultado = "1503";
/*     */     }
/* 272 */     else if ((this.vAliq != null) && ((Double.parseDouble(this.vAliq) < 2.0D) || (Double.parseDouble(this.vAliq) > 5.0D)))
/*     */     {
/* 274 */       resultado = "1505";
/*     */     }
/* 276 */     else if ((this.cListServ != null) && (Double.parseDouble(this.cListServ) < 0.0D))
/*     */     {
/* 278 */       resultado = "1508";
/*     */     }
/* 280 */     else if ((!this.cNatOp.equals("1")) && (!this.cNatOp.equals("2")) && (!this.cNatOp.equals("3")) && (!this.cNatOp.equals("4")) && (!this.cNatOp.equals("5")) && (!this.cNatOp.equals("6")) && (!this.cNatOp.equals("7")) && (!this.cNatOp.equals("8")))
/*     */     {
/* 282 */       resultado = "1510";
/*     */     }
/* 284 */     else if ((!this.indIncFisc.equals("1")) && (!this.indIncFisc.equals("2")))
/*     */     {
/* 286 */       resultado = "1511";
/*     */     }
/* 288 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 293 */     if (this.vDeducISSQN != null)
/* 294 */       retorno.append("<vDeducISSQN>").append(this.vDeducISSQN).append("</vDeducISSQN>");
/* 295 */     if (this.vBC != null)
/* 296 */       retorno.append("<vBC>").append(ControleDados.formatarDouble(this.vBC, 1, 15, 2)).append("</vBC>");
/* 297 */     if (this.vAliq != null)
/* 298 */       retorno.append("<vAliq>").append(this.vAliq).append("</vAliq>");
/* 299 */     if (this.vISSQN != null)
/* 300 */       retorno.append("<vISSQN>").append(ControleDados.formatarDouble(this.vISSQN, 1, 15, 2)).append("</vISSQN>");
/* 301 */     if (this.cMunFG != null)
/* 302 */       retorno.append("<cMunFG>").append(this.cMunFG).append("</cMunFG>");
/* 303 */     if (this.cListServ != null)
/* 304 */       retorno.append("<cListServ>").append(this.cListServ).append("</cListServ>");
/* 305 */     if (this.cServTribMun != null)
/* 306 */       retorno.append("<cServTribMun>").append(this.cServTribMun).append("</cServTribMun>");
/* 307 */     if (this.cNatOp != null)
/* 308 */       retorno.append("<cNatOp>").append(this.cNatOp).append("</cNatOp>");
/* 309 */     if (this.indIncFisc != null)
/* 310 */       retorno.append("<indIncFisc>").append(this.indIncFisc).append("</indIncFisc>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesISSQN
 * JD-Core Version:    0.6.2
 */