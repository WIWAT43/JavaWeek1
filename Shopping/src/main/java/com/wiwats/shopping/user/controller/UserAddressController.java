package com.wiwats.shopping.user.controller;

import com.wiwats.shopping.user.model.UserAddressRequest;
import com.wiwats.shopping.user.model.UserRequest;
import com.wiwats.shopping.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/userAddress")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @PostMapping(value = "/register")
    public UserAddressRequest registerAddress(@RequestBody UserAddressRequest userAddress) {

        return userAddressService.addAddress(userAddress);
    }

}
