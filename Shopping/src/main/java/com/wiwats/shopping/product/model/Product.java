package com.wiwats.shopping.product.model;

import com.wiwats.shopping.basket.model.Basket;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String name;
	private String detail;
	private String image;
	private double price;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Basket> baskets = new HashSet<>();

	public Product() {
	}

	public Product(Long productId) {
		this.productId = productId;
	}

	public Product(String name, String detail, String image, double price) {
		this.name = name;
		this.detail = detail;
		this.image = image;
		this.price = price;
	}

	public Product(ProductRespond productRespond) {
		this.productId = productRespond.getProductId();
		this.name = productRespond.getName();
		this.detail = productRespond.getDetail();
		this.image = productRespond.getImage();
		this.price = productRespond.getPrice();
	}
}