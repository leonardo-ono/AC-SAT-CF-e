/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesICMS
/*     */ {
/* 185 */   private ICMS00 ICMS00 = null;
/*     */ 
/* 193 */   private ICMS40 ICMS40 = null;
/*     */ 
/* 198 */   private ICMSSN102 ICMSSN102 = null;
/*     */ 
/* 203 */   private ICMSSN900 ICMSSN900 = null;
/*     */ 
/*     */   public InformacoesICMS(Node no)
/*     */   {
/*  27 */     NodeList filhos = no.getChildNodes();
/*  28 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  30 */       Node filhoAtual = filhos.item(i);
/*  31 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ICMS00"))
/*     */       {
/*  33 */         this.ICMS00 = new ICMS00(filhoAtual);
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ICMS40"))
/*     */       {
/*  37 */         this.ICMS40 = new ICMS40(filhoAtual);
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ICMSSN102"))
/*     */       {
/*  41 */         this.ICMSSN102 = new ICMSSN102(filhoAtual);
/*     */       }
/*  43 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("ICMSSN900"))
/*     */       {
/*  45 */         this.ICMSSN900 = new ICMSSN900(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public ICMS00 getICMS00()
/*     */   {
/*  55 */     return this.ICMS00;
/*     */   }
/*     */ 
/*     */   public void setICMS00(ICMS00 ICMS00CFe)
/*     */   {
/*  63 */     this.ICMS00 = ICMS00CFe;
/*     */   }
/*     */ 
/*     */   public ICMS40 getICMS40()
/*     */   {
/*  71 */     return this.ICMS40;
/*     */   }
/*     */ 
/*     */   public void setICMS40(ICMS40 ICMS40CFe)
/*     */   {
/*  79 */     this.ICMS40 = ICMS40CFe;
/*     */   }
/*     */ 
/*     */   public ICMSSN102 getICMSSN102()
/*     */   {
/*  87 */     return this.ICMSSN102;
/*     */   }
/*     */ 
/*     */   public void getICMSSN102(ICMSSN102 ICMSSN102CFe)
/*     */   {
/*  95 */     this.ICMSSN102 = ICMSSN102CFe;
/*     */   }
/*     */ 
/*     */   public ICMSSN900 getICMSSN900()
/*     */   {
/* 103 */     return this.ICMSSN900;
/*     */   }
/*     */ 
/*     */   public void getICMSSN900(ICMSSN900 ICMSSN900CFe)
/*     */   {
/* 111 */     this.ICMSSN900 = ICMSSN900CFe;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 116 */     String resultado = "1000";
/* 117 */     if ((this.ICMS00 == null) && (this.ICMS40 == null) && (this.ICMSSN102 == null) && (this.ICMSSN900 == null))
/*     */     {
/* 119 */       resultado = "1999";
/*     */     }
/* 121 */     else if ((this.ICMS00 != null) && ((this.ICMS40 != null) || (this.ICMSSN102 != null) || (this.ICMSSN900 != null)))
/*     */     {
/* 123 */       resultado = "1999";
/*     */     }
/* 125 */     else if ((this.ICMS40 != null) && ((this.ICMS00 != null) || (this.ICMSSN102 != null) || (this.ICMSSN900 != null)))
/*     */     {
/* 127 */       resultado = "1999";
/*     */     }
/* 129 */     else if ((this.ICMSSN102 != null) && ((this.ICMS00 != null) || (this.ICMS40 != null) || (this.ICMSSN900 != null)))
/*     */     {
/* 131 */       resultado = "1999";
/*     */     }
/* 133 */     else if ((this.ICMSSN900 != null) && ((this.ICMS00 != null) || (this.ICMS40 != null) || (this.ICMSSN102 != null)))
/*     */     {
/* 135 */       resultado = "1999";
/*     */     }
/* 137 */     else if ((this.ICMS00 == null) || ((resultado = this.ICMS00.validar()).equals("1000")))
/*     */     {
/* 140 */       if ((this.ICMS40 == null) || ((resultado = this.ICMS40.validar()).equals("1000")))
/*     */       {
/* 143 */         if ((this.ICMSSN102 == null) || ((resultado = this.ICMSSN102.validar()).equals("1000")))
/*     */         {
/* 146 */           if (this.ICMSSN900 != null) (resultado = this.ICMSSN900.validar()).equals("1000"); 
/*     */         }
/*     */       }
/*     */     }
/* 149 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 154 */     if (this.ICMS00 != null)
/*     */     {
/* 156 */       retorno.append("<ICMS00>");
/* 157 */       this.ICMS00.toString(retorno);
/* 158 */       retorno.append("</ICMS00>");
/*     */     }
/* 160 */     if (this.ICMS40 != null)
/*     */     {
/* 162 */       retorno.append("<ICMS40>");
/* 163 */       this.ICMS40.toString(retorno);
/* 164 */       retorno.append("</ICMS40>");
/*     */     }
/* 166 */     if (this.ICMSSN102 != null)
/*     */     {
/* 168 */       retorno.append("<ICMSSN102>");
/* 169 */       this.ICMSSN102.toString(retorno);
/* 170 */       retorno.append("</ICMSSN102>");
/*     */     }
/* 172 */     if (this.ICMSSN900 != null)
/*     */     {
/* 174 */       retorno.append("<ICMSSN900>");
/* 175 */       this.ICMSSN900.toString(retorno);
/* 176 */       retorno.append("</ICMSSN900>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesICMS
 * JD-Core Version:    0.6.2
 */