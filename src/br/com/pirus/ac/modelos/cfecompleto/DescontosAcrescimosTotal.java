/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class DescontosAcrescimosTotal
/*     */ {
/* 114 */   private String vDescSubtot = null;
/*     */ 
/* 117 */   private String vAcresSubtot = null;
/*     */ 
/*     */   public DescontosAcrescimosTotal(Node no)
/*     */   {
/*  28 */     NodeList filhos = no.getChildNodes();
/*  29 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  31 */       Node filhoAtual = filhos.item(i);
/*  32 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vDescSubtot"))
/*     */       {
/*  34 */         this.vDescSubtot = filhoAtual.getTextContent();
/*     */       }
/*  36 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAcresSubtot"))
/*     */       {
/*  38 */         this.vAcresSubtot = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvDescSubtot()
/*     */   {
/*  60 */     return this.vDescSubtot;
/*     */   }
/*     */ 
/*     */   public void setvDescSubtot(String vDescSubtot)
/*     */   {
/*  68 */     this.vDescSubtot = vDescSubtot;
/*     */   }
/*     */ 
/*     */   public String getvAcresSubtot()
/*     */   {
/*  76 */     return this.vAcresSubtot;
/*     */   }
/*     */ 
/*     */   public void setvAcresSubtot(String vAcresSubtot)
/*     */   {
/*  84 */     this.vAcresSubtot = vAcresSubtot;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/*  89 */     String resultado = "1000";
/*  90 */     if ((this.vDescSubtot != null) && (!ControleDados.validarDouble(1, 15, 2, this.vDescSubtot)))
/*     */     {
/*  92 */       resultado = "1999";
/*     */     }
/*  94 */     else if ((this.vAcresSubtot != null) && (!ControleDados.validarDouble(1, 15, 2, this.vAcresSubtot)))
/*     */     {
/*  96 */       resultado = "1999";
/*     */     }
/*  98 */     else if (((this.vDescSubtot == null) && (this.vAcresSubtot == null)) || ((this.vDescSubtot != null) && (this.vAcresSubtot != null)))
/*     */     {
/* 100 */       resultado = "1999";
/*     */     }
/* 102 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 107 */     if (this.vDescSubtot != null)
/* 108 */       retorno.append("<vDescSubtot>").append(this.vDescSubtot).append("</vDescSubtot>");
/* 109 */     if (this.vAcresSubtot != null)
/* 110 */       retorno.append("<vAcresSubtot>").append(this.vAcresSubtot).append("</vAcresSubtot>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.DescontosAcrescimosTotal
 * JD-Core Version:    0.6.2
 */