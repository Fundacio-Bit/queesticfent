
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;


public class UsuariDepartamentBean implements UsuariDepartament {



	long usuaridepartamentID;// PK
	java.lang.String usuariID;
	long departamentID;


  /** Constructor Buit */
  public UsuariDepartamentBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuariDepartamentBean(java.lang.String usuariID , long departamentID , long usuaridepartamentID) {
    this.usuariID=usuariID;
    this.departamentID=departamentID;
    this.usuaridepartamentID=usuaridepartamentID;
}
  /** Constructor sense valors autoincrementals */
  public UsuariDepartamentBean(java.lang.String usuariID , long departamentID) {
    this.usuariID=usuariID;
    this.departamentID=departamentID;
}
  public UsuariDepartamentBean(UsuariDepartament __bean) {
    this.setUsuariID(__bean.getUsuariID());
    this.setDepartamentID(__bean.getDepartamentID());
    this.setUsuaridepartamentID(__bean.getUsuaridepartamentID());
	}

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public long getDepartamentID() {
		return(departamentID);
	};
	public void setDepartamentID(long _departamentID_) {
		this.departamentID = _departamentID_;
	};

	public long getUsuaridepartamentID() {
		return(usuaridepartamentID);
	};
	public void setUsuaridepartamentID(long _usuaridepartamentID_) {
		this.usuaridepartamentID = _usuaridepartamentID_;
	};



  // ======================================

  public static UsuariDepartamentBean toBean(UsuariDepartament __bean) {
    if (__bean == null) { return null;}
    UsuariDepartamentBean __tmp = new UsuariDepartamentBean();
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setUsuaridepartamentID(__bean.getUsuaridepartamentID());
		return __tmp;
	}



}
