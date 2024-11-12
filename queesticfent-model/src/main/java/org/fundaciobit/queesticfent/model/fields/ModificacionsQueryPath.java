
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ModificacionsQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ModificacionsQueryPath() {
  }

  protected ModificacionsQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField MODIFICACIOID() {
    return new LongField(getQueryPath(), ModificacionsFields.MODIFICACIOID);
  }

  public LongField ENTRADAID() {
    return new LongField(getQueryPath(), ModificacionsFields.ENTRADAID);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), ModificacionsFields.ACCIOID);
  }

  public StringField OLDUSUARIID() {
    return new StringField(getQueryPath(), ModificacionsFields.OLDUSUARIID);
  }

  public LongField OLDPROJECTEID() {
    return new LongField(getQueryPath(), ModificacionsFields.OLDPROJECTEID);
  }

  public LongField OLDQUEESTICFENTID() {
    return new LongField(getQueryPath(), ModificacionsFields.OLDQUEESTICFENTID);
  }

  public StringField OLDDADA1() {
    return new StringField(getQueryPath(), ModificacionsFields.OLDDADA1);
  }

  public StringField OLDDADA2() {
    return new StringField(getQueryPath(), ModificacionsFields.OLDDADA2);
  }

  public TimestampField OLDDATA() {
    return new TimestampField(getQueryPath(), ModificacionsFields.OLDDATA);
  }

  public StringField NEWUSUARIID() {
    return new StringField(getQueryPath(), ModificacionsFields.NEWUSUARIID);
  }

  public LongField NEWPROJECTEID() {
    return new LongField(getQueryPath(), ModificacionsFields.NEWPROJECTEID);
  }

  public LongField NEWQUEESTICFENTID() {
    return new LongField(getQueryPath(), ModificacionsFields.NEWQUEESTICFENTID);
  }

  public StringField NEWDADA1() {
    return new StringField(getQueryPath(), ModificacionsFields.NEWDADA1);
  }

  public StringField NEWDADA2() {
    return new StringField(getQueryPath(), ModificacionsFields.NEWDADA2);
  }

  public TimestampField NEWDATA() {
    return new TimestampField(getQueryPath(), ModificacionsFields.NEWDATA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ModificacionsFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public EntradesQueryPath ENTRADES() {
    return new EntradesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacionsQueryPath.this.getQueryPath() + "entrades" + ".";
      }
    });
  }

  public AccionsQueryPath ACCIONS() {
    return new AccionsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacionsQueryPath.this.getQueryPath() + "accions" + ".";
      }
    });
  }

  public ProjectesQueryPath OLDPROJECTE() {
    return new ProjectesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacionsQueryPath.this.getQueryPath() + "oldprojecte" + ".";
      }
    });
  }

  public ProjectesQueryPath NEWPROJECTE() {
    return new ProjectesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacionsQueryPath.this.getQueryPath() + "newprojecte" + ".";
      }
    });
  }

}
