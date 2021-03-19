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
 * An order as a child of a requisition
 */
@ApiModel(description = "An order as a child of a requisition")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class RequisitionOrder   {
  @JsonProperty("orderId")
  private String orderId = null;

  public RequisitionOrder orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * The ID of the purchase order in the external system
   * @return orderId
   **/
  @ApiModelProperty(required = true, value = "The ID of the purchase order in the external system")
      @NotNull

    public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequisitionOrder requisitionOrder = (RequisitionOrder) o;
    return Objects.equals(this.orderId, requisitionOrder.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequisitionOrder {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
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
