/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.modelos.cfeac.COFINSAliq;
/*     */ import br.com.pirus.ac.modelos.cfeac.COFINSNT;
/*     */ import br.com.pirus.ac.modelos.cfeac.COFINSQtde;
/*     */ import br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.ICMS00;
/*     */ import br.com.pirus.ac.modelos.cfeac.ICMS40;
/*     */ import br.com.pirus.ac.modelos.cfeac.ICMSSN102;
/*     */ import br.com.pirus.ac.modelos.cfeac.ICMSSN900;
/*     */ import br.com.pirus.ac.modelos.cfeac.InformacoesCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.InformacoesCOFINS;
/*     */ import br.com.pirus.ac.modelos.cfeac.InformacoesICMS;
/*     */ import br.com.pirus.ac.modelos.cfeac.InformacoesPIS;
/*     */ import br.com.pirus.ac.modelos.cfeac.PISAliq;
/*     */ import br.com.pirus.ac.modelos.cfeac.PISNT;
/*     */ import br.com.pirus.ac.modelos.cfeac.PISQtde;
/*     */ import br.com.pirus.ac.modelos.cfeac.ProdutoCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.TributosCFe;
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
/*     */ public class JanelaConfigurarProduto extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  42 */   private JPanel jContentPane = null;
/*     */ 
/*  44 */   private JLabel labelCodigo = null;
/*     */ 
/*  46 */   private JLabel labelCodigoBarras = null;
/*     */ 
/*  48 */   private JLabel labelDescricao = null;
/*     */ 
/*  50 */   private JLabel labelNCM = null;
/*     */ 
/*  52 */   private JLabel labelCFOP = null;
/*     */ 
/*  54 */   private JLabel labelUCom = null;
/*     */ 
/*  56 */   private JLabel labelVUCom = null;
/*     */ 
/*  58 */   private JLabel labelIndRegra = null;
/*     */ 
/*  60 */   private JTextField textoCodigo = null;
/*     */ 
/*  62 */   private JTextField textoCodigoBarra = null;
/*     */ 
/*  64 */   private JTextField textoDescricao = null;
/*     */ 
/*  66 */   private JTextField textoNCM = null;
/*     */ 
/*  68 */   private JTextField textoCFOP = null;
/*     */ 
/*  70 */   private JTextField textoUCom = null;
/*     */ 
/*  72 */   private JTextField textoVUn = null;
/*     */ 
/*  74 */   private JTextField textoindRegra = null;
/*     */ 
/*  76 */   private JButton botaoOK = null;
/*     */ 
/*  78 */   private JButton botaoCancelar = null;
/*     */   private InformacoesCFe baseProd;
/*  82 */   private JComboBox comboProdutos = null;
/*     */ 
/*  84 */   private JLabel labelProdutos = null;
/*     */ 
/*  86 */   private String referenciaAntiga = "";
/*     */ 
/*  88 */   private JLabel labelTributacaoICMS = null;
/*     */ 
/*  90 */   private JComboBox comboICMS = null;
/*     */ 
/*  92 */   private JLabel labelTributacaoPIS = null;
/*     */ 
/*  94 */   private JLabel labelTributacaoCOFINS = null;
/*     */ 
/*  96 */   private JComboBox comboPIS = null;
/*     */ 
/*  98 */   private JComboBox comboCOFINS = null;
/*     */ 
/* 100 */   protected JanelaICMS00 jICMS00 = null;
/*     */ 
/* 102 */   protected JanelaICMS40 jICMS40 = null;
/*     */ 
/* 104 */   protected JanelaICMSSN102 jICMSSN102 = null;
/*     */ 
/* 106 */   protected JanelaICMSSN900 jICMSSN900 = null;
/*     */ 
/* 108 */   protected JanelaCOFINSAliq jCOFINSAliq = null;
/*     */ 
/* 110 */   protected JanelaCOFINSQtde jCOFINSQtde = null;
/*     */ 
/* 112 */   protected JanelaCOFINSNT jCOFINSNT = null;
/*     */ 
/* 114 */   protected JanelaPISAliq jPISAliq = null;
/*     */ 
/* 116 */   protected JanelaPISQtde jPISQtde = null;
/*     */ 
/* 118 */   protected JanelaPISNT jPISNT = null;
/*     */ 
/*     */   public JanelaConfigurarProduto(Frame owner, InformacoesCFe baseProd)
/*     */   {
/* 125 */     super(owner);
/* 126 */     this.baseProd = baseProd;
/* 127 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/* 139 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 143 */       e.printStackTrace();
/*     */     }
/* 145 */     setSize(287, 730);
/* 146 */     setResizable(false);
/* 147 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/* 148 */     setTitle("Configurar produto");
/* 149 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/* 159 */     if (this.jContentPane == null)
/*     */     {
/* 161 */       this.labelTributacaoCOFINS = new JLabel();
/* 162 */       this.labelTributacaoCOFINS.setBounds(new Rectangle(13, 599, 120, 16));
/* 163 */       this.labelTributacaoCOFINS.setText("Tributação COFINS:");
/* 164 */       this.labelTributacaoPIS = new JLabel();
/* 165 */       this.labelTributacaoPIS.setBounds(new Rectangle(13, 547, 96, 16));
/* 166 */       this.labelTributacaoPIS.setText("Tributação PIS:");
/* 167 */       this.labelTributacaoICMS = new JLabel();
/* 168 */       this.labelTributacaoICMS.setBounds(new Rectangle(13, 495, 101, 16));
/* 169 */       this.labelTributacaoICMS.setText("Tributação ICMS:");
/* 170 */       this.labelProdutos = new JLabel();
/* 171 */       this.labelProdutos.setBounds(new Rectangle(13, 13, 79, 16));
/* 172 */       this.labelProdutos.setText("Produtos");
/* 173 */       this.labelIndRegra = new JLabel();
/* 174 */       this.labelIndRegra.setBounds(new Rectangle(13, 441, 150, 16));
/* 175 */       this.labelIndRegra.setText("Regra de calculo (A ou T)");
/* 176 */       this.labelVUCom = new JLabel();
/* 177 */       this.labelVUCom.setBounds(new Rectangle(13, 389, 89, 16));
/* 178 */       this.labelVUCom.setText("Valor unitário");
/* 179 */       this.labelUCom = new JLabel();
/* 180 */       this.labelUCom.setBounds(new Rectangle(13, 337, 113, 16));
/* 181 */       this.labelUCom.setText("Unidade comercial");
/* 182 */       this.labelCFOP = new JLabel();
/* 183 */       this.labelCFOP.setBounds(new Rectangle(13, 285, 240, 16));
/* 184 */       this.labelCFOP.setText("Código Fiscal de Operações e Prestações");
/* 185 */       this.labelNCM = new JLabel();
/* 186 */       this.labelNCM.setBounds(new Rectangle(13, 233, 73, 16));
/* 187 */       this.labelNCM.setText("Código NCM");
/* 188 */       this.labelDescricao = new JLabel();
/* 189 */       this.labelDescricao.setBounds(new Rectangle(13, 181, 132, 16));
/* 190 */       this.labelDescricao.setText("Descrição do produto");
/* 191 */       this.labelCodigoBarras = new JLabel();
/* 192 */       this.labelCodigoBarras.setBounds(new Rectangle(13, 129, 106, 16));
/* 193 */       this.labelCodigoBarras.setText("Código de barras");
/* 194 */       this.labelCodigo = new JLabel();
/* 195 */       this.labelCodigo.setBounds(new Rectangle(13, 77, 132, 16));
/* 196 */       this.labelCodigo.setText("Referência do produto");
/* 197 */       this.jContentPane = new JPanel();
/* 198 */       this.jContentPane.setLayout(null);
/* 199 */       this.jContentPane.add(this.labelCodigo, null);
/* 200 */       this.jContentPane.add(this.labelCodigoBarras, null);
/* 201 */       this.jContentPane.add(this.labelDescricao, null);
/* 202 */       this.jContentPane.add(this.labelNCM, null);
/* 203 */       this.jContentPane.add(this.labelCFOP, null);
/* 204 */       this.jContentPane.add(this.labelUCom, null);
/* 205 */       this.jContentPane.add(this.labelVUCom, null);
/* 206 */       this.jContentPane.add(this.labelIndRegra, null);
/* 207 */       this.jContentPane.add(getTextoCodigo(), null);
/* 208 */       this.jContentPane.add(getTextoCodigoBarra(), null);
/* 209 */       this.jContentPane.add(getTextoDescricao(), null);
/* 210 */       this.jContentPane.add(getTextoNCM(), null);
/* 211 */       this.jContentPane.add(getTextoCFOP(), null);
/* 212 */       this.jContentPane.add(getTextoUCom(), null);
/* 213 */       this.jContentPane.add(getTextoVUn(), null);
/* 214 */       this.jContentPane.add(getTextoindRegra(), null);
/* 215 */       this.jContentPane.add(getBotaoOK(), null);
/* 216 */       this.jContentPane.add(getBotaoCancelar(), null);
/* 217 */       this.jContentPane.add(this.labelProdutos, null);
/* 218 */       this.jContentPane.add(this.labelTributacaoICMS, null);
/* 219 */       this.jContentPane.add(getComboImposto(), null);
/* 220 */       this.jContentPane.add(this.labelTributacaoPIS, null);
/* 221 */       this.jContentPane.add(this.labelTributacaoCOFINS, null);
/* 222 */       this.jContentPane.add(getComboPIS(), null);
/* 223 */       this.jContentPane.add(getComboCOFINS(), null);
/* 224 */       this.jContentPane.add(getComboProdutos(), null);
/*     */     }
/* 226 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCodigo()
/*     */   {
/* 236 */     if (this.textoCodigo == null)
/*     */     {
/* 238 */       this.textoCodigo = new JTextField();
/* 239 */       this.textoCodigo.setBounds(new Rectangle(13, 99, 258, 25));
/*     */     }
/* 241 */     return this.textoCodigo;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCodigoBarra()
/*     */   {
/* 251 */     if (this.textoCodigoBarra == null)
/*     */     {
/* 253 */       this.textoCodigoBarra = new JTextField();
/* 254 */       this.textoCodigoBarra.setBounds(new Rectangle(13, 151, 258, 25));
/*     */     }
/* 256 */     return this.textoCodigoBarra;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoDescricao()
/*     */   {
/* 266 */     if (this.textoDescricao == null)
/*     */     {
/* 268 */       this.textoDescricao = new JTextField();
/* 269 */       this.textoDescricao.setBounds(new Rectangle(13, 203, 258, 25));
/*     */     }
/* 271 */     return this.textoDescricao;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoNCM()
/*     */   {
/* 281 */     if (this.textoNCM == null)
/*     */     {
/* 283 */       this.textoNCM = new JTextField();
/* 284 */       this.textoNCM.setBounds(new Rectangle(13, 255, 258, 25));
/*     */     }
/* 286 */     return this.textoNCM;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoCFOP()
/*     */   {
/* 296 */     if (this.textoCFOP == null)
/*     */     {
/* 298 */       this.textoCFOP = new JTextField();
/* 299 */       this.textoCFOP.setBounds(new Rectangle(13, 307, 258, 25));
/* 300 */       this.textoCFOP.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 304 */           Long.parseLong(JanelaConfigurarProduto.this.textoCFOP.getText() + e.getKeyChar());
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
/* 316 */     return this.textoCFOP;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoUCom()
/*     */   {
/* 326 */     if (this.textoUCom == null)
/*     */     {
/* 328 */       this.textoUCom = new JTextField();
/* 329 */       this.textoUCom.setBounds(new Rectangle(13, 359, 258, 25));
/*     */     }
/* 331 */     return this.textoUCom;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoVUn()
/*     */   {
/* 341 */     if (this.textoVUn == null)
/*     */     {
/* 343 */       this.textoVUn = new JTextField();
/* 344 */       this.textoVUn.setBounds(new Rectangle(13, 411, 258, 25));
/* 345 */       this.textoVUn.addKeyListener(new KeyListener()
/*     */       {
/*     */         public void keyTyped(KeyEvent e)
/*     */         {
/* 349 */           Double.parseDouble(JanelaConfigurarProduto.this.textoVUn.getText() + e.getKeyChar());
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
/* 361 */     return this.textoVUn;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoindRegra()
/*     */   {
/* 371 */     if (this.textoindRegra == null)
/*     */     {
/* 373 */       this.textoindRegra = new JTextField();
/* 374 */       this.textoindRegra.setBounds(new Rectangle(13, 463, 258, 25));
/*     */     }
/* 376 */     return this.textoindRegra;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 386 */     if (this.botaoOK == null)
/*     */     {
/* 388 */       this.botaoOK = new JButton();
/* 389 */       this.botaoOK.setBounds(new Rectangle(13, 663, 100, 26));
/* 390 */       this.botaoOK.setText("Salvar");
/* 391 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 395 */           String cProd = JanelaConfigurarProduto.this.textoCodigo.getText();
/* 396 */           String cEAN = JanelaConfigurarProduto.this.textoCodigoBarra.getText();
/* 397 */           String xProd = JanelaConfigurarProduto.this.textoDescricao.getText();
/* 398 */           String NCM = JanelaConfigurarProduto.this.textoNCM.getText();
/* 399 */           String CFOP = JanelaConfigurarProduto.this.textoCFOP.getText();
/* 400 */           String uCom = JanelaConfigurarProduto.this.textoUCom.getText();
/* 401 */           String vUnCom = JanelaConfigurarProduto.this.textoVUn.getText();
/* 402 */           String indRegra = JanelaConfigurarProduto.this.textoindRegra.getText();
/* 403 */           if (cProd.length() <= 0)
/*     */           {
/* 405 */             JOptionPane.showMessageDialog(null, "O campo \"Referência do produto\" é de preenchimento obrigatório!");
/* 406 */             return;
/*     */           }
/* 408 */           if (xProd.length() <= 0)
/*     */           {
/* 410 */             JOptionPane.showMessageDialog(null, "O campo \"Descrição do produto\" é de preenchimento obrigatório!");
/* 411 */             return;
/*     */           }
/* 413 */           if (CFOP.length() <= 0)
/*     */           {
/* 415 */             JOptionPane.showMessageDialog(null, "O campo \"Código Fiscal de Operações e Prestações\" é de preenchimento obrigatório!");
/* 416 */             return;
/*     */           }
/* 418 */           if (uCom.length() <= 0)
/*     */           {
/* 420 */             JOptionPane.showMessageDialog(null, "O campo \"Unidade Comercial\" é de preenchimento obrigatório!");
/* 421 */             return;
/*     */           }
/* 423 */           if (vUnCom.length() <= 0)
/*     */           {
/* 425 */             JOptionPane.showMessageDialog(null, "O campo \"Valor unitário\" é de preenchimento obrigatório!");
/* 426 */             return;
/*     */           }
/* 428 */           if (indRegra.length() <= 0)
/*     */           {
/* 430 */             JOptionPane.showMessageDialog(null, "O campo \"Regra de calculo (A ou T)\" é de preenchimento obrigatório!");
/* 431 */             return;
/*     */           }
/* 433 */           if ((!indRegra.equals("A")) && (!indRegra.equals("T")))
/*     */           {
/* 435 */             JOptionPane.showMessageDialog(null, "O campo \"Regra de calculo (A ou T)\" deve ser preenchido com \"A\" para arredondamento e \"T\" para truncamento!");
/* 436 */             return;
/*     */           }
/* 438 */           ArrayList<DetalhamentoProdutosCFe> produtos = JanelaConfigurarProduto.this.baseProd.getDet();
/* 439 */           for (DetalhamentoProdutosCFe d : produtos)
/*     */           {
/* 441 */             if ((d.getProd().getcProd().equals(cProd)) && (!cProd.equals(JanelaConfigurarProduto.this.referenciaAntiga)))
/*     */             {
/* 443 */               JOptionPane.showMessageDialog(null, "Referência do produto já existente!");
/* 444 */               return;
/*     */             }
/*     */           }
/* 447 */           if (cEAN.length() <= 0)
/* 448 */             cEAN = null;
/* 449 */           if (NCM.length() <= 0)
/* 450 */             NCM = null;
/* 451 */           DetalhamentoProdutosCFe produto = (DetalhamentoProdutosCFe)JanelaConfigurarProduto.this.comboProdutos.getSelectedItem();
/* 452 */           produto.getProd().setcProd(cProd);
/* 453 */           produto.getProd().setcEAN(cEAN);
/* 454 */           produto.getProd().setxProd(xProd);
/* 455 */           produto.getProd().setNCM(NCM);
/* 456 */           produto.getProd().setCFOP(CFOP);
/* 457 */           produto.getProd().setuCom(uCom);
/* 458 */           produto.getProd().setqCom("1.000");
/* 459 */           produto.getProd().setvUnCom(vUnCom);
/* 460 */           produto.getProd().setIndRegra(indRegra);
/* 461 */           InformacoesICMS infICMS = null;
/* 462 */           InformacoesPIS infPIS = null;
/* 463 */           InformacoesCOFINS infCOFINS = null;
/* 464 */           if (JanelaConfigurarProduto.this.jICMS00 != null)
/*     */           {
/* 466 */             ICMS00 i00 = new ICMS00(JanelaConfigurarProduto.this.jICMS00.orig, JanelaConfigurarProduto.this.jICMS00.CST, JanelaConfigurarProduto.this.jICMS00.aliq);
/* 467 */             infICMS = new InformacoesICMS(i00);
/* 468 */             produto.getImposto().setICMS(infICMS);
/*     */           }
/* 470 */           else if (JanelaConfigurarProduto.this.jICMS40 != null)
/*     */           {
/* 472 */             ICMS40 i40 = new ICMS40(JanelaConfigurarProduto.this.jICMS40.orig, JanelaConfigurarProduto.this.jICMS40.CST);
/* 473 */             infICMS = new InformacoesICMS(i40);
/* 474 */             produto.getImposto().setICMS(infICMS);
/*     */           }
/* 476 */           else if (JanelaConfigurarProduto.this.jICMSSN102 != null)
/*     */           {
/* 478 */             ICMSSN102 i102 = new ICMSSN102(JanelaConfigurarProduto.this.jICMSSN102.orig, JanelaConfigurarProduto.this.jICMSSN102.CSOSN);
/* 479 */             infICMS = new InformacoesICMS(i102);
/* 480 */             produto.getImposto().setICMS(infICMS);
/*     */           }
/* 482 */           else if (JanelaConfigurarProduto.this.jICMSSN900 != null)
/*     */           {
/* 484 */             ICMSSN900 i900 = new ICMSSN900(JanelaConfigurarProduto.this.jICMSSN900.orig, JanelaConfigurarProduto.this.jICMSSN900.CSOSN, JanelaConfigurarProduto.this.jICMSSN900.aliq);
/* 485 */             infICMS = new InformacoesICMS(i900);
/* 486 */             produto.getImposto().setICMS(infICMS);
/*     */           }
/* 488 */           if (JanelaConfigurarProduto.this.jPISAliq != null)
/*     */           {
/* 490 */             PISAliq pAliq = new PISAliq(JanelaConfigurarProduto.this.jPISAliq.CST, JanelaConfigurarProduto.this.jPISAliq.BC, JanelaConfigurarProduto.this.jPISAliq.aliq);
/* 491 */             infPIS = new InformacoesPIS(pAliq);
/* 492 */             produto.getImposto().setPIS(infPIS);
/*     */           }
/* 494 */           else if (JanelaConfigurarProduto.this.jPISQtde != null)
/*     */           {
/* 496 */             PISQtde pQtde = new PISQtde(JanelaConfigurarProduto.this.jPISQtde.CST, "", JanelaConfigurarProduto.this.jPISQtde.aliq);
/* 497 */             infPIS = new InformacoesPIS(pQtde);
/* 498 */             produto.getImposto().setPIS(infPIS);
/*     */           }
/* 500 */           else if (JanelaConfigurarProduto.this.jPISNT != null)
/*     */           {
/* 502 */             PISNT pNT = new PISNT(JanelaConfigurarProduto.this.jPISNT.CST);
/* 503 */             infPIS = new InformacoesPIS(pNT);
/* 504 */             produto.getImposto().setPIS(infPIS);
/*     */           }
/* 506 */           if (JanelaConfigurarProduto.this.jCOFINSAliq != null)
/*     */           {
/* 508 */             COFINSAliq cAliq = new COFINSAliq(JanelaConfigurarProduto.this.jCOFINSAliq.CST, JanelaConfigurarProduto.this.jCOFINSAliq.BC, JanelaConfigurarProduto.this.jCOFINSAliq.aliq);
/* 509 */             infCOFINS = new InformacoesCOFINS(cAliq);
/* 510 */             produto.getImposto().setCOFINS(infCOFINS);
/*     */           }
/* 512 */           else if (JanelaConfigurarProduto.this.jCOFINSQtde != null)
/*     */           {
/* 514 */             COFINSQtde cQtde = new COFINSQtde(JanelaConfigurarProduto.this.jCOFINSQtde.CST, "", JanelaConfigurarProduto.this.jCOFINSQtde.aliq);
/* 515 */             infCOFINS = new InformacoesCOFINS(cQtde);
/* 516 */             produto.getImposto().setCOFINS(infCOFINS);
/*     */           }
/* 518 */           else if (JanelaConfigurarProduto.this.jCOFINSNT != null)
/*     */           {
/* 520 */             COFINSNT cNT = new COFINSNT(JanelaConfigurarProduto.this.jCOFINSNT.CST);
/* 521 */             infCOFINS = new InformacoesCOFINS(cNT);
/* 522 */             produto.getImposto().setCOFINS(infCOFINS);
/*     */           }
/* 524 */           ControleArquivos.escreverCaracteresArquivo("DB_PROD.xml", JanelaConfigurarProduto.this.baseProd.toString().toCharArray());
/* 525 */           JanelaConfigurarProduto.this.jICMS00 = null;
/* 526 */           JanelaConfigurarProduto.this.jICMS40 = null;
/* 527 */           JanelaConfigurarProduto.this.jICMSSN102 = null;
/* 528 */           JanelaConfigurarProduto.this.jICMSSN900 = null;
/* 529 */           JanelaConfigurarProduto.this.jCOFINSAliq = null;
/* 530 */           JanelaConfigurarProduto.this.jCOFINSQtde = null;
/* 531 */           JanelaConfigurarProduto.this.jCOFINSNT = null;
/* 532 */           JanelaConfigurarProduto.this.jPISAliq = null;
/* 533 */           JanelaConfigurarProduto.this.jPISQtde = null;
/* 534 */           JanelaConfigurarProduto.this.jPISNT = null;
/* 535 */           JOptionPane.showMessageDialog(JanelaConfigurarProduto.this, "Alterações salvas com sucesso!");
/*     */         }
/*     */       });
/*     */     }
/* 539 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 549 */     if (this.botaoCancelar == null)
/*     */     {
/* 551 */       this.botaoCancelar = new JButton();
/* 552 */       this.botaoCancelar.setBounds(new Rectangle(171, 663, 100, 26));
/* 553 */       this.botaoCancelar.setText("Sair");
/* 554 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 558 */           JanelaConfigurarProduto.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 562 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboProdutos()
/*     */   {
/* 572 */     if (this.comboProdutos == null)
/*     */     {
/* 574 */       this.comboProdutos = new JComboBox();
/* 575 */       this.comboProdutos.setBounds(new Rectangle(13, 35, 258, 20));
/* 576 */       ArrayList<DetalhamentoProdutosCFe> array = this.baseProd.getDet();
/* 577 */       for (DetalhamentoProdutosCFe o : array)
/* 578 */         this.comboProdutos.addItem(o);
/* 579 */       selecionar();
/* 580 */       this.comboProdutos.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 584 */           JanelaConfigurarProduto.this.selecionar();
/*     */         }
/*     */       });
/*     */     }
/* 588 */     return this.comboProdutos;
/*     */   }
/*     */ 
/*     */   private void selecionar()
/*     */   {
/* 593 */     for (ActionListener al : this.comboICMS.getActionListeners()) {
/* 594 */       this.comboICMS.removeActionListener(al);
/*     */     }
/* 596 */     for (ActionListener al : this.comboPIS.getActionListeners()) {
/* 597 */       this.comboPIS.removeActionListener(al);
/*     */     }
/* 599 */     for (ActionListener al : this.comboCOFINS.getActionListeners()) {
/* 600 */       this.comboCOFINS.removeActionListener(al);
/*     */     }
/*     */ 
/* 603 */     DetalhamentoProdutosCFe selecionado = (DetalhamentoProdutosCFe)this.comboProdutos.getSelectedItem();
/* 604 */     this.textoCodigo.setText(this.referenciaAntiga = selecionado.getProd().getcProd());
/* 605 */     this.textoCodigoBarra.setText(selecionado.getProd().getcEAN());
/* 606 */     this.textoDescricao.setText(selecionado.getProd().getxProd());
/* 607 */     this.textoNCM.setText(selecionado.getProd().getNCM());
/* 608 */     this.textoCFOP.setText(selecionado.getProd().getCFOP());
/* 609 */     this.textoUCom.setText(selecionado.getProd().getuCom());
/* 610 */     this.textoVUn.setText(selecionado.getProd().getvUnCom());
/* 611 */     this.textoindRegra.setText(selecionado.getProd().getIndRegra());
/* 612 */     InformacoesICMS infICMS = selecionado.getImposto().getICMS();
/* 613 */     ICMS00 i00 = infICMS.getICMS00();
/* 614 */     ICMS40 i40 = infICMS.getICMS40();
/* 615 */     ICMSSN102 i102 = infICMS.getICMSSN102();
/* 616 */     ICMSSN900 i900 = infICMS.getICMSSN900();
/* 617 */     if (i00 != null)
/*     */     {
/* 619 */       String CST = i00.getCST();
/* 620 */       if (CST.equals("00"))
/*     */       {
/* 622 */         this.comboICMS.setSelectedIndex(0);
/*     */       }
/* 624 */       else if (CST.equals("20"))
/*     */       {
/* 626 */         this.comboICMS.setSelectedIndex(1);
/*     */       }
/* 628 */       else if (CST.equals("90"))
/*     */       {
/* 630 */         this.comboICMS.setSelectedIndex(6);
/*     */       }
/*     */     }
/* 633 */     else if (i40 != null)
/*     */     {
/* 635 */       String CST = i40.getCST();
/* 636 */       if (CST.equals("40"))
/*     */       {
/* 638 */         this.comboICMS.setSelectedIndex(2);
/*     */       }
/* 640 */       else if (CST.equals("41"))
/*     */       {
/* 642 */         this.comboICMS.setSelectedIndex(3);
/*     */       }
/* 644 */       else if (CST.equals("50"))
/*     */       {
/* 646 */         this.comboICMS.setSelectedIndex(4);
/*     */       }
/* 648 */       else if (CST.equals("60"))
/*     */       {
/* 650 */         this.comboICMS.setSelectedIndex(5);
/*     */       }
/*     */     }
/* 653 */     else if (i102 != null)
/*     */     {
/* 655 */       String CST = i102.getCSOSN();
/* 656 */       if (CST.equals("102"))
/*     */       {
/* 658 */         this.comboICMS.setSelectedIndex(7);
/*     */       }
/* 660 */       else if (CST.equals("300"))
/*     */       {
/* 662 */         this.comboICMS.setSelectedIndex(8);
/*     */       }
/* 664 */       else if (CST.equals("500"))
/*     */       {
/* 666 */         this.comboICMS.setSelectedIndex(9);
/*     */       }
/*     */     }
/* 669 */     else if (i900 != null)
/*     */     {
/* 671 */       this.comboICMS.setSelectedIndex(10);
/*     */     }
/* 673 */     InformacoesPIS infPIS = selecionado.getImposto().getPIS();
/* 674 */     PISAliq pAliq = infPIS.getPISAliq();
/* 675 */     PISQtde pQtde = infPIS.getPISQTde();
/* 676 */     PISNT pNT = infPIS.getPISNT();
/* 677 */     if (pAliq != null)
/*     */     {
/* 679 */       this.comboPIS.setSelectedIndex(0);
/*     */     }
/* 681 */     else if (pQtde != null)
/*     */     {
/* 683 */       this.comboPIS.setSelectedIndex(1);
/*     */     }
/* 685 */     else if (pNT != null)
/*     */     {
/* 687 */       this.comboPIS.setSelectedIndex(2);
/*     */     }
/* 689 */     InformacoesCOFINS infCOFINS = selecionado.getImposto().getCOFINS();
/* 690 */     COFINSAliq cAliq = infCOFINS.getCOFINSAliq();
/* 691 */     COFINSQtde cQtde = infCOFINS.getCOFINSQTde();
/* 692 */     COFINSNT cNT = infCOFINS.getCOFINSNT();
/* 693 */     if (cAliq != null)
/*     */     {
/* 695 */       this.comboCOFINS.setSelectedIndex(0);
/*     */     }
/* 697 */     else if (cQtde != null)
/*     */     {
/* 699 */       this.comboCOFINS.setSelectedIndex(1);
/*     */     }
/* 701 */     else if (cNT != null)
/*     */     {
/* 703 */       this.comboCOFINS.setSelectedIndex(2);
/*     */     }
/* 705 */     this.comboPIS.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 709 */         int index = ((JComboBox)e.getSource()).getSelectedIndex();
/* 710 */         if (index == 0)
/*     */         {
/* 712 */           JanelaConfigurarProduto.this.jPISAliq = new JanelaPISAliq(JanelaConfigurarProduto.this);
/* 713 */           JanelaConfigurarProduto.this.jPISAliq.setVisible(true);
/* 714 */           JanelaConfigurarProduto.this.jPISQtde = null;
/* 715 */           JanelaConfigurarProduto.this.jPISNT = null;
/*     */         }
/* 717 */         else if (index == 1)
/*     */         {
/* 719 */           JanelaConfigurarProduto.this.jPISQtde = new JanelaPISQtde(JanelaConfigurarProduto.this);
/* 720 */           JanelaConfigurarProduto.this.jPISQtde.setVisible(true);
/* 721 */           JanelaConfigurarProduto.this.jPISAliq = null;
/* 722 */           JanelaConfigurarProduto.this.jPISNT = null;
/*     */         }
/* 724 */         else if (index == 2)
/*     */         {
/* 726 */           JanelaConfigurarProduto.this.jPISNT = new JanelaPISNT(JanelaConfigurarProduto.this);
/* 727 */           JanelaConfigurarProduto.this.jPISNT.setVisible(true);
/* 728 */           JanelaConfigurarProduto.this.jPISAliq = null;
/* 729 */           JanelaConfigurarProduto.this.jPISQtde = null;
/*     */         }
/*     */       }
/*     */     });
/* 733 */     this.comboICMS.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 737 */         int index = ((JComboBox)e.getSource()).getSelectedIndex();
/* 738 */         if ((index == 0) || (index == 1) || (index == 6))
/*     */         {
/* 740 */           String CST = "";
/* 741 */           if (index == 0)
/* 742 */             CST = "00";
/* 743 */           else if (index == 1)
/* 744 */             CST = "20";
/*     */           else
/* 746 */             CST = "90";
/* 747 */           JanelaConfigurarProduto.this.jICMS00 = new JanelaICMS00(JanelaConfigurarProduto.this, CST);
/* 748 */           JanelaConfigurarProduto.this.jICMS00.setVisible(true);
/* 749 */           JanelaConfigurarProduto.this.jICMS40 = null;
/* 750 */           JanelaConfigurarProduto.this.jICMSSN102 = null;
/* 751 */           JanelaConfigurarProduto.this.jICMSSN900 = null;
/*     */         }
/* 753 */         else if ((index == 2) || (index == 3) || (index == 4) || (index == 5))
/*     */         {
/* 755 */           String CST = "";
/* 756 */           if (index == 2)
/* 757 */             CST = "40";
/* 758 */           else if (index == 3)
/* 759 */             CST = "41";
/* 760 */           else if (index == 4)
/* 761 */             CST = "50";
/*     */           else
/* 763 */             CST = "60";
/* 764 */           JanelaConfigurarProduto.this.jICMS40 = new JanelaICMS40(JanelaConfigurarProduto.this, CST);
/* 765 */           JanelaConfigurarProduto.this.jICMS40.setVisible(true);
/* 766 */           JanelaConfigurarProduto.this.jICMS00 = null;
/* 767 */           JanelaConfigurarProduto.this.jICMSSN102 = null;
/* 768 */           JanelaConfigurarProduto.this.jICMSSN900 = null;
/*     */         }
/* 770 */         else if ((index == 7) || (index == 8) || (index == 9))
/*     */         {
/* 772 */           String CSOSN = "";
/* 773 */           if (index == 0)
/* 774 */             CSOSN = "102";
/* 775 */           else if (index == 1)
/* 776 */             CSOSN = "300";
/*     */           else
/* 778 */             CSOSN = "500";
/* 779 */           JanelaConfigurarProduto.this.jICMSSN102 = new JanelaICMSSN102(JanelaConfigurarProduto.this, CSOSN);
/* 780 */           JanelaConfigurarProduto.this.jICMSSN102.setVisible(true);
/* 781 */           JanelaConfigurarProduto.this.jICMS00 = null;
/* 782 */           JanelaConfigurarProduto.this.jICMS40 = null;
/* 783 */           JanelaConfigurarProduto.this.jICMSSN900 = null;
/*     */         }
/*     */         else
/*     */         {
/* 787 */           JanelaConfigurarProduto.this.jICMSSN900 = new JanelaICMSSN900(JanelaConfigurarProduto.this, "900");
/* 788 */           JanelaConfigurarProduto.this.jICMSSN900.setVisible(true);
/* 789 */           JanelaConfigurarProduto.this.jICMS00 = null;
/* 790 */           JanelaConfigurarProduto.this.jICMS40 = null;
/* 791 */           JanelaConfigurarProduto.this.jICMSSN102 = null;
/*     */         }
/*     */       }
/*     */     });
/* 795 */     this.comboCOFINS.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 799 */         int index = ((JComboBox)e.getSource()).getSelectedIndex();
/* 800 */         if (index == 0)
/*     */         {
/* 802 */           JanelaConfigurarProduto.this.jCOFINSAliq = new JanelaCOFINSAliq(JanelaConfigurarProduto.this);
/* 803 */           JanelaConfigurarProduto.this.jCOFINSAliq.setVisible(true);
/* 804 */           JanelaConfigurarProduto.this.jCOFINSQtde = null;
/* 805 */           JanelaConfigurarProduto.this.jCOFINSNT = null;
/*     */         }
/* 807 */         else if (index == 1)
/*     */         {
/* 809 */           JanelaConfigurarProduto.this.jCOFINSQtde = new JanelaCOFINSQtde(JanelaConfigurarProduto.this);
/* 810 */           JanelaConfigurarProduto.this.jCOFINSQtde.setVisible(true);
/* 811 */           JanelaConfigurarProduto.this.jCOFINSAliq = null;
/* 812 */           JanelaConfigurarProduto.this.jCOFINSNT = null;
/*     */         }
/* 814 */         else if (index == 2)
/*     */         {
/* 816 */           JanelaConfigurarProduto.this.jCOFINSNT = new JanelaCOFINSNT(JanelaConfigurarProduto.this);
/* 817 */           JanelaConfigurarProduto.this.jCOFINSNT.setVisible(true);
/* 818 */           JanelaConfigurarProduto.this.jCOFINSAliq = null;
/* 819 */           JanelaConfigurarProduto.this.jCOFINSQtde = null;
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private JComboBox getComboImposto()
/*     */   {
/* 832 */     if (this.comboICMS == null)
/*     */     {
/* 834 */       this.comboICMS = new JComboBox();
/* 835 */       this.comboICMS.setBounds(new Rectangle(13, 517, 258, 25));
/* 836 */       this.comboICMS.addItem("Tributada integralmente");
/* 837 */       this.comboICMS.addItem("Tributado com redução de base de cálculo");
/* 838 */       this.comboICMS.addItem("Isenta");
/* 839 */       this.comboICMS.addItem("Não tributada");
/* 840 */       this.comboICMS.addItem("Suspensão");
/* 841 */       this.comboICMS.addItem("Cobrado anteriormente por substituição tributária");
/* 842 */       this.comboICMS.addItem("Outros");
/* 843 */       this.comboICMS.addItem("Simples Nacional - Sem permissão de crédito");
/* 844 */       this.comboICMS.addItem("Simples Nacional - Imune");
/* 845 */       this.comboICMS.addItem("Simples Nacional - Cobrado anteriormente por substituição tributária ou por antecipação");
/* 846 */       this.comboICMS.addItem("Simples Nacional - Outros");
/* 847 */       this.comboICMS.setSelectedIndex(-1);
/*     */     }
/* 849 */     return this.comboICMS;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboPIS()
/*     */   {
/* 859 */     if (this.comboPIS == null)
/*     */     {
/* 861 */       this.comboPIS = new JComboBox();
/* 862 */       this.comboPIS.setBounds(new Rectangle(13, 569, 258, 25));
/* 863 */       this.comboPIS.addItem("Alíquota");
/* 864 */       this.comboPIS.addItem("Quantidade");
/* 865 */       this.comboPIS.addItem("Não tributado");
/* 866 */       this.comboPIS.addItem("Simples nacional");
/* 867 */       this.comboPIS.setSelectedIndex(-1);
/*     */     }
/* 869 */     return this.comboPIS;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboCOFINS()
/*     */   {
/* 879 */     if (this.comboCOFINS == null)
/*     */     {
/* 881 */       this.comboCOFINS = new JComboBox();
/* 882 */       this.comboCOFINS.setBounds(new Rectangle(13, 621, 258, 25));
/* 883 */       this.comboCOFINS.addItem("Alíquota");
/* 884 */       this.comboCOFINS.addItem("Quantidade");
/* 885 */       this.comboCOFINS.addItem("Não tributado");
/* 886 */       this.comboCOFINS.addItem("Simples nacional");
/* 887 */       this.comboCOFINS.setSelectedIndex(-1);
/*     */     }
/* 889 */     return this.comboCOFINS;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaConfigurarProduto
 * JD-Core Version:    0.6.2
 */