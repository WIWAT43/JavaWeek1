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

    public UserPaymentRequest() {
    }

    public UserPaymentRequest(int paymentId, Long userId, int paymentType, String cardNumber, String cardName, int monthExpire, int yearExpire, String ccv, int statusActive) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.monthExpire = monthExpire;
        this.yearExpire = yearExpire;
        this.ccv = ccv;
        this.statusActive = statusActive;
    }
}
