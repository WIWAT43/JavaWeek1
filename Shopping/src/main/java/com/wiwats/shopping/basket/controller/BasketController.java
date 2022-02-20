package com.wiwats.shopping.basket.controller;


import com.wiwats.shopping.basket.model.Basket;
import com.wiwats.shopping.basket.model.BasketRequest;
import com.wiwats.shopping.basket.model.BasketRespond;
import com.wiwats.shopping.basket.repository.BasketRepository;
import com.wiwats.shopping.basket.service.BasketService;
import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.service.ProductService;
import com.wiwats.shopping.user.model.User;
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
    @Autowired
    BasketService basketService;

    @Autowired
    ProductService productService;


    @PostMapping(value = "/addProductToBasket")
    public BasketRespond addProductToBasket (@RequestBody BasketRequest basketRequest){

        log.info("BasketController addProductToBasket - "+  basketRequest);


        return basketService.addProductToBasket(basketRequest);
    }


    @GetMapping("/findByUserId/{userId}")
    public List<BasketRespond> findByUserId(@PathVariable String userId){
        log.info("BasketController findByUserId - "+ userId);

        long userIdNumber;
        try {
            userIdNumber = Long.parseLong(userId);
        } catch (Exception e) {
            throw new UserDataIncorrectException("101");
        }

        return basketService.findByUserId(userIdNumber);
    }
}
