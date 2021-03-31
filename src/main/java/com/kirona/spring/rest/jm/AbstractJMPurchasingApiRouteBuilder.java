package com.kirona.spring.rest.jm;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestDefinition;
import org.springframework.beans.factory.annotation.Autowired;

import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionRequest;
import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionResponse;
import com.kirona.spring.processors.SystemAndOrg;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class that you can use to configure the purchasing API rest endpoint.
 * 
 * This simply configures some routes for the rest component, with expected java model objects, etc, etc
 * 
 * Relies on generated models in com.kirona.spring.jm.purchasingapi.model
 * 
 * @author richard.newton
 *
 */
@Slf4j
public abstract class AbstractJMPurchasingApiRouteBuilder extends RouteBuilder {

  @Setter
  private String path = "/jm/purchasing";
  @Setter
  private String routePrefix = "direct:jmPurchasing.inbound.";
  @Setter
  private boolean submitRequisitionEnabled = true;
  @Setter
  private boolean tracingEnabled = false;
  
  @Autowired
  ProducerTemplate producer;
  
  protected final String getSubmitRequisitionRoute() {
    return routePrefix + "submitRequisition";
  }

  @Override
  public final void configure() throws Exception {
    preConfigure();
    
    RestDefinition rest = rest(path);
    
    final SystemAndOrg sysOrg = new SystemAndOrg();
    
    if (submitRequisitionEnabled) {
      rest = rest
        .post("/{system}/{organisationId}/requisition")
        .consumes("application/json")
        .produces("application/json")
        .bindingMode(RestBindingMode.json)
        .type(SubmitRequisitionRequest.class)        
        .outType(SubmitRequisitionResponse.class)
        .route()
          .convertBodyTo(SubmitRequisitionRequest.class)
          .process("processor.systemAndOrg")
          .process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
              sysOrg.process(exchange); // convert system and orgId to exchange properties
              SubmitRequisitionResponse response = handleSubmitRequisition(SystemAndOrg.getSystem(exchange), SystemAndOrg.getOrgansistionId(exchange), exchange.getIn().getBody(SubmitRequisitionRequest.class));
              exchange.getMessage().setBody(response);
            }
          })
        .endRest();
//      RouteDefinition r = from("rest://POST:"+path+":/{system}/{organisationId}/requisition?consumes=application/json&inType=com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionRequest&outType=com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionResponse");
//      if (tracingEnabled) {
//        r = r.tracing();
//      }
//      r.process("processor.systemAndOrg") // converts system/organisationId headers to exchange properties
//       .to(getSubmitRequisitionRoute());
    }
    
    // TODO : add more routes / operations
    
    postConfigure();
  }

  /**
   * Default handler sends the request to a direct: internal route
   * @param system - the system ID
   * @param organsistionId - the organisation ID
   * @param request - the requisition data
   * @return the response
   */
  protected SubmitRequisitionResponse handleSubmitRequisition(String system, String organsistionId, SubmitRequisitionRequest request) {
    return producer.requestBody(getSubmitRequisitionRoute(), request, SubmitRequisitionResponse.class);
  }

  /**
   * Called after configure completes. 
   * 
   * You can use this to add additional routes, etc.
   */
  protected void postConfigure() {
  }

  /**
   * Implement this method and call the various setters to configure your generated routes
   */
  protected abstract void preConfigure();

}
