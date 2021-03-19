package com.kirona.spring.jm.purchasingapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirona.spring.jm.purchasingapi.model.GRNLine;
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
 * A Goods Received Note to be submitted to the purchasing system
 */
@ApiModel(description = "A Goods Received Note to be submitted to the purchasing system")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-18T08:40:04.204Z[GMT]")


public class SubmitGRNRequest   {
  @JsonProperty("goodsReceivedId")
  private Long goodsReceivedId = null;

  @JsonProperty("receivedDateTime")
  private OffsetDateTime receivedDateTime = null;

  @JsonProperty("receivingUser")
  private User receivingUser = null;

  @JsonProperty("receivedLines")
  @Valid
  private List<GRNLine> receivedLines = new ArrayList<>();

  public SubmitGRNRequest goodsReceivedId(Long goodsReceivedId) {
    this.goodsReceivedId = goodsReceivedId;
    return this;
  }

  /**
   * The Job Manager GoodsReceived record ID
   * @return goodsReceivedId
   **/
  @ApiModelProperty(required = true, value = "The Job Manager GoodsReceived record ID")
      @NotNull

    public Long getGoodsReceivedId() {
    return goodsReceivedId;
  }

  public void setGoodsReceivedId(Long goodsReceivedId) {
    this.goodsReceivedId = goodsReceivedId;
  }

  public SubmitGRNRequest receivedDateTime(OffsetDateTime receivedDateTime) {
    this.receivedDateTime = receivedDateTime;
    return this;
  }

  /**
   * The date and time the GRN was received in JM
   * @return receivedDateTime
   **/
  @ApiModelProperty(required = true, value = "The date and time the GRN was received in JM")
      @NotNull

    @Valid
    public OffsetDateTime getReceivedDateTime() {
    return receivedDateTime;
  }

  public void setReceivedDateTime(OffsetDateTime receivedDateTime) {
    this.receivedDateTime = receivedDateTime;
  }

  public SubmitGRNRequest receivingUser(User receivingUser) {
    this.receivingUser = receivingUser;
    return this;
  }

  /**
   * Get receivingUser
   * @return receivingUser
   **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public User getReceivingUser() {
    return receivingUser;
  }

  public void setReceivingUser(User receivingUser) {
    this.receivingUser = receivingUser;
  }

  public SubmitGRNRequest receivedLines(List<GRNLine> receivedLines) {
    this.receivedLines = receivedLines;
    return this;
  }

  public SubmitGRNRequest addReceivedLinesItem(GRNLine receivedLinesItem) {
    this.receivedLines.add(receivedLinesItem);
    return this;
  }

  /**
   * Get receivedLines
   * @return receivedLines
   **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<GRNLine> getReceivedLines() {
    return receivedLines;
  }

  public void setReceivedLines(List<GRNLine> receivedLines) {
    this.receivedLines = receivedLines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitGRNRequest submitGRNRequest = (SubmitGRNRequest) o;
    return Objects.equals(this.goodsReceivedId, submitGRNRequest.goodsReceivedId) &&
        Objects.equals(this.receivedDateTime, submitGRNRequest.receivedDateTime) &&
        Objects.equals(this.receivingUser, submitGRNRequest.receivingUser) &&
        Objects.equals(this.receivedLines, submitGRNRequest.receivedLines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goodsReceivedId, receivedDateTime, receivingUser, receivedLines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitGRNRequest {\n");
    
    sb.append("    goodsReceivedId: ").append(toIndentedString(goodsReceivedId)).append("\n");
    sb.append("    receivedDateTime: ").append(toIndentedString(receivedDateTime)).append("\n");
    sb.append("    receivingUser: ").append(toIndentedString(receivingUser)).append("\n");
    sb.append("    receivedLines: ").append(toIndentedString(receivedLines)).append("\n");
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
