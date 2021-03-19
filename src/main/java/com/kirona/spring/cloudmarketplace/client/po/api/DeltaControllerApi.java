package com.kirona.spring.cloudmarketplace.client.po.api;

import com.kirona.spring.cloudmarketplace.client.po.ApiClient;

import com.kirona.spring.cloudmarketplace.client.po.model.Delta;
import java.time.OffsetDateTime;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-19T13:44:41.473Z[Europe/London]")
@Component("com.kirona.spring.cloudmarketplace.client.po.api.DeltaControllerApi")
public class DeltaControllerApi {
    private ApiClient apiClient;

    public DeltaControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public DeltaControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Finds all purchase order changes based on the event type and can be filtered by date
     * 
     * <p><b>200</b> - OK
     * @param authorization  (required)
     * @param eventType eventType (optional)
     * @param timestamp timestamp (optional)
     * @return List&lt;Integer&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Integer> findDeltasUsingGET(String authorization, String eventType, OffsetDateTime timestamp) throws RestClientException {
        return findDeltasUsingGETWithHttpInfo(authorization, eventType, timestamp).getBody();
    }

    /**
     * Finds all purchase order changes based on the event type and can be filtered by date
     * 
     * <p><b>200</b> - OK
     * @param authorization  (required)
     * @param eventType eventType (optional)
     * @param timestamp timestamp (optional)
     * @return ResponseEntity&lt;List&lt;Integer&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Integer>> findDeltasUsingGETWithHttpInfo(String authorization, String eventType, OffsetDateTime timestamp) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling findDeltasUsingGET");
        }
        
        String path = apiClient.expandPath("/api/purchase-orders/deltas", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "eventType", eventType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "timestamp", timestamp));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Integer>> returnType = new ParameterizedTypeReference<List<Integer>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, contentType, authNames, returnType);
    }
    /**
     * Finds changes for a single purchase order using the given purchase order ID
     * 
     * <p><b>200</b> - OK
     * @param authorization  (required)
     * @param id id (required)
     * @return List&lt;Delta&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Delta> findPurchaseOrderDeltasUsingGET(String authorization, Long id) throws RestClientException {
        return findPurchaseOrderDeltasUsingGETWithHttpInfo(authorization, id).getBody();
    }

    /**
     * Finds changes for a single purchase order using the given purchase order ID
     * 
     * <p><b>200</b> - OK
     * @param authorization  (required)
     * @param id id (required)
     * @return ResponseEntity&lt;List&lt;Delta&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Delta>> findPurchaseOrderDeltasUsingGETWithHttpInfo(String authorization, Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling findPurchaseOrderDeltasUsingGET");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling findPurchaseOrderDeltasUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = apiClient.expandPath("/api/purchase-orders/deltas/{id}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Delta>> returnType = new ParameterizedTypeReference<List<Delta>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, contentType, authNames, returnType);
    }
}
