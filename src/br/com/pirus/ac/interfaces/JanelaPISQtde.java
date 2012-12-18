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
/*     */ public class JanelaPISQtde extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   private JPanel jContentPane = null;
/*     */ 
/*  24 */   private JLabel labelCST = null;
/*     */ 
/*  26 */   private JTextField textoCST = null;
/*     */ 
/*  28 */   private JLabel labelAliquota = null;
/*     */ 
/*  30 */   private JTextField textoAliquota = null;
/*     */ 
/*  32 */   private JButton botaoOK = null;
/*     */ 
/*  34 */   private JButton botaoCancelar = null;
/*     */ 
/* 187 */   public boolean ok = false;
/*     */ 
/* 189 */   public String CST = "";
/*     */ 
/* 191 */   public String aliq = "";
/*     */ 
/*     */   public JanelaPISQtde(JDialog owner)
/*     */   {
/*  41 */     super(owner);
/*  42 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  54 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  58 */       e.printStackTrace();
/*     */     }
/*  60 */     setSize(287, 195);
/*  61 */     setResizable(false);
/*  62 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  63 */     setTitle("PIS");
/*  64 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  74 */     if (this.jContentPane == null)
/*     */     {
/*  76 */       this.labelAliquota = new JLabel();
/*  77 */       this.labelAliquota.setBounds(new Rectangle(13, 68, 137, 16));
/*  78 */       this.labelAliquota.setText("Alíquota em reais:");
/*  79 */       this.labelCST = new JLabel();
/*  80 */       this.labelCST.setBounds(new Rectangle(13, 16, 178, 16));
/*  81 */       this.labelCST.setText("Código de Situação Tributária :");
/*  82 */       this.jContentPane = new JPanel();
/*  83 */       this.jContentPane.setLayout(null);
/*  84 */       this.jContentPane.add(this.labelCST, null);
/*  85 */       this.jContentPane.add(getTextoOrigem(), null);
/*  86 */       this.jContentPane.add(this.labelAliquota, null);
/*  87 */       this.jContentPane.add(getTextoAliquota(), null);
/*  88 */       this.jContentPane.add(getBotaoOK(), null);
/*  89 */       this.jContentPane.add(getBotaoCancelar(), null);
/*     */     }
/*  91 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoOrigem()
/*     */   {
/* 101 */     if (this.textoCST == null)
/*     */     {
/* 103 */       this.textoCST = new JTextField();
/* 104 */       this.textoCST.setBounds(new Rectangle(13, 38, 258, 25));
/*     */     }
/* 106 */     return this.textoCST;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoAliquota()
/*     */   {
/* 116 */     if (this.textoAliquota == null)
/*     */     {
/* 118 */       this.textoAliquota = new JTextField();
/* 119 */       this.textoAliquota.setBounds(new Rectangle(13, 90, 258, 25));
/*     */     }
/* 121 */     return this.textoAliquota;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 131 */     if (this.botaoOK == null)
/*     */     {
/* 133 */       this.botaoOK = new JButton();
/* 134 */       this.botaoOK.setBounds(new Rectangle(13, 130, 100, 26));
/* 135 */       this.botaoOK.setText("OK");
/* 136 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0)
/*     */         {
/* 140 */           JanelaPISQtde.this.ok = true;
/* 141 */           JanelaPISQtde.this.aliq = JanelaPISQtde.this.textoAliquota.getText();
/* 142 */           JanelaPISQtde.this.CST = JanelaPISQtde.this.textoCST.getText();
/* 143 */           if (JanelaPISQtde.this.CST.equals(""))
/*     */           {
/* 145 */             JOptionPane.showMessageDialog(JanelaPISQtde.this, "O Campo \"Código de Situação Tributária\" é de preenchimento obrigatório!");
/* 146 */             return;
/*     */           }
/* 148 */           if (JanelaPISQtde.this.aliq.equals(""))
/*     */           {
/* 150 */             JOptionPane.showMessageDialog(JanelaPISQtde.this, "O Campo \"Alíquota em reais\" é de preenchimento obrigatório!");
/* 151 */             return;
/*     */           }
/*     */ 
/* 155 */           JanelaPISQtde.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/* 160 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 170 */     if (this.botaoCancelar == null)
/*     */     {
/* 172 */       this.botaoCancelar = new JButton();
/* 173 */       this.botaoCancelar.setBounds(new Rectangle(171, 130, 100, 26));
/* 174 */       this.botaoCancelar.setText("Cancelar");
/* 175 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 179 */           JanelaPISQtde.this.ok = false;
/* 180 */           JanelaPISQtde.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 184 */     return this.botaoCancelar;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaPISQtde
 * JD-Core Version:    0.6.2
 */