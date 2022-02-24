package com.wiwats.shopping.user.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserAddress{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private String country;

}