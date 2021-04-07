package com.kirona.spring.soap.jm;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.kirona.kironadata.data.model.SetRefCodesRequest;
import com.kirona.kironadata.data.model.StandardResponseType;
import com.kirona.schemas.jobmanager.jm.model.CreateJobRequest;
import com.kirona.schemas.jobmanager.jm.model.CreateJobResponse;
import com.kirona.schemas.jobmanager.jm.model.GetJobRequest;
import com.kirona.schemas.jobmanager.jm.model.GetJobResponse;
import com.kirona.standalone.jm.wsclient.IJmClientCallback;
import com.kirona.standalone.jm.wsclient.IJmClientTemplate;
import com.kirona.standalone.jm.wsclient.JobManagerClientProxy;

import lombok.extern.slf4j.Slf4j;

// set up WS client for JM using the stand alone client artifact
@Slf4j
@Configuration
@ComponentScan("com.kirona.standalone.jm.wsclient")
public class WebservicesClientConfig {

  @Autowired
  IJmClientTemplate jmTemplate;

  @Autowired
  Environment springEnv;
  
  @PostConstruct
  public void logEnv() {
    log.info("endpoint : " + springEnv.getProperty("webservice.jobmanager.endpoint.url"));
    log.info("username : " + springEnv.getProperty("webservice.jobmanager.username.encrypted"));
    log.info("password : " + springEnv.getProperty("webservice.jobmanager.password.encrypted"));
  }
  
  @Bean("jmWebServicesClient")
  public JmClient getJmClient() {
    return new JmClient() {

      @Override
      public void setRefCodes(final SetRefCodesRequest domain, final String orgCode) throws Exception {
        if (domain == null) { return; }
        
        log.info("Sending refcodes to JM orgCode : " + orgCode + ", domain : " + domain.getRefCodesDomain());
        
        final StandardResponseType response = jmTemplate.doWithJobManagerClient(orgCode, new IJmClientCallback<StandardResponseType>() {
          @Override
          public StandardResponseType doJmClientCallback(JobManagerClientProxy proxy) {
            return proxy.getData().setRefCodes(domain);
          }
        });
        
        if (!isSuccess(response)) {
          throw new Exception("Non SUCCESS response");
        }
        
        log.info("Successfully set domain : " + domain.getRefCodesDomain());
      }

      private boolean isSuccess(StandardResponseType response) {
        return (response != null) && ("SUCCESS".equals(response.getResult()));
      }

      @Override
      public GetJobResponse getJob(final Long jobId, final String orgCode) throws Exception {
        log.info("Getting job for org code : " + jobId + " / " + orgCode);
        
        final GetJobResponse response = jmTemplate.doWithJobManagerClient(orgCode, new IJmClientCallback<GetJobResponse>() {
          @Override
          public GetJobResponse doJmClientCallback(JobManagerClientProxy proxy) {
            GetJobRequest getJobRequest = new GetJobRequest();
            getJobRequest.setJobId(jobId);
            return proxy.getJobManager().getJob(getJobRequest);
          }
        });
        
        if (response == null) {
          throw new Exception("Job not found");
        }
        
        return response;
      }

      @Override
      public CreateJobResponse createJob(CreateJobRequest createJob, String orgCode) throws Exception {
        log.info("Creating a job : " + createJob.getJobTypeCode() + " / " + orgCode);
        
        final CreateJobResponse response = jmTemplate.doWithJobManagerClient(orgCode, new IJmClientCallback<CreateJobResponse>() {
          @Override
          public CreateJobResponse doJmClientCallback(JobManagerClientProxy proxy) {
            return proxy.getJobManager().createJob(createJob);
          }
        });
        
        if (response == null) {
          throw new Exception("Job not created");
        }
        
        return response;
      }
      
    };

  }
}
