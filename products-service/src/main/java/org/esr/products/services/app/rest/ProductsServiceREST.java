package org.esr.products.services.app.rest;

import java.math.BigDecimal;

import org.esr.products.services.ProductsService;
import org.esr.products.services.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsServiceREST {

	@Autowired
	private ProductsService service = null;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct() {

		return new ResponseEntity<Product>(new Product("Product 1", new BigDecimal("20"), new Long(30)), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(Product Product) {

		return new ResponseEntity<Product>(service.createProduct(Product), HttpStatus.OK);
	}

}
