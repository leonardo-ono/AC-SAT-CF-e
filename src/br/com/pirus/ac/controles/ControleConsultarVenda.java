/*    */ package br.com.pirus.ac.controles;
/*    */ 
/*    */ import br.com.pirus.ac.interfaces.ControleACListener;
/*    */ import br.com.pirus.ac.interfaces.JanelaConsultar;
/*    */ import br.com.pirus.ac.utils.Utils;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class ControleConsultarVenda
/*    */   implements ActionListener, ControleACListener
/*    */ {
/*    */   private JanelaConsultar jConsultar;
/*    */   private ControleAC controleAC;
/*    */ 
/*    */   public ControleConsultarVenda(ControleAC controleAC, JanelaConsultar jConsultar)
/*    */   {
/* 18 */     this.controleAC = controleAC;
/* 19 */     this.jConsultar = jConsultar;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/* 24 */     if (this.jConsultar.getTextoSessao().getText().length() <= 0)
/* 25 */       JOptionPane.showMessageDialog(null, "Não existe nenhuma sessão para ser consultada!");
/* 26 */     this.controleAC.processarComandoConsultarCFe(this, Utils.getSenha(), Integer.parseInt(this.jConsultar.getTextoSessao().getText()));
/*    */   }
/*    */ 
/*    */   public void tratarResultado(String retorno)
/*    */   {
/* 31 */     System.out.println(retorno);
/* 32 */     String mensagemSefaz = "";
/* 33 */     if (retorno.indexOf("|") != -1)
/*    */     {
/* 35 */       mensagemSefaz = ControleDados.quebrarString(retorno, "|")[4];
/* 36 */       if (retorno.indexOf("06000") >= 0)
/* 37 */         retorno = ControleDados.quebrarString(retorno, "|")[3];
/*    */       else
/* 39 */         retorno = ControleDados.quebrarString(retorno, "|")[2];
/* 40 */       JOptionPane.showMessageDialog(null, retorno);
/* 41 */     } else if (retorno.length() > 0) {
/* 42 */       JOptionPane.showMessageDialog(null, retorno);
/* 43 */     }if (mensagemSefaz.length() > 0)
/* 44 */       JOptionPane.showMessageDialog(null, "ATENÇÃO!\nVocê recebeu a seguinte mensagem da SEFAZ:\n" + mensagemSefaz);
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleConsultarVenda
 * JD-Core Version:    0.6.2
 */