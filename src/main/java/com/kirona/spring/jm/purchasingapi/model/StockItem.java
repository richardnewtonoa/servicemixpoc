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
 * A single stock item
 */
@ApiModel(description = "A single stock item")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class StockItem   {
  @JsonProperty("stockCode")
  private String stockCode = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("extSupplierId")
  private String extSupplierId = null;

  @JsonProperty("extSupplierPartCode")
  private String extSupplierPartCode = null;

  public StockItem stockCode(String stockCode) {
    this.stockCode = stockCode;
    return this;
  }

  /**
   * The JM stock code (manufacturer part number)
   * @return stockCode
   **/
  @ApiModelProperty(required = true, value = "The JM stock code (manufacturer part number)")
      @NotNull

    public String getStockCode() {
    return stockCode;
  }

  public void setStockCode(String stockCode) {
    this.stockCode = stockCode;
  }

  public StockItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * The quantity (integer) of this item, which must be 1 or more
   * minimum: 1
   * @return quantity
   **/
  @ApiModelProperty(required = true, value = "The quantity (integer) of this item, which must be 1 or more")
      @NotNull

  @Min(1)  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public StockItem extSupplierId(String extSupplierId) {
    this.extSupplierId = extSupplierId;
    return this;
  }

  /**
   * ID (in the external system) of the supplier
   * @return extSupplierId
   **/
  @ApiModelProperty(value = "ID (in the external system) of the supplier")
  
    public String getExtSupplierId() {
    return extSupplierId;
  }

  public void setExtSupplierId(String extSupplierId) {
    this.extSupplierId = extSupplierId;
  }

  public StockItem extSupplierPartCode(String extSupplierPartCode) {
    this.extSupplierPartCode = extSupplierPartCode;
    return this;
  }

  /**
   * The supplier specific part number for this stock code
   * @return extSupplierPartCode
   **/
  @ApiModelProperty(value = "The supplier specific part number for this stock code")
  
    public String getExtSupplierPartCode() {
    return extSupplierPartCode;
  }

  public void setExtSupplierPartCode(String extSupplierPartCode) {
    this.extSupplierPartCode = extSupplierPartCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockItem stockItem = (StockItem) o;
    return Objects.equals(this.stockCode, stockItem.stockCode) &&
        Objects.equals(this.quantity, stockItem.quantity) &&
        Objects.equals(this.extSupplierId, stockItem.extSupplierId) &&
        Objects.equals(this.extSupplierPartCode, stockItem.extSupplierPartCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stockCode, quantity, extSupplierId, extSupplierPartCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockItem {\n");
    
    sb.append("    stockCode: ").append(toIndentedString(stockCode)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    extSupplierId: ").append(toIndentedString(extSupplierId)).append("\n");
    sb.append("    extSupplierPartCode: ").append(toIndentedString(extSupplierPartCode)).append("\n");
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
