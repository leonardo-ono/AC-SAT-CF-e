/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class PISOutr
/*     */ {
/* 261 */   private String CST = null;
/*     */ 
/* 264 */   private String pPIS = null;
/*     */ 
/* 267 */   private String qBCProd = null;
/*     */ 
/* 270 */   private String vBC = null;
/*     */ 
/* 273 */   private String vAliqProd = null;
/*     */ 
/* 276 */   private String vPIS = null;
/*     */ 
/*     */   public PISOutr(Node no)
/*     */   {
/*  47 */     NodeList filhos = no.getChildNodes();
/*  48 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  50 */       Node filhoAtual = filhos.item(i);
/*  51 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  53 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  55 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  57 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  59 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pPIS"))
/*     */       {
/*  61 */         this.pPIS = filhoAtual.getTextContent();
/*     */       }
/*  63 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  65 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  67 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  69 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  79 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  87 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  95 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/* 103 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getpPIS()
/*     */   {
/* 111 */     return this.pPIS;
/*     */   }
/*     */ 
/*     */   public void setpPIS(String pPIS)
/*     */   {
/* 119 */     this.pPIS = pPIS;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/* 127 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/* 135 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/* 143 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 151 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public String getvPIS()
/*     */   {
/* 159 */     return this.vPIS;
/*     */   }
/*     */ 
/*     */   public void setvPIS(String vPIS)
/*     */   {
/* 167 */     this.vPIS = vPIS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 172 */     String resultado = "1000";
/* 173 */     if (this.CST == null)
/*     */     {
/* 175 */       resultado = "1999";
/*     */     }
/* 177 */     else if ((this.vBC == null) && (this.pPIS == null) && (this.qBCProd == null) && (this.vAliqProd == null))
/*     */     {
/* 179 */       resultado = "1999";
/*     */     }
/* 181 */     else if ((this.vBC == null) && (this.pPIS == null))
/*     */     {
/* 183 */       resultado = "1999";
/*     */     }
/* 185 */     else if ((this.qBCProd == null) && (this.vAliqProd == null))
/*     */     {
/* 187 */       resultado = "1999";
/*     */     }
/* 189 */     else if ((this.vBC != null) && (this.qBCProd != null) && (this.vAliqProd != null))
/*     */     {
/* 191 */       resultado = "1999";
/*     */     }
/* 193 */     else if ((this.pPIS != null) && (this.qBCProd != null) && (this.vAliqProd != null))
/*     */     {
/* 195 */       resultado = "1999";
/*     */     }
/* 197 */     else if ((this.qBCProd != null) && ((this.pPIS != null) || (this.vBC != null)))
/*     */     {
/* 199 */       resultado = "1999";
/*     */     }
/* 201 */     else if ((this.vAliqProd != null) && ((this.pPIS != null) || (this.vBC != null)))
/*     */     {
/* 203 */       resultado = "1999";
/*     */     }
/* 205 */     else if ((this.vBC != null) && (!ControleDados.validarDouble(1, 15, 2, this.vBC)))
/*     */     {
/* 207 */       resultado = "1999";
/*     */     }
/* 209 */     else if ((this.pPIS != null) && (!ControleDados.validarDouble(1, 5, 4, this.pPIS)))
/*     */     {
/* 211 */       resultado = "1999";
/*     */     }
/* 213 */     else if ((this.qBCProd != null) && (!ControleDados.validarDouble(1, 16, 4, this.qBCProd)))
/*     */     {
/* 215 */       resultado = "1999";
/*     */     }
/* 217 */     else if ((this.vAliqProd != null) && (!ControleDados.validarDouble(1, 15, 4, this.vAliqProd)))
/*     */     {
/* 219 */       resultado = "1999";
/*     */     }
/* 221 */     else if (!this.CST.equals("99"))
/*     */     {
/* 223 */       resultado = "1488";
/*     */     }
/* 225 */     else if ((this.vBC != null) && (Double.parseDouble(this.vBC) < 0.0D))
/*     */     {
/* 227 */       resultado = "1479";
/*     */     }
/* 229 */     else if ((this.pPIS != null) && (Double.parseDouble(this.pPIS) < 0.0D))
/*     */     {
/* 231 */       resultado = "1480";
/*     */     }
/* 233 */     else if ((this.qBCProd != null) && (Double.parseDouble(this.qBCProd) < 0.0D))
/*     */     {
/* 235 */       resultado = "1483";
/*     */     }
/* 237 */     else if ((this.vAliqProd != null) && (Double.parseDouble(this.vAliqProd) < 0.0D))
/*     */     {
/* 239 */       resultado = "1484";
/*     */     }
/* 241 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 246 */     if (this.CST != null)
/* 247 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 248 */     if (this.vBC != null)
/* 249 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 250 */     if (this.pPIS != null)
/* 251 */       retorno.append("<pPIS>").append(this.pPIS).append("</pPIS>");
/* 252 */     if (this.qBCProd != null)
/* 253 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 254 */     if (this.vAliqProd != null)
/* 255 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/* 256 */     if (this.vPIS != null)
/* 257 */       retorno.append("<vPIS>").append(ControleDados.formatarDouble(this.vPIS, 1, 15, 2)).append("</vPIS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.PISOutr
 * JD-Core Version:    0.6.2
 */