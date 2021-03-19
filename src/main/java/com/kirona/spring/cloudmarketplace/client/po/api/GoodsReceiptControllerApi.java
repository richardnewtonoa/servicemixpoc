package com.kirona.spring.cloudmarketplace.client.po.api;

import com.kirona.spring.cloudmarketplace.client.po.ApiClient;

import com.kirona.spring.cloudmarketplace.client.po.model.GoodsReceipt;

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
@Component("com.kirona.spring.cloudmarketplace.client.po.api.GoodsReceiptControllerApi")
public class GoodsReceiptControllerApi {
    private ApiClient apiClient;

    public GoodsReceiptControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public GoodsReceiptControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Find a list of goods receipts for the given purchase order ID
     * 
     * <p><b>200</b> - OK
     * @param authorization  (required)
     * @param purchaseOrderId purchaseOrderId (required)
     * @return List&lt;GoodsReceipt&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<GoodsReceipt> getPurchaseOrderReceiptsUsingGET(String authorization, Long purchaseOrderId) throws RestClientException {
        return getPurchaseOrderReceiptsUsingGETWithHttpInfo(authorization, purchaseOrderId).getBody();
    }

    /**
     * Find a list of goods receipts for the given purchase order ID
     * 
     * <p><b>200</b> - OK
     * @param authorization  (required)
     * @param purchaseOrderId purchaseOrderId (required)
     * @return ResponseEntity&lt;List&lt;GoodsReceipt&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<GoodsReceipt>> getPurchaseOrderReceiptsUsingGETWithHttpInfo(String authorization, Long purchaseOrderId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getPurchaseOrderReceiptsUsingGET");
        }
        
        // verify the required parameter 'purchaseOrderId' is set
        if (purchaseOrderId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'purchaseOrderId' when calling getPurchaseOrderReceiptsUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("purchaseOrderId", purchaseOrderId);
        String path = apiClient.expandPath("/api/purchase-orders/goods-receipts/{purchaseOrderId}", uriVariables);

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

        ParameterizedTypeReference<List<GoodsReceipt>> returnType = new ParameterizedTypeReference<List<GoodsReceipt>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, contentType, authNames, returnType);
    }
}
