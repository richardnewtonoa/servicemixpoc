package com.kirona.spring;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.fasterxml.jackson.databind.JavaType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class JmsConfig {

  @Bean
  public MessageConverter messageConverter() {
    final SimpleMessageConverter sc = new SimpleMessageConverter();
    
    final MappingJackson2MessageConverter mc = new MappingJackson2MessageConverter() {
      // if the message specifies a type, use that type
      // else convert using the simple converter
      @Override
      public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        try {
          final JavaType type = getJavaTypeForMessage(message);
          log.info("Using jacksonPayloadType = " + type);
        }
        catch (Throwable t) {
          log.info("Falling back to simple message conversion for : " + message);
          return sc.fromMessage(message);
        }
        return super.fromMessage(message);
      }      
    };
    mc.setTargetType(MessageType.TEXT);
    mc.setTypeIdPropertyName("jacksonPayloadType");
    return mc;
  }
}
