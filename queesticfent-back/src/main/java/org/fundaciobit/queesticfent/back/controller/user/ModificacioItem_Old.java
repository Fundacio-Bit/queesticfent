package org.fundaciobit.queesticfent.back.controller.user;

import org.fundaciobit.queesticfent.model.entity.Accio;
import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;

public class ModificacioItem_Old {
  public final ModificacioQueEsticFent modificacio;;
  
  public final Accio accio;

  /**
   * @param modificacio
   * @param accio
   */
  public ModificacioItem_Old(ModificacioQueEsticFent modificacio, Accio accio) {
    super();
    this.modificacio = modificacio;
    this.accio = accio;
  }

  public ModificacioQueEsticFent getModificacio() {
    return modificacio;
  }

  public Accio getAccio() {
    return accio;
  }
  
}
