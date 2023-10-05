# ModificacionsApi

All URIs are relative to */queesticfentapi/externa*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**add**](ModificacionsApi.md#add) | **POST** /secure/modificacions/add | Afegeix una nova entrada |



## add

> Long add(modificacio)

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
        Modificacio modificacio = new Modificacio(); // Modificacio | 
        try {
            Long result = apiInstance.add(modificacio);
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
| **modificacio** | [**Modificacio**](Modificacio.md)|  | |

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

