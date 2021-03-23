package com.kirona.spring.soap.jm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.kirona.kironadata.data.model.SetRefCodesRequest;
import com.kirona.kironadata.data.model.StandardResponseType;
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
      
    };

  }
}
