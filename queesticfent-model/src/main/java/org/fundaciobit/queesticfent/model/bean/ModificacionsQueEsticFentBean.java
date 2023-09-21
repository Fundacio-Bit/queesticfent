
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;


public class ModificacionsQueEsticFentBean implements ModificacionsQueEsticFent {



	long modificacioID;// PK
	long accioID;
	java.lang.String usuariID;
	java.lang.Long projecteID;
	java.sql.Timestamp data;
	java.lang.Long queEsticFentID;
	java.lang.String dada1;
	java.lang.String dada2;


  /** Constructor Buit */
  public ModificacionsQueEsticFentBean() {
  }

  /** Constructor amb tots els camps  */
  public ModificacionsQueEsticFentBean(long modificacioID , long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.sql.Timestamp data , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.data=data;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor sense valors autoincrementals */
  public ModificacionsQueEsticFentBean(long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.sql.Timestamp data , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2) {
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.data=data;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor dels valors Not Null */
  public ModificacionsQueEsticFentBean(long modificacioID , long accioID , java.lang.String usuariID , java.sql.Timestamp data) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.data=data;
}
  public ModificacionsQueEsticFentBean(ModificacionsQueEsticFent __bean) {
    this.setModificacioID(__bean.getModificacioID());
    this.setAccioID(__bean.getAccioID());
    this.setUsuariID(__bean.getUsuariID());
    this.setProjecteID(__bean.getProjecteID());
    this.setData(__bean.getData());
    this.setQueEsticFentID(__bean.getQueEsticFentID());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
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

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
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



  // ======================================

  public static ModificacionsQueEsticFentBean toBean(ModificacionsQueEsticFent __bean) {
    if (__bean == null) { return null;}
    ModificacionsQueEsticFentBean __tmp = new ModificacionsQueEsticFentBean();
    __tmp.setModificacioID(__bean.getModificacioID());
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setData(__bean.getData());
    __tmp.setQueEsticFentID(__bean.getQueEsticFentID());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
		return __tmp;
	}



}
