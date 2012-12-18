/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ import java.util.Vector;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ProdutoCFe
/*     */ {
/* 305 */   private String cProd = null;
/*     */ 
/* 308 */   private String cEAN = null;
/*     */ 
/* 311 */   private String xProd = null;
/*     */ 
/* 314 */   private String NCM = null;
/*     */ 
/* 317 */   private String CFOP = null;
/*     */ 
/* 320 */   private String uCom = null;
/*     */ 
/* 323 */   private String qCom = null;
/*     */ 
/* 326 */   private String vUnCom = null;
/*     */ 
/* 332 */   private String indRegra = null;
/*     */ 
/* 335 */   private String vDesc = null;
/*     */ 
/* 338 */   private String vOutro = null;
/*     */ 
/* 341 */   private Vector<ObservacaoFisco> obsFiscoDet = new Vector();
/*     */ 
/*     */   public ProdutoCFe(Node no)
/*     */   {
/*  19 */     NodeList filhos = no.getChildNodes();
/*  20 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  22 */       Node filhoAtual = filhos.item(i);
/*  23 */       if (filhoAtual.getNodeName().equalsIgnoreCase("cProd"))
/*     */       {
/*  25 */         this.cProd = filhoAtual.getTextContent();
/*     */       }
/*  27 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("cEAN"))
/*     */       {
/*  29 */         this.cEAN = filhoAtual.getTextContent();
/*     */       }
/*  31 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xProd"))
/*     */       {
/*  33 */         this.xProd = filhoAtual.getTextContent();
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("NCM"))
/*     */       {
/*  37 */         this.NCM = filhoAtual.getTextContent();
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CFOP"))
/*     */       {
/*  41 */         this.CFOP = filhoAtual.getTextContent();
/*     */       }
/*  43 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("uCom"))
/*     */       {
/*  45 */         this.uCom = filhoAtual.getTextContent();
/*     */       }
/*  47 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qCom"))
/*     */       {
/*  49 */         this.qCom = filhoAtual.getTextContent();
/*     */       }
/*  51 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vUnCom"))
/*     */       {
/*  53 */         this.vUnCom = filhoAtual.getTextContent();
/*     */       }
/*  55 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("indRegra"))
/*     */       {
/*  57 */         this.indRegra = filhoAtual.getTextContent();
/*     */       }
/*  59 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vDesc"))
/*     */       {
/*  61 */         this.vDesc = filhoAtual.getTextContent();
/*     */       }
/*  63 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vOutro"))
/*     */       {
/*  65 */         this.vOutro = filhoAtual.getTextContent();
/*     */       }
/*  67 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("obsFiscoDet"))
/*     */       {
/*  69 */         ObservacaoFisco obsFisco = new ObservacaoFisco(filhoAtual);
/*  70 */         this.obsFiscoDet.add(obsFisco);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public ProdutoCFe(String cProd, String cEAN, String xProd, String NCM, String CFOP, String uCom, String qCom, String vUnCom, String indRegra)
/*     */   {
/*  77 */     this.cProd = cProd;
/*  78 */     this.cEAN = cEAN;
/*  79 */     this.xProd = xProd;
/*  80 */     this.NCM = NCM;
/*  81 */     this.CFOP = CFOP;
/*  82 */     this.uCom = uCom;
/*  83 */     this.qCom = qCom;
/*  84 */     this.vUnCom = vUnCom;
/*  85 */     this.indRegra = indRegra;
/*     */   }
/*     */ 
/*     */   public String getcProd()
/*     */   {
/*  93 */     return this.cProd;
/*     */   }
/*     */ 
/*     */   public void setcProd(String cProd)
/*     */   {
/* 101 */     this.cProd = cProd;
/*     */   }
/*     */ 
/*     */   public String getcEAN()
/*     */   {
/* 109 */     return this.cEAN;
/*     */   }
/*     */ 
/*     */   public void setcEAN(String cEAN)
/*     */   {
/* 117 */     this.cEAN = cEAN;
/*     */   }
/*     */ 
/*     */   public String getxProd()
/*     */   {
/* 125 */     return this.xProd;
/*     */   }
/*     */ 
/*     */   public void setxProd(String xProd)
/*     */   {
/* 133 */     this.xProd = xProd;
/*     */   }
/*     */ 
/*     */   public String getNCM()
/*     */   {
/* 141 */     return this.NCM;
/*     */   }
/*     */ 
/*     */   public void setNCM(String nCM)
/*     */   {
/* 149 */     this.NCM = nCM;
/*     */   }
/*     */ 
/*     */   public String getCFOP()
/*     */   {
/* 157 */     return this.CFOP;
/*     */   }
/*     */ 
/*     */   public void setCFOP(String cFOP)
/*     */   {
/* 165 */     this.CFOP = cFOP;
/*     */   }
/*     */ 
/*     */   public String getuCom()
/*     */   {
/* 173 */     return this.uCom;
/*     */   }
/*     */ 
/*     */   public void setuCom(String uCom)
/*     */   {
/* 181 */     this.uCom = uCom;
/*     */   }
/*     */ 
/*     */   public String getqCom()
/*     */   {
/* 189 */     return this.qCom;
/*     */   }
/*     */ 
/*     */   public void setqCom(String qCom)
/*     */   {
/* 197 */     this.qCom = qCom;
/*     */   }
/*     */ 
/*     */   public String getvUnCom()
/*     */   {
/* 205 */     return this.vUnCom;
/*     */   }
/*     */ 
/*     */   public void setvUnCom(String vUnCom)
/*     */   {
/* 213 */     this.vUnCom = vUnCom;
/*     */   }
/*     */ 
/*     */   public String getIndRegra()
/*     */   {
/* 221 */     return this.indRegra;
/*     */   }
/*     */ 
/*     */   public void setIndRegra(String indRegra)
/*     */   {
/* 229 */     this.indRegra = indRegra;
/*     */   }
/*     */ 
/*     */   public String getvDesc()
/*     */   {
/* 237 */     return this.vDesc;
/*     */   }
/*     */ 
/*     */   public void setvDesc(String vDesc)
/*     */   {
/* 245 */     this.vDesc = vDesc;
/*     */   }
/*     */ 
/*     */   public String getvOutro()
/*     */   {
/* 253 */     return this.vOutro;
/*     */   }
/*     */ 
/*     */   public void setvOutro(String vOutro)
/*     */   {
/* 261 */     this.vOutro = vOutro;
/*     */   }
/*     */ 
/*     */   public Vector<ObservacaoFisco> getobsFiscoDet()
/*     */   {
/* 269 */     return this.obsFiscoDet;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 274 */     if (this.cProd != null)
/* 275 */       retorno.append("<cProd>").append(this.cProd).append("</cProd>");
/* 276 */     if (this.cEAN != null)
/* 277 */       retorno.append("<cEAN>").append(this.cEAN).append("</cEAN>");
/* 278 */     if (this.xProd != null)
/* 279 */       retorno.append("<xProd>").append(this.xProd).append("</xProd>");
/* 280 */     if (this.NCM != null)
/* 281 */       retorno.append("<NCM>").append(this.NCM).append("</NCM>");
/* 282 */     if (this.CFOP != null)
/* 283 */       retorno.append("<CFOP>").append(this.CFOP).append("</CFOP>");
/* 284 */     if (this.uCom != null)
/* 285 */       retorno.append("<uCom>").append(this.uCom).append("</uCom>");
/* 286 */     if (this.qCom != null)
/* 287 */       retorno.append("<qCom>").append(ControleDados.formatarDouble(this.qCom, 1, 15, 4)).append("</qCom>");
/* 288 */     if (this.vUnCom != null)
/* 289 */       retorno.append("<vUnCom>").append(this.vUnCom).append("</vUnCom>");
/* 290 */     if (this.indRegra != null)
/* 291 */       retorno.append("<indRegra>").append(this.indRegra).append("</indRegra>");
/* 292 */     if (this.vDesc != null)
/* 293 */       retorno.append("<vDesc>").append(this.vDesc).append("</vDesc>");
/* 294 */     if (this.vOutro != null)
/* 295 */       retorno.append("<vOutro>").append(this.vOutro).append("</vOutro>");
/* 296 */     for (int i = 0; i < this.obsFiscoDet.size(); i++)
/*     */     {
/* 298 */       retorno.append("<obsFiscoDet xCampoDet=\"").append(((ObservacaoFisco)this.obsFiscoDet.elementAt(i)).getxCampoDet()).append("\">");
/* 299 */       ((ObservacaoFisco)this.obsFiscoDet.elementAt(i)).toString(retorno);
/* 300 */       retorno.append("</obsFiscoDet>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.ProdutoCFe
 * JD-Core Version:    0.6.2
 */