
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class DepartamentsJPAManager
         extends AbstractJPAManager<Departaments, Long>
         implements DepartamentsIJPAManager, IDepartamentsManager, DepartamentsFields {



    public static final TableName<Departaments> _TABLENAME =  new TableName<Departaments>("DepartamentsJPA");


    @PersistenceContext
    protected EntityManager __em;

    public DepartamentsJPAManager() {
    }

    protected DepartamentsJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return DepartamentsJPA. class;
    }



    public TableName<Departaments> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Departaments[] listToArray(List<Departaments> list)  {
        if(list == null) { return null; };
        return list.toArray(new Departaments[list.size()]);
    };

    public Departaments create( java.lang.String _nom_, java.lang.String _coordinadorid_, java.lang.String _nomldap_, java.lang.String _descripcio_) throws I18NException {
        DepartamentsJPA __bean =  new DepartamentsJPA(_nom_,_coordinadorid_,_nomldap_,_descripcio_);
        return create(__bean);
    }



 public void delete(long _departamentid_) {
   delete(findByPrimaryKey(_departamentid_));
 }




    public Departaments findByPrimaryKey(long _departamentid_) {
        return __em.find(DepartamentsJPA.class, _departamentid_);  
    }
    @Override
    protected Departaments getJPAInstance(Departaments __bean) {
        return convertToJPA(__bean);
    }


    public static DepartamentsJPA convertToJPA(Departaments __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof DepartamentsJPA) {
        return (DepartamentsJPA)__bean;
      }
      
      return DepartamentsJPA.toJPA(__bean);
    }


}