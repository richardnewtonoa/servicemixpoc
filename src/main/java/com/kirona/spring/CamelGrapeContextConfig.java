package com.kirona.spring;

import org.apache.camel.CamelContext;
import org.apache.camel.component.grape.GrapeComponent;
import org.apache.camel.component.grape.PatchesRepository;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.apache.ivy.core.settings.IvySettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.kirona.spring.grape.GrapeController;

import groovy.grape.Grape;
import groovy.grape.GrapeIvy;
import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;

import static org.apache.camel.component.grape.GrapeEndpoint.loadPatches;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.stream.Collectors;

// https://camel.apache.org/components/3.4.x/grape-component.html#_setting_up_class_loader
@Slf4j
@Component
public class CamelGrapeContextConfig implements CamelContextConfiguration {
  
  @Autowired
  @Lazy
  GrapeController controller;
  
  @Autowired
  @Lazy
  PatchesRepository patchRepo;
  
  // call from Spring Boot Main
  public static void initGrapes(String[] args) {
    // see groovy.grape.GrapeIvy
    if (System.getProperty("grape.root") == null) {
      System.setProperty("grape.root", "./grape");
    }
    if (System.getProperty("grape.config") == null) {
      System.setProperty("grape.config", System.getProperty("grape.root") + "/grapeConfig.xml");
    }
    
    try { 
      File rf = new File(System.getProperty("grape.root"));      
      System.setProperty("grape.root", rf.getCanonicalPath());
      File cf = new File(System.getProperty("grape.config"));   
      if (!cf.exists()) {
        createDefaultConfig(cf);
      }
      System.setProperty("grape.config", cf.getCanonicalPath());
    } catch (Exception ignore) {}
    
    log.info("Grape root directory configured at : " + System.getProperty("grape.root")); 
    log.info("Looking for Grape Config file at : " + System.getProperty("grape.config")); 
    
    //final Map<String, Object> resolver = new HashMap<>();
    //Grape.addResolver(resolver);
  }
  
  private static void createDefaultConfig(File cf) throws Exception {
    log.info("Creating default Grape config : " + cf.getCanonicalPath());
    ClassPathResource source = new ClassPathResource("grapeConfig.xml");
    try(InputStream is = source.getInputStream()) {
      try(OutputStream os = new FileOutputStream(cf)) {
        int b = 0;
        while (b >= 0) {
          b = is.read();
          if (b >= 0) {
            os.write(b);
          }
        }
      }
    }
  }

  @Override
  public void beforeApplicationStart(CamelContext camelContext) {
    log.info("Configuring Camel Context for Grape : " + camelContext);
    camelContext.setApplicationContextClassLoader(new GroovyClassLoader(camelContext.getApplicationContextClassLoader()));
  }

  @Override
  public void afterApplicationStart(CamelContext camelContext) {
    // dynamically load jars at startup 
    // https://camel.apache.org/components/3.4.x/grape-component.html#_loading_processors_bean_at_runtime
    // http://docs.groovy-lang.org/latest/html/documentation/grape.html
    final GrapeComponent grape = camelContext.getComponent("grape", GrapeComponent.class);

    final IvySettings settings = ((GrapeIvy)Grape.getInstance()).getSettings();
    log.info("Grape / Ivy resolver names : " + settings.getResolverNames().stream().collect(Collectors.joining(",")));
    
    grape.setPatchesRepository(patchRepo);
    
    log.info("Loading Grape patches ...");
    loadPatches(camelContext);
    
    controller.status();
  }
}
