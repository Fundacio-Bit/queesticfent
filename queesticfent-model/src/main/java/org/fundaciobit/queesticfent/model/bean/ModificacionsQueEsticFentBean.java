
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;


public class ModificacionsQueEsticFentBean implements ModificacionsQueEsticFent {



	long modificacioid;// PK
	long accioid;
	java.lang.String usuariid;
	java.lang.Long projecteid;
	java.sql.Timestamp data;
	java.lang.Long queesticfentid;
	java.lang.String dada1;
	java.lang.String dada2;


  /** Constructor Buit */
  public ModificacionsQueEsticFentBean() {
  }

  /** Constructor amb tots els camps  */
  public ModificacionsQueEsticFentBean(long modificacioid , long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.sql.Timestamp data , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2) {
    this.modificacioid=modificacioid;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.data=data;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor sense valors autoincrementals */
  public ModificacionsQueEsticFentBean(long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.sql.Timestamp data , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2) {
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.data=data;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor dels valors Not Null */
  public ModificacionsQueEsticFentBean(long modificacioid , long accioid , java.lang.String usuariid , java.sql.Timestamp data) {
    this.modificacioid=modificacioid;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.data=data;
}
  public ModificacionsQueEsticFentBean(ModificacionsQueEsticFent __bean) {
    this.setModificacioid(__bean.getModificacioid());
    this.setAccioid(__bean.getAccioid());
    this.setUsuariid(__bean.getUsuariid());
    this.setProjecteid(__bean.getProjecteid());
    this.setData(__bean.getData());
    this.setQueesticfentid(__bean.getQueesticfentid());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
	}

	public long getModificacioid() {
		return(modificacioid);
	};
	public void setModificacioid(long _modificacioid_) {
		this.modificacioid = _modificacioid_;
	};

	public long getAccioid() {
		return(accioid);
	};
	public void setAccioid(long _accioid_) {
		this.accioid = _accioid_;
	};

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public java.lang.Long getProjecteid() {
		return(projecteid);
	};
	public void setProjecteid(java.lang.Long _projecteid_) {
		this.projecteid = _projecteid_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public java.lang.Long getQueesticfentid() {
		return(queesticfentid);
	};
	public void setQueesticfentid(java.lang.Long _queesticfentid_) {
		this.queesticfentid = _queesticfentid_;
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
    __tmp.setModificacioid(__bean.getModificacioid());
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setData(__bean.getData());
    __tmp.setQueesticfentid(__bean.getQueesticfentid());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
		return __tmp;
	}



}
