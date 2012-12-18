/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.modelos.DBOperador;
/*     */ import br.com.pirus.ac.modelos.Operador;
/*     */ import br.com.pirus.ac.modelos.Operadores;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class JanelaConfigurarOperador extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   private JPanel jContentPane = null;
/*     */ 
/*  24 */   private JButton botaoOK = null;
/*     */ 
/*  26 */   private JButton botaoCancelar = null;
/*     */ 
/*  28 */   private JLabel labelOperador = null;
/*     */ 
/*  30 */   private JComboBox comboOperador = null;
/*     */   private DBOperador dbOperador;
/*     */   private JanelaAC owner;
/*     */ 
/*     */   public JanelaConfigurarOperador(JanelaAC owner, DBOperador dbOperador)
/*     */   {
/*  41 */     super(owner);
/*  42 */     this.owner = owner;
/*  43 */     this.dbOperador = dbOperador;
/*  44 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  56 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  60 */       e.printStackTrace();
/*     */     }
/*  62 */     setSize(287, 140);
/*  63 */     setResizable(false);
/*  64 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  65 */     setTitle("Configurar operador");
/*  66 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  76 */     if (this.jContentPane == null)
/*     */     {
/*  78 */       this.labelOperador = new JLabel();
/*  79 */       this.labelOperador.setBounds(new Rectangle(13, 20, 63, 16));
/*  80 */       this.labelOperador.setText("Operador");
/*  81 */       this.jContentPane = new JPanel();
/*  82 */       this.jContentPane.setLayout(null);
/*  83 */       this.jContentPane.add(getBotaoOK(), null);
/*  84 */       this.jContentPane.add(getBotaoCancelar(), null);
/*  85 */       this.jContentPane.add(this.labelOperador, null);
/*  86 */       this.jContentPane.add(getComboOperador(), null);
/*     */     }
/*  88 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/*  98 */     if (this.botaoOK == null)
/*     */     {
/* 100 */       this.botaoOK = new JButton();
/* 101 */       this.botaoOK.setBounds(new Rectangle(13, 76, 100, 26));
/* 102 */       this.botaoOK.setText("OK");
/* 103 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 107 */           JanelaConfigurarOperador.this.owner.getDadosOperador().setText(JanelaConfigurarOperador.this.comboOperador.getSelectedItem().toString());
/* 108 */           JanelaConfigurarOperador.this.dbOperador.setOperadorAtual((Operador)JanelaConfigurarOperador.this.comboOperador.getSelectedItem());
/* 109 */           ControleArquivos.escreverCaracteresArquivo("DB_OPERADOR.xml", JanelaConfigurarOperador.this.dbOperador.toString().toCharArray());
/* 110 */           JanelaConfigurarOperador.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 114 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 124 */     if (this.botaoCancelar == null)
/*     */     {
/* 126 */       this.botaoCancelar = new JButton();
/* 127 */       this.botaoCancelar.setBounds(new Rectangle(170, 76, 100, 26));
/* 128 */       this.botaoCancelar.setText("Cancelar");
/* 129 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 133 */           JanelaConfigurarOperador.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 137 */     return this.botaoCancelar;
/*     */   }
/*     */ 
/*     */   private JComboBox getComboOperador()
/*     */   {
/* 147 */     if (this.comboOperador == null)
/*     */     {
/* 149 */       this.comboOperador = new JComboBox();
/* 150 */       this.comboOperador.setBounds(new Rectangle(13, 43, 258, 20));
/* 151 */       ArrayList<Operador> array = this.dbOperador.getOperadores().getOperadores();
/* 152 */       for (Operador o : array)
/* 153 */         this.comboOperador.addItem(o);
/*     */     }
/* 155 */     return this.comboOperador;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaConfigurarOperador
 * JD-Core Version:    0.6.2
 */