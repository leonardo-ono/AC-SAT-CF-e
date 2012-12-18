/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class DescontosAcrescimosTotal
/*    */ {
/* 73 */   private String vDescSubtot = null;
/*    */ 
/* 76 */   private String vAcresSubtot = null;
/*    */ 
/*    */   public DescontosAcrescimosTotal(Node no)
/*    */   {
/* 17 */     NodeList filhos = no.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vDescSubtot"))
/*    */       {
/* 23 */         this.vDescSubtot = filhoAtual.getTextContent();
/*    */       }
/* 25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vAcresSubtot"))
/*    */       {
/* 27 */         this.vAcresSubtot = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getvDescSubtot()
/*    */   {
/* 37 */     return this.vDescSubtot;
/*    */   }
/*    */ 
/*    */   public void setvDescSubtot(String vDescSubtot)
/*    */   {
/* 45 */     this.vDescSubtot = vDescSubtot;
/*    */   }
/*    */ 
/*    */   public String getvAcresSubtot()
/*    */   {
/* 53 */     return this.vAcresSubtot;
/*    */   }
/*    */ 
/*    */   public void setvAcresSubtot(String vAcresSubtot)
/*    */   {
/* 61 */     this.vAcresSubtot = vAcresSubtot;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 66 */     if (this.vDescSubtot != null)
/* 67 */       retorno.append("<vDescSubtot>").append(this.vDescSubtot).append("</vDescSubtot>");
/* 68 */     if (this.vAcresSubtot != null)
/* 69 */       retorno.append("<vAcresSubtot>").append(this.vAcresSubtot).append("</vAcresSubtot>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.DescontosAcrescimosTotal
 * JD-Core Version:    0.6.2
 */