
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class AccioJPAManager
         extends AbstractJPAManager<Accio, Long>
         implements AccioIJPAManager, IAccioManager, AccioFields {



    public static final TableName<Accio> _TABLENAME =  new TableName<Accio>("AccioJPA");


    @PersistenceContext
    protected EntityManager __em;

    public AccioJPAManager() {
    }

    protected AccioJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return AccioJPA. class;
    }



    public TableName<Accio> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Accio[] listToArray(List<Accio> list)  {
        if(list == null) { return null; };
        return list.toArray(new Accio[list.size()]);
    };

    public Accio create( java.lang.String _nom_, java.lang.String _nomllegenda_, java.lang.String _color_, java.lang.String _descripcio_) throws I18NException {
        AccioJPA __bean =  new AccioJPA(_nom_,_nomllegenda_,_color_,_descripcio_);
        return create(__bean);
    }



 public void delete(long _accioID_) {
   delete(findByPrimaryKey(_accioID_));
 }




    public Accio findByPrimaryKey(long _accioID_) {
        return __em.find(AccioJPA.class, _accioID_);  
    }
    @Override
    protected Accio getJPAInstance(Accio __bean) {
        return convertToJPA(__bean);
    }


    public static AccioJPA convertToJPA(Accio __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof AccioJPA) {
        return (AccioJPA)__bean;
      }
      
      return AccioJPA.toJPA(__bean);
    }


}