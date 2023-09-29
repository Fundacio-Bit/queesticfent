package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IDepartamentsManager extends org.fundaciobit.genapp.common.query.ITableManager<Departaments, Long> {


	public Departaments create( java.lang.String _nom_, java.lang.String _coordinadorId_, java.lang.String _nomLDAP_, java.lang.String _descripcio_) throws I18NException;

	public Departaments findByPrimaryKey(long _departamentID_);

	public void delete(long _departamentID_);

}
