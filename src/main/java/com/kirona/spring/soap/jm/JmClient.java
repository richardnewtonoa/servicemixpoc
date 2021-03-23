package com.kirona.spring.soap.jm;

import com.kirona.kironadata.data.model.SetRefCodesRequest;

// API to make it easier to access JM WS from Camel routes, etc
public interface JmClient {

  public void setRefCodes(SetRefCodesRequest domain, String orgCode) throws Exception; 
}
