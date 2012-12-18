/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesAdicionaisCFe
/*     */ {
/*  98 */   private String infCpl = null;
/*     */ 
/* 101 */   private Vector<ObservacaoFisco> obsFisco = new Vector();
/*     */ 
/*     */   public InformacoesAdicionaisCFe(Node no)
/*     */   {
/*  40 */     NodeList filhos = no.getChildNodes();
/*  41 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  43 */       Node filhoAtual = filhos.item(i);
/*  44 */       if (filhoAtual.getNodeName().equalsIgnoreCase("infCpl"))
/*     */       {
/*  46 */         this.infCpl = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getInfCpl()
/*     */   {
/*  56 */     return this.infCpl;
/*     */   }
/*     */ 
/*     */   public void setInfCpl(String infCpl)
/*     */   {
/*  64 */     this.infCpl = infCpl;
/*     */   }
/*     */ 
/*     */   public Vector<ObservacaoFisco> getObsFisco()
/*     */   {
/*  72 */     return this.obsFisco;
/*     */   }
/*     */ 
/*     */   public String validar()
/*     */   {
/*  77 */     String resultado = "1000";
/*  78 */     if ((this.infCpl != null) && ((this.infCpl.length() < 1) || (this.infCpl.length() > 5000)))
/*     */     {
/*  80 */       resultado = "1999";
/*     */     }
/*  82 */     return resultado;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/*  87 */     if (this.infCpl != null)
/*  88 */       retorno.append("<infCpl>").append(this.infCpl).append("</infCpl>");
/*  89 */     for (int i = 0; i < this.obsFisco.size(); i++)
/*     */     {
/*  91 */       retorno.append("<obsFisco xCampoDet=\"").append(((ObservacaoFisco)this.obsFisco.elementAt(i)).getxCampoDet()).append("\">");
/*  92 */       ((ObservacaoFisco)this.obsFisco.elementAt(i)).toString(retorno);
/*  93 */       retorno.append("</obsFisco>");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesAdicionaisCFe
 * JD-Core Version:    0.6.2
 */