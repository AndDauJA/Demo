package com.mtb.demo.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mtb.demo.dto.BrandDto;
import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.entity.Brand;
import com.mtb.demo.entity.Kit;
import com.mtb.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDtoMapper {

    private final SizeDtoMapper sizeDtoMapper;
    private final BrandDtoMapper brandDtoMapper;
    private final ColorDtoMapper colorDtoMapper;
    private final GenderDtoMapper genderDtoMapper;



    public ProductDTO mapToProductDto(Product product) {
        BrandDto brandDto = brandDtoMapper.mapToBrandDto(product.getBrand());
        Collection<BrandDto> brandDtos = new ArrayList<>();
        brandDtos.add(brandDto);
        return ProductDTO.builder()
                .name(product.getName())
                .sizes(sizeDtoMapper.mapToSizeDtos(product.getProductSizes()))
                .brandNames(brandDtos)
                .colors(colorDtoMapper.mapToColorDtos(product.getProductColors()))
                .genders(genderDtoMapper.mapToGenderDtos(product.getProductGenders()))
                .build();
    }

    public List<ProductDTO> mapToProductDtos(Collection<Kit> products) {
        return products.stream().map(this::mapToProductDto).collect(Collectors.toList());
    }
}
