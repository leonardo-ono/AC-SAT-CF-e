/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class EnderecoEmitente
/*     */ {
/* 143 */   private String xLgr = null;
/*     */ 
/* 146 */   private String nro = null;
/*     */ 
/* 149 */   private String xCpl = null;
/*     */ 
/* 152 */   private String xBairro = null;
/*     */ 
/* 155 */   private String xMun = null;
/*     */ 
/* 158 */   private String CEP = null;
/*     */ 
/*     */   public EnderecoEmitente(Node no)
/*     */   {
/*  15 */     NodeList filhos = no.getChildNodes();
/*  16 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  18 */       Node filhoAtual = filhos.item(i);
/*  19 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xLgr"))
/*     */       {
/*  21 */         this.xLgr = filhoAtual.getTextContent();
/*     */       }
/*  23 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("nro"))
/*     */       {
/*  25 */         this.nro = filhoAtual.getTextContent();
/*     */       }
/*  27 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xCpl"))
/*     */       {
/*  29 */         this.xCpl = filhoAtual.getTextContent();
/*     */       }
/*  31 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xBairro"))
/*     */       {
/*  33 */         this.xBairro = filhoAtual.getTextContent();
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xMun"))
/*     */       {
/*  37 */         this.xMun = filhoAtual.getTextContent();
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("CEP"))
/*     */       {
/*  41 */         this.CEP = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getxLgr()
/*     */   {
/*  51 */     return this.xLgr;
/*     */   }
/*     */ 
/*     */   public void setxLgr(String xLgr)
/*     */   {
/*  59 */     this.xLgr = xLgr;
/*     */   }
/*     */ 
/*     */   public String getNro()
/*     */   {
/*  67 */     return this.nro;
/*     */   }
/*     */ 
/*     */   public void setNro(String nro)
/*     */   {
/*  75 */     this.nro = nro;
/*     */   }
/*     */ 
/*     */   public String getxCpl()
/*     */   {
/*  83 */     return this.xCpl;
/*     */   }
/*     */ 
/*     */   public void setxCpl(String xCpl)
/*     */   {
/*  91 */     this.xCpl = xCpl;
/*     */   }
/*     */ 
/*     */   public String getxBairro()
/*     */   {
/*  99 */     return this.xBairro;
/*     */   }
/*     */ 
/*     */   public void setxBairro(String xBairro)
/*     */   {
/* 107 */     this.xBairro = xBairro;
/*     */   }
/*     */ 
/*     */   public String getxMun()
/*     */   {
/* 115 */     return this.xMun;
/*     */   }
/*     */ 
/*     */   public void setxMun(String xMun)
/*     */   {
/* 123 */     this.xMun = xMun;
/*     */   }
/*     */ 
/*     */   public String getCEP()
/*     */   {
/* 131 */     return this.CEP;
/*     */   }
/*     */ 
/*     */   public void setCEP(String CEP)
/*     */   {
/* 139 */     this.CEP = CEP;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.EnderecoEmitente
 * JD-Core Version:    0.6.2
 */