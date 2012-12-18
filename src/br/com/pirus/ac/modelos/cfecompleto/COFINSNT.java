/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class COFINSNT
/*    */ {
/* 86 */   private String CST = null;
/*    */ 
/*    */   public COFINSNT(Node no)
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
/*    */     {
/* 70 */       resultado = "1999";
/*    */     }
/* 72 */     else if ((!this.CST.equals("04")) && (!this.CST.equals("06")) && (!this.CST.equals("07")) && (!this.CST.equals("08")) && (!this.CST.equals("09")))
/*    */     {
/* 74 */       resultado = "1498";
/*    */     }
/* 76 */     return resultado;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 81 */     if (this.CST != null)
/* 82 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.COFINSNT
 * JD-Core Version:    0.6.2
 */