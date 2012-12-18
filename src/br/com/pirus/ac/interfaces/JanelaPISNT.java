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
/*     */ public class JanelaPISNT extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   private JPanel jContentPane = null;
/*     */ 
/*  24 */   private JLabel labelCST = null;
/*     */ 
/*  26 */   private JTextField textoCST = null;
/*     */ 
/*  28 */   private JButton botaoOK = null;
/*     */ 
/*  30 */   private JButton botaoCancelar = null;
/*     */ 
/* 157 */   public boolean ok = false;
/*     */ 
/* 159 */   public String CST = "";
/*     */ 
/*     */   public JanelaPISNT(JDialog owner)
/*     */   {
/*  37 */     super(owner);
/*  38 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  50 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  54 */       e.printStackTrace();
/*     */     }
/*  56 */     setSize(287, 141);
/*  57 */     setResizable(false);
/*  58 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  59 */     setTitle("PIS");
/*  60 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  70 */     if (this.jContentPane == null)
/*     */     {
/*  72 */       this.labelCST = new JLabel();
/*  73 */       this.labelCST.setBounds(new Rectangle(13, 16, 178, 16));
/*  74 */       this.labelCST.setText("Código de Situação Tributária :");
/*  75 */       this.jContentPane = new JPanel();
/*  76 */       this.jContentPane.setLayout(null);
/*  77 */       this.jContentPane.add(this.labelCST, null);
/*  78 */       this.jContentPane.add(getTextoOrigem(), null);
/*  79 */       this.jContentPane.add(getBotaoOK(), null);
/*  80 */       this.jContentPane.add(getBotaoCancelar(), null);
/*     */     }
/*  82 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoOrigem()
/*     */   {
/*  92 */     if (this.textoCST == null)
/*     */     {
/*  94 */       this.textoCST = new JTextField();
/*  95 */       this.textoCST.setBounds(new Rectangle(13, 38, 258, 25));
/*     */     }
/*  97 */     return this.textoCST;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 107 */     if (this.botaoOK == null)
/*     */     {
/* 109 */       this.botaoOK = new JButton();
/* 110 */       this.botaoOK.setBounds(new Rectangle(13, 75, 100, 26));
/* 111 */       this.botaoOK.setText("OK");
/* 112 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0)
/*     */         {
/* 116 */           JanelaPISNT.this.ok = true;
/* 117 */           JanelaPISNT.this.CST = JanelaPISNT.this.textoCST.getText();
/* 118 */           if (JanelaPISNT.this.CST.equals(""))
/*     */           {
/* 120 */             JOptionPane.showMessageDialog(JanelaPISNT.this, "O Campo \"Código de Situação Tributária\" é de preenchimento obrigatório!");
/* 121 */             return;
/*     */           }
/*     */ 
/* 125 */           JanelaPISNT.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/* 130 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 140 */     if (this.botaoCancelar == null)
/*     */     {
/* 142 */       this.botaoCancelar = new JButton();
/* 143 */       this.botaoCancelar.setBounds(new Rectangle(171, 75, 100, 26));
/* 144 */       this.botaoCancelar.setText("Cancelar");
/* 145 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 149 */           JanelaPISNT.this.ok = false;
/* 150 */           JanelaPISNT.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 154 */     return this.botaoCancelar;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaPISNT
 * JD-Core Version:    0.6.2
 */