
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;


public class ModificacioQueEsticFentBean implements ModificacioQueEsticFent {



	long modificacioID;// PK
	long accioID;
	java.lang.String usuariID;
	java.lang.Long projecteID;
	java.lang.Long queEsticFentID;
	java.lang.String dada1;
	java.lang.String dada2;
	java.sql.Timestamp data;


  /** Constructor Buit */
  public ModificacioQueEsticFentBean() {
  }

  /** Constructor amb tots els camps  */
  public ModificacioQueEsticFentBean(long modificacioID , long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2 , java.sql.Timestamp data) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public ModificacioQueEsticFentBean(long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2 , java.sql.Timestamp data) {
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor dels valors Not Null */
  public ModificacioQueEsticFentBean(long modificacioID , long accioID , java.lang.String usuariID) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
}
  public ModificacioQueEsticFentBean(ModificacioQueEsticFent __bean) {
    this.setModificacioID(__bean.getModificacioID());
    this.setAccioID(__bean.getAccioID());
    this.setUsuariID(__bean.getUsuariID());
    this.setProjecteID(__bean.getProjecteID());
    this.setQueEsticFentID(__bean.getQueEsticFentID());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
    this.setData(__bean.getData());
	}

	public long getModificacioID() {
		return(modificacioID);
	};
	public void setModificacioID(long _modificacioID_) {
		this.modificacioID = _modificacioID_;
	};

	public long getAccioID() {
		return(accioID);
	};
	public void setAccioID(long _accioID_) {
		this.accioID = _accioID_;
	};

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public java.lang.Long getProjecteID() {
		return(projecteID);
	};
	public void setProjecteID(java.lang.Long _projecteID_) {
		this.projecteID = _projecteID_;
	};

	public java.lang.Long getQueEsticFentID() {
		return(queEsticFentID);
	};
	public void setQueEsticFentID(java.lang.Long _queEsticFentID_) {
		this.queEsticFentID = _queEsticFentID_;
	};

	public java.lang.String getDada1() {
		return(dada1);
	};
	public void setDada1(java.lang.String _dada1_) {
		this.dada1 = _dada1_;
	};

	public java.lang.String getDada2() {
		return(dada2);
	};
	public void setDada2(java.lang.String _dada2_) {
		this.dada2 = _dada2_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};



  // ======================================

  public static ModificacioQueEsticFentBean toBean(ModificacioQueEsticFent __bean) {
    if (__bean == null) { return null;}
    ModificacioQueEsticFentBean __tmp = new ModificacioQueEsticFentBean();
    __tmp.setModificacioID(__bean.getModificacioID());
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setQueEsticFentID(__bean.getQueEsticFentID());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
    __tmp.setData(__bean.getData());
		return __tmp;
	}



}
