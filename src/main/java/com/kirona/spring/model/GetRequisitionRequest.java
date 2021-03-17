package com.kirona.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRequisitionRequest {

  public String system;
  public String organisationId;
  public String requisitionId;
}
