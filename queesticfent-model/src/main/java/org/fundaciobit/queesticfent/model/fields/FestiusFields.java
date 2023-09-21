
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface FestiusFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_festius";


  public static final String _TABLE_MODEL = "festius";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField FESTIUID = new LongField(_TABLE_MODEL, "festiuID", "festiuid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final DateField DATA = new DateField(_TABLE_MODEL, "data", "data");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");


  public static final Field<?>[] ALL_FESTIUS_FIELDS = {
    FESTIUID,
    NOM,
    DATA,
    DESCRIPCIO
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
FESTIUID
  };
}
