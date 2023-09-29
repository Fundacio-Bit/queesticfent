
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface DepartamentsFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_departaments";


  public static final String _TABLE_MODEL = "departaments";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField DEPARTAMENTID = new LongField(_TABLE_MODEL, "departamentID", "departamentid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField COORDINADORID = new StringField(_TABLE_MODEL, "coordinadorId", "coordinadorid");
	 public static final StringField NOMLDAP = new StringField(_TABLE_MODEL, "nomLDAP", "nomldap");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");


  public static final Field<?>[] ALL_DEPARTAMENTS_FIELDS = {
    DEPARTAMENTID,
    NOM,
    COORDINADORID,
    NOMLDAP,
    DESCRIPCIO
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
DEPARTAMENTID
  };
}
