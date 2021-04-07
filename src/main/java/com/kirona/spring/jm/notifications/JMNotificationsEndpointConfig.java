package com.kirona.spring.jm.notifications;

import java.util.List;
import java.util.Properties;

import javax.security.auth.callback.CallbackHandler;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.WsdlDefinition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

import com.kirona.encryption.KironaEncryption;
import com.kirona.webservices.jm.notification.INotificationListener;
import com.kirona.webservices.jm.notification.jobextendedstatus.AbstractJobExtendedStatusChangeListener;
import com.kirona.webservices.jm.notification.jobextendedstatus.JobExtendedStatusChangeRequest;
import com.kirona.webservices.jm.notification.jobextendedstatus.JobExtendedStatusChangeResponse;
import com.kirona.webservices.jm.notification.jobstatus.AbstractJobStatusChangeListener;
import com.kirona.webservices.jm.notification.jobstatus.JobStatusChangeRequest;
import com.kirona.webservices.jm.notification.jobstatus.JobStatusChangeResponse;

import lombok.extern.slf4j.Slf4j;

// pass incoming notification calls to Camel direct: routes
// most of the notifications code is from a standard artifact, but we have to wire it up for Camel in here
@Slf4j
@Configuration
@ComponentScan(
    basePackages={
        "com.kirona.webservices.jm.notification.endpoint"
//      , "com.kirona.webservices.jm.notification.optimisebatch.reportsuccess"
//      , "com.kirona.webservices.jm.notification.optimisebatchresult.reportsuccess"
//      , "com.kirona.webservices.jm.notification.externalschedule.reportsuccess"
//      , "com.kirona.webservices.jm.notification.gpsupdate.reportsuccess"
//      , "com.kirona.webservices.jm.notification.jobcreate.reportsuccess"
//      , "com.kirona.webservices.jm.notification.jobevent.reportsuccess"
//      , "com.kirona.webservices.jm.notification.jobextendedstatus.reportsuccess"
//      , "com.kirona.webservices.jm.notification.jobstatus.reportsuccess"
//      , "com.kirona.webservices.jm.notification.optimiseschedule.reportsuccess"
//      , "com.kirona.webservices.jm.notification.queryavailability.reportsuccess"
//      , "com.kirona.webservices.jm.notification.refreshjobs.reportsuccess"
//      , "com.kirona.webservices.jm.notification.slotselected.reportsuccess"
//      , "com.kirona.webservices.jm.notification.updatebooking.reportsuccess"
//      , "com.kirona.webservices.jm.notification.updatejobownership.reportsuccess"
//      , "com.kirona.webservices.jm.notification.version.reportsuccess"
//      , "com.kirona.webservices.jm.notification.workingstatus.reportsuccess"
    })
@EnableWs
public class JMNotificationsEndpointConfig extends WsConfigurerAdapter implements EnvironmentAware {

  private static final String PROP_WS_USERNAME = "notification.ws.username.encrypted";
  private static final String PROP_WS_PASSWORD = "notification.ws.password.encrypted";
  
  private Environment springEnv;
  
  
  @Autowired
  private ProducerTemplate camel;
  
  @Override
  public void setEnvironment(Environment environment) {
    springEnv = environment;
  }

  /* (non-Javadoc)
   * @see org.springframework.ws.config.annotation.WsConfigurerAdapter#addInterceptors(java.util.List)
   */
  @Override
  public void addInterceptors(List<EndpointInterceptor> interceptors) {
    // TODO : logging ?
    
    // add WS-Security interceptor
    // check if security is enabled before adding
    if (isWsSecurityEnabled()) {
      interceptors.add(getSecurityInterceptor());
      log.info("Added WS-Security interceptor");
    }
    else {
      log.warn("WS-Security is disabled. Set properties 'notification.ws.username' and 'notification.ws.password' to enable.");
    }
  }

