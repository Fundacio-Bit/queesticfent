
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Grupsusuari;


public class GrupsusuariBean implements Grupsusuari {



	long grupsusuariid;// PK
	java.lang.String usuariid;
	long grupid;


  /** Constructor Buit */
  public GrupsusuariBean() {
  }

  /** Constructor amb tots els camps  */
  public GrupsusuariBean(long grupsusuariid , java.lang.String usuariid , long grupid) {
    this.grupsusuariid=grupsusuariid;
    this.usuariid=usuariid;
    this.grupid=grupid;
}
  /** Constructor sense valors autoincrementals */
  public GrupsusuariBean(java.lang.String usuariid , long grupid) {
    this.usuariid=usuariid;
    this.grupid=grupid;
}
  public GrupsusuariBean(Grupsusuari __bean) {
    this.setGrupsusuariid(__bean.getGrupsusuariid());
    this.setUsuariid(__bean.getUsuariid());
    this.setGrupid(__bean.getGrupid());
	}

	public long getGrupsusuariid() {
		return(grupsusuariid);
	};
	public void setGrupsusuariid(long _grupsusuariid_) {
		this.grupsusuariid = _grupsusuariid_;
	};

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public long getGrupid() {
		return(grupid);
	};
	public void setGrupid(long _grupid_) {
		this.grupid = _grupid_;
	};



  // ======================================

  public static GrupsusuariBean toBean(Grupsusuari __bean) {
    if (__bean == null) { return null;}
    GrupsusuariBean __tmp = new GrupsusuariBean();
    __tmp.setGrupsusuariid(__bean.getGrupsusuariid());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setGrupid(__bean.getGrupid());
		return __tmp;
	}



}
