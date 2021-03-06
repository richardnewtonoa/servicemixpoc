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
import com.kirona.spring.cloudmarketplace.client.po.model.Organisation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Buyer
 */
@JsonPropertyOrder({
  Buyer.JSON_PROPERTY_ATTENTION,
  Buyer.JSON_PROPERTY_BUSINESS_UNIT,
  Buyer.JSON_PROPERTY_BUSINESS_UNIT_ID,
  Buyer.JSON_PROPERTY_EMAIL,
  Buyer.JSON_PROPERTY_FAX,
  Buyer.JSON_PROPERTY_ID,
  Buyer.JSON_PROPERTY_INTERNAL_DELIVERY_ADDRESS,
  Buyer.JSON_PROPERTY_MAIL_STOP,
  Buyer.JSON_PROPERTY_NAME,
  Buyer.JSON_PROPERTY_ORGANISATION,
  Buyer.JSON_PROPERTY_PHONE,
  Buyer.JSON_PROPERTY_TAX_NUMBER
})
@JsonTypeName("Buyer")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-19T13:44:41.473Z[Europe/London]")
public class Buyer {
  public static final String JSON_PROPERTY_ATTENTION = "attention";
  private String attention;

  public static final String JSON_PROPERTY_BUSINESS_UNIT = "businessUnit";
  private String businessUnit;

  public static final String JSON_PROPERTY_BUSINESS_UNIT_ID = "businessUnitId";
  private Long businessUnitId;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_FAX = "fax";
  private String fax;

  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_INTERNAL_DELIVERY_ADDRESS = "internalDeliveryAddress";
  private String internalDeliveryAddress;

  public static final String JSON_PROPERTY_MAIL_STOP = "mailStop";
  private String mailStop;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_ORGANISATION = "organisation";
  private Organisation organisation;

  public static final String JSON_PROPERTY_PHONE = "phone";
  private String phone;

  public static final String JSON_PROPERTY_TAX_NUMBER = "taxNumber";
  private String taxNumber;


  public Buyer attention(String attention) {
    
    this.attention = attention;
    return this;
  }

   /**
   * Get attention
   * @return attention
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ATTENTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAttention() {
    return attention;
  }


  public void setAttention(String attention) {
    this.attention = attention;
  }


  public Buyer businessUnit(String businessUnit) {
    
    this.businessUnit = businessUnit;
    return this;
  }

   /**
   * Get businessUnit
   * @return businessUnit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BUSINESS_UNIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBusinessUnit() {
    return businessUnit;
  }


  public void setBusinessUnit(String businessUnit) {
    this.businessUnit = businessUnit;
  }


  public Buyer businessUnitId(Long businessUnitId) {
    
    this.businessUnitId = businessUnitId;
    return this;
  }

   /**
   * Get businessUnitId
   * @return businessUnitId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BUSINESS_UNIT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getBusinessUnitId() {
    return businessUnitId;
  }


  public void setBusinessUnitId(Long businessUnitId) {
    this.businessUnitId = businessUnitId;
  }


  public Buyer email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public Buyer fax(String fax) {
    
    this.fax = fax;
    return this;
  }

   /**
   * Get fax
   * @return fax
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FAX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFax() {
    return fax;
  }


  public void setFax(String fax) {
    this.fax = fax;
  }


  public Buyer id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Buyer internalDeliveryAddress(String internalDeliveryAddress) {
    
    this.internalDeliveryAddress = internalDeliveryAddress;
    return this;
  }

   /**
   * Get internalDeliveryAddress
   * @return internalDeliveryAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INTERNAL_DELIVERY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInternalDeliveryAddress() {
    return internalDeliveryAddress;
  }


  public void setInternalDeliveryAddress(String internalDeliveryAddress) {
    this.internalDeliveryAddress = internalDeliveryAddress;
  }


  public Buyer mailStop(String mailStop) {
    
    this.mailStop = mailStop;
    return this;
  }

   /**
   * Get mailStop
   * @return mailStop
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MAIL_STOP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMailStop() {
    return mailStop;
  }


  public void setMailStop(String mailStop) {
    this.mailStop = mailStop;
  }


  public Buyer name(String name) {
    
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


  public Buyer organisation(Organisation organisation) {
    
    this.organisation = organisation;
    return this;
  }

   /**
   * Get organisation
   * @return organisation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ORGANISATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Organisation getOrganisation() {
    return organisation;
  }


  public void setOrganisation(Organisation organisation) {
    this.organisation = organisation;
  }


  public Buyer phone(String phone) {
    
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    this.phone = phone;
  }


  public Buyer taxNumber(String taxNumber) {
    
    this.taxNumber = taxNumber;
    return this;
  }

   /**
   * Get taxNumber
   * @return taxNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TAX_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaxNumber() {
    return taxNumber;
  }


  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Buyer buyer = (Buyer) o;
    return Objects.equals(this.attention, buyer.attention) &&
        Objects.equals(this.businessUnit, buyer.businessUnit) &&
        Objects.equals(this.businessUnitId, buyer.businessUnitId) &&
        Objects.equals(this.email, buyer.email) &&
        Objects.equals(this.fax, buyer.fax) &&
        Objects.equals(this.id, buyer.id) &&
        Objects.equals(this.internalDeliveryAddress, buyer.internalDeliveryAddress) &&
        Objects.equals(this.mailStop, buyer.mailStop) &&
        Objects.equals(this.name, buyer.name) &&
        Objects.equals(this.organisation, buyer.organisation) &&
        Objects.equals(this.phone, buyer.phone) &&
        Objects.equals(this.taxNumber, buyer.taxNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attention, businessUnit, businessUnitId, email, fax, id, internalDeliveryAddress, mailStop, name, organisation, phone, taxNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Buyer {\n");
    sb.append("    attention: ").append(toIndentedString(attention)).append("\n");
    sb.append("    businessUnit: ").append(toIndentedString(businessUnit)).append("\n");
    sb.append("    businessUnitId: ").append(toIndentedString(businessUnitId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    internalDeliveryAddress: ").append(toIndentedString(internalDeliveryAddress)).append("\n");
    sb.append("    mailStop: ").append(toIndentedString(mailStop)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    organisation: ").append(toIndentedString(organisation)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    taxNumber: ").append(toIndentedString(taxNumber)).append("\n");
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

