package com.kirona.spring.routes.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Purchasing extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    // https://camel.apache.org/components/3.7.x/rest-component.html
//    from("rest:get:purchasing:/{system}/{organisationId}/requisition/{requisitionId}")
//      .tracing()
//      .autoStartup(true)
//      .to("log:com.kirona.spring.routes.rest.GetRequisition?level=DEBUG")
//      .to 

    // https://camel.apache.org/manual/latest/rest-dsl.html
    
    rest()
      .get("/test")
        .produces("text/plain")
        .route()
          .log("Received Test")
          .tracing()
          .transform().constant("test")
        .endRest();
        
    rest("/say/hello")
      .get()
        .produces("text/plain")
        .route()
          .transform().constant("Hello World");
    
    // define rest end point
    rest("/purchasing")
      .produces("application/json")
      .get("/{system}/{organisationId}/requisition/{requisitionId}")
        .route()
        .tracing()
        .to("direct:getRequisition")
        .endRest()
      .get("/{system}/{organisationId}/order/{orderId}")
        .route()
        .tracing()
        .to("direct:getOrder")
        .endRest();
    
    // get requisition process
    from("direct:getRequisition")
      .tracing()
      .log("Received getRequisition Request")
      .transform().simple("{ 'requisitionId' : '${header.requisitionId}' }");

    // get order process
    from("direct:getOrder")
      .tracing()
      .log("Received getOrder Request")
      .transform().simple("{ 'orderId' : '${header.orderId}' }");    
  }
}
