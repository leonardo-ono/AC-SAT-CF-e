/*      */ package br.com.pirus.ac.interfaces;
/*      */ 
/*      */ import br.com.pirus.ac.controles.ControleAC;
/*      */ import br.com.pirus.ac.controles.ControleFecharVenda;
/*      */ import br.com.pirus.ac.controles.ControleInserir;
/*      */ import br.com.pirus.ac.modelos.DBOperador;
/*      */ import br.com.pirus.ac.modelos.Operador;
/*      */ import br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe;
/*      */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoCFe;
/*      */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe;
/*      */ import br.com.pirus.ac.modelos.cfeac.InformacoesCFe;
/*      */ import br.com.pirus.ac.modelos.cfeac.ProdutoCFe;
/*      */ import br.com.pirus.ac.utils.Utils;
/*      */ import java.awt.Color;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.FocusListener;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.KeyListener;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.BoxLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.table.TableColumnModel;
/*      */ 
/*      */ public class JanelaAC extends JFrame
/*      */   implements ControleACListener
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   50 */   private JPanel jContentPane = null;
/*      */ 
/*   52 */   private JMenuBar menuPrincipal = null;
/*      */ 
/*   54 */   private JMenu jMenuConfiguracoes = null;
/*      */ 
/*   56 */   private JMenu jMenuCadastrar = null;
/*      */ 
/*   58 */   private JMenu jMenuDesligar = null;
/*      */ 
/*   60 */   private JMenuItem itemConfigurarAplicativo = null;
/*      */ 
/*   62 */   private JMenuItem itemConfigurarOperador = null;
/*      */ 
/*   64 */   private JMenuItem itemConfigurarContribuinte = null;
/*      */ 
/*   66 */   private JMenuItem itemCadastrarProduto = null;
/*      */ 
/*   68 */   private JMenuItem itemCadastrarOperador = null;
/*      */ 
/*   70 */   private JMenuItem itemDesligarSAT = null;
/*      */ 
/*   72 */   private JLabel logoSefaz = null;
/*      */ 
/*   74 */   private JLabel labelContribuinte = null;
/*      */ 
/*   76 */   private JLabel labelOperador = null;
/*      */ 
/*   78 */   private JLabel labelNumeroVenda = null;
/*      */ 
/*   80 */   private JPanel painelItens = null;
/*      */ 
/*   82 */   private JTable tabelaItens = null;
/*      */ 
/*   84 */   private String[][] dados = new String[0][];
/*      */ 
/*   86 */   private String[] colunas = { "Item", "Referência", "Descrição", "Valor Un", "Qtde", "Unidade", "Total" };
/*      */ 
/*   88 */   private DefaultTableModel modeloItens = new DefaultTableModel(this.dados, this.colunas);
/*      */ 
/*   90 */   private JScrollPane scrollTabela = null;
/*      */ 
/*   92 */   private JLabel labelCNPJ = null;
/*      */ 
/*   94 */   private JLabel labelConsumidor = null;
/*      */ 
/*   96 */   private JTextField idConsumidor = null;
/*      */ 
/*   98 */   private JLabel dadosContribuinte = null;
/*      */ 
/*  100 */   private JLabel dadosOperador = null;
/*      */ 
/*  102 */   public JLabel dadosVenda = null;
/*      */ 
/*  104 */   private JLabel dadosCNPJ = null;
/*      */ 
/*  106 */   private JPanel painelAdicionar = null;
/*      */ 
/*  108 */   private JLabel labelReferencia = null;
/*      */ 
/*  110 */   private JLabel labelQuantidade = null;
/*      */ 
/*  112 */   private JTextField valorQuantidade = null;
/*      */ 
/*  114 */   private JTextField valorReferencia = null;
/*      */ 
/*  116 */   private JLabel labelUnitario = null;
/*      */ 
/*  118 */   private JTextField valorValorUnitario = null;
/*      */ 
/*  120 */   private JPanel painelPagamento = null;
/*      */ 
/*  122 */   private JLabel labelValorTotal = null;
/*      */ 
/*  124 */   private JTextField valorValorTotal = null;
/*      */ 
/*  126 */   private JLabel labelValorPago = null;
/*      */ 
/*  128 */   private JTextField valorValorPago = null;
/*      */ 
/*  130 */   private JLabel labelTroco = null;
/*      */ 
/*  132 */   private JTextField valorTroco = null;
/*      */ 
/*  134 */   private JLabel labelTotal = null;
/*      */ 
/*  136 */   private JTextField valorQuantidadeItensTotal = null;
/*      */ 
/*  138 */   private JButton botaoFecharVenda = null;
/*      */ 
/*  140 */   private JTextField labelAlerta = null;
/*      */ 
/*  142 */   private JLabel labelAlertas = null;
/*      */ 
/*  144 */   private JButton botaoCancelarCupom = null;
/*      */ 
/*  146 */   private JButton botaoConsultarVenda = null;
/*      */ 
/*  148 */   private JButton botaoInserir = null;
/*      */ 
/*  150 */   private ControleInserir cInserir = null;
/*      */ 
/*  152 */   private ControleFecharVenda cFecharVenda = null;
/*      */ 
/*  154 */   private IdentificacaoCFe baseIDE = null;
/*      */ 
/*  156 */   private IdentificacaoEmitenteCFe baseEMIT = null;
/*      */ 
/*  158 */   private InformacoesCFe basePROD = null;
/*      */   private DBOperador baseOperador;
/*      */   private String unidade;
/*      */   private String descricao;
/*      */   public ControleAC cAC;
/*  168 */   private JMenuItem itemConfigurarProdutos = null;
/*      */ 
/*  170 */   private JLabel labelNome = null;
/*      */ 
/*  172 */   private JTextField dadosNome = null;
/*      */ 
/*      */   public JanelaAC()
/*      */   {
/*  180 */     initialize();
/*      */   }
/*      */ 
/*      */   public JanelaAC(IdentificacaoCFe baseIDE, IdentificacaoEmitenteCFe baseEMIT, InformacoesCFe basePROD, DBOperador baseOperador, ControleAC cAC)
/*      */   {
/*  185 */     this();
/*  186 */     this.baseIDE = baseIDE;
/*  187 */     this.baseEMIT = baseEMIT;
/*  188 */     this.basePROD = basePROD;
/*  189 */     this.baseOperador = baseOperador;
/*  190 */     this.cAC = cAC;
/*  191 */     this.cInserir = new ControleInserir(this);
/*  192 */     this.cFecharVenda = new ControleFecharVenda(this, basePROD, baseEMIT, baseIDE);
/*  193 */     this.botaoInserir.addActionListener(this.cInserir);
/*  194 */     this.botaoFecharVenda.addActionListener(this.cFecharVenda);
/*  195 */     this.dadosContribuinte.setText(baseEMIT.getxFant());
/*  196 */     this.dadosCNPJ.setText(baseEMIT.getCNPJ());
/*  197 */     this.dadosOperador.setText(baseOperador.getOperadorAtual().getNome());
/*  198 */     this.dadosVenda.setText(Utils.getNumVenda());
/*      */   }
/*      */ 
/*      */   private void initialize()
/*      */   {
/*      */     try
/*      */     {
/*  210 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  214 */       e.printStackTrace();
/*      */     }
/*  216 */     setDefaultCloseOperation(3);
/*  217 */     setSize(700, 592);
/*  218 */     setResizable(false);
/*  219 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  220 */     setTitle("PAF v2.0");
/*  221 */     setJMenuBar(getMenuPrincipal());
/*  222 */     setContentPane(getJContentPane());
/*  223 */     setTitle("Aplicativo Comercial v2.0");
/*      */   }
/*      */ 
/*      */   private JPanel getJContentPane()
/*      */   {
/*  233 */     if (this.jContentPane == null)
/*      */     {
/*  235 */       this.labelNome = new JLabel();
/*  236 */       this.labelNome.setBounds(new Rectangle(437, 52, 108, 16));
/*  237 */       this.labelNome.setFont(new Font("Dialog", 1, 12));
/*  238 */       this.labelNome.setText("Nome consumidor");
/*  239 */       this.labelAlertas = new JLabel();
/*  240 */       this.labelAlertas.setBounds(new Rectangle(13, 481, 49, 16));
/*  241 */       this.labelAlertas.setFont(new Font("Dialog", 1, 12));
/*  242 */       this.labelAlertas.setText("Alertas:");
/*  243 */       this.dadosCNPJ = new JLabel();
/*  244 */       this.dadosCNPJ.setBounds(new Rectangle(230, 52, 200, 16));
/*  245 */       this.dadosCNPJ.setText("");
/*  246 */       this.dadosCNPJ.setBackground(new Color(238, 238, 238));
/*  247 */       this.dadosCNPJ.setForeground(Color.lightGray);
/*  248 */       this.dadosCNPJ.setFont(new Font("Dialog", 1, 12));
/*  249 */       this.dadosVenda = new JLabel();
/*  250 */       this.dadosVenda.setBounds(new Rectangle(605, 33, 69, 16));
/*  251 */       this.dadosVenda.setText("");
/*  252 */       this.dadosVenda.setBackground(new Color(238, 238, 238));
/*  253 */       this.dadosVenda.setForeground(Color.lightGray);
/*  254 */       this.dadosVenda.setFont(new Font("Dialog", 1, 12));
/*  255 */       this.dadosVenda.setHorizontalAlignment(4);
/*  256 */       this.dadosVenda.setText(Utils.getNumVenda());
/*  257 */       this.dadosOperador = new JLabel();
/*  258 */       this.dadosOperador.setBounds(new Rectangle(230, 33, 200, 16));
/*  259 */       this.dadosOperador.setText("");
/*  260 */       this.dadosOperador.setBackground(new Color(238, 238, 238));
/*  261 */       this.dadosOperador.setForeground(Color.lightGray);
/*  262 */       this.dadosOperador.setFont(new Font("Dialog", 1, 12));
/*  263 */       this.dadosContribuinte = new JLabel();
/*  264 */       this.dadosContribuinte.setBounds(new Rectangle(230, 14, 200, 16));
/*  265 */       this.dadosContribuinte.setText("");
/*  266 */       this.dadosContribuinte.setBackground(new Color(238, 238, 238));
/*  267 */       this.dadosContribuinte.setForeground(Color.lightGray);
/*  268 */       this.dadosContribuinte.setFont(new Font("Dialog", 1, 12));
/*  269 */       this.labelConsumidor = new JLabel();
/*  270 */       this.labelConsumidor.setBounds(new Rectangle(437, 14, 160, 16));
/*  271 */       this.labelConsumidor.setFont(new Font("Dialog", 1, 12));
/*  272 */       this.labelConsumidor.setText("CNPJ / CPF do consumidor:");
/*  273 */       this.labelCNPJ = new JLabel();
/*  274 */       this.labelCNPJ.setBounds(new Rectangle(139, 53, 38, 16));
/*  275 */       this.labelCNPJ.setFont(new Font("Dialog", 1, 12));
/*  276 */       this.labelCNPJ.setText("CNPJ:");
/*  277 */       this.labelNumeroVenda = new JLabel();
/*  278 */       this.labelNumeroVenda.setBounds(new Rectangle(605, 14, 79, 16));
/*  279 */       this.labelNumeroVenda.setFont(new Font("Dialog", 1, 12));
/*  280 */       this.labelNumeroVenda.setText("Nº da venda:");
/*  281 */       this.labelOperador = new JLabel();
/*  282 */       this.labelOperador.setBounds(new Rectangle(139, 33, 79, 16));
/*  283 */       this.labelOperador.setFont(new Font("Dialog", 1, 12));
/*  284 */       this.labelOperador.setText("Operador:");
/*  285 */       this.labelContribuinte = new JLabel();
/*  286 */       this.labelContribuinte.setBounds(new Rectangle(139, 14, 79, 16));
/*  287 */       this.labelContribuinte.setFont(new Font("Dialog", 1, 12));
/*  288 */       this.labelContribuinte.setText("Contribuinte:");
/*  289 */       this.logoSefaz = new JLabel();
/*  290 */       this.logoSefaz.setText("JLabel");
/*  291 */       this.logoSefaz.setBounds(new Rectangle(8, 5, 114, 80));
/*  292 */       this.logoSefaz.setIcon(new ImageIcon(getClass().getResource("/images/nota_imagem.PNG")));
/*  293 */       this.jContentPane = new JPanel();
/*  294 */       this.jContentPane.setLayout(null);
/*  295 */       this.jContentPane.setBackground(Color.white);
/*  296 */       this.jContentPane.add(this.logoSefaz, null);
/*  297 */       this.jContentPane.add(this.labelContribuinte, null);
/*  298 */       this.jContentPane.add(this.labelOperador, null);
/*  299 */       this.jContentPane.add(this.labelNumeroVenda, null);
/*  300 */       this.jContentPane.add(getPainelItens(), null);
/*  301 */       this.jContentPane.add(this.labelCNPJ, null);
/*  302 */       this.jContentPane.add(this.labelConsumidor, null);
/*  303 */       this.jContentPane.add(getIdConsumidor(), null);
/*  304 */       this.jContentPane.add(this.dadosContribuinte, null);
/*  305 */       this.jContentPane.add(this.dadosOperador, null);
/*  306 */       this.jContentPane.add(this.dadosVenda, null);
/*  307 */       this.jContentPane.add(this.dadosCNPJ, null);
/*  308 */       this.jContentPane.add(getPainelAdicionar(), null);
/*  309 */       this.jContentPane.add(getPainelPagamento(), null);
/*  310 */       this.jContentPane.add(getBotaoFecharVenda(), null);
/*  311 */       this.jContentPane.add(getLabelAlerta(), null);
/*  312 */       this.jContentPane.add(this.labelAlertas, null);
/*  313 */       this.jContentPane.add(getBotaoCancelarCupom(), null);
/*  314 */       this.jContentPane.add(getBotaoConsultarVenda(), null);
/*  315 */       this.jContentPane.add(getBotaoInserir(), null);
/*  316 */       this.jContentPane.add(this.labelNome, null);
/*  317 */       this.jContentPane.add(getDadosNome(), null);
/*      */     }
/*  319 */     return this.jContentPane;
/*      */   }
/*      */ 
/*      */   private JMenuBar getMenuPrincipal()
/*      */   {
/*  329 */     if (this.menuPrincipal == null)
/*      */     {
/*  331 */       this.menuPrincipal = new JMenuBar();
/*  332 */       this.menuPrincipal.add(getJMenuConfigurar());
/*  333 */       this.menuPrincipal.add(getJMenuCadastrar());
/*      */     }
/*      */ 
/*  336 */     return this.menuPrincipal;
/*      */   }
/*      */ 
/*      */   private JMenu getJMenuDesligar()
/*      */   {
/*  341 */     if (this.jMenuDesligar == null)
/*      */     {
/*  343 */       this.jMenuDesligar = new JMenu();
/*  344 */       this.jMenuDesligar.setText("Desligar SAT");
/*  345 */       this.jMenuDesligar.add(getDesligarSAT());
/*      */     }
/*  347 */     return this.jMenuDesligar;
/*      */   }
/*      */ 
/*      */   private JMenu getJMenuConfigurar()
/*      */   {
/*  357 */     if (this.jMenuConfiguracoes == null)
/*      */     {
/*  359 */       this.jMenuConfiguracoes = new JMenu();
/*  360 */       this.jMenuConfiguracoes.setText("Configurar");
/*  361 */       this.jMenuConfiguracoes.add(getItemConfigurarAssinatura());
/*  362 */       this.jMenuConfiguracoes.add(getItemConfigurarContribuinte());
/*  363 */       this.jMenuConfiguracoes.add(getItemConfigurarOperador());
/*  364 */       this.jMenuConfiguracoes.add(getItemConfigurarProdutos());
/*      */     }
/*  366 */     return this.jMenuConfiguracoes;
/*      */   }
/*      */ 
/*      */   private JMenu getJMenuCadastrar()
/*      */   {
/*  376 */     if (this.jMenuCadastrar == null)
/*      */     {
/*  378 */       this.jMenuCadastrar = new JMenu();
/*  379 */       this.jMenuCadastrar.setText("Cadastrar");
/*  380 */       this.jMenuCadastrar.add(getItemCadastrarOperador());
/*  381 */       this.jMenuCadastrar.add(getItemCadastrarProduto());
/*      */     }
/*  383 */     return this.jMenuCadastrar;
/*      */   }
/*      */ 
/*      */   private JMenuItem getItemConfigurarAssinatura()
/*      */   {
/*  388 */     if (this.itemConfigurarAplicativo == null)
/*      */     {
/*  390 */       this.itemConfigurarAplicativo = new JMenuItem();
/*  391 */       this.itemConfigurarAplicativo.setText("Aplivativo");
/*  392 */       this.itemConfigurarAplicativo.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  396 */           JanelaConfigurarAC jCAC = new JanelaConfigurarAC(JanelaAC.this, JanelaAC.this.baseIDE);
/*  397 */           jCAC.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  401 */     return this.itemConfigurarAplicativo;
/*      */   }
/*      */ 
/*      */   private JMenuItem getItemConfigurarContribuinte()
/*      */   {
/*  406 */     if (this.itemConfigurarContribuinte == null)
/*      */     {
/*  408 */       this.itemConfigurarContribuinte = new JMenuItem();
/*  409 */       this.itemConfigurarContribuinte.setText("Contribuinte");
/*  410 */       this.itemConfigurarContribuinte.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  414 */           JanelaConfigurarContribuinte jCContribuinte = new JanelaConfigurarContribuinte(JanelaAC.this, JanelaAC.this.baseEMIT);
/*  415 */           jCContribuinte.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  419 */     return this.itemConfigurarContribuinte;
/*      */   }
/*      */ 
/*      */   private JMenuItem getItemConfigurarOperador()
/*      */   {
/*  424 */     if (this.itemConfigurarOperador == null)
/*      */     {
/*  426 */       this.itemConfigurarOperador = new JMenuItem();
/*  427 */       this.itemConfigurarOperador.setText("Operador");
/*  428 */       this.itemConfigurarOperador.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  432 */           JanelaConfigurarOperador jCOperador = new JanelaConfigurarOperador(JanelaAC.this, JanelaAC.this.baseOperador);
/*  433 */           jCOperador.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  437 */     return this.itemConfigurarOperador;
/*      */   }
/*      */ 
/*      */   private JMenuItem getItemCadastrarProduto()
/*      */   {
/*  442 */     if (this.itemCadastrarProduto == null)
/*      */     {
/*  444 */       this.itemCadastrarProduto = new JMenuItem();
/*  445 */       this.itemCadastrarProduto.setText("Produto");
/*  446 */       this.itemCadastrarProduto.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  450 */           JanelaCadastrarProduto jCadProduto = new JanelaCadastrarProduto(JanelaAC.this, JanelaAC.this.basePROD);
/*  451 */           jCadProduto.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  455 */     return this.itemCadastrarProduto;
/*      */   }
/*      */ 
/*      */   private JMenuItem getItemCadastrarOperador()
/*      */   {
/*  460 */     if (this.itemCadastrarOperador == null)
/*      */     {
/*  462 */       this.itemCadastrarOperador = new JMenuItem();
/*  463 */       this.itemCadastrarOperador.setText("Operador");
/*  464 */       this.itemCadastrarOperador.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  468 */           JanelaCadastrarOperador jCadOperador = new JanelaCadastrarOperador(JanelaAC.this, JanelaAC.this.baseOperador);
/*  469 */           jCadOperador.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  473 */     return this.itemCadastrarOperador;
/*      */   }
/*      */ 
/*      */   private JPanel getPainelItens()
/*      */   {
/*  483 */     if (this.painelItens == null)
/*      */     {
/*  485 */       this.painelItens = new JPanel();
/*  486 */       this.painelItens.setLayout(null);
/*  487 */       this.painelItens.setBounds(new Rectangle(13, 114, 480, 325));
/*  488 */       this.painelItens.setBorder(BorderFactory.createBevelBorder(1));
/*  489 */       this.painelItens.add(getScrollTabela(), null);
/*      */     }
/*  491 */     return this.painelItens;
/*      */   }
/*      */ 
/*      */   public JTable getTabelaItens()
/*      */   {
/*  501 */     if (this.tabelaItens == null)
/*      */     {
/*  503 */       this.tabelaItens = new JTable(this.modeloItens);
/*  504 */       this.tabelaItens.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  505 */       this.tabelaItens.getColumnModel().getColumn(1).setPreferredWidth(120);
/*  506 */       this.tabelaItens.getColumnModel().getColumn(2).setPreferredWidth(250);
/*  507 */       this.tabelaItens.setBackground(new Color(238, 238, 238));
/*  508 */       this.tabelaItens.setEnabled(false);
/*      */     }
/*  510 */     return this.tabelaItens;
/*      */   }
/*      */ 
/*      */   public void adicionaLinha(String item, String referencia, String descricao, String valor, String qtde, String un, String total)
/*      */   {
/*  515 */     this.modeloItens.addRow(new String[] { item, referencia, descricao, valor, qtde, un, total });
/*      */   }
/*      */ 
/*      */   public void removeLinha(int linha)
/*      */   {
/*  520 */     this.modeloItens.removeRow(linha);
/*      */   }
/*      */ 
/*      */   public void getQuantidadeDeLinhas()
/*      */   {
/*  525 */     this.modeloItens.getRowCount();
/*      */   }
/*      */ 
/*      */   public void removeLinha()
/*      */   {
/*  534 */     int linhaSelecionada = this.tabelaItens.getSelectedRow();
/*  535 */     if (linhaSelecionada < 0)
/*      */     {
/*  537 */       return;
/*      */     }
/*      */ 
/*  541 */     removeLinha(linhaSelecionada);
/*      */   }
/*      */ 
/*      */   private JScrollPane getScrollTabela()
/*      */   {
/*  552 */     if (this.scrollTabela == null)
/*      */     {
/*  554 */       this.scrollTabela = new JScrollPane();
/*  555 */       this.scrollTabela.setBounds(new Rectangle(2, 2, 476, 321));
/*  556 */       this.scrollTabela.setViewportView(getTabelaItens());
/*      */     }
/*  558 */     return this.scrollTabela;
/*      */   }
/*      */ 
/*      */   public JTextField getIdConsumidor()
/*      */   {
/*  568 */     if (this.idConsumidor == null)
/*      */     {
/*  570 */       this.idConsumidor = new JTextField();
/*  571 */       this.idConsumidor.addKeyListener(new KeyListener()
/*      */       {
/*      */         public void keyTyped(KeyEvent e)
/*      */         {
/*  575 */           Long.parseLong(JanelaAC.this.idConsumidor.getText() + e.getKeyChar());
/*      */         }
/*      */ 
/*      */         public void keyReleased(KeyEvent e)
/*      */         {
/*      */         }
/*      */ 
/*      */         public void keyPressed(KeyEvent e)
/*      */         {
/*      */         }
/*      */       });
/*  586 */       this.idConsumidor.setBounds(new Rectangle(437, 33, 160, 16));
/*  587 */       this.idConsumidor.setBackground(Color.white);
/*  588 */       this.idConsumidor.setEnabled(true);
/*      */     }
/*  590 */     return this.idConsumidor;
/*      */   }
/*      */ 
/*      */   private JPanel getPainelAdicionar()
/*      */   {
/*  600 */     if (this.painelAdicionar == null)
/*      */     {
/*  602 */       this.labelUnitario = new JLabel();
/*  603 */       this.labelUnitario.setFont(new Font("Dialog", 1, 12));
/*  604 */       this.labelUnitario.setText("Valor unitário:");
/*  605 */       this.labelQuantidade = new JLabel();
/*  606 */       this.labelQuantidade.setText("Quantidade:");
/*  607 */       this.labelQuantidade.setFont(new Font("Dialog", 1, 12));
/*  608 */       this.labelReferencia = new JLabel();
/*  609 */       this.labelReferencia.setFont(new Font("Dialog", 1, 12));
/*  610 */       this.labelReferencia.setText("Referência:");
/*  611 */       this.painelAdicionar = new JPanel();
/*  612 */       this.painelAdicionar.setLayout(new BoxLayout(getPainelAdicionar(), 1));
/*  613 */       this.painelAdicionar.setBounds(new Rectangle(511, 114, 165, 111));
/*  614 */       this.painelAdicionar.setBorder(BorderFactory.createBevelBorder(1));
/*  615 */       this.painelAdicionar.add(this.labelReferencia, null);
/*  616 */       this.painelAdicionar.add(getValorReferencia(), null);
/*  617 */       this.painelAdicionar.add(this.labelQuantidade, null);
/*  618 */       this.painelAdicionar.add(getValorQuantidade(), null);
/*  619 */       this.painelAdicionar.add(this.labelUnitario, null);
/*  620 */       this.painelAdicionar.add(getValorValorUnitario(), null);
/*      */     }
/*  622 */     return this.painelAdicionar;
/*      */   }
/*      */ 
/*      */   public JTextField getValorQuantidade()
/*      */   {
/*  632 */     if (this.valorQuantidade == null)
/*      */     {
/*  634 */       this.valorQuantidade = new JTextField();
/*  635 */       this.valorQuantidade.addKeyListener(new KeyListener()
/*      */       {
/*      */         public void keyTyped(KeyEvent e)
/*      */         {
/*  639 */           Double.parseDouble(JanelaAC.this.valorQuantidade.getText() + e.getKeyChar());
/*      */         }
/*      */ 
/*      */         public void keyReleased(KeyEvent e)
/*      */         {
/*      */         }
/*      */ 
/*      */         public void keyPressed(KeyEvent e)
/*      */         {
/*      */         }
/*      */       });
/*      */     }
/*  651 */     return this.valorQuantidade;
/*      */   }
/*      */ 
/*      */   public String getReferencia()
/*      */   {
/*  656 */     return this.valorReferencia.getText();
/*      */   }
/*      */ 
/*      */   public int getQuantidadeLinhasTabela()
/*      */   {
/*  661 */     return this.tabelaItens.getRowCount();
/*      */   }
/*      */ 
/*      */   public String getQuantidade()
/*      */   {
/*  666 */     return this.valorQuantidade.getText();
/*      */   }
/*      */ 
/*      */   public String getValorUnitario()
/*      */   {
/*  671 */     return this.valorValorUnitario.getText();
/*      */   }
/*      */ 
/*      */   public String getUnidade()
/*      */   {
/*  676 */     return this.unidade;
/*      */   }
/*      */ 
/*      */   public String getTotal()
/*      */   {
/*  681 */     BigDecimal total = new BigDecimal("0.0");
/*  682 */     total = total.add(new BigDecimal(getValorUnitario()));
/*  683 */     total = total.multiply(new BigDecimal(getQuantidade()));
/*  684 */     return total.toPlainString();
/*      */   }
/*      */ 
/*      */   public String getDescricao()
/*      */   {
/*  689 */     return this.descricao;
/*      */   }
/*      */ 
/*      */   public JTextField getValorReferencia()
/*      */   {
/*  699 */     if (this.valorReferencia == null)
/*      */     {
/*  701 */       this.valorReferencia = new JTextField();
/*  702 */       this.valorReferencia.addKeyListener(new KeyListener()
/*      */       {
/*      */         public void keyTyped(KeyEvent e)
/*      */         {
/*  706 */           Integer.parseInt(JanelaAC.this.valorReferencia.getText() + e.getKeyChar());
/*      */         }
/*      */ 
/*      */         public void keyReleased(KeyEvent e)
/*      */         {
/*      */         }
/*      */ 
/*      */         public void keyPressed(KeyEvent e)
/*      */         {
/*      */         }
/*      */       });
/*  717 */       this.valorReferencia.addFocusListener(new FocusListener()
/*      */       {
/*      */         public void focusLost(FocusEvent e)
/*      */         {
/*  721 */           ProdutoCFe prod = null;
/*  722 */           if ((JanelaAC.this.valorReferencia.getText() != null) && (JanelaAC.this.valorReferencia.getText().length() > 0))
/*      */           {
/*  724 */             ArrayList<DetalhamentoProdutosCFe> array = JanelaAC.this.basePROD.getDet();
/*  725 */             for (DetalhamentoProdutosCFe d : array)
/*      */             {
/*  727 */               if (d.getProd().getcProd().equals(JanelaAC.this.valorReferencia.getText()))
/*      */               {
/*  729 */                 prod = d.getProd();
/*  730 */                 break;
/*      */               }
/*      */             }
/*  733 */             if (prod != null)
/*      */             {
/*  735 */               JanelaAC.this.valorQuantidade.setText(prod.getqCom());
/*  736 */               JanelaAC.this.valorValorUnitario.setText(prod.getvUnCom());
/*  737 */               JanelaAC.this.descricao = prod.getxProd();
/*  738 */               JanelaAC.this.unidade = prod.getuCom();
/*  739 */               JanelaAC.this.labelAlerta.setText("");
/*  740 */               JanelaAC.this.valorQuantidade.requestFocus();
/*      */             }
/*      */             else
/*      */             {
/*  744 */               JanelaAC.this.labelAlerta.setText("Código do produto " + JanelaAC.this.valorReferencia.getText() + " não encontrado!");
/*  745 */               JanelaAC.this.valorQuantidade.setText("");
/*  746 */               JanelaAC.this.valorValorUnitario.setText("");
/*  747 */               JanelaAC.this.valorReferencia.requestFocus();
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */         public void focusGained(FocusEvent e)
/*      */         {
/*      */         }
/*      */       });
/*      */     }
/*  757 */     return this.valorReferencia;
/*      */   }
/*      */ 
/*      */   public JTextField getValorValorUnitario()
/*      */   {
/*  767 */     if (this.valorValorUnitario == null)
/*      */     {
/*  769 */       this.valorValorUnitario = new JTextField();
/*  770 */       this.valorValorUnitario.setEnabled(true);
/*  771 */       this.valorValorUnitario.setEditable(false);
/*  772 */       this.valorValorUnitario.setBackground(new Color(238, 238, 238));
/*      */     }
/*  774 */     return this.valorValorUnitario;
/*      */   }
/*      */ 
/*      */   private JPanel getPainelPagamento()
/*      */   {
/*  784 */     if (this.painelPagamento == null)
/*      */     {
/*  786 */       this.labelTroco = new JLabel();
/*  787 */       this.labelTroco.setFont(new Font("Dialog", 1, 12));
/*  788 */       this.labelTroco.setText("Troco:");
/*  789 */       this.labelValorPago = new JLabel();
/*  790 */       this.labelValorPago.setFont(new Font("Dialog", 1, 12));
/*  791 */       this.labelValorPago.setText("Valor pago:");
/*  792 */       this.labelValorTotal = new JLabel();
/*  793 */       this.labelValorTotal.setFont(new Font("Dialog", 1, 12));
/*  794 */       this.labelValorTotal.setText("Valor total:");
/*  795 */       this.labelTotal = new JLabel();
/*  796 */       this.labelTotal.setFont(new Font("Dialog", 1, 12));
/*  797 */       this.labelTotal.setText("Quantidade de itens:");
/*  798 */       this.painelPagamento = new JPanel();
/*  799 */       this.painelPagamento.setLayout(new BoxLayout(getPainelPagamento(), 1));
/*  800 */       this.painelPagamento.setBounds(new Rectangle(511, 286, 165, 152));
/*  801 */       this.painelPagamento.setBorder(BorderFactory.createBevelBorder(1));
/*  802 */       this.painelPagamento.add(this.labelTotal, null);
/*  803 */       this.painelPagamento.add(getValorQuantidadeItensTotal(), null);
/*  804 */       this.painelPagamento.add(this.labelValorTotal, null);
/*  805 */       this.painelPagamento.add(getValorValorTotal(), null);
/*  806 */       this.painelPagamento.add(this.labelValorPago, null);
/*  807 */       this.painelPagamento.add(getValorValorPago(), null);
/*  808 */       this.painelPagamento.add(this.labelTroco, null);
/*  809 */       this.painelPagamento.add(getValorTroco(), null);
/*      */     }
/*  811 */     return this.painelPagamento;
/*      */   }
/*      */ 
/*      */   public JTextField getValorValorTotal()
/*      */   {
/*  821 */     if (this.valorValorTotal == null)
/*      */     {
/*  823 */       this.valorValorTotal = new JTextField();
/*  824 */       this.valorValorTotal.setBackground(new Color(238, 238, 238));
/*  825 */       this.valorValorTotal.setEditable(false);
/*      */     }
/*  827 */     return this.valorValorTotal;
/*      */   }
/*      */ 
/*      */   public JTextField getValorValorPago()
/*      */   {
/*  837 */     if (this.valorValorPago == null)
/*      */     {
/*  839 */       this.valorValorPago = new JTextField();
/*  840 */       this.valorValorPago.setBackground(Color.white);
/*  841 */       this.valorValorPago.setEditable(true);
/*  842 */       this.valorValorPago.addKeyListener(new KeyListener()
/*      */       {
/*      */         public void keyTyped(KeyEvent e)
/*      */         {
/*  846 */           Double.parseDouble(JanelaAC.this.valorValorPago.getText() + e.getKeyChar());
/*      */         }
/*      */ 
/*      */         public void keyReleased(KeyEvent e)
/*      */         {
/*  851 */           if ((JanelaAC.this.getValorValorPago().getText().length() > 0) && (JanelaAC.this.getValorValorTotal().getText().length() > 0))
/*      */           {
/*  853 */             BigDecimal troco = new BigDecimal("0.0");
/*  854 */             troco = troco.add(new BigDecimal(JanelaAC.this.getValorValorPago().getText()));
/*  855 */             troco = troco.subtract(new BigDecimal(JanelaAC.this.getValorValorTotal().getText()));
/*  856 */             JanelaAC.this.getValorTroco().setText(troco.toPlainString());
/*  857 */             if (troco.doubleValue() < 0.0D)
/*  858 */               JanelaAC.this.getLabelAlerta().setText("Valor pago menor que o valor total!");
/*      */             else
/*  860 */               JanelaAC.this.getLabelAlerta().setText("");
/*      */           }
/*      */         }
/*      */ 
/*      */         public void keyPressed(KeyEvent e)
/*      */         {
/*      */         }
/*      */       });
/*      */     }
/*  869 */     return this.valorValorPago;
/*      */   }
/*      */ 
/*      */   public JTextField getValorTroco()
/*      */   {
/*  879 */     if (this.valorTroco == null)
/*      */     {
/*  881 */       this.valorTroco = new JTextField();
/*  882 */       this.valorTroco.setBackground(new Color(238, 238, 238));
/*  883 */       this.valorTroco.setEditable(false);
/*      */     }
/*  885 */     return this.valorTroco;
/*      */   }
/*      */ 
/*      */   public JTextField getValorQuantidadeItensTotal()
/*      */   {
/*  895 */     if (this.valorQuantidadeItensTotal == null)
/*      */     {
/*  897 */       this.valorQuantidadeItensTotal = new JTextField();
/*  898 */       this.valorQuantidadeItensTotal.setBackground(new Color(238, 238, 238));
/*  899 */       this.valorQuantidadeItensTotal.setEditable(false);
/*      */     }
/*  901 */     return this.valorQuantidadeItensTotal;
/*      */   }
/*      */ 
/*      */   public JButton getBotaoFecharVenda()
/*      */   {
/*  911 */     if (this.botaoFecharVenda == null)
/*      */     {
/*  913 */       this.botaoFecharVenda = new JButton();
/*  914 */       this.botaoFecharVenda.setBounds(new Rectangle(511, 446, 165, 29));
/*  915 */       this.botaoFecharVenda.setText("Fechar Venda");
/*      */     }
/*  917 */     return this.botaoFecharVenda;
/*      */   }
/*      */ 
/*      */   public JTextField getLabelAlerta()
/*      */   {
/*  927 */     if (this.labelAlerta == null)
/*      */     {
/*  929 */       this.labelAlerta = new JTextField();
/*  930 */       this.labelAlerta.setBounds(new Rectangle(13, 501, 662, 26));
/*  931 */       this.labelAlerta.setBackground(Color.lightGray);
/*  932 */       this.labelAlerta.setForeground(Color.red);
/*  933 */       this.labelAlerta.setText("");
/*  934 */       this.labelAlerta.setFont(new Font("Dialog", 0, 14));
/*  935 */       this.labelAlerta.setEditable(false);
/*      */     }
/*  937 */     return this.labelAlerta;
/*      */   }
/*      */ 
/*      */   public JButton getBotaoCancelarCupom()
/*      */   {
/*  947 */     if (this.botaoCancelarCupom == null)
/*      */     {
/*  949 */       this.botaoCancelarCupom = new JButton();
/*  950 */       this.botaoCancelarCupom.setBounds(new Rectangle(13, 446, 165, 29));
/*  951 */       this.botaoCancelarCupom.setText("Cancelar Venda");
/*  952 */       this.botaoCancelarCupom.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  956 */           JanelaCancelar jCancelar = new JanelaCancelar(JanelaAC.this.cAC, JanelaAC.this, JanelaAC.this.baseEMIT);
/*  957 */           jCancelar.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  961 */     return this.botaoCancelarCupom;
/*      */   }
/*      */ 
/*      */   public JButton getBotaoConsultarVenda()
/*      */   {
/*  971 */     if (this.botaoConsultarVenda == null)
/*      */     {
/*  973 */       this.botaoConsultarVenda = new JButton();
/*  974 */       this.botaoConsultarVenda.setBounds(new Rectangle(195, 446, 165, 29));
/*  975 */       this.botaoConsultarVenda.setText("Consultar Venda");
/*  976 */       this.botaoConsultarVenda.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  980 */           JanelaConsultar jConsultar = new JanelaConsultar(JanelaAC.this.cAC);
/*  981 */           jConsultar.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/*  985 */     return this.botaoConsultarVenda;
/*      */   }
/*      */ 
/*      */   public JButton getBotaoInserir()
/*      */   {
/*  995 */     if (this.botaoInserir == null)
/*      */     {
/*  997 */       this.botaoInserir = new JButton();
/*  998 */       this.botaoInserir.setBounds(new Rectangle(511, 241, 165, 29));
/*  999 */       this.botaoInserir.setText("Inserir Produto");
/*      */     }
/* 1001 */     return this.botaoInserir;
/*      */   }
/*      */ 
/*      */   public void atualizarTotal()
/*      */   {
/* 1006 */     int count = this.tabelaItens.getRowCount();
/* 1007 */     BigDecimal soma = new BigDecimal("0.0");
/* 1008 */     for (int i = 0; i < count; i++)
/*      */     {
/* 1010 */       soma = soma.add(new BigDecimal(String.valueOf(this.tabelaItens.getValueAt(i, 6))));
/*      */     }
/* 1012 */     this.valorValorTotal.setText("" + soma.doubleValue());
/*      */   }
/*      */ 
/*      */   public void atualizarTotalItens()
/*      */   {
/* 1017 */     this.valorQuantidadeItensTotal.setText("" + getQuantidadeLinhasTabela());
/*      */   }
/*      */ 
/*      */   public JLabel getDadosContribuinte()
/*      */   {
/* 1022 */     return this.dadosContribuinte;
/*      */   }
/*      */ 
/*      */   public JLabel getDadosCNPJ()
/*      */   {
/* 1027 */     return this.dadosCNPJ;
/*      */   }
/*      */ 
/*      */   public String getIE()
/*      */   {
/* 1032 */     return this.baseEMIT.getIE();
/*      */   }
/*      */ 
/*      */   public String getIM()
/*      */   {
/* 1037 */     return this.baseEMIT.getIM();
/*      */   }
/*      */ 
/*      */   public JLabel getDadosOperador()
/*      */   {
/* 1042 */     return this.dadosOperador;
/*      */   }
/*      */ 
/*      */   private JMenuItem getItemConfigurarProdutos()
/*      */   {
/* 1052 */     if (this.itemConfigurarProdutos == null)
/*      */     {
/* 1054 */       this.itemConfigurarProdutos = new JMenuItem();
/* 1055 */       this.itemConfigurarProdutos.setText("Produto");
/* 1056 */       this.itemConfigurarProdutos.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/* 1060 */           JanelaConfigurarProduto jCProduto = new JanelaConfigurarProduto(JanelaAC.this, JanelaAC.this.basePROD);
/* 1061 */           jCProduto.setVisible(true);
/*      */         }
/*      */       });
/*      */     }
/* 1065 */     return this.itemConfigurarProdutos;
/*      */   }
/*      */ 
/*      */   private JMenuItem getDesligarSAT()
/*      */   {
/* 1070 */     if (this.itemDesligarSAT == null)
/*      */     {
/* 1072 */       this.itemDesligarSAT = new JMenuItem();
/* 1073 */       this.itemDesligarSAT.setText("Desligar");
/* 1074 */       this.itemDesligarSAT.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/* 1078 */           if (JOptionPane.showConfirmDialog(null, "Deseja desligar o SAT-CFe ?", "Desligar o SAT-CFe", 2) == 0)
/*      */           {
/* 1080 */             ControleAC controleAC = new ControleAC();
/* 1081 */             controleAC.processarComandoDesligarSAT(JanelaAC.this);
/*      */           }
/*      */         }
/*      */       });
/*      */     }
/* 1086 */     return this.itemDesligarSAT;
/*      */   }
/*      */ 
/*      */   public JTextField getDadosNome()
/*      */   {
/* 1096 */     if (this.dadosNome == null)
/*      */     {
/* 1098 */       this.dadosNome = new JTextField();
/* 1099 */       this.dadosNome.setBounds(new Rectangle(437, 72, 160, 16));
/* 1100 */       this.dadosNome.setEnabled(true);
/* 1101 */       this.dadosNome.setBackground(Color.white);
/*      */     }
/* 1103 */     return this.dadosNome;
/*      */   }
/*      */ 
/*      */   public void tratarResultado(String retorno)
/*      */   {
/* 1112 */     if (retorno.indexOf("|") != -1)
/*      */     {
/* 1114 */       retorno = br.com.pirus.ac.controles.ControleDados.quebrarString(retorno, "|")[2];
/* 1115 */       JOptionPane.showMessageDialog(null, retorno);
/*      */     }
/* 1117 */     else if (retorno.length() > 0)
/*      */     {
/* 1119 */       JOptionPane.showMessageDialog(null, retorno);
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaAC
 * JD-Core Version:    0.6.2
 */