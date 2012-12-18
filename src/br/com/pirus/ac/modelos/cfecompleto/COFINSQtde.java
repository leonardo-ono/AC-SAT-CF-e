/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class COFINSQtde
/*     */ {
/* 187 */   private String CST = null;
/*     */ 
/* 190 */   private String qBCProd = null;
/*     */ 
/* 193 */   private String vAliqProd = null;
/*     */ 
/* 196 */   private String vCOFINS = null;
/*     */ 
/*     */   public COFINSQtde(Node no)
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
/*     */   public String getvCOFINS()
/*     */   {
/* 117 */     return this.vCOFINS;
/*     */   }
/*     */ 
/*     */   public void setvCOFINS(String vCOFINS)
/*     */   {
/* 125 */     this.vCOFINS = vCOFINS;
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
/* 153 */       resultado = "1494";
/*     */     }
/* 155 */     else if (Double.parseDouble(this.qBCProd) < 0.0D)
/*     */     {
/* 157 */       resultado = "1483";
/*     */     }
/* 159 */     else if (Double.parseDouble(this.vAliqProd) < 0.0D)
/*     */     {
/* 161 */       resultado = "1496";
/*     */     }
/* 163 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 168 */     if (this.CST != null)
/*     */     {
/* 170 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*     */     }
/* 172 */     if (this.qBCProd != null)
/*     */     {
/* 174 */       retorno.append("<qBCProd>").append(this.qBCProd).append("</qBCProd>");
/*     */     }
/* 176 */     if (this.vAliqProd != null)
/*     */     {
/* 178 */       retorno.append("<vAliqProd>").append(this.vAliqProd).append("</vAliqProd>");
/*     */     }
/* 180 */     if (this.vCOFINS != null)
/*     */     {
/* 182 */       retorno.append("<vCOFINS>").append(ControleDados.formatarDouble(this.vCOFINS, 1, 15, 2)).append("</vCOFINS>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.COFINSQtde
 * JD-Core Version:    0.6.2
 */