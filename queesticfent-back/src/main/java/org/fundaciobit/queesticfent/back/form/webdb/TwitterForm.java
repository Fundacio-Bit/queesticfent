package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.TwitterJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class TwitterForm extends queesticfentBaseForm {
  
  private TwitterJPA twitter;
  
  public TwitterForm() {
  }
  
  public TwitterForm(TwitterForm __toClone) {
    super(__toClone);
      this.twitter = __toClone.twitter;
  }
  
  public TwitterForm(TwitterJPA twitter, boolean nou) {
    super(nou);
    this.twitter = twitter;
  }
  
  public TwitterJPA getTwitter() {
    return twitter;
  }
  public void setTwitter(TwitterJPA twitter) {
    this.twitter = twitter;
  }
  
  
  
} // Final de Classe 
