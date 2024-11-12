
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface ModificacionsFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_modificacions";


  public static final String _TABLE_MODEL = "modificacions";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField MODIFICACIOID = new LongField(_TABLE_MODEL, "modificacioid", "modificacioid");  // PK
	 public static final LongField ENTRADAID = new LongField(_TABLE_MODEL, "entradaid", "entradaid");
	 public static final LongField ACCIOID = new LongField(_TABLE_MODEL, "accioid", "accioid");
	 public static final StringField OLDUSUARIID = new StringField(_TABLE_MODEL, "oldusuariID", "oldusuariid");
	 public static final LongField OLDPROJECTEID = new LongField(_TABLE_MODEL, "oldprojecteID", "oldprojecteid");
	 public static final LongField OLDQUEESTICFENTID = new LongField(_TABLE_MODEL, "oldqueesticfentid", "oldqueesticfentid");
	 public static final StringField OLDDADA1 = new StringField(_TABLE_MODEL, "olddada1", "olddada1");
	 public static final StringField OLDDADA2 = new StringField(_TABLE_MODEL, "olddada2", "olddada2");
	 public static final TimestampField OLDDATA = new TimestampField(_TABLE_MODEL, "olddata", "olddata");
	 public static final StringField NEWUSUARIID = new StringField(_TABLE_MODEL, "newusuariID", "newusuariid");
	 public static final LongField NEWPROJECTEID = new LongField(_TABLE_MODEL, "newprojecteID", "newprojecteid");
	 public static final LongField NEWQUEESTICFENTID = new LongField(_TABLE_MODEL, "newqueesticfentid", "newqueesticfentid");
	 public static final StringField NEWDADA1 = new StringField(_TABLE_MODEL, "newdada1", "newdada1");
	 public static final StringField NEWDADA2 = new StringField(_TABLE_MODEL, "newdada2", "newdada2");
	 public static final TimestampField NEWDATA = new TimestampField(_TABLE_MODEL, "newdata", "newdata");


  public static final Field<?>[] ALL_MODIFICACIONS_FIELDS = {
    MODIFICACIOID,
    ENTRADAID,
    ACCIOID,
    OLDUSUARIID,
    OLDPROJECTEID,
    OLDQUEESTICFENTID,
    OLDDADA1,
    OLDDADA2,
    OLDDATA,
    NEWUSUARIID,
    NEWPROJECTEID,
    NEWQUEESTICFENTID,
    NEWDADA1,
    NEWDADA2,
    NEWDATA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
MODIFICACIOID
  };
}
