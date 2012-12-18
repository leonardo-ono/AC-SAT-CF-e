/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class IdentificacaoCFe
/*     */ {
/*  95 */   private String nCFe = null;
/*     */ 
/*  98 */   private String dEmi = null;
/*     */ 
/* 101 */   private String hEmi = null;
/*     */ 
/*     */   public IdentificacaoCFe(Node no)
/*     */   {
/*  27 */     NodeList filhos = no.getChildNodes();
/*  28 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  30 */       Node filhoAtual = filhos.item(i);
/*  31 */       if (filhoAtual.getNodeName().equalsIgnoreCase("nCFe"))
/*     */       {
/*  33 */         this.nCFe = filhoAtual.getTextContent();
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("dEmi"))
/*     */       {
/*  37 */         this.dEmi = filhoAtual.getTextContent();
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("hEmi"))
/*     */       {
/*  41 */         this.hEmi = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getnCFe()
/*     */   {
/*  51 */     return this.nCFe;
/*     */   }
/*     */ 
/*     */   public void setnCFe(String nCFe)
/*     */   {
/*  59 */     this.nCFe = nCFe;
/*     */   }
/*     */ 
/*     */   public String getdEmi()
/*     */   {
/*  67 */     return this.dEmi;
/*     */   }
/*     */ 
/*     */   public void setdEmi(String dEmi)
/*     */   {
/*  75 */     this.dEmi = dEmi;
/*     */   }
/*     */ 
/*     */   public String gethEmi()
/*     */   {
/*  83 */     return this.hEmi;
/*     */   }
/*     */ 
/*     */   public void sethEmi(String hEmi)
/*     */   {
/*  91 */     this.hEmi = hEmi;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.IdentificacaoCFe
 * JD-Core Version:    0.6.2
 */