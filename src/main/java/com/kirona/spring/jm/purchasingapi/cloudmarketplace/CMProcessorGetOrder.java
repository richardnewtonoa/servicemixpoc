package com.kirona.spring.jm.purchasingapi.cloudmarketplace;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import com.kirona.spring.cloudmarketplace.client.po.api.PurchaseOrderDetailControllerApi;
import com.kirona.spring.cloudmarketplace.client.po.model.PurchaseOrder;
import com.kirona.spring.processors.SystemAndOrg;

import lombok.extern.slf4j.Slf4j;

// helper for the get purchase order details process
// extracts well known details from the exchange (system, organisationId, orderId)
// gets an auth token (probably per system+org)
// calls the REST API
// puts the result in the exchange
@Slf4j
@Component("cm.processor.getOrder")
public class CMProcessorGetOrder implements Processor {

  @Autowired
  PurchaseOrderDetailControllerApi api;
  
  @Autowired
  CMAuthentication auth;
  
  @Override
  public void process(Exchange exchange) throws Exception {
    final Message msg = exchange.getMessage();

    final String system = SystemAndOrg.getSystem(exchange);
    final String orgId = SystemAndOrg.getOrgansistionId(exchange);
    final String orderId = msg.getHeader("orderId", String.class);
    
    log.info("System = " + system + ", Org = " + orgId + ", Order = " + orderId);
    
    if ((system == null) || (orgId == null) || (orderId == null)) { throw new Exception("Missing parameters"); }
    final Long orderNum = Long.decode(orderId);
    
    final String authToken = auth.getAuthToken(system, orgId);
    log.info(" auth token = " + authToken);
    if (authToken == null) { throw new Exception("No auth token could be obtained"); }
    
    try {
      PurchaseOrder result = api.detailUsingGET(authToken, orderNum);
      exchange.getMessage().setBody(result, PurchaseOrder.class);
    }
    catch (HttpClientErrorException.NotFound nf) {
      log.info("PO not found :" + orderId);
      exchange.getMessage().setBody(null, PurchaseOrder.class);
    }
  }

}
