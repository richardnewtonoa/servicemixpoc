package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A single user attribute
 */
@ApiModel(description = "A single user attribute")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class UserAttribute   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("value")
  private String value = null;

  public UserAttribute code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The attribute code. Unique for a given user.
   * @return code
   **/
  @ApiModelProperty(example = "EMAIL", required = true, value = "The attribute code. Unique for a given user.")
      @NotNull

  @Size(max=30)   public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public UserAttribute value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The attribute value
   * @return value
   **/
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The attribute value")
      @NotNull

  @Size(max=100)   public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAttribute userAttribute = (UserAttribute) o;
    return Objects.equals(this.code, userAttribute.code) &&
        Objects.equals(this.value, userAttribute.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAttribute {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
