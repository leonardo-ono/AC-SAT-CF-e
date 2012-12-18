/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class COFINSNT
/*    */ {
/* 56 */   private String CST = null;
/*    */ 
/*    */   public COFINSNT(Node no)
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
/*    */   public COFINSNT(String CST)
/*    */   {
/* 30 */     this.CST = CST;
/*    */   }
/*    */ 
/*    */   public String getCST()
/*    */   {
/* 38 */     return this.CST;
/*    */   }
/*    */ 
/*    */   public void setCST(String CST)
/*    */   {
/* 46 */     this.CST = CST;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 51 */     if (this.CST != null)
/* 52 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.COFINSNT
 * JD-Core Version:    0.6.2
 */