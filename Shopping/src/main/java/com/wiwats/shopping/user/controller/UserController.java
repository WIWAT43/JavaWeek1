package com.wiwats.shopping.user.controller;

import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.model.UserRequest;
import com.wiwats.shopping.user.model.UserRespond;
import com.wiwats.shopping.user.repository.UserRepository;
import com.wiwats.shopping.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/register")
    public UserRespond registerUser(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @GetMapping("/findByUserName/{userName}")
    public Optional<User> findByUserName(@PathVariable  String userName){

        return userService.findByUserName(userName);
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
