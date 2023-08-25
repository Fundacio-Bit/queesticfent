package org.fundaciobit.queesticfent.model;

import org.fundaciobit.queesticfent.model.dao.*;

public interface IqueesticfentDaoManagers {
	public IAccionsManager getAccionsManager();
	public IDepartamentsManager getDepartamentsManager();
	public IFestiusManager getFestiusManager();
	public IFitxerManager getFitxerManager();
	public IGrupsManager getGrupsManager();
	public IGrupsusuariManager getGrupsusuariManager();
	public IIdiomaManager getIdiomaManager();
	public IModificacionsQueEsticFentManager getModificacionsQueEsticFentManager();
	public IPersonalProjecteManager getPersonalProjecteManager();
	public IProjectesManager getProjectesManager();
	public ITraduccioManager getTraduccioManager();
	public ITwitterManager getTwitterManager();
	public IUsuarisManager getUsuarisManager();
	public IUsuarisDepartamentManager getUsuarisDepartamentManager();

}