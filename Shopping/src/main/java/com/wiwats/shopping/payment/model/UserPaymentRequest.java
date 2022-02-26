package com.wiwats.shopping.payment.model;

import lombok.Data;

@Data
public class UserPaymentRequest {

    private int paymentId;
    private Long userId;
    private int paymentType;
    private String cardNumber;
    private String cardName;
    private int monthExpire;
    private int yearExpire;
    private String ccv;
    private int statusActive=0;
}
