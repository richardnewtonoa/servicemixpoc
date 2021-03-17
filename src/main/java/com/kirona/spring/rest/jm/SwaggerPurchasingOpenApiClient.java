package com.kirona.spring.rest.jm;

import java.net.URI;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.component.rest.openapi.RestOpenApiComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SwaggerPurchasingOpenApiClient {

  // https://camel.apache.org/components/latest/rest-openapi-component.html
  
  @Bean
  public Component jmPurchasingApi(CamelContext camelContext, @Value(value = "${com.kirona.spring.rest.jm.purchasingapi.swaggerurl}") String url) {
    log.info("Creating RestOpenApiComponent with URL : " + url);
    RestOpenApiComponent api = new RestOpenApiComponent(camelContext);
    api.setComponentName("netty-http");
    api.setSpecificationUri(URI.create(url));
    api.setConsumes("application/json");
    api.setProduces("application/json");
    return api;
  }
  
}
