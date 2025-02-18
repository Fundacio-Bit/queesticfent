
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Modificacio;


public class ModificacionsBean implements Modificacio {



	long modificacioid;// PK
	long entradaid;
	long accioid;
	java.lang.String oldusuariID;
	java.lang.Long oldprojecteID;
	java.lang.Long oldqueesticfentid;
	java.lang.String olddada1;
	java.lang.String olddada2;
	java.sql.Timestamp olddata;
	java.lang.String newusuariID;
	java.lang.Long newprojecteID;
	java.lang.Long newqueesticfentid;
	java.lang.String newdada1;
	java.lang.String newdada2;
	java.sql.Timestamp newdata;


  /** Constructor Buit */
  public ModificacionsBean() {
  }

  /** Constructor amb tots els camps  */
  public ModificacionsBean(long modificacioid , long entradaid , long accioid , java.lang.String oldusuariID , java.lang.Long oldprojecteID , java.lang.Long oldqueesticfentid , java.lang.String olddada1 , java.lang.String olddada2 , java.sql.Timestamp olddata , java.lang.String newusuariID , java.lang.Long newprojecteID , java.lang.Long newqueesticfentid , java.lang.String newdada1 , java.lang.String newdada2 , java.sql.Timestamp newdata) {
    this.modificacioid=modificacioid;
    this.entradaid=entradaid;
    this.accioid=accioid;
    this.oldusuariID=oldusuariID;
    this.oldprojecteID=oldprojecteID;
    this.oldqueesticfentid=oldqueesticfentid;
    this.olddada1=olddada1;
    this.olddada2=olddada2;
    this.olddata=olddata;
    this.newusuariID=newusuariID;
    this.newprojecteID=newprojecteID;
    this.newqueesticfentid=newqueesticfentid;
    this.newdada1=newdada1;
    this.newdada2=newdada2;
    this.newdata=newdata;
}
  /** Constructor sense valors autoincrementals */
  public ModificacionsBean(long entradaid , long accioid , java.lang.String oldusuariID , java.lang.Long oldprojecteID , java.lang.Long oldqueesticfentid , java.lang.String olddada1 , java.lang.String olddada2 , java.sql.Timestamp olddata , java.lang.String newusuariID , java.lang.Long newprojecteID , java.lang.Long newqueesticfentid , java.lang.String newdada1 , java.lang.String newdada2 , java.sql.Timestamp newdata) {
    this.entradaid=entradaid;
    this.accioid=accioid;
    this.oldusuariID=oldusuariID;
    this.oldprojecteID=oldprojecteID;
    this.oldqueesticfentid=oldqueesticfentid;
    this.olddada1=olddada1;
    this.olddada2=olddada2;
    this.olddata=olddata;
    this.newusuariID=newusuariID;
    this.newprojecteID=newprojecteID;
    this.newqueesticfentid=newqueesticfentid;
    this.newdada1=newdada1;
    this.newdada2=newdada2;
    this.newdata=newdata;
}
  /** Constructor dels valors Not Null */
  public ModificacionsBean(long modificacioid , long entradaid , long accioid , java.lang.String oldusuariID , java.sql.Timestamp olddata , java.lang.String newusuariID , java.sql.Timestamp newdata) {
    this.modificacioid=modificacioid;
    this.entradaid=entradaid;
    this.accioid=accioid;
    this.oldusuariID=oldusuariID;
    this.olddata=olddata;
    this.newusuariID=newusuariID;
    this.newdata=newdata;
}
  public ModificacionsBean(Modificacio __bean) {
    this.setModificacioid(__bean.getModificacioid());
    this.setEntradaid(__bean.getEntradaid());
    this.setAccioid(__bean.getAccioid());
    this.setOldusuariID(__bean.getOldusuariID());
    this.setOldprojecteID(__bean.getOldprojecteID());
    this.setOldqueesticfentid(__bean.getOldqueesticfentid());
    this.setOlddada1(__bean.getOlddada1());
    this.setOlddada2(__bean.getOlddada2());
    this.setOlddata(__bean.getOlddata());
    this.setNewusuariID(__bean.getNewusuariID());
    this.setNewprojecteID(__bean.getNewprojecteID());
    this.setNewqueesticfentid(__bean.getNewqueesticfentid());
    this.setNewdada1(__bean.getNewdada1());
    this.setNewdada2(__bean.getNewdada2());
    this.setNewdata(__bean.getNewdata());
	}

