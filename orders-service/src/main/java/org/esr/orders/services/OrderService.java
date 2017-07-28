package org.esr.orders.services;

import java.math.BigDecimal;

import org.esr.orders.OrderToggle;
import org.esr.orders.services.dto.Order;
import org.esr.toggle.ToggleClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private ToggleClientRepository repository;

	public Order createOrder(Order order) {

		String orderResult = "";
		if (repository.isToggleOn(OrderToggle.APPLY_TAXES)) {
			orderResult = "Order was placed as reserved";
			order = new Order(orderResult, new BigDecimal("20"));
			System.out.println(orderResult);
		} else {
			orderResult = "Order will be delivered";
			order = new Order(orderResult, new BigDecimal("10"));
			System.out.println(orderResult);
		}

		return order;
	}

}
