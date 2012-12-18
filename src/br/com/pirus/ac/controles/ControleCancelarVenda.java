/*    */ package br.com.pirus.ac.controles;
/*    */ 
/*    */ import br.com.pirus.ac.interfaces.ControleACListener;
/*    */ import br.com.pirus.ac.interfaces.JanelaCancelar;
/*    */ import br.com.pirus.ac.utils.Utils;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class ControleCancelarVenda
/*    */   implements ActionListener, ControleACListener
/*    */ {
/*    */   private String CNPJ;
/*    */   private String IE;
/*    */   private String IM;
/*    */   private String idConsumidor;
/*    */   private JanelaCancelar janelaCanc;
/*    */ 
/*    */   public ControleCancelarVenda(JanelaCancelar janelaCanc, String CNPJ, String IE, String IM, String idConsumidor)
/*    */   {
/* 24 */     this.janelaCanc = janelaCanc;
/* 25 */     this.CNPJ = CNPJ;
/* 26 */     this.IE = IE;
/* 27 */     this.IM = IM;
/* 28 */     this.idConsumidor = idConsumidor;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/* 33 */     String chave = ControleArquivos.lerBytesArquivo("C:/AC/Cancelamento/infCanc.txt");
/* 34 */     if (chave == null)
/*    */     {
/* 36 */       JOptionPane.showMessageDialog(this.janelaCanc, "Não foi encontrado nenhum cupom emitido!");
/* 37 */       return;
/*    */     }
/* 39 */     this.janelaCanc.cAC.processarComandoCancelarCFe(this, Utils.getSenha(), chave, getDadosCancelamento());
/*    */   }
/*    */ 
/*    */   private String getDadosCancelamento()
/*    */   {
/* 44 */     String docCancelamento = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><CFeCanc><infCFe><emit>";
/* 45 */     docCancelamento = docCancelamento + "<CNPJ>" + this.CNPJ + "</CNPJ>";
/* 46 */     docCancelamento = docCancelamento + "<IE>" + this.IE + "</IE>";
/* 47 */     if ((this.IM != null) && (this.IM.length() > 0))
/* 48 */       docCancelamento = docCancelamento + "<IM>" + this.IM + "</IM>";
/* 49 */     docCancelamento = docCancelamento + "</emit><dest>";
/* 50 */     if (Utils.isValidCNPJ(this.idConsumidor))
/* 51 */       docCancelamento = docCancelamento + "<CNPJ>" + this.idConsumidor + "</CNPJ>";
/* 52 */     else if (Utils.isValidCPF(this.idConsumidor))
/* 53 */       docCancelamento = docCancelamento + "<CPF>" + this.idConsumidor + "</CPF>";
/* 54 */     docCancelamento = docCancelamento + "</dest></infCFe></CFeCanc>";
/* 55 */     return docCancelamento;
/*    */   }
/*    */ 
/*    */   public void tratarResultado(String retorno)
/*    */   {
/*    */     try
/*    */     {
/* 62 */       String mensagemSefaz = "";
/* 63 */       if (retorno.indexOf("|") != -1)
/*    */       {
/* 65 */         mensagemSefaz = ControleDados.quebrarString(retorno, "|")[5];
/* 66 */         retorno = ControleDados.quebrarString(retorno, "|")[3];
/* 67 */         JOptionPane.showMessageDialog(null, retorno);
/* 68 */       } else if (retorno.length() > 0)
/*    */       {
/* 70 */         JOptionPane.showMessageDialog(null, retorno);
/*    */       }
/*    */ 
/* 73 */       if (mensagemSefaz.length() > 0)
/* 74 */         JOptionPane.showMessageDialog(null, "ATENÇÃO!\nVocê recebeu a seguinte mensagem da SEFAZ:\n" + mensagemSefaz);
/*    */     }
/*    */     catch (Exception e) {
/* 77 */       e.printStackTrace();
/* 78 */       JOptionPane.showMessageDialog(null, retorno);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleCancelarVenda
 * JD-Core Version:    0.6.2
 */