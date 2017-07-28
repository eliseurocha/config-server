package org.esr.products.services.dto;

import java.math.BigDecimal;

public class Product {
	private String description;
	private BigDecimal price;
	private Long stock;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String description, BigDecimal price, Long stock) {
		super();
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Long getStock() {
		return stock;
	}

}
