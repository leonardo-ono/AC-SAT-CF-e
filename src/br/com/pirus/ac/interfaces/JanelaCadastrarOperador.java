/*     */ package br.com.pirus.ac.interfaces;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.modelos.DBOperador;
/*     */ import br.com.pirus.ac.modelos.Operador;
/*     */ import br.com.pirus.ac.modelos.Operadores;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class JanelaCadastrarOperador extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private JPanel jContentPane = null;
/*     */ 
/*  28 */   private JTextField textoOperador = null;
/*     */ 
/*  30 */   private JLabel labelOperador = null;
/*     */ 
/*  32 */   private JButton botaoOK = null;
/*     */ 
/*  34 */   private JButton botaoCancelar = null;
/*     */   private DBOperador dbOperador;
/*     */ 
/*     */   public JanelaCadastrarOperador(Frame owner, DBOperador dbOperador)
/*     */   {
/*  43 */     super(owner);
/*  44 */     this.dbOperador = dbOperador;
/*  45 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*     */     try
/*     */     {
/*  57 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  61 */       e.printStackTrace();
/*     */     }
/*  63 */     setSize(287, 140);
/*  64 */     setResizable(false);
/*  65 */     setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
/*  66 */     setTitle("Cadastrar operador");
/*  67 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  77 */     if (this.jContentPane == null)
/*     */     {
/*  79 */       this.labelOperador = new JLabel();
/*  80 */       this.labelOperador.setBounds(new Rectangle(13, 20, 39, 16));
/*  81 */       this.labelOperador.setText("Nome");
/*  82 */       this.jContentPane = new JPanel();
/*  83 */       this.jContentPane.setLayout(null);
/*  84 */       this.jContentPane.add(getTextoOperador(), null);
/*  85 */       this.jContentPane.add(this.labelOperador, null);
/*  86 */       this.jContentPane.add(getBotaoOK(), null);
/*  87 */       this.jContentPane.add(getBotaoCancelar(), null);
/*     */     }
/*  89 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getTextoOperador()
/*     */   {
/*  99 */     if (this.textoOperador == null)
/*     */     {
/* 101 */       this.textoOperador = new JTextField();
/* 102 */       this.textoOperador.setBounds(new Rectangle(13, 40, 258, 25));
/*     */     }
/* 104 */     return this.textoOperador;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoOK()
/*     */   {
/* 114 */     if (this.botaoOK == null)
/*     */     {
/* 116 */       this.botaoOK = new JButton();
/* 117 */       this.botaoOK.setBounds(new Rectangle(13, 80, 100, 26));
/* 118 */       this.botaoOK.setText("OK");
/* 119 */       this.botaoOK.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 123 */           ArrayList<Operador> ops = JanelaCadastrarOperador.this.dbOperador.getOperadores().getOperadores();
/* 124 */           for (Operador o : ops)
/*     */           {
/* 126 */             if (o.getNome().trim().equalsIgnoreCase(JanelaCadastrarOperador.this.textoOperador.getText().trim()))
/*     */             {
/* 128 */               JOptionPane.showMessageDialog(null, "Já existe outro operador com o mesmo nome!");
/* 129 */               return;
/*     */             }
/*     */           }
/* 132 */           JanelaCadastrarOperador.this.dbOperador.getOperadores().getOperadores().add(new Operador("" + (JanelaCadastrarOperador.this.dbOperador.getOperadores().getOperadores().size() + 1), JanelaCadastrarOperador.this.textoOperador.getText()));
/* 133 */           ControleArquivos.escreverCaracteresArquivo("DB_OPERADOR.xml", JanelaCadastrarOperador.this.dbOperador.toString().toCharArray());
/* 134 */           JanelaCadastrarOperador.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 138 */     return this.botaoOK;
/*     */   }
/*     */ 
/*     */   private JButton getBotaoCancelar()
/*     */   {
/* 148 */     if (this.botaoCancelar == null)
/*     */     {
/* 150 */       this.botaoCancelar = new JButton();
/* 151 */       this.botaoCancelar.setBounds(new Rectangle(170, 80, 100, 26));
/* 152 */       this.botaoCancelar.setText("Cancelar");
/* 153 */       this.botaoCancelar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent e)
/*     */         {
/* 157 */           JanelaCadastrarOperador.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 161 */     return this.botaoCancelar;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.interfaces.JanelaCadastrarOperador
 * JD-Core Version:    0.6.2
 */