package com.kirona.spring;

import java.io.File;

import org.apache.camel.component.grape.FilePatchesRepository;
import org.apache.camel.component.grape.PatchesRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class GrapeBeans {
  
  @Bean
  PatchesRepository patchesRepository(@Value("${grape.patches.filename:grape.patches}") String filename) {
    File patchFile = new File(filename);
    try {
      log.info("Grape patches file : " + patchFile.getCanonicalPath());
    }
    catch (Exception e) {
      log.error("Error logging patchFile name", e);
    }
    return new FilePatchesRepository(patchFile);
  }
}
