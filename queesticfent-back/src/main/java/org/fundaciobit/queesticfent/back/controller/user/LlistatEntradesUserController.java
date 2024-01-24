package org.fundaciobit.queesticfent.back.controller.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.fundaciobit.basecamp.api3.BaseCampApi3;
import org.fundaciobit.basecamp.api3.beans.Entry;
import org.fundaciobit.basecamp.api3.beans.NewEntry;
import org.fundaciobit.basecamp.api3.beans.User;
import org.fundaciobit.basecamp.api3.utils.TokenResponse;
import org.fundaciobit.basecamp.api3.utils.UpdateTokenUtils;
import org.fundaciobit.genapp.common.KeyValue;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.SelectMultipleKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.core.utils.ISO8601;
import org.fundaciobit.queesticfent.back.controller.webdb.ModificacionsQueEsticFentController;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentForm;
import org.fundaciobit.queesticfent.back.security.LoginInfo;
import org.fundaciobit.queesticfent.back.utils.Utils;
import org.fundaciobit.queesticfent.commons.utils.Configuracio;
import org.fundaciobit.queesticfent.commons.utils.Constants;
import org.fundaciobit.queesticfent.model.bean.AccionsBean;
import org.fundaciobit.queesticfent.model.bean.ModificacionsQueEsticFentBean;
import org.fundaciobit.queesticfent.model.entity.Accions;
import org.fundaciobit.queesticfent.model.entity.Departaments;
import org.fundaciobit.queesticfent.model.entity.Festius;
import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;
import org.fundaciobit.queesticfent.model.entity.Projectes;
import org.fundaciobit.queesticfent.model.entity.Usuaris;
import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;
import org.fundaciobit.queesticfent.model.fields.AccionsFields;
import org.fundaciobit.queesticfent.model.fields.DepartamentsFields;
import org.fundaciobit.queesticfent.model.fields.FestiusFields;
import org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields;
import org.fundaciobit.queesticfent.model.fields.PersonalProjecteFields;
import org.fundaciobit.queesticfent.model.fields.ProjectesFields;
import org.fundaciobit.queesticfent.model.fields.UsuarisDepartamentFields;
import org.fundaciobit.queesticfent.model.fields.UsuarisFields;
import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;
import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA;
import org.fundaciobit.queesticfent.persistence.UsuarisJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

/**
 * 
 * @author fbosch
 * @author anadal (Basecamp)
 *
 */
@Controller
@RequestMapping(value = LlistatEntradesUserController.CONTEXT_WEB)
@SessionAttributes(types = { ModificacionsQueEsticFentForm.class, ModificacionsQueEsticFentFilterForm.class })
public class LlistatEntradesUserController extends ModificacionsQueEsticFentController {

    public static final String CONTEXT_WEB = "/user/entrades";

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService usuarisDepartamentEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.PersonalProjecteService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.PersonalProjecteService personalProjecteEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccionsService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.AccionsService accionsEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;

    //@EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService.JNDI_NAME)
    //protected org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService modificacionsQueEsticFentEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.FestiusService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.FestiusService festiusEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.UsuarisService usuarisEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentsService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.DepartamentsService departamentsEjb;

    @Override
    public String getTileForm() {
        return "entradesFormUser";
    }

    @Override
    public String getTileList() {
        return "modificacionsQueEsticFentListWebDB";
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "ModificacionsQueEsticFent_FilterForm_" + this.getClass().getName();
    }

    protected Where getWhereProjecte(List<Long> projectes) throws Exception {
        Where w = null;
        for (Long projecteID : projectes) {
            Projectes proj = projectesEjb.findByPrimaryKey(projecteID);
            if (w == null) {
                w = ModificacionsQueEsticFentFields.DADA1.like(proj.getNom() + ": %");
            } else {
                w = Where.OR(w, ModificacionsQueEsticFentFields.DADA1.like(proj.getNom() + ": %"));
            }
        }
        return w;
    }

    protected Where getWhereExcloureModificacions(String usuariID, List<Long> projectes) throws Exception {
        // (a) Eliminar elments moguts a altres llocs (CANVI DE DATA)
        Where ww1 = ModificacionsQueEsticFentFields.USUARIID.equal(usuariID);
        Where ww2 = ModificacionsQueEsticFentFields.ACCIOID.equal((long) Utils.ACCIO_CANVI_DATA);

        Where ww3 = null;
        for (Long projecteID : projectes) {
            //IProjectes proj = ProjectesManager.findByPrimaryKey(projecteID);
            if (ww3 == null) {
                ww3 = ModificacionsQueEsticFentFields.PROJECTEID.equal(projecteID);
            } else {
                ww3 = Where.OR(ww3, ModificacionsQueEsticFentFields.PROJECTEID.equal(projecteID));
            }
        }

        Where ww = Where.AND(ww1, ww2, ww3);

        /*Query<IModificacionsQueEsticFent,Integer> query;
        query = ModificacionsQueEsticFentManager.getQuery(IModificacionsQueEsticFent.QUEESTICFENTID, ww);
        List<Integer> listOfqueesticFentID =  query.execute();*/

        List<Long> listOfqueesticFentID = modificacionsQueEsticFentEjb
                .executeQuery(ModificacionsQueEsticFentFields.QUEESTICFENTID, ww);

        if (listOfqueesticFentID.size() == 0) {
            return ModificacionsQueEsticFentFields.QUEESTICFENTID.isNotNull();
        } else {
            Long[] queesticFentIDs = listOfqueesticFentID.toArray(new Long[listOfqueesticFentID.size()]);
            return ModificacionsQueEsticFentFields.QUEESTICFENTID.notIn(queesticFentIDs);
        }
    }

