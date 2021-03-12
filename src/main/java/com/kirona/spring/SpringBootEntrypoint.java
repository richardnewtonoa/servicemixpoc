package com.kirona.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * Spring Boot entry point (see POM packaging)
 * 
 * @author richard.newton
 *
 */
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class SpringBootEntrypoint {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootEntrypoint.class, args);
  }
}
