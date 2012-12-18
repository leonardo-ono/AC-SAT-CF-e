/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class ICMSTotal
/*    */ {
/* 49 */   private String vCFe = null;
/*    */ 
/*    */   public ICMSTotal(Node no)
/*    */   {
/* 21 */     NodeList filhos = no.getChildNodes();
/* 22 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 24 */       Node filhoAtual = filhos.item(i);
/* 25 */       if (filhoAtual.getNodeName().equalsIgnoreCase("vCFe"))
/*    */       {
/* 27 */         this.vCFe = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getvCFe()
/*    */   {
/* 37 */     return this.vCFe;
/*    */   }
/*    */ 
/*    */   public void setvCFe(String vCFe)
/*    */   {
/* 45 */     this.vCFe = vCFe;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ICMSTotal
 * JD-Core Version:    0.6.2
 */