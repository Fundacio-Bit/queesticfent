
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class GrupsJPAManager
         extends AbstractJPAManager<Grups, Long>
         implements GrupsIJPAManager, IGrupsManager, GrupsFields {



    public static final TableName<Grups> _TABLENAME =  new TableName<Grups>("GrupsJPA");


    @PersistenceContext
    protected EntityManager __em;

    public GrupsJPAManager() {
    }

    protected GrupsJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return GrupsJPA. class;
    }



    public TableName<Grups> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Grups[] listToArray(List<Grups> list)  {
        if(list == null) { return null; };
        return list.toArray(new Grups[list.size()]);
    };

    public Grups create( java.lang.String _nom_, java.lang.String _descripcio_, java.lang.Long _nivellseguretat_) throws I18NException {
        GrupsJPA __bean =  new GrupsJPA(_nom_,_descripcio_,_nivellseguretat_);
        return create(__bean);
    }



 public void delete(long _grupid_) {
   delete(findByPrimaryKey(_grupid_));
 }




    public Grups findByPrimaryKey(long _grupid_) {
        return __em.find(GrupsJPA.class, _grupid_);  
    }
    @Override
    protected Grups getJPAInstance(Grups __bean) {
        return convertToJPA(__bean);
    }


    public static GrupsJPA convertToJPA(Grups __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof GrupsJPA) {
        return (GrupsJPA)__bean;
      }
      
      return GrupsJPA.toJPA(__bean);
    }


}