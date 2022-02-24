package com.wiwats.shopping.basket.model;

import com.wiwats.shopping.product.model.Product;

import java.util.List;

public class BasketRespondList {

    private Long basketId;
    private Long userId;
    private String userName;
    private List<Product> product ;


    private int productUnit=0;
}
