package br.com.pirus.ac.comunicacao;

import com.sun.jna.Library;

public abstract interface FuncoesDLL extends Library
{
  public abstract String EnviarDadosVenda(int paramInt, String paramString1, String paramString2);

  public abstract String CancelarUltimaVenda(int paramInt, String paramString1, String paramString2, String paramString3);

  public abstract String ConsultarSAT(int paramInt);

  public abstract String TesteFimAFim(int paramInt, String paramString1, String paramString2);

  public abstract String ConsultarNumeroSessao(int paramInt1, String paramString, int paramInt2);

  public abstract String DesligarSAT();
}

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.comunicacao.FuncoesDLL
 * JD-Core Version:    0.6.2
 */