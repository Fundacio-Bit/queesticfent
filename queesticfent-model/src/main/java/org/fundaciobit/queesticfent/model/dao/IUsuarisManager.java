package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IUsuarisManager extends org.fundaciobit.genapp.common.query.ITableManager<Usuaris, String> {


	public Usuaris create( java.lang.String _usuariid_, java.lang.String _llinatge1_, java.lang.String _llinatge2_, java.lang.String _nom_, java.lang.String _correu_, java.lang.String _descripcio_, java.lang.String _extensio_, java.sql.Date _naixement_, java.lang.String _telefoncasa_, java.lang.String _telefonmobil_, java.lang.String _contrasenya_) throws I18NException;

	public Usuaris findByPrimaryKey(java.lang.String _usuariid_);

	public void delete(java.lang.String _usuariid_);

}
