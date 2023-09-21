
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class AccionsJPAManager
         extends AbstractJPAManager<Accions, Long>
         implements AccionsIJPAManager, IAccionsManager, AccionsFields {



    public static final TableName<Accions> _TABLENAME =  new TableName<Accions>("AccionsJPA");


    @PersistenceContext
    protected EntityManager __em;

    public AccionsJPAManager() {
    }

    protected AccionsJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return AccionsJPA. class;
    }



    public TableName<Accions> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Accions[] listToArray(List<Accions> list)  {
        if(list == null) { return null; };
        return list.toArray(new Accions[list.size()]);
    };

    public Accions create( java.lang.String _nom_, java.lang.String _nomLlegenda_, java.lang.String _color_, java.lang.String _descripcio_) throws I18NException {
        AccionsJPA __bean =  new AccionsJPA(_nom_,_nomLlegenda_,_color_,_descripcio_);
        return create(__bean);
    }



 public void delete(long _accioId_) {
   delete(findByPrimaryKey(_accioId_));
 }




    public Accions findByPrimaryKey(long _accioId_) {
        return __em.find(AccionsJPA.class, _accioId_);  
    }
    @Override
    protected Accions getJPAInstance(Accions __bean) {
        return convertToJPA(__bean);
    }


    public static AccionsJPA convertToJPA(Accions __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof AccionsJPA) {
        return (AccionsJPA)__bean;
      }
      
      return AccionsJPA.toJPA(__bean);
    }


}