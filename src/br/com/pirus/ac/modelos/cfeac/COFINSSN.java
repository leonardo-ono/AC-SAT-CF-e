/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class COFINSSN
/*    */ {
/* 53 */   private String CST = null;
/*    */ 
/*    */   public COFINSSN(Node no)
/*    */   {
/* 17 */     NodeList filhos = no.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*    */       {
/* 23 */         this.CST = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getCST()
/*    */   {
/* 33 */     return this.CST;
/*    */   }
/*    */ 
/*    */   public void setCST(String CST)
/*    */   {
/* 41 */     this.CST = CST;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 46 */     if (this.CST != null)
/*    */     {
/* 48 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.COFINSSN
 * JD-Core Version:    0.6.2
 */