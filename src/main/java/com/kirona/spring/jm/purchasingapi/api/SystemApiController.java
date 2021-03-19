package com.kirona.spring.jm.purchasingapi.api;

import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")
@RestController
public class SystemApiController implements SystemApi {

    private final SystemApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public SystemApiController(SystemApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public SystemApiDelegate getDelegate() {
        return delegate;
    }
}
