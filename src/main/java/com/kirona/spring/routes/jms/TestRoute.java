package com.kirona.spring.routes.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.kirona.spring.model.MessageBean;
import com.kirona.spring.model.ReplyBean;
import com.kirona.spring.transformers.TestTransformer;

@Component
public class TestRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("activemq:testroute")
      .log("Received Test Message")
//      .process("com.kirona.spring.processors.LogMessage") // bean name
      .description("Test Route")
      .autoStartup(true)
      .unmarshal().json(MessageBean.class)
      .bean(TestTransformer.class, "testRouteReply") // transform to output
      .outputType(ReplyBean.class)
//      .process("com.kirona.spring.processors.LogMessage") // bean name
      .marshal("json-jackson")                            // convert to JSON
      .process("com.kirona.spring.processors.LogMessage") // bean name
      .to("activemq:testreply")
      ;
  }

}
