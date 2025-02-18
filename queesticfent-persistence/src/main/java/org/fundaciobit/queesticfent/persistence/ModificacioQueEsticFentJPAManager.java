
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ModificacioQueEsticFentJPAManager
         extends AbstractJPAManager<ModificacioQueEsticFent, Long>
         implements ModificacioQueEsticFentIJPAManager, IModificacioQueEsticFentManager, ModificacioQueEsticFentFields {



    public static final TableName<ModificacioQueEsticFent> _TABLENAME =  new TableName<ModificacioQueEsticFent>("ModificacioQueEsticFentJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ModificacioQueEsticFentJPAManager() {
    }

    protected ModificacioQueEsticFentJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ModificacioQueEsticFentJPA. class;
    }



    public TableName<ModificacioQueEsticFent> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public ModificacioQueEsticFent[] listToArray(List<ModificacioQueEsticFent> list)  {
        if(list == null) { return null; };
        return list.toArray(new ModificacioQueEsticFent[list.size()]);
    };

    public ModificacioQueEsticFent create( long _accioID_, java.lang.String _usuariID_, java.lang.Long _projecteID_, java.lang.Long _queEsticFentID_, java.lang.String _dada1_, java.lang.String _dada2_, java.sql.Timestamp _data_) throws I18NException {
        ModificacioQueEsticFentJPA __bean =  new ModificacioQueEsticFentJPA(_accioID_,_usuariID_,_projecteID_,_queEsticFentID_,_dada1_,_dada2_,_data_);
        return create(__bean);
    }



 public void delete(long _modificacioID_) {
   delete(findByPrimaryKey(_modificacioID_));
 }




    public ModificacioQueEsticFent findByPrimaryKey(long _modificacioID_) {
        return __em.find(ModificacioQueEsticFentJPA.class, _modificacioID_);  
    }
    @Override
    protected ModificacioQueEsticFent getJPAInstance(ModificacioQueEsticFent __bean) {
        return convertToJPA(__bean);
    }


    public static ModificacioQueEsticFentJPA convertToJPA(ModificacioQueEsticFent __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof ModificacioQueEsticFentJPA) {
        return (ModificacioQueEsticFentJPA)__bean;
      }
      
      return ModificacioQueEsticFentJPA.toJPA(__bean);
    }


}