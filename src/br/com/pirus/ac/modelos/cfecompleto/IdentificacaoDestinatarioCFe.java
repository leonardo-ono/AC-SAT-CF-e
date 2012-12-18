/*    */ package br.com.pirus.ac.modelos.cfecompleto;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class IdentificacaoDestinatarioCFe
/*    */ {
/* 82 */   private String CNPJ = null;
/*    */ 
/* 85 */   private String CPF = null;
/*    */ 
/* 87 */   private String xNome = null;
/*    */ 
/*    */   public IdentificacaoDestinatarioCFe(Node no)
/*    */   {
/* 20 */     NodeList filhos = no.getChildNodes();
/* 21 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 23 */       Node filhoAtual = filhos.item(i);
/* 24 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CPF"))
/*    */       {
/* 26 */         this.CPF = filhoAtual.getTextContent();
/*    */       }
/* 28 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CNPJ"))
/*    */       {
/* 30 */         this.CNPJ = filhoAtual.getTextContent();
/*    */       }
/* 32 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xNome"))
/*    */       {
/* 34 */         this.xNome = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getCNPJ()
/*    */   {
/* 44 */     return this.CNPJ;
/*    */   }
/*    */ 
/*    */   public void setCNPJ(String CNPJ)
/*    */   {
/* 52 */     this.CNPJ = CNPJ;
/*    */   }
/*    */ 
/*    */   public String getCPF()
/*    */   {
/* 60 */     return this.CPF;
/*    */   }
/*    */ 
/*    */   public void setCPF(String CPF)
/*    */   {
/* 68 */     this.CPF = CPF;
/*    */   }
/*    */ 
/*    */   public String getxNome()
/*    */   {
/* 73 */     return this.xNome;
/*    */   }
/*    */ 
/*    */   public void setxNome(String xNome)
/*    */   {
/* 78 */     this.xNome = xNome;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.IdentificacaoDestinatarioCFe
 * JD-Core Version:    0.6.2
 */