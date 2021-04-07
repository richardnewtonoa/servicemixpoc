package com.kirona.helpers.jm;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.kirona.schemas.jobmanager.jm.model.CreateJobRequest;
import com.kirona.schemas.jobmanager.jm.model.GetJobResponse;
import com.kirona.schemas.jobmanager.jm.model.JobCreateRelationType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractFollowOnProcessor implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    GetJobResponse job = exchange.getMessage().getBody(GetJobResponse.class);
    log.info("Creating follow on to job : " + job.getJobId());
    
    CreateJobRequest followOn = createFollowOn(job);
    
    followOn.getFixedAttributes().setParentId(job.getJobId());
    followOn.getFixedAttributes().setParentRelationType(JobCreateRelationType.FOLLOW_ON);
    
    exchange.getMessage().setBody(followOn, CreateJobRequest.class);
  }

  protected abstract CreateJobRequest createFollowOn(GetJobResponse job);

}
