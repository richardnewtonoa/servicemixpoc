package com.kirona.spring.jm.purchasingapi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirona.spring.jm.purchasingapi.model.GetOrderResponse;
import com.kirona.spring.jm.purchasingapi.model.GetRequisitionResponse;
import com.kirona.spring.jm.purchasingapi.model.StockEnquiryResponse;
import com.kirona.spring.jm.purchasingapi.model.SubmitGRNRequest;
import com.kirona.spring.jm.purchasingapi.model.SubmitGRNResponse;
import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionRequest;
import com.kirona.spring.jm.purchasingapi.model.SubmitRequisitionResponse;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link SystemApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")
public interface SystemApiDelegate {

    Logger log = LoggerFactory.getLogger(SystemApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see SystemApi#getOrder
     */
    default ResponseEntity<GetOrderResponse> getOrder( String  system,
         String  organisationId,
         String  orderId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"requisitionId\" : \"requisitionId\",\n  \"orderId\" : \"orderId\",\n  \"lines\" : [ {\n    \"lineCost\" : 0.6027456,\n    \"quantity\" : 0,\n    \"lineDelivery\" : 0.5962134,\n    \"lineNumber\" : \"lineNumber\",\n    \"stockCode\" : \"stockCode\",\n    \"lineVAT\" : 0.14658129\n  }, {\n    \"lineCost\" : 0.6027456,\n    \"quantity\" : 0,\n    \"lineDelivery\" : 0.5962134,\n    \"lineNumber\" : \"lineNumber\",\n    \"stockCode\" : \"stockCode\",\n    \"lineVAT\" : 0.14658129\n  } ]\n}", GetOrderResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SystemApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SystemApi#getRequisition
     */
    default ResponseEntity<GetRequisitionResponse> getRequisition( String  system,
         String  organisationId,
         String  requisitionId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"requisitionId\" : \"requisitionId\",\n  \"orders\" : [ {\n    \"orderId\" : \"orderId\"\n  }, {\n    \"orderId\" : \"orderId\"\n  } ],\n  \"status\" : \"submitted\"\n}", GetRequisitionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SystemApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SystemApi#stockEnquiry
     */
    default ResponseEntity<StockEnquiryResponse> stockEnquiry( String  system,
         String  organisationId,
         String  stockCode,
         String  extSupplierId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"supplierStockItem\" : [ {\n    \"cost\" : 0.08008281904610115,\n    \"catalogId\" : \"catalogId\",\n    \"extSupplierPartCode\" : \"extSupplierPartCode\",\n    \"extSupplierId\" : \"extSupplierId\",\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"deliveryCharge\" : 0.6027456183070403,\n    \"minOrderQuantity\" : 0,\n    \"leadTimeInDays\" : 0,\n    \"collectionAvailable\" : true\n  }, {\n    \"cost\" : 0.08008281904610115,\n    \"catalogId\" : \"catalogId\",\n    \"extSupplierPartCode\" : \"extSupplierPartCode\",\n    \"extSupplierId\" : \"extSupplierId\",\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"deliveryCharge\" : 0.6027456183070403,\n    \"minOrderQuantity\" : 0,\n    \"leadTimeInDays\" : 0,\n    \"collectionAvailable\" : true\n  } ]\n}", StockEnquiryResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SystemApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SystemApi#submitGRN
     */
    default ResponseEntity<SubmitGRNResponse> submitGRN( String  system,
         String  organisationId,
         SubmitGRNRequest  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"grnId\" : \"grnId\"\n}", SubmitGRNResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SystemApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SystemApi#submitRequisition
     */
    default ResponseEntity<SubmitRequisitionResponse> submitRequisition( String  system,
         String  organisationId,
         SubmitRequisitionRequest  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"requisitionId\" : \"requisitionId\"\n}", SubmitRequisitionResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SystemApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
