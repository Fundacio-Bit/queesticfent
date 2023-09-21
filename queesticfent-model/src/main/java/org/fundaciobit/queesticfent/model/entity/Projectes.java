package org.fundaciobit.queesticfent.model.entity;

public interface Projectes extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getProjecteId();
	public void setProjecteId(long _projecteId_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public long getDepartamentid();
	public void setDepartamentid(long _departamentid_);

	public java.lang.String getDescripcio();
	public void setDescripcio(java.lang.String _descripcio_);

	public boolean isActiu();
	public void setActiu(boolean _actiu_);

	public java.sql.Date getFromdata();
	public void setFromdata(java.sql.Date _fromdata_);

	public java.sql.Date getTodata();
	public void setTodata(java.sql.Date _todata_);



  // ======================================

}
