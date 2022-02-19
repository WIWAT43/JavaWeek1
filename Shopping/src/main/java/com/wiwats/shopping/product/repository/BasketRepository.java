package com.wiwats.shopping.product.repository;

import com.wiwats.shopping.product.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
}
