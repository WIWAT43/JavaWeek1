package com.wiwats.shopping.product.model;

import com.wiwats.shopping.basket.model.Basket;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProductRespond {

    private Long productId;
    private String name;
    private String detail;
    private String image;
    private double price;

    public ProductRespond(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.detail = product.getDetail();
        this.image = product.getImage();
        this.price = product.getPrice();
    }
}
