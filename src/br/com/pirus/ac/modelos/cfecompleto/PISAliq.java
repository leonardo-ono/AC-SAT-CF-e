/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class PISAliq
/*     */ {
/* 180 */   private String CST = null;
/*     */ 
/* 183 */   private String pPIS = null;
/*     */ 
/* 186 */   private String vPIS = null;
/*     */ 
/* 189 */   private String vBC = null;
/*     */ 
/*     */   public PISAliq(Node no)
/*     */   {
/*  43 */     NodeList filhos = no.getChildNodes();
/*  44 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  46 */       Node filhoAtual = filhos.item(i);
/*  47 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  49 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  51 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vBC"))
/*     */       {
/*  53 */         this.vBC = filhoAtual.getTextContent();
/*     */       }
/*  55 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pPIS"))
/*     */       {
/*  57 */         this.pPIS = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  67 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  75 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getpPIS()
/*     */   {
/*  83 */     return this.pPIS;
/*     */   }
/*     */ 
/*     */   public void setpPIS(String pPIS)
/*     */   {
/*  91 */     this.pPIS = pPIS;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  99 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/* 107 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getvPIS()
/*     */   {
/* 115 */     return this.vPIS;
/*     */   }
/*     */ 
/*     */   public void setvPIS(String vPIS)
/*     */   {
/* 123 */     this.vPIS = vPIS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 128 */     String resultado = "1000";
/* 129 */     if (this.CST == null)
/*     */     {
/* 131 */       resultado = "1999";
/*     */     }
/* 133 */     else if (this.vBC == null)
/*     */     {
/* 135 */       resultado = "1999";
/*     */     }
/* 137 */     else if (this.pPIS == null)
/*     */     {
/* 139 */       resultado = "1999";
/*     */     }
/* 141 */     else if (!ControleDados.validarDouble(1, 15, 2, this.vBC))
/*     */     {
/* 143 */       resultado = "1999";
/*     */     }
/* 145 */     else if (!ControleDados.validarDouble(1, 5, 4, this.pPIS))
/*     */     {
/* 147 */       resultado = "1999";
/*     */     }
/* 149 */     else if ((!this.CST.equals("01")) && (!this.CST.equals("02")))
/*     */     {
/* 151 */       resultado = "1478";
/*     */     }
/* 153 */     else if (Double.parseDouble(this.vBC) < 0.0D)
/*     */     {
/* 155 */       resultado = "1479";
/*     */     }
/* 157 */     else if (Double.parseDouble(this.pPIS) < 0.0D)
/*     */     {
/* 159 */       resultado = "1480";
/*     */     }
/* 161 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 166 */     if (this.CST != null)
/* 167 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 168 */     if (this.vBC != null)
/* 169 */       retorno.append("<vBC>").append(this.vBC).append("</vBC>");
/* 170 */     if (this.pPIS != null)
/* 171 */       retorno.append("<pPIS>").append(this.pPIS).append("</pPIS>");
/* 172 */     if (this.vPIS != null)
/* 173 */       retorno.append("<vPIS>").append(ControleDados.formatarDouble(this.vPIS, 1, 15, 2)).append("</vPIS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.PISAliq
 * JD-Core Version:    0.6.2
 */