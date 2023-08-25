
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ModificacionsQueEsticFentJPAManager
         extends AbstractJPAManager<ModificacionsQueEsticFent, Long>
         implements ModificacionsQueEsticFentIJPAManager, IModificacionsQueEsticFentManager, ModificacionsQueEsticFentFields {



    public static final TableName<ModificacionsQueEsticFent> _TABLENAME =  new TableName<ModificacionsQueEsticFent>("ModificacionsQueEsticFentJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ModificacionsQueEsticFentJPAManager() {
    }

    protected ModificacionsQueEsticFentJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ModificacionsQueEsticFentJPA. class;
    }



    public TableName<ModificacionsQueEsticFent> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public ModificacionsQueEsticFent[] listToArray(List<ModificacionsQueEsticFent> list)  {
        if(list == null) { return null; };
        return list.toArray(new ModificacionsQueEsticFent[list.size()]);
    };

    public ModificacionsQueEsticFent create( long _accioid_, java.lang.String _usuariid_, java.lang.Long _projecteid_, java.sql.Timestamp _data_, java.lang.Long _queesticfentid_, java.lang.String _dada1_, java.lang.String _dada2_) throws I18NException {
        ModificacionsQueEsticFentJPA __bean =  new ModificacionsQueEsticFentJPA(_accioid_,_usuariid_,_projecteid_,_data_,_queesticfentid_,_dada1_,_dada2_);
        return create(__bean);
    }



 public void delete(long _modificacioid_) {
   delete(findByPrimaryKey(_modificacioid_));
 }




    public ModificacionsQueEsticFent findByPrimaryKey(long _modificacioid_) {
        return __em.find(ModificacionsQueEsticFentJPA.class, _modificacioid_);  
    }
    @Override
    protected ModificacionsQueEsticFent getJPAInstance(ModificacionsQueEsticFent __bean) {
        return convertToJPA(__bean);
    }


    public static ModificacionsQueEsticFentJPA convertToJPA(ModificacionsQueEsticFent __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof ModificacionsQueEsticFentJPA) {
        return (ModificacionsQueEsticFentJPA)__bean;
      }
      
      return ModificacionsQueEsticFentJPA.toJPA(__bean);
    }


}