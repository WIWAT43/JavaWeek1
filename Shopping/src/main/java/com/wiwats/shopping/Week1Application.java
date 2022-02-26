package com.wiwats.shopping;

import com.wiwats.shopping.basket.model.BasketRequest;
import com.wiwats.shopping.basket.service.BasketService;
import com.wiwats.shopping.payment.model.UserPayment;
import com.wiwats.shopping.payment.repository.UserPaymentRepository;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.repository.ProductRepository;
import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.model.UserAddress;
import com.wiwats.shopping.user.repository.UserAddressRepository;
import com.wiwats.shopping.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Week1Application {

	public static void main(String[] args) {
		SpringApplication.run(Week1Application.class, args);
	}




	@Bean
	public CommandLineRunner demoProductData(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("Product01","Product01 detail","https://xxx/product01.jpg",100));
			productRepository.save(new Product("Product02","Product02 detail","https://xxx/product02.jpg",200));
			productRepository.save(new Product("Product03","Product03 detail","https://xxx/product03.jpg",800));
			productRepository.save(new Product("Product04","Product04 detail","https://xxx/product04.jpg",700));
			productRepository.save(new Product("Product05","Product05 detail","https://xxx/product05.jpg",900));
			productRepository.save(new Product("Product06","Product06 detail","https://xxx/product06.jpg",259));
			productRepository.save(new Product("Product07","Product07 detail","https://xxx/product07.jpg",234));
			productRepository.save(new Product("Product08","Product08 detail","https://xxx/product08.jpg",540));
			productRepository.save(new Product("Product09","Product09 detail","https://xxx/product09.jpg",600));
			productRepository.save(new Product("Product10","Product10 detail","https://xxx/product10.jpg",300));

		};
	}

	@Bean
	public CommandLineRunner demoUserData(UserRepository userRepository) {
		return args -> {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			userRepository.save(new User(date.toString(),"Last Name 01","First Name 01","1234567890","user01",date.toString(),"123456"));
			userRepository.save(new User(date.toString(),"Last Name 02","First Name 02","1234567890","user02",date.toString(),"123456"));
			userRepository.save(new User(date.toString(),"Last Name 03","First Name 03","1234567890","user03",date.toString(),"123456"));
			userRepository.save(new User(date.toString(),"Last Name 04","First Name 04","1234567890","user04",date.toString(),"123456"));
			userRepository.save(new User(date.toString(),"Last Name 05","First Name 05","1234567890","user05",date.toString(),"123456"));

		};
	}

	@Bean
	public CommandLineRunner demoBasketData(BasketService basketService) {
		return args -> {
			basketService.addProductToBasket(new BasketRequest(0L,1L,1L,1));
			basketService.addProductToBasket(new BasketRequest(0L,1L,2L,8));
			basketService.addProductToBasket(new BasketRequest(0L,2L,3L,9));
			basketService.addProductToBasket(new BasketRequest(0L,2L,1L,3));
			basketService.addProductToBasket(new BasketRequest(0L,3L,3L,2));
		};
	}

	@Bean
	public CommandLineRunner demoAddUserPayment(UserPaymentRepository userPaymentRepository) {
		return args -> {
			userPaymentRepository.save(new UserPayment(new User(1L),1,"12345678","Card Name01",2,25,"332",1));
			userPaymentRepository.save(new UserPayment(new User(2L),1,"23423443","Card Name02",2,25,"123",1));
			userPaymentRepository.save(new UserPayment(new User(3L),1,"57654658","Card Name03",2,25,"321",1));

		};
	}

	@Bean
	public CommandLineRunner demoAddUserAddress(UserAddressRepository userAddressRepository) {
		return args -> {
			userAddressRepository.save(new UserAddress(new User(1L),"Address Line1","Address Line2","Bangkok","10123","Thailand",1 ));
			userAddressRepository.save(new UserAddress(new User(2L),"Address Line1","Address Line2","Bangkok","10123","Thailand",1 ));
			userAddressRepository.save(new UserAddress(new User(3L),"Address Line1","Address Line2","Bangkok","10123","Thailand",1 ));

		};
	}
	
}
