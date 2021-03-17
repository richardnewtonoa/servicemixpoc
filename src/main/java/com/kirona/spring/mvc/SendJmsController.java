package com.kirona.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirona.spring.model.GetRequisitionRequest;
import com.kirona.spring.model.MessageBean;
import com.kirona.spring.model.SystemAndOrg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("jms")
public class SendJmsController {

  @Autowired
  JmsTemplate jms;
  
  @GetMapping(path = "callopenapi")
  public String callopenapi() {
    log.info("callopenapi Called");
    
    SystemAndOrg s = new SystemAndOrg();
    s.setOrganisationId("org1");
    s.setSystem("system1");
    
    try {
      jms.convertAndSend("callopenapi", s);
    }
    catch (Exception e) {
      log.error("Error Sending JMS Message", e);
      return "ERROR";
    }
    
    return "SENT";
  }
  
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
  
  @GetMapping(path = "rest")
  public String testGetRequisition() {
    log.info("Test Called");
    
    GetRequisitionRequest r = new GetRequisitionRequest();
    r.setOrganisationId("org1");
    r.setRequisitionId("r1234");
    r.setSystem("system1");
    
    try {
      jms.convertAndSend("restroute", r);
    }
    catch (Exception e) {
      log.error("Error Sending JMS Message", e);
      return "ERROR";
    }
    
    return "SENT";
  }  
}
