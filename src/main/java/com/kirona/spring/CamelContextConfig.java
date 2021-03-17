package com.kirona.spring;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.NoTypeConversionAvailableException;
import org.apache.camel.TypeConversionException;
import org.apache.camel.TypeConverter;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.stereotype.Component;

import com.kirona.spring.model.ReplyBean;

import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CamelContextConfig implements CamelContextConfiguration {
  
  @Override
  public void beforeApplicationStart(CamelContext camelContext) {
    log.info("Configuring Camel Context for Grape : " + camelContext);
    camelContext.setApplicationContextClassLoader(new GroovyClassLoader(camelContext.getApplicationContextClassLoader()));
  }

  @Override
  public void afterApplicationStart(CamelContext camelContext) {
  }
}
