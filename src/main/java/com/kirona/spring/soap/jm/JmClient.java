package com.kirona.spring.soap.jm;

import com.kirona.kironadata.data.model.SetRefCodesRequest;
import com.kirona.schemas.jobmanager.jm.model.CreateJobRequest;
import com.kirona.schemas.jobmanager.jm.model.CreateJobResponse;
import com.kirona.schemas.jobmanager.jm.model.GetJobResponse;

// API to make it easier to access JM WS from Camel routes, etc
public interface JmClient {

  public void setRefCodes(SetRefCodesRequest domain, String orgCode) throws Exception; 
  
  public GetJobResponse getJob(Long jobId, String orgCode) throws Exception; 
  
  public CreateJobResponse createJob(CreateJobRequest createJob, String orgCode) throws Exception;
}
