package org.fundaciobit.queesticfent.commons.utils;

/**
 *
 * @author anadal
 *
 */
public interface Constants {

  public static final String QUEESTICFENT_PROPERTY_BASE="org.fundaciobit.queesticfent.";

    public static final String MAIL_SERVICE = "java:/org.fundaciobit.queesticfent.mail";

    // TRUE ROLES
    public static final String QEF_ADMIN="QEF_ADMIN";
    public static final String QEF_USER="QEF_USER";
    public static final String QEF_WS="QEF_WS";

    // VIRTUAL SECURITY ROLES
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    // EJB HIGH LEVEL ROLES
    public static final String ROLE_EJB_FULL_ACCESS  = QEF_ADMIN;
    public static final String ROLE_EJB_BASIC_ACCESS = QEF_USER;
    public static final String ROLE_EJB_WS_ACCESS = QEF_WS;
}
