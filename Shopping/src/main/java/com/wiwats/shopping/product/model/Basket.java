package com.wiwats.shopping.product.model;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;

    private Long userId;
    private Long productId;

    private int productUnit;




    public Basket() {
    }

    public Basket(Long basketId,Long userId, Long productId,int productUnit) {
        this.basketId = basketId;
        this.userId = userId;
        this.productId = productId;
        this.productUnit = productUnit;
    }
}
