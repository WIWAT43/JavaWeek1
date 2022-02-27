package com.wiwats.shopping.payment.model;

import com.wiwats.shopping.user.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
public class UserPaymentReturn {

    private int paymentId;
    private Long userId;
    private int paymentType;
    private String cardNumber;
    private String cardName;
    private int monthExpire;
    private int yearExpire;
    private int statusActive=0;

    public UserPaymentReturn() {
    }

    public UserPaymentReturn(UserPayment userPayment) {
        this.paymentId = userPayment.getPaymentId();
        this.userId = userPayment.getUser().getUserId();
        this.paymentType = userPayment.getPaymentType();
        this.cardNumber = userPayment.getCardNumber();
        this.cardName = userPayment.getCardName();
        this.monthExpire =userPayment.getMonthExpire();
        this.yearExpire = userPayment.getYearExpire();
        this.statusActive = userPayment.getStatusActive();
    }
}
