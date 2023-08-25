package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IGrupsManager extends org.fundaciobit.genapp.common.query.ITableManager<Grups, Long> {


	public Grups create( java.lang.String _nom_, java.lang.String _descripcio_, java.lang.Long _nivellseguretat_) throws I18NException;

	public Grups findByPrimaryKey(long _grupid_);

	public void delete(long _grupid_);

}
