
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;


public class UsuarisDepartamentBean implements UsuarisDepartament {



	long usuaridepartamentid;// PK
	java.lang.String usuariid;
	long departamentid;


  /** Constructor Buit */
  public UsuarisDepartamentBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuarisDepartamentBean(java.lang.String usuariid , long departamentid , long usuaridepartamentid) {
    this.usuariid=usuariid;
    this.departamentid=departamentid;
    this.usuaridepartamentid=usuaridepartamentid;
}
  /** Constructor sense valors autoincrementals */
  public UsuarisDepartamentBean(java.lang.String usuariid , long departamentid) {
    this.usuariid=usuariid;
    this.departamentid=departamentid;
}
  public UsuarisDepartamentBean(UsuarisDepartament __bean) {
    this.setUsuariid(__bean.getUsuariid());
    this.setDepartamentid(__bean.getDepartamentid());
    this.setUsuaridepartamentid(__bean.getUsuaridepartamentid());
	}

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public long getDepartamentid() {
		return(departamentid);
	};
	public void setDepartamentid(long _departamentid_) {
		this.departamentid = _departamentid_;
	};

	public long getUsuaridepartamentid() {
		return(usuaridepartamentid);
	};
	public void setUsuaridepartamentid(long _usuaridepartamentid_) {
		this.usuaridepartamentid = _usuaridepartamentid_;
	};



  // ======================================

  public static UsuarisDepartamentBean toBean(UsuarisDepartament __bean) {
    if (__bean == null) { return null;}
    UsuarisDepartamentBean __tmp = new UsuarisDepartamentBean();
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setDepartamentid(__bean.getDepartamentid());
    __tmp.setUsuaridepartamentid(__bean.getUsuaridepartamentid());
		return __tmp;
	}



}
