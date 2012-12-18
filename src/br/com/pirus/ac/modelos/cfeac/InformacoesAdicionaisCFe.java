/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class InformacoesAdicionaisCFe
/*    */ {
/* 61 */   private String infCpl = null;
/*    */ 
/*    */   public InformacoesAdicionaisCFe(Node no)
/*    */   {
/* 17 */     NodeList filhos = no.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("infCpl"))
/*    */       {
/* 23 */         this.infCpl = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getInfCpl()
/*    */   {
/* 33 */     return this.infCpl;
/*    */   }
/*    */ 
/*    */   public void setInfCpl(String infCpl)
/*    */   {
/* 41 */     this.infCpl = infCpl;
/*    */   }
/*    */ 
/*    */   public String validar()
/*    */   {
/* 46 */     String resultado = "1000";
/* 47 */     if ((this.infCpl != null) && ((this.infCpl.length() < 1) || (this.infCpl.length() > 5000)))
/*    */     {
/* 49 */       resultado = "1999";
/*    */     }
/* 51 */     return resultado;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 56 */     if (this.infCpl != null)
/* 57 */       retorno.append("<infCpl>").append(this.infCpl).append("</infCpl>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesAdicionaisCFe
 * JD-Core Version:    0.6.2
 */