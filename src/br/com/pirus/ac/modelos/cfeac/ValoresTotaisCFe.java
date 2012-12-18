/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class ValoresTotaisCFe
/*    */ {
/* 59 */   private DescontosAcrescimosTotal descAcrEntr = null;
/*    */ 
/*    */   public ValoresTotaisCFe(Node no)
/*    */   {
/* 17 */     NodeList filhos = no.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("DescAcrEntr"))
/*    */       {
/* 23 */         this.descAcrEntr = new DescontosAcrescimosTotal(filhoAtual);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public ValoresTotaisCFe()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DescontosAcrescimosTotal getDescAcrEntr()
/*    */   {
/* 37 */     return this.descAcrEntr;
/*    */   }
/*    */ 
/*    */   public void setDescAcrEntr(DescontosAcrescimosTotal descAcrEntrCfe)
/*    */   {
/* 45 */     this.descAcrEntr = descAcrEntrCfe;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 50 */     if (this.descAcrEntr != null)
/*    */     {
/* 52 */       retorno.append("<DescAcrEntr>");
/* 53 */       this.descAcrEntr.toString(retorno);
/* 54 */       retorno.append("</DescAcrEntr>");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ValoresTotaisCFe
 * JD-Core Version:    0.6.2
 */