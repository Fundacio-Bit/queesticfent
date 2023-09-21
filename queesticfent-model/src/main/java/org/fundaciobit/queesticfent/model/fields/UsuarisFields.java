
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface UsuarisFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "qef_usuaris";


  public static final String _TABLE_MODEL = "usuaris";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final StringField USUARIID = new StringField(_TABLE_MODEL, "usuariId", "usuariid");  // PK
	 public static final StringField LLINATGE1 = new StringField(_TABLE_MODEL, "llinatge1", "llinatge1");
	 public static final StringField LLINATGE2 = new StringField(_TABLE_MODEL, "llinatge2", "llinatge2");
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField CORREU = new StringField(_TABLE_MODEL, "correu", "correu");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");
	 public static final StringField EXTENSIO = new StringField(_TABLE_MODEL, "extensio", "extensio");
	 public static final DateField NAIXEMENT = new DateField(_TABLE_MODEL, "naixement", "naixement");
	 public static final StringField TELEFONCASA = new StringField(_TABLE_MODEL, "telefoncasa", "telefoncasa");
	 public static final StringField TELEFONMOBIL = new StringField(_TABLE_MODEL, "telefonmobil", "telefonmobil");
	 public static final StringField CONTRASENYA = new StringField(_TABLE_MODEL, "contrasenya", "contrasenya");


  public static final Field<?>[] ALL_USUARIS_FIELDS = {
    USUARIID,
    LLINATGE1,
    LLINATGE2,
    NOM,
    CORREU,
    DESCRIPCIO,
    EXTENSIO,
    NAIXEMENT,
    TELEFONCASA,
    TELEFONMOBIL,
    CONTRASENYA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
USUARIID
  };
}
