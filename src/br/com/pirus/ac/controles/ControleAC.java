/*     */ package br.com.pirus.ac.controles;
/*     */ 
/*     */ import br.com.pirus.ac.comunicacao.FuncoesDLL;
/*     */ import br.com.pirus.ac.interfaces.ControleACListener;
/*     */ import br.com.pirus.ac.utils.Utils;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.xml.internal.messaging.saaj.util.Base64;
/*     */ import java.util.Calendar;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class ControleAC
/*     */ {
/* 197 */   private FuncoesDLL dll = (FuncoesDLL)Native.loadLibrary("SAT", FuncoesDLL.class);
/*     */ 
/* 199 */   private String resultado = null;
/*     */ 
/* 201 */   private long tempoResposta = 0L;
/*     */ 
/*     */   public String processarComandoPing()
/*     */   {
/*  16 */     this.resultado = null;
/*  17 */     new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*  21 */         ControleLogs.logar("------------- PINGAR -------------");
/*     */         try
/*     */         {
/*  24 */           ControleAC.this.resultado = ControleAC.this.dll.ConsultarSAT(ControleAC.getRandom(6));
/*     */         }
/*     */         catch (Exception e) {
/*  27 */           ControleLogs.logar("Falha no Driver do SAT-CFe.");
/*     */         }
/*  29 */         ControleLogs.logar("------------- FIM PINGAR -------------");
/*     */       }
/*     */     }).start();
/*  32 */     aguardaRecebimentoSincrono(30000L);
/*  33 */     return Utils.tratarResultadoPing(this.resultado);
/*     */   }
/*     */ 
/*     */   public void processarComandoPing(ControleACListener janela)
/*     */   {
/*  38 */     this.resultado = null;
/*  39 */     this.tempoResposta = 0L;
/*  40 */     ControleLogs.logar("------------- PINGAR -------------");
/*  41 */     long inicio = Calendar.getInstance().getTimeInMillis();
/*     */     try
/*     */     {
/*  44 */       if (ControleArquivos.existeArquivo("C:/SAT/SAT.dll"))
/*  45 */         this.resultado = this.dll.ConsultarSAT(getRandom(6));
/*     */       else
/*  47 */         throw new Exception();
/*     */     }
/*     */     catch (Exception e) {
/*  50 */       ControleLogs.logar("Falha no Driver do SAT-CFe.");
/*  51 */       return;
/*     */     }
/*  53 */     this.tempoResposta = (Calendar.getInstance().getTimeInMillis() - inicio);
/*  54 */     ControleLogs.logar("------------- FIM PINGAR -------------");
/*  55 */     if (janela != null)
/*  56 */       janela.tratarResultado(this.resultado);
/*     */   }
/*     */ 
/*     */   public void processarComandoDesligarSAT(ControleACListener janela)
/*     */   {
/*  61 */     this.resultado = null;
/*  62 */     this.tempoResposta = 0L;
/*  63 */     ControleLogs.logar("------------- DESLIGAR SAT -------------");
/*  64 */     long inicio = Calendar.getInstance().getTimeInMillis();
/*     */     try
/*     */     {
/*  67 */       if (ControleArquivos.existeArquivo("C:/SAT/SAT.dll"))
/*  68 */         this.resultado = this.dll.DesligarSAT();
/*     */       else
/*  70 */         throw new Exception();
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       ControleLogs.logar("Falha no Driver do SAT-CFe.");
/*  74 */       return;
/*     */     }
/*  76 */     this.tempoResposta = (Calendar.getInstance().getTimeInMillis() - inicio);
/*  77 */     ControleLogs.logar("------------- FIM DESLIGAR SAT -------------");
/*  78 */     if (janela != null)
/*  79 */       janela.tratarResultado(this.resultado);
/*     */   }
/*     */ 
/*     */   public void processarComandoEmitirCFe(ControleACListener janela, String codigoAtivacao, String dados)
/*     */   {
/*  84 */     this.resultado = null;
/*  85 */     this.tempoResposta = 0L;
/*  86 */     ControleLogs.logar("-------------EMITIR CFE-------------");
/*  87 */     String aviso = null;
/*  88 */     Integer numeroSessao = getRandom(6);
/*  89 */     long inicio = Calendar.getInstance().getTimeInMillis();
/*     */     try
/*     */     {
/*  92 */       ControleArquivos.escreverCaracteresArquivo("c:/cfe.txt", dados.toCharArray());
/*  93 */       this.resultado = this.dll.EnviarDadosVenda(numeroSessao, codigoAtivacao, dados);
/*     */     }
/*     */     catch (Exception e) {
/*  96 */       ControleLogs.logar("Falha no Driver do SAT-CFe.");
/*  97 */       return;
/*     */     }
/*  99 */     this.tempoResposta = (Calendar.getInstance().getTimeInMillis() - inicio);
/* 100 */     ControleLogs.logar("-------------FIM EMITIR CFE-------------");
/* 101 */     String[] partes = ControleDados.quebrarString(this.resultado, "|");
/* 102 */     if ((this.resultado.startsWith("06000")) && (partes.length == 9))
/*     */     {
/* 104 */       String doc = Base64.base64Decode(partes[5]);
/* 105 */       String vCFe = doc.substring(doc.indexOf("<vCFe>") + "<vCFe>".length(), doc.indexOf("</vCFe>"));
/* 106 */       String chave = partes[8];
/* 107 */       ControleArquivos.escreverCaracteresArquivo("C:/AC/Cancelamento/infCanc.txt", (chave + "|" + vCFe).toCharArray());
/* 108 */       ControleArquivos.escreverCaracteresArquivo("C:/AC/lastCFe.xml", doc.toCharArray());
/*     */     }
/* 110 */     ControleArquivos.escreverCaracteresArquivo("C:/AC/Sessoes/" + numeroSessao + ".txt", this.resultado.toCharArray());
/* 111 */     ControleArquivos.escreverCaracteresArquivo("C:/AC/Sessoes/sessao.txt", (""+numeroSessao).toCharArray() );
/* 112 */     if (janela != null)
/* 113 */       janela.tratarResultado(this.resultado);
/*     */   }
/*     */ 
/*     */   public void processarComandoCancelarCFe(ControleACListener janela, String codigoAtivacao, String chaveAcesso, String dados)
/*     */   {
/* 118 */     this.resultado = null;
/* 119 */     this.tempoResposta = 0L;
/* 120 */     ControleLogs.logar("-------------CANCELAR CFE-------------");
/* 121 */     long inicio = Calendar.getInstance().getTimeInMillis();
/*     */     try
/*     */     {
/* 124 */       this.resultado = this.dll.CancelarUltimaVenda(getRandom(6), codigoAtivacao, chaveAcesso, dados);
/*     */     }
/*     */     catch (Exception e) {
/* 127 */       ControleLogs.logar("Falha no Driver do SAT-CFe.");
/* 128 */       return;
/*     */     }
/* 130 */     this.tempoResposta = (Calendar.getInstance().getTimeInMillis() - inicio);
/* 131 */     ControleLogs.logar("-------------FIM CANCELAR CFE-------------");
/* 132 */     if (janela != null)
/* 133 */       janela.tratarResultado(this.resultado);
/*     */   }
/*     */ 
/*     */   public void processarComandoConsultarCFe(ControleACListener janela, String codigoAtivacao, int numeroSessao)
/*     */   {
/* 138 */     this.resultado = null;
/* 139 */     this.tempoResposta = 0L;
/* 140 */     ControleLogs.logar("-------------CONSULTAR CFE-------------");
/* 141 */     long inicio = Calendar.getInstance().getTimeInMillis();
/*     */     try
/*     */     {
/* 144 */       this.resultado = this.dll.ConsultarNumeroSessao(getRandom(6), codigoAtivacao, numeroSessao);
/*     */     }
/*     */     catch (Exception e) {
/* 147 */       ControleLogs.logar("Falha no Driver do SAT-CFe.");
/* 148 */       return;
/*     */     }
/* 150 */     this.tempoResposta = (Calendar.getInstance().getTimeInMillis() - inicio);
/* 151 */     ControleLogs.logar("-------------FIM CONSULTAR CFE-------------");
/* 152 */     if (this.resultado.startsWith("11000"))
/*     */     {
/* 154 */       ControleArquivos.escreverCaracteresArquivo("C:/AC/Sessoes/" + numeroSessao + ".txt", this.resultado.substring(this.resultado.indexOf("06")).toCharArray());
/*     */     }
/* 156 */     if (janela != null)
/* 157 */       janela.tratarResultado(this.resultado);
/*     */   }
/*     */ 
/*     */   public static int getRandom(int tamanho)
/*     */   {
/* 162 */     int max = 1;
/* 163 */     for (int i = 0; i < tamanho; i++)
/* 164 */       max *= 10;
/* 165 */     int resultado = new Random().nextInt(max);
/* 166 */     if (resultado >= max / 10) {
/* 167 */       return resultado;
/*     */     }
/* 169 */     return getRandom(tamanho);
/*     */   }
/*     */ 
/*     */   private String aguardaRecebimentoSincrono(long tempo)
/*     */   {
/*     */     try
/*     */     {
/* 176 */       long tempoAtual = System.currentTimeMillis();
/* 177 */       long t0 = tempoAtual;
/* 178 */       while ((tempoAtual - t0 < tempo) && (this.resultado == null))
/*     */       {
/* 180 */         Thread.sleep(200L);
/* 181 */         tempoAtual = System.currentTimeMillis();
/*     */       }
/* 183 */       if (this.resultado == null)
/* 184 */         this.resultado = "Timeout.";
/*     */     }
/*     */     catch (Exception e) {
/* 187 */       this.resultado = "Timeout.";
/*     */     }
/* 189 */     return this.resultado;
/*     */   }
/*     */ 
/*     */   public long getTempoResposta()
/*     */   {
/* 194 */     return this.tempoResposta;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleAC
 * JD-Core Version:    0.6.2
 */