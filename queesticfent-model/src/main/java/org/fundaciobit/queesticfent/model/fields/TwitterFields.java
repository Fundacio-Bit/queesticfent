
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TwitterFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_jos_twitter";


  public static final String _TABLE_MODEL = "twitter";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField ID = new LongField(_TABLE_MODEL, "id", "id");  // PK
	 public static final StringField USERNAME = new StringField(_TABLE_MODEL, "username", "username");
	 public static final StringField COMENTARIO = new StringField(_TABLE_MODEL, "comentario", "comentario");
	 public static final DateField FECHA = new DateField(_TABLE_MODEL, "fecha", "fecha");
	 public static final LongField USER_ID = new LongField(_TABLE_MODEL, "user_id", "user_id");
	 public static final StringField IP = new StringField(_TABLE_MODEL, "ip", "ip");


  public static final Field<?>[] ALL_TWITTER_FIELDS = {
    ID,
    USERNAME,
    COMENTARIO,
    FECHA,
    USER_ID,
    IP
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
ID
  };
}
