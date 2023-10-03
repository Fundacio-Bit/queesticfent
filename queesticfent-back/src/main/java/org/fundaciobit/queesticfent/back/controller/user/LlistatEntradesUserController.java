package org.fundaciobit.queesticfent.back.controller.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.queesticfent.back.controller.webdb.ModificacionsQueEsticFentController;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentForm;
import org.fundaciobit.queesticfent.back.security.LoginInfo;
import org.fundaciobit.queesticfent.back.utils.Utils;
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
        form.addReadOnlyField(PROJECTEID);

        return form;
    }

    public static SimpleDateFormat getSimpleDateTimeFormat() {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    protected Map<Date, List<QueEsticFentItem>> getQueEsticFentItemByUser(String usuariID,
            List<Long> projectes, Date start, Date end) throws Exception {

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
        log.info("XYZ ZZZ Modificacions = "+modificacions.size());

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
                    log.info("XXX XYZ Dia = "+modificacio.getData() + "       --- Titol Dia mes: "+date);
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
                case (int)  Utils.ACCIO_FESTIU:
                // Es realitza amb la taula de Fesius
                    
                    
                    
                    
                    
                    
                break;
                //    '0'    no mostrar entrada                ID, usuari, data    
                case (int) Utils.ACCIO_AMAGAR_ENTRADA: {
                    item = itemsByQueEsticFentID.get(modificacio.getQueEsticFentID());
                    if (item == null) {
                        System.out.println("Modificaci� amb ID " + modificacio.getModificacioID()
                                + " fa refer�ncia a entrada no arregada amb ID " + modificacio.getQueEsticFentID());
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
                        System.out.println("DADA1: ]" + modificacio.getDada1() + "[");
                        System.out.println("DADA2: ]" + dada2 + "[");
                        System.out.println("DESC: ]" + item.getDescripcio() + "[");
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
                    //System.out.println(" + Modificacio QEF_ID: " + modificacio.getQueEsticFentID());
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
                            QueEsticFentItem aborrar = null;
                            for (QueEsticFentItem qefi : items) {
                                //System.out.println(" ID original: " + qefi.getQueesticfentOriginal().getQueesticfentID());
                                //System.out.println(" Modificacio ID: " + modificacio.getQueEsticFentID());
                                /*if (qefi.getQueesticfentOriginal().getQueesticfentID() == modificacio.getQueesticfentId()) {                    
                                  aborrar = qefi;
                                  break;
                                }*/
                            }
                            if (aborrar != null) {
                                items.remove(aborrar);
                            }
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

                    } else {
                        //   TODO
                        System.out.println(" ERRROR ");
                        new Exception().printStackTrace();
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

                //System.out.println("Accio Festa : " + accFesta);
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
        UsuarisDepartament[] departamentsUsuari;
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
            String projecteStr = "28"; //request.getParameter("projecteID");
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
                System.out.println("mostrarEntradesAmagades: " + mostrarEntradesAmagadesStr);
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

        String usuariID = request.getParameter("usuariID");

        try {
            Calendar start = Calendar.getInstance();

            int mes;
            {
                String mesStr = request.getParameter("mes");
                if (mesStr == null) {
                    mes = start.get(Calendar.MONTH);
                } else {
                    mes = Integer.parseInt(mesStr);
                }
            }

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

            //============== PROJECTES

            Long projecteID; // REQUERIT
            {
                String projecteStr = request.getParameter("projecteID");
                if (projecteStr == null || projecteStr.trim().length() == 0) {
                    //XYZ Gestio d'errors?
                    //throw new Exception("No s'ha passat el paràmetre projecteID.");
                    log.error("No s'ha passat el paràmetre projecteID.");
                }
                projecteID = Long.parseLong(projecteStr);
            }
            String projectName = projectesEjb.findByPrimaryKey(projecteID).getNom();

            log.info("XYZ ProjectID: " + projecteID);
            log.info("XYZ projectName: " + projectName);

            response.setContentType("application/application/vnd.oasis.opendocument.text");
            response.setHeader("Content-Disposition", "filename=\"" + projectName + "_Seguiment_Tasques_"
                    
                    + StringEscapeUtils.unescapeHtml4(Utils.mesos[mes]) + "_" + any + ".odt\""); // inline;

            List<String> usuarisList;
            {
                Where w;
                Where w1 = PersonalProjecteFields.PROJECTEID.equal(projecteID);
                if ("true".equals(request.getParameter("multiple"))) {
                    w = w1;
                } else {
                    Where w2 = PersonalProjecteFields.USUARIID.equal(usuariID);
                    w = Where.AND(w1, w2);
                }

                usuarisList = personalProjecteEjb.executeQuery(PersonalProjecteFields.USUARIID, w,
                        new OrderBy(PersonalProjecteFields.ORDRE));
            }

            log.info("XYZ usuarisList: " + usuarisList.toArray());

            // XYZ Passar a log
            for (String usr : usuarisList) {

                System.out.println("Personal projecte " + projecteID + ": " + usr);
            }

            System.out.println();
            System.out.println();

            //DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();

            File webInfDir = new File(FileSystemManager.getFilesPath(), "plantilles");
            webInfDir.mkdirs();

            File templateFile = new File(webInfDir, projectName + "_Template.odt"); //"Template_TasquesPersonalOTAE.odt")
            if (!templateFile.exists()) {
                templateFile = new File("DEFAULT_Template.odt");
            }

            //DocumentTemplate template = documentTemplateFactory.getTemplate(templateFile);

            Map<String, Object> map = generateUserInfo(usuarisList, projecteID, any, mes);

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

                metadata.load( "items", Item.class, true );
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

            System.out.println("=========================");
            System.out.println(": " + itemsByDate.size());
            System.out.println("Llista: " + itemsByDate.size());
            System.out.println("MAX DAY: " + maxDay);
            System.out.println("Usuari: " + usuariID);

            List<Item> items = new ArrayList<Item>();
            List<QueEsticFentItem> llista;
            for (int d = 1; d <= maxDay; d++) {

                String dStr = String.valueOf(d);

                start.set(Calendar.DATE, d);
                int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);

                boolean isCapDeSetmana = (dayOfWeek == Calendar.SUNDAY) || (dayOfWeek == Calendar.SATURDAY);
                llista = itemsByDate.get(start.getTime());
                /*if(llista != null) {
                    log.info("XYZ llista itembsByDate["+d+"] = " +llista.size());
                    for (QueEsticFentItem userInfo : llista) {
                        log.info("    -"+userInfo.getDescripcio());
                    } 
                }*/

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
                            /*
                            if (qefi.getAccio() != null && qefi.getAccio().getAccioID() == Utils.ACCIO_AMAGAR_ENTRADA) {
                              continue;
                            }
                            */
                            if (qefi.getModificacioItemByAccioType(Utils.ACCIO_AMAGAR_ENTRADA) != null) {
                                continue;
                            }

                            if (comment.length() != 0) {
                                comment.append('\n');
                            }
                            log.info("    *" + qefi.getDescripcio());
                            comment.append(qefi.getDescripcio());

                        }
                        item.setComentari(comment.toString());
                        //System.out.println("DIA " + d + ": " + comment.toString());
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
