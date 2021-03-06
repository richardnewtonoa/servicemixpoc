/*
 * Purchase Orders API
 * REST API for purchase orders
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.kirona.spring.cloudmarketplace.client.po.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FreeFormatDeliveryInfo
 */
@JsonPropertyOrder({
  FreeFormatDeliveryInfo.JSON_PROPERTY_ADDRESS_ID,
  FreeFormatDeliveryInfo.JSON_PROPERTY_FREE_FORMAT_SUPPLIER,
  FreeFormatDeliveryInfo.JSON_PROPERTY_METHOD
})
@JsonTypeName("FreeFormatDeliveryInfo")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-19T13:44:41.473Z[Europe/London]")
public class FreeFormatDeliveryInfo {
  public static final String JSON_PROPERTY_ADDRESS_ID = "addressId";
  private Long addressId;

  public static final String JSON_PROPERTY_FREE_FORMAT_SUPPLIER = "freeFormatSupplier";
  private Boolean freeFormatSupplier;

  /**
   * Gets or Sets method
   */
  public enum MethodEnum {
    MANUAL("MANUAL"),
    
    FAX("FAX"),
    
    EMAIL("EMAIL");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MethodEnum fromValue(String value) {
      for (MethodEnum b : MethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_METHOD = "method";
  private MethodEnum method;


  public FreeFormatDeliveryInfo addressId(Long addressId) {
    
    this.addressId = addressId;
    return this;
  }

   /**
   * Get addressId
   * @return addressId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getAddressId() {
    return addressId;
  }


  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }


  public FreeFormatDeliveryInfo freeFormatSupplier(Boolean freeFormatSupplier) {
    
    this.freeFormatSupplier = freeFormatSupplier;
    return this;
  }

   /**
   * Get freeFormatSupplier
   * @return freeFormatSupplier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FREE_FORMAT_SUPPLIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getFreeFormatSupplier() {
    return freeFormatSupplier;
  }


  public void setFreeFormatSupplier(Boolean freeFormatSupplier) {
    this.freeFormatSupplier = freeFormatSupplier;
  }


  public FreeFormatDeliveryInfo method(MethodEnum method) {
    
    this.method = method;
    return this;
  }

   /**
   * Get method
   * @return method
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MethodEnum getMethod() {
    return method;
  }


  public void setMethod(MethodEnum method) {
    this.method = method;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FreeFormatDeliveryInfo freeFormatDeliveryInfo = (FreeFormatDeliveryInfo) o;
    return Objects.equals(this.addressId, freeFormatDeliveryInfo.addressId) &&
        Objects.equals(this.freeFormatSupplier, freeFormatDeliveryInfo.freeFormatSupplier) &&
        Objects.equals(this.method, freeFormatDeliveryInfo.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressId, freeFormatSupplier, method);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FreeFormatDeliveryInfo {\n");
    sb.append("    addressId: ").append(toIndentedString(addressId)).append("\n");
    sb.append("    freeFormatSupplier: ").append(toIndentedString(freeFormatSupplier)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

