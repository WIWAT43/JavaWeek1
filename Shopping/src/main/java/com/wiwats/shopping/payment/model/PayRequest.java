package com.wiwats.shopping.payment.model;

import lombok.Data;

import java.util.List;

@Data
public class PayRequest {

    private Long userId;
    private List<Long> basketId;

    public PayRequest() {
    }

    public PayRequest(Long userId, List<Long> basketId) {
        this.userId = userId;
        this.basketId = basketId;
    }
}