    @Override
    public ModificacionsQueEsticFentForm getModificacionsQueEsticFentForm(ModificacionsQueEsticFentJPA _jpa,
            boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {

        ModificacionsQueEsticFentForm form = super.getModificacionsQueEsticFentForm(_jpa, __isView, request, mav);
        if (form.isNou()) {
            ModificacionsQueEsticFentJPA m = form.getModificacionsQueEsticFent();
            //TODO XYZ Falta UsuariID, Data, Accio com a readonly
            // Amagar queesticfentID
            m.setUsuariID(request.getParameter("usuariID"));
            form.addReadOnlyField(DATA);

            try {
                m.setData(new Timestamp(getSimpleDateTimeFormat().parse(request.getParameter("data")).getTime()));
            } catch (ParseException e) {
                // TODO XYZ 
                e.printStackTrace();
            }
            String projecteIdStr = request.getParameter("projecteID");
            if (projecteIdStr != null) {
                //TODO XYZ Falta posar ProjecteID com a readonly
                m.setProjecteID(Long.parseLong(projecteIdStr));
            }
            String accioID = request.getParameter("accioID");
            if (String.valueOf(Utils.ACCIO_VACANCES).contentEquals(accioID)) {
                m.setAccioID(Utils.ACCIO_VACANCES);
                m.setDada1("Vacances");
                try {
                    this.create(request, m);

                    BaseCampApi3 api3 = new BaseCampApi3(Configuracio.getBasecampUrlBase(),
                            Configuracio.getBasecampOrganizationID(),
                            new File(Configuracio.getBasecampTokenPropertiesFile()));

                    if (api3.isNecessaryUpdateToken()) {

                        String client_id = Configuracio.getBasecampClientID();
                        String redirectUrl = Configuracio.getBasecampRedirectUrl();

                        String getTokenUrl = UpdateTokenUtils.getGetCodeUrl(client_id, redirectUrl);

                        request.getSession().setAttribute("__MODIFICACIOID__", m.getModificacioID());

                        mav.setView(new RedirectView(getTokenUrl, false));

                        return form;

                    }

                    mav.setView(new RedirectView(
                            getContextWeb() + "/addbasecampscheduleentries/" + m.getModificacioID(), true));

                    return form;

                } catch (I18NException e) {
                    String msg = "Error afegint vacances: " + I18NUtils.getMessage(e);
                    log.error(msg, e);
                    HtmlUtils.saveMessageError(request, msg);
                } catch (I18NValidationException e) {
                    String msg = "Error afegint vacances: " + I18NUtils.getMessage(e);
                    log.error(msg, e);
                    HtmlUtils.saveMessageError(request, msg);

                }
                mav.setView(new RedirectView(getContextWeb() + LLISTAT_ENTRADES, true));
                return form;

            } else {
                m.setAccioID(Utils.ACCIO_NOVA_ENTRADA);
            }

        }

        form.addReadOnlyField(USUARIID);
        form.addReadOnlyField(ACCIOID);
        form.addHiddenField(QUEESTICFENTID);
        //form.addReadOnlyField(PROJECTEID);

        return form;
    }

    public static SimpleDateFormat getSimpleDateTimeFormat() {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    @RequestMapping("/basecamptoken")
    public ModelAndView token(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

        ModelAndView mav = new ModelAndView();
        try {

            // TODO XYZ ZZZ falta gestionar si l'usuari cancela, envia parametre error !!!!!
            String code = request.getParameter("code");

            log.info("CODE => ]" + code + "[");

            //  https://governdigital.fundaciobit.org/queesticfent/user/entrades/basecamptoken

            TokenResponse tokenInfo = UpdateTokenUtils.getNewTokenFromCode(Configuracio.getBasecampClientID(),
                    Configuracio.getBasecampClientSecret(), Configuracio.getBasecampRedirectUrl(), code);

            File basecampTokenFile = new File(Configuracio.getBasecampTokenPropertiesFile());

            UpdateTokenUtils.updateBasecampTokenProperties(basecampTokenFile, tokenInfo);

            Long modificacioID = (Long) request.getSession().getAttribute("__MODIFICACIOID__");

            mav.setView(new RedirectView(getContextWeb() + "/addbasecampscheduleentries/" + modificacioID, true));

        } catch (Exception e) {
            String msg = "Error afegint vacances(Error actualitzant token de Basecamp): " + e.getMessage();
            log.error(msg, e);
            HtmlUtils.saveMessageError(request, msg);

            mav.setView(new RedirectView(getContextWeb() + LLISTAT_ENTRADES, true));

        }

        return mav;
    }

    /*
    @RequestMapping(value = "/testbasecamp", method = RequestMethod.GET)
    public ModelAndView testBaseCamp(HttpServletRequest request, HttpServletResponse response) throws I18NException {
        try {
    
            String url = Configuracio.getBasecampUrlBase();
            Long org = Configuracio.getBasecampOrganizationID();
            String tokenfile = Configuracio.getBasecampTokenPropertiesFile();
            Long projectID = Configuracio.getBasecampProjectID();
    
            log.info("url => " + url);
            log.info("org => " + org);
            log.info("tokenfile => " + tokenfile);
            log.info("projectID => " + projectID);
    
            BaseCampApi3 api3 = new BaseCampApi3(url, org, new File(tokenfile));
    
            log.info("api3.getToken() => " + api3.getToken());
    
            User[] users = api3.getUsers(projectID);
    
            StringBuilder str = new StringBuilder();
            for (User user : users) {
                str.append(user.getName()).append("<br/>");
            }
            HtmlUtils.saveMessageInfo(request, str.toString());
    
        } catch (Throwable th) {
    
            String msg = "Error no controlat provant comunicació amb Basecamp: " + th.getMessage();
    
            log.error(msg, th);
    
            HtmlUtils.saveMessageError(request, msg);
    
        }
    
        ModelAndView mav = new ModelAndView();
        mav.setView(new RedirectView(getContextWeb() + LLISTAT_ENTRADES, true));
    
        return mav;
    }
    */

    @Override
    public void delete(HttpServletRequest request, ModificacionsQueEsticFent modificacionsQueEsticFent)
            throws I18NException {

        modificacionsQueEsticFentEjb.delete(modificacionsQueEsticFent);

        if (modificacionsQueEsticFent.getAccioID() == Utils.ACCIO_VACANCES) {
            BaseCampApi3 api3 = getBasecampApi3();
            Long projectID = Configuracio.getBasecampProjectID();

            String info = modificacionsQueEsticFent.getDada2();
            Long entryID = null;
            try {
                Properties prop = new Properties();
                prop.load(new StringReader(info));

                String entryIDStr = prop.getProperty("basecamp.entryID");

                if (entryIDStr != null) {

                    entryID = Long.parseLong(entryIDStr);
                    api3.deleteScheduleEntry(projectID, entryID);

                    HtmlUtils.saveMessageSuccess(request, "Esborrada entrada del Calendari de Basecamp");

                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                entryID = null;
            }

            if (entryID == null) {
                HtmlUtils.saveMessageWarning(request,
                        "Ha d'esborrar manualment " + "del Calendari de Basecamp l'entrada de Vacances del dia "
                                + modificacionsQueEsticFent.getData());
            }

        }

    }

    @RequestMapping(value = "/addbasecampscheduleentries/{modificacioID}", method = RequestMethod.GET)
    public ModelAndView addBasecampScheduleEntries(HttpServletRequest request, HttpServletResponse response,
            @PathVariable Long modificacioID) throws I18NException {
        try {
            ModificacionsQueEsticFentJPA m = this.findByPrimaryKey(request, modificacioID);

            BaseCampApi3 api3 = getBasecampApi3();

            Long projectID = Configuracio.getBasecampProjectID();

            Long scheduleID = api3.getScheduleID(projectID);

            NewEntry e = new NewEntry();
            e.setStarts_at(ISO8601.dateToISO8601(m.getData()));
            e.setEnds_at(ISO8601.dateToISO8601(m.getData()));

            // XYZ ZZZ  Canviar per EMAIL !!!!!
            String username = LoginInfo.getInstance().getUsername();

            User user = api3.getUserIdFromEmail(projectID, username + "@fundaciobit.org");
            e.setSummary("Vacances " + username.toUpperCase());
            e.setAllDay(true);
            e.setParticipant_ids(new Integer[] { user.getId() });

            Entry fullEntry = api3.addScheduleEntry(projectID, scheduleID, e);

            m.setDada2("basecamp.entryID=" + fullEntry.getId());
            
            this.update(request, m);

            HtmlUtils.saveMessageSuccess(request, "Afegit dia lliure al calendari de BaseCamp");

        } catch (Throwable th) {

            String msg = "Error no controlat intentant donat d'alta l'entrada al calendari de Basecamp: "
                    + th.getMessage();

            log.error(msg, th);

            HtmlUtils.saveMessageError(request, msg);

        }

        ModelAndView mav = new ModelAndView();
        mav.setView(new RedirectView(getContextWeb() + LLISTAT_ENTRADES, true));

        return mav;
    }

    protected BaseCampApi3 getBasecampApi3() {
        BaseCampApi3 api3 = new BaseCampApi3(Configuracio.getBasecampUrlBase(),
                Configuracio.getBasecampOrganizationID(), new File(Configuracio.getBasecampTokenPropertiesFile()));
        return api3;
    }

    /*
    @Override
    public ModificacionsQueEsticFentJPA create(HttpServletRequest request,
            ModificacionsQueEsticFentJPA modificacionsQueEsticFent) throws I18NException, I18NValidationException {
    
        ModificacionsQueEsticFentJPA m;
        m = (ModificacionsQueEsticFentJPA) modificacionsQueEsticFentEjb.create(modificacionsQueEsticFent);
        
        return m;
        
        
        
    }
    */

    // TODO Falta DELETE De tipus Vacances

    protected Map<Date, List<QueEsticFentItem>> getQueEsticFentItemByUser(String usuariID, List<Long> projectes,
            Date start, Date end) throws Exception {

        // 1.- Llegir Accions
        Map<Long, Accions> accionsByID = new HashMap<Long, Accions>();
        {

            List<Accions> accions = this.accionsEjb.select();
            for (Accions acc : accions) {
                accionsByID.put(acc.getAccioID(), acc);
            }
        }

        // 2.- Cercar Elements de QueEsticFent

        //Where w1 = null; //getWhereOfQueEsticFent(usuariID, start, end);
        //Where w2 = getWhereProjecte(projectes);
        //Where w3 = null;
        //Where w3 = getWhereExcloureModificacions(usuariID, projectes);

        //Where w = Where.AND(w1, w2, w3);

        // 3.- Mapejar dades
        Map<Long, QueEsticFentItem> itemsByQueEsticFentID = new HashMap<Long, QueEsticFentItem>();
        Map<Date, List<QueEsticFentItem>> llista = new HashMap<Date, List<QueEsticFentItem>>();

        // 3.1.- Mapejar entrades OTAE12 (OTAE + YEAR)
        //Where w5a = getWhereCurrentOTAE(start);
        //Where w_OTAE = Where.AND(w);

        //List<IQueEsticFent> all = QueEsticFentManager.getInstance().select(w,OrderType.ASC, IQueEsticFent.DATA);
        //afegirEntrades(usuariID, all, itemsByQueEsticFentID, llista, projectes);

        // 3.2.- Mapejar entrades  SINONIMS
        /*
        Where w5b = getWhereSinonimsOTAE();    
        Where w_Sinonims = Where.AND(w, w5b);
        List<IQueEsticFent> all_Sin = QueEsticFentManager.getInstance().select(w_Sinonims, OrderType.ASC, IQueEsticFent.DATA);    
        final IAccions accioSinonim = accionsByID.get(Utils.ACCIO_SINONIM);
        afegirEntrades(usuariID, all_Sin, itemsByQueEsticFentID, llista, accioSinonim);
        */
        log.info("XYZ ZZZ Projectes = "+Arrays.toString(projectes.toArray()));
        // 4.- Aplicar Modificacions
        // 4.1.- Cercar Modificacions
        Where wm1 = ModificacionsQueEsticFentFields.USUARIID.equal(usuariID);
        Where wm2 = ModificacionsQueEsticFentFields.DATA.greaterThanOrEqual(new Timestamp(start.getTime()));
        Where wm3 = ModificacionsQueEsticFentFields.DATA.lessThanOrEqual(new Timestamp(end.getTime()));
        Where wm4a = ModificacionsQueEsticFentFields.PROJECTEID.in(projectes.toArray(new Long[projectes.size()]));
        Where wm4b = ModificacionsQueEsticFentFields.ACCIOID.equal((long) Utils.ACCIO_VACANCES);
        Where wm = Where.AND(wm1, wm2, wm3, Where.OR(wm4a, wm4b));

        //IModificacionsQueEsticFent[] modificacions = ModificacionsQueEsticFentManager.selectForOnlyRead(wm);
        List<ModificacionsQueEsticFent> modificacions = modificacionsQueEsticFentEjb.select(wm);
        log.info("XYZ ZZZ Modificacions = " + modificacions.size());

        // 4.2.- Adaptar entrades
        QueEsticFentItem item;
        for (ModificacionsQueEsticFent modificacio : modificacions) {
            switch ((int) modificacio.getAccioID()) {
                // '-4'  ACCIO_SINONIM XXX
                //case Utils.ACCIO_SINONIM:
                // Aix� es fa en el punt anterior
                //break;

                //    '-3', 'Afegir Nova Entrada'                  usuari, data, dada1  
                case (int) Utils.ACCIO_NOVA_ENTRADA: {
                    Date date = toDate000000(modificacio.getData().getTime());
                    log.info("XXX XYZ Dia = " + modificacio.getData() + "       --- Titol Dia mes: " + date);
                    item = new QueEsticFentItem(usuariID, modificacio.getData(), modificacio.getDada1());
                    item.addModificacioItem(
                            new ModificacioItem(modificacio, accionsByID.get(modificacio.getAccioID())));
                    /*
                    item.setModificacio(modificacio);
                    item.setAccio(accionsByID.get(modificacio.getAccioID()));
                    */
                    List<QueEsticFentItem> items = llista.get(date);
                    if (items == null) {
                        items = new ArrayList<QueEsticFentItem>();
                        llista.put(date, items);
                    }
                    items.add(item);
                }
                break;
                //    '-2', 'Afegir Entrada de QueEsticFent'   ID, usuari, data
                case (int) Utils.ACCIO_AFEGIR_QUEESTICFENT: {

                    item = itemsByQueEsticFentID.get(modificacio.getQueEsticFentID());
                    if (item == null) {
                        ModificacionsQueEsticFentJPA qef = modificacionsQueEsticFentEjb
                                .findByPrimaryKey(modificacio.getQueEsticFentID());
                        if (qef != null) {
                            item = new QueEsticFentItem(usuariID, qef.getData(), qef.getDada1());
                        }

                        Date date = toDate000000(item.getData().getTime());
                        List<QueEsticFentItem> items = llista.get(date);

                        if (items == null) {
                            items = new ArrayList<QueEsticFentItem>();
                            llista.put(date, items);
                        }
                        // Mapejar per data
                        items.add(item);
                        itemsByQueEsticFentID.put(modificacio.getQueEsticFentID(), item);
                    }
                    item.addModificacioItem(
                            new ModificacioItem(modificacio, accionsByID.get(modificacio.getAccioID())));
                    /*
                    item.setAccio(accionsByID.get(Utils.ACCIO_AFEGIR_QUEESTICFENT));
                    item.setModificacio(modificacio);
                    */
                }
                break;
                //    '-1'   Festiu                                        data
                case (int) Utils.ACCIO_FESTIU:
                // Es realitza amb la taula de Fesius

                break;
                //    '0'    no mostrar entrada                ID, usuari, data    
                case (int) Utils.ACCIO_AMAGAR_ENTRADA: {
                    item = itemsByQueEsticFentID.get(modificacio.getQueEsticFentID());
                    if (item == null) {
                        log.info("Modificació amb ID " + modificacio.getModificacioID()
                                + " fa referència a entrada no arregada amb ID " + modificacio.getQueEsticFentID());
                    } else {
                        item.addModificacioItem(
                                new ModificacioItem(modificacio, accionsByID.get(modificacio.getAccioID())));
                        /*
                        item.setModificacio(modificacio);
                        item.setAccio(accionsByID.get(modificacio.getAccioID()));
                        */
                    }
                }
                break;
                //    '1',  'Modificar Text dins Entrada',     ID, usuari, data, dada1, dada2
                case (int) Utils.ACCIO_CANVI_TEXT: {
                    item = itemsByQueEsticFentID.get(modificacio.getQueEsticFentID());
                    if (item != null) {
                        String dada2 = modificacio.getDada2();
                        if (dada2 == null) {
                            dada2 = "";
                        }
                        /*
                        log.info("DADA1: ]" + modificacio.getDada1() + "[");
                        log.info("DADA2: ]" + dada2 + "[");
                        log.info("DESC: ]" + item.getDescripcio() + "[");
                        */

                        String newText = item.getDescripcio().replace(modificacio.getDada1(), dada2);
                        item.setDescripcio(newText);
                        item.addModificacioItem(
                                new ModificacioItem(modificacio, accionsByID.get(modificacio.getAccioID())));
                        /*
                        item.setModificacio(modificacio);
                        item.setAccio(accionsByID.get(modificacio.getAccioID()));
                        */
                    }
                }
                break;
                //    '-4',  'Vacances',                            usuari, data
                case (int) Utils.ACCIO_VACANCES: {
                    Date date = toDate000000(modificacio.getData().getTime());

                    item = new QueEsticFentItem(usuariID, modificacio.getData(), "Vacances");
                    item.addModificacioItem(
                            new ModificacioItem(modificacio, accionsByID.get(modificacio.getAccioID())));
                    /*
                    item.setModificacio(modificacio);
                    item.setAccio(accionsByID.get(modificacio.getAccioID()));
                    */

                    List<QueEsticFentItem> items = llista.get(date);
                    if (items == null) {
                        items = new ArrayList<QueEsticFentItem>();
                        llista.put(date, items);
                    }
                    items.add(item);
                }
                break;
                //    '3',  'Canvi Data',                          usuari, data  
                case (int) Utils.ACCIO_CANVI_DATA: {
                    //log.info(" + Modificacio QEF_ID: " + modificacio.getQueEsticFentID());
                    item = itemsByQueEsticFentID.get(modificacio.getQueEsticFentID());
                    if (item == null) {
                        ModificacionsQueEsticFentJPA mqef = modificacionsQueEsticFentEjb
                                .findByPrimaryKey(modificacio.getQueEsticFentID());
                        QueEsticFentItem qef = new QueEsticFentItem(mqef.getUsuariID(), mqef.getData(),
                                mqef.getDada1());
                        if (qef != null) {
                            item = new QueEsticFentItem(usuariID, qef.getData(), qef.getDescripcio());
                        }
                        itemsByQueEsticFentID.put(modificacio.getQueEsticFentID(), item);
                    }

                    if (item != null) {

                        // Eliminar del map per data 
                        Date date = toDate000000(item.getData().getTime());
                        List<QueEsticFentItem> items = llista.get(date);
                        if (items != null) {
                            //QueEsticFentItem aborrar = null;
                            //for (QueEsticFentItem qefi : items) {
                            //log.info(" ID original: " + qefi.getQueesticfentOriginal().getQueesticfentID());
                            //log.info(" Modificacio ID: " + modificacio.getQueEsticFentID());
                            /*if (qefi.getQueesticfentOriginal().getQueesticfentID() == modificacio.getQueesticfentId()) {                    
                              aborrar = qefi;
                              break;
                            }*/
                            //}

                        }

                        // Afegir al nou Map per data
                        Date newDate = toDate000000(modificacio.getData().getTime());
                        items = llista.get(newDate);
                        if (items == null) {
                            items = new ArrayList<QueEsticFentItem>();
                            llista.put(newDate, items);
                        }
                        items.add(item);

                        // Canviar data i afegir modificacio
                        item.setData(modificacio.getData());
                        item.addModificacioItem(
                                new ModificacioItem(modificacio, accionsByID.get(modificacio.getAccioID())));
                        /*
                        item.setModificacio(modificacio);
                        item.setAccio(accionsByID.get(modificacio.getAccioID()));
                        */

                    }
                }
                break;

                default:
                    throw new Exception("Accio desconeguda (" + modificacio.getAccioID()
                            + ") executant la modificacio amb ID " + modificacio.getModificacioID());
            }
        }

        // 5.- Afegir FESTIUS
        {
            Where wf1 = FestiusFields.DATA.greaterThanOrEqual(new java.sql.Date(start.getTime()));
            Where wf2 = FestiusFields.DATA.lessThanOrEqual(new java.sql.Date(end.getTime()));

            Where wf = Where.AND(wf1, wf2);

            List<Festius> festius = festiusEjb.select(wf, new OrderBy(FestiusFields.DATA, OrderType.ASC));
            for (Festius festa : festius) {

                Date date = toDate000000(festa.getData().getTime());

                item = new QueEsticFentItem(null, new Timestamp(festa.getData().getTime()),
                        "Festiu - " + festa.getNom());
                //item.setAccio(accionsByID.get(Utils.ACCIO_FESTIU));
                Accions accFesta = accionsByID.get(Utils.ACCIO_FESTIU);

                //log.info("Accio Festa : " + accFesta);
                ModificacionsQueEsticFent mqef = new ModificacionsQueEsticFentBean();
                mqef.setAccioID(Utils.ACCIO_FESTIU);
                mqef.setModificacioID(0);

                item.addModificacioItem(new ModificacioItem(mqef, accFesta));

                List<QueEsticFentItem> items = llista.get(date);

                if (items == null) {
                    items = new ArrayList<QueEsticFentItem>();
                    llista.put(date, items);
                }
                // Mapejar per data
                items.add(item);
            }

        }

        return llista;

    }

    public static final String LLISTAT_ENTRADES = "/llistatentrades";

    @RequestMapping(value = LLISTAT_ENTRADES, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView llistatEntrades(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("entradesListUser");

        String loggedUser = LoginInfo.getInstance().getUsername();

        boolean tePermisos;
        {

            boolean esAdministrador = LoginInfo.hasRole(Constants.ROLE_ADMIN);

            /*boolean esCoordinador;
            {
            
            IDepartaments[] list = DepartamentsManager.selectForOnlyRead(IDepartaments.COORDINADORID.equal(loggedUser));
            esCoordinador = (list.length != 0);
            }*/

            //Utils.CAP_DE_PROJECTE
            /*boolean esCapDeProjecte = false;
            {
            int[] roles = getSecurity().getRolesOfUser(loggedUser);
            List<KeyValue<Integer>> list = getSecurity().getAllRoleNames();
            for(int rol : roles) {
              String roleName = getSecurity().getFullNameOfRole(rol);
              if (Utils.CAP_DE_PROJECTE.equals(roleName)) {
                esCapDeProjecte = true;
                break;
              }
            }
            }*/
            tePermisos = esAdministrador; //|| esCoordinador || esCapDeProjecte;
        }

        mav.addObject("tePermisos", tePermisos);

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        mav.addObject("yesterday", yesterday);
        Calendar today = Calendar.getInstance();
        mav.addObject("today", today);

        Calendar start = Calendar.getInstance();
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        String usuariID = request.getParameter("usuariID");
        if (usuariID == null) {
            usuariID = loggedUser;
        }
        mav.addObject("usuariID", usuariID);

        // Cercar departaments de l'usuari
        List<Long> departaments;
        //UsuarisDepartament[] departamentsUsuari;
        {
            Where wud = UsuarisDepartamentFields.USUARIID.equal(usuariID);

            departaments = usuarisDepartamentEjb.executeQuery(UsuarisDepartamentFields.DEPARTAMENTID, wud);
        }

        if (departaments.isEmpty()) {
            throw new Exception("L'usuari " + usuariID + " no té departament assignat.");
        }

        // Seleccionar departamentID
        long departamentID;
        {
            String departamentIDStr = request.getParameter("departamentID");
            if (departamentIDStr == null) {
                departamentID = departaments.get(0);
            } else {
                departamentID = Long.parseLong(departamentIDStr);
            }
        }

        mav.addObject("departaments", departaments);
        mav.addObject("departamentID", departamentID);

        // ============== PROJECTES
        List<Long> projectes;
        /*
        if (esAdministrador) {
          // Com que soc administrador llegirï¿½ tots els projectes del departament
          Where wp = IProjectes.DEPARTAMENTID.equal(departamentID);
          Query<IProjectes, Integer> query;
          query = ProjectesManager.getQuery(IProjectes.PROJECTEID, wp);
          projectes = query.execute();
        } else
          */
        {
            /** Seleccionar projectes de l'usuari */
            Where wp = PersonalProjecteFields.USUARIID.equal(usuariID);

            projectes = personalProjecteEjb.executeQuery(PersonalProjecteFields.PROJECTEID, wp);
        }

        Long projecteID = null; // null == TOTS
        List<Long> projectesSeleccionats = projectes;
        {
            String projecteStr = null;
            if(request.getParameter("projecteID")!= null) {
                projecteStr = request.getParameter("projecteID");
            }
            
            if (projecteStr != null && projecteStr.length() != 0) {
                projecteID = Long.parseLong(projecteStr);
                // Projecte per parï¿½metre no esta en la llista de disponibles
                if (projectes.contains(projecteID)) {
                    projectesSeleccionats = new ArrayList<Long>();
                    projectesSeleccionats.add(projecteID);
                }
            }
        }

        if (projecteID == null) {
            // Tots els projectes
            projectesSeleccionats = projectes;
            if (projectesSeleccionats.size() == 1) {
                projecteID = projectes.get(0);
            }
        }

        mav.addObject("projecteID", projecteID);

        int mes;
        {
            String mesStr = request.getParameter("mes");
            if (mesStr == null) {
                mes = start.get(Calendar.MONTH);
            } else {
                mes = Integer.parseInt(mesStr);
            }
        }

        mav.addObject("mes", mes);

        // Seleccionar any
        int any;
        {
            String anyStr = request.getParameter("any");
            if (anyStr == null) {
                any = start.get(Calendar.YEAR);
            } else {
                any = Integer.parseInt(anyStr);
            }
        }
        mav.addObject("any", any);

        boolean mostrarEntradesAmagades = false;
        {
            String mostrarEntradesAmagadesStr = request.getParameter("mostrarEntradesAmagades");
            if (mostrarEntradesAmagadesStr != null) {
                log.info("mostrarEntradesAmagades: " + mostrarEntradesAmagadesStr);
                mostrarEntradesAmagades = ("on".compareTo(mostrarEntradesAmagadesStr) == 0);
            }
            mav.addObject("mostrarEntradesAmagades", mostrarEntradesAmagades);
        }

        int mesAnterior = mes - 1;
        int anyAnterior = any;
        if (mesAnterior < Calendar.JANUARY) {
            mesAnterior = Calendar.DECEMBER;
            anyAnterior = any - 1;
        }

        mav.addObject("anyAnterior", anyAnterior);
        mav.addObject("mesAnterior", mesAnterior);

        int anySeguent = any;
        int mesSeguent = mes + 1;
        if (mesSeguent > Calendar.DECEMBER) {
            mesSeguent = Calendar.JANUARY;
            anySeguent = any + 1;
        }
        mav.addObject("anySeguent", anySeguent);
        mav.addObject("mesSeguent", mesSeguent);

        start.set(Calendar.MONTH, mes);
        start.set(Calendar.YEAR, any);
        start.set(Calendar.DATE, 1);

        int maxDay = start.getActualMaximum(Calendar.DAY_OF_MONTH);
        mav.addObject("maxDay", maxDay);

        Calendar end = Calendar.getInstance();
        end.setTimeInMillis(start.getTimeInMillis());
        end.set(Calendar.DATE, maxDay);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);

        // (1) Obtenir dades
        Map<Date, List<QueEsticFentItem>> itemsByDate;

        itemsByDate = getQueEsticFentItemByUser(usuariID, projectesSeleccionats, start.getTime(), end.getTime());
        //  itemsByDate = new java.util.HashMap<Date, List<QueEsticFentItem>>();
        mav.addObject("start", start);
        mav.addObject("itemsByDate", itemsByDate);

        {
            List<Accions> allAccions;
            //allAccions = new IAccions[0];

            Where wa = AccionsFields.ACCIOID.greaterThanOrEqual((long) 0);
            allAccions = accionsEjb.select(wa, new OrderBy(AccionsFields.NOM, OrderType.ASC));
            //allAccions = accionsEjb.selectForOnlyRead(wa, OrderType.ASC, AccionsFields.NOM);
            mav.addObject("allAccions", allAccions);
        }

        String redirectUrlParams = "mes=" + mes + "&any=" + any + "&usuariID=" + usuariID;
        if (projecteID != null) {
            redirectUrlParams = redirectUrlParams + "&projecteID=" + projecteID.intValue();
        }
        mav.addObject("redirectUrlParams", redirectUrlParams);
        String redirectUrl = URLEncoder.encode("LlistatEntrades.jsp?" + redirectUrlParams, "UTF-8");
        mav.addObject("redirectUrl", redirectUrl);
        mav.addObject("projecteID", projecteID);
        {
            //ISecurity __security = ManagerQueEsticFentOTAE.getSecurity();
            Where ud = UsuarisDepartamentFields.DEPARTAMENTID.equal(departamentID);
            List<UsuarisDepartament> personalCap = this.usuarisDepartamentEjb.select(ud);
            for (UsuarisDepartament usuarisDepartament : personalCap) {

                UsuarisJPA usuari = usuarisEjb.findByPrimaryKey(usuarisDepartament.getUsuariID());
                UsuarisDepartamentJPA usuarisDepartamentJpa = (UsuarisDepartamentJPA) usuarisDepartament;
                usuarisDepartamentJpa.setUsuaris(usuari);
            }
            mav.addObject("personalCap", personalCap);
        }
        {
            List<Accions> actions = this.accionsEjb.select(AccionsFields.COLOR.isNotNull(),
                    new OrderBy(AccionsFields.ACCIOID, OrderType.ASC));
            actions.add(new AccionsBean(-10, null, "Multiples Canvis", "ffff00", null));
            mav.addObject("actions", actions);
        }
        {
            Where where = ProjectesFields.PROJECTEID.in(projectes);
            List<Projectes> projectesList = this.projectesEjb.select(where);
            mav.addObject("projectesList", projectesList);
        }
        {
            Where where = DepartamentsFields.DEPARTAMENTID.in(departaments);
            List<Departaments> departamentsInfo = this.departamentsEjb.select(where);
            mav.addObject("departamentsInfo", departamentsInfo);
        }

        log.info("\n\n XYZ redirectUrlParams: " + redirectUrlParams);
        return mav;
    }

    protected static Date toDate000000(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        //return cal.get(Calendar.DAY_OF_MONTH);

        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Put it back in the Date object  
        return cal.getTime();

    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request,
            ModificacionsQueEsticFentForm modificacionsQueEsticFentForm) {
        return "redirect:" + getContextWeb() + LLISTAT_ENTRADES;
    }

    @Override
    public String getRedirectWhenModified(HttpServletRequest request,
            ModificacionsQueEsticFentForm modificacionsQueEsticFentForm, Throwable __e) {
        if (__e == null) {
            return "redirect:" + getContextWeb() + LLISTAT_ENTRADES;
        } else {
            return getTileForm();
        }
    }

    @Override
    public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long modificacioID, Throwable __e) {
        return "redirect:" + getContextWeb() + LLISTAT_ENTRADES;
    }

    @Override
    public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long modificacioID) {
        return "redirect:" + getContextWeb() + LLISTAT_ENTRADES;
    }

    @RequestMapping(value = "mostrarodt", method = { RequestMethod.GET, RequestMethod.POST })
    public void mostrarODT(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Usuari seleccionat
        String usuariID = request.getParameter("usuariID");

        try {
            Calendar start = Calendar.getInstance();
            //Mes seleccionat
            int mes;
            {
                String mesStr = request.getParameter("mes");
                if (mesStr == null) {
                    mes = start.get(Calendar.MONTH);
                } else {
                    mes = Integer.parseInt(mesStr);
                }
            }

            // Any Seleccionat
            int any;
            {
                String anyStr = request.getParameter("any");
                if (anyStr == null) {
                    any = start.get(Calendar.YEAR);
                } else {
                    any = Integer.parseInt(anyStr);
                }
            }

            
            //Projecte seleccionat
            
            
            String projecteStr = request.getParameter("projecteID");
            String projectName = "OTAE";
            
            List<String> usuarisList;
            List<Long> projectesID = new ArrayList<Long>(); 
            List<Projectes> projectes;
            Where w;
           
            
            if (projecteStr != null && projecteStr.trim().length() > 0 && Long.parseLong(projecteStr)>0) {
                //En cas de que arribi un projecte per parametre: Seleccionam 1 projecte
                Long projecteID = Long.parseLong(projecteStr);
                projectesID.add(projecteID);
                
                Where equalProjecteId = PersonalProjecteFields.PROJECTEID.equal(projecteID);
                Where equalUsuariId = PersonalProjecteFields.USUARIID.equal(usuariID);
                
                if ("true".equals(request.getParameter("multiple"))) {
                    log.info("S'HA ENTRAT A MULTIPLES USUARI");
                    w = equalProjecteId;
                } else {
                    log.info("S'HA ENTRAT A UN USUARI");
                    w = Where.AND(equalProjecteId, equalUsuariId);
                }
                
            }else {
                // No arriba projecte per parametre: Tots els projectes
                projectName = "OTAE";
                
                //Agafam el llistat complet de projectes
                projectesID = projectesEjb.executeQuery(ProjectesFields.PROJECTEID, new OrderBy(ProjectesFields.PROJECTEID));
               
                if ("true".equals(request.getParameter("multiple"))) {
                    log.info("S'HA ENTRAT A MULTIPLES USUARI");
                    Where equalProjecteId= PersonalProjecteFields.PROJECTEID.in(projectesID);
                    w = equalProjecteId;
                } else {
                    log.info("S'HA ENTRAT A UN USUARI");
                    Where equalProjecteId= PersonalProjecteFields.PROJECTEID.in(projectesID);
                    Where equalUsuariId= PersonalProjecteFields.USUARIID.equal(usuariID);
                    w = Where.AND(equalProjecteId, equalUsuariId);
                }
            }
            
            
            usuarisList = personalProjecteEjb.executeQuery(PersonalProjecteFields.USUARIID, w,
                    new OrderBy(PersonalProjecteFields.ORDRE));
                        
            response.setContentType("application/application/vnd.oasis.opendocument.text");
            response.setHeader("Content-Disposition", "filename=\"" + projectName + "_Seguiment_Tasques_"

                    + StringEscapeUtils.unescapeHtml4(Utils.mesos[mes]) + "_" + any + ".odt\""); // inline;

            File webInfDir = new File(FileSystemManager.getFilesPath(), "plantilles");
            webInfDir.mkdirs();

            File templateFile = new File(webInfDir, projectName + "_Template.odt"); //"Template_TasquesPersonalOTAE.odt")
            if (!templateFile.exists()) {
                templateFile = new File("DEFAULT_Template.odt");
            }

            Map<String, Object> map = generateUserInfo(usuarisList, projectesID, any, mes);

            ArrayList<org.fundaciobit.queesticfent.back.controller.user.UserInfo> llistaDeUserInfo = (ArrayList<org.fundaciobit.queesticfent.back.controller.user.UserInfo>) map
                    .get("usuaris");
            log.info("XYZ llistatDeUserInfo SIZE= " + llistaDeUserInfo.size());

            for (org.fundaciobit.queesticfent.back.controller.user.UserInfo userInfo : llistaDeUserInfo) {
                log.info(" ----- " + userInfo.nom);
                for (Item item : userInfo.items) {
                    log.info(" **" + item.dia + "   -" + item.comentari);
                }

            }

            //template.createDocument(map, baos);

            OutputStream outStream = response.getOutputStream();
            generateUsingXDocReport(map, templateFile, outStream);
            //generateUsingJooReports(map, templateFile, outStream);

            outStream.flush();

        } catch (Throwable e) {

            String msg = "Error generant ODT: ";
            if (e instanceof I18NException) {
                msg = msg + I18NUtils.getMessage((I18NException) e);

            } else {
                msg = msg + e.getMessage();
            }
            log.error(msg, e);
            HtmlUtils.saveMessageError(request, msg);
            response.sendRedirect(request.getContextPath() + getContextWeb() + LLISTAT_ENTRADES);

        }
    }

    public static void generateUsingXDocReport(Map<String, Object> map, File templateFile, OutputStream outStream)
            throws IOException, XDocReportException {
        InputStream in = new FileInputStream(templateFile);
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);

        // 2) Create fields metadata to manage lazy loop ([#list Freemarker) for table row and manage dynamic image
        FieldsMetadata metadata = report.createFieldsMetadata();

        metadata.load("items", Item.class, true);
        report.setFieldsMetadata(metadata);

        // Create context Java model
        IContext context = report.createContext();
        context.putMap(map);
        report.process(context, outStream);
    }

