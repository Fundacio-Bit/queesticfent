package org.fundaciobit.queesticfent.api.externa.secure.modificacions;

import java.sql.Timestamp;
import java.util.Locale;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.utils.rest.RestException;
import org.fundaciobit.pluginsib.utils.rest.RestExceptionInfo;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;
import org.fundaciobit.queesticfent.commons.utils.Constants;
import org.fundaciobit.queesticfent.logic.utils.I18NLogicUtils;
import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;
import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;

/**
 * 
 * @author anadal
 *
 */
@Path("/secure/modificacions")
@OpenAPIDefinition(tags = { @Tag(name = ModificacionsService.TAG , description = "Api per afegir entrades de QueEsticFent"), })
@SecurityScheme(type = SecuritySchemeType.HTTP, name = ModificacionsService.SEC, scheme = "basic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModificacionsService extends RestUtils{
    
    
    protected static final String TAG = "Modificacions";
    
    protected static final String SEC = "BasicAuth";

    protected static final Logger log = Logger.getLogger(ModificacionsService.class);
    
    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService modificacionsQueEsticFentEjb;

    @Path("/add")
    @POST
    @RolesAllowed(Constants.QEF_WS)
	@SecurityRequirement(name = SEC)  
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(operationId = "add", summary = "Afegeix una nova entrada", tags = { TAG })
    @ApiResponses(
            value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operació finalitzada correctament",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Long.class))),
        @ApiResponse(
                responseCode = "400",
                description = "EFIB: Paràmetres incorrectes",
                content = { @Content(
                        mediaType = MIME_APPLICATION_JSON,
                        schema = @Schema(implementation = RestExceptionInfo.class)) }),
        @ApiResponse(
                responseCode = "401",
                description = "EFIB: No Autenticat",
                content = { @Content(
                        mediaType = MIME_APPLICATION_JSON,
                        schema = @Schema(implementation = String.class)) }),
        @ApiResponse(
                responseCode = "403",
                description = "EFIB: No Autoritzat",
                content = { @Content(
                        mediaType = MIME_APPLICATION_JSON,
                        schema = @Schema(implementation = String.class)) }),
        @ApiResponse(
                responseCode = "500",
                description = "EFIB: Error durant la consulta de les dades obertes",
                content = { @Content(
                        mediaType = MIME_APPLICATION_JSON,
                        schema = @Schema(implementation = RestExceptionInfo.class)) }),
        @ApiResponse(
            responseCode = "510",
            description = "Només s'utilitza per crear fitxer de constants...",
            content = { @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ModificacionsConstants.class)) }) })
    public Long add(
            @RequestBody(content = {@Content (schema = @Schema(implementation = Modificacio.class))} , required = true)  Modificacio modificacio) {

        log.info(" Entra a ADD de AfegirModificacio ... ");
        String language = modificacio.getLanguage();

        try {
            
            ModificacionsQueEsticFent modif = new ModificacionsQueEsticFentJPA();
            modif.setDada1(modificacio.getDada1());
            modif.setData(new Timestamp(modificacio.getData().getTime()));
            modif.setProjecteID(modificacio.getProjecteID());
            modif.setUsuariID(modificacio.getUsuariID());
            modif = modificacionsQueEsticFentEjb.create(modif);
            

            return modif.getModificacioID();
              
        } catch (RestException e) {
            log.error("Error cridada api rest estadistiques accessos: " + e.getMessage());
            throw e;
            
        }catch (Throwable th) {

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

}
