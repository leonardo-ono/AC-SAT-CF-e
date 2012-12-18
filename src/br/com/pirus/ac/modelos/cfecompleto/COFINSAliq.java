/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class COFINSAliq
/*     */ {
/* 180 */   private String CST = null;
/*     */ 
/* 183 */   private String pCOFINS = null;
/*     */ 
/* 186 */   private String vCOFINS = null;
/*     */ 
/* 189 */   private String vBC = null;
/*     */ 
/*     */   public COFINSAliq(Node no)
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
/*  55 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("pCOFINS"))
/*     */       {
/*  57 */         this.pCOFINS = filhoAtual.getTextContent();
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
/*     */   public String getpCOFINS()
/*     */   {
/*  83 */     return this.pCOFINS;
/*     */   }
/*     */ 
/*     */   public void setpCOFINS(String pCOFINS)
/*     */   {
/*  91 */     this.pCOFINS = pCOFINS;
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
/*     */   public String getvCOFINS()
/*     */   {
/* 115 */     return this.vCOFINS;
/*     */   }
/*     */ 
/*     */   public void setvCOFINS(String vCOFINS)
/*     */   {
/* 123 */     this.vCOFINS = vCOFINS;
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
/* 137 */     else if (this.pCOFINS == null)
/*     */     {
/* 139 */       resultado = "1999";
/*     */     }
/* 141 */     else if (!ControleDados.validarDouble(1, 15, 2, this.vBC))
/*     */     {
/* 143 */       resultado = "1999";
/*     */     }
/* 145 */     else if (!ControleDados.validarDouble(1, 5, 4, this.pCOFINS))
/*     */     {
/* 147 */       resultado = "1999";
/*     */     }
/* 149 */     else if ((!this.CST.equals("01")) && (!this.CST.equals("02")))
/*     */     {
/* 151 */       resultado = "1490";
/*     */     }
/* 153 */     else if (Double.parseDouble(this.vBC) < 0.0D)
/*     */     {
/* 155 */       resultado = "1491";
/*     */     }
/* 157 */     else if (Double.parseDouble(this.pCOFINS) < 0.0D)
/*     */     {
/* 159 */       resultado = "1492";
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
/* 170 */     if (this.pCOFINS != null)
/* 171 */       retorno.append("<pCOFINS>").append(this.pCOFINS).append("</pCOFINS>");
/* 172 */     if (this.vCOFINS != null)
/* 173 */       retorno.append("<vCOFINS>").append(ControleDados.formatarDouble(this.vCOFINS, 1, 15, 2)).append("</vCOFINS>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.COFINSAliq
 * JD-Core Version:    0.6.2
 */