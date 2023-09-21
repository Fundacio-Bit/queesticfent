
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class UsuarisJPAManager
         extends AbstractJPAManager<Usuaris, String>
         implements UsuarisIJPAManager, IUsuarisManager, UsuarisFields {



    public static final TableName<Usuaris> _TABLENAME =  new TableName<Usuaris>("UsuarisJPA");


    @PersistenceContext
    protected EntityManager __em;

    public UsuarisJPAManager() {
    }

    protected UsuarisJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return UsuarisJPA. class;
    }



    public TableName<Usuaris> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Usuaris[] listToArray(List<Usuaris> list)  {
        if(list == null) { return null; };
        return list.toArray(new Usuaris[list.size()]);
    };

    public Usuaris create( java.lang.String _usuariId_, java.lang.String _llinatge1_, java.lang.String _llinatge2_, java.lang.String _nom_, java.lang.String _correu_, java.lang.String _descripcio_, java.lang.String _extensio_, java.sql.Date _naixement_, java.lang.String _telefoncasa_, java.lang.String _telefonmobil_, java.lang.String _contrasenya_) throws I18NException {
        UsuarisJPA __bean =  new UsuarisJPA(_usuariId_,_llinatge1_,_llinatge2_,_nom_,_correu_,_descripcio_,_extensio_,_naixement_,_telefoncasa_,_telefonmobil_,_contrasenya_);
        return create(__bean);
    }



 public void delete(java.lang.String _usuariId_) {
   delete(findByPrimaryKey(_usuariId_));
 }




    public Usuaris findByPrimaryKey(java.lang.String _usuariId_) {
        return __em.find(UsuarisJPA.class, _usuariId_);  
    }
    @Override
    protected Usuaris getJPAInstance(Usuaris __bean) {
        return convertToJPA(__bean);
    }


    public static UsuarisJPA convertToJPA(Usuaris __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof UsuarisJPA) {
        return (UsuarisJPA)__bean;
      }
      
      return UsuarisJPA.toJPA(__bean);
    }


}