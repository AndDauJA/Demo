package com.mtb.demo.service;

import java.util.Collection;
import java.util.List;

import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.dto.ProductFilterDto;
import com.mtb.demo.entity.Kit;
import com.mtb.demo.entity.Product;
import com.mtb.demo.mapper.KitProductMapper;
import com.mtb.demo.mapper.ProductDtoMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class KitService {

	private final ProductService productService;
	private final KitProductMapper kitProductMapper;
	private final ProductDtoMapper productDtoMapper;

	public List<ProductDTO> getProductByProductFilter(ProductFilterDto productFilterDto) {
		final Collection<String> genders = productFilterDto.getSelectedGenderFilters().stream().toList();
		final Collection<Product> productByGenders = productService.getProductByGenders(genders.toArray(String[]::new));
		final List<Kit> kits = productByGenders.stream()
				.map(kitProductMapper::mapTo)
				.toList();
		return productDtoMapper.mapToProductDtos(kits);
	}
}
