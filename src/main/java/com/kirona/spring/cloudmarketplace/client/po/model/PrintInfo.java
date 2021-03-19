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
 * PrintInfo
 */
@JsonPropertyOrder({
  PrintInfo.JSON_PROPERTY_FINAL_TEXT,
  PrintInfo.JSON_PROPERTY_FOOTER,
  PrintInfo.JSON_PROPERTY_HEADER
})
@JsonTypeName("PrintInfo")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-19T13:44:41.473Z[Europe/London]")
public class PrintInfo {
  public static final String JSON_PROPERTY_FINAL_TEXT = "finalText";
  private String finalText;

  public static final String JSON_PROPERTY_FOOTER = "footer";
  private String footer;

  public static final String JSON_PROPERTY_HEADER = "header";
  private String header;


  public PrintInfo finalText(String finalText) {
    
    this.finalText = finalText;
    return this;
  }

   /**
   * Get finalText
   * @return finalText
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FINAL_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFinalText() {
    return finalText;
  }


  public void setFinalText(String finalText) {
    this.finalText = finalText;
  }


  public PrintInfo footer(String footer) {
    
    this.footer = footer;
    return this;
  }

   /**
   * Get footer
   * @return footer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FOOTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFooter() {
    return footer;
  }


  public void setFooter(String footer) {
    this.footer = footer;
  }


  public PrintInfo header(String header) {
    
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HEADER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHeader() {
    return header;
  }


  public void setHeader(String header) {
    this.header = header;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrintInfo printInfo = (PrintInfo) o;
    return Objects.equals(this.finalText, printInfo.finalText) &&
        Objects.equals(this.footer, printInfo.footer) &&
        Objects.equals(this.header, printInfo.header);
  }

  @Override
  public int hashCode() {
    return Objects.hash(finalText, footer, header);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrintInfo {\n");
    sb.append("    finalText: ").append(toIndentedString(finalText)).append("\n");
    sb.append("    footer: ").append(toIndentedString(footer)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
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

