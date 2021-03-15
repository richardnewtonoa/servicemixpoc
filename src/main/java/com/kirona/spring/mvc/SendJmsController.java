package com.kirona.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("jms")
public class SendJmsController {

  @Getter
  @Setter
  public static class MessageBean {
    private String string1;
    private Long long1;
    private Boolean bool1;
  }
  
  @Autowired
  JmsTemplate jms;
  
  @GetMapping(path = "test")
  public String test() {
    log.info("Test Called");
    
    MessageBean b = new MessageBean();
    b.setBool1(Boolean.TRUE);
    b.setLong1(123l);
    b.setString1("TestString");
    
    try {
      jms.convertAndSend("testroute", b);
    }
    catch (Exception e) {
      log.error("Error Sending JMS Message", e);
      return "ERROR";
    }
    
    return "SENT";
  }
}
