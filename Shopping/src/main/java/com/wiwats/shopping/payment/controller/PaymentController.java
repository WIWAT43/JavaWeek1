package com.wiwats.shopping.payment.controller;


import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.payment.model.PayRequest;
import com.wiwats.shopping.payment.model.UserPayment;
import com.wiwats.shopping.payment.model.UserPaymentRequest;
import com.wiwats.shopping.payment.repository.UserPaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/Payment")
public class PaymentController {

    @Autowired
    UserPaymentRepository userPaymentRepository;


    @PostMapping(value = "/addUserPayment")
    public String addUserPayment(@RequestBody UserPaymentRequest userPaymentRequest){
      UserPayment userPayment = new UserPayment();
      userPayment = userPaymentRepository.save(new UserPayment(userPaymentRequest));

      if (userPayment.equals(null)) {
          throw new UserDataIncorrectException("501");
      }
      return "Success";
    }


    @PostMapping(value = "/paid")
    public void paid(@RequestBody PayRequest payRequest){

    }

}
