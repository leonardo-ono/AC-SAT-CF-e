/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import br.com.pirus.ac.controles.ControleDados;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class MP
/*    */ {
/* 75 */   private String cMP = null;
/*    */ 
/* 78 */   private String vMP = null;
/*    */ 
/*    */   public MP(Node no)
/*    */   {
/* 21 */     NodeList filhos = no.getChildNodes();
/* 22 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 24 */       Node filhoAtual = filhos.item(i);
/* 25 */       if (filhoAtual.getNodeName().equalsIgnoreCase("cMP"))
/*    */       {
/* 27 */         this.cMP = filhoAtual.getTextContent();
/*    */       }
/* 29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vMP"))
/*    */       {
/* 31 */         this.vMP = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String validar()
/*    */   {
/* 38 */     String resultado = "1000";
/* 39 */     if (this.cMP == null)
/*    */     {
/* 41 */       resultado = "1999";
/*    */     }
/* 43 */     else if (this.vMP == null)
/*    */     {
/* 45 */       resultado = "1999";
/*    */     }
/* 47 */     else if (!ControleDados.eNumerico(this.cMP))
/*    */     {
/* 49 */       resultado = "1999";
/*    */     }
/* 51 */     else if (!ControleDados.eNumerico(this.vMP))
/*    */     {
/* 53 */       resultado = "1999";
/*    */     }
/* 55 */     else if (this.cMP.length() != 1)
/*    */     {
/* 57 */       resultado = "1999";
/*    */     }
/* 59 */     else if (!ControleDados.validarDouble(1, 15, 2, this.vMP))
/*    */     {
/* 61 */       resultado = "1999";
/*    */     }
/* 63 */     return resultado;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 68 */     if (this.cMP != null)
/* 69 */       retorno.append("<cMP>").append(this.cMP).append("</cMP>");
/* 70 */     if (this.vMP != null)
/* 71 */       retorno.append("<vMP>").append(ControleDados.formatarDouble(this.vMP, 1, 15, 2)).append("</vMP>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.MP
 * JD-Core Version:    0.6.2
 */