package org.esr.orders.services.dto;

import java.math.BigDecimal;

public class Order {
	private String description;
	private BigDecimal value;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(String description, BigDecimal value) {
		super();
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getValue() {
		return value;
	}

}
