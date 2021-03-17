package com.kirona.spring.transformers;

import org.springframework.stereotype.Component;

import com.kirona.spring.model.MessageBean;
import com.kirona.spring.model.ReplyBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestTransformer {
  
  public ReplyBean testRouteReply(MessageBean messageBody) {
    log.info(" Received Message Body = " + messageBody);
    ReplyBean r = new ReplyBean();
    r.setReply("REPLY");
    return r;
  }
}
