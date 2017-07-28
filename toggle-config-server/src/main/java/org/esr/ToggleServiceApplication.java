package org.esr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ToggleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToggleServiceApplication.class, args);
	}
}
