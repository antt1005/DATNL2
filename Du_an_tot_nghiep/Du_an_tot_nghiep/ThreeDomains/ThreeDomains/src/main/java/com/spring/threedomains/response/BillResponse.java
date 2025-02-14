package com.spring.threedomains.response;

import java.math.BigDecimal;
import java.util.Date;

public interface BillResponse {
    Integer getId();
    String getCode();
    Date getPurchaseDate();
    Date getEstimatedDate();
    Date getPaymentDate();
    Date getDelyveryDate();
    BigDecimal getTotalPrice();
    BigDecimal getShipPrice();
    BigDecimal getTotalPriceLast();
    String getNote();
    Integer getPayType();
    Integer getPayStatus();
    Integer getIdCoupon();
    Integer getIdAddress();
    Integer getIdCustomer();
    Integer getIdVoucher();
    Integer getIdEmployee();
    Integer getStatus();
    Integer getTypeStatus();
}
