package com.wiwats.shopping.product.repository;
import com.wiwats.shopping.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNameContainingIgnoreCase(String productName);

    @Query("SELECT DISTINCT p FROM Product p JOIN p.baskets bk LEFT JOIN bk.user u  WHERE u.userId LIKE ?1")
     List<Product> findByUserBasket(Long userId);
}
