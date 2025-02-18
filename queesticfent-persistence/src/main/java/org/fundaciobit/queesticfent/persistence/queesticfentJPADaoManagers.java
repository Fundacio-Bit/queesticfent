package org.fundaciobit.queesticfent.persistence;

import org.fundaciobit.queesticfent.model.*;
import org.fundaciobit.queesticfent.model.dao.*;
import javax.persistence.EntityManager;

public final class queesticfentJPADaoManagers implements IqueesticfentDaoManagers{

   private final AccioJPAManager qef_accio;
   private final DepartamentJPAManager qef_departament;
   private final EntradaJPAManager qef_entrada;
   private final FestiuJPAManager qef_festiu;
   private final FitxerJPAManager qef_fitxer;
   private final IdiomaJPAManager qef_idioma;
   private final ModificacioQueEsticFentJPAManager qef_modificacioqueesticfent;
   private final PersonalProjecteJPAManager qef_personalprojecte;
   private final ProjecteJPAManager qef_projecte;
   private final TraduccioJPAManager qef_traduccio;
   private final UsuariJPAManager qef_usuari;
   private final UsuariDepartamentJPAManager qef_usuaridepartament;

  public  queesticfentJPADaoManagers(EntityManager __em) {
    this.qef_accio = new AccioJPAManager(__em);
    this.qef_departament = new DepartamentJPAManager(__em);
    this.qef_entrada = new EntradaJPAManager(__em);
    this.qef_festiu = new FestiuJPAManager(__em);
    this.qef_fitxer = new FitxerJPAManager(__em);
    this.qef_idioma = new IdiomaJPAManager(__em);
    this.qef_modificacioqueesticfent = new ModificacioQueEsticFentJPAManager(__em);
    this.qef_personalprojecte = new PersonalProjecteJPAManager(__em);
    this.qef_projecte = new ProjecteJPAManager(__em);
    this.qef_traduccio = new TraduccioJPAManager(__em);
    this.qef_usuari = new UsuariJPAManager(__em);
    this.qef_usuaridepartament = new UsuariDepartamentJPAManager(__em);
  }

    public IAccioManager getAccioManager() {
        return this.qef_accio;
    };

    public IDepartamentManager getDepartamentManager() {
        return this.qef_departament;
    };

    public IEntradaManager getEntradaManager() {
        return this.qef_entrada;
    };

    public IFestiuManager getFestiuManager() {
        return this.qef_festiu;
    };

    public IFitxerManager getFitxerManager() {
        return this.qef_fitxer;
    };

    public IIdiomaManager getIdiomaManager() {
        return this.qef_idioma;
    };

    public IModificacioQueEsticFentManager getModificacioQueEsticFentManager() {
        return this.qef_modificacioqueesticfent;
    };

    public IPersonalProjecteManager getPersonalProjecteManager() {
        return this.qef_personalprojecte;
    };

    public IProjecteManager getProjecteManager() {
        return this.qef_projecte;
    };

    public ITraduccioManager getTraduccioManager() {
        return this.qef_traduccio;
    };

    public IUsuariManager getUsuariManager() {
        return this.qef_usuari;
    };

    public IUsuariDepartamentManager getUsuariDepartamentManager() {
        return this.qef_usuaridepartament;
    };


}