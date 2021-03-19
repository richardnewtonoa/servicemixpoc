package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirona.spring.jm.purchasingapi.model.StockItem;
import com.kirona.spring.jm.purchasingapi.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Data required to submit a new requisition
 */
@ApiModel(description = "Data required to submit a new requisition")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class SubmitRequisitionRequest   {
  @JsonProperty("stockRequestGroupId")
  private Long stockRequestGroupId = null;

  @JsonProperty("requestor")
  private User requestor = null;

  @JsonProperty("jobId")
  private Long jobId = null;

  @JsonProperty("requestedDateTime")
  private OffsetDateTime requestedDateTime = null;

  @JsonProperty("deliveryAddress")
  private String deliveryAddress = null;

  @JsonProperty("stockItems")
  @Valid
  private List<StockItem> stockItems = new ArrayList<>();

  public SubmitRequisitionRequest stockRequestGroupId(Long stockRequestGroupId) {
    this.stockRequestGroupId = stockRequestGroupId;
    return this;
  }

  /**
   * The requisition ID from JM
   * @return stockRequestGroupId
   **/
  @ApiModelProperty(required = true, value = "The requisition ID from JM")
      @NotNull

    public Long getStockRequestGroupId() {
    return stockRequestGroupId;
  }

  public void setStockRequestGroupId(Long stockRequestGroupId) {
    this.stockRequestGroupId = stockRequestGroupId;
  }

  public SubmitRequisitionRequest requestor(User requestor) {
    this.requestor = requestor;
    return this;
  }

  /**
   * Get requestor
   * @return requestor
   **/
  @ApiModelProperty(value = "")
  
    @Valid
    public User getRequestor() {
    return requestor;
  }

  public void setRequestor(User requestor) {
    this.requestor = requestor;
  }

  public SubmitRequisitionRequest jobId(Long jobId) {
    this.jobId = jobId;
    return this;
  }

  /**
   * If the requisition relates to a specific job, the ID will be here
   * @return jobId
   **/
  @ApiModelProperty(value = "If the requisition relates to a specific job, the ID will be here")
  
    public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public SubmitRequisitionRequest requestedDateTime(OffsetDateTime requestedDateTime) {
    this.requestedDateTime = requestedDateTime;
    return this;
  }

  /**
   * The date and time the requisition was made in JM
   * @return requestedDateTime
   **/
  @ApiModelProperty(required = true, value = "The date and time the requisition was made in JM")
      @NotNull

    @Valid
    public OffsetDateTime getRequestedDateTime() {
    return requestedDateTime;
  }

  public void setRequestedDateTime(OffsetDateTime requestedDateTime) {
    this.requestedDateTime = requestedDateTime;
  }

  public SubmitRequisitionRequest deliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
    return this;
  }

  /**
   * If a delivery address is specified for the requisition it will be here. If not present, this is a collection request.
   * @return deliveryAddress
   **/
  @ApiModelProperty(value = "If a delivery address is specified for the requisition it will be here. If not present, this is a collection request.")
  
    public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public SubmitRequisitionRequest stockItems(List<StockItem> stockItems) {
    this.stockItems = stockItems;
    return this;
  }

  public SubmitRequisitionRequest addStockItemsItem(StockItem stockItemsItem) {
    this.stockItems.add(stockItemsItem);
    return this;
  }

  /**
   * Get stockItems
   * @return stockItems
   **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<StockItem> getStockItems() {
    return stockItems;
  }

  public void setStockItems(List<StockItem> stockItems) {
    this.stockItems = stockItems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitRequisitionRequest submitRequisitionRequest = (SubmitRequisitionRequest) o;
    return Objects.equals(this.stockRequestGroupId, submitRequisitionRequest.stockRequestGroupId) &&
        Objects.equals(this.requestor, submitRequisitionRequest.requestor) &&
        Objects.equals(this.jobId, submitRequisitionRequest.jobId) &&
        Objects.equals(this.requestedDateTime, submitRequisitionRequest.requestedDateTime) &&
        Objects.equals(this.deliveryAddress, submitRequisitionRequest.deliveryAddress) &&
        Objects.equals(this.stockItems, submitRequisitionRequest.stockItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stockRequestGroupId, requestor, jobId, requestedDateTime, deliveryAddress, stockItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitRequisitionRequest {\n");
    
    sb.append("    stockRequestGroupId: ").append(toIndentedString(stockRequestGroupId)).append("\n");
    sb.append("    requestor: ").append(toIndentedString(requestor)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    requestedDateTime: ").append(toIndentedString(requestedDateTime)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
    sb.append("    stockItems: ").append(toIndentedString(stockItems)).append("\n");
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
