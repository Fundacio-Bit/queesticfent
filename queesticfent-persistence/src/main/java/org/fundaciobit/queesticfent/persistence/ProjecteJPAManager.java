
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ProjecteJPAManager
         extends AbstractJPAManager<Projecte, Long>
         implements ProjecteIJPAManager, IProjecteManager, ProjecteFields {



    public static final TableName<Projecte> _TABLENAME =  new TableName<Projecte>("ProjecteJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ProjecteJPAManager() {
    }

    protected ProjecteJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ProjecteJPA. class;
    }



    public TableName<Projecte> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Projecte[] listToArray(List<Projecte> list)  {
        if(list == null) { return null; };
        return list.toArray(new Projecte[list.size()]);
    };

    public Projecte create( java.lang.String _nom_, long _departamentID_, java.lang.String _descripcio_, boolean _actiu_, java.sql.Date _fromdata_, java.sql.Date _todata_) throws I18NException {
        ProjecteJPA __bean =  new ProjecteJPA(_nom_,_departamentID_,_descripcio_,_actiu_,_fromdata_,_todata_);
        return create(__bean);
    }



 public void delete(long _projecteID_) {
   delete(findByPrimaryKey(_projecteID_));
 }




    public Projecte findByPrimaryKey(long _projecteID_) {
        return __em.find(ProjecteJPA.class, _projecteID_);  
    }
    @Override
    protected Projecte getJPAInstance(Projecte __bean) {
        return convertToJPA(__bean);
    }


    public static ProjecteJPA convertToJPA(Projecte __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof ProjecteJPA) {
        return (ProjecteJPA)__bean;
      }
      
      return ProjecteJPA.toJPA(__bean);
    }


}