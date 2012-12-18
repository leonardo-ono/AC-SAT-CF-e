/*    */ package br.com.pirus.ac.controles;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class ControleLogs
/*    */ {
/*    */   public static void logar(Object texto)
/*    */   {
/* 13 */     System.out.println("[" + makeNewTrack() + "]:" + texto);
/*    */   }
/*    */ 
/*    */   public static String makeNewTrack()
/*    */   {
/* 23 */     Calendar c = Calendar.getInstance();
/* 24 */     String track = c.get(1) + " " + (c.get(2) < 10 ? "0" + c.get(2) : new StringBuilder().append(c.get(2)).toString()) + " " + (c.get(5) < 10 ? "0" + c.get(5) : new StringBuilder().append(c.get(5)).toString()) + " " + (c.get(11) < 10 ? "0" + c.get(11) : new StringBuilder().append(c.get(11)).toString()) + " " + (c.get(12) < 10 ? "0" + c.get(12) : new StringBuilder().append(c.get(12)).toString()) + " " + (c.get(13) < 10 ? "0" + c.get(13) : new StringBuilder().append(c.get(13)).toString());
/* 25 */     return track;
/*    */   }
/*    */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.controles.ControleLogs
 * JD-Core Version:    0.6.2
 */