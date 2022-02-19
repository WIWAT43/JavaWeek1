package com.wiwats.shopping.user.controller;

import com.wiwats.shopping.user.model.UserRequest;
import com.wiwats.shopping.user.model.UserRespond;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    UserRequest userRequest = new UserRequest("Wiwat","Sathornsawat","01234567890","wiwat_4","213321");
    HttpHeaders headers = new HttpHeaders();

    @Test
    void registerUser() {
        HttpEntity<UserRequest> request = new HttpEntity<>(userRequest, headers);
        UserRespond result = testRestTemplate.postForObject("/user/register",userRequest,UserRespond.class);
        assertEquals("200", result.getStatus());
    }

    @Test
    void registerUserDataInvalid() {
        HttpEntity<UserRequest> request = new HttpEntity<>(userRequest, headers);
        UserRespond result = testRestTemplate.postForObject("/user/register",userRequest,UserRespond.class);
        assertEquals("Username not available", result.getMessage());
    }
}