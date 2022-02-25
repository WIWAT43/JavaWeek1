package com.wiwats.shopping.payment.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long userId;
    private int paymentType;
    private String cardNumber;
    private String cardName;
    private int monthExpire;
    private int yearExpire;
    private String ccv;
    private int statusActive=0;
}
