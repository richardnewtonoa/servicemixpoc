package com.kirona.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestJmsListener {

  @JmsListener(destination = "testreply")
  public void testResponse(Message message) {
    log.info("Received reply : " + message);
    try {
      log.info(" body = " + message.getBody(String.class));
    }
    catch (Throwable e) {
      log.error("Unable to extract body as a string", e);
    }
  }
  
  @JmsListener(destination = "callopenapiresult")
  public void callOpenApiResult(@Payload String payload) {
    log.info("Received reply : " + payload);
//    try {
//      log.info(" text = " + message.getStringProperty("text"));
//    }
//    catch (Throwable e) {
//      log.error("Unable to extract body as a string", e);
//    }
  }
}
