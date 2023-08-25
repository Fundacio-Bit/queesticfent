package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.TraduccioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class TraduccioForm extends queesticfentBaseForm {
  
  private TraduccioJPA traduccio;
  
  public TraduccioForm() {
  }
  
  public TraduccioForm(TraduccioForm __toClone) {
    super(__toClone);
      this.traduccio = __toClone.traduccio;
  }
  
  public TraduccioForm(TraduccioJPA traduccio, boolean nou) {
    super(nou);
    this.traduccio = traduccio;
  }
  
  public TraduccioJPA getTraduccio() {
    return traduccio;
  }
  public void setTraduccio(TraduccioJPA traduccio) {
    this.traduccio = traduccio;
  }
  
  
  
} // Final de Classe 
