
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface GrupsFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_grups";


  public static final String _TABLE_MODEL = "grups";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField GRUPID = new LongField(_TABLE_MODEL, "grupID", "grupid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");
	 public static final LongField NIVELLSEGURETAT = new LongField(_TABLE_MODEL, "nivellSeguretat", "nivellseguretat");


  public static final Field<?>[] ALL_GRUPS_FIELDS = {
    GRUPID,
    NOM,
    DESCRIPCIO,
    NIVELLSEGURETAT
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
GRUPID
  };
}
