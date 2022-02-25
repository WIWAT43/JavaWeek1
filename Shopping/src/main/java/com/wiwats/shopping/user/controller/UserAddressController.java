package com.wiwats.shopping.user.controller;

import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.user.model.UserAddressRequest;
import com.wiwats.shopping.user.model.UserRequest;
import com.wiwats.shopping.user.repository.UserAddressRepository;
import com.wiwats.shopping.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/userAddress")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @PostMapping(value = "/register")
    public UserAddressRequest registerAddress(@RequestBody UserAddressRequest userAddress) {
        return userAddressService.addAddress(userAddress);
    }

    @GetMapping("/findAddressByUserIdAndStatus/{userId},{statusActive}")
    public List<UserAddressRequest> findAddressByUserIdAndStatus(@PathVariable Long userId,@PathVariable int statusActive) {

      return   userAddressService.findAddressByUserIdAndStatus(userId,statusActive);
    }

}
