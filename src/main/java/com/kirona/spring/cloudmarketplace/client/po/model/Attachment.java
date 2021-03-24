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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Attachment
 */
@JsonPropertyOrder({
  Attachment.JSON_PROPERTY_FULL_FILE_PATH,
  Attachment.JSON_PROPERTY_NAME,
  Attachment.JSON_PROPERTY_TIMESTAMP
})
@JsonTypeName("Attachment")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-19T13:44:41.473Z[Europe/London]")
public class Attachment {
  public static final String JSON_PROPERTY_FULL_FILE_PATH = "fullFilePath";
  private String fullFilePath;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private OffsetDateTime timestamp;


  public Attachment fullFilePath(String fullFilePath) {
    
    this.fullFilePath = fullFilePath;
    return this;
  }

   /**
   * Get fullFilePath
   * @return fullFilePath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FULL_FILE_PATH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFullFilePath() {
    return fullFilePath;
  }


  public void setFullFilePath(String fullFilePath) {
    this.fullFilePath = fullFilePath;
  }


  public Attachment name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Attachment timestamp(OffsetDateTime timestamp) {
    
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }


  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.fullFilePath, attachment.fullFilePath) &&
        Objects.equals(this.name, attachment.name) &&
        Objects.equals(this.timestamp, attachment.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullFilePath, name, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    sb.append("    fullFilePath: ").append(toIndentedString(fullFilePath)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
