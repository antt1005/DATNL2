package com.spring.threedomains.response;

import java.util.Date;

public interface BillHistoryResponse {
    Date getCreateDate();
    String getCreateBy();
    String getNote();
    Integer getStatus();


}
