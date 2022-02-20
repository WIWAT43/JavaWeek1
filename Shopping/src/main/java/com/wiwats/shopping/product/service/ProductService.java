package com.wiwats.shopping.product.service;

import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

   @Autowired
    ProductRepository productRepository;

   public List<Product> findByUserInBasket (Long userId){
      return productRepository.findByUserBasket(userId);
   }

}
