/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class IdentificacaoEmitenteCFe
/*     */ {
/* 178 */   private String CNPJ = null;
/*     */ 
/* 181 */   private String xNome = null;
/*     */ 
/* 184 */   private String xFant = null;
/*     */ 
/* 187 */   private EnderecoEmitente enderEmit = null;
/*     */ 
/* 190 */   private String IE = null;
/*     */ 
/* 193 */   private String IM = null;
/*     */ 
/*     */   public IdentificacaoEmitenteCFe(Node no)
/*     */   {
/*  50 */     NodeList filhos = no.getChildNodes();
/*  51 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  53 */       Node filhoAtual = filhos.item(i);
/*  54 */       if (filhoAtual.getNodeName().equalsIgnoreCase("CNPJ"))
/*     */       {
/*  56 */         this.CNPJ = filhoAtual.getTextContent();
/*     */       }
/*  58 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xNome"))
/*     */       {
/*  60 */         this.xNome = filhoAtual.getTextContent();
/*     */       }
/*  62 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xFant"))
/*     */       {
/*  64 */         this.xFant = filhoAtual.getTextContent();
/*     */       }
/*  66 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("enderEmit"))
/*     */       {
/*  68 */         this.enderEmit = new EnderecoEmitente(filhoAtual);
/*     */       }
/*  70 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("IE"))
/*     */       {
/*  72 */         this.IE = filhoAtual.getTextContent();
/*     */       }
/*  74 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("IM"))
/*     */       {
/*  76 */         this.IM = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getCNPJ()
/*     */   {
/*  86 */     return this.CNPJ;
/*     */   }
/*     */ 
/*     */   public void setCNPJ(String CNPJ)
/*     */   {
/*  94 */     this.CNPJ = CNPJ;
/*     */   }
/*     */ 
/*     */   public String getxNome()
/*     */   {
/* 102 */     return this.xNome;
/*     */   }
/*     */ 
/*     */   public void setxNome(String xNome)
/*     */   {
/* 110 */     this.xNome = xNome;
/*     */   }
/*     */ 
/*     */   public String getxFant()
/*     */   {
/* 118 */     return this.xFant;
/*     */   }
/*     */ 
/*     */   public void setxFant(String xFant)
/*     */   {
/* 126 */     this.xFant = xFant;
/*     */   }
/*     */ 
/*     */   public EnderecoEmitente getEnderEmit()
/*     */   {
/* 134 */     return this.enderEmit;
/*     */   }
/*     */ 
/*     */   public void getEnderEmit(EnderecoEmitente enderEmitCfe)
/*     */   {
/* 142 */     this.enderEmit = enderEmitCfe;
/*     */   }
/*     */ 
/*     */   public String getIE()
/*     */   {
/* 150 */     return this.IE;
/*     */   }
/*     */ 
/*     */   public void setIE(String IE)
/*     */   {
/* 158 */     this.IE = IE;
/*     */   }
/*     */ 
/*     */   public String getIM()
/*     */   {
/* 166 */     return this.IM;
/*     */   }
/*     */ 
/*     */   public void setIM(String iM)
/*     */   {
/* 174 */     this.IM = iM;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.IdentificacaoEmitenteCFe
 * JD-Core Version:    0.6.2
 */