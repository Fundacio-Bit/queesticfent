package org.fundaciobit.queesticfent.back.controller.user;

import org.fundaciobit.queesticfent.model.entity.Accions;
import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;

public class ModificacioItem_Old {
  public final ModificacionsQueEsticFent modificacio;;
  
  public final Accions accio;

  /**
   * @param modificacio
   * @param accio
   */
  public ModificacioItem_Old(ModificacionsQueEsticFent modificacio, Accions accio) {
    super();
    this.modificacio = modificacio;
    this.accio = accio;
  }

  public ModificacionsQueEsticFent getModificacio() {
    return modificacio;
  }

  public Accions getAccio() {
    return accio;
  }
  
}
