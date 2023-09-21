
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface PersonalProjecteFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_personalprojecte";


  public static final String _TABLE_MODEL = "personalProjecte";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField PERSONALPROJECTEID = new LongField(_TABLE_MODEL, "personalProjecteId", "personalprojecteid");  // PK
	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariid", "usuariid");
	 public static final LongField PROJECTEID = new LongField(_TABLE_MODEL, "projecteid", "projecteid");
	 public static final LongField ORDRE = new LongField(_TABLE_MODEL, "ordre", "ordre");
	 public static final ShortField PERCENT = new ShortField(_TABLE_MODEL, "percent", "percent");


  public static final Field<?>[] ALL_PERSONALPROJECTE_FIELDS = {
    PERSONALPROJECTEID,
    USUARIID,
    PROJECTEID,
    ORDRE,
    PERCENT
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
PERSONALPROJECTEID
  };
}
