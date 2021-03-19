package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirona.spring.jm.purchasingapi.model.OrderLine;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details of a single purchase order
 */
@ApiModel(description = "Details of a single purchase order")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class GetOrderResponse   {
  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("requisitionId")
  private String requisitionId = null;

  @JsonProperty("lines")
  @Valid
  private List<OrderLine> lines = null;

  public GetOrderResponse orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * The purchasing system purchase order ID
   * @return orderId
   **/
  @ApiModelProperty(required = true, value = "The purchasing system purchase order ID")
      @NotNull

    public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public GetOrderResponse requisitionId(String requisitionId) {
    this.requisitionId = requisitionId;
    return this;
  }

  /**
   * The purchasing system requisition ID
   * @return requisitionId
   **/
  @ApiModelProperty(required = true, value = "The purchasing system requisition ID")
      @NotNull

    public String getRequisitionId() {
    return requisitionId;
  }

  public void setRequisitionId(String requisitionId) {
    this.requisitionId = requisitionId;
  }

  public GetOrderResponse lines(List<OrderLine> lines) {
    this.lines = lines;
    return this;
  }

  public GetOrderResponse addLinesItem(OrderLine linesItem) {
    if (this.lines == null) {
      this.lines = new ArrayList<>();
    }
    this.lines.add(linesItem);
    return this;
  }

  /**
   * Get lines
   * @return lines
   **/
  @ApiModelProperty(value = "")
      @Valid
    public List<OrderLine> getLines() {
    return lines;
  }

  public void setLines(List<OrderLine> lines) {
    this.lines = lines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetOrderResponse getOrderResponse = (GetOrderResponse) o;
    return Objects.equals(this.orderId, getOrderResponse.orderId) &&
        Objects.equals(this.requisitionId, getOrderResponse.requisitionId) &&
        Objects.equals(this.lines, getOrderResponse.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, requisitionId, lines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetOrderResponse {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    requisitionId: ").append(toIndentedString(requisitionId)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
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
