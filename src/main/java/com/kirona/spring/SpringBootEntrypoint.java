package com.kirona.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring Boot entry point (see POM packaging)
 * 
 * @author richard.newton
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableJms
@EnableWebMvc
public class SpringBootEntrypoint {
  public static void main(String[] args) {
    CamelGrapeContextConfig.initGrapes(args);
    SpringApplication.run(SpringBootEntrypoint.class, args);
  }
}
