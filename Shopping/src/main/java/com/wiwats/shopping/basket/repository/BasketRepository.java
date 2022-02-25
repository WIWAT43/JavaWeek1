package com.wiwats.shopping.basket.repository;

import com.wiwats.shopping.basket.model.Basket;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {

    List<Basket> findByUser(User user);

    List<Basket> findByUserAndPaymentStatusLike(User user,int paymentStatus);
}