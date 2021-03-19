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
 * The result of submitting a GRN to the purchasing system
 */
@ApiModel(description = "The result of submitting a GRN to the purchasing system")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class SubmitGRNResponse   {
  @JsonProperty("grnId")
  private String grnId = null;

  public SubmitGRNResponse grnId(String grnId) {
    this.grnId = grnId;
    return this;
  }

  /**
   * GRN ID created in the purchasing system. May be null if the system does not create such IDs.
   * @return grnId
   **/
  @ApiModelProperty(required = true, value = "GRN ID created in the purchasing system. May be null if the system does not create such IDs.")
      @NotNull

    public String getGrnId() {
    return grnId;
  }

  public void setGrnId(String grnId) {
    this.grnId = grnId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitGRNResponse submitGRNResponse = (SubmitGRNResponse) o;
    return Objects.equals(this.grnId, submitGRNResponse.grnId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grnId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitGRNResponse {\n");
    
    sb.append("    grnId: ").append(toIndentedString(grnId)).append("\n");
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
