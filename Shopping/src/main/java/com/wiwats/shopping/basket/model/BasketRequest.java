package com.wiwats.shopping.basket.model;

import lombok.Data;

@Data
public class BasketRequest {

    private Long basketId;
    private Long userId;
    private Long productId;
    private int productUnit;

    public BasketRequest(Long basketId,Long userId, Long productId, int productUnit) {
        this.basketId = basketId;
        this.userId = userId;
        this.productId = productId;
        this.productUnit = productUnit;
    }

    public BasketRequest() {
    }
}
