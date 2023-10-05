package org.fundaciobit.queesticfent.api.externa.secure.modificacions;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

import org.fundaciobit.queesticfent.commons.utils.Constants;

/**
 * 
 * @author anadal
 *
 */

@Schema(name = "ModificacionsConstants")
public class ModificacionsConstants {

    @Schema(
            description = "Constant ROLE_EJB_FULL_ACCESS",
            nullable = false,
            defaultValue = "" + Constants.ROLE_EJB_FULL_ACCESS,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String ROLE_EJB_FULL_ACCESS;

    @Schema(
            description = "Constant ROLE_EJB_BASIC_ACCESS",
            nullable = false,
            defaultValue = "" + Constants.ROLE_EJB_BASIC_ACCESS,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String ROLE_EJB_BASIC_ACCESS;

    @Schema(
            description = "Constant ROLE_EJB_WS_ACCESS",
            nullable = false,
            defaultValue = "" + Constants.ROLE_EJB_BASIC_ACCESS,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String ROLE_EJB_WS_ACCESS;

}