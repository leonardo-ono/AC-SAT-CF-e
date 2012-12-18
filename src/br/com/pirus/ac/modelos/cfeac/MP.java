/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import br.com.pirus.ac.controles.ControleDados;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class MP
/*    */ {
/* 66 */   private String cMP = null;
/*    */ 
/* 69 */   private String vMP = null;
/*    */ 
/*    */   public MP(Node no)
/*    */   {
/* 18 */     NodeList filhos = no.getChildNodes();
/* 19 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 21 */       Node filhoAtual = filhos.item(i);
/* 22 */       if (filhoAtual.getNodeName().equalsIgnoreCase("cMP"))
/*    */       {
/* 24 */         this.cMP = filhoAtual.getTextContent();
/*    */       }
/* 26 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vMP"))
/*    */       {
/* 28 */         this.vMP = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public MP()
/*    */   {
/*    */   }
/*    */ 
/*    */   public String getcMP()
/*    */   {
/* 39 */     return this.cMP;
/*    */   }
/*    */ 
/*    */   public void setcMP(String cMP)
/*    */   {
/* 44 */     this.cMP = cMP;
/*    */   }
/*    */ 
/*    */   public String getvMP()
/*    */   {
/* 49 */     return this.vMP;
/*    */   }
/*    */ 
/*    */   public void setvMP(String vMP)
/*    */   {
/* 54 */     this.vMP = vMP;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 59 */     if (this.cMP != null)
/* 60 */       retorno.append("<cMP>").append(this.cMP).append("</cMP>");
/* 61 */     if (this.vMP != null)
/* 62 */       retorno.append("<vMP>").append(ControleDados.formatarDouble(this.vMP, 1, 15, 2)).append("</vMP>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.MP
 * JD-Core Version:    0.6.2
 */