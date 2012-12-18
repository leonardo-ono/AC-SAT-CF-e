/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ProdutoCFe
/*     */ {
/* 148 */   private String cProd = null;
/*     */ 
/* 151 */   private String xProd = null;
/*     */ 
/* 154 */   private String uCom = null;
/*     */ 
/* 157 */   private String qCom = null;
/*     */ 
/* 160 */   private String vUnCom = null;
/*     */ 
/* 163 */   private String vItem = null;
/*     */ 
/*     */   public ProdutoCFe(Node no)
/*     */   {
/*  20 */     NodeList filhos = no.getChildNodes();
/*  21 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  23 */       Node filhoAtual = filhos.item(i);
/*  24 */       if (filhoAtual.getNodeName().equalsIgnoreCase("cProd"))
/*     */       {
/*  26 */         this.cProd = filhoAtual.getTextContent();
/*     */       }
/*  28 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("xProd"))
/*     */       {
/*  30 */         this.xProd = filhoAtual.getTextContent();
/*     */       }
/*  32 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("uCom"))
/*     */       {
/*  34 */         this.uCom = filhoAtual.getTextContent();
/*     */       }
/*  36 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("qCom"))
/*     */       {
/*  38 */         this.qCom = filhoAtual.getTextContent();
/*     */       }
/*  40 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vUnCom"))
/*     */       {
/*  42 */         this.vUnCom = filhoAtual.getTextContent();
/*     */       }
/*  44 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("vItem"))
/*     */       {
/*  46 */         this.vItem = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getcProd()
/*     */   {
/*  56 */     return this.cProd;
/*     */   }
/*     */ 
/*     */   public void setcProd(String cProd)
/*     */   {
/*  64 */     this.cProd = cProd;
/*     */   }
/*     */ 
/*     */   public String getxProd()
/*     */   {
/*  72 */     return this.xProd;
/*     */   }
/*     */ 
/*     */   public void setxProd(String xProd)
/*     */   {
/*  80 */     this.xProd = xProd;
/*     */   }
/*     */ 
/*     */   public String getuCom()
/*     */   {
/*  88 */     return this.uCom;
/*     */   }
/*     */ 
/*     */   public void setuCom(String uCom)
/*     */   {
/*  96 */     this.uCom = uCom;
/*     */   }
/*     */ 
/*     */   public String getqCom()
/*     */   {
/* 104 */     return this.qCom;
/*     */   }
/*     */ 
/*     */   public void setqCom(String qCom)
/*     */   {
/* 112 */     this.qCom = qCom;
/*     */   }
/*     */ 
/*     */   public String getvUnCom()
/*     */   {
/* 120 */     return this.vUnCom;
/*     */   }
/*     */ 
/*     */   public void setvUnCom(String vUnCom)
/*     */   {
/* 128 */     this.vUnCom = vUnCom;
/*     */   }
/*     */ 
/*     */   public String getvItem()
/*     */   {
/* 136 */     return this.vItem;
/*     */   }
/*     */ 
/*     */   public void setvItem(String vItem)
/*     */   {
/* 144 */     this.vItem = vItem;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ProdutoCFe
 * JD-Core Version:    0.6.2
 */