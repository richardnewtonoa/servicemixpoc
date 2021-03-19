package com.kirona.spring.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// takes any 'system' or 'organisationId' headers from the current message
// and copies them into exchange properties
// so we can access them in other places (to get config, etc, etc)
@Slf4j
@Component("processor.systemAndOrg")
public class SystemAndOrg implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    Message msg = exchange.getMessage();
    final String system = msg.getHeader("system", "default", String.class);
    final String orgId = msg.getHeader("organisationId", "default", String.class);
    log.info("Setting exchange properties for system / organisationId : " + system + " / " + orgId);
    exchange.setProperty("system", system);
    exchange.setProperty("organisationId", orgId);
  }

  public static String getSystem(Exchange exchange) {
    return exchange.getProperty("system", "default", String.class);
  }
  
  public static String getOrgansistionId(Exchange exchange) {
    return exchange.getProperty("organisationId", "default", String.class);
  }
}
