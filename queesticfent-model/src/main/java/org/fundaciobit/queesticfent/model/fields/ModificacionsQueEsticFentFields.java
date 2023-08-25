
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface ModificacionsQueEsticFentFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_modificacionsqueesticfent";


  public static final String _TABLE_MODEL = "modificacionsQueEsticFent";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField MODIFICACIOID = new LongField(_TABLE_MODEL, "modificacioid", "modificacioid");  // PK
	 public static final LongField ACCIOID = new LongField(_TABLE_MODEL, "accioid", "accioid");
	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariid", "usuariid");
	 public static final LongField PROJECTEID = new LongField(_TABLE_MODEL, "projecteid", "projecteid");
	 public static final TimestampField DATA = new TimestampField(_TABLE_MODEL, "data", "data");
	 public static final LongField QUEESTICFENTID = new LongField(_TABLE_MODEL, "queesticfentid", "queesticfentid");
	 public static final StringField DADA1 = new StringField(_TABLE_MODEL, "dada1", "dada1");
	 public static final StringField DADA2 = new StringField(_TABLE_MODEL, "dada2", "dada2");


  public static final Field<?>[] ALL_MODIFICACIONSQUEESTICFENT_FIELDS = {
    MODIFICACIOID,
    ACCIOID,
    USUARIID,
    PROJECTEID,
    DATA,
    QUEESTICFENTID,
    DADA1,
    DADA2
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
MODIFICACIOID
  };
}
