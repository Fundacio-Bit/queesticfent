package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IDepartamentsManager extends org.fundaciobit.genapp.common.query.ITableManager<Departaments, Long> {


	public Departaments create( java.lang.String _nom_, java.lang.String _coordinadorid_, java.lang.String _nomldap_, java.lang.String _descripcio_) throws I18NException;

	public Departaments findByPrimaryKey(long _departamentid_);

	public void delete(long _departamentid_);

}
