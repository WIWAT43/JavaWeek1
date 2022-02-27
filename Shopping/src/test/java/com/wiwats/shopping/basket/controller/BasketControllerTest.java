package com.wiwats.shopping.basket.controller;

import com.wiwats.shopping.basket.model.BasketRequest;
import com.wiwats.shopping.basket.model.BasketRespond;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    BasketRequest basketRequest = new BasketRequest(0L,1L,1L,5);

    @Test
    void addProductToBasket() {

        BasketRespond result = testRestTemplate.postForObject("/basket/addProductToBasket",basketRequest,BasketRespond.class);

        assertNotEquals(0,result.getBasketId());
    }

    @Test
    void findBasketByUserIdNotPayYet() {

        ResponseEntity<List> result
                = testRestTemplate.getForEntity("/basket/findByUserId/1", List.class);
        assertEquals(200,result.getStatusCodeValue());
    }
}