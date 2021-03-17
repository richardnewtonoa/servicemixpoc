package com.kirona.spring.routes.jms;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
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
//      .transform().simple("{ \"system\": \"${exchangeProperty.system}\", \"organisationId\" : \"${exchangeProperty.organisationId}\" }")
      // https://camel.apache.org/components/3.4.x/mustache-component.html
      // mustache cannot (by default) access the exchange properties
      // so we need this app property setting : camel.component.mustache.allow-context-map-all=true
      // NOTE : does not work with JSON (String) body content - you would need a Java model
//      .to("mustache:bean:callOpenApiTemplates.mustacheResult")
      // https://camel.apache.org/components/3.4.x/jslt-component.html
      // we need to use allowContextMapAll to access exchange properties
      //.to("jslt:bean:callOpenApiTemplates.jsltResult?allowContextMapAll=true") // does NOT work !
      .to("jslt:com/kirona/spring/routes/jms/result.jslt?allowContextMapAll=true") //works
      //.to("jslt:classpath:com/kirona/spring/routes/jms/result.jslt?allowContextMapAll=true") // does NOT work !
      .setHeader("jacksonPayloadType").constant(SystemAndOrg.class.getName())
      .to("activemq:callopenapiresult");    
  }

  
  // a bean containing the templates referenced in our routes
  // these could be on the class path, but this is an easy option for a POC
  public static interface CallOpenApiTemplates {
    public String mustacheResult();
    public String jsltResult();
  }
  
  @Bean("callOpenApiTemplates")
  public CallOpenApiTemplates templates() {
    return new CallOpenApiTemplates() {
      @Override
      public String mustacheResult() {
        return "{ \"system\": \"{{exchange.properties.system}}\", \"organisationId\": \"{{exchange.properties.organisationId}}\", \"stockCodes\": [ {{#body.supplierStockItem}} { \"stockCode\": \"{{extSupplierPartCode}}\", \"delivery\": {{deliveryCharge}} } {{/body.supplierStockItem}} ] }";
      }

      @Override
      public String jsltResult() {
        return "{ \"system\": .exchange.properties.system, \"organisationId\": .exchange.properties.organisationId }";
      }
    };
  }
}
