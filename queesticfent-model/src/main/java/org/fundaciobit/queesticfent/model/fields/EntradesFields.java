
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EntradesFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_entrades";


  public static final String _TABLE_MODEL = "entrades";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField ENTRADAID = new LongField(_TABLE_MODEL, "entradaID", "entradaid");  // PK
	 public static final LongField ACCIOID = new LongField(_TABLE_MODEL, "accioid", "accioid");
	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariid", "usuariid");
	 public static final LongField PROJECTEID = new LongField(_TABLE_MODEL, "projecteid", "projecteid");
	 public static final LongField QUEESTICFENTID = new LongField(_TABLE_MODEL, "queesticfentid", "queesticfentid");
	 public static final StringField DADA1 = new StringField(_TABLE_MODEL, "dada1", "dada1");
	 public static final StringField DADA2 = new StringField(_TABLE_MODEL, "dada2", "dada2");
	 public static final TimeField DATA = new TimeField(_TABLE_MODEL, "data", "data");


  public static final Field<?>[] ALL_ENTRADES_FIELDS = {
    ENTRADAID,
    ACCIOID,
    USUARIID,
    PROJECTEID,
    QUEESTICFENTID,
    DADA1,
    DADA2,
    DATA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
ENTRADAID
  };
}
