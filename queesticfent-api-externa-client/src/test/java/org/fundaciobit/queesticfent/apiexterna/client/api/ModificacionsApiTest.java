/*
 * API REST EXTERNA de queesticfent
 * Conjunt de Serveis REST de queesticfent per ser accedits des de l'exterior
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.fundaciobit.queesticfent.apiexterna.client.api;

import org.fundaciobit.queesticfent.apiexterna.client.services.ApiClient;
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiException;
import org.fundaciobit.queesticfent.apiexterna.client.services.auth.HttpBasicAuth;
import org.fundaciobit.queesticfent.apiexterna.client.model.AddModificacioRequest;
import org.fundaciobit.queesticfent.apiexterna.client.model.GetModificacionsResponse;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Properties;

/**
 * API tests for ModificacionsApi
 */
public class ModificacionsApiTest {
    
    
    
    
    public static void main(String[] args) throws ApiException, ParseException {
        
        ModificacionsApiTest apiTest = new ModificacionsApiTest();
        
        apiTest.getModificacionsTest();
        
    }
    
    
    public void getModificacionsTest() throws ApiException, ParseException {
        
        final ModificacionsApi api = getApi();
        
        //Modificar aquests valors per l'usuari de test de l'entorn.
        String usuariID="fbosch";
        String strData = "2024-03-05";
        //String strData = "05-03-2024";

        GetModificacionsResponse response = api.getmodificacions(usuariID, strData, "ca");
        
        System.out.println("Response = "+response);
        
        // TODO: test validations
    }

    /**
     * Afegeix una nova entrada
     *
     * @throws ApiException
     *          if the Api call fails
     */
    public void addTest() throws ApiException {
        
        final ModificacionsApi api = getApi();
        
        AddModificacioRequest modificacio = new AddModificacioRequest();
        modificacio.setUsuariID("fbosch");
        modificacio.setDada1("Dada 1 XXX");
        modificacio.setData(OffsetDateTime.now());
        modificacio.setLanguage("ca");
        modificacio.setProjecteID((long) 13);
        
        Long response = api.add(modificacio);
        
        System.out.println("Response = "+response);
        

        // TODO: test validations
    }
    
    
    private ModificacionsApi getApi() {
        
        Properties props = getProperties();
        
        String host = props.getProperty("host");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        ApiClient client = new ApiClient();
        client.setBasePath(host);
        client.setUsername(username);
        client.setPassword(password);
        
        HttpBasicAuth basicAuth = (HttpBasicAuth) client.getAuthentication("BasicAuth");
        basicAuth.setUsername(username);
        basicAuth.setPassword(password);

        ModificacionsApi api = new ModificacionsApi(client);

        return api;

    }
    
    protected Properties getProperties() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("test.properties")));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return props;
    }
    
}
