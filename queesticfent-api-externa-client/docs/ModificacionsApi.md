# ModificacionsApi

All URIs are relative to */queesticfentapi/externa*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**add**](ModificacionsApi.md#add) | **POST** /secure/modificacions/add | Afegeix una nova entrada |
| [**getmodificacions**](ModificacionsApi.md#getmodificacions) | **POST** /secure/modificacions/getmodificacions | Retorna les modificacions segons a un rang de temps. Permet filtrar per usuaris |



## add

> Long add(addModificacioRequest)

Afegeix una nova entrada

### Example

```java
// Import classes:
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiClient;
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiException;
import org.fundaciobit.queesticfent.apiexterna.client.services.Configuration;
import org.fundaciobit.queesticfent.apiexterna.client.services.auth.*;
import org.fundaciobit.queesticfent.apiexterna.client.services.models.*;
import org.fundaciobit.queesticfent.apiexterna.client.api.ModificacionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/queesticfentapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ModificacionsApi apiInstance = new ModificacionsApi(defaultClient);
        AddModificacioRequest addModificacioRequest = new AddModificacioRequest(); // AddModificacioRequest | 
        try {
            Long result = apiInstance.add(addModificacioRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ModificacionsApi#add");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **addModificacioRequest** | [**AddModificacioRequest**](AddModificacioRequest.md)|  | |

### Return type

**Long**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació finalitzada correctament |  -  |
| **400** | EFIB: Paràmetres incorrectes |  -  |
| **401** | EFIB: No Autenticat |  -  |
| **403** | EFIB: No Autoritzat |  -  |
| **500** | EFIB: Error durant la consulta de les dades obertes |  -  |
| **510** | Només s&#39;utilitza per crear fitxer de constants... |  -  |


## getmodificacions

> GetModificacionsResponse getmodificacions(usuariID, date, language)

Retorna les modificacions segons a un rang de temps. Permet filtrar per usuaris

### Example

```java
// Import classes:
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiClient;
import org.fundaciobit.queesticfent.apiexterna.client.services.ApiException;
import org.fundaciobit.queesticfent.apiexterna.client.services.Configuration;
import org.fundaciobit.queesticfent.apiexterna.client.services.auth.*;
import org.fundaciobit.queesticfent.apiexterna.client.services.models.*;
import org.fundaciobit.queesticfent.apiexterna.client.api.ModificacionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/queesticfentapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ModificacionsApi apiInstance = new ModificacionsApi(defaultClient);
        String usuariID = "jgarcia"; // String | Identificador de l'usuari
        String date = "2023-07-19"; // String | Filtre Data de la consulta. Format yyyy-MM-dd (ISO 8601)
        String language = "ca"; // String | Idioma en que s'han de retornar les dades(Només suportat 'ca' o 'es')
        try {
            GetModificacionsResponse result = apiInstance.getmodificacions(usuariID, date, language);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ModificacionsApi#getmodificacions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **usuariID** | **String**| Identificador de l&#39;usuari | |
| **date** | **String**| Filtre Data de la consulta. Format yyyy-MM-dd (ISO 8601) | |
| **language** | **String**| Idioma en que s&#39;han de retornar les dades(Només suportat &#39;ca&#39; o &#39;es&#39;) | [optional] [default to ca] |

### Return type

[**GetModificacionsResponse**](GetModificacionsResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació finalitzada correctament |  -  |
| **400** | QEFI: Paràmetres incorrectes |  -  |
| **401** | QEFI: No Autenticat |  -  |
| **403** | QEFI: No Autoritzat |  -  |
| **500** | QEFI: Error durant la consulta de les dades obertes |  -  |
| **510** | Només s&#39;utilitza per crear fitxer de constants... |  -  |

