package com.wiwats.shopping.product.controller;

import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/findAllProduct")
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/findByNameContaining/{productName}")
    public List<Product> findByNameContaining(@PathVariable String productName){
        log.info("ProductController findByNameContaining - "+ productName);
        return productRepository.findByNameContainingIgnoreCase(productName);
    }

    @GetMapping("/findById/{productId}")
    public Optional<Product> findById(@PathVariable String productId){
        log.info("ProductController findById - "+ productId);

        long productIdNumber;
         try {
             productIdNumber = Long.parseLong(productId);
         } catch (Exception e) {
             throw new UserDataIncorrectException("101");
        }
        return productRepository.findById(productIdNumber);
    }
}
