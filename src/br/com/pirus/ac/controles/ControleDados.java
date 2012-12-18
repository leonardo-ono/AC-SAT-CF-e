/*     */ package br.com.pirus.ac.controles;
/*     */ 
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class ControleDados
/*     */ {
/*     */   public static String byteToHex(byte[] buf, int off, int len)
/*     */   {
/*  24 */     StringBuffer strbuf = new StringBuffer(buf.length * 2);
/*  25 */     for (int i = off; i < len; i++)
/*     */     {
/*  27 */       if ((buf[i] & 0xFF) < 16)
/*  28 */         strbuf.append("0");
/*  29 */       strbuf.append(Long.toString(buf[i] & 0xFF, 16));
/*     */     }
/*  31 */     return strbuf.toString();
/*     */   }
/*     */ 
/*     */   private static String getData(boolean invertido)
/*     */   {
/*  43 */     Calendar cal = Calendar.getInstance();
/*  44 */     String mes = String.valueOf(cal.get(2) + 1);
/*  45 */     String dia = String.valueOf(cal.get(5));
/*  46 */     String ano = String.valueOf(cal.get(1));
/*  47 */     if (dia.length() < 2)
/*     */     {
/*  49 */       dia = "0" + dia;
/*     */     }
/*  51 */     if (mes.length() < 2)
/*     */     {
/*  53 */       mes = "0" + mes;
/*     */     }
/*  55 */     if (invertido) {
/*  56 */       return ano + mes + dia;
/*     */     }
/*  58 */     return dia + mes + ano;
/*     */   }
/*     */ 
/*     */   private static String getHorario()
/*     */   {
/*  70 */     Calendar cal = Calendar.getInstance();
/*  71 */     String horas = String.valueOf(cal.get(11));
/*  72 */     String minutos = String.valueOf(cal.get(12));
/*  73 */     String segundos = String.valueOf(cal.get(13));
/*  74 */     if (horas.length() < 2)
/*     */     {
/*  76 */       horas = "0" + horas;
/*     */     }
/*  78 */     if (minutos.length() < 2)
/*     */     {
/*  80 */       minutos = "0" + minutos;
/*     */     }
/*  82 */     if (segundos.length() < 2)
/*     */     {
/*  84 */       segundos = "0" + segundos;
/*     */     }
/*  86 */     return horas + minutos + segundos;
/*     */   }
/*     */ 
/*     */   public static String getTimeStamp()
/*     */   {
/*  96 */     return getData(true) + getHorario();
/*     */   }
/*     */ 
/*     */   public static int verificarOcorrenciasCaractere(String conteudo, char caractere)
/*     */   {
/* 109 */     char[] caracteres = conteudo.toCharArray();
/* 110 */     int quantia = 0;
/* 111 */     for (int i = 0; i <= conteudo.length() - 1; i++)
/* 112 */       if (caracteres[i] == caractere)
/* 113 */         quantia++;
/* 114 */     return quantia;
/*     */   }
/*     */ 
/*     */   public static String[] quebrarString(String conteudo, String delimitador)
/*     */   {
/* 128 */     String cont = conteudo;
/* 129 */     Vector linhas = new Vector();
/* 130 */     while (cont.indexOf(delimitador) != -1)
/*     */     {
/* 132 */       linhas.addElement(cont.substring(0, cont.indexOf(delimitador)));
/* 133 */       cont = cont.substring(cont.indexOf(delimitador) + delimitador.length(), cont.length());
/*     */     }
/* 135 */     linhas.addElement(cont);
/* 136 */     String[] linhasFinal = new String[linhas.size()];
/* 137 */     for (int i = 0; i <= linhas.size() - 1; i++)
/*     */     {
/* 139 */       linhasFinal[i] = ((String)linhas.elementAt(i));
/*     */     }
/* 141 */     return linhasFinal;
/*     */   }
/*     */ 
/*     */   public static String preencheCom(String linha_a_preencher, String letra, int tamanho, int direcao)
/*     */   {
/* 157 */     if ((linha_a_preencher == null) || (linha_a_preencher.trim() == ""))
/*     */     {
/* 159 */       linha_a_preencher = "";
/*     */     }
/* 161 */     StringBuffer sb = new StringBuffer(linha_a_preencher);
/* 162 */     if (direcao == 1)
/*     */     {
/* 164 */       for (int i = sb.length(); i < tamanho; i++)
/*     */       {
/* 166 */         sb.insert(0, letra);
/*     */       }
/*     */     }
/* 169 */     else if (direcao == 2)
/*     */     {
/* 171 */       for (int i = sb.length(); i < tamanho; i++)
/*     */       {
/* 173 */         sb.append(letra);
/*     */       }
/*     */     }
/* 176 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static boolean isNumerico(String conteudo)
/*     */   {
/* 187 */     if (conteudo.length() == 0)
/* 188 */       return true;
/*     */     try
/*     */     {
/* 191 */       Integer.parseInt(conteudo);
/* 192 */       return true;
/*     */     }
/*     */     catch (NumberFormatException nfe) {
/*     */     }
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */   public static String replaceAll(String conteudo, String antigo, String novo)
/*     */   {
/* 211 */     while (conteudo.indexOf(antigo) != -1)
/*     */     {
/* 213 */       String conteudo1 = conteudo.substring(0, conteudo.indexOf(antigo));
/* 214 */       String conteudo2 = conteudo.substring(conteudo.indexOf(antigo) + antigo.length());
/* 215 */       conteudo = conteudo1 + novo + conteudo2;
/*     */     }
/* 217 */     return conteudo;
/*     */   }
/*     */ 
/*     */   public static long transformarDataEmMili(String data)
/*     */   {
/* 235 */     while (data.length() < 17)
/* 236 */       data = data + "0";
/* 237 */     Calendar calendario = Calendar.getInstance();
/* 238 */     calendario.set(1, Integer.parseInt(data.substring(0, 4)));
/* 239 */     calendario.set(2, -1 + Integer.parseInt(data.substring(4, 6)));
/* 240 */     calendario.set(5, Integer.parseInt(data.substring(6, 8)));
/* 241 */     calendario.set(11, Integer.parseInt(data.substring(8, 10)));
/* 242 */     calendario.set(12, Integer.parseInt(data.substring(10, 12)));
/* 243 */     calendario.set(13, Integer.parseInt(data.substring(12, 14)));
/* 244 */     calendario.set(14, Integer.parseInt(data.substring(14)));
/* 245 */     return calendario.getTime().getTime();
/*     */   }
/*     */ 
/*     */   public static boolean isVersaoNova(String versaoNova, String versaoAntiga, String delimitadorVersao)
/*     */   {
/* 259 */     String[] partesVersaoNova = quebrarString(versaoNova, delimitadorVersao);
/* 260 */     String[] partesVersaoAntiga = quebrarString(versaoAntiga, delimitadorVersao);
/* 261 */     int i = partesVersaoAntiga.length > partesVersaoNova.length ? partesVersaoAntiga.length : partesVersaoNova.length;
/* 262 */     int e = 0;
/* 263 */     while (e <= i)
/*     */     {
/* 266 */       if ((e >= partesVersaoAntiga.length) && (e >= partesVersaoNova.length))
/*     */       {
/* 268 */         return false;
/*     */       }
/*     */ 
/* 271 */       if (e >= partesVersaoAntiga.length)
/*     */       {
/* 273 */         int f = e;
/* 274 */         while (f < i)
/*     */         {
/* 277 */           if (!partesVersaoNova[f].equals("0"))
/* 278 */             return true;
/* 279 */           f++;
/*     */         }
/*     */ 
/* 282 */         return false;
/*     */       }
/*     */ 
/* 285 */       if (e >= partesVersaoNova.length)
/*     */       {
/* 287 */         return false;
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 293 */         if (Integer.parseInt(partesVersaoNova[e]) < Integer.parseInt(partesVersaoAntiga[e]))
/*     */         {
/* 295 */           return false;
/*     */         }
/* 297 */         if (Integer.parseInt(partesVersaoNova[e]) > Integer.parseInt(partesVersaoAntiga[e]))
/*     */         {
/* 299 */           return true;
/*     */         }
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 304 */         return false;
/*     */       }
/*     */ 
/* 307 */       e++;
/*     */     }
/* 309 */     return false;
/*     */   }
/*     */ 
/*     */   public static byte[] encodedByte(byte[] conteudo)
/*     */   {
/* 314 */     int count = 0;
/* 315 */     for (int i = 0; i < conteudo.length; i++)
/*     */     {
/* 317 */       if (conteudo[i] == 43)
/*     */       {
/* 319 */         count++;
/*     */       }
/*     */     }
/* 322 */     int tamanho = count * 2 + conteudo.length;
/* 323 */     byte[] byteEncoded = new byte[tamanho];
/* 324 */     int j = 0;
/* 325 */     for (int i = 0; i < conteudo.length; i++)
/*     */     {
/* 327 */       if (conteudo[i] == 43)
/*     */       {
/* 329 */         byteEncoded[j] = 37;
/* 330 */         j++;
/* 331 */         byteEncoded[j] = 50;
/* 332 */         j++;
/* 333 */         byteEncoded[j] = 98;
/* 334 */         j++;
/*     */       }
/*     */       else
/*     */       {
/* 338 */         byteEncoded[j] = conteudo[i];
/* 339 */         j++;
/*     */       }
/*     */     }
/* 342 */     return byteEncoded;
/*     */   }
/*     */ 
/*     */   public static boolean validarDouble(int tamanhoMinimo, int tamanhoMaximo, int TamanhoAposVirgula, String numero)
/*     */   {
/* 347 */     if (!eNumerico(numero))
/*     */     {
/* 349 */       return false;
/*     */     }
/*     */ 
/* 352 */     int index = numero.indexOf(".");
/* 353 */     if (index == -1)
/* 354 */       return false;
/* 355 */     String antes = numero.substring(0, index);
/* 356 */     String depois = numero.substring(index + 1);
/* 357 */     if ((antes.length() < tamanhoMinimo) || (antes.length() > tamanhoMaximo))
/* 358 */       return false;
/* 359 */     if (depois.length() != TamanhoAposVirgula)
/* 360 */       return false;
/* 361 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean validarCNPJCPF(String CNPJ)
/*     */   {
/* 366 */     if (!eNumerico(CNPJ))
/*     */     {
/* 368 */       return false;
/*     */     }
/* 370 */     if (CNPJ.length() == 11)
/*     */     {
/*     */       int d2;
/* 376 */       int d1 = d2 = 0;
/*     */       int digito2;
                int resto;
/* 377 */       int digito1 = digito2 = resto = 0;
/* 378 */       for (int n_Count = 1; n_Count < CNPJ.length() - 1; n_Count++)
/*     */       {
/* 380 */         int digitoCPF = Integer.valueOf(CNPJ.substring(n_Count - 1, n_Count)).intValue();
/* 381 */         d1 += (11 - n_Count) * digitoCPF;
/* 382 */         d2 += (12 - n_Count) * digitoCPF;
/*     */       }
/* 384 */       resto = d1 % 11;
/* 385 */       if (resto < 2)
/* 386 */         digito1 = 0;
/*     */       else
/* 388 */         digito1 = 11 - resto;
/* 389 */       d2 += 2 * digito1;
/* 390 */       resto = d2 % 11;
/* 391 */       if (resto < 2)
/* 392 */         digito2 = 0;
/*     */       else
/* 394 */         digito2 = 11 - resto;
/* 395 */       String nDigVerific = CNPJ.substring(CNPJ.length() - 2, CNPJ.length());
/* 396 */       String nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
/* 397 */       return nDigVerific.equals(nDigResult);
/*     */     }
/* 399 */     if (CNPJ.length() == 14)
/*     */     {
/* 401 */       int soma = 0;
/* 402 */       String cnpj_calc = CNPJ.substring(0, 12);
/* 403 */       char[] chr_cnpj = CNPJ.toCharArray();
/* 404 */       for (int i = 0; i < 4; i++)
/* 405 */         if ((chr_cnpj[i] - '0' >= 0) && (chr_cnpj[i] - '0' <= 9))
/* 406 */           soma += (chr_cnpj[i] - '0') * (6 - (i + 1));
/* 407 */       for (int i = 0; i < 8; i++)
/* 408 */         if ((chr_cnpj[(i + 4)] - '0' >= 0) && (chr_cnpj[(i + 4)] - '0' <= 9))
/* 409 */           soma += (chr_cnpj[(i + 4)] - '0') * (10 - (i + 1));
/* 410 */       int dig = 11 - soma % 11;
/* 411 */       cnpj_calc = cnpj_calc + ((dig == 10) || (dig == 11) ? "0" : Integer.toString(dig));
/* 412 */       soma = 0;
/* 413 */       for (int i = 0; i < 5; i++)
/* 414 */         if ((chr_cnpj[i] - '0' >= 0) && (chr_cnpj[i] - '0' <= 9))
/* 415 */           soma += (chr_cnpj[i] - '0') * (7 - (i + 1));
/* 416 */       for (int i = 0; i < 8; i++)
/* 417 */         if ((chr_cnpj[(i + 5)] - '0' >= 0) && (chr_cnpj[(i + 5)] - '0' <= 9))
/* 418 */           soma += (chr_cnpj[(i + 5)] - '0') * (10 - (i + 1));
/* 419 */       dig = 11 - soma % 11;
/* 420 */       cnpj_calc = cnpj_calc + ((dig == 10) || (dig == 11) ? "0" : Integer.toString(dig));
/* 421 */       return CNPJ.equals(cnpj_calc);
/*     */     }
/*     */ 
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean eNumerico(String valor)
/*     */   {
/*     */     try
/*     */     {
/* 431 */       Double.parseDouble(valor);
/* 432 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 436 */     return false;
/*     */   }
/*     */ 
/*     */   public static String formatarDouble(String numero, int minimo, int maximo, int casas)
/*     */   {
/* 442 */     String mascara = "";
/* 443 */     for (int i = 0; i < minimo; i++)
/* 444 */       mascara = mascara + "0";
/* 445 */     if (casas > 0)
/* 446 */       mascara = mascara + ".";
/* 447 */     for (int i = 0; i < casas; i++)
/* 448 */       mascara = mascara + "0";
/* 449 */     DecimalFormat df = new DecimalFormat(mascara);
/* 450 */     return df.format(Double.parseDouble(numero)).replace(",", ".");
/*     */   }
/*     */ 
/*     */   public static int contarOcorrencia(String alvo, String ocorrencia)
/*     */   {
/* 455 */     int pos = -1;
/* 456 */     int contagem = 0;
/*     */     while (true)
/*     */     {
/* 459 */       pos = alvo.indexOf(ocorrencia, pos + 1);
/* 460 */       if (pos < 0)
/*     */         break;
/* 462 */       contagem++;
/*     */     }
/* 464 */     return contagem;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleDados
 * JD-Core Version:    0.6.2
 */