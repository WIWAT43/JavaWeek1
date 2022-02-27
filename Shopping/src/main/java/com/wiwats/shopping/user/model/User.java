package com.wiwats.shopping.user.model;

import com.wiwats.shopping.basket.model.Basket;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String modifiedADate;
	private String lastName;
	private String firstName;
	private String telephone;
	private String userName;
	private String createdDate;
	private String password;

	public User(Long userId) {
		this.userId = userId;
	}

//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Basket> baskets = new HashSet<>();

//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<UserAddress> userAddresses = new HashSet<>();


	public void setUserFromRequest(UserRequest userRequest) {
		this.userId = userRequest.getUserId();
		this.lastName = userRequest.getLastName();
		this.firstName = userRequest.getFirstName();
		this.telephone = userRequest.getTelephone();
		this.userName = userRequest.getUserName();
		this.password = userRequest.getPassword();
	}

	public User() {
	}

	public User(String modifiedADate, String lastName, String firstName, String telephone, String userName, String createdDate, String password) {
		this.modifiedADate = modifiedADate;
		this.lastName = lastName;
		this.firstName = firstName;
		this.telephone = telephone;
		this.userName = userName;
		this.createdDate = createdDate;
		this.password = password;
	}

	public String getFullName() {
		return firstName +" "+lastName;
	}

}