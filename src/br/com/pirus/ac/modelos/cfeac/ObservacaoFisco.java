/*    */ package br.com.pirus.ac.modelos.cfeac;
/*    */ 
/*    */ import org.w3c.dom.NamedNodeMap;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class ObservacaoFisco
/*    */ {
/* 77 */   private String xCampoDet = null;
/*    */ 
/* 80 */   private String xTextoDet = null;
/*    */ 
/*    */   public ObservacaoFisco(Node no)
/*    */   {
/* 18 */     NodeList filhos = no.getChildNodes();
/* 19 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 21 */       Node filhoAtual = filhos.item(i);
/* 22 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xTextoDet"))
/*    */       {
/* 24 */         this.xTextoDet = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/* 27 */     NamedNodeMap atributos = no.getAttributes();
/* 28 */     for (int i = 0; i < atributos.getLength(); i++)
/*    */     {
/* 30 */       Node filhoAtual = atributos.item(i);
/* 31 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xCampoDet"))
/*    */       {
/* 33 */         this.xCampoDet = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getxCampoDet()
/*    */   {
/* 43 */     return this.xCampoDet;
/*    */   }
/*    */ 
/*    */   public void setxCampoDet(String xCampoDet)
/*    */   {
/* 51 */     this.xCampoDet = xCampoDet;
/*    */   }
/*    */ 
/*    */   public String getxTextoDet()
/*    */   {
/* 59 */     return this.xTextoDet;
/*    */   }
/*    */ 
/*    */   public void setxTextoDet(String xTextoDet)
/*    */   {
/* 67 */     this.xTextoDet = xTextoDet;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 72 */     if (this.xTextoDet != null)
/* 73 */       retorno.append("<xTextoDet>").append(this.xTextoDet).append("</xTextoDet>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ObservacaoFisco
 * JD-Core Version:    0.6.2
 */