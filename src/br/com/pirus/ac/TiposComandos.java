package br.com.pirus.ac;

public abstract interface TiposComandos
{
  public static final String COMANDO_EMITIR_NOTA = "S02";
  public static final String COMANDO_CANCELA_NOTA = "S03";
  public static final String COMANDO_PING = "S04";
  public static final String COMANDO_CONSULTA = "S06";
  public static final String COMANDO_CONSULTA_SESSAO = "S07";
  public static final String COMANDO_CONFIGURAR_SAT = "S08";
  public static final String COMANDO_EDITAR_ASSINATURA = "S09";
  public static final String COMANDO_ATUALIZAR_SAT = "S10";
  public static final String COMANDO_COLSULTAR_LOGS = "S11";
  public static final String RETORNO_COMANDO_EMITIR_NOTA = "P02";
  public static final String RETORNO_COMANDO_CANCELA_NOTA = "P03";
  public static final String RETORNO_COMANDO_PING = "P04";
  public static final String RETORNO_COMANDO_CONSULTA = "P06";
  public static final String RETORNO_COMANDO_CONSULTA_SESSAO = "P07";
  public static final String RETORNO_COMANDO_CONFIGURAR_SAT = "P08";
  public static final String RETORNO_COMANDO_EDITAR_ASSINATURA = "P09";
  public static final String RETORNO_COMANDO_ATUALIZAR_SAT = "P10";
  public static final String RETORNO_COMANDO_CONSULTAR_LOGS = "P11";
}

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.TiposComandos
 * JD-Core Version:    0.6.2
 */