
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Entrades;


public class EntradesBean implements Entrades {



	long entradaID;// PK
	long accioid;
	java.lang.String usuariid;
	java.lang.Long projecteid;
	java.lang.Long queesticfentid;
	java.lang.String dada1;
	java.lang.String dada2;
	java.sql.Time data;


  /** Constructor Buit */
  public EntradesBean() {
  }

  /** Constructor amb tots els camps  */
  public EntradesBean(long entradaID , long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2 , java.sql.Time data) {
    this.entradaID=entradaID;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public EntradesBean(long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2 , java.sql.Time data) {
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor dels valors Not Null */
  public EntradesBean(long entradaID , long accioid , java.lang.String usuariid , java.sql.Time data) {
    this.entradaID=entradaID;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.data=data;
}
  public EntradesBean(Entrades __bean) {
    this.setEntradaID(__bean.getEntradaID());
    this.setAccioid(__bean.getAccioid());
    this.setUsuariid(__bean.getUsuariid());
    this.setProjecteid(__bean.getProjecteid());
    this.setQueesticfentid(__bean.getQueesticfentid());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
    this.setData(__bean.getData());
	}

	public long getEntradaID() {
		return(entradaID);
	};
	public void setEntradaID(long _entradaID_) {
		this.entradaID = _entradaID_;
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

	public java.sql.Time getData() {
		return(data);
	};
	public void setData(java.sql.Time _data_) {
		this.data = _data_;
	};



  // ======================================

  public static EntradesBean toBean(Entrades __bean) {
    if (__bean == null) { return null;}
    EntradesBean __tmp = new EntradesBean();
    __tmp.setEntradaID(__bean.getEntradaID());
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setQueesticfentid(__bean.getQueesticfentid());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
    __tmp.setData(__bean.getData());
		return __tmp;
	}



}
