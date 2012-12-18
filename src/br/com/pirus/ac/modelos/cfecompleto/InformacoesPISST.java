/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesPISST
/*     */ {
/* 221 */   private String vBC = null;
/*     */ 
/* 224 */   private String pPIS = null;
/*     */ 
/* 227 */   private String qBCProd = null;
/*     */ 
/* 230 */   private String vAliqProd = null;
/*     */ 
/* 233 */   private String vPIS = null;
/*     */ 
/*     */   public InformacoesPISST(Node no)
/*     */   {
/*  45 */     NodeList filhos = no.getChildNodes();
/*  46 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  48 */       Node filhoAtual = filhos.item(i);
/*  49 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  51 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  53 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pPIS"))
/*     */       {
/*  55 */         this.pPIS = filhoAtual.getTextContent();
/*     */       }
/*  57 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  59 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  61 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  63 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  73 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  81 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getpPIS()
/*     */   {
/*  89 */     return this.pPIS;
/*     */   }
/*     */ 
/*     */   public void setpPIS(String pPIS)
/*     */   {
/*  97 */     this.pPIS = pPIS;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/* 105 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/* 113 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/* 121 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 129 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public String getvPIS()
/*     */   {
/* 137 */     return this.vPIS;
/*     */   }
/*     */ 
/*     */   public void setvPIS(String vPIS)
/*     */   {
/* 145 */     this.vPIS = vPIS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 150 */     String resultado = "1000";
/* 151 */     if ((this.vBC == null) && (this.pPIS == null) && (this.qBCProd == null) && (this.vAliqProd == null))
/*     */     {
/* 153 */       resultado = "1999";
/*     */     }
/* 155 */     else if ((this.vBC != null) && ((this.pPIS != null) || ((this.qBCProd != null) && (this.vAliqProd != null))))
/*     */     {
/* 157 */       resultado = "1999";
/*     */     }
/* 159 */     else if ((this.pPIS != null) && ((this.vBC != null) || ((this.qBCProd != null) && (this.vAliqProd != null))))
/*     */     {
/* 161 */       resultado = "1999";
/*     */     }
/* 163 */     else if ((this.qBCProd != null) && ((this.pPIS != null) || ((this.vBC != null) && (this.vAliqProd != null))))
/*     */     {
/* 165 */       resultado = "1999";
/*     */     }
/* 167 */     else if ((this.vAliqProd != null) && ((this.pPIS != null) || ((this.qBCProd != null) && (this.vBC != null))))
/*     */     {
/* 169 */       resultado = "1999";
/*     */     }
/* 171 */     else if ((this.vBC != null) && (!ControleDados.validarDouble(1, 15, 2, this.vBC)))
/*     */     {
/* 173 */       resultado = "1999";
/*     */     }
/* 175 */     else if ((this.pPIS != null) && (!ControleDados.validarDouble(1, 5, 4, this.pPIS)))
/*     */     {
/* 177 */       resultado = "1999";
/*     */     }
/* 179 */     else if ((this.qBCProd != null) && (!ControleDados.validarDouble(1, 16, 4, this.qBCProd)))
/*     */     {
/* 181 */       resultado = "1999";
/*     */     }
/* 183 */     else if ((this.vAliqProd != null) && (!ControleDados.validarDouble(1, 15, 4, this.vAliqProd)))
/*     */     {
/* 185 */       resultado = "1999";
/*     */     }
/* 187 */     else if ((this.vBC != null) && (Double.parseDouble(this.vBC) < 0.0D))
/*     */     {
/* 189 */       resultado = "1479";
/*     */     }
/* 191 */     else if ((this.pPIS != null) && (Double.parseDouble(this.pPIS) < 0.0D))
/*     */     {
/* 193 */       resultado = "1480";
/*     */     }
/* 195 */     else if ((this.qBCProd != null) && (Double.parseDouble(this.qBCProd) < 0.0D))
/*     */     {
/* 197 */       resultado = "1483";
/*     */     }
/* 199 */     else if ((this.vAliqProd != null) && (Double.parseDouble(this.vAliqProd) < 0.0D))
/*     */     {
/* 201 */       resultado = "1484";
/*     */     }
/* 203 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 208 */     if (this.vBC != null)
/* 209 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 210 */     if (this.pPIS != null)
/* 211 */       retorno.append("<pPIS>").append(this.pPIS).append("</pPIS>");
/* 212 */     if (this.qBCProd != null)
/* 213 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 214 */     if (this.vAliqProd != null)
/* 215 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/* 216 */     if (this.vPIS != null)
/* 217 */       retorno.append("<vPIS>").append(ControleDados.formatarDouble(this.vPIS, 1, 15, 2)).append("</vPIS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesPISST
 * JD-Core Version:    0.6.2
 */