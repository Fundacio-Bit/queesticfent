
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class FestiusJPAManager
         extends AbstractJPAManager<Festius, Long>
         implements FestiusIJPAManager, IFestiusManager, FestiusFields {



    public static final TableName<Festius> _TABLENAME =  new TableName<Festius>("FestiusJPA");


    @PersistenceContext
    protected EntityManager __em;

    public FestiusJPAManager() {
    }

    protected FestiusJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return FestiusJPA. class;
    }



    public TableName<Festius> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Festius[] listToArray(List<Festius> list)  {
        if(list == null) { return null; };
        return list.toArray(new Festius[list.size()]);
    };

    public Festius create( java.lang.String _nom_, java.sql.Date _data_, java.lang.String _descripcio_) throws I18NException {
        FestiusJPA __bean =  new FestiusJPA(_nom_,_data_,_descripcio_);
        return create(__bean);
    }



 public void delete(long _festiuID_) {
   delete(findByPrimaryKey(_festiuID_));
 }




    public Festius findByPrimaryKey(long _festiuID_) {
        return __em.find(FestiusJPA.class, _festiuID_);  
    }
    @Override
    protected Festius getJPAInstance(Festius __bean) {
        return convertToJPA(__bean);
    }


    public static FestiusJPA convertToJPA(Festius __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof FestiusJPA) {
        return (FestiusJPA)__bean;
      }
      
      return FestiusJPA.toJPA(__bean);
    }


}