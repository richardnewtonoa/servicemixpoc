package com.kirona.spring.routes.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

// generally applicable configuration for all rest endpoints
@Slf4j
@Configuration
public class EndpointConfig extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    log.info("Configuring REST endpoint on port 8081");
    
    restConfiguration()
      .component("netty-http")
      .host("localhost")
      .port(8081);
  }

}
