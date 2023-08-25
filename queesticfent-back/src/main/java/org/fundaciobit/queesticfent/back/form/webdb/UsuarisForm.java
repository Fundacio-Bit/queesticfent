package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.UsuarisJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class UsuarisForm extends queesticfentBaseForm {
  
  private UsuarisJPA usuaris;
  
  public UsuarisForm() {
  }
  
  public UsuarisForm(UsuarisForm __toClone) {
    super(__toClone);
      this.usuaris = __toClone.usuaris;
  }
  
  public UsuarisForm(UsuarisJPA usuaris, boolean nou) {
    super(nou);
    this.usuaris = usuaris;
  }
  
  public UsuarisJPA getUsuaris() {
    return usuaris;
  }
  public void setUsuaris(UsuarisJPA usuaris) {
    this.usuaris = usuaris;
  }
  
  
  
} // Final de Classe 
