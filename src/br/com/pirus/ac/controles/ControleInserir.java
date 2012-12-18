/*    */ package br.com.pirus.ac.controles;
/*    */ 
/*    */ import br.com.pirus.ac.interfaces.JanelaAC;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class ControleInserir
/*    */   implements ActionListener
/*    */ {
/*    */   private JanelaAC janelaAC;
/*    */ 
/*    */   public ControleInserir(JanelaAC janelaAC)
/*    */   {
/* 14 */     this.janelaAC = janelaAC;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/* 19 */     String referencia = this.janelaAC.getValorReferencia().getText();
/* 20 */     String qtd = this.janelaAC.getValorQuantidade().getText();
/* 21 */     if ((referencia.length() <= 0) || (referencia == null))
/*    */     {
/* 23 */       JOptionPane.showMessageDialog(this.janelaAC, "O campo \"Referência\" é de preenchimento obrigatório!");
/* 24 */       return;
/*    */     }
/* 26 */     if ((qtd.length() <= 0) || (referencia == null))
/*    */     {
/* 28 */       JOptionPane.showMessageDialog(this.janelaAC, "O campo \"Quantidade\" é de preenchimento obrigatório!");
/* 29 */       return;
/*    */     }
/* 31 */     String unitario = this.janelaAC.getValorUnitario();
/* 32 */     String descricao = this.janelaAC.getDescricao();
/* 33 */     String unidade = this.janelaAC.getUnidade();
/* 34 */     String total = "" + (Double.parseDouble(qtd) * Double.parseDouble(unitario));
/* 35 */     this.janelaAC.adicionaLinha("" + (this.janelaAC.getQuantidadeLinhasTabela() + 1), referencia, descricao, unitario, qtd, unidade, total);
/* 36 */     this.janelaAC.atualizarTotalItens();
/* 37 */     this.janelaAC.atualizarTotal();
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleInserir
 * JD-Core Version:    0.6.2
 */