/*     */ package br.com.pirus.ac.modelos.cfecompleto;
/*     */ 
/*     */ import br.com.pirus.ac.controles.ControleDados;
/*     */ 
/*     */ public class ISSQNtot
/*     */ {
/* 155 */   private String vBC = null;
/*     */ 
/* 158 */   private String vISS = null;
/*     */ 
/* 161 */   private String vPIS = null;
/*     */ 
/* 164 */   private String vCOFINS = null;
/*     */ 
/* 167 */   private String vPISST = null;
/*     */ 
/* 170 */   private String vCOFINSST = null;
/*     */ 
/*     */   public ISSQNtot()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ISSQNtot(String vBC, String vISS, String vPIS, String vCOFINS, String vPISST, String vCOFINSST)
/*     */   {
/*  33 */     this();
/*  34 */     this.vBC = vBC;
/*  35 */     this.vISS = vISS;
/*  36 */     this.vPIS = vPIS;
/*  37 */     this.vCOFINS = vCOFINS;
/*  38 */     this.vPISST = vPISST;
/*  39 */     this.vCOFINSST = vCOFINSST;
/*     */   }
/*     */ 
/*     */   public String getvBC()
/*     */   {
/*  47 */     return this.vBC;
/*     */   }
/*     */ 
/*     */   public void setvBC(String vBC)
/*     */   {
/*  55 */     this.vBC = vBC;
/*     */   }
/*     */ 
/*     */   public String getvISS()
/*     */   {
/*  63 */     return this.vISS;
/*     */   }
/*     */ 
/*     */   public void setvISS(String vISS)
/*     */   {
/*  71 */     this.vISS = vISS;
/*     */   }
/*     */ 
/*     */   public String getvPIS()
/*     */   {
/*  79 */     return this.vPIS;
/*     */   }
/*     */ 
/*     */   public void setvPIS(String vPIS)
/*     */   {
/*  87 */     this.vPIS = vPIS;
/*     */   }
/*     */ 
/*     */   public String getvCOFINS()
/*     */   {
/*  95 */     return this.vCOFINS;
/*     */   }
/*     */ 
/*     */   public void setvCOFINS(String vCOFINS)
/*     */   {
/* 103 */     this.vCOFINS = vCOFINS;
/*     */   }
/*     */ 
/*     */   public String getvPISST()
/*     */   {
/* 111 */     return this.vPISST;
/*     */   }
/*     */ 
/*     */   public void setvPISST(String vPISST)
/*     */   {
/* 119 */     this.vPISST = vPISST;
/*     */   }
/*     */ 
/*     */   public String getvCOFINSST()
/*     */   {
/* 127 */     return this.vCOFINSST;
/*     */   }
/*     */ 
/*     */   public void setvCOFINSST(String vCOFINSST)
/*     */   {
/* 135 */     this.vCOFINSST = vCOFINSST;
/*     */   }
/*     */ 
/*     */   public void toString(StringBuffer retorno)
/*     */   {
/* 140 */     if (this.vBC != null)
/* 141 */       retorno.append("<vBC>").append(ControleDados.formatarDouble(this.vBC, 1, 15, 2)).append("</vBC>");
/* 142 */     if (this.vISS != null)
/* 143 */       retorno.append("<vISS>").append(ControleDados.formatarDouble(this.vISS, 1, 15, 2)).append("</vISS>");
/* 144 */     if (this.vPIS != null)
/* 145 */       retorno.append("<vPIS>").append(ControleDados.formatarDouble(this.vPIS, 1, 15, 2)).append("</vPIS>");
/* 146 */     if (this.vCOFINS != null)
/* 147 */       retorno.append("<vCOFINS>").append(ControleDados.formatarDouble(this.vCOFINS, 1, 15, 2)).append("</vCOFINS>");
/* 148 */     if (this.vPISST != null)
/* 149 */       retorno.append("<vPISST>").append(ControleDados.formatarDouble(this.vPISST, 1, 15, 2)).append("</vPISST>");
/* 150 */     if (this.vCOFINSST != null)
/* 151 */       retorno.append("<vCOFINSST>").append(ControleDados.formatarDouble(this.vCOFINSST, 1, 15, 2)).append("</vCOFINSST>");
/*     */   }
/*     */ }

/* Location:           C:\Arquivos de programas\SAT-CFe\Aplicativo Comercial\AC.jar
 * Qualified Name:     br.com.pirus.ac.modelos.cfecompleto.ISSQNtot
 * JD-Core Version:    0.6.2
 */