    public Map<String, Object> generateUserInfo(List<String> usuaris, Long projecteID, int any, int mes)
            throws Exception {
        return generateUserInfo(usuaris, Arrays.asList(new Long[] { projecteID }), any, mes);
    }

    private Map<String, Object> generateUserInfo(List<String> usuaris, List<Long> projectes, int any, int mes)
            throws Exception {
        
        List<KeyValue<Long>> projectesList = this.projectesEjb.executeQuery(new SelectMultipleKeyValue<Long>(ProjectesFields.PROJECTEID.select, ProjectesFields.NOM.select), new OrderBy(ProjectesFields.PROJECTEID));
        
        Map<Long, String> projectesMap = new HashMap<Long, String>();
        
        for (KeyValue<Long> keyValue : projectesList) {
            projectesMap.put(keyValue.getKey(), keyValue.getValue());
        }
        

        Calendar start = Calendar.getInstance();

        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        start.set(Calendar.MONTH, mes);
        start.set(Calendar.YEAR, any);
        start.set(Calendar.DATE, 1);

        int maxDay = start.getActualMaximum(Calendar.DAY_OF_MONTH);

        Calendar end = Calendar.getInstance();
        end.setTimeInMillis(start.getTimeInMillis());
        end.set(Calendar.DATE, maxDay);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);

