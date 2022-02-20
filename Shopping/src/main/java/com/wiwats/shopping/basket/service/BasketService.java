package com.wiwats.shopping.basket.service;

import com.wiwats.shopping.basket.model.Basket;
import com.wiwats.shopping.basket.model.BasketRequest;
import com.wiwats.shopping.basket.model.BasketRespond;
import com.wiwats.shopping.basket.repository.BasketRepository;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.repository.ProductRepository;
import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BasketService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BasketRepository basketRepository;

    public BasketRespond addProductToBasket(BasketRequest basketRequest){
     Optional<User> user = userRepository.findById(basketRequest.getUserId());
     Optional<Product> product = productRepository.findById(basketRequest.getProductId());
     Optional<Basket> basketCurrentData = basketRepository.findById(basketRequest.getBasketId());

     Basket basketReturnSave = new Basket();
     if(basketCurrentData.isEmpty()|| basketCurrentData==null){
         Basket basket = new Basket();
         basket.addBasketItem(basketRequest.getBasketId(),user.get(),product.get(),basketRequest.getProductUnit());
         basketReturnSave = basketRepository.save(basket);
     } else {
         Basket basket = new Basket();

         basket.addBasketItem(basketCurrentData.get().getBasketId(),basketCurrentData.get().getUser(),basketCurrentData.get().getProduct(),basketCurrentData.get().getProductUnit()+basketRequest.getProductUnit());

         basketReturnSave = basketRepository.save(basket);

     }


  //  log.info( "BasketService - addProductToBasket "+ String.valueOf(basketReturnSave));
     BasketRespond basketRespond = new BasketRespond();
     basketRespond.SetBasketRespondByBasket(basketReturnSave);

   return basketRespond;
    }

    public List<BasketRespond> findByUserId (Long userId){

        List<Basket> baskets = basketRepository.findByUser(new User(userId));

        List<BasketRespond> basketRespond = new ArrayList<>();

        for (Basket basket : baskets) {
            BasketRespond bs = new BasketRespond();
            bs.SetBasketRespondByBasket( basket);

            basketRespond.add(bs);
        }

        return basketRespond;
    }

}
