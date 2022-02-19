package com.wiwats.shopping.product.model;

import lombok.Data;

import javax.persistence.*;
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

	public Product() {
	}

	public Product(String name, String detail, String image, double price) {
		this.name = name;
		this.detail = detail;
		this.image = image;
		this.price = price;
	}
}