package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IUsuarisDepartamentManager extends org.fundaciobit.genapp.common.query.ITableManager<UsuarisDepartament, Long> {


	public UsuarisDepartament create( java.lang.String _usuariId_, long _departamentid_) throws I18NException;

	public UsuarisDepartament findByPrimaryKey(long _usuariDepartamentId_);

	public void delete(long _usuariDepartamentId_);

}
