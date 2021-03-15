package com.kirona.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

  @Bean
  public MessageConverter messageConverter() {
    MappingJackson2MessageConverter mc = new MappingJackson2MessageConverter();
    mc.setTargetType(MessageType.TEXT);
    return mc;
  }
}
