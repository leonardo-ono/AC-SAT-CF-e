/*    */ package br.com.pirus.ac.modelos;
/*    */ 
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class Operador
/*    */ {
/* 84 */   private String id = null;
/*    */ 
/* 86 */   private String nome = null;
/*    */ 
/*    */   public Operador(Node raiz)
/*    */   {
/* 28 */     NodeList filhos = raiz.getChildNodes();
/* 29 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 31 */       Node filhoAtual = filhos.item(i);
/* 32 */       if (filhoAtual.getNodeName().equalsIgnoreCase("id"))
/*    */       {
/* 34 */         this.id = filhoAtual.getTextContent();
/*    */       }
/* 36 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("nome"))
/*    */       {
/* 38 */         this.nome = filhoAtual.getTextContent();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public Operador(String id, String nome)
/*    */   {
/* 45 */     this.id = id;
/* 46 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   public String getId()
/*    */   {
/* 51 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(String id)
/*    */   {
/* 56 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getNome()
/*    */   {
/* 61 */     return this.nome;
/*    */   }
/*    */ 
/*    */   public void setNome(String nome)
/*    */   {
/* 66 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 71 */     retorno.append("<operador>");
/* 72 */     if (this.id != null)
/* 73 */       retorno.append("<id>").append(this.id).append("</id>");
/* 74 */     if (this.nome != null)
/* 75 */       retorno.append("<nome>").append(this.nome).append("</nome>");
/* 76 */     retorno.append("</operador>");
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 81 */     return this.nome;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.Operador
 * JD-Core Version:    0.6.2
 */