package com.kirona.spring.routes.file;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.springframework.stereotype.Component;

import com.kirona.kironadata.data.model.SetRefCodesRequest;
import com.kirona.spring.soap.jm.JmClient;

@Component
public class FileRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    
    // in reality, you might pattern match the filenames rather than using the choice() stuff ... this is just a POC
    from("file://app/kirona/files/csv?autoCreate=true&readLock=rename&move=done&antInclude=*.csv")
      .tracing()
      // https://camel.apache.org/components/3.7.x/file-component.html#_file_consumer_only
      // https://camel.apache.org/manual/latest/faq/why-can-i-not-use-when-or-otherwise-in-a-java-camel-route.html
      .setProperty("orgCode").constant("KIR1") // different folders per org ?
      .choice()
        .when(header("CamelFileNameOnly").startsWith("refcodes"))
          .to("direct:file.refcodes")
        .when(header("CamelFileNameOnly").startsWith("other"))
          .to("direct:file.other")
        .otherwise()
          .log("Not a known file pattern : ${header.CamelFilePath}")
        .end();


    CsvDataFormat csvFormat = new CsvDataFormat();
    csvFormat.setDelimiter(",");
    csvFormat.setIgnoreHeaderCase("true");
    csvFormat.setSkipHeaderRecord("true"); // header is not data
    csvFormat.setUseMaps("true"); // file must have a header row
    
    // etc
    
    from("direct:file.refcodes")
      .log("Importing as RefCodes : ${header.CamelFilePath}")
      .unmarshal(csvFormat)  // one big list of maps !
      .convertBodyTo(SetRefCodesRequest.class) // relies on the translator below
      .setExchangePattern(ExchangePattern.InOnly)
      .bean(JmClient.class, "setRefCodes(${body},${exchangeProperty.orgCode})");
    
    from("direct:file.other")
      .log("Performing null operation on : ${header.CamelFilePath}");
    
    // tell camel how to transform CM model to JM model
    getContext().getTypeConverterRegistry()
      .addTypeConverters(new FileToRefCodesConverters());    
  }

}
