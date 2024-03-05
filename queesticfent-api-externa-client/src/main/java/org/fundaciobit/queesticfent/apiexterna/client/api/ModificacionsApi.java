package org.fundaciobit.queesticfent.apiexterna.client.api;

import org.fundaciobit.queesticfent.apiexterna.client.services.ApiException;
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiClient;
import org.fundaciobit.queesticfent.apiexterna.client.services.Configuration;
import org.fundaciobit.queesticfent.apiexterna.client.services.Pair;

import javax.ws.rs.core.GenericType;

import org.fundaciobit.queesticfent.apiexterna.client.model.AddModificacioRequest;
import org.fundaciobit.queesticfent.apiexterna.client.model.GetModificacionsResponse;
import org.fundaciobit.queesticfent.apiexterna.client.model.ModificacionsConstants;
import org.fundaciobit.queesticfent.apiexterna.client.model.RestExceptionInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ModificacionsApi {
  private ApiClient apiClient;

  public ModificacionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ModificacionsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Afegeix una nova entrada
   * 
   * @param addModificacioRequest  (required)
   * @return a {@code Long}
   * @throws ApiException if fails to make API call
   */
  public Long add(AddModificacioRequest addModificacioRequest) throws ApiException {
    Object localVarPostBody = addModificacioRequest;
    
    // verify the required parameter 'addModificacioRequest' is set
    if (addModificacioRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'addModificacioRequest' when calling add");
    }
    
    // create path and map variables
    String localVarPath = "/secure/modificacions/add".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<Long> localVarReturnType = new GenericType<Long>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna les modificacions segons a un rang de temps. Permet filtrar per usuaris
   * 
   * @param usuariID Identificador de l&#39;usuari (required)
   * @param date Filtre Data de la consulta. Format yyyy-MM-dd (ISO 8601) (required)
   * @param language Idioma en que s&#39;han de retornar les dades(Només suportat &#39;ca&#39; o &#39;es&#39;) (optional, default to ca)
   * @return a {@code GetModificacionsResponse}
   * @throws ApiException if fails to make API call
   */
  public GetModificacionsResponse getmodificacions(String usuariID, String date, String language) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'usuariID' is set
    if (usuariID == null) {
      throw new ApiException(400, "Missing the required parameter 'usuariID' when calling getmodificacions");
    }
    
    // verify the required parameter 'date' is set
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling getmodificacions");
    }
    
    // create path and map variables
    String localVarPath = "/secure/modificacions/getmodificacions".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "usuariID", usuariID));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "date", date));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<GetModificacionsResponse> localVarReturnType = new GenericType<GetModificacionsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