	public long getModificacioid() {
		return(modificacioid);
	};
	public void setModificacioid(long _modificacioid_) {
		this.modificacioid = _modificacioid_;
	};

	public long getEntradaid() {
		return(entradaid);
	};
	public void setEntradaid(long _entradaid_) {
		this.entradaid = _entradaid_;
	};

	public long getAccioid() {
		return(accioid);
	};
	public void setAccioid(long _accioid_) {
		this.accioid = _accioid_;
	};

	public java.lang.String getOldusuariID() {
		return(oldusuariID);
	};
	public void setOldusuariID(java.lang.String _oldusuariID_) {
		this.oldusuariID = _oldusuariID_;
	};

	public java.lang.Long getOldprojecteID() {
		return(oldprojecteID);
	};
	public void setOldprojecteID(java.lang.Long _oldprojecteID_) {
		this.oldprojecteID = _oldprojecteID_;
	};

	public java.lang.Long getOldqueesticfentid() {
		return(oldqueesticfentid);
	};
	public void setOldqueesticfentid(java.lang.Long _oldqueesticfentid_) {
		this.oldqueesticfentid = _oldqueesticfentid_;
	};

	public java.lang.String getOlddada1() {
		return(olddada1);
	};
	public void setOlddada1(java.lang.String _olddada1_) {
		this.olddada1 = _olddada1_;
	};

	public java.lang.String getOlddada2() {
		return(olddada2);
	};
	public void setOlddada2(java.lang.String _olddada2_) {
		this.olddada2 = _olddada2_;
	};

	public java.sql.Timestamp getOlddata() {
		return(olddata);
	};
	public void setOlddata(java.sql.Timestamp _olddata_) {
		this.olddata = _olddata_;
	};

	public java.lang.String getNewusuariID() {
		return(newusuariID);
	};
	public void setNewusuariID(java.lang.String _newusuariID_) {
		this.newusuariID = _newusuariID_;
	};

	public java.lang.Long getNewprojecteID() {
		return(newprojecteID);
	};
	public void setNewprojecteID(java.lang.Long _newprojecteID_) {
		this.newprojecteID = _newprojecteID_;
	};

	public java.lang.Long getNewqueesticfentid() {
		return(newqueesticfentid);
	};
	public void setNewqueesticfentid(java.lang.Long _newqueesticfentid_) {
		this.newqueesticfentid = _newqueesticfentid_;
	};

	public java.lang.String getNewdada1() {
		return(newdada1);
	};
	public void setNewdada1(java.lang.String _newdada1_) {
		this.newdada1 = _newdada1_;
	};

	public java.lang.String getNewdada2() {
		return(newdada2);
	};
	public void setNewdada2(java.lang.String _newdada2_) {
		this.newdada2 = _newdada2_;
	};

	public java.sql.Timestamp getNewdata() {
		return(newdata);
	};
	public void setNewdata(java.sql.Timestamp _newdata_) {
		this.newdata = _newdata_;
	};



  // ======================================

  public static ModificacionsBean toBean(Modificacio __bean) {
    if (__bean == null) { return null;}
    ModificacionsBean __tmp = new ModificacionsBean();
    __tmp.setModificacioid(__bean.getModificacioid());
    __tmp.setEntradaid(__bean.getEntradaid());
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setOldusuariID(__bean.getOldusuariID());
    __tmp.setOldprojecteID(__bean.getOldprojecteID());
    __tmp.setOldqueesticfentid(__bean.getOldqueesticfentid());
    __tmp.setOlddada1(__bean.getOlddada1());
    __tmp.setOlddada2(__bean.getOlddada2());
    __tmp.setOlddata(__bean.getOlddata());
    __tmp.setNewusuariID(__bean.getNewusuariID());
    __tmp.setNewprojecteID(__bean.getNewprojecteID());
    __tmp.setNewqueesticfentid(__bean.getNewqueesticfentid());
    __tmp.setNewdada1(__bean.getNewdada1());
    __tmp.setNewdada2(__bean.getNewdada2());
    __tmp.setNewdata(__bean.getNewdata());
		return __tmp;
	}



}
