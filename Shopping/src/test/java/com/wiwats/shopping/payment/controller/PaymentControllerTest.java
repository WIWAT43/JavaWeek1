package com.wiwats.shopping.payment.controller;

import com.wiwats.shopping.payment.model.PayRequest;
import com.wiwats.shopping.payment.model.PaymentSummary;
import com.wiwats.shopping.payment.model.UserPayment;
import com.wiwats.shopping.payment.model.UserPaymentRequest;
import com.wiwats.shopping.product.model.ProductRespond;
import com.wiwats.shopping.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    UserPaymentRequest userPayment = new UserPaymentRequest(0,3L,1,"57654658","Card Name03",2,25,"321",1);

    @Test
    void addUserPayment() {

        String result = testRestTemplate.postForObject("/Payment/addUserPayment",userPayment,String.class);

        assertEquals("Success",result);
    }

    @Test
    void paid() {

        List<Long> basketId = new ArrayList<>();
        basketId.add(1L);
        basketId.add(2L);

        PayRequest payRequest=new PayRequest(1L,basketId);
        PaymentSummary result = testRestTemplate.postForObject("/Payment/paid",payRequest,PaymentSummary.class);
        assertEquals(1,result.getTransactionId());
        System.out.println(result);
    }

    @Test
    void getUserPaymentByUserIdAndStatus() {

        ResponseEntity<List> result
                = testRestTemplate.getForEntity("/Payment/getUserPaymentByUserIdAndStatus/1,1", List.class);
        assertEquals(200,result.getStatusCodeValue());
    }
}