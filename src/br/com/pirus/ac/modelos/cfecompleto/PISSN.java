/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class PISSN
/*    */ {
/* 82 */   private String CST = null;
/*    */ 
/*    */   public PISSN(Node no)
/*    */   {
/* 38 */     NodeList filhos = no.getChildNodes();
/* 39 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 41 */       Node filhoAtual = filhos.item(i);
/* 42 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*    */       {
/* 44 */         this.CST = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getCST()
/*    */   {
/* 54 */     return this.CST;
/*    */   }
/*    */ 
/*    */   public void setCST(String CST)
/*    */   {
/* 62 */     this.CST = CST;
/*    */   }
/*    */ 
/*    */   public String validar()
/*    */   {
/* 67 */     String resultado = "1000";
/* 68 */     if (this.CST == null)
/* 69 */       resultado = "1999";
/* 70 */     else if (!this.CST.equals("49"))
/* 71 */       resultado = "1487";
/* 72 */     return resultado;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 77 */     if (this.CST != null)
/* 78 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.PISSN
 * JD-Core Version:    0.6.2
 */