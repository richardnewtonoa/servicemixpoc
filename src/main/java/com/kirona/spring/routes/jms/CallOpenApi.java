package com.kirona.spring.routes.jms;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

import com.kirona.spring.model.SystemAndOrg;

// accept a JMS message, convert pay load JSON into a SystemAndOrg bean
// forward to the internal route to call a REST API
@Configuration
public class CallOpenApi extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("activemq:callopenapi")
      .setExchangePattern(ExchangePattern.InOnly)    
      .tracing()
      .unmarshal().json(SystemAndOrg.class)
      .to("direct:callopenapi");
    
    from("direct:callopenapiresult")
      .setExchangePattern(ExchangePattern.InOnly)
      .tracing()
      .transform().simple("{ \"system\": \"${exchangeProperty.system}\", \"organisationId\" : \"${exchangeProperty.organisationId}\" }")
      .setHeader("jacksonPayloadType").constant(SystemAndOrg.class.getName())
      .to("activemq:callopenapiresult");    
  }

}
