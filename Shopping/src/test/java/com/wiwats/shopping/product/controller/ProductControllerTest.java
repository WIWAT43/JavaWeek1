package com.wiwats.shopping.product.controller;

import com.wiwats.shopping.product.model.ProductRespond;
import com.wiwats.shopping.user.model.UserAddressRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    HttpHeaders headers = new HttpHeaders();
    ProductRespond productRespond = new ProductRespond(0L,"Test Product01","fortest","http://xxx",300);

    @Test
    void findAllProduct() {
        ResponseEntity<List> result
                = testRestTemplate.getForEntity("/product/findAllProduct", List.class);

        assertEquals(200,result.getStatusCodeValue());

    }

    @Test
    void findByNameContaining() {

        ProductRespond result = testRestTemplate.postForObject("/product/findByNameContaining","Product01",ProductRespond.class);
        assertNotEquals(1L,result.getProductId());
    }

    @Test
    void findById() {

        ProductRespond result = testRestTemplate.getForObject("/product/findById/1",ProductRespond.class);

        assertEquals("Product01",result.getName());

    }

    @Test
    void addProduct() {

        ProductRespond result = testRestTemplate.postForObject("/product/addProduct",productRespond,ProductRespond.class);

        assertEquals("Test Product01",result.getName());
    }
}