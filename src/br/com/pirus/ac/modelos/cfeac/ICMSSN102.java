/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class ICMSSN102
/*    */ {
/* 84 */   private String orig = null;
/*    */ 
/* 91 */   private String CSOSN = null;
/*    */ 
/*    */   public ICMSSN102(Node no)
/*    */   {
/* 17 */     NodeList filhos = no.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Orig"))
/*    */       {
/* 23 */         this.orig = filhoAtual.getTextContent();
/*    */       }
/* 25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CSOSN"))
/*    */       {
/* 27 */         this.CSOSN = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public ICMSSN102(String orig, String CSOSN)
/*    */   {
/* 34 */     this.orig = orig;
/* 35 */     this.CSOSN = CSOSN;
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
/*    */   public String getCSOSN()
/*    */   {
/* 59 */     return this.CSOSN;
/*    */   }
/*    */ 
/*    */   public void setCSOSN(String cSOSN)
/*    */   {
/* 67 */     this.CSOSN = cSOSN;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 72 */     if (this.orig != null)
/* 73 */       retorno.append("<Orig>").append(this.orig).append("</Orig>");
/* 74 */     if (this.CSOSN != null)
/* 75 */       retorno.append("<CSOSN>").append(this.CSOSN).append("</CSOSN>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ICMSSN102
 * JD-Core Version:    0.6.2
 */