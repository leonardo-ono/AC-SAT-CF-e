/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class IdentificacaoDestinatarioCFe
/*     */ {
/*  99 */   private String CNPJ = null;
/*     */ 
/* 102 */   private String CPF = null;
/*     */ 
/* 105 */   private String xNome = null;
/*     */ 
/*     */   public IdentificacaoDestinatarioCFe(Node no)
/*     */   {
/*  17 */     NodeList filhos = no.getChildNodes();
/*  18 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  20 */       Node filhoAtual = filhos.item(i);
/*  21 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CPF"))
/*     */       {
/*  23 */         this.CPF = filhoAtual.getTextContent();
/*     */       }
/*  25 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CNPJ"))
/*     */       {
/*  27 */         this.CNPJ = filhoAtual.getTextContent();
/*     */       }
/*  29 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xNome"))
/*     */       {
/*  31 */         this.xNome = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public IdentificacaoDestinatarioCFe()
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getCNPJ()
/*     */   {
/*  45 */     return this.CNPJ;
/*     */   }
/*     */ 
/*     */   public void setCNPJ(String CNPJ)
/*     */   {
/*  53 */     this.CNPJ = CNPJ;
/*     */   }
/*     */ 
/*     */   public String getCPF()
/*     */   {
/*  61 */     return this.CPF;
/*     */   }
/*     */ 
/*     */   public void setCPF(String CPF)
/*     */   {
/*  69 */     this.CPF = CPF;
/*     */   }
/*     */ 
/*     */   public String getxNome()
/*     */   {
/*  77 */     return this.xNome;
/*     */   }
/*     */ 
/*     */   public void setxNome(String xNome)
/*     */   {
/*  85 */     this.xNome = xNome;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  90 */     if (this.CNPJ != null)
/*  91 */       retorno.append("<CNPJ>").append(this.CNPJ).append("</CNPJ>");
/*  92 */     if (this.CPF != null)
/*  93 */       retorno.append("<CPF>").append(this.CPF).append("</CPF>");
/*  94 */     if (this.xNome != null)
/*  95 */       retorno.append("<xNome>").append(this.xNome).append("</xNome>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.IdentificacaoDestinatarioCFe
 * JD-Core Version:    0.6.2
 */