package com.kirona.spring.jm.purchasingapi.cloudmarketplace;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

import com.kirona.spring.cloudmarketplace.client.po.model.PurchaseOrder;
import com.kirona.spring.jm.purchasingapi.model.GetOrderResponse;

import lombok.extern.slf4j.Slf4j;

// https://camel.apache.org/manual/latest/type-converter.html
@Slf4j
public class CMtoJMConverters implements TypeConverters {

  @Converter(allowNull = true)
  public static GetOrderResponse orderCmToJm(PurchaseOrder po) {
    log.info("Converting PO : " + po);
    
    if (po == null) { return null; }

    GetOrderResponse r = new GetOrderResponse();
    r.setOrderId(po.getId().toString());
    r.setRequisitionId(po.getRequisitionId());
    // TODO : lines
    
    return r;
  }
}
