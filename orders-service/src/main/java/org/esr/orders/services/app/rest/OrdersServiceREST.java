package org.esr.orders.services.app.rest;

import java.math.BigDecimal;

import org.esr.orders.services.OrderService;
import org.esr.orders.services.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrdersServiceREST {

	@Autowired
	private OrderService service = null;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Order> getOrder() {

		return new ResponseEntity<Order>(new Order("Order 1", new BigDecimal("20")), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Order> createOrder(Order order) {

		return new ResponseEntity<Order>(service.createOrder(order), HttpStatus.OK);
	}

}
