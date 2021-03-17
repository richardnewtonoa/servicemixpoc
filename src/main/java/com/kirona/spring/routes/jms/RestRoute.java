package com.kirona.spring.routes.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.kirona.spring.model.GetRequisitionRequest;

// receive a JMS message, forward to a rest api, and return the response
//@Component
public class RestRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("activemq:restroute")
      .log("Received Request")
      .autoStartup(true)
      .unmarshal().json(GetRequisitionRequest.class)
      .to("jmPurchasingApi:getRequisition?system=test&organisationId=org1&requisitionId=r2")
      .convertBodyTo(String.class)
      .process("com.kirona.spring.processors.LogMessage")
      .to("activemq:testreply");
  }

}
