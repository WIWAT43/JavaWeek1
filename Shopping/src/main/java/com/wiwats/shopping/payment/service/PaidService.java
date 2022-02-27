package com.wiwats.shopping.payment.service;

import com.wiwats.shopping.basket.model.Basket;
import com.wiwats.shopping.basket.repository.BasketRepository;
import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.payment.model.PayRequest;
import com.wiwats.shopping.payment.model.PaymentSummary;
import com.wiwats.shopping.payment.model.PaymentTransaction;
import com.wiwats.shopping.payment.model.UserPayment;
import com.wiwats.shopping.payment.repository.PaymentTransactionRepository;
import com.wiwats.shopping.payment.repository.UserPaymentRepository;
import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.model.UserAddressRequest;
import com.wiwats.shopping.user.repository.UserRepository;
import com.wiwats.shopping.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaidService {

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;
    @Autowired
    BasketRepository basketRepository;

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Autowired
    UserAddressService userAddressService;

    @Autowired
    UserRepository userRepository;

    public PaymentSummary paid(PayRequest payRequest){

        List<Basket> baskets = new ArrayList<>();

        for (Long basketId : payRequest.getBasketId()) {
            baskets.add(basketRepository.findById(basketId).get());
        }

     //Check Correct userID and get SumTotal
        Double sumTotal= Double.valueOf(0);
        for (Basket basket : baskets) {
            if (!basket.getUser().getUserId().equals(payRequest.getUserId())){
                throw new UserDataIncorrectException("601");
            }

            try {
                sumTotal = sumTotal+ (basket.getProductUnit()* basket.getProduct().getPrice());
            } catch (Exception e) {
                throw new UserDataIncorrectException("103");
            }
        }

       List<UserPayment> userPayments = userPaymentRepository.findByUserAndStatusActiveLike(new User(payRequest.getUserId()),1);

        if ( userPayments.size()== 0){
            throw new UserDataIncorrectException("701");
        }

        List<UserAddressRequest> userAddress = userAddressService.findAddressByUserIdAndStatus(payRequest.getUserId(),1);

        if ( userAddress.size()== 0){
            throw new UserDataIncorrectException("801");
        }

       PaymentTransaction paymentTransaction = new PaymentTransaction();

       paymentTransaction = paymentTransactionRepository.save(new PaymentTransaction(sumTotal,userPayments.get(0).getPaymentId()));

        for (Basket basket : baskets) {
            basket.addPaymentTransaction(paymentTransaction);
            basket.setUserAddressID(userAddress.get(0).getAddressId());
            basketRepository.save(basket);

        }

       User user = userRepository.getById(payRequest.getUserId());

        PaymentSummary paymentSummary = new PaymentSummary(paymentTransaction.getTransactionId(), paymentTransaction.getDateTime(),sumTotal,userPayments.get(0).getPaymentId(),user.getFullName(),userAddress.get(0).getFullAddress() );

        return paymentSummary;
    }
}
