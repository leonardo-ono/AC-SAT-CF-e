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
/*     */ public class JanelaPISAliq extends JDialog
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
/*  36 */   private JLabel labelBC = null;
/*     */ 
/*  38 */   private JTextField textoBC = null;
/*     */ 
/* 217 */   public boolean ok = false;
/*     */ 
/* 219 */   public String CST = "";
/*     */ 
/* 221 */   public String aliq = "";
/*     */ 
/* 223 */   public String BC = "";
/*     */ 
/*     */   public JanelaPISAliq(JDialog owner)
/*     */   {
/*  45 */     super(owner);
/*  46 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  58 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  62 */       e.printStackTrace();
/*     */     }
/*  64 */     setSize(287, 239);
/*  65 */     setResizable(false);
/*  66 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  67 */     setTitle("PIS");
/*  68 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  78 */     if (this.jContentPane == null)
/*     */     {
/*  80 */       this.labelBC = new JLabel();
/*  81 */       this.labelBC.setBounds(new Rectangle(13, 120, 134, 16));
/*  82 */       this.labelBC.setText("Base Cálculo:");
/*  83 */       this.labelAliquota = new JLabel();
/*  84 */       this.labelAliquota.setBounds(new Rectangle(13, 68, 137, 16));
/*  85 */       this.labelAliquota.setText("Alíquota em percentual:");
/*  86 */       this.labelCST = new JLabel();
/*  87 */       this.labelCST.setBounds(new Rectangle(13, 16, 178, 16));
/*  88 */       this.labelCST.setText("Código de Situação Tributária :");
/*  89 */       this.jContentPane = new JPanel();
/*  90 */       this.jContentPane.setLayout(null);
/*  91 */       this.jContentPane.add(this.labelCST, null);
/*  92 */       this.jContentPane.add(getTextoOrigem(), null);
/*  93 */       this.jContentPane.add(this.labelAliquota, null);
/*  94 */       this.jContentPane.add(getTextoAliquota(), null);
/*  95 */       this.jContentPane.add(getBotaoOK(), null);
/*  96 */       this.jContentPane.add(getBotaoCancelar(), null);
/*  97 */       this.jContentPane.add(this.labelBC, null);
/*  98 */       this.jContentPane.add(getTextoBC(), null);
/*     */     }
/* 100 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoOrigem()
/*     */   {
/* 110 */     if (this.textoCST == null)
/*     */     {
/* 112 */       this.textoCST = new JTextField();
/* 113 */       this.textoCST.setBounds(new Rectangle(13, 38, 258, 25));
/*     */     }
/* 115 */     return this.textoCST;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoAliquota()
/*     */   {
/* 125 */     if (this.textoAliquota == null)
/*     */     {
/* 127 */       this.textoAliquota = new JTextField();
/* 128 */       this.textoAliquota.setBounds(new Rectangle(13, 90, 258, 25));
/*     */     }
/* 130 */     return this.textoAliquota;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 140 */     if (this.botaoOK == null)
/*     */     {
/* 142 */       this.botaoOK = new JButton();
/* 143 */       this.botaoOK.setBounds(new Rectangle(13, 175, 100, 26));
/* 144 */       this.botaoOK.setText("OK");
/* 145 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0)
/*     */         {
/* 149 */           JanelaPISAliq.this.ok = true;
/* 150 */           JanelaPISAliq.this.aliq = JanelaPISAliq.this.textoAliquota.getText();
/* 151 */           JanelaPISAliq.this.CST = JanelaPISAliq.this.textoCST.getText();
/* 152 */           JanelaPISAliq.this.BC = JanelaPISAliq.this.textoBC.getText();
/* 153 */           if (JanelaPISAliq.this.CST.equals(""))
/*     */           {
/* 155 */             JOptionPane.showMessageDialog(JanelaPISAliq.this, "O Campo \"Código de Situação Tributária\" é de preenchimento obrigatório!");
/* 156 */             return;
/*     */           }
/* 158 */           if (JanelaPISAliq.this.aliq.equals(""))
/*     */           {
/* 160 */             JOptionPane.showMessageDialog(JanelaPISAliq.this, "O Campo \"Alíquota em percentual\" é de preenchimento obrigatório!");
/* 161 */             return;
/*     */           }
/* 163 */           if (JanelaPISAliq.this.BC.equals(""))
/*     */           {
/* 165 */             JOptionPane.showMessageDialog(JanelaPISAliq.this, "O Campo \"Base Cálculo\" é de preenchimento obrigatório!");
/* 166 */             return;
/*     */           }
/*     */ 
/* 170 */           JanelaPISAliq.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/* 175 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 185 */     if (this.botaoCancelar == null)
/*     */     {
/* 187 */       this.botaoCancelar = new JButton();
/* 188 */       this.botaoCancelar.setBounds(new Rectangle(171, 175, 100, 26));
/* 189 */       this.botaoCancelar.setText("Cancelar");
/* 190 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 194 */           JanelaPISAliq.this.ok = false;
/* 195 */           JanelaPISAliq.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 199 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoBC()
/*     */   {
/* 209 */     if (this.textoBC == null)
/*     */     {
/* 211 */       this.textoBC = new JTextField();
/* 212 */       this.textoBC.setBounds(new Rectangle(13, 142, 258, 25));
/*     */     }
/* 214 */     return this.textoBC;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaPISAliq
 * JD-Core Version:    0.6.2
 */