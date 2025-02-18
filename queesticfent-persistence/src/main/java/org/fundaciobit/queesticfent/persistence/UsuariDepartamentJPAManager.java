
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class UsuariDepartamentJPAManager
         extends AbstractJPAManager<UsuariDepartament, Long>
         implements UsuariDepartamentIJPAManager, IUsuariDepartamentManager, UsuariDepartamentFields {



    public static final TableName<UsuariDepartament> _TABLENAME =  new TableName<UsuariDepartament>("UsuariDepartamentJPA");


    @PersistenceContext
    protected EntityManager __em;

    public UsuariDepartamentJPAManager() {
    }

    protected UsuariDepartamentJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return UsuariDepartamentJPA. class;
    }



    public TableName<UsuariDepartament> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public UsuariDepartament[] listToArray(List<UsuariDepartament> list)  {
        if(list == null) { return null; };
        return list.toArray(new UsuariDepartament[list.size()]);
    };

    public UsuariDepartament create( java.lang.String _usuariID_, long _departamentID_) throws I18NException {
        UsuariDepartamentJPA __bean =  new UsuariDepartamentJPA(_usuariID_,_departamentID_);
        return create(__bean);
    }



 public void delete(long _usuaridepartamentID_) {
   delete(findByPrimaryKey(_usuaridepartamentID_));
 }




    public UsuariDepartament findByPrimaryKey(long _usuaridepartamentID_) {
        return __em.find(UsuariDepartamentJPA.class, _usuaridepartamentID_);  
    }
    @Override
    protected UsuariDepartament getJPAInstance(UsuariDepartament __bean) {
        return convertToJPA(__bean);
    }


    public static UsuariDepartamentJPA convertToJPA(UsuariDepartament __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof UsuariDepartamentJPA) {
        return (UsuariDepartamentJPA)__bean;
      }
      
      return UsuariDepartamentJPA.toJPA(__bean);
    }


}