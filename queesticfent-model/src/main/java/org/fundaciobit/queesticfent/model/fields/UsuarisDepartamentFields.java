
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface UsuarisDepartamentFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_usuarisdepartament";


  public static final String _TABLE_MODEL = "usuarisDepartament";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField USUARIDEPARTAMENTID = new LongField(_TABLE_MODEL, "usuariDepartamentID", "usuaridepartamentid");  // PK
	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariID", "usuariid");
	 public static final LongField DEPARTAMENTID = new LongField(_TABLE_MODEL, "departamentID", "departamentid");


  public static final Field<?>[] ALL_USUARISDEPARTAMENT_FIELDS = {
    USUARIDEPARTAMENTID,
    USUARIID,
    DEPARTAMENTID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
USUARIDEPARTAMENTID
  };
}
