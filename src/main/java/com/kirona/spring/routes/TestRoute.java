package com.kirona.spring.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("activemq:testroute")
      .log("Received Test Message")
      .process("com.kirona.spring.processors.LogMessage") // bean name
      .description("Test Route")
      .autoStartup(true);
  }

}
