/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class IdentificacaoLocalEntrega
/*     */ {
/* 243 */   private String xLgr = null;
/*     */ 
/* 246 */   private String nro = null;
/*     */ 
/* 249 */   private String xCpl = null;
/*     */ 
/* 252 */   private String xBairro = null;
/*     */ 
/* 255 */   private String xMun = null;
/*     */ 
/* 258 */   private String UF = null;
/*     */ 
/*     */   public IdentificacaoLocalEntrega(Node no)
/*     */   {
/*  49 */     NodeList filhos = no.getChildNodes();
/*  50 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  52 */       Node filhoAtual = filhos.item(i);
/*  53 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xLgr"))
/*     */       {
/*  55 */         this.xLgr = filhoAtual.getTextContent();
/*     */       }
/*  57 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("nro"))
/*     */       {
/*  59 */         this.nro = filhoAtual.getTextContent();
/*     */       }
/*  61 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xCpl"))
/*     */       {
/*  63 */         this.xCpl = filhoAtual.getTextContent();
/*     */       }
/*  65 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xBairro"))
/*     */       {
/*  67 */         this.xBairro = filhoAtual.getTextContent();
/*     */       }
/*  69 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xMun"))
/*     */       {
/*  71 */         this.xMun = filhoAtual.getTextContent();
/*     */       }
/*  73 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("UF"))
/*     */       {
/*  75 */         this.UF = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getxLgr()
/*     */   {
/*  85 */     return this.xLgr;
/*     */   }
/*     */ 
/*     */   public void setxLgr(String xLgr)
/*     */   {
/*  93 */     this.xLgr = xLgr;
/*     */   }
/*     */ 
/*     */   public String getNro()
/*     */   {
/* 101 */     return this.nro;
/*     */   }
/*     */ 
/*     */   public void setNro(String nro)
/*     */   {
/* 109 */     this.nro = nro;
/*     */   }
/*     */ 
/*     */   public String getxCpl()
/*     */   {
/* 117 */     return this.xCpl;
/*     */   }
/*     */ 
/*     */   public void setxCpl(String xCpl)
/*     */   {
/* 125 */     this.xCpl = xCpl;
/*     */   }
/*     */ 
/*     */   public String getxBairro()
/*     */   {
/* 133 */     return this.xBairro;
/*     */   }
/*     */ 
/*     */   public void setxBairro(String xBairro)
/*     */   {
/* 141 */     this.xBairro = xBairro;
/*     */   }
/*     */ 
/*     */   public String getxMun()
/*     */   {
/* 149 */     return this.xMun;
/*     */   }
/*     */ 
/*     */   public void setxMun(String xMun)
/*     */   {
/* 157 */     this.xMun = xMun;
/*     */   }
/*     */ 
/*     */   public String getUF()
/*     */   {
/* 165 */     return this.UF;
/*     */   }
/*     */ 
/*     */   public void setUF(String UF)
/*     */   {
/* 173 */     this.UF = UF;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/* 178 */     String resultado = "1000";
/* 179 */     if (this.xLgr == null)
/*     */     {
/* 181 */       resultado = "1999";
/*     */     }
/* 183 */     else if (this.nro == null)
/*     */     {
/* 185 */       resultado = "1999";
/*     */     }
/* 187 */     else if (this.xBairro == null)
/*     */     {
/* 189 */       resultado = "1999";
/*     */     }
/* 191 */     else if (this.xMun == null)
/*     */     {
/* 193 */       resultado = "1999";
/*     */     }
/* 195 */     else if (this.UF == null)
/*     */     {
/* 197 */       resultado = "1999";
/*     */     }
/* 199 */     else if ((this.xLgr.length() < 2) || (this.xLgr.length() > 60))
/*     */     {
/* 201 */       resultado = "1999";
/*     */     }
/* 203 */     else if ((this.nro.length() < 1) || (this.nro.length() > 60))
/*     */     {
/* 205 */       resultado = "1999";
/*     */     }
/* 207 */     else if ((this.xCpl != null) && ((this.xCpl.length() < 1) || (this.xCpl.length() > 60)))
/*     */     {
/* 209 */       resultado = "1999";
/*     */     }
/* 211 */     else if ((this.xBairro.length() < 1) || (this.xBairro.length() > 60))
/*     */     {
/* 213 */       resultado = "1999";
/*     */     }
/* 215 */     else if ((this.xMun.length() < 2) || (this.xMun.length() > 60))
/*     */     {
/* 217 */       resultado = "1999";
/*     */     }
/* 219 */     else if (this.UF.length() != 2)
/*     */     {
/* 221 */       resultado = "1999";
/*     */     }
/* 223 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 228 */     if (this.xLgr != null)
/* 229 */       retorno.append("<xLgr>").append(this.xLgr).append("</xLgr>");
/* 230 */     if (this.nro != null)
/* 231 */       retorno.append("<nro>").append(this.nro).append("</nro>");
/* 232 */     if (this.xCpl != null)
/* 233 */       retorno.append("<xCpl>").append(this.xCpl).append("</xCpl>");
/* 234 */     if (this.xBairro != null)
/* 235 */       retorno.append("<xBairro>").append(this.xBairro).append("</xBairro>");
/* 236 */     if (this.xMun != null)
/* 237 */       retorno.append("<xMun>").append(this.xMun).append("</xMun>");
/* 238 */     if (this.UF != null)
/* 239 */       retorno.append("<UF>").append(this.UF).append("</UF>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.IdentificacaoLocalEntrega
 * JD-Core Version:    0.6.2
 */