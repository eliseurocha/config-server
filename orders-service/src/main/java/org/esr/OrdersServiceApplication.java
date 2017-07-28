package org.esr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class OrdersServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(OrdersServiceApplication.class, args);
	}

}
