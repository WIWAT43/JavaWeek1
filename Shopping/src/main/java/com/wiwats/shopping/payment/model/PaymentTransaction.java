package com.wiwats.shopping.payment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String dateTime;
    private double totalPay;
    private int userPaymentId;

    public PaymentTransaction() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.dateTime = date.toString();
    }

    public PaymentTransaction(double totalPay,int userPaymentId) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.dateTime = date.toString();
        this.totalPay = totalPay;
        this.userPaymentId = userPaymentId;
    }


}
