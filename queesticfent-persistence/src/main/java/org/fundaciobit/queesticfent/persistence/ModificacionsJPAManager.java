
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ModificacionsJPAManager
         extends AbstractJPAManager<Modificacions, Long>
         implements ModificacionsIJPAManager, IModificacionsManager, ModificacionsFields {



    public static final TableName<Modificacions> _TABLENAME =  new TableName<Modificacions>("ModificacionsJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ModificacionsJPAManager() {
    }

    protected ModificacionsJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ModificacionsJPA. class;
    }



    public TableName<Modificacions> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Modificacions[] listToArray(List<Modificacions> list)  {
        if(list == null) { return null; };
        return list.toArray(new Modificacions[list.size()]);
    };

    public Modificacions create( long _entradaid_, long _accioid_, java.lang.String _oldusuariID_, java.lang.Long _oldprojecteID_, java.lang.Long _oldqueesticfentid_, java.lang.String _olddada1_, java.lang.String _olddada2_, java.sql.Timestamp _olddata_, java.lang.String _newusuariID_, java.lang.Long _newprojecteID_, java.lang.Long _newqueesticfentid_, java.lang.String _newdada1_, java.lang.String _newdada2_, java.sql.Timestamp _newdata_) throws I18NException {
        ModificacionsJPA __bean =  new ModificacionsJPA(_entradaid_,_accioid_,_oldusuariID_,_oldprojecteID_,_oldqueesticfentid_,_olddada1_,_olddada2_,_olddata_,_newusuariID_,_newprojecteID_,_newqueesticfentid_,_newdada1_,_newdada2_,_newdata_);
        return create(__bean);
    }



 public void delete(long _modificacioid_) {
   delete(findByPrimaryKey(_modificacioid_));
 }




    public Modificacions findByPrimaryKey(long _modificacioid_) {
        return __em.find(ModificacionsJPA.class, _modificacioid_);  
    }
    @Override
    protected Modificacions getJPAInstance(Modificacions __bean) {
        return convertToJPA(__bean);
    }


    public static ModificacionsJPA convertToJPA(Modificacions __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof ModificacionsJPA) {
        return (ModificacionsJPA)__bean;
      }
      
      return ModificacionsJPA.toJPA(__bean);
    }


}