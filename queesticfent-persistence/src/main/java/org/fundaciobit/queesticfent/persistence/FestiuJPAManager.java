
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class FestiuJPAManager
         extends AbstractJPAManager<Festiu, Long>
         implements FestiuIJPAManager, IFestiuManager, FestiuFields {



    public static final TableName<Festiu> _TABLENAME =  new TableName<Festiu>("FestiuJPA");


    @PersistenceContext
    protected EntityManager __em;

    public FestiuJPAManager() {
    }

    protected FestiuJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return FestiuJPA. class;
    }



    public TableName<Festiu> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Festiu[] listToArray(List<Festiu> list)  {
        if(list == null) { return null; };
        return list.toArray(new Festiu[list.size()]);
    };

    public Festiu create( java.lang.String _nom_, java.sql.Date _data_, java.lang.String _descripcio_) throws I18NException {
        FestiuJPA __bean =  new FestiuJPA(_nom_,_data_,_descripcio_);
        return create(__bean);
    }



 public void delete(long _festiuID_) {
   delete(findByPrimaryKey(_festiuID_));
 }




    public Festiu findByPrimaryKey(long _festiuID_) {
        return __em.find(FestiuJPA.class, _festiuID_);  
    }
    @Override
    protected Festiu getJPAInstance(Festiu __bean) {
        return convertToJPA(__bean);
    }


    public static FestiuJPA convertToJPA(Festiu __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof FestiuJPA) {
        return (FestiuJPA)__bean;
      }
      
      return FestiuJPA.toJPA(__bean);
    }


}