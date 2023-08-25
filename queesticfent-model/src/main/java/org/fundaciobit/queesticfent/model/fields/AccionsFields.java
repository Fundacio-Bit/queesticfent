
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface AccionsFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_accions";


  public static final String _TABLE_MODEL = "accions";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField ACCIOID = new LongField(_TABLE_MODEL, "accioid", "accioid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField NOMLLEGENDA = new StringField(_TABLE_MODEL, "nomllegenda", "nomllegenda");
	 public static final StringField COLOR = new StringField(_TABLE_MODEL, "color", "color");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");


  public static final Field<?>[] ALL_ACCIONS_FIELDS = {
    ACCIOID,
    NOM,
    NOMLLEGENDA,
    COLOR,
    DESCRIPCIO
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
ACCIOID
  };
}
