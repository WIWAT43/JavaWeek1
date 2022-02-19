package com.wiwats.shopping.user.model;

import lombok.Data;

@Data
public class UserPayment{
	private int UserPaymentId;
	private int userId;
	private int paymentTypeId;
	private String accountNo;
	private String expiry;

}