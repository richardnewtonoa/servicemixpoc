package com.kirona.spring.routes.file;

import java.util.List;
import java.util.Map;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

import com.kirona.kironadata.data.model.RefCodesValuesType;
import com.kirona.kironadata.data.model.SetRefCodesRequest;

import lombok.extern.slf4j.Slf4j;

//https://camel.apache.org/manual/latest/type-converter.html
@Slf4j
public class FileToRefCodesConverters implements TypeConverters {

  public static final String DOMAIN = "DOMAIN";
  public static final String LOW_VALUE = "LOW_VALUE";
      
  @Converter(allowNull = true)
  public SetRefCodesRequest fileToRefCodes(List<Map<String,String>> csvLines) {
    
    SetRefCodesRequest r = null;
    
    if ((csvLines != null) && (!csvLines.isEmpty())) {
      r = new SetRefCodesRequest();
      
      // we do have some data - we only get domain from line 1
      // records in different domains are ignored
      r.setRefCodesDomain(csvLines.get(0).get(DOMAIN));
      log.info("DOMAIN on first record = " + r.getRefCodesDomain());
      
      if (r.getRefCodesDomain() != null) {
        for (Map<String,String> line : csvLines) {
          final String domain = line.get(DOMAIN);
          if (r.getRefCodesDomain().equals(domain)) {
            // this line is for the correct domain
            RefCodesValuesType v = new RefCodesValuesType();
            v.setLowValue(line.get(LOW_VALUE));
            // TODO : more fields
            r.getRefCodesValues().add(v);
          }
          else {
            log.info("Ignored line - not in correct domain : " + domain);
          }
        }
      }
    }
    return r;
  }
}
