
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;


public class UsuarisDepartamentBean implements UsuarisDepartament {



	long usuariDepartamentID;// PK
	java.lang.String usuariID;
	long departamentID;


  /** Constructor Buit */
  public UsuarisDepartamentBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuarisDepartamentBean(long usuariDepartamentID , java.lang.String usuariID , long departamentID) {
    this.usuariDepartamentID=usuariDepartamentID;
    this.usuariID=usuariID;
    this.departamentID=departamentID;
}
  /** Constructor sense valors autoincrementals */
  public UsuarisDepartamentBean(java.lang.String usuariID , long departamentID) {
    this.usuariID=usuariID;
    this.departamentID=departamentID;
}
  public UsuarisDepartamentBean(UsuarisDepartament __bean) {
    this.setUsuariDepartamentID(__bean.getUsuariDepartamentID());
    this.setUsuariID(__bean.getUsuariID());
    this.setDepartamentID(__bean.getDepartamentID());
	}

	public long getUsuariDepartamentID() {
		return(usuariDepartamentID);
	};
	public void setUsuariDepartamentID(long _usuariDepartamentID_) {
		this.usuariDepartamentID = _usuariDepartamentID_;
	};

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



  // ======================================

  public static UsuarisDepartamentBean toBean(UsuarisDepartament __bean) {
    if (__bean == null) { return null;}
    UsuarisDepartamentBean __tmp = new UsuarisDepartamentBean();
    __tmp.setUsuariDepartamentID(__bean.getUsuariDepartamentID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setDepartamentID(__bean.getDepartamentID());
		return __tmp;
	}



}
