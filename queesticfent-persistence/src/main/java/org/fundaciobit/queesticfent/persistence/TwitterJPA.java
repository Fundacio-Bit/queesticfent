
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;


@Entity(name = "TwitterJPA")
@Table(name = "qef_jos_twitter" , indexes = { 
        @Index(name="qef_jos_twitter_pk_i", columnList = "id")})
@SequenceGenerator(name="TWITTER_SEQ", sequenceName="qef_jos_twitter_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class TwitterJPA implements Twitter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TWITTER_SEQ")
    @Column(name="id",nullable = false,length = 19)
    long id;

    @Column(name="username",nullable = false,length = 25)
    java.lang.String username;

    @Column(name="comentario",length = 255)
    java.lang.String comentario;

    @Column(name="fecha",length = 13)
    java.sql.Date fecha;

    @Column(name="user_id",length = 19)
    java.lang.Long user_id;

    @Column(name="ip",length = 50)
    java.lang.String ip;



  /** Constructor Buit */
  public TwitterJPA() {
  }

  /** Constructor amb tots els camps  */
  public TwitterJPA(long id , java.lang.String username , java.lang.String comentario , java.sql.Date fecha , java.lang.Long user_id , java.lang.String ip) {
    this.id=id;
    this.username=username;
    this.comentario=comentario;
    this.fecha=fecha;
    this.user_id=user_id;
    this.ip=ip;
}
  /** Constructor sense valors autoincrementals */
  public TwitterJPA(java.lang.String username , java.lang.String comentario , java.sql.Date fecha , java.lang.Long user_id , java.lang.String ip) {
    this.username=username;
    this.comentario=comentario;
    this.fecha=fecha;
    this.user_id=user_id;
    this.ip=ip;
}
  /** Constructor dels valors Not Null */
  public TwitterJPA(long id , java.lang.String username) {
    this.id=id;
    this.username=username;
}
  public TwitterJPA(Twitter __bean) {
    this.setId(__bean.getId());
    this.setUsername(__bean.getUsername());
    this.setComentario(__bean.getComentario());
    this.setFecha(__bean.getFecha());
    this.setUser_id(__bean.getUser_id());
    this.setIp(__bean.getIp());
	}

	public long getId() {
		return(id);
	};
	public void setId(long _id_) {
		this.id = _id_;
	};

	public java.lang.String getUsername() {
		return(username);
	};
	public void setUsername(java.lang.String _username_) {
		this.username = _username_;
	};

	public java.lang.String getComentario() {
		return(comentario);
	};
	public void setComentario(java.lang.String _comentario_) {
		this.comentario = _comentario_;
	};

	public java.sql.Date getFecha() {
		return(fecha);
	};
	public void setFecha(java.sql.Date _fecha_) {
		this.fecha = _fecha_;
	};

	public java.lang.Long getUser_id() {
		return(user_id);
	};
	public void setUser_id(java.lang.Long _user_id_) {
		this.user_id = _user_id_;
	};

	public java.lang.String getIp() {
		return(ip);
	};
	public void setIp(java.lang.String _ip_) {
		this.ip = _ip_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Twitter) {
      Twitter __instance = (Twitter)__obj;
      __result = true;
      __result = __result && (this.getId() == __instance.getId()) ;
    } else {
      __result = false;
    }
    return __result;
  }


 // ---------------  STATIC METHODS ------------------
  public static TwitterJPA toJPA(Twitter __bean) {
    if (__bean == null) { return null;}
    TwitterJPA __tmp = new TwitterJPA();
    __tmp.setId(__bean.getId());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setComentario(__bean.getComentario());
    __tmp.setFecha(__bean.getFecha());
    __tmp.setUser_id(__bean.getUser_id());
    __tmp.setIp(__bean.getIp());
		return __tmp;
	}


  public static TwitterJPA copyJPA(TwitterJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<TwitterJPA> copyJPA(java.util.Set<TwitterJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<TwitterJPA> __tmpSet = (java.util.Set<TwitterJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<TwitterJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (TwitterJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static TwitterJPA copyJPA(TwitterJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    TwitterJPA __tmp = (TwitterJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
