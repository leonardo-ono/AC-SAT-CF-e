/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InformacoesCFe
/*     */ {
/* 153 */   private String id = null;
/*     */ 
/* 156 */   private IdentificacaoCFe ide = null;
/*     */ 
/* 159 */   private IdentificacaoEmitenteCFe emit = null;
/*     */ 
/* 162 */   private IdentificacaoDestinatarioCFe dest = null;
/*     */ 
/* 165 */   private Vector<DetalhamentoProdutosCFe> det = new Vector();
/*     */ 
/* 168 */   private ValoresTotaisCFe total = null;
/*     */ 
/*     */   public InformacoesCFe(Node no)
/*     */   {
/*  22 */     NodeList filhos = no.getChildNodes();
/*  23 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  25 */       Node filhoAtual = filhos.item(i);
/*  26 */       if (filhoAtual.getNodeName().equalsIgnoreCase("ide"))
/*     */       {
/*  28 */         this.ide = new IdentificacaoCFe(filhoAtual);
/*     */       }
/*  30 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("emit"))
/*     */       {
/*  32 */         this.emit = new IdentificacaoEmitenteCFe(filhoAtual);
/*     */       }
/*  34 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("dest"))
/*     */       {
/*  36 */         this.dest = new IdentificacaoDestinatarioCFe(filhoAtual);
/*     */       }
/*  38 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("det"))
/*     */       {
/*  40 */         DetalhamentoProdutosCFe detAtual = new DetalhamentoProdutosCFe(filhoAtual);
/*  41 */         this.det.add(detAtual);
/*     */       }
/*  43 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("total"))
/*     */       {
/*  45 */         this.total = new ValoresTotaisCFe(filhoAtual);
/*     */       }
/*     */     }
/*  48 */     NamedNodeMap atributos = no.getAttributes();
/*  49 */     for (int i = 0; i < atributos.getLength(); i++)
/*     */     {
/*  51 */       Node filhoAtual = atributos.item(i);
/*  52 */       if (filhoAtual.getNodeName().equalsIgnoreCase("Id"))
/*     */       {
/*  54 */         this.id = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/*  64 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  72 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public IdentificacaoCFe getIde()
/*     */   {
/*  80 */     return this.ide;
/*     */   }
/*     */ 
/*     */   public void setIde(IdentificacaoCFe ideCFe)
/*     */   {
/*  88 */     this.ide = ideCFe;
/*     */   }
/*     */ 
/*     */   public IdentificacaoEmitenteCFe getEmit()
/*     */   {
/*  96 */     return this.emit;
/*     */   }
/*     */ 
/*     */   public void setEmit(IdentificacaoEmitenteCFe emitCfe)
/*     */   {
/* 104 */     this.emit = emitCfe;
/*     */   }
/*     */ 
/*     */   public IdentificacaoDestinatarioCFe getDest()
/*     */   {
/* 112 */     return this.dest;
/*     */   }
/*     */ 
/*     */   public void setDest(IdentificacaoDestinatarioCFe destCfe)
/*     */   {
/* 120 */     this.dest = destCfe;
/*     */   }
/*     */ 
/*     */   public Vector<DetalhamentoProdutosCFe> getDet()
/*     */   {
/* 128 */     return this.det;
/*     */   }
/*     */ 
/*     */   public ValoresTotaisCFe getTotal()
/*     */   {
/* 136 */     return this.total;
/*     */   }
/*     */ 
/*     */   public void setTotal(ValoresTotaisCFe totalCFe)
/*     */   {
/* 144 */     this.total = totalCFe;
/*     */   }
/*     */ 
/*     */   public void setDet(Vector<DetalhamentoProdutosCFe> det)
/*     */   {
/* 149 */     this.det = det;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.InformacoesCFe
 * JD-Core Version:    0.6.2
 */