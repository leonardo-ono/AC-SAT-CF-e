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
/*     */ public class IdentificacaoEmitenteCFe
/*     */ {
/* 214 */   private String CNPJ = null;
/*     */ 
/* 216 */   private String xFant = null;
/*     */ 
/* 219 */   private String IE = null;
/*     */ 
/* 222 */   private String IM = null;
/*     */ 
/* 231 */   private String cRegTribISSQN = null;
/*     */ 
/* 238 */   private String indRatISSQN = null;
/*     */ 
/*     */   public IdentificacaoEmitenteCFe(Node no)
/*     */   {
/*  30 */     NodeList filhos = no.getChildNodes();
/*  31 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  33 */       Node filhoAtual = filhos.item(i);
/*  34 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CNPJ"))
/*     */       {
/*  36 */         this.CNPJ = filhoAtual.getTextContent().trim().replace(".", "").replace("-", "").replace("/", "");
/*     */       }
/*  38 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xFant"))
/*     */       {
/*  40 */         this.xFant = filhoAtual.getTextContent().trim();
/*     */       }
/*  42 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("IE"))
/*     */       {
/*  44 */         this.IE = filhoAtual.getTextContent().trim();
/*     */       }
/*  46 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("IM"))
/*     */       {
/*  48 */         this.IM = filhoAtual.getTextContent().trim();
/*     */       }
/*  50 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cRegTribISSQN"))
/*     */       {
/*  52 */         this.cRegTribISSQN = filhoAtual.getTextContent().trim();
/*     */       }
/*  54 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("indRatISSQN"))
/*     */       {
/*  56 */         this.indRatISSQN = filhoAtual.getTextContent().trim();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCNPJ()
/*     */   {
/*  66 */     return this.CNPJ;
/*     */   }
/*     */ 
/*     */   public void setCNPJ(String CNPJ)
/*     */   {
/*  74 */     this.CNPJ = CNPJ;
/*     */   }
/*     */ 
/*     */   public String getxFant()
/*     */   {
/*  79 */     return this.xFant;
/*     */   }
/*     */ 
/*     */   public void setxFant(String xFant)
/*     */   {
/*  84 */     this.xFant = xFant;
/*     */   }
/*     */ 
/*     */   public String getIE()
/*     */   {
/*  92 */     return this.IE;
/*     */   }
/*     */ 
/*     */   public void setIE(String IE)
/*     */   {
/* 100 */     this.IE = IE;
/*     */   }
/*     */ 
/*     */   public String getIM()
/*     */   {
/* 108 */     return this.IM;
/*     */   }
/*     */ 
/*     */   public void setIM(String iM)
/*     */   {
/* 116 */     this.IM = iM;
/*     */   }
/*     */ 
/*     */   public String getIndRatISSQN()
/*     */   {
/* 121 */     return this.indRatISSQN;
/*     */   }
/*     */ 
/*     */   public String getcRegTribISSQN()
/*     */   {
/* 126 */     return this.cRegTribISSQN;
/*     */   }
/*     */ 
/*     */   public void setcRegTribISSQN(String cRegTribISSQN)
/*     */   {
/* 131 */     this.cRegTribISSQN = cRegTribISSQN;
/*     */   }
/*     */ 
/*     */   public void setIndRatISSQN(String indRatISSQN)
/*     */   {
/* 136 */     this.indRatISSQN = indRatISSQN;
/*     */   }
/*     */ 
/*     */   public static String format(String xmlSource) throws IOException, ParserConfigurationException, SAXException
/*     */   {
/* 141 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 142 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 143 */     Document document = builder.parse(new InputSource(new StringReader(xmlSource)));
/* 144 */     OutputFormat of = new OutputFormat();
/* 145 */     of.setIndenting(false);
/* 146 */     of.setOmitXMLDeclaration(false);
/* 147 */     Writer writer = new StringWriter();
/* 148 */     XMLSerializer serializer = new XMLSerializer(writer, of);
/* 149 */     serializer.serialize(document);
/* 150 */     return new String(writer.toString().getBytes("UTF-8"));
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 155 */     if (this.CNPJ != null)
/* 156 */       retorno.append("<CNPJ>").append(this.CNPJ).append("</CNPJ>");
/* 157 */     if (this.IE != null)
/* 158 */       retorno.append("<IE>").append(this.IE).append("</IE>");
/* 159 */     if (this.IM != null)
/* 160 */       retorno.append("<IM>").append(this.IM).append("</IM>");
/* 161 */     if (this.xFant != null)
/* 162 */       retorno.append("<xFant>").append(this.xFant).append("</xFant>");
/* 163 */     if (this.cRegTribISSQN != null)
/* 164 */       retorno.append("<cRegTribISSQN>").append(this.cRegTribISSQN).append("</cRegTribISSQN>");
/* 165 */     if (this.indRatISSQN != null)
/* 166 */       retorno.append("<indRatISSQN>").append(this.indRatISSQN).append("</indRatISSQN>");
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 171 */     StringBuffer retorno = new StringBuffer();
/* 172 */     retorno.append("<emit>");
/* 173 */     if (this.CNPJ != null)
/* 174 */       retorno.append("<CNPJ>").append(this.CNPJ).append("</CNPJ>");
/* 175 */     if (this.IE != null)
/* 176 */       retorno.append("<IE>").append(this.IE).append("</IE>");
/* 177 */     if (this.IM != null)
/* 178 */       retorno.append("<IM>").append(this.IM).append("</IM>");
/* 179 */     if (this.xFant != null)
/* 180 */       retorno.append("<xFant>").append(this.xFant).append("</xFant>");
/* 181 */     if (this.cRegTribISSQN != null)
/* 182 */       retorno.append("<cRegTribISSQN>").append(this.cRegTribISSQN).append("</cRegTribISSQN>");
/* 183 */     if (this.indRatISSQN != null)
/* 184 */       retorno.append("<indRatISSQN>").append(this.indRatISSQN).append("</indRatISSQN>");
/* 185 */     retorno.append("</emit>");
/*     */     try
/*     */     {
/* 188 */       return format(new String(retorno.toString().getBytes()));
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/* 192 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 196 */       e.printStackTrace();
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/* 200 */       e.printStackTrace();
/*     */     }
/*     */     catch (SAXException e)
/*     */     {
/* 204 */       e.printStackTrace();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       e.printStackTrace();
/*     */     }
/* 210 */     return retorno.toString();
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe
 * JD-Core Version:    0.6.2
 */