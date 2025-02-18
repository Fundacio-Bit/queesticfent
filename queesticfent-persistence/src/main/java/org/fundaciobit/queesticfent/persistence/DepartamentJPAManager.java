
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class DepartamentJPAManager
         extends AbstractJPAManager<Departament, Long>
         implements DepartamentIJPAManager, IDepartamentManager, DepartamentFields {



    public static final TableName<Departament> _TABLENAME =  new TableName<Departament>("DepartamentJPA");


    @PersistenceContext
    protected EntityManager __em;

    public DepartamentJPAManager() {
    }

    protected DepartamentJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return DepartamentJPA. class;
    }



    public TableName<Departament> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Departament[] listToArray(List<Departament> list)  {
        if(list == null) { return null; };
        return list.toArray(new Departament[list.size()]);
    };

    public Departament create( java.lang.String _nom_, java.lang.String _coordinadorid_, java.lang.String _nomldap_, java.lang.String _descripcio_) throws I18NException {
        DepartamentJPA __bean =  new DepartamentJPA(_nom_,_coordinadorid_,_nomldap_,_descripcio_);
        return create(__bean);
    }



 public void delete(long _departamentID_) {
   delete(findByPrimaryKey(_departamentID_));
 }




    public Departament findByPrimaryKey(long _departamentID_) {
        return __em.find(DepartamentJPA.class, _departamentID_);  
    }
    @Override
    protected Departament getJPAInstance(Departament __bean) {
        return convertToJPA(__bean);
    }


    public static DepartamentJPA convertToJPA(Departament __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof DepartamentJPA) {
        return (DepartamentJPA)__bean;
      }
      
      return DepartamentJPA.toJPA(__bean);
    }


}