/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.InformacoesCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.ProdutoCFe;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class JanelaCadastrarProduto extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private JPanel jContentPane = null;
/*     */ 
/*  32 */   private JLabel labelCodigo = null;
/*     */ 
/*  34 */   private JLabel labelCodigoBarras = null;
/*     */ 
/*  36 */   private JLabel labelDescricao = null;
/*     */ 
/*  38 */   private JLabel labelNCM = null;
/*     */ 
/*  40 */   private JLabel labelCFOP = null;
/*     */ 
/*  42 */   private JLabel labelUCom = null;
/*     */ 
/*  44 */   private JLabel labelVUCom = null;
/*     */ 
/*  46 */   private JLabel labelIndRegra = null;
/*     */ 
/*  48 */   private JTextField textoCodigo = null;
/*     */ 
/*  50 */   private JTextField textoCodigoBarra = null;
/*     */ 
/*  52 */   private JTextField textoDescricao = null;
/*     */ 
/*  54 */   private JTextField textoNCM = null;
/*     */ 
/*  56 */   private JTextField textoCFOP = null;
/*     */ 
/*  58 */   private JTextField textoUCom = null;
/*     */ 
/*  60 */   private JTextField textoVUn = null;
/*     */ 
/*  62 */   private JTextField textoindRegra = null;
/*     */ 
/*  64 */   private JButton botaoOK = null;
/*     */ 
/*  66 */   private JButton botaoCancelar = null;
/*     */   private InformacoesCFe baseProd;
/*  70 */   private JLabel labelTributacaoICMS = null;
/*     */ 
/*  72 */   private JComboBox comboICMS = null;
/*     */ 
/*  74 */   private JLabel labelTributacaoPIS = null;
/*     */ 
/*  76 */   private JLabel labelTributacaoCOFINS = null;
/*     */ 
/*  78 */   private JComboBox comboPIS = null;
/*     */ 
/*  80 */   private JComboBox comboCOFINS = null;
/*     */ 
/*  82 */   protected JanelaICMS00 jICMS00 = null;
/*     */ 
/*  84 */   protected JanelaICMS40 jICMS40 = null;
/*     */ 
/*  86 */   protected JanelaICMSSN102 jICMSSN102 = null;
/*     */ 
/*  88 */   protected JanelaICMSSN900 jICMSSN900 = null;
/*     */ 
/*  90 */   protected JanelaCOFINSAliq jCOFINSAliq = null;
/*     */ 
/*  92 */   protected JanelaCOFINSQtde jCOFINSQtde = null;
/*     */ 
/*  94 */   protected JanelaCOFINSNT jCOFINSNT = null;
/*     */ 
/*  96 */   protected JanelaPISAliq jPISAliq = null;
/*     */ 
/*  98 */   protected JanelaPISQtde jPISQtde = null;
/*     */ 
/* 100 */   protected JanelaPISNT jPISNT = null;
/*     */ 
/*     */   public JanelaCadastrarProduto(Frame owner, InformacoesCFe baseProd)
/*     */   {
/* 107 */     super(owner);
/* 108 */     this.baseProd = baseProd;
/* 109 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/* 121 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 125 */       e.printStackTrace();
/*     */     }
/* 127 */     setSize(287, 664);
/* 128 */     setResizable(false);
/* 129 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/* 130 */     setTitle("Cadastrar produto");
/* 131 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/* 141 */     if (this.jContentPane == null)
/*     */     {
/* 143 */       this.labelTributacaoCOFINS = new JLabel();
/* 144 */       this.labelTributacaoCOFINS.setBounds(new Rectangle(13, 536, 120, 16));
/* 145 */       this.labelTributacaoCOFINS.setText("Tributação COFINS:");
/* 146 */       this.labelTributacaoPIS = new JLabel();
/* 147 */       this.labelTributacaoPIS.setBounds(new Rectangle(13, 484, 96, 16));
/* 148 */       this.labelTributacaoPIS.setText("Tributação PIS:");
/* 149 */       this.labelTributacaoICMS = new JLabel();
/* 150 */       this.labelTributacaoICMS.setBounds(new Rectangle(13, 432, 101, 16));
/* 151 */       this.labelTributacaoICMS.setText("Tributação ICMS:");
/* 152 */       this.labelIndRegra = new JLabel();
/* 153 */       this.labelIndRegra.setBounds(new Rectangle(13, 380, 150, 16));
/* 154 */       this.labelIndRegra.setText("Regra de calculo (A ou T)");
/* 155 */       this.labelVUCom = new JLabel();
/* 156 */       this.labelVUCom.setBounds(new Rectangle(13, 328, 89, 16));
/* 157 */       this.labelVUCom.setText("Valor unitário");
/* 158 */       this.labelUCom = new JLabel();
/* 159 */       this.labelUCom.setBounds(new Rectangle(13, 276, 113, 16));
/* 160 */       this.labelUCom.setText("Unidade comercial");
/* 161 */       this.labelCFOP = new JLabel();
/* 162 */       this.labelCFOP.setBounds(new Rectangle(13, 224, 240, 16));
/* 163 */       this.labelCFOP.setText("Código Fiscal de Operações e Prestações");
/* 164 */       this.labelNCM = new JLabel();
/* 165 */       this.labelNCM.setBounds(new Rectangle(13, 172, 73, 16));
/* 166 */       this.labelNCM.setText("Código NCM");
/* 167 */       this.labelDescricao = new JLabel();
/* 168 */       this.labelDescricao.setBounds(new Rectangle(13, 120, 132, 16));
/* 169 */       this.labelDescricao.setText("Descrição do produto");
/* 170 */       this.labelCodigoBarras = new JLabel();
/* 171 */       this.labelCodigoBarras.setBounds(new Rectangle(13, 68, 106, 16));
/* 172 */       this.labelCodigoBarras.setText("Código de barras");
/* 173 */       this.labelCodigo = new JLabel();
/* 174 */       this.labelCodigo.setBounds(new Rectangle(13, 16, 132, 16));
/* 175 */       this.labelCodigo.setText("Referência do produto");
/* 176 */       this.jContentPane = new JPanel();
/* 177 */       this.jContentPane.setLayout(null);
/* 178 */       this.jContentPane.add(this.labelCodigo, null);
/* 179 */       this.jContentPane.add(this.labelCodigoBarras, null);
/* 180 */       this.jContentPane.add(this.labelDescricao, null);
/* 181 */       this.jContentPane.add(this.labelNCM, null);
/* 182 */       this.jContentPane.add(this.labelCFOP, null);
/* 183 */       this.jContentPane.add(this.labelUCom, null);
/* 184 */       this.jContentPane.add(this.labelVUCom, null);
/* 185 */       this.jContentPane.add(this.labelIndRegra, null);
/* 186 */       this.jContentPane.add(getTextoCodigo(), null);
/* 187 */       this.jContentPane.add(getTextoCodigoBarra(), null);
/* 188 */       this.jContentPane.add(getTextoDescricao(), null);
/* 189 */       this.jContentPane.add(getTextoNCM(), null);
/* 190 */       this.jContentPane.add(getTextoCFOP(), null);
/* 191 */       this.jContentPane.add(getTextoUCom(), null);
/* 192 */       this.jContentPane.add(getTextoVUn(), null);
/* 193 */       this.jContentPane.add(getTextoindRegra(), null);
/* 194 */       this.jContentPane.add(getBotaoOK(), null);
/* 195 */       this.jContentPane.add(getBotaoCancelar(), null);
/* 196 */       this.jContentPane.add(this.labelTributacaoICMS, null);
/* 197 */       this.jContentPane.add(getComboImposto(), null);
/* 198 */       this.jContentPane.add(this.labelTributacaoPIS, null);
/* 199 */       this.jContentPane.add(this.labelTributacaoCOFINS, null);
/* 200 */       this.jContentPane.add(getComboPIS(), null);
/* 201 */       this.jContentPane.add(getComboCOFINS(), null);
/*     */     }
/* 203 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCodigo()
/*     */   {
/* 213 */     if (this.textoCodigo == null)
/*     */     {
/* 215 */       this.textoCodigo = new JTextField();
/* 216 */       this.textoCodigo.setBounds(new Rectangle(13, 38, 258, 25));
/*     */     }
/* 218 */     return this.textoCodigo;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCodigoBarra()
/*     */   {
/* 228 */     if (this.textoCodigoBarra == null)
/*     */     {
/* 230 */       this.textoCodigoBarra = new JTextField();
/* 231 */       this.textoCodigoBarra.setBounds(new Rectangle(13, 90, 258, 25));
/*     */     }
/* 233 */     return this.textoCodigoBarra;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoDescricao()
/*     */   {
/* 243 */     if (this.textoDescricao == null)
/*     */     {
/* 245 */       this.textoDescricao = new JTextField();
/* 246 */       this.textoDescricao.setBounds(new Rectangle(13, 142, 258, 25));
/*     */     }
/* 248 */     return this.textoDescricao;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoNCM()
/*     */   {
/* 258 */     if (this.textoNCM == null)
/*     */     {
/* 260 */       this.textoNCM = new JTextField();
/* 261 */       this.textoNCM.setBounds(new Rectangle(13, 194, 258, 25));
/*     */     }
/* 263 */     return this.textoNCM;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCFOP()
/*     */   {
/* 273 */     if (this.textoCFOP == null)
/*     */     {
/* 275 */       this.textoCFOP = new JTextField();
/* 276 */       this.textoCFOP.setBounds(new Rectangle(13, 246, 258, 25));
/* 277 */       this.textoCFOP.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 281 */           Long.parseLong(JanelaCadastrarProduto.this.textoCFOP.getText() + e.getKeyChar());
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
/* 293 */     return this.textoCFOP;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoUCom()
/*     */   {
/* 303 */     if (this.textoUCom == null)
/*     */     {
/* 305 */       this.textoUCom = new JTextField();
/* 306 */       this.textoUCom.setBounds(new Rectangle(13, 298, 258, 25));
/*     */     }
/* 308 */     return this.textoUCom;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoVUn()
/*     */   {
/* 318 */     if (this.textoVUn == null)
/*     */     {
/* 320 */       this.textoVUn = new JTextField();
/* 321 */       this.textoVUn.setBounds(new Rectangle(13, 350, 258, 25));
/* 322 */       this.textoVUn.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 326 */           Double.parseDouble(JanelaCadastrarProduto.this.textoVUn.getText() + e.getKeyChar());
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
/* 338 */     return this.textoVUn;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoindRegra()
/*     */   {
/* 348 */     if (this.textoindRegra == null)
/*     */     {
/* 350 */       this.textoindRegra = new JTextField();
/* 351 */       this.textoindRegra.setBounds(new Rectangle(13, 402, 258, 25));
/*     */     }
/* 353 */     return this.textoindRegra;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 363 */     if (this.botaoOK == null)
/*     */     {
/* 365 */       this.botaoOK = new JButton();
/* 366 */       this.botaoOK.setBounds(new Rectangle(13, 593, 100, 26));
/* 367 */       this.botaoOK.setText("OK");
/* 368 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 372 */           String cProd = JanelaCadastrarProduto.this.textoCodigo.getText();
/* 373 */           String cEAN = JanelaCadastrarProduto.this.textoCodigoBarra.getText();
/* 374 */           String xProd = JanelaCadastrarProduto.this.textoDescricao.getText();
/* 375 */           String NCM = JanelaCadastrarProduto.this.textoNCM.getText();
/* 376 */           String CFOP = JanelaCadastrarProduto.this.textoCFOP.getText();
/* 377 */           String uCom = JanelaCadastrarProduto.this.textoUCom.getText();
/* 378 */           String qCom = "1.0000";
/* 379 */           String vUnCom = JanelaCadastrarProduto.this.textoVUn.getText();
/* 380 */           String indRegra = JanelaCadastrarProduto.this.textoindRegra.getText();
/* 381 */           if (cProd.length() <= 0)
/*     */           {
/* 383 */             JOptionPane.showMessageDialog(null, "O campo \"Referência do produto\" é de preenchimento obrigatório!");
/* 384 */             return;
/*     */           }
/* 386 */           if (xProd.length() <= 0)
/*     */           {
/* 388 */             JOptionPane.showMessageDialog(null, "O campo \"Descrição do produto\" é de preenchimento obrigatório!");
/* 389 */             return;
/*     */           }
/* 391 */           if (CFOP.length() <= 0)
/*     */           {
/* 393 */             JOptionPane.showMessageDialog(null, "O campo \"Código Fiscal de Operações e Prestações\" é de preenchimento obrigatório!");
/* 394 */             return;
/*     */           }
/* 396 */           if (uCom.length() <= 0)
/*     */           {
/* 398 */             JOptionPane.showMessageDialog(null, "O campo \"Unidade Comercial\" é de preenchimento obrigatório!");
/* 399 */             return;
/*     */           }
/* 401 */           if (vUnCom.length() <= 0)
/*     */           {
/* 403 */             JOptionPane.showMessageDialog(null, "O campo \"Valor unitário\" é de preenchimento obrigatório!");
/* 404 */             return;
/*     */           }
/* 406 */           if (indRegra.length() <= 0)
/*     */           {
/* 408 */             JOptionPane.showMessageDialog(null, "O campo \"Regra de calculo (A ou T)\" é de preenchimento obrigatório!");
/* 409 */             return;
/*     */           }
/* 411 */           if ((!indRegra.equals("A")) && (!indRegra.equals("T")))
/*     */           {
/* 413 */             JOptionPane.showMessageDialog(null, "O campo \"Regra de calculo (A ou T)\" deve ser preenchido com \"A\" para arredondamento e \"T\" para truncamento!");
/* 414 */             return;
/*     */           }
/* 416 */           ArrayList<DetalhamentoProdutosCFe> produtos = JanelaCadastrarProduto.this.baseProd.getDet();
/* 417 */           for (DetalhamentoProdutosCFe d : produtos)
/*     */           {
/* 419 */             if (d.getProd().getcProd().equals(cProd))
/*     */             {
/* 421 */               JOptionPane.showMessageDialog(null, "Referência do produto já existente!");
/* 422 */               return;
/*     */             }
/*     */           }
/* 425 */           if (cEAN.length() <= 0)
/* 426 */             cEAN = null;
/* 427 */           if (NCM.length() <= 0)
/* 428 */             NCM = null;
/* 429 */           DetalhamentoProdutosCFe produto = new DetalhamentoProdutosCFe(cProd, cEAN, xProd, NCM, CFOP, uCom, qCom, vUnCom, indRegra, JanelaCadastrarProduto.this.jICMS00, JanelaCadastrarProduto.this.jICMS40, JanelaCadastrarProduto.this.jICMSSN102, JanelaCadastrarProduto.this.jICMSSN900, JanelaCadastrarProduto.this.jPISAliq, JanelaCadastrarProduto.this.jPISQtde, JanelaCadastrarProduto.this.jPISNT, JanelaCadastrarProduto.this.jCOFINSAliq, JanelaCadastrarProduto.this.jCOFINSQtde, JanelaCadastrarProduto.this.jCOFINSNT);
/* 430 */           JanelaCadastrarProduto.this.baseProd.getDet().add(produto);
/* 431 */           ControleArquivos.escreverCaracteresArquivo("DB_PROD.xml", JanelaCadastrarProduto.this.baseProd.toString().toCharArray());
/* 432 */           JanelaCadastrarProduto.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 436 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 446 */     if (this.botaoCancelar == null)
/*     */     {
/* 448 */       this.botaoCancelar = new JButton();
/* 449 */       this.botaoCancelar.setBounds(new Rectangle(171, 593, 100, 26));
/* 450 */       this.botaoCancelar.setText("Cancelar");
/* 451 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 455 */           JanelaCadastrarProduto.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 459 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboImposto()
/*     */   {
/* 469 */     if (this.comboICMS == null)
/*     */     {
/* 471 */       this.comboICMS = new JComboBox();
/* 472 */       this.comboICMS.setBounds(new Rectangle(13, 453, 258, 25));
/* 473 */       this.comboICMS.addItem("Tributada integralmente");
/* 474 */       this.comboICMS.addItem("Tributado com redução de base de cálculo");
/* 475 */       this.comboICMS.addItem("Isenta");
/* 476 */       this.comboICMS.addItem("Não tributada");
/* 477 */       this.comboICMS.addItem("Suspensão");
/* 478 */       this.comboICMS.addItem("Cobrado anteriormente por substituição tributária");
/* 479 */       this.comboICMS.addItem("Outros");
/* 480 */       this.comboICMS.addItem("Simples Nacional - Sem permissão de crédito");
/* 481 */       this.comboICMS.addItem("Simples Nacional - Imune");
/* 482 */       this.comboICMS.addItem("Simples Nacional - Cobrado anteriormente por substituição tributária ou por antecipação");
/* 483 */       this.comboICMS.addItem("Simples Nacional - Outros");
/* 484 */       this.comboICMS.setSelectedIndex(-1);
/* 485 */       this.comboICMS.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 489 */           int index = ((JComboBox)e.getSource()).getSelectedIndex();
/* 490 */           if ((index == 0) || (index == 1) || (index == 6))
/*     */           {
/* 492 */             String CST = "";
/* 493 */             if (index == 0)
/* 494 */               CST = "00";
/* 495 */             else if (index == 1)
/* 496 */               CST = "20";
/*     */             else
/* 498 */               CST = "90";
/* 499 */             JanelaCadastrarProduto.this.jICMS00 = new JanelaICMS00(JanelaCadastrarProduto.this, CST);
/* 500 */             JanelaCadastrarProduto.this.jICMS00.setVisible(true);
/* 501 */             JanelaCadastrarProduto.this.jICMS40 = null;
/* 502 */             JanelaCadastrarProduto.this.jICMSSN102 = null;
/* 503 */             JanelaCadastrarProduto.this.jICMSSN900 = null;
/*     */           }
/* 505 */           else if ((index == 2) || (index == 3) || (index == 4) || (index == 5))
/*     */           {
/* 507 */             String CST = "";
/* 508 */             if (index == 2)
/* 509 */               CST = "40";
/* 510 */             else if (index == 3)
/* 511 */               CST = "41";
/* 512 */             else if (index == 4)
/* 513 */               CST = "50";
/*     */             else
/* 515 */               CST = "60";
/* 516 */             JanelaCadastrarProduto.this.jICMS40 = new JanelaICMS40(JanelaCadastrarProduto.this, CST);
/* 517 */             JanelaCadastrarProduto.this.jICMS40.setVisible(true);
/* 518 */             JanelaCadastrarProduto.this.jICMS00 = null;
/* 519 */             JanelaCadastrarProduto.this.jICMSSN102 = null;
/* 520 */             JanelaCadastrarProduto.this.jICMSSN900 = null;
/*     */           }
/* 522 */           else if ((index == 7) || (index == 8) || (index == 9))
/*     */           {
/* 524 */             String CSOSN = "";
/* 525 */             if (index == 0)
/* 526 */               CSOSN = "102";
/* 527 */             else if (index == 1)
/* 528 */               CSOSN = "300";
/*     */             else
/* 530 */               CSOSN = "500";
/* 531 */             JanelaCadastrarProduto.this.jICMSSN102 = new JanelaICMSSN102(JanelaCadastrarProduto.this, CSOSN);
/* 532 */             JanelaCadastrarProduto.this.jICMSSN102.setVisible(true);
/* 533 */             JanelaCadastrarProduto.this.jICMS00 = null;
/* 534 */             JanelaCadastrarProduto.this.jICMS40 = null;
/* 535 */             JanelaCadastrarProduto.this.jICMSSN900 = null;
/*     */           }
/*     */           else
/*     */           {
/* 539 */             JanelaCadastrarProduto.this.jICMSSN900 = new JanelaICMSSN900(JanelaCadastrarProduto.this, "900");
/* 540 */             JanelaCadastrarProduto.this.jICMSSN900.setVisible(true);
/* 541 */             JanelaCadastrarProduto.this.jICMS00 = null;
/* 542 */             JanelaCadastrarProduto.this.jICMS40 = null;
/* 543 */             JanelaCadastrarProduto.this.jICMSSN102 = null;
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 548 */     return this.comboICMS;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboPIS()
/*     */   {
/* 558 */     if (this.comboPIS == null)
/*     */     {
/* 560 */       this.comboPIS = new JComboBox();
/* 561 */       this.comboPIS.setBounds(new Rectangle(13, 505, 258, 25));
/* 562 */       this.comboPIS.addItem("Alíquota");
/* 563 */       this.comboPIS.addItem("Quantidade");
/* 564 */       this.comboPIS.addItem("Não tributado");
/* 565 */       this.comboPIS.addItem("Simples nacional");
/* 566 */       this.comboPIS.setSelectedIndex(-1);
/* 567 */       this.comboPIS.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 571 */           int index = ((JComboBox)e.getSource()).getSelectedIndex();
/* 572 */           if (index == 0)
/*     */           {
/* 574 */             JanelaCadastrarProduto.this.jPISAliq = new JanelaPISAliq(JanelaCadastrarProduto.this);
/* 575 */             JanelaCadastrarProduto.this.jPISAliq.setVisible(true);
/* 576 */             JanelaCadastrarProduto.this.jPISQtde = null;
/* 577 */             JanelaCadastrarProduto.this.jPISNT = null;
/*     */           }
/* 579 */           else if (index == 1)
/*     */           {
/* 581 */             JanelaCadastrarProduto.this.jPISQtde = new JanelaPISQtde(JanelaCadastrarProduto.this);
/* 582 */             JanelaCadastrarProduto.this.jPISQtde.setVisible(true);
/* 583 */             JanelaCadastrarProduto.this.jPISAliq = null;
/* 584 */             JanelaCadastrarProduto.this.jPISNT = null;
/*     */           }
/* 586 */           else if (index == 2)
/*     */           {
/* 588 */             JanelaCadastrarProduto.this.jPISNT = new JanelaPISNT(JanelaCadastrarProduto.this);
/* 589 */             JanelaCadastrarProduto.this.jPISNT.setVisible(true);
/* 590 */             JanelaCadastrarProduto.this.jPISAliq = null;
/* 591 */             JanelaCadastrarProduto.this.jPISQtde = null;
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 596 */     return this.comboPIS;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboCOFINS()
/*     */   {
/* 606 */     if (this.comboCOFINS == null)
/*     */     {
/* 608 */       this.comboCOFINS = new JComboBox();
/* 609 */       this.comboCOFINS.setBounds(new Rectangle(13, 558, 258, 25));
/* 610 */       this.comboCOFINS.addItem("Alíquota");
/* 611 */       this.comboCOFINS.addItem("Quantidade");
/* 612 */       this.comboCOFINS.addItem("Não tributado");
/* 613 */       this.comboCOFINS.addItem("Simples nacional");
/* 614 */       this.comboCOFINS.setSelectedIndex(-1);
/* 615 */       this.comboCOFINS.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 619 */           int index = ((JComboBox)e.getSource()).getSelectedIndex();
/* 620 */           if (index == 0)
/*     */           {
/* 622 */             JanelaCadastrarProduto.this.jCOFINSAliq = new JanelaCOFINSAliq(JanelaCadastrarProduto.this);
/* 623 */             JanelaCadastrarProduto.this.jCOFINSAliq.setVisible(true);
/* 624 */             JanelaCadastrarProduto.this.jCOFINSQtde = null;
/* 625 */             JanelaCadastrarProduto.this.jCOFINSNT = null;
/*     */           }
/* 627 */           else if (index == 1)
/*     */           {
/* 629 */             JanelaCadastrarProduto.this.jCOFINSQtde = new JanelaCOFINSQtde(JanelaCadastrarProduto.this);
/* 630 */             JanelaCadastrarProduto.this.jCOFINSQtde.setVisible(true);
/* 631 */             JanelaCadastrarProduto.this.jCOFINSAliq = null;
/* 632 */             JanelaCadastrarProduto.this.jCOFINSNT = null;
/*     */           }
/* 634 */           else if (index == 2)
/*     */           {
/* 636 */             JanelaCadastrarProduto.this.jCOFINSNT = new JanelaCOFINSNT(JanelaCadastrarProduto.this);
/* 637 */             JanelaCadastrarProduto.this.jCOFINSNT.setVisible(true);
/* 638 */             JanelaCadastrarProduto.this.jCOFINSAliq = null;
/* 639 */             JanelaCadastrarProduto.this.jCOFINSQtde = null;
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 644 */     return this.comboCOFINS;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaCadastrarProduto
 * JD-Core Version:    0.6.2
 */