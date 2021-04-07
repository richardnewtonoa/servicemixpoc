package com.kirona.spring.rest.cm;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestDefinition;
import org.springframework.beans.factory.annotation.Autowired;

import com.kirona.spring.jm.purchasingapi.cloudmarketplace.CMAuthentication;
import com.kirona.spring.processors.SystemAndOrg;

import lombok.Setter;

/**
 * Extend this to create internal routes that accept CM Java model objects, and pass them to the CM REST endpoint, and return the result as Java model objects 
 * @author richard.newton
 *
 */
public abstract class AbstractCMPurchasingApiRouteBuilder extends RouteBuilder {

  @Setter
  private String path = "/jm/purchasing";
  @Setter
  private String host = "http://locahost";
  @Setter
  private String routePrefix = "direct:cmPurchasing.outbound.";
  @Setter
  private boolean tracingEnabled = false;
  
  @Autowired
  protected CMAuthentication cmAuthentication;
  
  protected final Processor authProcessor = createAuthenticationProcess();
  
  @Override
  public void configure() throws Exception {
    preConfigure();
    
    // common setup for all routes
    RestDefinition rest = rest()
        .bindingMode(RestBindingMode.json)
        .consumes("application/json")
        .produces("application/json");
    
    rest.setApiDocs("com/kirona/spring/rest/cm/purchase-orders_api-1.0-resolved.json");
    
    // we expect the message body to be a Long (purchase order ID)
    from(getPurchaseOrderDetailRoute())
      // get OAuth token and set a message header
      .process(authProcessor)
      .setHeader("purchaseOrderId").simple("${body}")
      .to("rest:get:" + path + ":/api/purchase-orders/{purchaseOrderId}?outType=com.kirona.spring.cloudmarketplace.client.po.model.PurchaseOrder&host="+host+"&apiDoc=com/kirona/spring/rest/cm/purchase-orders_api-1.0-resolved.json");
    
    postConfigure();
  }

  protected Processor createAuthenticationProcess() {
    return new Processor() {
      @Override
      public void process(Exchange exchange) throws Exception {
        String system = SystemAndOrg.getSystem(exchange);
        String orgId = SystemAndOrg.getOrgansistionId(exchange);
        String token = cmAuthentication.getAuthToken(system, orgId);
        exchange.getMessage().setHeader("Authorization", token);
      }
     };
  }

  private String getPurchaseOrderDetailRoute() {
    return routePrefix + "po.details";
  }

  private void postConfigure() {
  }

  protected abstract void preConfigure();

}
