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
 * A single line on a goods received note
 */
@ApiModel(description = "A single line on a goods received note")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class GRNLine   {
  @JsonProperty("goodsReceivedLineId")
  private Long goodsReceivedLineId = null;

  @JsonProperty("orderId")
  private Long orderId = null;

  @JsonProperty("lineNumber")
  private String lineNumber = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("lineComplete")
  private Boolean lineComplete = null;

  public GRNLine goodsReceivedLineId(Long goodsReceivedLineId) {
    this.goodsReceivedLineId = goodsReceivedLineId;
    return this;
  }

  /**
   * The Job Manager goods received line ID
   * @return goodsReceivedLineId
   **/
  @ApiModelProperty(required = true, value = "The Job Manager goods received line ID")
      @NotNull

    public Long getGoodsReceivedLineId() {
    return goodsReceivedLineId;
  }

  public void setGoodsReceivedLineId(Long goodsReceivedLineId) {
    this.goodsReceivedLineId = goodsReceivedLineId;
  }

  public GRNLine orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * The purchasing system purchase order ID
   * @return orderId
   **/
  @ApiModelProperty(required = true, value = "The purchasing system purchase order ID")
      @NotNull

    public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public GRNLine lineNumber(String lineNumber) {
    this.lineNumber = lineNumber;
    return this;
  }

  /**
   * The purchasing system purchase order line number
   * @return lineNumber
   **/
  @ApiModelProperty(required = true, value = "The purchasing system purchase order line number")
      @NotNull

    public String getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(String lineNumber) {
    this.lineNumber = lineNumber;
  }

  public GRNLine quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * The quantity received (minimum of 1)
   * minimum: 1
   * @return quantity
   **/
  @ApiModelProperty(required = true, value = "The quantity received (minimum of 1)")
      @NotNull

  @Min(1)  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public GRNLine lineComplete(Boolean lineComplete) {
    this.lineComplete = lineComplete;
    return this;
  }

  /**
   * True if all items for this line have been received, false otherwise
   * @return lineComplete
   **/
  @ApiModelProperty(required = true, value = "True if all items for this line have been received, false otherwise")
      @NotNull

    public Boolean isLineComplete() {
    return lineComplete;
  }

  public void setLineComplete(Boolean lineComplete) {
    this.lineComplete = lineComplete;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GRNLine grNLine = (GRNLine) o;
    return Objects.equals(this.goodsReceivedLineId, grNLine.goodsReceivedLineId) &&
        Objects.equals(this.orderId, grNLine.orderId) &&
        Objects.equals(this.lineNumber, grNLine.lineNumber) &&
        Objects.equals(this.quantity, grNLine.quantity) &&
        Objects.equals(this.lineComplete, grNLine.lineComplete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goodsReceivedLineId, orderId, lineNumber, quantity, lineComplete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GRNLine {\n");
    
    sb.append("    goodsReceivedLineId: ").append(toIndentedString(goodsReceivedLineId)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    lineNumber: ").append(toIndentedString(lineNumber)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    lineComplete: ").append(toIndentedString(lineComplete)).append("\n");
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
