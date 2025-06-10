package org.fundaciobit.queesticfent.back.controller.user;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.basecamp.api3.BaseCampApi3;
import org.fundaciobit.basecamp.api3.beans.User;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.queesticfent.back.controller.webdb.ModificacioQueEsticFentController;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacioQueEsticFentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacioQueEsticFentForm;
import org.fundaciobit.queesticfent.back.security.LoginInfo;
import org.fundaciobit.queesticfent.commons.utils.Configuracio;
import org.fundaciobit.queesticfent.model.entity.Festiu;
import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;
import org.fundaciobit.queesticfent.model.entity.Usuari;
import org.fundaciobit.queesticfent.model.fields.FestiuFields;
import org.fundaciobit.queesticfent.model.fields.ModificacioQueEsticFentFields;
import org.fundaciobit.queesticfent.model.fields.UsuariDepartamentFields;
import org.fundaciobit.queesticfent.model.fields.UsuariFields;
import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author anadal
 *
 */

@Controller
@RequestMapping(value = "/user/vacances")
@SessionAttributes(types = { ModificacioQueEsticFentForm.class, ModificacioQueEsticFentFilterForm.class })
public class VacancesUserController extends ModificacioQueEsticFentController {

	public static final String[] MESOS = { "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost",
			"Setembre", "Octubre", "Novembre", "Desembre" };

	@EJB(mappedName = org.fundaciobit.queesticfent.ejb.FestiuService.JNDI_NAME)
	protected org.fundaciobit.queesticfent.ejb.FestiuService festiusEjb;

