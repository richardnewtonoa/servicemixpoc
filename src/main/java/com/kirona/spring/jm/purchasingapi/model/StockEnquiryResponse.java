package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirona.spring.jm.purchasingapi.model.SupplierStockItem;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Result of searching for supplier related stock details using a manufacture part code
 */
@ApiModel(description = "Result of searching for supplier related stock details using a manufacture part code")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class StockEnquiryResponse   {
  @JsonProperty("supplierStockItem")
  @Valid
  private List<SupplierStockItem> supplierStockItem = new ArrayList<>();

  public StockEnquiryResponse supplierStockItem(List<SupplierStockItem> supplierStockItem) {
    this.supplierStockItem = supplierStockItem;
    return this;
  }

  public StockEnquiryResponse addSupplierStockItemItem(SupplierStockItem supplierStockItemItem) {
    this.supplierStockItem.add(supplierStockItemItem);
    return this;
  }

  /**
   * Get supplierStockItem
   * @return supplierStockItem
   **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<SupplierStockItem> getSupplierStockItem() {
    return supplierStockItem;
  }

  public void setSupplierStockItem(List<SupplierStockItem> supplierStockItem) {
    this.supplierStockItem = supplierStockItem;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockEnquiryResponse stockEnquiryResponse = (StockEnquiryResponse) o;
    return Objects.equals(this.supplierStockItem, stockEnquiryResponse.supplierStockItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supplierStockItem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockEnquiryResponse {\n");
    
    sb.append("    supplierStockItem: ").append(toIndentedString(supplierStockItem)).append("\n");
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
