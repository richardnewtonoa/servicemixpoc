package com.kirona.spring.cloudmarketplace.client;

import java.net.URI;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.component.rest.swagger.RestSwaggerComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

// definition of the rest client calls we can make to CM around POs
@Slf4j
@Configuration
public class PurchaseOrdersClientRest {

  // https://camel.apache.org/components/latest/rest-openapi-component.html
  
  @Bean
  public Component cmPurchaseOrdersApi(
      CamelContext camelContext
      , @Value(value = "${com.kirona.spring.cloudmarketplace.client.swaggerurl}") String swaggerUrl
      , @Value(value = "${com.kirona.spring.cloudmarketplace.client.hosturl}") String host) 
  {
    log.info("Creating RestOpenApiComponent with Swagger URL : " + swaggerUrl + " , Host URL : " + host);
    RestSwaggerComponent api = new RestSwaggerComponent (camelContext);
    api.setComponentName("netty-http");
    api.setSpecificationUri(URI.create(swaggerUrl));
    api.setHost(host);
    api.setConsumes("application/json");
    api.setProduces("application/json");
    return api;
  }
}
