package com.wiwats.shopping.payment.model;

import lombok.Data;

import java.util.List;

@Data
public class PayRequest {

    private Long userId;
    private List<Long> basketId;
}
