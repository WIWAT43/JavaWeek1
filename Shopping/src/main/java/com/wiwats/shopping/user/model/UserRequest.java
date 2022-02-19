package com.wiwats.shopping.user.model;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String firstName;
    private String lastName;
    private String telephone;
    private String userName;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String firstName, String lastName, String telephone, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.userName = userName;
        this.password = password;
    }
}
