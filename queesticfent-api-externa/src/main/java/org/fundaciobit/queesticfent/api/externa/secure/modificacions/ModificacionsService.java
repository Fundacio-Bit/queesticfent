package org.fundaciobit.queesticfent.api.externa.secure.modificacions;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.utils.rest.RestException;
import org.fundaciobit.pluginsib.utils.rest.RestExceptionInfo;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;
import org.fundaciobit.queesticfent.commons.utils.Constants;
import org.fundaciobit.queesticfent.logic.utils.I18NLogicUtils;
import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;
import org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields;
import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

/**
 * 
 * @author anadal
 *
 */
@Path("/secure/modificacions")
@OpenAPIDefinition(tags = {
        @Tag(name = ModificacionsService.TAG, description = "Api per afegir entrades de QueEsticFent"), })
@SecurityScheme(type = SecuritySchemeType.HTTP, name = ModificacionsService.SEC, scheme = "basic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModificacionsService extends RestUtils {

    protected static final String TAG = "Modificacions";

    protected static final String SEC = "BasicAuth";

    protected final Logger log = Logger.getLogger(this.getClass());

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService modificacionsQueEsticFentEjb;

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.UsuarisService usuarisEjb;

    @Path("/add")
    @POST
    @RolesAllowed(Constants.QEF_WS)
    @SecurityRequirement(name = SEC)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(operationId = "add", summary = "Afegeix una nova entrada", tags = { TAG })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operació finalitzada correctament", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "EFIB: Paràmetres incorrectes", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(responseCode = "401", description = "EFIB: No Autenticat", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "403", description = "EFIB: No Autoritzat", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "500", description = "EFIB: Error durant la consulta de les dades obertes", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(responseCode = "510", description = "Només s'utilitza per crear fitxer de constants...", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ModificacionsConstants.class)) }) })
    public Long add(@RequestBody(content = {
            @Content(schema = @Schema(implementation = AddModificacioRequest.class)) }, required = true) AddModificacioRequest modificacio) {

        log.info(" Entra a ADD de AfegirModificacio ... ");
        String language = modificacio.getLanguage();

        try {

            ModificacionsQueEsticFent modif = new ModificacionsQueEsticFentJPA();
            modif.setDada1(modificacio.getDada1());
            modif.setData(new Date(modificacio.getData().getTime()));
            modif.setProjecteID(modificacio.getProjecteID());
            modif.setUsuariID(modificacio.getUsuariID());
            modif = modificacionsQueEsticFentEjb.create(modif);

            return modif.getModificacioID();

        } catch (RestException e) {
            log.error("Error cridada api rest estadistiques accessos: " + e.getMessage());
            throw e;

        } catch (Throwable th) {

            String msg;
            if (th instanceof I18NException) {
                msg = I18NLogicUtils.getMessage((I18NException) th, new Locale(language));
            } else {
                msg = th.getMessage();
            }
            this.log.error("Error desconegut retornant dades obertes: " + msg, th);
            throw new RestException(msg, th, Status.INTERNAL_SERVER_ERROR);
        }

    }

    @Path("/getmodificacions")
    @POST
    @RolesAllowed(Constants.QEF_WS)
    @SecurityRequirement(name = SEC)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(operationId = "getmodificacions", summary = "Retorna les modificacions segons a un rang de temps. Permet filtrar per usuaris", tags = {
            TAG })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operació finalitzada correctament", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetModificacionsResponse.class))),
            @ApiResponse(responseCode = "400", description = "QEFI: Paràmetres incorrectes", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(responseCode = "401", description = "QEFI: No Autenticat", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "403", description = "QEFI: No Autoritzat", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "500", description = "QEFI: Error durant la consulta de les dades obertes", content = {
                    @Content(mediaType = MIME_APPLICATION_JSON, schema = @Schema(implementation = RestExceptionInfo.class)) }),
            @ApiResponse(responseCode = "510", description = "Només s'utilitza per crear fitxer de constants...", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ModificacionsConstants.class)) }) })
    public GetModificacionsResponse getModificacions(

            @Parameter(description = "Identificador de l'usuari", required = true, example = "jgarcia", schema = @Schema(implementation = String.class)) @QueryParam("usuariID") String usuariID,

            @Parameter(name = "date", description = "Filtre Data de la consulta. Format yyyy-MM-dd (ISO 8601)", required = true, example = "2023-07-19", in = ParameterIn.QUERY, schema = @Schema(implementation = String.class, pattern = DATE_PATTERN_ISO8601_ONLYDATE)) @QueryParam("date") String date,
            @Parameter(name = "language", description = "Idioma en que s'han de retornar les dades(Només suportat 'ca' o 'es')", in = ParameterIn.QUERY, required = false, examples = {
                    @ExampleObject(name = "Català", value = "ca"),
                    @ExampleObject(name = "Castellano", value = "es") }, schema = @Schema(defaultValue = "ca", implementation = String.class)) @QueryParam("language") String language,

            @Parameter(hidden = true) @Context HttpServletRequest request

    ) throws RestException {

        log.info(" Entra a getModificacions ... ");

        try {

            language = RestUtils.checkLanguage(language);

            Where whereUserId = ModificacionsQueEsticFentFields.USUARIID.equal(usuariID);

            java.util.Date data2 = RestUtils.parseOnlyDateISO8601ToDate(date, "date", "ca");
            if (data2 == null) {
                throw new RestException("Data es buida");
            }
            Where whereDateStart = ModificacionsQueEsticFentFields.DATA.equal(new Date(data2.getTime()));
            Where whereGetModificacions = Where.AND(whereUserId, whereDateStart);

            GetModificacionsResponse modificacionsResponse = new GetModificacionsResponse();
            List<ModificacionsQueEsticFent> select = modificacionsQueEsticFentEjb.select(whereGetModificacions);
            List<ModificacioRest> list = new ArrayList<ModificacioRest>();

            for (ModificacionsQueEsticFent modificacionsQueEsticFent : select) {
                list.add(new ModificacioRest(modificacionsQueEsticFent.getModificacioID(),
                        modificacionsQueEsticFent.getAccioID(), modificacionsQueEsticFent.getUsuariID(),
                        modificacionsQueEsticFent.getProjecteID(),
                        new Timestamp(modificacionsQueEsticFent.getData().getTime()),
                        modificacionsQueEsticFent.getDada1(), modificacionsQueEsticFent.getDada2()));
            }

            modificacionsResponse.setModificacions(list);
            return modificacionsResponse;

        } catch (RestException e) {
            log.error("Error cridada api rest estadistiques accessos: " + e.getMessage());
            throw e;

        } catch (Throwable th) {
            String msg;
            msg = th.getMessage();
            this.log.error("Error desconegut retornant dades obertes: " + msg, th);
            throw new RestException(msg, th, Status.INTERNAL_SERVER_ERROR);
        }

    }

}
