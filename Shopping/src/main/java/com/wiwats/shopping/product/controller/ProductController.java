package com.wiwats.shopping.product.controller;

import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.payment.model.PayRequest;
import com.wiwats.shopping.payment.model.PaymentSummary;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.model.ProductRespond;
import com.wiwats.shopping.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/findAllProduct")
    public List<ProductRespond> findAllProduct(){

        List<Product> products = productRepository.findAll();

        List<ProductRespond> productResponds = new ArrayList<>();
        for (Product product : products) {
            productResponds.add(new ProductRespond(product));
        }

        return productResponds;
    }

    @GetMapping("/findByNameContaining/{productName}")
    public List<ProductRespond> findByNameContaining(@PathVariable String productName){
        log.info("ProductController findByNameContaining - "+ productName);

        List<ProductRespond> productRespond = new ArrayList<ProductRespond>();
        List<Product> products = productRepository.findByNameContainingIgnoreCase(productName);

        for (Product product : products) {
            productRespond.add( new ProductRespond(product));
        }

        return productRespond;
    }

    @GetMapping("/findById/{productId}")
    public ProductRespond findById(@PathVariable String productId){
        log.info("ProductController findById - "+ productId);

        long productIdNumber;
         try {
             productIdNumber = Long.parseLong(productId);
         } catch (Exception e) {
             throw new UserDataIncorrectException("101");
        }

         ProductRespond productRespond = new ProductRespond(productRepository.findById(productIdNumber).get());

        return productRespond;
    }


    @PostMapping(value = "/addProduct")
    public ProductRespond addProduct(@RequestBody ProductRespond productRespond){

        Product product = productRepository.save(new Product(productRespond));
        ProductRespond result = new ProductRespond(product);
        return result;
    }

}
