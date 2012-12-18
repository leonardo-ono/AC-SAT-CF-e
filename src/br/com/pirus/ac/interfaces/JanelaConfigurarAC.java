/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoCFe;
/*     */ import br.com.pirus.ac.utils.Utils;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class JanelaConfigurarAC extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private JPanel jContentPane = null;
/*     */ 
/*  28 */   private JTextField textoSenha = null;
/*     */ 
/*  30 */   private JButton botaoOK = null;
/*     */ 
/*  32 */   private JButton botaoCancelar = null;
/*     */ 
/*  34 */   private JLabel labelSenha = null;
/*     */ 
/*  36 */   private JLabel labelAssinatura = null;
/*     */ 
/*  38 */   private JTextField textoAssinatura = null;
/*     */ 
/*  40 */   private JLabel labelCNPJSH = null;
/*     */ 
/*  42 */   private JTextField textoCNPJSH = null;
/*     */   private IdentificacaoCFe baseIDE;
/*     */ 
/*     */   public JanelaConfigurarAC(Frame owner, IdentificacaoCFe baseIDE)
/*     */   {
/*  51 */     super(owner);
/*  52 */     this.baseIDE = baseIDE;
/*  53 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  65 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  69 */       e.printStackTrace();
/*     */     }
/*  71 */     setSize(287, 230);
/*  72 */     setResizable(false);
/*  73 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  74 */     setTitle("Configurar aplicativo comercial");
/*  75 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  85 */     if (this.jContentPane == null)
/*     */     {
/*  87 */       this.labelCNPJSH = new JLabel();
/*  88 */       this.labelCNPJSH.setBounds(new Rectangle(13, 113, 143, 16));
/*  89 */       this.labelCNPJSH.setText("CNPJ da software house");
/*  90 */       this.labelAssinatura = new JLabel();
/*  91 */       this.labelAssinatura.setBounds(new Rectangle(13, 61, 201, 16));
/*  92 */       this.labelAssinatura.setText("Assinatura do aplicativo comercial");
/*  93 */       this.labelSenha = new JLabel();
/*  94 */       this.labelSenha.setBounds(new Rectangle(13, 9, 107, 15));
/*  95 */       this.labelSenha.setText("Senha de ativação");
/*  96 */       this.jContentPane = new JPanel();
/*  97 */       this.jContentPane.setLayout(null);
/*  98 */       this.jContentPane.add(getTextoSenha(), null);
/*  99 */       this.jContentPane.add(getBotaoOK(), null);
/* 100 */       this.jContentPane.add(getBotaoCancelar(), null);
/* 101 */       this.jContentPane.add(this.labelSenha, null);
/* 102 */       this.jContentPane.add(this.labelAssinatura, null);
/* 103 */       this.jContentPane.add(getTextoAssinatura(), null);
/* 104 */       this.jContentPane.add(this.labelCNPJSH, null);
/* 105 */       this.jContentPane.add(getTextoCNPJSH(), null);
/*     */     }
/* 107 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoSenha()
/*     */   {
/* 117 */     if (this.textoSenha == null)
/*     */     {
/* 119 */       this.textoSenha = new JTextField();
/* 120 */       this.textoSenha.setBounds(new Rectangle(13, 30, 258, 25));
/* 121 */       this.textoSenha.setText(Utils.getSenha());
/*     */     }
/* 123 */     return this.textoSenha;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 133 */     if (this.botaoOK == null)
/*     */     {
/* 135 */       this.botaoOK = new JButton();
/* 136 */       this.botaoOK.setBounds(new Rectangle(13, 170, 100, 26));
/* 137 */       this.botaoOK.setText("OK");
/* 138 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 142 */           if (!Utils.isValidCNPJ(JanelaConfigurarAC.this.textoCNPJSH.getText()))
/*     */           {
/* 144 */             JOptionPane.showMessageDialog(null, "CNPJ inválido");
/* 145 */             return;
/*     */           }
/* 147 */           Utils.setSenha(JanelaConfigurarAC.this.textoSenha.getText());
/* 148 */           JanelaConfigurarAC.this.baseIDE.setCNPJ(JanelaConfigurarAC.this.textoCNPJSH.getText());
/* 149 */           JanelaConfigurarAC.this.baseIDE.setSignAC(JanelaConfigurarAC.this.textoAssinatura.getText());
/* 150 */           ControleArquivos.escreverCaracteresArquivo("DB_IDE.xml", JanelaConfigurarAC.this.baseIDE.toString().toCharArray());
/* 151 */           JanelaConfigurarAC.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 155 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 165 */     if (this.botaoCancelar == null)
/*     */     {
/* 167 */       this.botaoCancelar = new JButton();
/* 168 */       this.botaoCancelar.setBounds(new Rectangle(171, 170, 100, 26));
/* 169 */       this.botaoCancelar.setText("Cancelar");
/* 170 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 174 */           JanelaConfigurarAC.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 178 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoAssinatura()
/*     */   {
/* 188 */     if (this.textoAssinatura == null)
/*     */     {
/* 190 */       this.textoAssinatura = new JTextField();
/* 191 */       this.textoAssinatura.setBounds(new Rectangle(13, 83, 258, 25));
/* 192 */       this.textoAssinatura.setText(this.baseIDE.getSignAC());
/*     */     }
/* 194 */     return this.textoAssinatura;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCNPJSH()
/*     */   {
/* 204 */     if (this.textoCNPJSH == null)
/*     */     {
/* 206 */       this.textoCNPJSH = new JTextField();
/* 207 */       this.textoCNPJSH.setBounds(new Rectangle(13, 135, 258, 25));
/* 208 */       this.textoCNPJSH.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 212 */           Long.parseLong(JanelaConfigurarAC.this.textoCNPJSH.getText() + e.getKeyChar());
/*     */         }
/*     */ 
/*     */         public void keyReleased(KeyEvent e)
/*     */         {
/*     */         }
/*     */ 
/*     */         public void keyPressed(KeyEvent e)
/*     */         {
/*     */         }
/*     */       });
/* 223 */       this.textoCNPJSH.setText(this.baseIDE.getCNPJ());
/*     */     }
/* 225 */     return this.textoCNPJSH;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaConfigurarAC
 * JD-Core Version:    0.6.2
 */