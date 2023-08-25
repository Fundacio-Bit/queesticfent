
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ProjectesJPAManager
         extends AbstractJPAManager<Projectes, Long>
         implements ProjectesIJPAManager, IProjectesManager, ProjectesFields {



    public static final TableName<Projectes> _TABLENAME =  new TableName<Projectes>("ProjectesJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ProjectesJPAManager() {
    }

    protected ProjectesJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ProjectesJPA. class;
    }



    public TableName<Projectes> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Projectes[] listToArray(List<Projectes> list)  {
        if(list == null) { return null; };
        return list.toArray(new Projectes[list.size()]);
    };

    public Projectes create( java.lang.String _nom_, long _departamentid_, java.lang.String _descripcio_, boolean _actiu_, java.sql.Date _fromdata_, java.sql.Date _todata_, boolean _actiu2_) throws I18NException {
        ProjectesJPA __bean =  new ProjectesJPA(_nom_,_departamentid_,_descripcio_,_actiu_,_fromdata_,_todata_,_actiu2_);
        return create(__bean);
    }



 public void delete(long _projecteid_) {
   delete(findByPrimaryKey(_projecteid_));
 }




    public Projectes findByPrimaryKey(long _projecteid_) {
        return __em.find(ProjectesJPA.class, _projecteid_);  
    }
    @Override
    protected Projectes getJPAInstance(Projectes __bean) {
        return convertToJPA(__bean);
    }


    public static ProjectesJPA convertToJPA(Projectes __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof ProjectesJPA) {
        return (ProjectesJPA)__bean;
      }
      
      return ProjectesJPA.toJPA(__bean);
    }


}