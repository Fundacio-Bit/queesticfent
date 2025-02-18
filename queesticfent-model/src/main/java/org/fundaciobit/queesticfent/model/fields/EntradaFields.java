
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EntradaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_entrada";


  public static final String _TABLE_MODEL = "entrada";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField ENTRADAID = new LongField(_TABLE_MODEL, "entradaID", "entradaid");  // PK
	 public static final LongField ACCIOID = new LongField(_TABLE_MODEL, "accioID", "accioid");
	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariID", "usuariid");
	 public static final LongField PROJECTEID = new LongField(_TABLE_MODEL, "projecteID", "projecteid");
	 public static final StringField DADA1 = new StringField(_TABLE_MODEL, "dada1", "dada1");
	 public static final LongField QUEESTICFENTID = new LongField(_TABLE_MODEL, "queEsticFentID", "queesticfentid");
	 public static final StringField DADA2 = new StringField(_TABLE_MODEL, "dada2", "dada2");
	 public static final TimestampField DATA = new TimestampField(_TABLE_MODEL, "data", "data");


  public static final Field<?>[] ALL_ENTRADA_FIELDS = {
    ENTRADAID,
    ACCIOID,
    USUARIID,
    PROJECTEID,
    DADA1,
    QUEESTICFENTID,
    DADA2,
    DATA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
ENTRADAID
  };
}
