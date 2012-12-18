/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class ICMS40
/*    */ {
/* 83 */   private String orig = null;
/*    */ 
/* 91 */   private String CST = null;
/*    */ 
/*    */   public ICMS40(Node no)
/*    */   {
/* 17 */     NodeList filhos = no.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*    */       {
/* 23 */         this.orig = filhoAtual.getTextContent();
/*    */       }
/* 25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CST"))
/*    */       {
/* 27 */         this.CST = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public ICMS40(String orig, String CST)
/*    */   {
/* 34 */     this.orig = orig;
/* 35 */     this.CST = CST;
/*    */   }
/*    */ 
/*    */   public String getOrig()
/*    */   {
/* 43 */     return this.orig;
/*    */   }
/*    */ 
/*    */   public void setOrig(String orig)
/*    */   {
/* 51 */     this.orig = orig;
/*    */   }
/*    */ 
/*    */   public String getCST()
/*    */   {
/* 59 */     return this.CST;
/*    */   }
/*    */ 
/*    */   public void setCST(String CST)
/*    */   {
/* 67 */     this.CST = CST;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 72 */     if (this.orig != null)
/* 73 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/* 74 */     if (this.CST != null)
/* 75 */       retorno.append("<CST>").append(this.CST).append("</CST>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ICMS40
 * JD-Core Version:    0.6.2
 */