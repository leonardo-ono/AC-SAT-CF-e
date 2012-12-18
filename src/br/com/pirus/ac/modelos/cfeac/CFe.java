/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import com.sun.org.apache.xml.internal.serialize.OutputFormat;
/*     */ import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class CFe
/*     */ {
/* 105 */   private InformacoesCFe infCFe = null;
/*     */   public static final int TESTE = 2;
/*     */   public static final int REAL = 1;
/*     */ 
/*     */   public CFe(InformacoesCFe infCFe)
/*     */   {
/*  31 */     this.infCFe = infCFe;
/*     */   }
/*     */ 
/*     */   public CFe(Node raiz)
/*     */   {
/*  36 */     NodeList filhos = raiz.getChildNodes();
/*  37 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  39 */       Node filhoAtual = filhos.item(i);
/*  40 */       if (filhoAtual.getNodeName().equalsIgnoreCase("infCFe"))
/*     */       {
/*  42 */         this.infCFe = new InformacoesCFe(filhoAtual);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setInfCFe(InformacoesCFe inf)
/*     */   {
/*  52 */     this.infCFe = inf;
/*     */   }
/*     */ 
/*     */   public InformacoesCFe getInfCFe()
/*     */   {
/*  60 */     return this.infCFe;
/*     */   }
/*     */ 
/*     */   public static String format(String xmlSource) throws IOException, ParserConfigurationException, SAXException
/*     */   {
/*  65 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  66 */     DocumentBuilder builder = factory.newDocumentBuilder();
/*  67 */     Document document = builder.parse(new InputSource(new StringReader(xmlSource)));
/*  68 */     OutputFormat of = new OutputFormat();
/*  69 */     of.setIndenting(true);
/*  70 */     of.setOmitXMLDeclaration(false);
/*  71 */     of.setEncoding("UTF-8");
/*  72 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*  73 */     XMLSerializer serializer = new XMLSerializer(of);
/*  74 */     serializer.setOutputByteStream(baos);
/*  75 */     serializer.serialize(document);
/*  76 */     return baos.toString();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  81 */     StringBuffer sb = new StringBuffer();
/*  82 */     sb.append("<CFe xmlns=\"http://www.fazenda.sp.gov.br/sat\">");
/*  83 */     this.infCFe.toString(sb);
/*  84 */     sb.append("</CFe>");
/*     */     try
/*     */     {
/*  87 */       return format(sb.toString());
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  91 */       e.printStackTrace();
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/*  95 */       e.printStackTrace();
/*     */     }
/*     */     catch (SAXException e)
/*     */     {
/*  99 */       e.printStackTrace();
/*     */     }
/* 101 */     return "";
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.CFe
 * JD-Core Version:    0.6.2
 */