package com.kirona.spring.jm.purchasingapi.cloudmarketplace;

import javax.annotation.PostConstruct;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.kirona.spring.cloudmarketplace.client.po.ApiClient;
import com.kirona.spring.jm.purchasingapi.model.GetOrderResponse;

import lombok.extern.slf4j.Slf4j;

// this is 'glue' (between the
// probably created by dev ?
@Slf4j
@Component
public class JMPurchasingRoutes extends RouteBuilder {

  @Autowired
  ApiClient cmApi;
  
  @Autowired
  Environment springEnv;
  
  @PostConstruct
  public void setCMApiUrl() {
    log.info("Setting CM API Base URL to : " + springEnv.getProperty("com.kirona.spring.cloudmarketplace.client.hosturl") + "/purchase-orders");
    cmApi.setBasePath(springEnv.getProperty("com.kirona.spring.cloudmarketplace.client.hosturl") + "/purchase-orders");
  }
  
  @Override
  public void configure() throws Exception {
    
//    // get requisition
//    from("direct:jm.purchasing.getRequisition")
//      .tracing()
//      .transform().constant( // dummy data response - we would go off to some service to get the requisition from CM, then transform it
//            "{ "
//          + " \"requisitionId\": \"string\", "
//          + " \"status\": \"submitted\", "
//          + " \"orders\": ["
//          + "  {"
//          + "   \"orderId\": \"string\""
//          + "  }"
//          + " ]"
//          + "}") 
//      .unmarshal().json(GetRequisitionResponse.class); // we need to return an object of this class
    
    // get (purchase order) details
    // VIA the open-api bean (raw JSON)
//    from("direct:jm.purchasing.getOrder")
//      .tracing()
//      .log("${header.orderId}")
//      .toD("cmPurchaseOrdersApi:detailUsingGET?purchaseOrderId=${header.orderId}")     // request details from CM
//      .to("jslt:com/kirona/spring/jm/purchasingapi/cloudmarketplace/getOrder.jslt")    // transform to JM format
//      .unmarshal().json(GetOrderResponse.class);
    
    // get (purchase) order details
    // via the Swagger generated code (model objects) 
    from("direct:jm.purchasing.getOrder")
      .tracing()
      .process("processor.systemAndOrg")
      .process("cm.processor.getOrder")       // this is a Spring bean name
      .convertBodyTo(GetOrderResponse.class); // relies on a custom converter strategy (see CMtoJMConverters.class)
    
    // tell camel how to transform CM model to JM model
    getContext().getTypeConverterRegistry()
      .addTypeConverters(new CMtoJMConverters());
  }
  

}