	@EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuariService.JNDI_NAME)
	protected org.fundaciobit.queesticfent.ejb.UsuariService usuarisEjb;

	@EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuariDepartamentService.JNDI_NAME)
	protected org.fundaciobit.queesticfent.ejb.UsuariDepartamentService UsuariDepartamentEjb;

	@Override
	public String getEntityNameCode() {
		return "vacances";
	}

	@Override
	public String getEntityNameCodePlural() {
		return "vacances";
	}

	@Override
	public String getTileList() {
		return "modificacionsQueEsticFentListUser";
	}

	@Override
	public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {

		Where w1 = ModificacioQueEsticFentFields.ACCIOID.equal(-4L);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, -2);

		Timestamp from = new Timestamp(cal.getTimeInMillis());

		cal.add(Calendar.MONTH, +10);
		cal.set(Calendar.DATE, -1);

		Timestamp to = new Timestamp(cal.getTimeInMillis());

		Where w2 = ModificacioQueEsticFentFields.DATA.between(from, to);
		return Where.AND(w1, w2);
	}

	@Override
	public ModificacioQueEsticFentFilterForm getModificacioQueEsticFentFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		ModificacioQueEsticFentFilterForm modificacionsQueEsticFentFilterForm;
		modificacionsQueEsticFentFilterForm = super.getModificacioQueEsticFentFilterForm(pagina, mav, request);

		if (modificacionsQueEsticFentFilterForm.isNou()) {

		}

		return modificacionsQueEsticFentFilterForm;
	}

	@RequestMapping(value = "/vacancespermes", method = RequestMethod.GET)
	public ModelAndView vacancesPerMes(HttpServletRequest request, HttpServletResponse response) throws I18NException {

		// Where per accio vacances i entre 2 mesos enrera i 8? mesos envant.
		Where w;
		Timestamp from, to;
		{
			Where w1 = ModificacioQueEsticFentFields.ACCIOID.equal(-4L);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, 1);
			cal.add(Calendar.MONTH, -2);

			from = new Timestamp(cal.getTimeInMillis());

			cal.add(Calendar.MONTH, +10);
			cal.set(Calendar.DATE, -1);

			to = new Timestamp(cal.getTimeInMillis());

			Where w2 = ModificacioQueEsticFentFields.DATA.between(from, to);

			List<String> usuarisIds = UsuariDepartamentEjb.executeQuery(UsuariDepartamentFields.USUARIID);

			Where w3 = ModificacioQueEsticFentFields.USUARIID.in(usuarisIds);

			w = Where.AND(w1, w2, w3);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Set<String> festius = new HashSet<String>();
		{
			List<Festiu> festiusList = festiusEjb.select(
					FestiuFields.DATA.between(new java.sql.Date(from.getTime()), new java.sql.Date(to.getTime())));

			for (Festiu f : festiusList) {

				festius.add(sdf.format(f.getData()));
			}

		}

		List<ModificacioQueEsticFent> vacances = this.modificacioQueEsticFentEjb.select(w);

		log.info("vacances.size() =>" + vacances.size());

		Map<String, VacancesMes> vacancesmesos = new TreeMap<String, VacancesUserController.VacancesMes>();

		Set<String> usuaris = new HashSet<String>();

		for (ModificacioQueEsticFent m : vacances) {

			Timestamp date = m.getData();

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			int mes = cal.get(Calendar.MONTH);

			int anyo = cal.get(Calendar.YEAR);

			String anyMes = anyo + String.format("%02d", mes);

			VacancesMes vacancesPerMes = vacancesmesos.get(anyMes);
			if (vacancesPerMes == null) {
				vacancesPerMes = new VacancesMes();

				vacancesPerMes.anyo = anyo;
				vacancesPerMes.mesnom = MESOS[mes];

				vacancesPerMes.numberofdays = cal.getActualMaximum(Calendar.DATE);

				vacancesPerMes.personesMap = new TreeMap<String, VacancesUserController.PersonaVacancesInfo>();

				Calendar dia = Calendar.getInstance();
				dia.setTimeInMillis(cal.getTimeInMillis());
				BitSet capdesetmanes = new BitSet(vacancesPerMes.numberofdays);
				BitSet festiusMes = new BitSet(vacancesPerMes.numberofdays);
				for (int i = 1; i <= vacancesPerMes.numberofdays; i++) {
					dia.set(Calendar.DATE, i);

					int diaset = dia.get(Calendar.DAY_OF_WEEK);

					if (diaset == Calendar.SATURDAY || diaset == Calendar.SUNDAY) {
						capdesetmanes.set(i);
					} else {

						if (festius.contains(sdf.format(dia.getTime()))) {
							festiusMes.set(i);
						}
					}

				}

				vacancesPerMes.capdesetmanes = capdesetmanes;
				vacancesPerMes.festius = festiusMes;

				vacancesmesos.put(anyMes, vacancesPerMes);

			}

			String user = m.getUsuariID();

			usuaris.add(user);

			PersonaVacancesInfo persona = vacancesPerMes.personesMap.get(user);
			if (persona == null) {

				persona = new PersonaVacancesInfo();
				persona.username = user;
				persona.vacances = new BitSet(vacancesPerMes.numberofdays);

				vacancesPerMes.personesMap.put(user, persona);
			}

			persona.vacances.set(cal.get(Calendar.DATE));
		}

		List<Usuari> usuarisList = usuarisEjb.select(UsuariFields.USUARIID.in(usuaris));
		Set<UsuariInfo> persones = new TreeSet<UsuariInfo>();
		for (Usuari u : usuarisList) {
			UsuariInfo p = new UsuariInfo();
			p.username = u.getUsuariID();
			p.color = u.getContrasenya();
			p.nom = u.getNom() + " " + u.getLlinatge1() + " " + u.getLlinatge2();
			persones.add(p);
		}

		ModelAndView mav = new ModelAndView("taulaDeVacances");
		mav.addObject("vacancesmesos", vacancesmesos.values());
		mav.addObject("persones", persones);
		log.info("UsuariID = "+request.getParameter("usuariID"));
		mav.addObject("usuariID", request.getParameter("usuariID"));
		

		return mav;

	}

	
	
	@RequestMapping(value = "/afegirrangvacances", method = RequestMethod.GET)
    public ModelAndView afegirRangVacances(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
	    String dataIniciStr = request.getParameter("dataInici");
	    String dataFiStr = request.getParameter("dataFi");
	    log.info("DataIniciStr = " + dataIniciStr);
	    log.info("DataFiStr = " + dataFiStr);
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInici = format.parse(dataIniciStr);
        Date dataFi = format.parse(dataFiStr);

        Calendar calendariInici = Calendar.getInstance();
        calendariInici.setTime(dataInici);

        Calendar calendariFi = Calendar.getInstance();
        calendariFi.setTime(dataFi);
	    
        Calendar start = (Calendar) calendariInici.clone(); // Copiem per no modificar l'original
        Calendar end = calendariFi;
        LoginInfo li = LoginInfo.getInstance();
        
        log.info("li.getUsername()"+li.getUsername());
        log.info("li.getUserInfo().getId()"+li.getUserInfo().getId());
        
        
        
        for (; !start.after(end); start.add(Calendar.DATE, 1)) {
            
            ModificacioQueEsticFentJPA m = new ModificacioQueEsticFentJPA();
            Date dataTmp = start.getTime();
            m.setData(new Timestamp(dataTmp.getTime()));
            m.setAccioID(-4);
            m.setUsuariID(li.getUsername());
            m.setDada1("vacances");
            
            modificacioQueEsticFentEjb.create(m);
        }
	    
	    return new ModelAndView(new RedirectView("/user/vacances/vacancespermes", true));
	}
	
	
	
	
	public static class VacancesMes {
		int anyo;
		String mesnom;
		int numberofdays;
		Map<String, PersonaVacancesInfo> personesMap;

		BitSet festius;

		BitSet capdesetmanes;

		public int getAnyo() {
			return anyo;
		}

		public void setAnyo(int anyo) {
			this.anyo = anyo;
		}

		public String getMesnom() {
			return mesnom;
		}

		public void setMesnom(String mesnom) {
			this.mesnom = mesnom;
		}

		public int getNumberofdays() {
			return numberofdays;
		}

		public void setNumberofdays(int numberofdays) {
			this.numberofdays = numberofdays;
		}

		public Map<String, PersonaVacancesInfo> getPersonesMap() {
			return personesMap;
		}

		public void setPersonesMap(Map<String, PersonaVacancesInfo> personesMap) {
			this.personesMap = personesMap;
		}

		public BitSet getFestius() {
			return festius;
		}

		public void setFestius(BitSet festius) {
			this.festius = festius;
		}

		public BitSet getCapdesetmanes() {
			return capdesetmanes;
		}

		public void setCapdesetmanes(BitSet capdesetmanes) {
			this.capdesetmanes = capdesetmanes;
		}

	}

	public static class PersonaVacancesInfo {
		String username;
		BitSet vacances;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public BitSet getVacances() {
			return vacances;
		}

		public void setVacances(BitSet vacances) {
			this.vacances = vacances;
		}

	}
	
	
	public static class UsuariInfo implements Comparable<UsuariInfo> {
		String username;
		String nom;
		String color;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public int compareTo(UsuariInfo o) {
			return this.username.compareTo(o.username);
		}

	}

}
