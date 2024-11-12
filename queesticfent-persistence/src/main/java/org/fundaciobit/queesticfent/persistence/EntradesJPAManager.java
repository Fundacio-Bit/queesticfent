
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class EntradesJPAManager
         extends AbstractJPAManager<Entrades, Long>
         implements EntradesIJPAManager, IEntradesManager, EntradesFields {



    public static final TableName<Entrades> _TABLENAME =  new TableName<Entrades>("EntradesJPA");


    @PersistenceContext
    protected EntityManager __em;

    public EntradesJPAManager() {
    }

    protected EntradesJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return EntradesJPA. class;
    }



    public TableName<Entrades> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Entrades[] listToArray(List<Entrades> list)  {
        if(list == null) { return null; };
        return list.toArray(new Entrades[list.size()]);
    };

    public Entrades create( long _accioid_, java.lang.String _usuariid_, java.lang.Long _projecteid_, java.lang.Long _queesticfentid_, java.lang.String _dada1_, java.lang.String _dada2_, java.sql.Time _data_) throws I18NException {
        EntradesJPA __bean =  new EntradesJPA(_accioid_,_usuariid_,_projecteid_,_queesticfentid_,_dada1_,_dada2_,_data_);
        return create(__bean);
    }



 public void delete(long _entradaID_) {
   delete(findByPrimaryKey(_entradaID_));
 }




    public Entrades findByPrimaryKey(long _entradaID_) {
        return __em.find(EntradesJPA.class, _entradaID_);  
    }
    @Override
    protected Entrades getJPAInstance(Entrades __bean) {
        return convertToJPA(__bean);
    }


    public static EntradesJPA convertToJPA(Entrades __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof EntradesJPA) {
        return (EntradesJPA)__bean;
      }
      
      return EntradesJPA.toJPA(__bean);
    }


}