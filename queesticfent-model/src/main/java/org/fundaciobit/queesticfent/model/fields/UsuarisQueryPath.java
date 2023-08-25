
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class UsuarisQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public UsuarisQueryPath() {
  }

  protected UsuarisQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), UsuarisFields.USUARIID);
  }

  public StringField LLINATGE1() {
    return new StringField(getQueryPath(), UsuarisFields.LLINATGE1);
  }

  public StringField LLINATGE2() {
    return new StringField(getQueryPath(), UsuarisFields.LLINATGE2);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), UsuarisFields.NOM);
  }

  public StringField CORREU() {
    return new StringField(getQueryPath(), UsuarisFields.CORREU);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), UsuarisFields.DESCRIPCIO);
  }

  public StringField EXTENSIO() {
    return new StringField(getQueryPath(), UsuarisFields.EXTENSIO);
  }

  public DateField NAIXEMENT() {
    return new DateField(getQueryPath(), UsuarisFields.NAIXEMENT);
  }

  public StringField TELEFONCASA() {
    return new StringField(getQueryPath(), UsuarisFields.TELEFONCASA);
  }

  public StringField TELEFONMOBIL() {
    return new StringField(getQueryPath(), UsuarisFields.TELEFONMOBIL);
  }

  public StringField CONTRASENYA() {
    return new StringField(getQueryPath(), UsuarisFields.CONTRASENYA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (UsuarisFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public GrupsusuariQueryPath GRUPSUSUARIS() {
    return new GrupsusuariQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuarisQueryPath.this.getQueryPath() + "grupsusuaris" + ".";
      }
    });
  }
*/

}
