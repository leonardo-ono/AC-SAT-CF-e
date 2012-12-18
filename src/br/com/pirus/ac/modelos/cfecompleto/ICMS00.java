/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ICMS00
/*     */ {
/* 179 */   private String orig = null;
/*     */ 
/* 186 */   private String CST = null;
/*     */ 
/* 189 */   private String pICMS = null;
/*     */ 
/* 192 */   private String vICMS = null;
/*     */ 
/*     */   public ICMS00(Node no)
/*     */   {
/*  45 */     NodeList filhos = no.getChildNodes();
/*  46 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  48 */       Node filhoAtual = filhos.item(i);
/*  49 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*     */       {
/*  51 */         this.orig = filhoAtual.getTextContent();
/*     */       }
/*  53 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*     */       {
/*  55 */         this.CST = filhoAtual.getTextContent();
/*     */       }
/*  57 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pICMS"))
/*     */       {
/*  59 */         this.pICMS = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getOrig()
/*     */   {
/*  69 */     return this.orig;
/*     */   }
/*     */ 
/*     */   public void setOrig(String orig)
/*     */   {
/*  77 */     this.orig = orig;
/*     */   }
/*     */ 
/*     */   public String getCST()
/*     */   {
/*  85 */     return this.CST;
/*     */   }
/*     */ 
/*     */   public void setCST(String CST)
/*     */   {
/*  93 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   public String getpICMS()
/*     */   {
/* 101 */     return this.pICMS;
/*     */   }
/*     */ 
/*     */   public void setpICMS(String pICMS)
/*     */   {
/* 109 */     this.pICMS = pICMS;
/*     */   }
/*     */ 
/*     */   public String getvICMS()
/*     */   {
/* 117 */     return this.vICMS;
/*     */   }
/*     */ 
/*     */   public void setvICMS(String vICMS)
/*     */   {
/* 125 */     this.vICMS = vICMS;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 130 */     String resultado = "1000";
/* 131 */     if (this.orig == null)
/*     */     {
/* 133 */       resultado = "1999";
/*     */     }
/* 135 */     else if (this.CST == null)
/*     */     {
/* 137 */       resultado = "1999";
/*     */     }
/* 139 */     else if (this.pICMS == null)
/*     */     {
/* 141 */       resultado = "1999";
/*     */     }
/* 143 */     else if ((!this.orig.equals("0")) && (!this.orig.equals("1")) && (!this.orig.equals("2")))
/*     */     {
/* 145 */       resultado = "1471";
/*     */     }
/* 147 */     else if ((!this.CST.equals("00")) && (!this.CST.equals("20")) && (!this.CST.equals("90")))
/*     */     {
/* 149 */       resultado = "1472";
/*     */     }
/* 151 */     else if (!ControleDados.validarDouble(1, 5, 2, this.pICMS))
/*     */     {
/* 153 */       resultado = "1999";
/*     */     }
/* 155 */     else if (Double.parseDouble(this.pICMS) < 0.0D)
/*     */     {
/* 157 */       resultado = "1473";
/*     */     }
/* 159 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 164 */     if (this.orig != null)
/* 165 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/* 166 */     if (this.CST != null)
/* 167 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/* 168 */     if (this.pICMS != null)
/* 169 */       retorno.append("<pICMS>").append(this.pICMS).append("</pICMS>");
/* 170 */     if (this.vICMS != null)
/* 171 */       retorno.append("<vICMS>").append(ControleDados.formatarDouble(this.vICMS, 1, 15, 2)).append("</vICMS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ICMS00
 * JD-Core Version:    0.6.2
 */