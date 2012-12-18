/*     */ package br.com.pirus.ac.modelos.cfeac;
/*     */ 
/*     */ import br.com.pirus.ac.interfaces.JanelaCOFINSAliq;
/*     */ import br.com.pirus.ac.interfaces.JanelaCOFINSNT;
/*     */ import br.com.pirus.ac.interfaces.JanelaCOFINSQtde;
/*     */ import br.com.pirus.ac.interfaces.JanelaICMS00;
/*     */ import br.com.pirus.ac.interfaces.JanelaICMS40;
/*     */ import br.com.pirus.ac.interfaces.JanelaICMSSN102;
/*     */ import br.com.pirus.ac.interfaces.JanelaICMSSN900;
/*     */ import br.com.pirus.ac.interfaces.JanelaPISAliq;
/*     */ import br.com.pirus.ac.interfaces.JanelaPISNT;
/*     */ import br.com.pirus.ac.interfaces.JanelaPISQtde;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class DetalhamentoProdutosCFe
/*     */ {
/* 191 */   private String nItem = null;
/*     */ 
/* 194 */   private ProdutoCFe prod = null;
/*     */ 
/* 197 */   private TributosCFe imposto = null;
/*     */ 
/* 200 */   private String infAdProd = null;
/*     */ 
/*     */   public DetalhamentoProdutosCFe(Node no)
/*     */   {
/*  27 */     NodeList filhos = no.getChildNodes();
/*  28 */     for (int i = 0; i < filhos.getLength(); i++)
/*     */     {
/*  30 */       Node filhoAtual = filhos.item(i);
/*  31 */       if (filhoAtual.getNodeName().equalsIgnoreCase("prod"))
/*     */       {
/*  33 */         this.prod = new ProdutoCFe(filhoAtual);
/*     */       }
/*  35 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("imposto"))
/*     */       {
/*  37 */         this.imposto = new TributosCFe(filhoAtual);
/*     */       }
/*  39 */       else if (filhoAtual.getNodeName().equalsIgnoreCase("infAdProd"))
/*     */       {
/*  41 */         this.infAdProd = filhoAtual.getTextContent();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public DetalhamentoProdutosCFe(String cProd, String cEAN, String xProd, String nCM, String cFOP, String uCom, String qCom, String vUnCom, String indRegra, JanelaICMS00 icms00, JanelaICMS40 icms40, JanelaICMSSN102 icmssn102, JanelaICMSSN900 icmssn900, JanelaPISAliq pisAliq, JanelaPISQtde pisQtde, JanelaPISNT pisnt, JanelaCOFINSAliq cofinsAliq, JanelaCOFINSQtde cofinsQtde, JanelaCOFINSNT cofinsnt)
/*     */   {
/*  48 */     InformacoesICMS infICMS = null;
/*  49 */     InformacoesPIS infPIS = null;
/*  50 */     InformacoesCOFINS infCOFINS = null;
/*  51 */     if (icms00 != null)
/*     */     {
/*  53 */       ICMS00 i00 = new ICMS00(icms00.orig, icms00.CST, icms00.aliq);
/*  54 */       infICMS = new InformacoesICMS(i00);
/*     */     }
/*  56 */     else if (icms40 != null)
/*     */     {
/*  58 */       ICMS40 i40 = new ICMS40(icms40.orig, icms40.CST);
/*  59 */       infICMS = new InformacoesICMS(i40);
/*     */     }
/*  61 */     else if (icmssn102 != null)
/*     */     {
/*  63 */       ICMSSN102 i102 = new ICMSSN102(icmssn102.orig, icmssn102.CSOSN);
/*  64 */       infICMS = new InformacoesICMS(i102);
/*     */     }
/*  66 */     else if (icmssn900 != null)
/*     */     {
/*  68 */       ICMSSN900 i900 = new ICMSSN900(icmssn900.orig, icmssn900.CSOSN, icmssn900.aliq);
/*  69 */       infICMS = new InformacoesICMS(i900);
/*     */     }
/*  71 */     if (pisAliq != null)
/*     */     {
/*  73 */       PISAliq pAliq = new PISAliq(pisAliq.CST, pisAliq.BC, pisAliq.aliq);
/*  74 */       infPIS = new InformacoesPIS(pAliq);
/*     */     }
/*  76 */     else if (pisQtde != null)
/*     */     {
/*  78 */       PISQtde pQtde = new PISQtde(pisQtde.CST, "", pisQtde.aliq);
/*  79 */       infPIS = new InformacoesPIS(pQtde);
/*     */     }
/*  81 */     else if (pisnt != null)
/*     */     {
/*  83 */       PISNT pNT = new PISNT(pisnt.CST);
/*  84 */       infPIS = new InformacoesPIS(pNT);
/*     */     }
/*  86 */     if (cofinsAliq != null)
/*     */     {
/*  88 */       COFINSAliq cAliq = new COFINSAliq(pisAliq.CST, pisAliq.BC, pisAliq.aliq);
/*  89 */       infCOFINS = new InformacoesCOFINS(cAliq);
/*     */     }
/*  91 */     else if (cofinsQtde != null)
/*     */     {
/*  93 */       COFINSQtde cQtde = new COFINSQtde(pisQtde.CST, "", pisQtde.aliq);
/*  94 */       infCOFINS = new InformacoesCOFINS(cQtde);
/*     */     }
/*  96 */     else if (cofinsnt != null)
/*     */     {
/*  98 */       COFINSNT cNT = new COFINSNT(pisnt.CST);
/*  99 */       infCOFINS = new InformacoesCOFINS(cNT);
/*     */     }
/* 101 */     this.prod = new ProdutoCFe(cProd, cEAN, xProd, nCM, cFOP, uCom, qCom, vUnCom, indRegra);
/* 102 */     this.imposto = new TributosCFe(infICMS, infPIS, null, infCOFINS, null);
/*     */   }
/*     */ 
/*     */   public DetalhamentoProdutosCFe()
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getNItem()
/*     */   {
/* 114 */     return this.nItem;
/*     */   }
/*     */ 
/*     */   public void setnItem(String nItem)
/*     */   {
/* 122 */     this.nItem = nItem;
/*     */   }
/*     */ 
/*     */   public ProdutoCFe getProd()
/*     */   {
/* 130 */     return this.prod;
/*     */   }
/*     */ 
/*     */   public TributosCFe getImposto()
/*     */   {
/* 138 */     return this.imposto;
/*     */   }
/*     */ 
/*     */   public String getInfAdProd()
/*     */   {
/* 146 */     return this.infAdProd;
/*     */   }
/*     */ 
/*     */   public void setInfAdProd(String infAdProd)
/*     */   {
/* 154 */     this.infAdProd = infAdProd;
/*     */   }
/*     */ 
/*     */   public void setProd(ProdutoCFe prod)
/*     */   {
/* 159 */     this.prod = prod;
/*     */   }
/*     */ 
/*     */   public void setImposto(TributosCFe imposto)
/*     */   {
/* 164 */     this.imposto = imposto;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 169 */     if (this.prod != null)
/*     */     {
/* 171 */       retorno.append("<prod>");
/* 172 */       this.prod.toString(retorno);
/* 173 */       retorno.append("</prod>");
/*     */     }
/* 175 */     if (this.imposto != null)
/*     */     {
/* 177 */       retorno.append("<imposto>");
/* 178 */       this.imposto.toString(retorno);
/* 179 */       retorno.append("</imposto>");
/*     */     }
/* 181 */     if (this.infAdProd != null)
/* 182 */       retorno.append("<infAdProd>").append(this.infAdProd).append("</infAdProd>");
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 187 */     return this.prod.getxProd();
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe
 * JD-Core Version:    0.6.2
 */