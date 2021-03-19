package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kirona.spring.jm.purchasingapi.model.RequisitionOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The details of a requisition from the external system
 */
@ApiModel(description = "The details of a requisition from the external system")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class GetRequisitionResponse   {
  @JsonProperty("requisitionId")
  private String requisitionId = null;

  /**
   * Status of the requisition in the purchasing system.
   */
  public enum StatusEnum {
    SUBMITTED("submitted"),
    
    AUTHORISED("authorised"),
    
    CANCELLED("cancelled");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("orders")
  @Valid
  private List<RequisitionOrder> orders = null;

  public GetRequisitionResponse requisitionId(String requisitionId) {
    this.requisitionId = requisitionId;
    return this;
  }

  /**
   * The external requisition ID
   * @return requisitionId
   **/
  @ApiModelProperty(required = true, value = "The external requisition ID")
      @NotNull

    public String getRequisitionId() {
    return requisitionId;
  }

  public void setRequisitionId(String requisitionId) {
    this.requisitionId = requisitionId;
  }

  public GetRequisitionResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the requisition in the purchasing system.
   * @return status
   **/
  @ApiModelProperty(required = true, value = "Status of the requisition in the purchasing system.")
      @NotNull

    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public GetRequisitionResponse orders(List<RequisitionOrder> orders) {
    this.orders = orders;
    return this;
  }

  public GetRequisitionResponse addOrdersItem(RequisitionOrder ordersItem) {
    if (this.orders == null) {
      this.orders = new ArrayList<>();
    }
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
   **/
  @ApiModelProperty(value = "")
      @Valid
    public List<RequisitionOrder> getOrders() {
    return orders;
  }

  public void setOrders(List<RequisitionOrder> orders) {
    this.orders = orders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetRequisitionResponse getRequisitionResponse = (GetRequisitionResponse) o;
    return Objects.equals(this.requisitionId, getRequisitionResponse.requisitionId) &&
        Objects.equals(this.status, getRequisitionResponse.status) &&
        Objects.equals(this.orders, getRequisitionResponse.orders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requisitionId, status, orders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetRequisitionResponse {\n");
    
    sb.append("    requisitionId: ").append(toIndentedString(requisitionId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    orders: ").append(toIndentedString(orders)).append("\n");
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
