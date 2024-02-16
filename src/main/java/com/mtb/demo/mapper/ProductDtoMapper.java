package com.mtb.demo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.entity.Kit;
import com.mtb.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDtoMapper {

	private final SizeDtoMapper sizeDtoMapper;

	public ProductDTO mapToProductDto(Product product) {
		return ProductDTO.builder()
				.name(product.getName())
				.sizes(sizeDtoMapper.mapToSizeDtos(product.getProductSizes()))
				.build();
	}

	public List<ProductDTO> mapToProductDtos(Collection<Kit> products) {
		return products.stream().map(this::mapToProductDto).collect(Collectors.toList());
	}
}
