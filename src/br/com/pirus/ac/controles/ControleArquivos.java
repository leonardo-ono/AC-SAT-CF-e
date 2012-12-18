/*     */ package br.com.pirus.ac.controles;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class ControleArquivos
/*     */ {
/*     */   public static synchronized String lerBytesArquivo(String caminho)
/*     */   {
/*  19 */     File arquivo = null;
/*  20 */     BufferedReader leitor = null;
/*     */     try
/*     */     {
/*  23 */       arquivo = new File("C:/Arquivos de programas/SAT-CFe/Aplicativo Comercial/" + caminho);
/*  24 */       int qtdBytesArquivo = (int)arquivo.length();

                if (arquivo.exists()) {
                    qtdBytesArquivo = (int)arquivo.length();
                }
/*  25 */       //if (qtdBytesArquivo > 0)
/*     */       {
/*  27 */         leitor = new BufferedReader(new FileReader(arquivo));
/*  28 */         char[] saida = new char[qtdBytesArquivo];
/*  29 */         leitor.read(saida);
/*  30 */         return new String(saida);
/*     */       }
/*     */ 
/*  34 */       //return "";
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  44 */         if (leitor != null)
/*     */         {
/*  46 */           leitor.close();
/*     */         }
/*     */       }
/*     */       catch (IOException localIOException3)
/*     */       {
/*     */       }
/*     */     }
/*  53 */     return "";
/*     */   }
/*     */ 
/*     */   public static synchronized boolean escreverCaracteresArquivo(String caminho, char[] b)
/*     */   {
/*  66 */     return escreverCaracteresArquivo(caminho, b, false);
/*     */   }
/*     */ 
/*     */   public static synchronized boolean escreverCaracteresArquivo(String caminho, char[] b, boolean concatenar)
/*     */   {
/*  84 */     File arquivo = null;
/*  85 */     BufferedWriter escritor = null;
/*     */     try
/*     */     {
/*  88 */       arquivo = new File("C:/Arquivos de programas/SAT-CFe/Aplicativo Comercial/" + caminho);
/*  89 */       if (!concatenar)
/*     */       {
/*  91 */         if (arquivo.exists())
/*     */         {
/*  93 */           arquivo.delete();
/*     */         }
/*  95 */         criarArquivo(caminho);
/*  96 */         escreverCaracteresArquivo(caminho, b, true);
/*     */       }while (true) { 
    
                    // return true;
/*     */ 
/*  99 */         if (!arquivo.exists())
/*     */         {
/* 101 */           criarArquivo(caminho);
/*     */         }
/* 103 */         escritor = new BufferedWriter(new FileWriter(arquivo));
/* 104 */         escritor.write(b);
/* 105 */         escritor.flush();
/* 106 */         escritor.close();
/*     */       }
/*     */     }
/*     */     catch (IOException localIOException1)
/*     */     {
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 116 */         if (escritor != null)
/*     */         {
/* 118 */           escritor.close();
/*     */         }
/*     */       }
/*     */       catch (IOException localIOException3)
/*     */       {
/*     */       }
/*     */     }
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   public static void escreverBytesArquivo(String caminho, byte[] b)
/*     */   {
/*     */     try
/*     */     {
/* 132 */       FileOutputStream fos = new FileOutputStream("C:/Arquivos de programas/SAT-CFe/Aplicativo Comercial/" + caminho);
/* 133 */       fos.write(b);
/* 134 */       fos.close();
/*     */     }
/*     */     catch (FileNotFoundException ex)
/*     */     {
/* 138 */       ControleLogs.logar("FileNotFoundException : " + ex);
/*     */     }
/*     */     catch (IOException ioe)
/*     */     {
/* 142 */       ControleLogs.logar("IOException : " + ioe);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static synchronized long tamanhoArquivo(String caminho)
/*     */   {
/* 148 */     File arquivo = null;
/* 149 */     arquivo = new File(caminho);
/* 150 */     return arquivo.length();
/*     */   }
/*     */ 
/*     */   public static synchronized boolean existeArquivo(String caminho)
/*     */   {
/* 162 */     File novoArquivo = null;
/* 163 */     novoArquivo = new File(caminho);
/* 164 */     return novoArquivo.exists();
/*     */   }
/*     */ 
/*     */   public static synchronized boolean excluirArquivo(String caminho)
/*     */   {
/* 176 */     File novoArquivo = null;
/* 177 */     novoArquivo = new File(caminho);
/* 178 */     return novoArquivo.delete();
/*     */   }
/*     */ 
/*     */   public static synchronized boolean criarArquivo(String caminho)
/*     */   {
/* 188 */     File novoArquivo = null;
/* 189 */     novoArquivo = new File(caminho);
/* 190 */     boolean resultado = false;
/*     */     try
/*     */     {
/* 193 */       resultado = novoArquivo.createNewFile();
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/* 198 */     return resultado;
/*     */   }
/*     */ 
/*     */   public static synchronized boolean criarDiretorio(String caminho)
/*     */   {
/* 208 */     File novoArquivo = null;
/* 209 */     novoArquivo = new File(caminho);
/* 210 */     return novoArquivo.mkdirs();
/*     */   }
/*     */ 
/*     */   public static synchronized String[] listarDiretorio(String caminho)
/*     */   {
/* 221 */     File dir = null;
/* 222 */     String[] lista = (String[])null;
/* 223 */     dir = new File(caminho);
/* 224 */     if (dir.exists())
/*     */     {
/* 226 */       if (dir.isDirectory())
/*     */       {
/* 228 */         lista = dir.list();
/*     */       }
/*     */     }
/* 231 */     return lista;
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleArquivos
 * JD-Core Version:    0.6.2
 */