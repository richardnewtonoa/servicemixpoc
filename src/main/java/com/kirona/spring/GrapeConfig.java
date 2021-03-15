package com.kirona.spring;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.stereotype.Component;

import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GrapeConfig implements CamelContextConfiguration {
  
  @Override
  public void beforeApplicationStart(CamelContext camelContext) {
    log.info("Configuring Camel Context for Grape : " + camelContext);
    camelContext.setApplicationContextClassLoader(new GroovyClassLoader(camelContext.getApplicationContextClassLoader()));
  }

  @Override
  public void afterApplicationStart(CamelContext camelContext) {
  }
}
