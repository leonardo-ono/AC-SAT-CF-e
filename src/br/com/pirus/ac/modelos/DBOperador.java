/*    */ package br.com.pirus.ac.modelos;
/*    */ 
/*    */ import com.sun.org.apache.xml.internal.serialize.OutputFormat;
/*    */ import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
/*    */ import java.io.IOException;
/*    */ import java.io.StringReader;
/*    */ import java.io.StringWriter;
/*    */ import java.io.Writer;
/*    */ import javax.xml.parsers.DocumentBuilder;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import javax.xml.parsers.ParserConfigurationException;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ import org.xml.sax.InputSource;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ public class DBOperador
/*    */ {
/* 96 */   private Operador operadorAtual = null;
/*    */ 
/* 98 */   private Operadores operadores = null;
/*    */ 
/*    */   public DBOperador(Node raiz)
/*    */   {
/* 28 */     NodeList filhos = raiz.getChildNodes();
/* 29 */     for (int i = 0; i < filhos.getLength(); i++)
/*    */     {
/* 31 */       Node filhoAtual = filhos.item(i);
/* 32 */       if (filhoAtual.getNodeName().equalsIgnoreCase("operador"))
/*    */       {
/* 34 */         this.operadorAtual = new Operador(filhoAtual);
/*    */       }
/* 36 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("operadores"))
/*    */       {
/* 38 */         this.operadores = new Operadores(filhoAtual);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public Operador getOperadorAtual()
/*    */   {
/* 45 */     return this.operadorAtual;
/*    */   }
/*    */ 
/*    */   public void setOperadorAtual(Operador operadorAtual)
/*    */   {
/* 50 */     this.operadorAtual = operadorAtual;
/*    */   }
/*    */ 
/*    */   public Operadores getOperadores()
/*    */   {
/* 55 */     return this.operadores;
/*    */   }
/*    */ 
/*    */   public void setOperadores(Operadores operadores)
/*    */   {
/* 60 */     this.operadores = operadores;
/*    */   }
/*    */ 
/*    */   public static String format(String xmlSource) throws IOException, ParserConfigurationException, SAXException
/*    */   {
/* 65 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 66 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 67 */     Document document = builder.parse(new InputSource(new StringReader(xmlSource)));
/* 68 */     OutputFormat of = new OutputFormat();
/* 69 */     of.setIndenting(false);
/* 70 */     of.setOmitXMLDeclaration(false);
/* 71 */     Writer writer = new StringWriter();
/* 72 */     XMLSerializer serializer = new XMLSerializer(writer, of);
/* 73 */     serializer.serialize(document);
/* 74 */     return new String(writer.toString().getBytes("UTF-8"));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 79 */     StringBuffer sb = new StringBuffer();
/* 80 */     sb.append("<dbOperador>");
/* 81 */     this.operadorAtual.toString(sb);
/* 82 */     this.operadores.toString(sb);
/* 83 */     sb.append("</dbOperador>");
/*    */     try
/*    */     {
/* 86 */       return format(new String(sb.toString().getBytes()));
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 90 */       e.printStackTrace();
/*    */     }
/* 92 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.DBOperador
 * JD-Core Version:    0.6.2
 */