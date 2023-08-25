
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class PersonalProjecteQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public PersonalProjecteQueryPath() {
  }

  protected PersonalProjecteQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PERSONALPROJECTEID() {
    return new LongField(getQueryPath(), PersonalProjecteFields.PERSONALPROJECTEID);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), PersonalProjecteFields.USUARIID);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), PersonalProjecteFields.PROJECTEID);
  }

  public LongField ORDRE() {
    return new LongField(getQueryPath(), PersonalProjecteFields.ORDRE);
  }

  public ShortField PERCENT() {
    return new ShortField(getQueryPath(), PersonalProjecteFields.PERCENT);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PersonalProjecteFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public ProjectesQueryPath PROJECTES() {
    return new ProjectesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PersonalProjecteQueryPath.this.getQueryPath() + "projectes" + ".";
      }
    });
  }

}
