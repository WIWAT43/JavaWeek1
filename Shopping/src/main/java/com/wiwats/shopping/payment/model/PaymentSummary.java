package com.wiwats.shopping.payment.model;

import lombok.Data;

@Data
public class PaymentSummary {

    private Long transactionId;
    private String dateTime;
    private double totalPay;
    private int userPaymentId;
    private String userFullName;
    private String address;

    public PaymentSummary() {
    }

    public PaymentSummary(Long transactionId, String dateTime, double totalPay, int userPaymentId, String userFullName, String address) {
        this.transactionId = transactionId;
        this.dateTime = dateTime;
        this.totalPay = totalPay;
        this.userPaymentId = userPaymentId;
        this.userFullName = userFullName;
        this.address = address;
    }
}
