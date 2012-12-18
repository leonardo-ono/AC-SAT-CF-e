/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleAC;
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.controles.ControleConsultarVenda;
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
/*     */ public class JanelaConsultar extends JFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   private JPanel jContentPane = null;
/*     */ 
/*  24 */   private JButton botaoOK = null;
/*     */ 
/*  26 */   private JButton botaoCancelar = null;
/*     */ 
/*  28 */   private JLabel labelSessao = null;
/*     */ 
/*  30 */   private JTextField textoSessao = null;
/*     */ 
/*  32 */   private ControleConsultarVenda cConsultar = null;
/*     */   public ControleAC cAC;
/*     */ 
/*     */   public JanelaConsultar(ControleAC cAC)
/*     */   {
/*  42 */     this.cAC = cAC;
/*  43 */     this.cConsultar = new ControleConsultarVenda(cAC, this);
/*  44 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  56 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  60 */       e.printStackTrace();
/*     */     }
/*  62 */     setSize(330, 132);
/*  63 */     setResizable(false);
/*  64 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  65 */     setTitle("Consultar último cupom emitido");
/*     */ 
/*  67 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  77 */     if (this.jContentPane == null)
/*     */     {
/*  79 */       this.labelSessao = new JLabel();
/*  80 */       this.labelSessao.setBounds(new Rectangle(13, 9, 128, 16));
/*  81 */       this.labelSessao.setText("Último sessão emitida");
/*  82 */       this.jContentPane = new JPanel();
/*  83 */       this.jContentPane.setLayout(null);
/*  84 */       this.jContentPane.add(getBotaoOK(), null);
/*  85 */       this.jContentPane.add(getBotalCancelar(), null);
/*  86 */       this.jContentPane.add(this.labelSessao, null);
/*  87 */       this.jContentPane.add(getTextoSessao(), null);
/*     */     }
/*  89 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/*  99 */     if (this.botaoOK == null)
/*     */     {
/* 101 */       this.botaoOK = new JButton();
/* 102 */       this.botaoOK.setBounds(new Rectangle(13, 70, 130, 26));
/* 103 */       this.botaoOK.setText("Consultar");
/* 104 */       this.botaoOK.addActionListener(this.cConsultar);
/*     */     }
/* 106 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotalCancelar()
/*     */   {
/* 116 */     if (this.botaoCancelar == null)
/*     */     {
/* 118 */       this.botaoCancelar = new JButton();
/* 119 */       this.botaoCancelar.setBounds(new Rectangle(180, 70, 130, 26));
/* 120 */       this.botaoCancelar.setText("Cancelar");
/* 121 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 125 */           JanelaConsultar.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 129 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   public JTextField getTextoSessao()
/*     */   {
/* 139 */     if (this.textoSessao == null)
/*     */     {
/* 141 */       this.textoSessao = new JTextField();
/* 142 */       this.textoSessao.setBounds(new Rectangle(13, 30, 298, 25));
/* 143 */       this.textoSessao.setBackground(new Color(238, 238, 238));
/* 144 */       this.textoSessao.setEditable(false);
/* 145 */       this.textoSessao.setEnabled(false);
/* 146 */       this.textoSessao.setText(ControleArquivos.lerBytesArquivo("C:/AC/Sessoes/sessao.txt"));
/*     */     }
/* 148 */     return this.textoSessao;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaConsultar
 * JD-Core Version:    0.6.2
 */