/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleAC;
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.controles.ControleCancelarVenda;
/*     */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class JanelaCancelar extends JFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private JPanel jContentPane = null;
/*     */ 
/*  30 */   private JButton botaoOK = null;
/*     */ 
/*  32 */   private JButton botaoCancelar = null;
/*     */ 
/*  34 */   private JLabel labelCupom = null;
/*     */ 
/*  36 */   private JTextField textoCupom = null;
/*     */ 
/*  38 */   private ControleCancelarVenda cCancelar = null;
/*     */   public ControleAC cAC;
/*     */   private JanelaAC jAC;
/*     */   private IdentificacaoEmitenteCFe baseEMIT;
/*     */ 
/*     */   public JanelaCancelar(ControleAC cAC, JanelaAC jAC, IdentificacaoEmitenteCFe baseEMIT)
/*     */   {
/*  52 */     this.cAC = cAC;
/*  53 */     this.jAC = jAC;
/*  54 */     this.baseEMIT = baseEMIT;
/*  55 */     this.cCancelar = new ControleCancelarVenda(this, baseEMIT.getCNPJ(), baseEMIT.getIE(), baseEMIT.getIM(), jAC.getIdConsumidor().getText());
/*  56 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  68 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e) {
/*  71 */       e.printStackTrace();
/*     */     }
/*  73 */     setSize(330, 132);
/*  74 */     setResizable(false);
/*  75 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  76 */     setTitle("Cancelar último cupom fiscal");
/*  77 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  87 */     if (this.jContentPane == null)
/*     */     {
/*  89 */       this.labelCupom = new JLabel();
/*  90 */       this.labelCupom.setBounds(new Rectangle(13, 9, 128, 16));
/*  91 */       this.labelCupom.setText("Último cupom emitido");
/*  92 */       this.jContentPane = new JPanel();
/*  93 */       this.jContentPane.setLayout(null);
/*  94 */       this.jContentPane.add(getBotaoOK(), null);
/*  95 */       this.jContentPane.add(getBotalCancelar(), null);
/*  96 */       this.jContentPane.add(this.labelCupom, null);
/*  97 */       this.jContentPane.add(getTextoCupom(), null);
/*     */     }
/*  99 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 109 */     if (this.botaoOK == null)
/*     */     {
/* 111 */       this.botaoOK = new JButton();
/* 112 */       this.botaoOK.setBounds(new Rectangle(13, 70, 130, 26));
/* 113 */       this.botaoOK.setText("Cancelar Cupom");
/* 114 */       this.botaoOK.addActionListener(this.cCancelar);
/*     */     }
/* 116 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotalCancelar()
/*     */   {
/* 126 */     if (this.botaoCancelar == null)
/*     */     {
/* 128 */       this.botaoCancelar = new JButton();
/* 129 */       this.botaoCancelar.setBounds(new Rectangle(180, 70, 130, 26));
/* 130 */       this.botaoCancelar.setText("Fechar");
/* 131 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 135 */           JanelaCancelar.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 139 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCupom()
/*     */   {
/* 149 */     if (this.textoCupom == null)
/*     */     {
/* 151 */       this.textoCupom = new JTextField();
/* 152 */       this.textoCupom.setBounds(new Rectangle(13, 30, 298, 25));
/* 153 */       this.textoCupom.setBackground(new Color(238, 238, 238));
/* 154 */       this.textoCupom.setEditable(false);
/* 155 */       this.textoCupom.setEnabled(false);
/* 156 */       String chave = ControleArquivos.lerBytesArquivo("C:/AC/Cancelamento/infCanc.txt");
/*     */ 
/* 158 */       this.textoCupom.setText(chave);
/*     */     }
/* 160 */     return this.textoCupom;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaCancelar
 * JD-Core Version:    0.6.2
 */