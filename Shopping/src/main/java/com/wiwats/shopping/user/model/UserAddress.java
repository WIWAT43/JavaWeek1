package com.wiwats.shopping.user.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserAddress{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private String country;
	private int statusActive=0;

	public UserAddress() {
	}

	public UserAddress(UserAddressRequest userAddressRequest) {
		this.addressId = userAddressRequest.getAddressId();
		this.user = new User(userAddressRequest.getUserId());
		this.addressLine1 = userAddressRequest.getAddressLine1();
		this.addressLine2 = userAddressRequest.getAddressLine2();
		this.city = userAddressRequest.getCity();
		this.postalCode = userAddressRequest.getPostalCode();
		this.country = userAddressRequest.getCountry();
		this.statusActive= userAddressRequest.getStatusActive();
	}
}