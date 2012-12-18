/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class IdentificacaoLocalEntrega
/*     */ {
/* 161 */   private String xLgr = null;
/*     */ 
/* 164 */   private String nro = null;
/*     */ 
/* 167 */   private String xCpl = null;
/*     */ 
/* 170 */   private String xBairro = null;
/*     */ 
/* 173 */   private String xMun = null;
/*     */ 
/* 176 */   private String UF = null;
/*     */ 
/*     */   public IdentificacaoLocalEntrega(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xLgr"))
/*     */       {
/*  23 */         this.xLgr = filhoAtual.getTextContent();
/*     */       }
/*  25 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("nro"))
/*     */       {
/*  27 */         this.nro = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xCpl"))
/*     */       {
/*  31 */         this.xCpl = filhoAtual.getTextContent();
/*     */       }
/*  33 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xBairro"))
/*     */       {
/*  35 */         this.xBairro = filhoAtual.getTextContent();
/*     */       }
/*  37 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xMun"))
/*     */       {
/*  39 */         this.xMun = filhoAtual.getTextContent();
/*     */       }
/*  41 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("UF"))
/*     */       {
/*  43 */         this.UF = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getxLgr()
/*     */   {
/*  53 */     return this.xLgr;
/*     */   }
/*     */ 
/*     */   public void setxLgr(String xLgr)
/*     */   {
/*  61 */     this.xLgr = xLgr;
/*     */   }
/*     */ 
/*     */   public String getNro()
/*     */   {
/*  69 */     return this.nro;
/*     */   }
/*     */ 
/*     */   public void setNro(String nro)
/*     */   {
/*  77 */     this.nro = nro;
/*     */   }
/*     */ 
/*     */   public String getxCpl()
/*     */   {
/*  85 */     return this.xCpl;
/*     */   }
/*     */ 
/*     */   public void setxCpl(String xCpl)
/*     */   {
/*  93 */     this.xCpl = xCpl;
/*     */   }
/*     */ 
/*     */   public String getxBairro()
/*     */   {
/* 101 */     return this.xBairro;
/*     */   }
/*     */ 
/*     */   public void setxBairro(String xBairro)
/*     */   {
/* 109 */     this.xBairro = xBairro;
/*     */   }
/*     */ 
/*     */   public String getxMun()
/*     */   {
/* 117 */     return this.xMun;
/*     */   }
/*     */ 
/*     */   public void setxMun(String xMun)
/*     */   {
/* 125 */     this.xMun = xMun;
/*     */   }
/*     */ 
/*     */   public String getUF()
/*     */   {
/* 133 */     return this.UF;
/*     */   }
/*     */ 
/*     */   public void setUF(String UF)
/*     */   {
/* 141 */     this.UF = UF;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 146 */     if (this.xLgr != null)
/* 147 */       retorno.append("<xLgr>").append(this.xLgr).append("</xLgr>");
/* 148 */     if (this.nro != null)
/* 149 */       retorno.append("<nro>").append(this.nro).append("</nro>");
/* 150 */     if (this.xCpl != null)
/* 151 */       retorno.append("<xCpl>").append(this.xCpl).append("</xCpl>");
/* 152 */     if (this.xBairro != null)
/* 153 */       retorno.append("<xBairro>").append(this.xBairro).append("</xBairro>");
/* 154 */     if (this.xMun != null)
/* 155 */       retorno.append("<xMun>").append(this.xMun).append("</xMun>");
/* 156 */     if (this.UF != null)
/* 157 */       retorno.append("<UF>").append(this.UF).append("</UF>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.IdentificacaoLocalEntrega
 * JD-Core Version:    0.6.2
 */