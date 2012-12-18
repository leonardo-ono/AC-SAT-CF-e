/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesCOFINSST
/*     */ {
/* 222 */   private String vBC = null;
/*     */ 
/* 225 */   private String pCOFINS = null;
/*     */ 
/* 228 */   private String qBCProd = null;
/*     */ 
/* 231 */   private String vAliqProd = null;
/*     */ 
/* 234 */   private String vCOFINS = null;
/*     */ 
/*     */   public InformacoesCOFINSST(Node no)
/*     */   {
/*  46 */     NodeList filhos = no.getChildNodes();
/*  47 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  49 */       Node filhoAtual = filhos.item(i);
/*  50 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  52 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  54 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pCOFINS"))
/*     */       {
/*  56 */         this.pCOFINS = filhoAtual.getTextContent();
/*     */       }
/*  58 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  60 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  62 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  64 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  74 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  82 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getpCOFINS()
/*     */   {
/*  90 */     return this.pCOFINS;
/*     */   }
/*     */ 
/*     */   public void setpCOFINS(String pCOFINS)
/*     */   {
/*  98 */     this.pCOFINS = pCOFINS;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/* 106 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/* 114 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/* 122 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 130 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public String getvCOFINS()
/*     */   {
/* 138 */     return this.vCOFINS;
/*     */   }
/*     */ 
/*     */   public void setvCOFINS(String vCOFINS)
/*     */   {
/* 146 */     this.vCOFINS = vCOFINS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 151 */     String resultado = "1000";
/* 152 */     if ((this.vBC == null) && (this.pCOFINS == null) && (this.qBCProd == null) && (this.vAliqProd == null))
/*     */     {
/* 154 */       resultado = "1999";
/*     */     }
/* 156 */     else if ((this.vBC != null) && ((this.pCOFINS != null) || ((this.qBCProd != null) && (this.vAliqProd != null))))
/*     */     {
/* 158 */       resultado = "1999";
/*     */     }
/* 160 */     else if ((this.pCOFINS != null) && ((this.vBC != null) || ((this.qBCProd != null) && (this.vAliqProd != null))))
/*     */     {
/* 162 */       resultado = "1999";
/*     */     }
/* 164 */     else if ((this.qBCProd != null) && ((this.pCOFINS != null) || ((this.vBC != null) && (this.vAliqProd != null))))
/*     */     {
/* 166 */       resultado = "1999";
/*     */     }
/* 168 */     else if ((this.vAliqProd != null) && ((this.pCOFINS != null) || ((this.qBCProd != null) && (this.vBC != null))))
/*     */     {
/* 170 */       resultado = "1999";
/*     */     }
/* 172 */     else if ((this.vBC != null) && (!ControleDados.validarDouble(1, 15, 2, this.vBC)))
/*     */     {
/* 174 */       resultado = "1999";
/*     */     }
/* 176 */     else if ((this.pCOFINS != null) && (!ControleDados.validarDouble(1, 5, 4, this.pCOFINS)))
/*     */     {
/* 178 */       resultado = "1999";
/*     */     }
/* 180 */     else if ((this.qBCProd != null) && (!ControleDados.validarDouble(1, 16, 4, this.qBCProd)))
/*     */     {
/* 182 */       resultado = "1999";
/*     */     }
/* 184 */     else if ((this.vAliqProd != null) && (!ControleDados.validarDouble(1, 15, 4, this.vAliqProd)))
/*     */     {
/* 186 */       resultado = "1999";
/*     */     }
/* 188 */     else if ((this.vBC != null) && (Double.parseDouble(this.vBC) < 0.0D))
/*     */     {
/* 190 */       resultado = "1491";
/*     */     }
/* 192 */     else if ((this.pCOFINS != null) && (Double.parseDouble(this.pCOFINS) < 0.0D))
/*     */     {
/* 194 */       resultado = "1492";
/*     */     }
/* 196 */     else if ((this.qBCProd != null) && (Double.parseDouble(this.qBCProd) < 0.0D))
/*     */     {
/* 198 */       resultado = "1483";
/*     */     }
/* 200 */     else if ((this.vAliqProd != null) && (Double.parseDouble(this.vAliqProd) < 0.0D))
/*     */     {
/* 202 */       resultado = "1496";
/*     */     }
/* 204 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 209 */     if (this.vBC != null)
/* 210 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 211 */     if (this.pCOFINS != null)
/* 212 */       retorno.append("<pCOFINS>").append(this.pCOFINS).append("</pCOFINS>");
/* 213 */     if (this.qBCProd != null)
/* 214 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 215 */     if (this.vAliqProd != null)
/* 216 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/* 217 */     if (this.vCOFINS != null)
/* 218 */       retorno.append("<vCOFINS>").append(ControleDados.formatarDouble(this.vCOFINS, 1, 15, 2)).append("</vCOFINS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesCOFINSST
 * JD-Core Version:    0.6.2
 */