package com.wiwats.shopping.payment.model;

import com.wiwats.shopping.user.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int paymentType;
    private String cardNumber;
    private String cardName;
    private int monthExpire;
    private int yearExpire;
    private String ccv;
    private int statusActive=0;


    public UserPayment(User user, int paymentType, String cardNumber, String cardName, int monthExpire, int yearExpire, String ccv, int statusActive) {
        this.user = user;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.monthExpire = monthExpire;
        this.yearExpire = yearExpire;
        this.ccv = ccv;
        this.statusActive = statusActive;
    }

    public UserPayment() {
    }

    public UserPayment(UserPaymentRequest up) {
        this.user = new User(up.getUserId());
        this.paymentType = up.getPaymentType();
        this.cardNumber = up.getCardNumber();
        this.cardName = up.getCardName();
        this.monthExpire = up.getMonthExpire();
        this.yearExpire = up.getYearExpire();
        this.ccv = up.getCcv();
        this.statusActive = up.getStatusActive();
    }
}
