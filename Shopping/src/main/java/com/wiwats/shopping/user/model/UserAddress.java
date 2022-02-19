package com.wiwats.shopping.user.model;

import lombok.Data;

@Data
public class UserAddress{
	private int addressId;
	private Long userId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private String country;

}