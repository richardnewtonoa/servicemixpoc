package com.kirona.spring.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("com.kirona.spring.processors.LogMessage")
public class LogMessage implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    Message m = exchange.getMessage();
    if (m != null) {
      log.info(" Message Body = " + m.getBody());
    }
  }

}
