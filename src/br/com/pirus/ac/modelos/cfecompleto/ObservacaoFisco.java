/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ObservacaoFisco
/*     */ {
/* 122 */   private String xCampoDet = null;
/*     */ 
/* 125 */   private String xTextoDet = null;
/*     */ 
/*     */   public ObservacaoFisco(Node no)
/*     */   {
/*  41 */     NodeList filhos = no.getChildNodes();
/*  42 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  44 */       Node filhoAtual = filhos.item(i);
/*  45 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xTextoDet"))
/*     */       {
/*  47 */         this.xTextoDet = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*  50 */     NamedNodeMap atributos = no.getAttributes();
/*  51 */     for (int i = 0; i < atributos.getLength(); i++)
/*     */     {
/*  53 */       Node filhoAtual = atributos.item(i);
/*  54 */       if (filhoAtual.getNodeName().equalsIgnoreCase("xCampoDet"))
/*     */       {
/*  56 */         this.xCampoDet = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getxCampoDet()
/*     */   {
/*  66 */     return this.xCampoDet;
/*     */   }
/*     */ 
/*     */   public void setxCampoDet(String xCampoDet)
/*     */   {
/*  74 */     this.xCampoDet = xCampoDet;
/*     */   }
/*     */ 
/*     */   public String getxTextoDet()
/*     */   {
/*  82 */     return this.xTextoDet;
/*     */   }
/*     */ 
/*     */   public void setxTextoDet(String xTextoDet)
/*     */   {
/*  90 */     this.xTextoDet = xTextoDet;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/*  95 */     String resultado = "1000";
/*  96 */     if (this.xCampoDet == null)
/*     */     {
/*  98 */       resultado = "1999";
/*     */     }
/* 100 */     else if (this.xTextoDet == null)
/*     */     {
/* 102 */       resultado = "1999";
/*     */     }
/* 104 */     else if ((this.xCampoDet.length() < 1) || (this.xCampoDet.length() > 20))
/*     */     {
/* 106 */       resultado = "1999";
/*     */     }
/* 108 */     else if ((this.xTextoDet.length() < 1) || (this.xTextoDet.length() > 60))
/*     */     {
/* 110 */       resultado = "1999";
/*     */     }
/* 112 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 117 */     if (this.xTextoDet != null)
/* 118 */       retorno.append("<xTextoDet>").append(this.xTextoDet).append("</xTextoDet>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ObservacaoFisco
 * JD-Core Version:    0.6.2
 */