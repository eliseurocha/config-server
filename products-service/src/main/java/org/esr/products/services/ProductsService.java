package org.esr.products.services;

import java.math.BigDecimal;

import org.esr.products.ProductToggle;
import org.esr.products.services.dto.Product;
import org.esr.toggle.ToggleClientRepository;
import org.esr.toggle.dto.ServiceConfigKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

	@Autowired
	private ToggleClientRepository repository ;

	public Product createProduct(Product product) {

		String productResult = "";
		if (repository.isToggleOn(ProductToggle.APPLY_TAXES)) {
			productResult = "Product was created";
			product = new Product(productResult, new BigDecimal("20"), new Long(30));
			System.out.println(productResult);
		} else {
			productResult = "Product will be created";
			product = new Product(productResult, new BigDecimal("10"), new Long(20));
			System.out.println(productResult);
		}

		return product;
	}

}
