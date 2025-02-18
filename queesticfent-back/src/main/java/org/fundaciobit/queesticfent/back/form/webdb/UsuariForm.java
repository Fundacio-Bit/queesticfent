package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.UsuariJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class UsuariForm extends queesticfentBaseForm {
  
  private UsuariJPA usuari;
  
  public UsuariForm() {
  }
  
  public UsuariForm(UsuariForm __toClone) {
    super(__toClone);
      this.usuari = __toClone.usuari;
  }
  
  public UsuariForm(UsuariJPA usuari, boolean nou) {
    super(nou);
    this.usuari = usuari;
  }
  
  public UsuariJPA getUsuari() {
    return usuari;
  }
  public void setUsuari(UsuariJPA usuari) {
    this.usuari = usuari;
  }
  
  
  
} // Final de Classe 