        ArrayList<org.fundaciobit.queesticfent.back.controller.user.UserInfo> llistaDeUserInfo = new ArrayList<org.fundaciobit.queesticfent.back.controller.user.UserInfo>();

        List<Usuaris> usuarisFull = usuarisEjb.select(UsuarisFields.USUARIID.in(usuaris));
        for (Usuaris usuari : usuarisFull) {
            String usuariID = usuari.getUsuariID();
            start.set(Calendar.DATE, 1);

            Map<Date, List<QueEsticFentItem>> itemsByDate;
            itemsByDate = getQueEsticFentItemByUser(usuariID, projectes, start.getTime(), end.getTime());

            log.info("=========================");
            log.info(": " + itemsByDate.size());
            log.info("Llista: " + itemsByDate.size());
            log.info("MAX DAY: " + maxDay);
            log.info("Usuari: " + usuariID);

            List<Item> items = new ArrayList<Item>();
            List<QueEsticFentItem> llista;
            for (int d = 1; d <= maxDay; d++) {

                String dStr = String.valueOf(d);

                start.set(Calendar.DATE, d);
                int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);

                boolean isCapDeSetmana = (dayOfWeek == Calendar.SUNDAY) || (dayOfWeek == Calendar.SATURDAY);
                llista = itemsByDate.get(start.getTime());

                Item item = new Item();
                item.setDia(dStr);
                if (isCapDeSetmana) {
                    item.setComentari("----------------------------- " + Utils.diesFull[dayOfWeek]
                            + " -----------------------------");
                } else {
                    if (llista == null || llista.size() == 0) {
                        item.setComentari("");
                    } else {
                        StringBuffer comment = new StringBuffer();
                        for (QueEsticFentItem qefi : llista) {
                            if (qefi.getModificacioItemByAccioType(Utils.ACCIO_AMAGAR_ENTRADA) != null) {
                                continue;
                            }

                            if (comment.length() != 0) {
                                comment.append('\n');
                            }
                            String descripcioItem="";
                            if(qefi.getModificacions().get(0).getModificacio().getProjecteID() != null) {
                                descripcioItem = projectesMap.get(qefi.getModificacions().get(0).getModificacio().getProjecteID())+": "+qefi.getDescripcio();
                            }else {
                                descripcioItem = qefi.getDescripcio();
                            }
                            
                            log.info("    *" + descripcioItem);

                            comment.append(descripcioItem);
                            
                        }
                        item.setComentari(comment.toString());
                    }
                }
                items.add(item);
                log.info("Introduit Item: [" + d + "] " + item.comentari);
                ;
            }
            String fullname = usuari.getNom() + " " + usuari.getLlinatge1()
                    + (usuari.getLlinatge2() != null ? (" " + usuari.getLlinatge2()) : "");
            org.fundaciobit.queesticfent.back.controller.user.UserInfo userInfo = new org.fundaciobit.queesticfent.back.controller.user.UserInfo(
                    fullname, items);

            llistaDeUserInfo.add(userInfo);

        }
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("mes", StringEscapeUtils.unescapeHtml4(Utils.mesos[mes]));
        data.put("any", String.valueOf(any));
        data.put("usuaris", llistaDeUserInfo);

        return data;
    }

}
