
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface GrupsusuariFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_grupsusuari";


  public static final String _TABLE_MODEL = "grupsusuari";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField GRUPSUSUARIID = new LongField(_TABLE_MODEL, "grupsUsuariID", "grupsusuariid");  // PK
	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariID", "usuariid");
	 public static final LongField GRUPID = new LongField(_TABLE_MODEL, "grupID", "grupid");


  public static final Field<?>[] ALL_GRUPSUSUARI_FIELDS = {
    GRUPSUSUARIID,
    USUARIID,
    GRUPID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
GRUPSUSUARIID
  };
}
