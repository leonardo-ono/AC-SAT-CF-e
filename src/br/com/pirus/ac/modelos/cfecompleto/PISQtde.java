/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class PISQtde
/*     */ {
/* 179 */   private String CST = null;
/*     */ 
/* 182 */   private String qBCProd = null;
/*     */ 
/* 185 */   private String vAliqProd = null;
/*     */ 
/* 188 */   private String vPIS = null;
/*     */ 
/*     */   public PISQtde(Node no)
/*     */   {
/*  45 */     NodeList filhos = no.getChildNodes();
/*  46 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  48 */       Node filhoAtual = filhos.item(i);
/*  49 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  51 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  53 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qBCProd"))
/*     */       {
/*  55 */         this.qBCProd = filhoAtual.getTextContent();
/*     */       }
/*  57 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAliqProd"))
/*     */       {
/*  59 */         this.vAliqProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  69 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  77 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getqBCProd()
/*     */   {
/*  85 */     return this.qBCProd;
/*     */   }
/*     */ 
/*     */   public void setqBCProd(String qBCProd)
/*     */   {
/*  93 */     this.qBCProd = qBCProd;
/*     */   }
/*     */ 
/*     */   public String getvAliqProd()
/*     */   {
/* 101 */     return this.vAliqProd;
/*     */   }
/*     */ 
/*     */   public void setvAliqProd(String vAliqProd)
/*     */   {
/* 109 */     this.vAliqProd = vAliqProd;
/*     */   }
/*     */ 
/*     */   public String getvPIS()
/*     */   {
/* 117 */     return this.vPIS;
/*     */   }
/*     */ 
/*     */   public void setvPIS(String vPIS)
/*     */   {
/* 125 */     this.vPIS = vPIS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 130 */     String resultado = "1000";
/* 131 */     if (this.CST == null)
/*     */     {
/* 133 */       resultado = "1999";
/*     */     }
/* 135 */     else if (this.qBCProd == null)
/*     */     {
/* 137 */       resultado = "1999";
/*     */     }
/* 139 */     else if (this.vAliqProd == null)
/*     */     {
/* 141 */       resultado = "1999";
/*     */     }
/* 143 */     else if (!ControleDados.validarDouble(1, 16, 4, this.qBCProd))
/*     */     {
/* 145 */       resultado = "1999";
/*     */     }
/* 147 */     else if (!ControleDados.validarDouble(1, 15, 4, this.vAliqProd))
/*     */     {
/* 149 */       resultado = "1999";
/*     */     }
/* 151 */     else if (!this.CST.equals("03"))
/*     */     {
/* 153 */       resultado = "1482";
/*     */     }
/* 155 */     else if (Double.parseDouble(this.qBCProd) < 0.0D)
/*     */     {
/* 157 */       resultado = "1483";
/*     */     }
/* 159 */     else if (Double.parseDouble(this.vAliqProd) < 0.0D)
/*     */     {
/* 161 */       resultado = "1484";
/*     */     }
/* 163 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 168 */     if (this.CST != null)
/* 169 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 170 */     if (this.qBCProd != null)
/* 171 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/* 172 */     if (this.vAliqProd != null)
/* 173 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/* 174 */     if (this.vPIS != null)
/* 175 */       retorno.append("<vPIS>").append(ControleDados.formatarDouble(this.vPIS, 1, 15, 2)).append("</vPIS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.PISQtde
 * JD-Core Version:    0.6.2
 */