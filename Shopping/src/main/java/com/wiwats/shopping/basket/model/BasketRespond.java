package com.wiwats.shopping.basket.model;

import lombok.Data;

@Data
public class BasketRespond {

    private Long basketId;
    private Long userId;
    private String userName;
    private Long productId;
    private String productName;
    private String detail;
    private String image;
    private double price;

    private int productUnit=0;

    public void SetBasketRespondByBasket(Basket basket) {
        this.basketId = basket.getBasketId();
        this.userId = basket.getUser().getUserId();
        this.userName = basket.getUser().getUserName();
        this.productId = basket.getProduct().getProductId();
        this.productName = basket.getProduct().getName();
        this.detail = basket.getProduct().getDetail();
        this.image = basket.getProduct().getImage();
        this.price = basket.getProduct().getPrice();
        this.productUnit = basket.getProductUnit();
    }
}
