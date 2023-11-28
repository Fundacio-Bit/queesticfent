package org.fundaciobit.queesticfent.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author GenApp
 * 
 */
public class Configuracio implements Constants {

    private static final Properties fileProperties = new Properties();

    private static final Properties fileAndSystemProperties = new Properties();

    /*
     * Agafa els fitxers de propietats definits a l'standalone
     *
     * Seguim els estandars de la CAIB
     */
    public static Properties getFilesProperties() {

		if (fileProperties.isEmpty()) {
			// matches the property name as defined in the system-properties element in
			// WildFly
			String property = Constants.QUEESTICFENT_PROPERTY_BASE + "properties";
			loadPropertyFile(property);

			String propertySystem = Constants.QUEESTICFENT_PROPERTY_BASE + "system.properties";
			loadPropertyFile(propertySystem);
		}

		return fileProperties;

	}

    public static void loadPropertyFile(String property) {

        String propertyFile = System.getProperty(property);

        if (propertyFile == null) {
            String msg = "No existeix la propietat: " + property
                    + " al fitxer standalone. S'hauria d'incloure aquesta propietat a l'etiqueta <system-properties> del fitxer standalone";
            throw new RuntimeException(msg);
        }

        if (propertyFile.trim().length() == 0) {
            String msg = "La propietat: " + property
                    + " del fitxer standalone no té valor. Se li ha de posar el fitxer corresponent a la propietat al fitxer standalone";
            throw new RuntimeException(msg);
        }

        File File = new File(propertyFile);
        try {
            fileProperties.load(new FileInputStream(File));

        } catch (FileNotFoundException e) {
            throw new RuntimeException("La propietat: " + property
                    + " del fitxer standalone apunta a un fitxer que no existeix (" + propertyFile + ")");

        } catch (IOException e) {
            throw new RuntimeException("La propietat: " + property + " del fitxer standalone apunta a un fitxer("
                    + propertyFile + ") que no es pot llegir:" + e.getMessage(), e);
        }
    }

    public static Properties getSystemAndFileProperties() {

        if (fileAndSystemProperties.isEmpty()) {
            fileAndSystemProperties.putAll(getFilesProperties());
            fileAndSystemProperties.putAll(System.getProperties());
        }
        return fileAndSystemProperties;
    }

    public static String getProperty(String key) {

        return getFilesProperties().getProperty(key);

    }

    public static String getProperty(String key, String def) {

        return getFilesProperties().getProperty(key, def);

    }

    public static boolean isDesenvolupament() {

        return Boolean.parseBoolean(getProperty(QUEESTICFENT_PROPERTY_BASE + "development"));
    }

    public static boolean isCAIB() {
        return Boolean.parseBoolean(getProperty(QUEESTICFENT_PROPERTY_BASE + "iscaib"));
    }

    public static String getAppEmail() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "email.from");
    }

    public static String getAppName() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "name", "queesticfent");
    }
    
    public static String getFrontUrl() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "url.front");
    }
    
    public static String getBackUrl() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "url.back");
    }

    public static String getDefaultLanguage() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "defaultlanguage", "ca");
    }

    public static byte[] getEncryptKey() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "encryptkey", "0123456789123456").getBytes();
    }

    public static Long getMaxUploadSizeInBytes() {
        return Long.parseLong(getProperty(QUEESTICFENT_PROPERTY_BASE + "maxuploadsizeinbytes"));
    }

    public static Long getMaxFitxerAdaptatSizeInBytes() {
        return Long.parseLong(getProperty(QUEESTICFENT_PROPERTY_BASE + "maxfitxeradaptatsizeinbytes"));
    }

    public static Long getBasecampOrganizationID() {
        return Long.parseLong(getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.organizationID"));
    }
    
    
    
    public static Long getBasecampProjectID() {
        return Long.parseLong(getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.projectID"));
    }

    public static String getBasecampUrlBase() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.urlBase");
    }
    
    public static String getBasecampClientID() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.client_id");
    }
    
    public static String getBasecampClientSecret() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.client_secret");
    }

    public static String getBasecampRedirectUrl() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.redirect_uri");
    }
    
    public static String getBasecampTokenPropertiesFile() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "basecamp.token_properties_file");
    }
    

    public static File getFilesDirectory() {
        String path = getProperty(QUEESTICFENT_PROPERTY_BASE + "filesdirectory");
        if (path == null) {
            throw new RuntimeException("No existeix la propietat '" + QUEESTICFENT_PROPERTY_BASE + "filesdirectory'"
                    + " al fitxer " + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + ". S'hauria d'anar al fitxer " + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + " i incloure la propietat '" + QUEESTICFENT_PROPERTY_BASE
                    + "filesdirectory'" + " amb una ruta al directori on l'aplició gestionara els fitxers.");
        }

        if (path.isEmpty()) {
            throw new RuntimeException("No s'ha definit la propietat '" + QUEESTICFENT_PROPERTY_BASE + "filesdirectory'"
                    + " al fitxer " + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + ". S'hauria d'anar al fitxer " + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + " i donar valor a la propietat '" + QUEESTICFENT_PROPERTY_BASE +"filesdirectory'"
                    + " amb una ruta al directori on l'aplició gestionara els fitxers.");
        }
        
        File filesFolder = new File(path);
        
        if (!filesFolder.exists()) {
            throw new RuntimeException("El directori indicat a la propietat '" + QUEESTICFENT_PROPERTY_BASE
                    + ".filesdirectory'" + " del fitxer "
                    + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + " no existeix. S'hauria de modificar la ruta indicada per la d'un directori existent, o crear un directori amb la ruta: "
                    + path);
        }

        if (!filesFolder.isDirectory()) {
            throw new RuntimeException("El directori indicat a la propietat '" + QUEESTICFENT_PROPERTY_BASE
                    + ".filesdirectory'" + " del fitxer "
                    + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + " no es un directori, probablement es tracti d'un fitxer. S'hauria de modificar la ruta indicada per la d'un directori existent.");
        }

        if (!filesFolder.canWrite()) {
            throw new RuntimeException("El directori indicat a la propietat '" + QUEESTICFENT_PROPERTY_BASE
                    + ".filesdirectory'" + " del fitxer "
                    + System.getProperty(QUEESTICFENT_PROPERTY_BASE + "system.properties")
                    + " es un directori sense permisos d'escriptura. S'haurien de donar permisos d'escriptura al directori, o canviar la ruta a un directori amb permisos.");
        }
        return new File(path);

    }

    public static String getFileSystemManager() {
        return getProperty(QUEESTICFENT_PROPERTY_BASE + "filesystemmanagerclass");
    }

}
