package org.fundaciobit.queesticfent.apiexterna.client.api;

import org.fundaciobit.queesticfent.apiexterna.client.services.ApiException;
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiClient;
import org.fundaciobit.queesticfent.apiexterna.client.services.Configuration;
import org.fundaciobit.queesticfent.apiexterna.client.services.Pair;

import javax.ws.rs.core.GenericType;

import org.fundaciobit.queesticfent.apiexterna.client.model.Modificacio;
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
   * @param modificacio  (required)
   * @return a {@code Long}
   * @throws ApiException if fails to make API call
   */
  public Long add(Modificacio modificacio) throws ApiException {
    Object localVarPostBody = modificacio;
    
    // verify the required parameter 'modificacio' is set
    if (modificacio == null) {
      throw new ApiException(400, "Missing the required parameter 'modificacio' when calling add");
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
}
