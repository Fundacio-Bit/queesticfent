
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class GrupsusuariJPAManager
         extends AbstractJPAManager<Grupsusuari, Long>
         implements GrupsusuariIJPAManager, IGrupsusuariManager, GrupsusuariFields {



    public static final TableName<Grupsusuari> _TABLENAME =  new TableName<Grupsusuari>("GrupsusuariJPA");


    @PersistenceContext
    protected EntityManager __em;

    public GrupsusuariJPAManager() {
    }

    protected GrupsusuariJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return GrupsusuariJPA. class;
    }



    public TableName<Grupsusuari> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Grupsusuari[] listToArray(List<Grupsusuari> list)  {
        if(list == null) { return null; };
        return list.toArray(new Grupsusuari[list.size()]);
    };

    public Grupsusuari create( java.lang.String _usuariID_, long _grupID_) throws I18NException {
        GrupsusuariJPA __bean =  new GrupsusuariJPA(_usuariID_,_grupID_);
        return create(__bean);
    }



 public void delete(long _grupsUsuariID_) {
   delete(findByPrimaryKey(_grupsUsuariID_));
 }




    public Grupsusuari findByPrimaryKey(long _grupsUsuariID_) {
        return __em.find(GrupsusuariJPA.class, _grupsUsuariID_);  
    }
    @Override
    protected Grupsusuari getJPAInstance(Grupsusuari __bean) {
        return convertToJPA(__bean);
    }


    public static GrupsusuariJPA convertToJPA(Grupsusuari __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof GrupsusuariJPA) {
        return (GrupsusuariJPA)__bean;
      }
      
      return GrupsusuariJPA.toJPA(__bean);
    }


}