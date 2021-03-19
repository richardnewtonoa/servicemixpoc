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
 * Details of a single purchase order line
 */
@ApiModel(description = "Details of a single purchase order line")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class OrderLine   {
  @JsonProperty("lineNumber")
  private String lineNumber = null;

  @JsonProperty("stockCode")
  private String stockCode = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("lineCost")
  private Float lineCost = null;

  @JsonProperty("lineVAT")
  private Float lineVAT = null;

  @JsonProperty("lineDelivery")
  private Float lineDelivery = null;

  public OrderLine lineNumber(String lineNumber) {
    this.lineNumber = lineNumber;
    return this;
  }

  /**
   * The purchase order line number
   * @return lineNumber
   **/
  @ApiModelProperty(required = true, value = "The purchase order line number")
      @NotNull

    public String getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(String lineNumber) {
    this.lineNumber = lineNumber;
  }

  public OrderLine stockCode(String stockCode) {
    this.stockCode = stockCode;
    return this;
  }

  /**
   * The stock code (manufacturer part code) of this line
   * @return stockCode
   **/
  @ApiModelProperty(required = true, value = "The stock code (manufacturer part code) of this line")
      @NotNull

    public String getStockCode() {
    return stockCode;
  }

  public void setStockCode(String stockCode) {
    this.stockCode = stockCode;
  }

  public OrderLine quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * The quantity of items for this line
   * minimum: 0
   * @return quantity
   **/
  @ApiModelProperty(required = true, value = "The quantity of items for this line")
      @NotNull

  @Min(0)  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderLine lineCost(Float lineCost) {
    this.lineCost = lineCost;
    return this;
  }

  /**
   * The cost of the items on this line ex VAT (optional)
   * minimum: 0
   * @return lineCost
   **/
  @ApiModelProperty(value = "The cost of the items on this line ex VAT (optional)")
  
  @DecimalMin("0")  public Float getLineCost() {
    return lineCost;
  }

  public void setLineCost(Float lineCost) {
    this.lineCost = lineCost;
  }

  public OrderLine lineVAT(Float lineVAT) {
    this.lineVAT = lineVAT;
    return this;
  }

  /**
   * The value of the VAT on this line (optional)
   * minimum: 0
   * @return lineVAT
   **/
  @ApiModelProperty(value = "The value of the VAT on this line (optional)")
  
  @DecimalMin("0")  public Float getLineVAT() {
    return lineVAT;
  }

  public void setLineVAT(Float lineVAT) {
    this.lineVAT = lineVAT;
  }

  public OrderLine lineDelivery(Float lineDelivery) {
    this.lineDelivery = lineDelivery;
    return this;
  }

  /**
   * The cost of the delivery on this line (optional)
   * minimum: 0
   * @return lineDelivery
   **/
  @ApiModelProperty(value = "The cost of the delivery on this line (optional)")
  
  @DecimalMin("0")  public Float getLineDelivery() {
    return lineDelivery;
  }

  public void setLineDelivery(Float lineDelivery) {
    this.lineDelivery = lineDelivery;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderLine orderLine = (OrderLine) o;
    return Objects.equals(this.lineNumber, orderLine.lineNumber) &&
        Objects.equals(this.stockCode, orderLine.stockCode) &&
        Objects.equals(this.quantity, orderLine.quantity) &&
        Objects.equals(this.lineCost, orderLine.lineCost) &&
        Objects.equals(this.lineVAT, orderLine.lineVAT) &&
        Objects.equals(this.lineDelivery, orderLine.lineDelivery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineNumber, stockCode, quantity, lineCost, lineVAT, lineDelivery);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderLine {\n");
    
    sb.append("    lineNumber: ").append(toIndentedString(lineNumber)).append("\n");
    sb.append("    stockCode: ").append(toIndentedString(stockCode)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    lineCost: ").append(toIndentedString(lineCost)).append("\n");
    sb.append("    lineVAT: ").append(toIndentedString(lineVAT)).append("\n");
    sb.append("    lineDelivery: ").append(toIndentedString(lineDelivery)).append("\n");
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
