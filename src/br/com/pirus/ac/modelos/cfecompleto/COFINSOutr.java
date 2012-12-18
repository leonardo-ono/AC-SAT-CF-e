/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class COFINSOutr
/*     */ {
/* 254 */   private String CST = null;
/*     */ 
/* 257 */   private String pCOFINS = null;
/*     */ 
/* 260 */   private String qBCProd = null;
/*     */ 
/* 263 */   private String vBC = null;
/*     */ 
/* 266 */   private String vAliqProd = null;
/*     */ 
/* 269 */   private String vCOFINS = null;
/*     */ 
/*     */   public COFINSOutr(Node no)
/*     */   {
/*  48 */     NodeList filhos = no.getChildNodes();
/*  49 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  51 */       Node filhoAtual = filhos.item(i);
/*  52 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  54 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  56 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  58 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  60 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pCOFINS"))
/*     */       {
/*  62 */         this.pCOFINS = filhoAtual.getTextContent();
/*     */       }
/*  64 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  66 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  68 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  70 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  80 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  88 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  96 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/* 104 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getpCOFINS()
/*     */   {
/* 112 */     return this.pCOFINS;
/*     */   }
/*     */ 
/*     */   public void setpCOFINS(String pCOFINS)
/*     */   {
/* 120 */     this.pCOFINS = pCOFINS;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/* 128 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/* 136 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/* 144 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 152 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public String getvCOFINS()
/*     */   {
/* 160 */     return this.vCOFINS;
/*     */   }
/*     */ 
/*     */   public void setvCOFINS(String vCOFINS)
/*     */   {
/* 168 */     this.vCOFINS = vCOFINS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 173 */     String resultado = "1000";
/* 174 */     if (this.CST == null)
/*     */     {
/* 176 */       resultado = "1999";
/*     */     }
/* 178 */     else if ((this.vBC == null) && (this.pCOFINS == null) && (this.qBCProd == null) && (this.vAliqProd == null))
/*     */     {
/* 180 */       resultado = "1999";
/*     */     }
/* 182 */     else if ((this.vBC != null) && ((this.pCOFINS != null) || ((this.qBCProd != null) && (this.vAliqProd != null))))
/*     */     {
/* 184 */       resultado = "1999";
/*     */     }
/* 186 */     else if ((this.pCOFINS != null) && ((this.vBC != null) || ((this.qBCProd != null) && (this.vAliqProd != null))))
/*     */     {
/* 188 */       resultado = "1999";
/*     */     }
/* 190 */     else if ((this.qBCProd != null) && ((this.pCOFINS != null) || ((this.vBC != null) && (this.vAliqProd != null))))
/*     */     {
/* 192 */       resultado = "1999";
/*     */     }
/* 194 */     else if ((this.vAliqProd != null) && ((this.pCOFINS != null) || ((this.qBCProd != null) && (this.vBC != null))))
/*     */     {
/* 196 */       resultado = "1999";
/*     */     }
/* 198 */     else if ((this.vBC != null) && (!ControleDados.validarDouble(1, 15, 2, this.vBC)))
/*     */     {
/* 200 */       resultado = "1999";
/*     */     }
/* 202 */     else if ((this.pCOFINS != null) && (!ControleDados.validarDouble(1, 5, 4, this.pCOFINS)))
/*     */     {
/* 204 */       resultado = "1999";
/*     */     }
/* 206 */     else if ((this.qBCProd != null) && (!ControleDados.validarDouble(1, 16, 4, this.qBCProd)))
/*     */     {
/* 208 */       resultado = "1999";
/*     */     }
/* 210 */     else if ((this.vAliqProd != null) && (!ControleDados.validarDouble(1, 15, 4, this.vAliqProd)))
/*     */     {
/* 212 */       resultado = "1999";
/*     */     }
/* 214 */     else if (!this.CST.equals("99"))
/*     */     {
/* 216 */       resultado = "1500";
/*     */     }
/* 218 */     else if ((this.vBC != null) && (Double.parseDouble(this.vBC) < 0.0D))
/*     */     {
/* 220 */       resultado = "1491";
/*     */     }
/* 222 */     else if ((this.pCOFINS != null) && (Double.parseDouble(this.pCOFINS) < 0.0D))
/*     */     {
/* 224 */       resultado = "1492";
/*     */     }
/* 226 */     else if ((this.qBCProd != null) && (Double.parseDouble(this.qBCProd) < 0.0D))
/*     */     {
/* 228 */       resultado = "1483";
/*     */     }
/* 230 */     else if ((this.vAliqProd != null) && (Double.parseDouble(this.vAliqProd) < 0.0D))
/*     */     {
/* 232 */       resultado = "1496";
/*     */     }
/* 234 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 239 */     if (this.CST != null)
/* 240 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 241 */     if (this.vBC != null)
/* 242 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 243 */     if (this.pCOFINS != null)
/* 244 */       retorno.append("<pCOFINS>").append(this.pCOFINS).append("</pCOFINS>");
/* 245 */     if (this.qBCProd != null)
/* 246 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 247 */     if (this.vAliqProd != null)
/* 248 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/* 249 */     if (this.vCOFINS != null)
/* 250 */       retorno.append("<vCOFINS>").append(ControleDados.formatarDouble(this.vCOFINS, 1, 15, 2)).append("</vCOFINS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.COFINSOutr
 * JD-Core Version:    0.6.2
 */