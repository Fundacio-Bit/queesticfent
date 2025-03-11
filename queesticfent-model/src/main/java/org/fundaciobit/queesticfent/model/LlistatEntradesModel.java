package org.fundaciobit.queesticfent.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.fundaciobit.queesticfent.model.entity.Accio;
import org.fundaciobit.queesticfent.model.entity.Departament;
import org.fundaciobit.queesticfent.model.entity.Projecte;
import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;

public class LlistatEntradesModel {

	boolean tePermisos;

	String usuariId;

	List<Long> departaments;

	long departamentId;

	Long projecteId = 0L;

	List<Long> projectes;

	List<Long> projectesSeleccionats;

	boolean mostrarEntradesAmagades;

	Calendar selectedMonthStart;

	Map<Date, List<QueEsticFentItem>> itemsByDate;

	List<Accio> allAccions;

	String redirectUrlParams;

	String redirectUrl;

	List<UsuariDepartament> personalCap;

	List<Accio> actions;

	List<Projecte> projectesList;

	List<Departament> departamentsInfo;
	
	


	public List<Accio> getActions() {
		return actions;
	}

	public void setActions(List<Accio> actions) {
		this.actions = actions;
	}

	public List<Projecte> getProjectesList() {
		return projectesList;
	}

	public void setProjectesList(List<Projecte> projectesList) {
		this.projectesList = projectesList;
	}

	public List<Departament> getDepartamentsInfo() {
		return departamentsInfo;
	}

	public void setDepartamentsInfo(List<Departament> departamentsInfo) {
		this.departamentsInfo = departamentsInfo;
	}

	public List<Accio> getAllAccions() {
		return allAccions;
	}

	public void setAllAccions(List<Accio> allAccions) {
		this.allAccions = allAccions;
	}

	public String getRedirectUrlParams() {
		return redirectUrlParams;
	}

	public void setRedirectUrlParams(String redirectUrlParams) {
		this.redirectUrlParams = redirectUrlParams;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public List<UsuariDepartament> getPersonalCap() {
		return personalCap;
	}

	public void setPersonalCap(List<UsuariDepartament> personalCap) {
		this.personalCap = personalCap;
	}

	public void setProjecteId(Long projecteId) {
		this.projecteId = projecteId;
	}

	public Calendar getSelectedMonthStart() {
		return selectedMonthStart;
	}

	public void setSelectedMonthStart(Calendar start) {
		this.selectedMonthStart = start;
	}
	
	public int getSelectedMonth() {
	    return this.getSelectedMonthStart().get(Calendar.MONTH);
	}
	
	public int getSelectedYear() {
       return this.getSelectedMonthStart().get(Calendar.YEAR);
	}

	public Map<Date, List<QueEsticFentItem>> getItemsByDate() {
		return itemsByDate;
	}

	public void setItemsByDate(Map<Date, List<QueEsticFentItem>> itemsByDate) {
		this.itemsByDate = itemsByDate;
	}

	public boolean isMostrarEntradesAmagades() {
		return mostrarEntradesAmagades;
	}

	public void setMostrarEntradesAmagades(boolean mostrarEntradesAmagades) {
		this.mostrarEntradesAmagades = mostrarEntradesAmagades;
	}

	public boolean isTePermisos() {
		return tePermisos;
	}

	public void setTePermisos(boolean tePermisos) {
		this.tePermisos = tePermisos;
	}

	public String getUsuariId() {
		return usuariId;
	}

	public void setUsuariId(String usuariId) {
		this.usuariId = usuariId;
	}

	public List<Long> getDepartaments() {
		return departaments;
	}

	public void setDepartaments(List<Long> departaments) {
		this.departaments = departaments;
	}

	public long getDepartamentId() {
		return departamentId;
	}

	public void setDepartamentId(long departamentId) {
		this.departamentId = departamentId;
	}

	public List<Long> getProjectes() {
		return projectes;
	}

	public void setProjectes(List<Long> projectes) {
		this.projectes = projectes;
	}

	public long getProjecteId() {
		return projecteId;
	}

	public void setProjecteId(long projecteId) {
		this.projecteId = projecteId;
	}

	public List<Long> getProjectesSeleccionats() {
		return projectesSeleccionats;
	}

	public void setProjectesSeleccionats(List<Long> projectesSeleccionats) {
		this.projectesSeleccionats = projectesSeleccionats;
	}

}
