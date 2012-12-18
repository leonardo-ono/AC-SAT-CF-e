/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe;
/*     */ import java.awt.Dimension;
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
/*     */ public class JanelaConfigurarContribuinte extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private JPanel jContentPane = null;
/*     */ 
/*  28 */   private JTextField textoIE = null;
/*     */ 
/*  30 */   private JButton botaoOK = null;
/*     */ 
/*  32 */   private JButton botaoCancelar = null;
/*     */ 
/*  34 */   private JLabel labelIE = null;
/*     */ 
/*  36 */   private JLabel labelIM = null;
/*     */ 
/*  38 */   private JTextField textoIM = null;
/*     */ 
/*  40 */   private JLabel labelCNPJ = null;
/*     */ 
/*  42 */   private JTextField textoCNPJ = null;
/*     */   private IdentificacaoEmitenteCFe baseEMIT;
/*  46 */   private JLabel labelNomeFantasia = null;
/*     */ 
/*  48 */   private JTextField textoNomeFantasia = null;
/*     */ 
/*  50 */   private JLabel labelcRegTribISSQN = null;
/*     */ 
/*  52 */   private JTextField textocRegTribISSQN = null;
/*     */ 
/*  54 */   private JLabel indRatISSQN = null;
/*     */ 
/*  56 */   private JTextField textoindRatISSQN = null;
/*     */   private JanelaAC owner;
/*     */ 
/*     */   public JanelaConfigurarContribuinte(JanelaAC owner, IdentificacaoEmitenteCFe baseEMIT)
/*     */   {
/*  65 */     super(owner);
/*  66 */     this.owner = owner;
/*  67 */     this.baseEMIT = baseEMIT;
/*  68 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  80 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  84 */       e.printStackTrace();
/*     */     }
/*  86 */     setSize(287, 393);
/*  87 */     setResizable(false);
/*  88 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  89 */     setTitle("Configurar contribuinte");
/*  90 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/* 100 */     if (this.jContentPane == null)
/*     */     {
/* 102 */       this.indRatISSQN = new JLabel();
/* 103 */       this.indRatISSQN.setBounds(new Rectangle(13, 273, 211, 16));
/* 104 */       this.indRatISSQN.setText("Indicador de rateio do ISSQN (S ou N)");
/* 105 */       this.labelcRegTribISSQN = new JLabel();
/* 106 */       this.labelcRegTribISSQN.setBounds(new Rectangle(13, 219, 252, 16));
/* 107 */       this.labelcRegTribISSQN.setText("Código do Regime de tributação do ISSQN");
/* 108 */       this.labelNomeFantasia = new JLabel();
/* 109 */       this.labelNomeFantasia.setBounds(new Rectangle(13, 165, 93, 16));
/* 110 */       this.labelNomeFantasia.setText("Razão Social");
/* 111 */       this.labelCNPJ = new JLabel();
/* 112 */       this.labelCNPJ.setBounds(new Rectangle(13, 113, 143, 16));
/* 113 */       this.labelCNPJ.setText("CNPJ (somente números)");
/* 114 */       this.labelIM = new JLabel();
/* 115 */       this.labelIM.setBounds(new Rectangle(13, 61, 201, 16));
/* 116 */       this.labelIM.setText("IM");
/* 117 */       this.labelIE = new JLabel();
/* 118 */       this.labelIE.setBounds(new Rectangle(13, 9, 107, 15));
/* 119 */       this.labelIE.setText("IE");
/* 120 */       this.jContentPane = new JPanel();
/* 121 */       this.jContentPane.setLayout(null);
/* 122 */       this.jContentPane.add(getTextoIE(), null);
/* 123 */       this.jContentPane.add(getBotaoOK(), null);
/* 124 */       this.jContentPane.add(getBotaoCancelar(), null);
/* 125 */       this.jContentPane.add(this.labelIE, null);
/* 126 */       this.jContentPane.add(this.labelIM, null);
/* 127 */       this.jContentPane.add(getTextoIM(), null);
/* 128 */       this.jContentPane.add(this.labelCNPJ, null);
/* 129 */       this.jContentPane.add(getTextoCNPJ(), null);
/* 130 */       this.jContentPane.add(this.labelNomeFantasia, null);
/* 131 */       this.jContentPane.add(getTextoNomeFantasia(), null);
/* 132 */       this.jContentPane.add(this.labelcRegTribISSQN, null);
/* 133 */       this.jContentPane.add(getTextocRegTribISSQN(), null);
/* 134 */       this.jContentPane.add(this.indRatISSQN, null);
/* 135 */       this.jContentPane.add(getTextoindRatISSQN(), null);
/*     */     }
/* 137 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoIE()
/*     */   {
/* 147 */     if (this.textoIE == null)
/*     */     {
/* 149 */       this.textoIE = new JTextField();
/* 150 */       this.textoIE.setBounds(new Rectangle(13, 30, 258, 25));
/* 151 */       this.textoIE.setText(this.baseEMIT.getIE());
/* 152 */       this.textoIE.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 156 */           Long.parseLong(JanelaConfigurarContribuinte.this.textoCNPJ.getText() + e.getKeyChar());
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
/*     */     }
/* 168 */     return this.textoIE;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 178 */     if (this.botaoOK == null)
/*     */     {
/* 180 */       this.botaoOK = new JButton();
/* 181 */       this.botaoOK.setBounds(new Rectangle(13, 330, 100, 26));
/* 182 */       this.botaoOK.setText("OK");
/* 183 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 187 */           if (JanelaConfigurarContribuinte.this.getTextoIE().getText().length() <= 0)
/*     */           {
/* 189 */             JOptionPane.showMessageDialog(null, "O preenchimento do campo \"IE\" é obrigatório!");
/* 190 */             return;
/*     */           }
/* 192 */           if (JanelaConfigurarContribuinte.this.getTextoCNPJ().getText().length() <= 0)
/*     */           {
/* 194 */             JOptionPane.showMessageDialog(null, "O preenchimento do campo \"CNPJ\" é obrigatório!");
/* 195 */             return;
/*     */           }
/* 197 */           if (JanelaConfigurarContribuinte.this.getTextoNomeFantasia().getText().length() <= 0)
/*     */           {
/* 199 */             JOptionPane.showMessageDialog(null, "O preenchimento do campo \"Razão Social\" é obrigatório!");
/* 200 */             return;
/*     */           }
/* 202 */           if (JanelaConfigurarContribuinte.this.getTextoindRatISSQN().getText().length() <= 0)
/*     */           {
/* 204 */             JOptionPane.showMessageDialog(null, "O preenchimento do campo \"Indicador de rateio do ISSQN\" é obrigatório!");
/* 205 */             return;
/*     */           }
/*     */ 
/* 212 */           if ((!JanelaConfigurarContribuinte.this.textoindRatISSQN.getText().equals("S")) && (!JanelaConfigurarContribuinte.this.textoindRatISSQN.getText().equals("N")))
/*     */           {
/* 214 */             JOptionPane.showMessageDialog(null, "Indicador de rateio do ISSQN inválido!");
/* 215 */             return;
/*     */           }
/* 217 */           JanelaConfigurarContribuinte.this.baseEMIT.setIE(JanelaConfigurarContribuinte.this.textoIE.getText());
/* 218 */           if (JanelaConfigurarContribuinte.this.textoIM.getText().length() <= 0)
/* 219 */             JanelaConfigurarContribuinte.this.baseEMIT.setIM(null);
/*     */           else
/* 221 */             JanelaConfigurarContribuinte.this.baseEMIT.setIM(JanelaConfigurarContribuinte.this.textoIM.getText());
/* 222 */           JanelaConfigurarContribuinte.this.baseEMIT.setCNPJ(JanelaConfigurarContribuinte.this.textoCNPJ.getText().replace(".", "").replace("-", "").replace("/", ""));
/* 223 */           JanelaConfigurarContribuinte.this.baseEMIT.setxFant(JanelaConfigurarContribuinte.this.textoNomeFantasia.getText());
/* 224 */           if (JanelaConfigurarContribuinte.this.textocRegTribISSQN.getText().length() <= 0)
/* 225 */             JanelaConfigurarContribuinte.this.baseEMIT.setcRegTribISSQN(null);
/*     */           else
/* 227 */             JanelaConfigurarContribuinte.this.baseEMIT.setcRegTribISSQN(JanelaConfigurarContribuinte.this.textocRegTribISSQN.getText());
/* 228 */           JanelaConfigurarContribuinte.this.baseEMIT.setIndRatISSQN(JanelaConfigurarContribuinte.this.textoindRatISSQN.getText());
/* 229 */           JanelaConfigurarContribuinte.this.owner.getDadosCNPJ().setText(JanelaConfigurarContribuinte.this.textoCNPJ.getText());
/* 230 */           JanelaConfigurarContribuinte.this.owner.getDadosContribuinte().setText(JanelaConfigurarContribuinte.this.textoNomeFantasia.getText());
/* 231 */           ControleArquivos.escreverCaracteresArquivo("DB_EMIT.xml", JanelaConfigurarContribuinte.this.baseEMIT.toString().toCharArray());
/* 232 */           JOptionPane.showMessageDialog(null, "As Configurações foram salvas com sucesso!");
/* 233 */           JanelaConfigurarContribuinte.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 237 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 247 */     if (this.botaoCancelar == null)
/*     */     {
/* 249 */       this.botaoCancelar = new JButton();
/* 250 */       this.botaoCancelar.setBounds(new Rectangle(170, 330, 100, 26));
/* 251 */       this.botaoCancelar.setText("Cancelar");
/* 252 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 256 */           JanelaConfigurarContribuinte.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 260 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoIM()
/*     */   {
/* 270 */     if (this.textoIM == null)
/*     */     {
/* 272 */       this.textoIM = new JTextField();
/* 273 */       this.textoIM.setBounds(new Rectangle(13, 83, 258, 25));
/* 274 */       this.textoIM.setText(this.baseEMIT.getIM());
/* 275 */       this.textoIM.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 279 */           Long.parseLong(JanelaConfigurarContribuinte.this.textoCNPJ.getText() + e.getKeyChar());
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
/*     */     }
/* 291 */     return this.textoIM;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCNPJ()
/*     */   {
/* 301 */     if (this.textoCNPJ == null)
/*     */     {
/* 303 */       this.textoCNPJ = new JTextField();
/* 304 */       this.textoCNPJ.setBounds(new Rectangle(13, 135, 258, 25));
/* 305 */       this.textoCNPJ.setText(this.baseEMIT.getCNPJ());
/*     */     }
/* 307 */     return this.textoCNPJ;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoNomeFantasia()
/*     */   {
/* 317 */     if (this.textoNomeFantasia == null)
/*     */     {
/* 319 */       this.textoNomeFantasia = new JTextField();
/* 320 */       this.textoNomeFantasia.setBounds(new Rectangle(13, 188, 258, 25));
/* 321 */       this.textoNomeFantasia.setText(this.baseEMIT.getxFant());
/*     */     }
/* 323 */     return this.textoNomeFantasia;
/*     */   }
/*     */ 
/*     */   private JTextField getTextocRegTribISSQN()
/*     */   {
/* 333 */     if (this.textocRegTribISSQN == null)
/*     */     {
/* 335 */       this.textocRegTribISSQN = new JTextField();
/* 336 */       this.textocRegTribISSQN.setBounds(new Rectangle(13, 242, 258, 25));
/* 337 */       this.textocRegTribISSQN.setText(this.baseEMIT.getcRegTribISSQN());
/*     */     }
/* 339 */     return this.textocRegTribISSQN;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoindRatISSQN()
/*     */   {
/* 349 */     if (this.textoindRatISSQN == null)
/*     */     {
/* 351 */       this.textoindRatISSQN = new JTextField();
/* 352 */       this.textoindRatISSQN.setBounds(new Rectangle(13, 295, 258, 25));
/* 353 */       this.textoindRatISSQN.setText(this.baseEMIT.getIndRatISSQN());
/*     */     }
/* 355 */     return this.textoindRatISSQN;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaConfigurarContribuinte
 * JD-Core Version:    0.6.2
 */