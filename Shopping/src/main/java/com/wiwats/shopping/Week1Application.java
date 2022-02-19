package com.wiwats.shopping;

import com.wiwats.shopping.product.model.Basket;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.product.repository.BasketRepository;
import com.wiwats.shopping.product.repository.ProductRepository;
import com.wiwats.shopping.user.model.User;
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
	public CommandLineRunner demoBasketData(BasketRepository basketRepository) {
		return args -> {
			basketRepository.save(new Basket(1L,1L,1L,1));
			basketRepository.save(new Basket(2L,1L,2L,2));
			basketRepository.save(new Basket(3L,1L,3L,3));
			basketRepository.save(new Basket(4L,1L,4L,2));
			basketRepository.save(new Basket(5L,1L,5L,1));

		};
	}
}
