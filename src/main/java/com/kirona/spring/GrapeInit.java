package com.kirona.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import groovy.grape.Grape;
import groovy.lang.GroovyClassLoader;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Loads extra dependencies via Grape BEFORE Spring starts, so we can define beans in them, etc
 * 
 * @author richard.newton
 *
 */
@Slf4j
public class GrapeInit {

  @Data
  private static class Artifact {
    private String groupId;
    private String artifactId;
    private String version;
  }
  
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
    
    // logging
    System.setProperty("groovy.grape.report.downloads", "true");
    //System.setProperty("ivy.message.logger.level", "4");
    
    // load a dependency (would be a dynamic list)
    try {
      final List<Artifact> artifacts = loadArtifacts(System.getProperty("grape.root"));
      
      final Map<String,Object> dependency = new HashMap<>();
  
      final GroovyClassLoader loader = new GroovyClassLoader(GrapeInit.class.getClassLoader());
      Thread.currentThread().setContextClassLoader(loader);
      dependency.put("classLoader", loader);
  
      log.info("Using Grape to load external dependencies : " + artifacts.size());
      for (Artifact a : artifacts) {
        log.info(" Grape.grab() : " + a);
        
        dependency.put("group", a.getGroupId());
        dependency.put("module", a.getArtifactId());
        dependency.put("version", a.getVersion());
        
        Grape.grab(dependency);
      }
    }
    catch (Exception e) {
      log.warn("Error loading Grape artifacts");
      throw new RuntimeException(e);
    }
    
    //final Map<String, Object> resolver = new HashMap<>();
    //Grape.addResolver(resolver);
  }
  
  private static List<Artifact> loadArtifacts(String rootFolder) throws Exception {
    final File artifactList = new File(rootFolder, "grape.artifacts");
    if (!artifactList.exists()) {
      log.info("No external dependecies to load. File does not exist : " + artifactList.getCanonicalPath());
      return Collections.emptyList();
    }
    
    final List<Artifact> loaded = new ArrayList<>();
    
    try (BufferedReader r = new BufferedReader(new FileReader(artifactList))) {
      String line = "";
      while (line != null) {
        line = r.readLine();
        if ((line != null) && !line.startsWith("#")) {
          String[] parts = line.split(":", 3);
          if (parts.length == 3) {
            Artifact a = new Artifact();
            a.setGroupId(parts[0]);
            a.setArtifactId(parts[1]);
            a.setVersion(parts[2]);
            loaded.add(a);
            log.info(" Read artifact details : " + a);
          }
          else {
            log.info("Ignored artifact details (not in 3 parts) : " + line);
          }
        }
      }
    }
    
    return loaded;
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
}
