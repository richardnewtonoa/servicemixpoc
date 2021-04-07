package com.kirona.spring.routes.internal;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class CallOpenApiClient extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("direct:callopenapi")
      .log("Received Request")
      .tracing()
      .setProperty("system").simple("${body.system}")
      .setProperty("organisationId").simple("${body.organisationId}")
      .setBody().constant(null)
      .to(ExchangePattern.InOut, "jmPurchasingApi:stockEnquiry?system=${exchangeProperty.system}&organisationId=${exchangeProperty.organisationId}")
      .convertBodyTo(String.class)
      .to("direct:callopenapiresult");
  }

}
