package com.kirona.spring.routes.jm.notifications;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.kirona.webservices.jm.notification.jobstatus.JobStatusChangeRequest;

@Component
public class StatusUpdateRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("direct:jm.notify.jobStatusChange")
      .tracing()
      .convertBodyTo(JobStatusChangeRequest.class) // should already be this class - just for documentation
      .choice()
        .when(simple("${body.statusCode} == 'STARTED'"))
        .log("STARTED status")
      .otherwise()
        .log("other status");
  }

}
