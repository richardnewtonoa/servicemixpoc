package com.kirona.spring.jm.purchasingapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.kirona.spring.jm.purchasingapi.api.SystemApiDelegate;
import com.kirona.spring.jm.purchasingapi.model.GetOrderResponse;
import com.kirona.spring.jm.purchasingapi.model.GetRequisitionResponse;
import com.kirona.spring.jm.purchasingapi.model.StockEnquiryResponse;
import com.kirona.spring.jm.purchasingapi.model.SubmitGRNRequest;
import com.kirona.spring.jm.purchasingapi.model.SubmitGRNResponse;
import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionRequest;
import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SystemApiCamelImpl implements SystemApiDelegate {

  @Autowired
  ProducerTemplate camel;
  
  @Override
  public ResponseEntity<GetOrderResponse> getOrder(String system, String organisationId, String orderId) {
    
    // TODO : validate params
    
    try {
      Map<String,Object> headers = new HashMap<>();
      headers.put("system", system);
      headers.put("organisationId", organisationId);
      headers.put("orderId", orderId);
      GetOrderResponse response = camel.requestBodyAndHeaders("direct:jm.purchasing.getOrder", null, headers, GetOrderResponse.class);
      if (response == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      else {
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
    }
    catch (Exception e) {
      log.error("Failed to process request", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<GetRequisitionResponse> getRequisition(String system, String organisationId, String requisitionId) {
    log.info("Received getRequisition request : " + system + ", " + organisationId + ", " + requisitionId);
    
    // TODO : validate params
    
    try {
      Map<String,Object> headers = new HashMap<>();
      headers.put("system", system);
      headers.put("organisationId", organisationId);
      headers.put("requisitionId", requisitionId);
      GetRequisitionResponse response = camel.requestBodyAndHeaders("direct:jm.purchasing.getRequisition", null, headers, GetRequisitionResponse.class);
      if (response == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      else {
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
    }
    catch (Exception e) {
      log.error("Failed to process request", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<StockEnquiryResponse> stockEnquiry(String system, String organisationId, String stockCode,
      String extSupplierId) {
    throw new UnsupportedOperationException("NOT IMPLEMENTED");
  }

  @Override
  public ResponseEntity<SubmitGRNResponse> submitGRN(String system, String organisationId, SubmitGRNRequest body) {
    throw new UnsupportedOperationException("NOT IMPLEMENTED");
  }

  @Override
  public ResponseEntity<SubmitRequisitionResponse> submitRequisition(String system, String organisationId,
      SubmitRequisitionRequest body) {
    log.info("Received submitRequisition request : " + system + ", " + organisationId + ", " + body);
    
    // TOD : validate params
    
    // direct to a well known route in camel - this is synchronous
    try {
      Map<String,Object> headers = new HashMap<>();
      headers.put("system", system);
      headers.put("organisationId", organisationId);
      SubmitRequisitionResponse result = camel.requestBodyAndHeaders("direct:jm.purchasing.submitRequisition", body, headers, SubmitRequisitionResponse.class);
      return new ResponseEntity<SubmitRequisitionResponse>(result, HttpStatus.OK);
    }
    catch (Exception e) {
      log.error("Failed to process request", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
