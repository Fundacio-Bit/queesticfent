
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class EntradaJPAManager
         extends AbstractJPAManager<Entrada, Long>
         implements EntradaIJPAManager, IEntradaManager, EntradaFields {



    public static final TableName<Entrada> _TABLENAME =  new TableName<Entrada>("EntradaJPA");


    @PersistenceContext
    protected EntityManager __em;

    public EntradaJPAManager() {
    }

    protected EntradaJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return EntradaJPA. class;
    }



    public TableName<Entrada> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Entrada[] listToArray(List<Entrada> list)  {
        if(list == null) { return null; };
        return list.toArray(new Entrada[list.size()]);
    };

    public Entrada create( long _accioID_, java.lang.String _usuariID_, java.lang.Long _projecteID_, java.lang.String _dada1_, java.lang.Long _queEsticFentID_, java.lang.String _dada2_, java.sql.Timestamp _data_) throws I18NException {
        EntradaJPA __bean =  new EntradaJPA(_accioID_,_usuariID_,_projecteID_,_dada1_,_queEsticFentID_,_dada2_,_data_);
        return create(__bean);
    }



 public void delete(long _entradaID_) {
   delete(findByPrimaryKey(_entradaID_));
 }




    public Entrada findByPrimaryKey(long _entradaID_) {
        return __em.find(EntradaJPA.class, _entradaID_);  
    }
    @Override
    protected Entrada getJPAInstance(Entrada __bean) {
        return convertToJPA(__bean);
    }


    public static EntradaJPA convertToJPA(Entrada __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof EntradaJPA) {
        return (EntradaJPA)__bean;
      }
      
      return EntradaJPA.toJPA(__bean);
    }


}