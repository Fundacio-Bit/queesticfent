package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IDepartamentManager extends org.fundaciobit.genapp.common.query.ITableManager<Departament, Long> {


	public Departament create( java.lang.String _nom_, java.lang.String _coordinadorid_, java.lang.String _nomldap_, java.lang.String _descripcio_) throws I18NException;

	public Departament findByPrimaryKey(long _departamentID_);

	public void delete(long _departamentID_);

}
