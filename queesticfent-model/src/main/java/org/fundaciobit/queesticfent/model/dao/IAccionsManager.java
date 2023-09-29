package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IAccionsManager extends org.fundaciobit.genapp.common.query.ITableManager<Accions, Long> {


	public Accions create( java.lang.String _nom_, java.lang.String _nomLlegenda_, java.lang.String _color_, java.lang.String _descripcio_) throws I18NException;

	public Accions findByPrimaryKey(long _accioID_);

	public void delete(long _accioID_);

}
