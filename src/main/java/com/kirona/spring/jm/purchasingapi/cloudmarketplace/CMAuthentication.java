package com.kirona.spring.jm.purchasingapi.cloudmarketplace;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// bean that can get / manage authentication tokens for CM
@Slf4j
@Component
public class CMAuthentication {

  public String getAuthToken(String system, String orgId) {
    log.warn("Returning static token for system / org : " + system + " / " + orgId);
    return "bearer 8081c76c-9ad3-4a08-88f3-0bf39a11e537";
    //return "bearer 162179b8-9bd2-4079-8ab9-1853d8543e9e";
  }
}
