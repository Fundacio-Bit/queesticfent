
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface ProjectesFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_projectes";


  public static final String _TABLE_MODEL = "projectes";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField PROJECTEID = new LongField(_TABLE_MODEL, "projecteID", "projecteid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final LongField DEPARTAMENTID = new LongField(_TABLE_MODEL, "departamentID", "departamentid");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");
	 public static final BooleanField ACTIU = new BooleanField(_TABLE_MODEL, "actiu", "actiu");
	 public static final DateField FROMDATA = new DateField(_TABLE_MODEL, "fromdata", "fromdata");
	 public static final DateField TODATA = new DateField(_TABLE_MODEL, "todata", "todata");


  public static final Field<?>[] ALL_PROJECTES_FIELDS = {
    PROJECTEID,
    NOM,
    DEPARTAMENTID,
    DESCRIPCIO,
    ACTIU,
    FROMDATA,
    TODATA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
PROJECTEID
  };
}
