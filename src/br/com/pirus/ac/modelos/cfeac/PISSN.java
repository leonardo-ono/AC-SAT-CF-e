/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class PISSN
/*    */ {
/* 61 */   private String CST = null;
/*    */ 
/*    */   public PISSN(Node no)
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
/*    */   public String validar()
/*    */   {
/* 46 */     String resultado = "1000";
/* 47 */     if (this.CST == null)
/* 48 */       resultado = "1999";
/* 49 */     else if (!this.CST.equals("49"))
/* 50 */       resultado = "1487";
/* 51 */     return resultado;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 56 */     if (this.CST != null)
/* 57 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.PISSN
 * JD-Core Version:    0.6.2
 */