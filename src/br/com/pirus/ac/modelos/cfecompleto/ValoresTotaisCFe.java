/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class ValoresTotaisCFe
/*    */ {
/* 48 */   private ICMSTotal ICMSTot = null;
/*    */ 
/*    */   public ValoresTotaisCFe(Node no)
/*    */   {
/* 20 */     NodeList filhos = no.getChildNodes();
/* 21 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 23 */       Node filhoAtual = filhos.item(i);
/* 24 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ICMSTot"))
/*    */       {
/* 26 */         this.ICMSTot = new ICMSTotal(filhoAtual);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public ICMSTotal getICMSTot()
/*    */   {
/* 36 */     return this.ICMSTot;
/*    */   }
/*    */ 
/*    */   public void setICMSTot(ICMSTotal ICMSTotDfe)
/*    */   {
/* 44 */     this.ICMSTot = ICMSTotDfe;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ValoresTotaisCFe
 * JD-Core Version:    0.6.2
 */