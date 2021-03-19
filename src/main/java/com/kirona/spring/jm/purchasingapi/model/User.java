package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirona.spring.jm.purchasingapi.model.UserAttribute;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A Job Manager User
 */
@ApiModel(description = "A Job Manager User")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class User   {
  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("fullName")
  private String fullName = null;

  @JsonProperty("attributes")
  @Valid
  private List<UserAttribute> attributes = null;

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * User name / id in Job Manager
   * @return userName
   **/
  @ApiModelProperty(example = "USER1", required = true, value = "User name / id in Job Manager")
      @NotNull

  @Size(max=30)   public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name of the user
   * @return fullName
   **/
  @ApiModelProperty(example = "Dave Smith", value = "Full name of the user")
  
    public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public User attributes(List<UserAttribute> attributes) {
    this.attributes = attributes;
    return this;
  }

  public User addAttributesItem(UserAttribute attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

  /**
   * Array of UserAttributes associated to the user
   * @return attributes
   **/
  @ApiModelProperty(value = "Array of UserAttributes associated to the user")
      @Valid
    public List<UserAttribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<UserAttribute> attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.fullName, user.fullName) &&
        Objects.equals(this.attributes, user.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, fullName, attributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
