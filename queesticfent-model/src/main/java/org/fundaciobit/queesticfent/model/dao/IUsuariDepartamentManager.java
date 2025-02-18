package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IUsuariDepartamentManager extends org.fundaciobit.genapp.common.query.ITableManager<UsuariDepartament, Long> {


	public UsuariDepartament create( java.lang.String _usuariID_, long _departamentID_) throws I18NException;

	public UsuariDepartament findByPrimaryKey(long _usuaridepartamentID_);

	public void delete(long _usuaridepartamentID_);

}
