/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class JanelaICMSSN102 extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   private JPanel jContentPane = null;
/*     */ 
/*  24 */   private JLabel labelOrigem = null;
/*     */ 
/*  26 */   private JTextField textoOrigem = null;
/*     */ 
/*  28 */   private JButton botaoOK = null;
/*     */ 
/*  30 */   private JButton botaoCancelar = null;
/*     */ 
/* 158 */   public boolean ok = false;
/*     */ 
/* 160 */   public String orig = "";
/*     */   public String CSOSN;
/*     */ 
/*     */   public JanelaICMSSN102(JDialog owner, String CSOSN)
/*     */   {
/*  37 */     super(owner);
/*  38 */     initialize();
/*  39 */     this.CSOSN = CSOSN;
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  51 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  55 */       e.printStackTrace();
/*     */     }
/*  57 */     setSize(287, 139);
/*  58 */     setResizable(false);
/*  59 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  60 */     setTitle("ICMS");
/*  61 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  71 */     if (this.jContentPane == null)
/*     */     {
/*  73 */       this.labelOrigem = new JLabel();
/*  74 */       this.labelOrigem.setBounds(new Rectangle(13, 16, 135, 16));
/*  75 */       this.labelOrigem.setText("Origem da mercadoria:");
/*  76 */       this.jContentPane = new JPanel();
/*  77 */       this.jContentPane.setLayout(null);
/*  78 */       this.jContentPane.add(this.labelOrigem, null);
/*  79 */       this.jContentPane.add(getTextoOrigem(), null);
/*  80 */       this.jContentPane.add(getBotaoOK(), null);
/*  81 */       this.jContentPane.add(getBotaoCancelar(), null);
/*     */     }
/*  83 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoOrigem()
/*     */   {
/*  93 */     if (this.textoOrigem == null)
/*     */     {
/*  95 */       this.textoOrigem = new JTextField();
/*  96 */       this.textoOrigem.setBounds(new Rectangle(13, 38, 258, 25));
/*     */     }
/*  98 */     return this.textoOrigem;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 108 */     if (this.botaoOK == null)
/*     */     {
/* 110 */       this.botaoOK = new JButton();
/* 111 */       this.botaoOK.setBounds(new Rectangle(13, 70, 100, 26));
/* 112 */       this.botaoOK.setText("OK");
/* 113 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0)
/*     */         {
/* 117 */           JanelaICMSSN102.this.ok = true;
/* 118 */           JanelaICMSSN102.this.orig = JanelaICMSSN102.this.textoOrigem.getText();
/* 119 */           if (JanelaICMSSN102.this.orig.equals(""))
/*     */           {
/* 121 */             JOptionPane.showMessageDialog(JanelaICMSSN102.this, "O Campo \"Origem da mercadoria\" é de preenchimento obrigatório!");
/* 122 */             return;
/*     */           }
/*     */ 
/* 126 */           JanelaICMSSN102.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/* 131 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 141 */     if (this.botaoCancelar == null)
/*     */     {
/* 143 */       this.botaoCancelar = new JButton();
/* 144 */       this.botaoCancelar.setBounds(new Rectangle(171, 70, 100, 26));
/* 145 */       this.botaoCancelar.setText("Cancelar");
/* 146 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 150 */           JanelaICMSSN102.this.ok = false;
/* 151 */           JanelaICMSSN102.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 155 */     return this.botaoCancelar;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaICMSSN102
 * JD-Core Version:    0.6.2
 */