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
/*     */ public class JanelaICMS00 extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   private JPanel jContentPane = null;
/*     */ 
/*  24 */   private JLabel labelOrigem = null;
/*     */ 
/*  26 */   private JTextField textoOrigem = null;
/*     */ 
/*  28 */   private JLabel labelAliquota = null;
/*     */ 
/*  30 */   private JTextField textoAliquota = null;
/*     */ 
/*  32 */   private JButton botaoOK = null;
/*     */ 
/*  34 */   private JButton botaoCancelar = null;
/*     */ 
/* 188 */   public boolean ok = false;
/*     */ 
/* 190 */   public String orig = "";
/*     */ 
/* 192 */   public String aliq = "";
/*     */   public String CST;
/*     */ 
/*     */   public JanelaICMS00(JDialog owner, String CST)
/*     */   {
/*  41 */     super(owner);
/*  42 */     initialize();
/*  43 */     this.CST = CST;
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  55 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  59 */       e.printStackTrace();
/*     */     }
/*  61 */     setSize(287, 190);
/*  62 */     setResizable(false);
/*  63 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  64 */     setTitle("ICMS");
/*  65 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  75 */     if (this.jContentPane == null)
/*     */     {
/*  77 */       this.labelAliquota = new JLabel();
/*  78 */       this.labelAliquota.setBounds(new Rectangle(13, 68, 137, 16));
/*  79 */       this.labelAliquota.setText("Alíquota efetiva:");
/*  80 */       this.labelOrigem = new JLabel();
/*  81 */       this.labelOrigem.setBounds(new Rectangle(13, 16, 135, 16));
/*  82 */       this.labelOrigem.setText("Origem da mercadoria:");
/*  83 */       this.jContentPane = new JPanel();
/*  84 */       this.jContentPane.setLayout(null);
/*  85 */       this.jContentPane.add(this.labelOrigem, null);
/*  86 */       this.jContentPane.add(getTextoOrigem(), null);
/*  87 */       this.jContentPane.add(this.labelAliquota, null);
/*  88 */       this.jContentPane.add(getTextoAliquota(), null);
/*  89 */       this.jContentPane.add(getBotaoOK(), null);
/*  90 */       this.jContentPane.add(getBotaoCancelar(), null);
/*     */     }
/*  92 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoOrigem()
/*     */   {
/* 102 */     if (this.textoOrigem == null)
/*     */     {
/* 104 */       this.textoOrigem = new JTextField();
/* 105 */       this.textoOrigem.setBounds(new Rectangle(13, 38, 258, 25));
/*     */     }
/* 107 */     return this.textoOrigem;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoAliquota()
/*     */   {
/* 117 */     if (this.textoAliquota == null)
/*     */     {
/* 119 */       this.textoAliquota = new JTextField();
/* 120 */       this.textoAliquota.setBounds(new Rectangle(13, 90, 258, 25));
/*     */     }
/* 122 */     return this.textoAliquota;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 132 */     if (this.botaoOK == null)
/*     */     {
/* 134 */       this.botaoOK = new JButton();
/* 135 */       this.botaoOK.setBounds(new Rectangle(13, 125, 100, 26));
/* 136 */       this.botaoOK.setText("OK");
/* 137 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0)
/*     */         {
/* 141 */           JanelaICMS00.this.ok = true;
/* 142 */           JanelaICMS00.this.orig = JanelaICMS00.this.textoOrigem.getText();
/* 143 */           JanelaICMS00.this.aliq = JanelaICMS00.this.textoAliquota.getText();
/* 144 */           if (JanelaICMS00.this.orig.equals(""))
/*     */           {
/* 146 */             JOptionPane.showMessageDialog(JanelaICMS00.this, "O Campo \"Origem da mercadoria\" é de preenchimento obrigatório!");
/* 147 */             return;
/*     */           }
/* 149 */           if (JanelaICMS00.this.aliq.equals(""))
/*     */           {
/* 151 */             JOptionPane.showMessageDialog(JanelaICMS00.this, "O Campo \"Alíquota efetiva\" é de preenchimento obrigatório!");
/* 152 */             return;
/*     */           }
/*     */ 
/* 156 */           JanelaICMS00.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/* 161 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 171 */     if (this.botaoCancelar == null)
/*     */     {
/* 173 */       this.botaoCancelar = new JButton();
/* 174 */       this.botaoCancelar.setBounds(new Rectangle(171, 125, 100, 26));
/* 175 */       this.botaoCancelar.setText("Cancelar");
/* 176 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 180 */           JanelaICMS00.this.ok = false;
/* 181 */           JanelaICMS00.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 185 */     return this.botaoCancelar;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaICMS00
 * JD-Core Version:    0.6.2
 */