package org.fundaciobit.queesticfent.persistence;

import org.fundaciobit.queesticfent.model.*;
import org.fundaciobit.queesticfent.model.dao.*;
import javax.persistence.EntityManager;

public final class queesticfentJPADaoManagers implements IqueesticfentDaoManagers{

   private final AccionsJPAManager qef_accions;
   private final DepartamentsJPAManager qef_departaments;
   private final FestiusJPAManager qef_festius;
   private final FitxerJPAManager qef_fitxer;
   private final GrupsJPAManager qef_grups;
   private final GrupsusuariJPAManager qef_grupsusuari;
   private final IdiomaJPAManager qef_idioma;
   private final ModificacionsQueEsticFentJPAManager qef_modificacionsqueesticfent;
   private final PersonalProjecteJPAManager qef_personalprojecte;
   private final ProjectesJPAManager qef_projectes;
   private final TraduccioJPAManager qef_traduccio;
   private final TwitterJPAManager qef_jos_twitter;
   private final UsuarisJPAManager qef_usuaris;
   private final UsuarisDepartamentJPAManager qef_usuarisdepartament;

  public  queesticfentJPADaoManagers(EntityManager __em) {
    this.qef_accions = new AccionsJPAManager(__em);
    this.qef_departaments = new DepartamentsJPAManager(__em);
    this.qef_festius = new FestiusJPAManager(__em);
    this.qef_fitxer = new FitxerJPAManager(__em);
    this.qef_grups = new GrupsJPAManager(__em);
    this.qef_grupsusuari = new GrupsusuariJPAManager(__em);
    this.qef_idioma = new IdiomaJPAManager(__em);
    this.qef_modificacionsqueesticfent = new ModificacionsQueEsticFentJPAManager(__em);
    this.qef_personalprojecte = new PersonalProjecteJPAManager(__em);
    this.qef_projectes = new ProjectesJPAManager(__em);
    this.qef_traduccio = new TraduccioJPAManager(__em);
    this.qef_jos_twitter = new TwitterJPAManager(__em);
    this.qef_usuaris = new UsuarisJPAManager(__em);
    this.qef_usuarisdepartament = new UsuarisDepartamentJPAManager(__em);
  }

    public IAccionsManager getAccionsManager() {
        return this.qef_accions;
    };

    public IDepartamentsManager getDepartamentsManager() {
        return this.qef_departaments;
    };

    public IFestiusManager getFestiusManager() {
        return this.qef_festius;
    };

    public IFitxerManager getFitxerManager() {
        return this.qef_fitxer;
    };

    public IGrupsManager getGrupsManager() {
        return this.qef_grups;
    };

    public IGrupsusuariManager getGrupsusuariManager() {
        return this.qef_grupsusuari;
    };

    public IIdiomaManager getIdiomaManager() {
        return this.qef_idioma;
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

    public ITwitterManager getTwitterManager() {
        return this.qef_jos_twitter;
    };

    public IUsuarisManager getUsuarisManager() {
        return this.qef_usuaris;
    };

    public IUsuarisDepartamentManager getUsuarisDepartamentManager() {
        return this.qef_usuarisdepartament;
    };


}