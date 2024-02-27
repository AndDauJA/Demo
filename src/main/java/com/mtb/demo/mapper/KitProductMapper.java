package com.mtb.demo.mapper;

import com.mtb.demo.entity.Kit;
import com.mtb.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class KitProductMapper {

	public Kit mapTo(Product product) {
		return Kit.builder()
				.id(product.getId())
				.name(product.getName())
				.brand(product.getBrand())
				.productGenders(product.getProductGenders())
				.productSizes(product.getProductSizes())
				.build();
	}

}
