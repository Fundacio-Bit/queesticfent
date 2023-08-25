
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface UsuarisDepartamentFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_usuarisdepartament";


  public static final String _TABLE_MODEL = "usuarisDepartament";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariid", "usuariid");
	 public static final LongField DEPARTAMENTID = new LongField(_TABLE_MODEL, "departamentid", "departamentid");
	 public static final LongField USUARIDEPARTAMENTID = new LongField(_TABLE_MODEL, "usuaridepartamentid", "usuaridepartamentid");  // PK


  public static final Field<?>[] ALL_USUARISDEPARTAMENT_FIELDS = {
    USUARIID,
    DEPARTAMENTID,
    USUARIDEPARTAMENTID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
USUARIDEPARTAMENTID
  };
}
