
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;


public class UsuarisDepartamentBean implements UsuarisDepartament {



	long usuariDepartamentId;// PK
	java.lang.String usuariId;
	long departamentid;


  /** Constructor Buit */
  public UsuarisDepartamentBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuarisDepartamentBean(java.lang.String usuariId , long departamentid , long usuariDepartamentId) {
    this.usuariId=usuariId;
    this.departamentid=departamentid;
    this.usuariDepartamentId=usuariDepartamentId;
}
  /** Constructor sense valors autoincrementals */
  public UsuarisDepartamentBean(java.lang.String usuariId , long departamentid) {
    this.usuariId=usuariId;
    this.departamentid=departamentid;
}
  public UsuarisDepartamentBean(UsuarisDepartament __bean) {
    this.setUsuariId(__bean.getUsuariId());
    this.setDepartamentid(__bean.getDepartamentid());
    this.setUsuariDepartamentId(__bean.getUsuariDepartamentId());
	}

	public java.lang.String getUsuariId() {
		return(usuariId);
	};
	public void setUsuariId(java.lang.String _usuariId_) {
		this.usuariId = _usuariId_;
	};

	public long getDepartamentid() {
		return(departamentid);
	};
	public void setDepartamentid(long _departamentid_) {
		this.departamentid = _departamentid_;
	};

	public long getUsuariDepartamentId() {
		return(usuariDepartamentId);
	};
	public void setUsuariDepartamentId(long _usuariDepartamentId_) {
		this.usuariDepartamentId = _usuariDepartamentId_;
	};



  // ======================================

  public static UsuarisDepartamentBean toBean(UsuarisDepartament __bean) {
    if (__bean == null) { return null;}
    UsuarisDepartamentBean __tmp = new UsuarisDepartamentBean();
    __tmp.setUsuariId(__bean.getUsuariId());
    __tmp.setDepartamentid(__bean.getDepartamentid());
    __tmp.setUsuariDepartamentId(__bean.getUsuariDepartamentId());
		return __tmp;
	}



}
