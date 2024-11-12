package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IModificacionsManager extends org.fundaciobit.genapp.common.query.ITableManager<Modificacions, Long> {


	public Modificacions create( long _entradaid_, long _accioid_, java.lang.String _oldusuariID_, java.lang.Long _oldprojecteID_, java.lang.Long _oldqueesticfentid_, java.lang.String _olddada1_, java.lang.String _olddada2_, java.sql.Timestamp _olddata_, java.lang.String _newusuariID_, java.lang.Long _newprojecteID_, java.lang.Long _newqueesticfentid_, java.lang.String _newdada1_, java.lang.String _newdada2_, java.sql.Timestamp _newdata_) throws I18NException;

	public Modificacions findByPrimaryKey(long _modificacioid_);

	public void delete(long _modificacioid_);

}
