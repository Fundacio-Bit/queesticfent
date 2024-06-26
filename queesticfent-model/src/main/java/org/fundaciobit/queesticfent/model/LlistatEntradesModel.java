package org.fundaciobit.queesticfent.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.fundaciobit.queesticfent.model.entity.Accions;
import org.fundaciobit.queesticfent.model.entity.Departaments;
import org.fundaciobit.queesticfent.model.entity.Projectes;
import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;


public class LlistatEntradesModel {
	
	boolean tePermisos;
	
	Calendar yesterday, today;
	
	String usuariId;
	
	List<Long> departaments;
	
	long departamentId;
	
	Long projecteId = 0L;
	
	List<Long> projectes;
	
	List<Long> projectesSeleccionats;
	
	int mes, any, mesAnterior, anyAnterior, mesSeguent, anySeguent, maxDay;
	
	boolean mostrarEntradesAmagades;
	
	Calendar start;
	
	Map<Date, List<QueEsticFentItem>> itemsByDate;
	
	List<Accions> allAccions;
	
	String redirectUrlParams;
	
	String redirectUrl;
	
	List<UsuarisDepartament> personalCap;
	
	List<Accions> actions;
	
	List<Projectes> projectesList;
	
	List<Departaments> departamentsInfo;
	
	

	/*List<String> nomDropdown;
	
	String departament;
	
	List<String> projectesDropdown;
	
	int previousMonth, currentMonth, nextMonth, currentYear;
	
	String urlExportacioUserOdt;
	
	String urlExportacioDeptOdt;
	
	List<DiaEntrades> dies;*/

	
	
	
	
	
	public int getAny() {
		return any;
	}

	public List<Accions> getActions() {
		return actions;
	}

	public void setActions(List<Accions> actions) {
		this.actions = actions;
	}

	public List<Projectes> getProjectesList() {
		return projectesList;
	}

	public void setProjectesList(List<Projectes> projectesList) {
		this.projectesList = projectesList;
	}

	public List<Departaments> getDepartamentsInfo() {
		return departamentsInfo;
	}

	public void setDepartamentsInfo(List<Departaments> departamentsInfo) {
		this.departamentsInfo = departamentsInfo;
	}

	public List<Accions> getAllAccions() {
		return allAccions;
	}

	public void setAllAccions(List<Accions> allAccions) {
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

	public List<UsuarisDepartament> getPersonalCap() {
		return personalCap;
	}

	public void setPersonalCap(List<UsuarisDepartament> personalCap) {
		this.personalCap = personalCap;
	}

	public void setProjecteId(Long projecteId) {
		this.projecteId = projecteId;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Map<Date, List<QueEsticFentItem>> getItemsByDate() {
		return itemsByDate;
	}

	public void setItemsByDate(Map<Date, List<QueEsticFentItem>> itemsByDate) {
		this.itemsByDate = itemsByDate;
	}

	public int getMaxDay() {
		return maxDay;
	}

	public void setMaxDay(int maxDay) {
		this.maxDay = maxDay;
	}

	public int getMesAnterior() {
		return mesAnterior;
	}

	public void setMesAnterior(int mesAnterior) {
		this.mesAnterior = mesAnterior;
	}

	public int getAnyAnterior() {
		return anyAnterior;
	}

	public void setAnyAnterior(int anyAnterior) {
		this.anyAnterior = anyAnterior;
	}

	public int getMesSeguent() {
		return mesSeguent;
	}

	public void setMesSeguent(int mesSeguent) {
		this.mesSeguent = mesSeguent;
	}

	public int getAnySeguent() {
		return anySeguent;
	}

	public void setAnySeguent(int anySeguent) {
		this.anySeguent = anySeguent;
	}

	public boolean isMostrarEntradesAmagades() {
		return mostrarEntradesAmagades;
	}

	public void setMostrarEntradesAmagades(boolean mostrarEntradesAmagades) {
		this.mostrarEntradesAmagades = mostrarEntradesAmagades;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public boolean isTePermisos() {
		return tePermisos;
	}

	public void setTePermisos(boolean tePermisos) {
		this.tePermisos = tePermisos;
	}

	public Calendar getYesterday() {
		return yesterday;
	}

	public void setYesterday(Calendar yesterday) {
		this.yesterday = yesterday;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
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

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	

	
	
	
	
	
	
}
