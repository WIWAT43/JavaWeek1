package com.wiwats.shopping.user.model;

import lombok.Data;

@Data
public class UserRespond {
    private Long userId;
    private String userName;
    private String message;
    private String status;

    public void setRespond(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();


    }
}
