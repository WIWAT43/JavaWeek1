package com.wiwats.shopping.user.controller;

import com.wiwats.shopping.user.model.UserAddressRequest;
import com.wiwats.shopping.user.model.UserRequest;
import com.wiwats.shopping.user.model.UserRespond;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserAddressControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    UserAddressRequest userAddressRequest = new UserAddressRequest(1L,"Test address Line2","Test address Line2","Bangkok","10000","ThaiLand",0);
    HttpHeaders headers = new HttpHeaders();

    @Test
    void registerAddress() {

        UserAddressRequest result = testRestTemplate.postForObject("/userAddress/register",userAddressRequest,UserAddressRequest.class);
        assertNotEquals(0,result.getAddressId());

    }

    @Test
    void findAddressByUserIdAndStatus() {

        ResponseEntity<List> result
                = testRestTemplate.getForEntity("/userAddress/findAddressByUserIdAndStatus/1,1", List.class);

        assertEquals(200,result.getStatusCodeValue());

    }
}