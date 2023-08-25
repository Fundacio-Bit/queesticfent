
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Twitter;


public class TwitterBean implements Twitter {



	long id;// PK
	java.lang.String username;
	java.lang.String comentario;
	java.sql.Date fecha;
	java.lang.Long user_id;
	java.lang.String ip;


  /** Constructor Buit */
  public TwitterBean() {
  }

  /** Constructor amb tots els camps  */
  public TwitterBean(long id , java.lang.String username , java.lang.String comentario , java.sql.Date fecha , java.lang.Long user_id , java.lang.String ip) {
    this.id=id;
    this.username=username;
    this.comentario=comentario;
    this.fecha=fecha;
    this.user_id=user_id;
    this.ip=ip;
}
  /** Constructor sense valors autoincrementals */
  public TwitterBean(java.lang.String username , java.lang.String comentario , java.sql.Date fecha , java.lang.Long user_id , java.lang.String ip) {
    this.username=username;
    this.comentario=comentario;
    this.fecha=fecha;
    this.user_id=user_id;
    this.ip=ip;
}
  /** Constructor dels valors Not Null */
  public TwitterBean(long id , java.lang.String username) {
    this.id=id;
    this.username=username;
}
  public TwitterBean(Twitter __bean) {
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



  // ======================================

  public static TwitterBean toBean(Twitter __bean) {
    if (__bean == null) { return null;}
    TwitterBean __tmp = new TwitterBean();
    __tmp.setId(__bean.getId());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setComentario(__bean.getComentario());
    __tmp.setFecha(__bean.getFecha());
    __tmp.setUser_id(__bean.getUser_id());
    __tmp.setIp(__bean.getIp());
		return __tmp;
	}



}
