/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import com.sun.org.apache.xml.internal.serialize.OutputFormat;
/*     */ import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.io.Writer;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class IdentificacaoCFe
/*     */ {
/* 132 */   private String CNPJ = null;
/*     */ 
/* 135 */   private String signAC = null;
/*     */ 
/*     */   public IdentificacaoCFe(Node no)
/*     */   {
/*  30 */     NodeList filhos = no.getChildNodes();
/*  31 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  33 */       Node filhoAtual = filhos.item(i);
/*  34 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CNPJ"))
/*     */       {
/*  36 */         this.CNPJ = filhoAtual.getTextContent();
/*     */       }
/*  38 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("signAC"))
/*     */       {
/*  40 */         this.signAC = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCNPJ()
/*     */   {
/*  50 */     return this.CNPJ;
/*     */   }
/*     */ 
/*     */   public void setCNPJ(String CNPJ)
/*     */   {
/*  58 */     this.CNPJ = CNPJ;
/*     */   }
/*     */ 
/*     */   public String getSignAC()
/*     */   {
/*  66 */     return this.signAC;
/*     */   }
/*     */ 
/*     */   public void setSignAC(String signAC)
/*     */   {
/*  74 */     this.signAC = signAC;
/*     */   }
/*     */ 
/*     */   public static String format(String xmlSource) throws IOException, ParserConfigurationException, SAXException
/*     */   {
/*  79 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  80 */     DocumentBuilder builder = factory.newDocumentBuilder();
/*  81 */     Document document = builder.parse(new InputSource(new StringReader(xmlSource)));
/*  82 */     OutputFormat of = new OutputFormat();
/*  83 */     of.setIndenting(false);
/*  84 */     of.setOmitXMLDeclaration(false);
/*  85 */     Writer writer = new StringWriter();
/*  86 */     XMLSerializer serializer = new XMLSerializer(writer, of);
/*  87 */     serializer.serialize(document);
/*  88 */     return new String(writer.toString().getBytes("UTF-8"));
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  93 */     if (this.CNPJ != null)
/*  94 */       retorno.append("<CNPJ>").append(this.CNPJ).append("</CNPJ>");
/*  95 */     if (this.signAC != null)
/*  96 */       retorno.append("<signAC>").append(this.signAC).append("</signAC>");
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 101 */     StringBuffer retorno = new StringBuffer();
/* 102 */     retorno.append("<ide>");
/* 103 */     if (this.CNPJ != null)
/* 104 */       retorno.append("<CNPJ>").append(this.CNPJ).append("</CNPJ>");
/* 105 */     if (this.signAC != null)
/* 106 */       retorno.append("<signAC>").append(this.signAC).append("</signAC>");
/* 107 */     retorno.append("</ide>");
/*     */     try
/*     */     {
/* 110 */       return format(new String(retorno.toString().getBytes()));
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/* 114 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       e.printStackTrace();
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */     catch (SAXException e)
/*     */     {
/* 126 */       e.printStackTrace();
/*     */     }
/* 128 */     return retorno.toString();
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.IdentificacaoCFe
 * JD-Core Version:    0.6.2
 */