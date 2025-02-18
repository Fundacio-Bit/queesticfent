
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class UsuariQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public UsuariQueryPath() {
  }

  protected UsuariQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), UsuariFields.USUARIID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), UsuariFields.NOM);
  }

  public StringField LLINATGE1() {
    return new StringField(getQueryPath(), UsuariFields.LLINATGE1);
  }

  public StringField LLINATGE2() {
    return new StringField(getQueryPath(), UsuariFields.LLINATGE2);
  }

  public StringField CORREU() {
    return new StringField(getQueryPath(), UsuariFields.CORREU);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), UsuariFields.DESCRIPCIO);
  }

  public StringField EXTENSIO() {
    return new StringField(getQueryPath(), UsuariFields.EXTENSIO);
  }

  public DateField NAIXEMENT() {
    return new DateField(getQueryPath(), UsuariFields.NAIXEMENT);
  }

  public StringField TELEFONCASA() {
    return new StringField(getQueryPath(), UsuariFields.TELEFONCASA);
  }

  public StringField TELEFONMOBIL() {
    return new StringField(getQueryPath(), UsuariFields.TELEFONMOBIL);
  }

  public StringField CONTRASENYA() {
    return new StringField(getQueryPath(), UsuariFields.CONTRASENYA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (UsuariFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public UsuariDepartamentQueryPath USUARIDEPARTAMENTS() {
    return new UsuariDepartamentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuariQueryPath.this.getQueryPath() + "usuariDepartaments" + ".";
      }
    });
  }
*/

}
