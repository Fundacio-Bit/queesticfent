package org.fundaciobit.queesticfent.persistence;

import org.fundaciobit.queesticfent.model.*;
import org.fundaciobit.queesticfent.model.dao.*;
import javax.persistence.EntityManager;

public final class queesticfentJPADaoManagers implements IqueesticfentDaoManagers{

   private final AccionsJPAManager qef_accions;
   private final DepartamentsJPAManager qef_departaments;
   private final EntradesJPAManager qef_entrades;
   private final FestiusJPAManager qef_festius;
   private final FitxerJPAManager qef_fitxer;
   private final IdiomaJPAManager qef_idioma;
   private final ModificacionsJPAManager qef_modificacions;
   private final ModificacionsQueEsticFentJPAManager qef_modificacionsqueesticfent;
   private final PersonalProjecteJPAManager qef_personalprojecte;
   private final ProjectesJPAManager qef_projectes;
   private final TraduccioJPAManager qef_traduccio;
   private final UsuarisJPAManager qef_usuaris;
   private final UsuarisDepartamentJPAManager qef_usuarisdepartament;

  public  queesticfentJPADaoManagers(EntityManager __em) {
    this.qef_accions = new AccionsJPAManager(__em);
    this.qef_departaments = new DepartamentsJPAManager(__em);
    this.qef_entrades = new EntradesJPAManager(__em);
    this.qef_festius = new FestiusJPAManager(__em);
    this.qef_fitxer = new FitxerJPAManager(__em);
    this.qef_idioma = new IdiomaJPAManager(__em);
    this.qef_modificacions = new ModificacionsJPAManager(__em);
    this.qef_modificacionsqueesticfent = new ModificacionsQueEsticFentJPAManager(__em);
    this.qef_personalprojecte = new PersonalProjecteJPAManager(__em);
    this.qef_projectes = new ProjectesJPAManager(__em);
    this.qef_traduccio = new TraduccioJPAManager(__em);
    this.qef_usuaris = new UsuarisJPAManager(__em);
    this.qef_usuarisdepartament = new UsuarisDepartamentJPAManager(__em);
  }

    public IAccionsManager getAccionsManager() {
        return this.qef_accions;
    };

    public IDepartamentsManager getDepartamentsManager() {
        return this.qef_departaments;
    };

    public IEntradesManager getEntradesManager() {
        return this.qef_entrades;
    };

    public IFestiusManager getFestiusManager() {
        return this.qef_festius;
    };

    public IFitxerManager getFitxerManager() {
        return this.qef_fitxer;
    };

    public IIdiomaManager getIdiomaManager() {
        return this.qef_idioma;
    };

    public IModificacionsManager getModificacionsManager() {
        return this.qef_modificacions;
    };

    public IModificacionsQueEsticFentManager getModificacionsQueEsticFentManager() {
        return this.qef_modificacionsqueesticfent;
    };

    public IPersonalProjecteManager getPersonalProjecteManager() {
        return this.qef_personalprojecte;
    };

    public IProjectesManager getProjectesManager() {
        return this.qef_projectes;
    };

    public ITraduccioManager getTraduccioManager() {
        return this.qef_traduccio;
    };

    public IUsuarisManager getUsuarisManager() {
        return this.qef_usuaris;
    };

    public IUsuarisDepartamentManager getUsuarisDepartamentManager() {
        return this.qef_usuarisdepartament;
    };


}