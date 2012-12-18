/*     */ package br.com.pirus.ac.utils;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleArquivos;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Utils
/*     */ {
/* 159 */   private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
/*     */ 
/* 161 */   private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
/*     */ 
/*     */   public static String preencheCom(String linha_a_preencher, String letra, int tamanho, int direcao)
/*     */   {
/*  27 */     if ((linha_a_preencher == null) || (linha_a_preencher.trim() == ""))
/*     */     {
/*  29 */       linha_a_preencher = "";
/*     */     }
/*     */ 
/*  33 */     while (linha_a_preencher.contains(" "))
/*     */     {
/*  35 */       linha_a_preencher = linha_a_preencher.replaceAll(" ", " ").trim();
/*     */     }
/*     */ 
/*  38 */     linha_a_preencher = linha_a_preencher.replaceAll("[./-]", "");
/*  39 */     StringBuffer sb = new StringBuffer(linha_a_preencher);
/*  40 */     if (direcao == 1)
/*     */     {
/*  43 */       for (int i = sb.length(); i < tamanho; i++)
/*     */       {
/*  45 */         sb.insert(0, letra);
/*     */       }
/*     */     }
/*  48 */     else if (direcao == 2)
/*     */     {
/*  51 */       for (int i = sb.length(); i < tamanho; i++)
/*     */       {
/*  53 */         sb.append(letra);
/*     */       }
/*     */     }
/*  56 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String[] quebrarString(String conteudo, String delimitador)
/*     */   {
/*  61 */     String cont = conteudo;
/*  62 */     Vector linhas = new Vector();
/*  63 */     while (cont.indexOf(delimitador) != -1)
/*     */     {
/*  65 */       linhas.addElement(cont.substring(0, cont.indexOf(delimitador)));
/*  66 */       cont = cont.substring(cont.indexOf(delimitador) + delimitador.length(), cont.length());
/*     */     }
/*  68 */     linhas.addElement(cont);
/*  69 */     return (String[])linhas.toArray();
/*     */   }
/*     */ 
/*     */   private static int calcularDigito(String str, int[] peso)
/*     */   {
/*  74 */     int soma = 0;
/*  75 */     for (int indice = str.length() - 1; indice >= 0; indice--)
/*     */     {
/*  77 */       int digito = Integer.parseInt(str.substring(indice, indice + 1));
/*  78 */       soma += digito * peso[(peso.length - str.length() + indice)];
/*     */     }
/*  80 */     soma = 11 - soma % 11;
/*  81 */     return soma > 9 ? 0 : soma;
/*     */   }
/*     */ 
/*     */   public static boolean isValidCPF(String cpf)
/*     */   {
/*  86 */     if ((cpf == null) || (cpf.length() != 11))
/*  87 */       return false;
/*  88 */     Integer digito1 = Integer.valueOf(calcularDigito(cpf.substring(0, 9), pesoCPF));
/*  89 */     Integer digito2 = Integer.valueOf(calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF));
/*  90 */     return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
/*     */   }
/*     */ 
/*     */   public static boolean isValidCNPJ(String cnpj)
/*     */   {
/*  95 */     if ((cnpj == null) || (cnpj.length() != 14))
/*  96 */       return false;
/*  97 */     Integer digito1 = Integer.valueOf(calcularDigito(cnpj.substring(0, 12), pesoCNPJ));
/*  98 */     Integer digito2 = Integer.valueOf(calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ));
/*  99 */     return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
/*     */   }
/*     */ 
/*     */   public static String getSenha()
/*     */   {
/* 104 */     return ControleArquivos.lerBytesArquivo("C:/AC/sessao.txt");
/*     */   }
/*     */ 
/*     */   public static void setSenha(String senha)
/*     */   {
/* 109 */     ControleArquivos.escreverBytesArquivo("C:/AC/sessao.txt", senha.getBytes());
/*     */   }
/*     */ 
/*     */   public static String gerarNumVenda()
/*     */   {
/* 114 */     return null;
/*     */   }
/*     */ 
/*     */   public static String gerarSessao()
/*     */   {
/* 119 */     if (!ControleArquivos.existeArquivo("C:/AC/nVenda.txt"))
/*     */     {
/* 121 */       ControleArquivos.escreverCaracteresArquivo("C:/AC/nVenda.txt", "1".toCharArray());
/* 122 */       return "1";
/*     */     }
/*     */ 
/* 126 */     String conteudo = ControleArquivos.lerBytesArquivo("C:/AC/nVenda.txt");
/* 127 */     conteudo = "" + (Integer.parseInt(conteudo) + 1);
/* 128 */     ControleArquivos.escreverCaracteresArquivo("C:/AC/nVenda.txt", conteudo.toCharArray());
/* 129 */     return conteudo;
/*     */   }
/*     */ 
/*     */   public static String getNumVenda()
/*     */   {
/* 135 */     if (!ControleArquivos.existeArquivo("C:/AC/nVenda.txt"))
/*     */     {
/* 137 */       ControleArquivos.escreverCaracteresArquivo("C:/AC/nVenda.txt", "1".toCharArray());
/* 138 */       return "1";
/*     */     }
/*     */ 
/* 142 */     String conteudo = ControleArquivos.lerBytesArquivo("C:/AC/nVenda.txt");
/* 143 */     return conteudo;
/*     */   }
/*     */ 
/*     */   public static String tratarResultadoPing(String retorno)
/*     */   {
/* 149 */     if (retorno.indexOf("|") != -1)
/*     */     {
/* 151 */       return br.com.pirus.ac.controles.ControleDados.quebrarString(retorno, "|")[2];
/*     */     }
/*     */ 
/* 155 */     return retorno;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.utils.Utils
 * JD-Core Version:    0.6.2
 */