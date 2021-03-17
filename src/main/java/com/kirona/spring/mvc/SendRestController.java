package com.kirona.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("rest")
public class SendRestController {

  @Autowired
  RestOperations rest;
  
  String urlBase = "http://localhost:8081/purchasing";
  
  @GetMapping("requisition")
  public void testRequisition() {
    log.info("Sending REST request to getRequisition");
    ResponseEntity<String> response = rest.getForEntity(urlBase+"/{system}/{organisationId}/requisition/{requisitionId}", String.class, "system1", "org1", "req1");
    log.info("RESPONSE = " + response);
  }
}
