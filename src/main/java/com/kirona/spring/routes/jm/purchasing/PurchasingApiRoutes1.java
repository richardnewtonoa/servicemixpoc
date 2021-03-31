package com.kirona.spring.routes.jm.purchasing;

import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionResponse;
import com.kirona.spring.rest.jm.AbstractJMPurchasingApiRouteBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PurchasingApiRoutes1 extends AbstractJMPurchasingApiRouteBuilder {

  @Override
  protected void preConfigure() {
    setTracingEnabled(true);
    setPath("/jm/purchasing1");
    setRoutePrefix("direct:purchasing1.");
  }

  
  @Override
  protected void postConfigure() {
    from(getSubmitRequisitionRoute())
      .tracing()
      .process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
          SubmitRequisitionResponse resp = new SubmitRequisitionResponse();
          resp.setRequisitionId(UUID.randomUUID().toString());
          log.info(" returning requisition ID : " + resp.getRequisitionId());
          exchange.getMessage().setBody(resp);
        }
      });
  }
}
