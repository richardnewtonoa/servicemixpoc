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
 * Result of successfully submitting a requisition request
 */
@ApiModel(description = "Result of successfully submitting a requisition request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class SubmitRequisitionResponse   {
  @JsonProperty("requisitionId")
  private String requisitionId = null;

  public SubmitRequisitionResponse requisitionId(String requisitionId) {
    this.requisitionId = requisitionId;
    return this;
  }

  /**
   * The external requisition ID created
   * @return requisitionId
   **/
  @ApiModelProperty(required = true, value = "The external requisition ID created")
      @NotNull

    public String getRequisitionId() {
    return requisitionId;
  }

  public void setRequisitionId(String requisitionId) {
    this.requisitionId = requisitionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitRequisitionResponse submitRequisitionResponse = (SubmitRequisitionResponse) o;
    return Objects.equals(this.requisitionId, submitRequisitionResponse.requisitionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requisitionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitRequisitionResponse {\n");
    
    sb.append("    requisitionId: ").append(toIndentedString(requisitionId)).append("\n");
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
