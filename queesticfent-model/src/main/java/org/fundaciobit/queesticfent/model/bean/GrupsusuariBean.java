
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Grupsusuari;


public class GrupsusuariBean implements Grupsusuari {



	long grupsUsuariID;// PK
	java.lang.String usuariID;
	long grupID;


  /** Constructor Buit */
  public GrupsusuariBean() {
  }

  /** Constructor amb tots els camps  */
  public GrupsusuariBean(long grupsUsuariID , java.lang.String usuariID , long grupID) {
    this.grupsUsuariID=grupsUsuariID;
    this.usuariID=usuariID;
    this.grupID=grupID;
}
  /** Constructor sense valors autoincrementals */
  public GrupsusuariBean(java.lang.String usuariID , long grupID) {
    this.usuariID=usuariID;
    this.grupID=grupID;
}
  public GrupsusuariBean(Grupsusuari __bean) {
    this.setGrupsUsuariID(__bean.getGrupsUsuariID());
    this.setUsuariID(__bean.getUsuariID());
    this.setGrupID(__bean.getGrupID());
	}

	public long getGrupsUsuariID() {
		return(grupsUsuariID);
	};
	public void setGrupsUsuariID(long _grupsUsuariID_) {
		this.grupsUsuariID = _grupsUsuariID_;
	};

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public long getGrupID() {
		return(grupID);
	};
	public void setGrupID(long _grupID_) {
		this.grupID = _grupID_;
	};



  // ======================================

  public static GrupsusuariBean toBean(Grupsusuari __bean) {
    if (__bean == null) { return null;}
    GrupsusuariBean __tmp = new GrupsusuariBean();
    __tmp.setGrupsUsuariID(__bean.getGrupsUsuariID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setGrupID(__bean.getGrupID());
		return __tmp;
	}



}
