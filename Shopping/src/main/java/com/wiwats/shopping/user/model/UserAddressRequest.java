package com.wiwats.shopping.user.model;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class UserAddressRequest {

    private Long addressId;
    private Long userId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String country;
    private int statusActive;


    public UserAddressRequest(Long userId, String addressLine1, String addressLine2, String city, String postalCode, String country, int statusActive) {
        this.userId = userId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.statusActive = statusActive;
    }

    public UserAddressRequest() {
    }

    public UserAddressRequest(UserAddress userAddress) {
        this.addressId = userAddress.getAddressId();
        this.userId = userAddress.getUser().getUserId();
        this.addressLine1 = userAddress.getAddressLine1();
        this.addressLine2 = userAddress.getAddressLine2();
        this.city = userAddress.getCity();
        this.postalCode = userAddress.getPostalCode();
        this.country = userAddress.getCountry();
        this.statusActive = userAddress.getStatusActive();
    }

    public String getFullAddress() {
        return this.addressLine1+" "+this.addressLine2+" "+this.city+" "+this.postalCode+" "+this.country;
    }


}
