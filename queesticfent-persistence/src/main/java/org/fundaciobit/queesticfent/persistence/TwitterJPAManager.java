
package org.fundaciobit.queesticfent.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.queesticfent.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class TwitterJPAManager
         extends AbstractJPAManager<Twitter, Long>
         implements TwitterIJPAManager, ITwitterManager, TwitterFields {



    public static final TableName<Twitter> _TABLENAME =  new TableName<Twitter>("TwitterJPA");


    @PersistenceContext
    protected EntityManager __em;

    public TwitterJPAManager() {
    }

    protected TwitterJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return TwitterJPA. class;
    }



    public TableName<Twitter> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Twitter[] listToArray(List<Twitter> list)  {
        if(list == null) { return null; };
        return list.toArray(new Twitter[list.size()]);
    };

    public Twitter create( java.lang.String _username_, java.lang.String _comentario_, java.sql.Date _fecha_, java.lang.Long _user_id_, java.lang.String _ip_) throws I18NException {
        TwitterJPA __bean =  new TwitterJPA(_username_,_comentario_,_fecha_,_user_id_,_ip_);
        return create(__bean);
    }



 public void delete(long _id_) {
   delete(findByPrimaryKey(_id_));
 }




    public Twitter findByPrimaryKey(long _id_) {
        return __em.find(TwitterJPA.class, _id_);  
    }
    @Override
    protected Twitter getJPAInstance(Twitter __bean) {
        return convertToJPA(__bean);
    }


    public static TwitterJPA convertToJPA(Twitter __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof TwitterJPA) {
        return (TwitterJPA)__bean;
      }
      
      return TwitterJPA.toJPA(__bean);
    }


}