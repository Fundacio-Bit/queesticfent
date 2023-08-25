
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class UsuarisDepartamentJPAManager
         extends AbstractJPAManager<UsuarisDepartament, Long>
         implements UsuarisDepartamentIJPAManager, IUsuarisDepartamentManager, UsuarisDepartamentFields {



    public static final TableName<UsuarisDepartament> _TABLENAME =  new TableName<UsuarisDepartament>("UsuarisDepartamentJPA");


    @PersistenceContext
    protected EntityManager __em;

    public UsuarisDepartamentJPAManager() {
    }

    protected UsuarisDepartamentJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return UsuarisDepartamentJPA. class;
    }



    public TableName<UsuarisDepartament> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public UsuarisDepartament[] listToArray(List<UsuarisDepartament> list)  {
        if(list == null) { return null; };
        return list.toArray(new UsuarisDepartament[list.size()]);
    };

    public UsuarisDepartament create( java.lang.String _usuariid_, long _departamentid_) throws I18NException {
        UsuarisDepartamentJPA __bean =  new UsuarisDepartamentJPA(_usuariid_,_departamentid_);
        return create(__bean);
    }



 public void delete(long _usuaridepartamentid_) {
   delete(findByPrimaryKey(_usuaridepartamentid_));
 }




    public UsuarisDepartament findByPrimaryKey(long _usuaridepartamentid_) {
        return __em.find(UsuarisDepartamentJPA.class, _usuaridepartamentid_);  
    }
    @Override
    protected UsuarisDepartament getJPAInstance(UsuarisDepartament __bean) {
        return convertToJPA(__bean);
    }


    public static UsuarisDepartamentJPA convertToJPA(UsuarisDepartament __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof UsuarisDepartamentJPA) {
        return (UsuarisDepartamentJPA)__bean;
      }
      
      return UsuarisDepartamentJPA.toJPA(__bean);
    }


}