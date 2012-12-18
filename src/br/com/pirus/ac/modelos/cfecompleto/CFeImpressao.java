/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class CFeImpressao
/*    */ {
/* 56 */   private InformacoesCFe infCFe = null;
/*    */   public static final int TESTE = 2;
/*    */   public static final int REAL = 1;
/*    */ 
/*    */   public CFeImpressao()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CFeImpressao(Node raiz)
/*    */   {
/* 27 */     this();
/* 28 */     NodeList filhos = raiz.getChildNodes();
/* 29 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 31 */       Node filhoAtual = filhos.item(i);
/* 32 */       if (filhoAtual.getNodeName().equalsIgnoreCase("infCFe"))
/*    */       {
/* 34 */         this.infCFe = new InformacoesCFe(filhoAtual);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setInfCFe(InformacoesCFe inf)
/*    */   {
/* 44 */     this.infCFe = inf;
/*    */   }
/*    */ 
/*    */   public InformacoesCFe getInfCFe()
/*    */   {
/* 52 */     return this.infCFe;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.CFeImpressao
 * JD-Core Version:    0.6.2
 */