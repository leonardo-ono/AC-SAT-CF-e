/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.NamedNodeMap;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class DetalhamentoProdutosCFe
/*    */ {
/* 78 */   private String nItem = null;
/*    */ 
/* 81 */   private ProdutoCFe prod = null;
/*    */ 
/* 84 */   private TributosCFe imposto = null;
/*    */ 
/*    */   public DetalhamentoProdutosCFe(Node no)
/*    */   {
/* 21 */     NodeList filhos = no.getChildNodes();
/* 22 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 24 */       Node filhoAtual = filhos.item(i);
/* 25 */       if (filhoAtual.getNodeName().equalsIgnoreCase("prod"))
/*    */       {
/* 27 */         this.prod = new ProdutoCFe(filhoAtual);
/*    */       }
/* 29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("imposto"))
/*    */       {
/* 31 */         this.imposto = new TributosCFe(filhoAtual);
/*    */       }
/*    */     }
/* 34 */     NamedNodeMap atributos = no.getAttributes();
/* 35 */     for (int i = 0; i < atributos.getLength(); i++)
/*    */     {
/* 37 */       Node filhoAtual = atributos.item(i);
/* 38 */       if (filhoAtual.getNodeName().equalsIgnoreCase("nItem"))
/*    */       {
/* 40 */         this.nItem = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getNItem()
/*    */   {
/* 50 */     return this.nItem;
/*    */   }
/*    */ 
/*    */   public void setnItem(String nItem)
/*    */   {
/* 58 */     this.nItem = nItem;
/*    */   }
/*    */ 
/*    */   public ProdutoCFe getProd()
/*    */   {
/* 66 */     return this.prod;
/*    */   }
/*    */ 
/*    */   public TributosCFe getImposto()
/*    */   {
/* 74 */     return this.imposto;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe
 * JD-Core Version:    0.6.2
 */