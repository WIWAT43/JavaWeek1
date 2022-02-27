package com.wiwats.shopping.payment.controller;


import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.payment.model.*;
import com.wiwats.shopping.payment.repository.UserPaymentRepository;
import com.wiwats.shopping.payment.service.PaidService;
import com.wiwats.shopping.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/Payment")
public class PaymentController {

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Autowired
    PaidService paidService;

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
    public PaymentSummary paid(@RequestBody PayRequest payRequest){

        return paidService.paid(payRequest);
    }

    @GetMapping("/getUserPaymentByUserIdAndStatus/{userId},{status}")
    public List<UserPaymentReturn> getUserPaymentByUserIdAndStatus(@PathVariable Long userId,@PathVariable  int status){

        List<UserPayment> userPayment = userPaymentRepository.findByUserAndStatusActiveLike(new User(userId),status);
    List<UserPaymentReturn> userPaymentReturns = new ArrayList<>();

        for (UserPayment payment : userPayment) {
            userPaymentReturns.add( new UserPaymentReturn(payment));
        }

        return userPaymentReturns;
    }

}
