/*     */ package br.com.pirus.ac;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleAC;
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import br.com.pirus.ac.interfaces.JanelaAC;
/*     */ import br.com.pirus.ac.interfaces.SplashScreen;
/*     */ import br.com.pirus.ac.modelos.DBOperador;
/*     */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.InformacoesCFe;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class Main
/*     */ {
/* 139 */   private static IdentificacaoCFe baseIDE = null;
/*     */ 
/* 141 */   private static IdentificacaoEmitenteCFe baseEMIT = null;
/*     */ 
/* 143 */   private static InformacoesCFe basePROD = null;
/*     */ 
/* 145 */   private static DBOperador baseOperador = null;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  28 */     System.setProperty("jna.library.path", "C:/SAT/");
/*  29 */     ControleArquivos.criarDiretorio("C:/AC/");
/*  30 */     ControleArquivos.criarDiretorio("C:/AC/Sessoes/");
/*  31 */     ControleArquivos.criarDiretorio("C:/AC/Cancelamento/");
/*  32 */     SplashScreen splashScreen = new SplashScreen("/images/nfpaulista.PNG");
/*  33 */     splashScreen.splash();
/*  34 */     if (!ControleArquivos.existeArquivo("c:/SAT/SAT.dll"))
/*     */     {
/*  36 */       JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao SAT-FISCAL, o programa não irá iniciar!");
/*  37 */       System.exit(0);
/*     */     }
/*  39 */     ControleAC cComandos = new ControleAC();
/*     */     try
/*     */     {
/*  42 */       baseIDE = carregarBaseDadosIde();
/*  43 */       baseEMIT = carregarBaseDadosEmit();
/*  44 */       basePROD = carregarBaseDadosProd();
/*  45 */       baseOperador = carregarBaseDadosOperador();
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/*  49 */       e.printStackTrace();
/*     */     }
/*     */     catch (SAXException e) {
/*  52 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e) {
/*  55 */       e.printStackTrace();
/*     */     }
/*     */     catch (Exception e) {
/*  58 */       e.printStackTrace();
/*     */     }
/*  60 */     JanelaAC jPrincipal = new JanelaAC(baseIDE, baseEMIT, basePROD, baseOperador, cComandos);
/*  61 */     String retornoPing = cComandos.processarComandoPing();
/*  62 */     if (retornoPing.equals("Timeout."))
/*     */     {
/*  64 */       JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao SAT-FISCAL, o programa não irá iniciar!");
/*  65 */       System.exit(0);
/*     */     }
/*     */     else {
/*  68 */       JOptionPane.showMessageDialog(null, retornoPing);
/*     */     }
/*     */ 
/*  71 */     splashScreen.disable();
/*  72 */     jPrincipal.setVisible(true);
/*  73 */     jPrincipal.setFocusable(true);
/*     */   }
/*     */ 
/*     */   private static IdentificacaoEmitenteCFe carregarBaseDadosEmit()
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  79 */     String emit = ControleArquivos.lerBytesArquivo("DB_EMIT.xml");
/*  80 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/*  81 */     dbf.setNamespaceAware(true);
/*     */ 
/*  83 */     DocumentBuilder db = dbf.newDocumentBuilder();
/*  84 */     ByteArrayInputStream is = new ByteArrayInputStream(emit.getBytes());
/*  85 */     Document doc = db.parse(is);
/*     */ 
/*  87 */     NodeList raizes = doc.getChildNodes();
/*  88 */     Node raiz = raizes.item(0);
/*  89 */     IdentificacaoEmitenteCFe base = new IdentificacaoEmitenteCFe(raiz);
/*     */ 
/*  91 */     return base;
/*     */   }
/*     */ 
/*     */   private static IdentificacaoCFe carregarBaseDadosIde() throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  96 */     String emit = ControleArquivos.lerBytesArquivo("DB_IDE.xml");
/*  97 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/*  98 */     dbf.setNamespaceAware(true);
/*     */ 
/* 100 */     DocumentBuilder db = dbf.newDocumentBuilder();
/* 101 */     ByteArrayInputStream is = new ByteArrayInputStream(emit.getBytes());
/* 102 */     Document doc = db.parse(is);
/* 103 */     NodeList raizes = doc.getChildNodes();
/* 104 */     Node raiz = raizes.item(0);
/* 105 */     IdentificacaoCFe base = new IdentificacaoCFe(raiz);
/* 106 */     return base;
/*     */   }
/*     */ 
/*     */   private static InformacoesCFe carregarBaseDadosProd() throws ParserConfigurationException, SAXException, IOException
/*     */   {
/* 111 */     String emit = ControleArquivos.lerBytesArquivo("DB_PROD.xml");
/* 112 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 113 */     dbf.setNamespaceAware(true);
/*     */ 
/* 115 */     DocumentBuilder db = dbf.newDocumentBuilder();
/* 116 */     ByteArrayInputStream is = new ByteArrayInputStream(emit.getBytes());
/* 117 */     Document doc = db.parse(is);
/* 118 */     NodeList raizes = doc.getChildNodes();
/* 119 */     Node raiz = raizes.item(0);
/* 120 */     InformacoesCFe base = new InformacoesCFe(raiz);
/* 121 */     return base;
/*     */   }
/*     */ 
/*     */   private static DBOperador carregarBaseDadosOperador() throws ParserConfigurationException, SAXException, IOException
/*     */   {
/* 126 */     String emit = ControleArquivos.lerBytesArquivo("DB_OPERADOR.xml");
/* 127 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 128 */     dbf.setNamespaceAware(true);
/*     */ 
/* 130 */     DocumentBuilder db = dbf.newDocumentBuilder();
/* 131 */     ByteArrayInputStream is = new ByteArrayInputStream(emit.getBytes());
/* 132 */     Document doc = db.parse(is);
/* 133 */     NodeList raizes = doc.getChildNodes();
/* 134 */     Node raiz = raizes.item(0);
/* 135 */     DBOperador base = new DBOperador(raiz);
/* 136 */     return base;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.Main
 * JD-Core Version:    0.6.2
 */