package org.fundaciobit.queesticfent.model;

import org.fundaciobit.queesticfent.model.dao.*;

public interface IqueesticfentDaoManagers {
	public IAccioManager getAccioManager();
	public IDepartamentManager getDepartamentManager();
	public IEntradaManager getEntradaManager();
	public IFestiuManager getFestiuManager();
	public IFitxerManager getFitxerManager();
	public IIdiomaManager getIdiomaManager();
	public IModificacioQueEsticFentManager getModificacioQueEsticFentManager();
	public IPersonalProjecteManager getPersonalProjecteManager();
	public IProjecteManager getProjecteManager();
	public ITraduccioManager getTraduccioManager();
	public IUsuariManager getUsuariManager();
	public IUsuariDepartamentManager getUsuariDepartamentManager();

}