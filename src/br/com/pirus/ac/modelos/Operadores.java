/*    */ package br.com.pirus.ac.modelos;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class Operadores
/*    */ {
/* 49 */   private ArrayList<Operador> operadores = new ArrayList();
/*    */ 
/*    */   public Operadores(Node raiz)
/*    */   {
/* 17 */     NodeList filhos = raiz.getChildNodes();
/* 18 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 20 */       Node filhoAtual = filhos.item(i);
/* 21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("operador"))
/*    */       {
/* 23 */         Operador opAtual = new Operador(filhoAtual);
/* 24 */         this.operadores.add(opAtual);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public ArrayList<Operador> getOperadores()
/*    */   {
/* 31 */     return this.operadores;
/*    */   }
/*    */ 
/*    */   public void setOperadores(ArrayList<Operador> operadores)
/*    */   {
/* 36 */     this.operadores = operadores;
/*    */   }
/*    */ 
/*    */   public void toString(StringBuffer retorno)
/*    */   {
/* 41 */     retorno.append("<operadores>");
/* 42 */     for (int i = 0; i < this.operadores.size(); i++)
/*    */     {
/* 44 */       ((Operador)this.operadores.get(i)).toString(retorno);
/*    */     }
/* 46 */     retorno.append("</operadores>");
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.Operadores
 * JD-Core Version:    0.6.2
 */