package com.kirona.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRequisitionRequest extends SystemAndOrg {
  public String requisitionId;
}
