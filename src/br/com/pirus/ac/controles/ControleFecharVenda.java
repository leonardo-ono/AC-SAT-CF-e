/*     */ package br.com.pirus.ac.controles;
/*     */ 
/*     */ import br.com.pirus.ac.interfaces.ControleACListener;
/*     */ import br.com.pirus.ac.interfaces.JanelaAC;
/*     */ import br.com.pirus.ac.modelos.PrintCFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.CFe;
/*     */ import br.com.pirus.ac.modelos.cfeac.MP;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.CFeImpressao;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.EnderecoEmitente;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.ICMS00;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.ICMS40;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.ICMSSN102;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.ICMSSN900;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.ICMSTotal;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.InformacoesICMS;
/*     */ import br.com.pirus.ac.modelos.cfecompleto.TributosCFe;
/*     */ import br.com.pirus.ac.utils.Utils;
/*     */ import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ControleFecharVenda
/*     */   implements ActionListener, ControleACListener
/*     */ {
/*     */   private JanelaAC janelaAC;
/*     */   private br.com.pirus.ac.modelos.cfeac.InformacoesCFe basePROD;
/*     */   private br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe baseEMIT;
/*     */   private br.com.pirus.ac.modelos.cfeac.IdentificacaoCFe baseIDE;
/*     */ 
/*     */   public ControleFecharVenda(JanelaAC janelaAC, br.com.pirus.ac.modelos.cfeac.InformacoesCFe basePROD, br.com.pirus.ac.modelos.cfeac.IdentificacaoEmitenteCFe baseEMIT, br.com.pirus.ac.modelos.cfeac.IdentificacaoCFe baseIDE)
/*     */   {
/*  47 */     this.janelaAC = janelaAC;
/*  48 */     this.basePROD = basePROD;
/*  49 */     this.baseEMIT = baseEMIT;
/*  50 */     this.baseIDE = baseIDE;
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/*  55 */     String troco = this.janelaAC.getValorTroco().getText();
/*  56 */     String pago = this.janelaAC.getValorValorPago().getText();
/*  57 */     int count = this.janelaAC.getTabelaItens().getRowCount();
/*  58 */     if (count <= 0)
/*     */     {
/*  60 */       this.janelaAC.getLabelAlerta().setText("Não há nenhum item na venda!");
/*  61 */       return;
/*  62 */     }if (pago.length() <= 0)
/*     */     {
/*  64 */       this.janelaAC.getLabelAlerta().setText("O campo \"Valor Pago\" é de preenchimento obrigatório!");
/*  65 */       return;
/*  66 */     }if (Double.parseDouble(troco) < 0.0D)
/*     */     {
/*  68 */       this.janelaAC.getLabelAlerta().setText("O troco deve ser maior ou igual a 0!");
/*  69 */       return;
/*     */     }
/*     */ 
/*  72 */     this.janelaAC.getLabelAlerta().setText("");
/*  73 */     desativarComponentes();
/*  74 */     String cupom = gerarCupom();
/*  75 */     ControleArquivos.escreverCaracteresArquivo("C:/AC/dadosVenda", cupom.toCharArray());
/*  76 */     this.janelaAC.cAC.processarComandoEmitirCFe(this, Utils.getSenha(), cupom);
/*     */   }
/*     */ 
/*     */   private String gerarCupom()
/*     */   {
/*  82 */     JTable tabela = this.janelaAC.getTabelaItens();
/*  83 */     int count = tabela.getRowCount();
/*  84 */     ArrayList produtos = this.basePROD.getDet();
/*  85 */     ArrayList produtosCFe = new ArrayList();
/*  86 */     br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe produtoAtual = null;
/*  87 */     for (int i = 0; i < count; i++)
/*     */     {
/*  89 */       for (int j = 0; j < produtos.size(); j++)
/*     */       {
/*  91 */         if (((br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe)produtos.get(j)).getProd().getcProd().equals(tabela.getValueAt(i, 1)))
/*     */         {
/*  93 */           produtoAtual = new br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe();
/*  94 */           br.com.pirus.ac.modelos.cfeac.ProdutoCFe prod = ((br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe)produtos.get(j)).getProd();
/*  95 */           br.com.pirus.ac.modelos.cfeac.ProdutoCFe prodNovo = new br.com.pirus.ac.modelos.cfeac.ProdutoCFe(prod.getcProd(), prod.getcEAN(), prod.getxProd(), prod.getNCM(), prod.getCFOP(), prod.getuCom(), tabela.getValueAt(i, 4).toString(), 
/*  96 */             prod.getvUnCom(), prod.getIndRegra());
/*  97 */           produtoAtual.setProd(prodNovo);
/*  98 */           produtoAtual.setImposto(((br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe)produtos.get(j)).getImposto());
/*  99 */           produtoAtual.setInfAdProd(((br.com.pirus.ac.modelos.cfeac.DetalhamentoProdutosCFe)produtos.get(j)).getInfAdProd());
/* 100 */           produtoAtual.setnItem("" + (i + 1));
/* 101 */           produtosCFe.add(produtoAtual);
/* 102 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 107 */     br.com.pirus.ac.modelos.cfeac.InformacoesCFe infCFe = new br.com.pirus.ac.modelos.cfeac.InformacoesCFe();
/*     */ 
/* 109 */     infCFe.setVersaoDadosEnt("1.00");
/*     */ 
/* 111 */     infCFe.setIde(this.baseIDE);
/*     */ 
/* 113 */     infCFe.setEmit(this.baseEMIT);
/*     */ 
/* 115 */     br.com.pirus.ac.modelos.cfeac.IdentificacaoDestinatarioCFe dest = new br.com.pirus.ac.modelos.cfeac.IdentificacaoDestinatarioCFe();
/* 116 */     String nome = this.janelaAC.getDadosNome().getText();
/* 117 */     String id = this.janelaAC.getIdConsumidor().getText();
/* 118 */     if (nome.length() > 0)
/* 119 */       dest.setxNome(this.janelaAC.getDadosNome().getText());
/* 120 */     if (id.length() > 0)
/* 121 */       if (Utils.isValidCNPJ(id))
/* 122 */         dest.setCNPJ(id);
/* 123 */       else if (Utils.isValidCPF(id))
/* 124 */         dest.setCPF(id);
/* 125 */     infCFe.setDest(dest);
/*     */ 
/* 127 */     infCFe.setDet(produtosCFe);
/*     */ 
/* 129 */     MP mp = new MP();
/* 130 */     mp.setcMP("1");
/* 131 */     mp.setvMP(this.janelaAC.getValorValorTotal().getText());
/* 132 */     infCFe.setMP(mp);
/*     */ 
/* 134 */     br.com.pirus.ac.modelos.cfeac.ValoresTotaisCFe total = new br.com.pirus.ac.modelos.cfeac.ValoresTotaisCFe();
/* 135 */     infCFe.setTotal(total);
/* 136 */     CFe cupom = new CFe(infCFe);
/* 137 */     return cupom.toString();
/*     */   }
/*     */ 
/*     */   private void desativarComponentes()
/*     */   {
/* 142 */     this.janelaAC.getValorReferencia().setEnabled(false);
/* 143 */     this.janelaAC.getValorReferencia().setEditable(false);
/* 144 */     this.janelaAC.getValorReferencia().setBackground(new Color(238, 238, 238));
/* 145 */     this.janelaAC.getValorQuantidade().setEnabled(false);
/* 146 */     this.janelaAC.getValorQuantidade().setEditable(false);
/* 147 */     this.janelaAC.getValorQuantidade().setBackground(new Color(238, 238, 238));
/* 148 */     this.janelaAC.getValorValorPago().setEnabled(false);
/* 149 */     this.janelaAC.getValorValorPago().setEditable(false);
/* 150 */     this.janelaAC.getValorValorPago().setBackground(new Color(238, 238, 238));
/* 151 */     this.janelaAC.getIdConsumidor().setEnabled(false);
/* 152 */     this.janelaAC.getIdConsumidor().setEditable(false);
/* 153 */     this.janelaAC.getIdConsumidor().setBackground(new Color(238, 238, 238));
/* 154 */     this.janelaAC.getBotaoCancelarCupom().setEnabled(false);
/* 155 */     this.janelaAC.getBotaoConsultarVenda().setEnabled(false);
/* 156 */     this.janelaAC.getBotaoFecharVenda().setEnabled(false);
/* 157 */     this.janelaAC.getBotaoInserir().setEnabled(false);
/*     */   }
/*     */ 
/*     */   private void ativarComponentes()
/*     */   {
/* 162 */     this.janelaAC.getValorReferencia().setEnabled(true);
/* 163 */     this.janelaAC.getValorReferencia().setEditable(true);
/* 164 */     this.janelaAC.getValorReferencia().setBackground(Color.white);
/* 165 */     this.janelaAC.getValorQuantidade().setEnabled(true);
/* 166 */     this.janelaAC.getValorQuantidade().setEditable(true);
/* 167 */     this.janelaAC.getValorQuantidade().setBackground(Color.white);
/* 168 */     this.janelaAC.getValorValorPago().setEnabled(true);
/* 169 */     this.janelaAC.getValorValorPago().setEditable(true);
/* 170 */     this.janelaAC.getValorValorPago().setBackground(Color.white);
/* 171 */     this.janelaAC.getIdConsumidor().setEnabled(true);
/* 172 */     this.janelaAC.getIdConsumidor().setEditable(true);
/* 173 */     this.janelaAC.getIdConsumidor().setBackground(Color.white);
/* 174 */     this.janelaAC.getBotaoCancelarCupom().setEnabled(true);
/* 175 */     this.janelaAC.getBotaoConsultarVenda().setEnabled(true);
/* 176 */     this.janelaAC.getBotaoFecharVenda().setEnabled(true);
/* 177 */     this.janelaAC.getBotaoInserir().setEnabled(true);
/*     */   }
/*     */ 
/*     */   public void tratarResultado(String retorno)
/*     */   {
/* 182 */     ativarComponentes();
/* 183 */     String[] retornoArray = (String[])null;
/* 184 */     if (retorno.indexOf("|") != -1)
/* 185 */       retornoArray = ControleDados.quebrarString(retorno, "|");
/* 186 */     else if (retorno.length() > 0)
/* 187 */       JOptionPane.showMessageDialog(null, retorno);
/* 188 */     if (retornoArray != null)
/*     */     {
/* 190 */       JOptionPane.showMessageDialog(null, retornoArray[3]);
/* 191 */       if (retornoArray.length >= 9)
/* 192 */         ControleArquivos.escreverBytesArquivo("C:/AC/Cancelamento/infCanc.txt", retornoArray[8].getBytes());
/* 193 */       if (retornoArray.length >= 6)
/*     */       {
/* 195 */         byte[] c = Base64.decode(retornoArray[6]);
/* 196 */         ControleArquivos.escreverBytesArquivo("C:/AC/lastCFe.xml", c);
/*     */       }
/* 198 */       if (retornoArray[1].equals("06000"))
/*     */       {
/* 200 */         finalizar();
/*     */ 
/* 202 */         JOptionPane.showMessageDialog(null, "Cupom enviado à impressora.");
/* 203 */         imprimir();
/*     */       }
/*     */ 
/* 206 */       if (retornoArray[5].length() > 0)
/* 207 */         JOptionPane.showMessageDialog(null, "ATENÇÃO!\nVocê recebeu a seguinte mensagem da SEFAZ:\n" + retornoArray[5]);
/*     */     }
/*     */     else {
/* 210 */       finalizar();
/* 211 */       JOptionPane.showMessageDialog(null, retorno);
/*     */     }
/* 213 */     finalizar();
/*     */   }
/*     */ 
/*     */   private void finalizar()
/*     */   {
/* 218 */     this.janelaAC.getValorQuantidade().setText("");
/* 219 */     this.janelaAC.getValorReferencia().setText("");
/* 220 */     this.janelaAC.getValorValorPago().setText("");
/* 221 */     this.janelaAC.getValorValorTotal().setText("");
/* 222 */     this.janelaAC.getValorValorUnitario().setText("");
/* 223 */     this.janelaAC.getValorTroco().setText("");
/* 224 */     this.janelaAC.getIdConsumidor().setText("");
/* 225 */     this.janelaAC.getDadosNome().setText("");
/* 226 */     this.janelaAC.getValorQuantidadeItensTotal().setText("");
/* 227 */     int qtdLinhas = this.janelaAC.getQuantidadeLinhasTabela();
/* 228 */     for (int i = 0; i < qtdLinhas; i++)
/*     */     {
/* 230 */       this.janelaAC.removeLinha(0);
/*     */     }
/* 232 */     this.janelaAC.dadosVenda.setText(Utils.gerarNumVenda());
/*     */   }
/*     */ 
/*     */   private void imprimir()
/*     */   {
/*     */     try
/*     */     {
/* 239 */       String cupom = ControleArquivos.lerBytesArquivo("C:/AC/lastCFe.xml");
/* 240 */       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 241 */       dbf.setNamespaceAware(true);
/*     */ 
/* 243 */       DocumentBuilder db = dbf.newDocumentBuilder();
/* 244 */       String xml = cupom;
/* 245 */       ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
/* 246 */       Document doc = db.parse(is);
/* 247 */       NodeList raizes = doc.getChildNodes();
/* 248 */       Node raiz = raizes.item(0);
/* 249 */       CFeImpressao impressao = new CFeImpressao(raiz);
/* 250 */       String nomeFantasia = impressao.getInfCFe().getEmit().getxFant();
/* 251 */       String razao = impressao.getInfCFe().getEmit().getxNome();
/* 252 */       String CNPJ = impressao.getInfCFe().getEmit().getCNPJ();
/* 253 */       String IE = impressao.getInfCFe().getEmit().getIE();
/* 254 */       String IM = impressao.getInfCFe().getEmit().getIM();
/* 255 */       String logradouro = impressao.getInfCFe().getEmit().getEnderEmit().getxLgr();
/* 256 */       String nro = impressao.getInfCFe().getEmit().getEnderEmit().getNro();
/* 257 */       String bairro = impressao.getInfCFe().getEmit().getEnderEmit().getxBairro();
/* 258 */       String cpl = impressao.getInfCFe().getEmit().getEnderEmit().getxCpl();
/* 259 */       String mun = impressao.getInfCFe().getEmit().getEnderEmit().getxMun();
/* 260 */       String nCFe = impressao.getInfCFe().getIde().getnCFe();
/* 261 */       String destinatario = impressao.getInfCFe().getDest().getCPF();
/* 262 */       if (destinatario == null)
/* 263 */         destinatario = impressao.getInfCFe().getDest().getCNPJ();
/* 264 */       String endereco = "";
/* 265 */       if (logradouro != null)
/* 266 */         endereco = endereco + logradouro;
/* 267 */       if (nro != null)
/* 268 */         endereco = endereco + " " + nro;
/* 269 */       if (cpl != null)
/* 270 */         endereco = endereco + " " + cpl;
/* 271 */       if (bairro != null)
/* 272 */         endereco = endereco + " " + bairro;
/* 273 */       if (mun != null)
/* 274 */         endereco = endereco + " " + mun;
/* 275 */       String cabecalho = "";
/* 276 */       if (nomeFantasia != null)
/* 277 */         cabecalho = cabecalho + nomeFantasia;
/* 278 */       if (razao != null)
/* 279 */         cabecalho = cabecalho + "\r\n" + razao;
/* 280 */       if (endereco.length() > 0)
/* 281 */         cabecalho = cabecalho + "\r\n" + endereco;
/* 282 */       cabecalho = cabecalho + "\r\n";
/* 283 */       if (CNPJ != null)
/* 284 */         cabecalho = cabecalho + "CNPJ " + CNPJ;
/* 285 */       if (IE != null)
/* 286 */         cabecalho = cabecalho + " IE " + IE;
/* 287 */       if (IM != null)
/* 288 */         cabecalho = cabecalho + " IM " + IM;
/* 289 */       cabecalho = cabecalho + "\r\n..................................................";
/* 290 */       cabecalho = cabecalho + "\r\nExtrato No. " + nCFe;
/* 291 */       cabecalho = cabecalho + "\r\nCUPOM FISCAL ELETRONICO";
/* 292 */       cabecalho = cabecalho + "\r\n..................................................";
/* 293 */       if (destinatario != null)
/*     */       {
/* 295 */         cabecalho = cabecalho + "\r\nCPF/CNPJ do Consumidor: " + destinatario;
/* 296 */         cabecalho = cabecalho + "\r\n..................................................";
/*     */       }
/* 298 */       cabecalho = cabecalho + "\r\n# |COD|DESC|QTD|UN|VL UNIT R$|ST|ALIQ|VL ITEM R$";
/* 299 */       String corpo = "";
/* 300 */       Vector produtos = impressao.getInfCFe().getDet();
/* 301 */       for (int i = 0; i < produtos.size(); i++)
/*     */       {
/* 303 */         String atual = "";
/* 304 */         String numero = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getNItem();
/* 305 */         String codigo = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getProd().getcProd();
/* 306 */         String descricao = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getProd().getxProd();
/* 307 */         String qtd = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getProd().getqCom();
/* 308 */         String un = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getProd().getuCom();
/* 309 */         String vUn = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getProd().getvUnCom();
/* 310 */         String ST = getST((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i));
/* 311 */         String ALIQ = getAliq((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i));
/* 312 */         String valor = ((br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe)produtos.get(i)).getProd().getvItem();
/* 313 */         atual = atual + "\r\n" + numero + " " + codigo + " " + descricao + " " + qtd + " " + un + " " + vUn + " " + ST + " " + ALIQ + " " + valor;
/* 314 */         corpo = corpo + atual;
/*     */       }
/* 316 */       String total = impressao.getInfCFe().getTotal().getICMSTot().getvCFe();
/* 317 */       String nomeAdquirinte = impressao.getInfCFe().getDest().getxNome();
/* 318 */       corpo = corpo + "\r\n\r\nTOTAL                                   " + total;
/* 319 */       corpo = corpo + "\r\n\"ICMS a ser recolhido conforme LC 123/2006 - Simples Nacional\"";
/* 320 */       corpo = corpo + "\r\n..................................................";
/* 321 */       corpo = corpo + "\r\nDEST";
/* 322 */       if (nomeAdquirinte != null)
/* 323 */         corpo = corpo + "\r\n" + nomeAdquirinte;
/* 324 */       corpo = corpo + "\r\n..................................................";
/* 325 */       String rodape = "";
/* 326 */       String data = impressao.getInfCFe().getIde().getdEmi();
/* 327 */       String hora = impressao.getInfCFe().getIde().gethEmi();
/* 328 */       String idCFe = impressao.getInfCFe().getId().substring(3);
/* 329 */       System.out.println(idCFe);
/* 330 */       String novoidCFe = inserirChar(4, idCFe, " ");
/* 331 */       rodape = rodape + "\r\n" + data + " " + hora;
/* 332 */       rodape = rodape + "\r\n" + novoidCFe;
/* 333 */       String vlrImp = cabecalho + corpo + rodape;
/* 334 */       new PrintCFe(vlrImp, idCFe);
/*     */     }
/*     */     catch (Exception e) {
/* 337 */       e.printStackTrace();
/* 338 */       JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getAliq(br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe detalhamentoProdutosCFe)
/*     */   {
/* 344 */     InformacoesICMS infICMS = detalhamentoProdutosCFe.getImposto().getICMS();
/* 345 */     ICMS00 i00 = infICMS.getICMS00();
/* 346 */     ICMS40 i40 = infICMS.getICMS40();
/* 347 */     ICMSSN102 i102 = infICMS.getICMSSN102();
/* 348 */     ICMSSN900 i900 = infICMS.getICMSSN900();
/* 349 */     if (i00 != null)
/*     */     {
/* 351 */       return i00.getpICMS() + "%";
/* 352 */     }if (i40 != null)
/*     */     {
/* 354 */       return "0%";
/* 355 */     }if (i102 != null)
/*     */     {
/* 357 */       return "0%";
/* 358 */     }if (i900 != null)
/*     */     {
/* 360 */       return "0%";
/*     */     }
/* 362 */     return "0%";
/*     */   }
/*     */ 
/*     */   private String getST(br.com.pirus.ac.modelos.cfecompleto.DetalhamentoProdutosCFe detalhamentoProdutosCFe)
/*     */   {
/* 367 */     InformacoesICMS infICMS = detalhamentoProdutosCFe.getImposto().getICMS();
/* 368 */     ICMS00 i00 = infICMS.getICMS00();
/* 369 */     ICMS40 i40 = infICMS.getICMS40();
/* 370 */     ICMSSN102 i102 = infICMS.getICMSSN102();
/* 371 */     ICMSSN900 i900 = infICMS.getICMSSN900();
/* 372 */     if (i00 != null)
/*     */     {
/* 374 */       String CST = i00.getCST();
/* 375 */       if (CST.equals("00"))
/*     */       {
/* 377 */         return "T";
/* 378 */       }if (CST.equals("20"))
/*     */       {
/* 380 */         return "T";
/* 381 */       }if (CST.equals("90"))
/*     */       {
/* 383 */         return "T";
/*     */       }
/* 385 */     } else if (i40 != null)
/*     */     {
/* 387 */       String CST = i40.getCST();
/* 388 */       if (CST.equals("40"))
/*     */       {
/* 390 */         return "I";
/* 391 */       }if (CST.equals("41"))
/*     */       {
/* 393 */         return "N";
/* 394 */       }if (CST.equals("50"))
/*     */       {
/* 396 */         return "N";
/* 397 */       }if (CST.equals("60"))
/*     */       {
/* 399 */         return "F";
/*     */       }
/* 401 */     } else if (i102 != null)
/*     */     {
/* 403 */       String CST = i102.getCSOSN();
/* 404 */       if (CST.equals("102"))
/*     */       {
/* 406 */         return "T";
/* 407 */       }if (CST.equals("300"))
/*     */       {
/* 409 */         return "N";
/* 410 */       }if (CST.equals("500"))
/*     */       {
/* 412 */         return "F";
/*     */       }
/* 414 */     } else if (i900 != null)
/*     */     {
/* 416 */       return "T";
/*     */     }
/* 418 */     return null;
/*     */   }
/*     */ 
/*     */   private String inserirChar(int espaco, String valor, String caracter)
/*     */   {
/* 423 */     int start = 0;
/* 424 */     String novoValor = "";
/* 425 */     while (start + espaco < valor.length())
/*     */     {
/* 427 */       novoValor = novoValor + valor.substring(start, start + espaco) + caracter;
/* 428 */       start += espaco;
/*     */     }
/* 430 */     novoValor = novoValor + valor.substring(start, start + espaco);
/* 431 */     return novoValor;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleFecharVenda
 * JD-Core Version:    0.6.2
 */