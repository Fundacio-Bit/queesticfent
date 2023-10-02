
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class PersonalProjecteJPAManager
         extends AbstractJPAManager<PersonalProjecte, Long>
         implements PersonalProjecteIJPAManager, IPersonalProjecteManager, PersonalProjecteFields {



    public static final TableName<PersonalProjecte> _TABLENAME =  new TableName<PersonalProjecte>("PersonalProjecteJPA");


    @PersistenceContext
    protected EntityManager __em;

    public PersonalProjecteJPAManager() {
    }

    protected PersonalProjecteJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return PersonalProjecteJPA. class;
    }



    public TableName<PersonalProjecte> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public PersonalProjecte[] listToArray(List<PersonalProjecte> list)  {
        if(list == null) { return null; };
        return list.toArray(new PersonalProjecte[list.size()]);
    };

    public PersonalProjecte create( java.lang.String _usuariID_, long _projecteID_, long _ordre_, java.lang.Short _percent_) throws I18NException {
        PersonalProjecteJPA __bean =  new PersonalProjecteJPA(_usuariID_,_projecteID_,_ordre_,_percent_);
        return create(__bean);
    }



 public void delete(long _personalProjecteID_) {
   delete(findByPrimaryKey(_personalProjecteID_));
 }




    public PersonalProjecte findByPrimaryKey(long _personalProjecteID_) {
        return __em.find(PersonalProjecteJPA.class, _personalProjecteID_);  
    }
    @Override
    protected PersonalProjecte getJPAInstance(PersonalProjecte __bean) {
        return convertToJPA(__bean);
    }


    public static PersonalProjecteJPA convertToJPA(PersonalProjecte __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof PersonalProjecteJPA) {
        return (PersonalProjecteJPA)__bean;
      }
      
      return PersonalProjecteJPA.toJPA(__bean);
    }


}