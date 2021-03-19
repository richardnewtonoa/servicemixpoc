package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details of a stock item available from a supplier
 */
@ApiModel(description = "Details of a stock item available from a supplier")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class SupplierStockItem   {
  @JsonProperty("extSupplierId")
  private String extSupplierId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("collectionAvailable")
  private Boolean collectionAvailable = null;

  @JsonProperty("cost")
  private BigDecimal cost = null;

  @JsonProperty("deliveryCharge")
  private BigDecimal deliveryCharge = null;

  @JsonProperty("leadTimeInDays")
  private Integer leadTimeInDays = null;

  @JsonProperty("minOrderQuantity")
  private Integer minOrderQuantity = null;

  @JsonProperty("extSupplierPartCode")
  private String extSupplierPartCode = null;

  @JsonProperty("catalogId")
  private String catalogId = null;

  public SupplierStockItem extSupplierId(String extSupplierId) {
    this.extSupplierId = extSupplierId;
    return this;
  }

  /**
   * ID (in the external system) of the supplier
   * @return extSupplierId
   **/
  @ApiModelProperty(required = true, value = "ID (in the external system) of the supplier")
      @NotNull

    public String getExtSupplierId() {
    return extSupplierId;
  }

  public void setExtSupplierId(String extSupplierId) {
    this.extSupplierId = extSupplierId;
  }

  public SupplierStockItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the stock item in the supplier catalog (optional)
   * @return name
   **/
  @ApiModelProperty(value = "The name of the stock item in the supplier catalog (optional)")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SupplierStockItem description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the stock item in the supplier catalog (optional)
   * @return description
   **/
  @ApiModelProperty(value = "The description of the stock item in the supplier catalog (optional)")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SupplierStockItem collectionAvailable(Boolean collectionAvailable) {
    this.collectionAvailable = collectionAvailable;
    return this;
  }

  /**
   * true if collection is available for this item from this supplier
   * @return collectionAvailable
   **/
  @ApiModelProperty(value = "true if collection is available for this item from this supplier")
  
    public Boolean isCollectionAvailable() {
    return collectionAvailable;
  }

  public void setCollectionAvailable(Boolean collectionAvailable) {
    this.collectionAvailable = collectionAvailable;
  }

  public SupplierStockItem cost(BigDecimal cost) {
    this.cost = cost;
    return this;
  }

  /**
   * The cost of purchasing the item from this supplier
   * minimum: 0
   * @return cost
   **/
  @ApiModelProperty(required = true, value = "The cost of purchasing the item from this supplier")
      @NotNull

    @Valid
  @DecimalMin("0")  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  public SupplierStockItem deliveryCharge(BigDecimal deliveryCharge) {
    this.deliveryCharge = deliveryCharge;
    return this;
  }

  /**
   * The delivery charge for this item from this supplier
   * minimum: 0
   * @return deliveryCharge
   **/
  @ApiModelProperty(value = "The delivery charge for this item from this supplier")
  
    @Valid
  @DecimalMin("0")  public BigDecimal getDeliveryCharge() {
    return deliveryCharge;
  }

  public void setDeliveryCharge(BigDecimal deliveryCharge) {
    this.deliveryCharge = deliveryCharge;
  }

  public SupplierStockItem leadTimeInDays(Integer leadTimeInDays) {
    this.leadTimeInDays = leadTimeInDays;
    return this;
  }

  /**
   * The lead time (in days) to order this item from this supplier
   * minimum: 0
   * @return leadTimeInDays
   **/
  @ApiModelProperty(value = "The lead time (in days) to order this item from this supplier")
  
  @Min(0)  public Integer getLeadTimeInDays() {
    return leadTimeInDays;
  }

  public void setLeadTimeInDays(Integer leadTimeInDays) {
    this.leadTimeInDays = leadTimeInDays;
  }

  public SupplierStockItem minOrderQuantity(Integer minOrderQuantity) {
    this.minOrderQuantity = minOrderQuantity;
    return this;
  }

  /**
   * The minimum order quantity for this item from this supplier
   * minimum: 0
   * @return minOrderQuantity
   **/
  @ApiModelProperty(value = "The minimum order quantity for this item from this supplier")
  
  @Min(0)  public Integer getMinOrderQuantity() {
    return minOrderQuantity;
  }

  public void setMinOrderQuantity(Integer minOrderQuantity) {
    this.minOrderQuantity = minOrderQuantity;
  }

  public SupplierStockItem extSupplierPartCode(String extSupplierPartCode) {
    this.extSupplierPartCode = extSupplierPartCode;
    return this;
  }

  /**
   * The supplier specific part number for this stock code
   * @return extSupplierPartCode
   **/
  @ApiModelProperty(required = true, value = "The supplier specific part number for this stock code")
      @NotNull

    public String getExtSupplierPartCode() {
    return extSupplierPartCode;
  }

  public void setExtSupplierPartCode(String extSupplierPartCode) {
    this.extSupplierPartCode = extSupplierPartCode;
  }

  public SupplierStockItem catalogId(String catalogId) {
    this.catalogId = catalogId;
    return this;
  }

  /**
   * The ID of the catalog that this stock item relates to
   * @return catalogId
   **/
  @ApiModelProperty(value = "The ID of the catalog that this stock item relates to")
  
    public String getCatalogId() {
    return catalogId;
  }

  public void setCatalogId(String catalogId) {
    this.catalogId = catalogId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupplierStockItem supplierStockItem = (SupplierStockItem) o;
    return Objects.equals(this.extSupplierId, supplierStockItem.extSupplierId) &&
        Objects.equals(this.name, supplierStockItem.name) &&
        Objects.equals(this.description, supplierStockItem.description) &&
        Objects.equals(this.collectionAvailable, supplierStockItem.collectionAvailable) &&
        Objects.equals(this.cost, supplierStockItem.cost) &&
        Objects.equals(this.deliveryCharge, supplierStockItem.deliveryCharge) &&
        Objects.equals(this.leadTimeInDays, supplierStockItem.leadTimeInDays) &&
        Objects.equals(this.minOrderQuantity, supplierStockItem.minOrderQuantity) &&
        Objects.equals(this.extSupplierPartCode, supplierStockItem.extSupplierPartCode) &&
        Objects.equals(this.catalogId, supplierStockItem.catalogId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extSupplierId, name, description, collectionAvailable, cost, deliveryCharge, leadTimeInDays, minOrderQuantity, extSupplierPartCode, catalogId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupplierStockItem {\n");
    
    sb.append("    extSupplierId: ").append(toIndentedString(extSupplierId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    collectionAvailable: ").append(toIndentedString(collectionAvailable)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    deliveryCharge: ").append(toIndentedString(deliveryCharge)).append("\n");
    sb.append("    leadTimeInDays: ").append(toIndentedString(leadTimeInDays)).append("\n");
    sb.append("    minOrderQuantity: ").append(toIndentedString(minOrderQuantity)).append("\n");
    sb.append("    extSupplierPartCode: ").append(toIndentedString(extSupplierPartCode)).append("\n");
    sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
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
