package com.wiwats.shopping.product.controller;


import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.product.model.Basket;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.repository.BasketRepository;
import com.wiwats.shopping.product.repository.ProductRepository;
import com.wiwats.shopping.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/basket")
public class BasketController {

    @Autowired
    BasketRepository basketRepository;


    @GetMapping("/findAll")
    public List<Basket> findByUserId(){

        return basketRepository.findAll();
    }


//    @GetMapping("/findByUserId/{userId}")
//    public List<Product> findByUserId(String userId){
//        log.info("BasketController findByUserId - "+ userId);
//
//        long userIdNumber;
//        try {
//            userIdNumber = Long.parseLong(userId);
//        } catch (Exception e) {
//            throw new UserDataIncorrectException("101");
//        }
//        ProductService productService = new ProductService();
//
//        return productService.);
//    }
}
