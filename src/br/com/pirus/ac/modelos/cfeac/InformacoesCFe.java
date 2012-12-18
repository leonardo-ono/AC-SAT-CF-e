/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import com.sun.org.apache.xml.internal.serialize.OutputFormat;
/*     */ import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class InformacoesCFe
/*     */ {
/* 351 */   private String versaoDadosEnt = null;
/*     */ 
/* 354 */   private IdentificacaoCFe ide = null;
/*     */ 
/* 357 */   private IdentificacaoEmitenteCFe emit = null;
/*     */ 
/* 360 */   private IdentificacaoDestinatarioCFe dest = null;
/*     */ 
/* 363 */   private IdentificacaoLocalEntrega entrega = null;
/*     */ 
/* 366 */   private ArrayList<DetalhamentoProdutosCFe> det = new ArrayList<DetalhamentoProdutosCFe>();
/*     */ 
/* 369 */   private ValoresTotaisCFe total = null;
/*     */ 
/* 375 */   private MP MP = null;
/*     */ 
/* 378 */   private InformacoesAdicionaisCFe infAdic = null;
/*     */ 
/*     */   public InformacoesCFe(Node no)
/*     */   {
/*  32 */     NodeList filhos = no.getChildNodes();
/*  33 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  35 */       Node filhoAtual = filhos.item(i);
/*  36 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ide"))
/*     */       {
/*  38 */         this.ide = new IdentificacaoCFe(filhoAtual);
/*  39 */       } else if (filhoAtual.getNodeName().equalsIgnoreCase("emit"))
/*     */       {
/*  41 */         this.emit = new IdentificacaoEmitenteCFe(filhoAtual);
/*  42 */       } else if (filhoAtual.getNodeName().equalsIgnoreCase("det"))
/*     */       {
/*  44 */         DetalhamentoProdutosCFe detAtual = new DetalhamentoProdutosCFe(filhoAtual);
/*  45 */         this.det.add(detAtual);
/*  46 */       } else if (filhoAtual.getNodeName().equalsIgnoreCase("infAdic"))
/*     */       {
/*  48 */         this.infAdic = new InformacoesAdicionaisCFe(filhoAtual);
/*     */       }
/*     */     }
/*  51 */     NamedNodeMap atributos = no.getAttributes();
/*  52 */     for (int i = 0; i < atributos.getLength(); i++)
/*     */     {
/*  54 */       Node filhoAtual = atributos.item(i);
/*  55 */       if (filhoAtual.getNodeName().equalsIgnoreCase("versaoDadosEnt"))
/*     */       {
/*  57 */         this.versaoDadosEnt = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public InformacoesCFe()
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getVersaoDadosEnt()
/*     */   {
/*  72 */     return this.versaoDadosEnt;
/*     */   }
/*     */ 
/*     */   public void setVersaoDadosEnt(String versaoDadosEnt)
/*     */   {
/*  82 */     this.versaoDadosEnt = versaoDadosEnt;
/*     */   }
/*     */ 
/*     */   public IdentificacaoCFe getIde()
/*     */   {
/*  90 */     return this.ide;
/*     */   }
/*     */ 
/*     */   public void setIde(IdentificacaoCFe ideCFe)
/*     */   {
/*  99 */     this.ide = ideCFe;
/*     */   }
/*     */ 
/*     */   public IdentificacaoEmitenteCFe getEmit()
/*     */   {
/* 107 */     return this.emit;
/*     */   }
/*     */ 
/*     */   public void setEmit(IdentificacaoEmitenteCFe emitCfe)
/*     */   {
/* 116 */     this.emit = emitCfe;
/*     */   }
/*     */ 
/*     */   public IdentificacaoDestinatarioCFe getDest()
/*     */   {
/* 124 */     return this.dest;
/*     */   }
/*     */ 
/*     */   public void setDest(IdentificacaoDestinatarioCFe destCfe)
/*     */   {
/* 133 */     this.dest = destCfe;
/*     */   }
/*     */ 
/*     */   public IdentificacaoLocalEntrega getEntrega()
/*     */   {
/* 141 */     return this.entrega;
/*     */   }
/*     */ 
/*     */   public void setEntrega(IdentificacaoLocalEntrega entregaCfe)
/*     */   {
/* 150 */     this.entrega = entregaCfe;
/*     */   }
/*     */ 
/*     */   public ArrayList<DetalhamentoProdutosCFe> getDet()
/*     */   {
/* 158 */     return this.det;
/*     */   }
/*     */ 
/*     */   public ValoresTotaisCFe getTotal()
/*     */   {
/* 166 */     return this.total;
/*     */   }
/*     */ 
/*     */   public void setTotal(ValoresTotaisCFe totalCFe)
/*     */   {
/* 175 */     this.total = totalCFe;
/*     */   }
/*     */ 
/*     */   public InformacoesAdicionaisCFe getInfAdic()
/*     */   {
/* 183 */     return this.infAdic;
/*     */   }
/*     */ 
/*     */   public void setInfAdic(InformacoesAdicionaisCFe infAdicCfe)
/*     */   {
/* 192 */     this.infAdic = infAdicCfe;
/*     */   }
/*     */ 
/*     */   public MP getMP()
/*     */   {
/* 197 */     return this.MP;
/*     */   }
/*     */ 
/*     */   public void setMP(MP mP)
/*     */   {
/* 202 */     this.MP = mP;
/*     */   }
/*     */ 
/*     */   public void setDet(ArrayList<DetalhamentoProdutosCFe> det)
/*     */   {
/* 207 */     this.det = det;
/*     */   }
/*     */ 
/*     */   public static String format(String xmlSource) throws IOException, ParserConfigurationException, SAXException
/*     */   {
/* 212 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 213 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 214 */     Document document = builder.parse(new InputSource(new StringReader(xmlSource)));
/* 215 */     OutputFormat of = new OutputFormat();
/* 216 */     of.setIndenting(false);
/* 217 */     of.setOmitXMLDeclaration(false);
/* 218 */     Writer writer = new StringWriter();
/* 219 */     XMLSerializer serializer = new XMLSerializer(writer, of);
/* 220 */     serializer.serialize(document);
/* 221 */     return new String(writer.toString().getBytes("UTF-8"));
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 226 */     retorno.append("<infCFe versaoDadosEnt=\"").append(this.versaoDadosEnt).append("\"").append(">");
/* 227 */     if (this.ide != null)
/*     */     {
/* 229 */       retorno.append("<ide>");
/* 230 */       this.ide.toString(retorno);
/* 231 */       retorno.append("</ide>");
/*     */     }
/* 233 */     if (this.emit != null)
/*     */     {
/* 235 */       retorno.append("<emit>");
/* 236 */       this.emit.toString(retorno);
/* 237 */       retorno.append("</emit>");
/*     */     }
/* 239 */     if (this.dest != null)
/*     */     {
/* 241 */       retorno.append("<dest>");
/* 242 */       this.dest.toString(retorno);
/* 243 */       retorno.append("</dest>");
/*     */     }
/* 245 */     if (this.entrega != null)
/*     */     {
/* 247 */       retorno.append("<entrega>");
/* 248 */       this.entrega.toString(retorno);
/* 249 */       retorno.append("</entrega>");
/*     */     }
/* 251 */     for (int i = 0; i < this.det.size(); i++)
/*     */     {
/* 253 */       retorno.append("<det nItem=\"").append(((DetalhamentoProdutosCFe)this.det.get(i)).getNItem()).append("\">");
/* 254 */       ((DetalhamentoProdutosCFe)this.det.get(i)).toString(retorno);
/* 255 */       retorno.append("</det>");
/*     */     }
/* 257 */     if (this.MP != null)
/*     */     {
/* 259 */       retorno.append("<MP>");
/* 260 */       this.MP.toString(retorno);
/* 261 */       retorno.append("</MP>");
/*     */     }
/* 263 */     if (this.total != null)
/*     */     {
/* 265 */       retorno.append("<total>");
/* 266 */       this.total.toString(retorno);
/* 267 */       retorno.append("</total>");
/*     */     }
/* 269 */     if (this.infAdic != null)
/*     */     {
/* 271 */       retorno.append("<infAdic>");
/* 272 */       this.infAdic.toString(retorno);
/* 273 */       retorno.append("</infAdic>");
/*     */     }
/* 275 */     retorno.append("</infCFe>");
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     StringBuffer retorno = new StringBuffer();
/* 281 */     retorno.append("<dets>");
/* 282 */     if (this.ide != null)
/*     */     {
/* 284 */       retorno.append("<ide>");
/* 285 */       this.ide.toString(retorno);
/* 286 */       retorno.append("</ide>");
/*     */     }
/* 288 */     if (this.emit != null)
/*     */     {
/* 290 */       retorno.append("<emit>");
/* 291 */       this.emit.toString(retorno);
/* 292 */       retorno.append("</emit>");
/*     */     }
/* 294 */     if (this.dest != null)
/*     */     {
/* 296 */       retorno.append("<dest>");
/* 297 */       this.dest.toString(retorno);
/* 298 */       retorno.append("</dest>");
/*     */     }
/* 300 */     if (this.entrega != null)
/*     */     {
/* 302 */       retorno.append("<entrega>");
/* 303 */       this.entrega.toString(retorno);
/* 304 */       retorno.append("</entrega>");
/*     */     }
/* 306 */     for (int i = 0; i < this.det.size(); i++)
/*     */     {
/* 308 */       retorno.append("<det>");
/* 309 */       ((DetalhamentoProdutosCFe)this.det.get(i)).toString(retorno);
/* 310 */       retorno.append("</det>");
/*     */     }
/* 312 */     if (this.MP != null)
/*     */     {
/* 314 */       retorno.append("<MP>");
/* 315 */       this.MP.toString(retorno);
/* 316 */       retorno.append("</MP>");
/*     */     }
/* 318 */     if (this.total != null)
/*     */     {
/* 320 */       retorno.append("<total>");
/* 321 */       this.total.toString(retorno);
/* 322 */       retorno.append("</total>");
/*     */     }
/* 324 */     if (this.infAdic != null)
/*     */     {
/* 326 */       retorno.append("<infAdic>");
/* 327 */       this.infAdic.toString(retorno);
/* 328 */       retorno.append("</infAdic>");
/*     */     }
/* 330 */     retorno.append("</dets>");
/*     */     try
/*     */     {
/* 333 */       return format(new String(retorno.toString().getBytes()));
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/* 336 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e) {
/* 339 */       e.printStackTrace();
/*     */     }
/*     */     catch (ParserConfigurationException e) {
/* 342 */       e.printStackTrace();
/*     */     }
/*     */     catch (SAXException e) {
/* 345 */       e.printStackTrace();
/*     */     }
/* 347 */     return retorno.toString();
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.InformacoesCFe
 * JD-Core Version:    0.6.2
 */