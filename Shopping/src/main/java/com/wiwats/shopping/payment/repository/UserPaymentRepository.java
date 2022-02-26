package com.wiwats.shopping.payment.repository;

import com.wiwats.shopping.payment.model.UserPayment;
import com.wiwats.shopping.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Integer> {

    List<UserPayment> findByUserAndStatusActiveLike(User user,int status);

}