  private EndpointInterceptor getSecurityInterceptor() {
    Wss4jSecurityInterceptor i = new Wss4jSecurityInterceptor();
    i.setValidationActions("UsernameToken");
    i.setValidationCallbackHandler(getSecurityCallbackHandler());
    i.setSkipValidationIfNoHeaderPresent(false);  // enforce WSS validation
    return i;
  }

  private CallbackHandler getSecurityCallbackHandler() {
    SimplePasswordValidationCallbackHandler h = new SimplePasswordValidationCallbackHandler();
    Properties users = new Properties();
    users.setProperty(decrypt(springEnv.getProperty(PROP_WS_USERNAME)), decrypt(springEnv.getProperty(PROP_WS_PASSWORD)));
    h.setUsers(users);
    return h;
  }

  private String decrypt(String value) {
    if (value == null) { return null; }
    return KironaEncryption.decrypt(value);
  }

  private boolean isWsSecurityEnabled() {
    // security enabled if a user name and password are specified
    return ( (springEnv.getProperty(PROP_WS_USERNAME) != null) && (springEnv.getProperty(PROP_WS_PASSWORD) != null) );
  }
  
  // see : https://spring.io/guides/gs/producing-web-service/
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/jm/notifications/*");
  }
    
    
  // example URL for WSDL access -
  // http://localhost:18080/ondemand/webservices/Notifications.wsdl
  @Bean(name="Notifications")
  public WsdlDefinition getWsdlDefinition() {
    ClassPathResource wsdlResource = new ClassPathResource("wsdl/JobManagerOutboundNotificationServices.wsdl");
    log.info("Notifications WSDL should be available at url http(s)://SERVER:PORT/jm/notifications/Notifications.wsdl ...");
    return new SimpleWsdl11Definition(wsdlResource);
  }

  @Bean(name="Notifications880")
  public WsdlDefinition getWsdlDefinition880() {
    ClassPathResource wsdlResource = new ClassPathResource("wsdl/JobManagerOutboundNotificationServices_v8.8.0.wsdl");
    log.info("Notifications WSDL should be available at url http(s)://SERVER:PORT/jm/notifications/Notifications880.wsdl ...");
    return new SimpleWsdl11Definition(wsdlResource);
  }
  
  @Bean(name="Notifications882")
  public WsdlDefinition getWsdlDefinition882() {
    ClassPathResource wsdlResource = new ClassPathResource("wsdl/JobManagerOutboundNotificationServices_v8.8.2.wsdl");
    log.info("Notifications WSDL should be available at url http(s)://SERVER:PORT/jm/notifications/Notifications882.wsdl ...");
    return new SimpleWsdl11Definition(wsdlResource);
  }
  
  
// LISTENERS
  
  @Bean
  public INotificationListener jobStatusChangeListener() {
    return new AbstractJobStatusChangeListener() {      
      @Override
      protected JobStatusChangeResponse handleRequest(JobStatusChangeRequest request) {
        log.info("Received job status change request " + request);
        
        final JobStatusChangeResponse response = new JobStatusChangeResponse(request.getJobId());
        response.setSuccess(true);
        
        try {
          camel.sendBody("direct:jm.notify.jobStatusChange", request);
        }
        catch (Throwable t) {
          log.warn("Error handling job status change notification", t);
          response.setSuccess(false);
        }
        
        return response;
      }
    };
  }
  
  @Bean
  public INotificationListener jobExtendedStatusChangeListener() {
    return new AbstractJobExtendedStatusChangeListener() {
      @Override
      protected JobExtendedStatusChangeResponse handleRequest(JobExtendedStatusChangeRequest request) {
        log.info("Received job extended status change request " + request);
        
        final JobExtendedStatusChangeResponse response = new JobExtendedStatusChangeResponse(request.getJobId());
        response.setSuccess(true);
        
        try {
          camel.sendBody("direct:jm.notify.jobExtendedStatusChange", request);
        }
        catch (Throwable t) {
          log.warn("Error handling job extended status change notification", t);
          response.setSuccess(false);
        }
        
        return response;
      }
    };
    
  }
  
  // TODO : create beans for all other request types
}
