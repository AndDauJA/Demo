package com.mtb.demo.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.dto.ProductFilterDto;
import com.mtb.demo.entity.Product;
import com.mtb.demo.mapper.GenderDtoMapper;
import com.mtb.demo.mapper.KitProductMapper;
import com.mtb.demo.mapper.ProductDtoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitService {

    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    @Transactional
    public List<ProductDTO> getProductByProductFilter(ProductFilterDto productFilterDto) {

        final Collection<String> brandNameFilters = productFilterDto.selectedBrandNameFilter();
        final Collection<String> genderFilters = productFilterDto.selectedGenderFilter();

        Collection<Product> filteredProductsByGenders = Collections.emptyList();
        Collection<Product> filteredProductsByBrandNames = Collections.emptyList();

        if (genderFilters != null && !genderFilters.isEmpty()) {
            filteredProductsByGenders = productService.getProductByGenders(genderFilters.toArray(new String[0]));
        }
        if (brandNameFilters != null && !brandNameFilters.isEmpty()) {
            filteredProductsByBrandNames = productService.getProductByBrandNames(brandNameFilters.toArray(new String[0]));
        }
//        final Collection<Product> productByGenders = productService.getProductByGenders(genderFilters.toArray(new String[0]));
        Collection<Product> combinedFilteredProducts = Stream.concat(filteredProductsByGenders.stream(), filteredProductsByBrandNames.stream())
                .collect(Collectors.toSet());
//        final List<Kit> kits = productByGenders.stream()
//                .map(kitProductMapper::mapTo)
//
//                .toList();
//        return productDtoMapper.mapToProductDtos(kits);
        return combinedFilteredProducts.stream()
                .map(productDtoMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(productDtoMapper::mapToProductDto)
                .collect(Collectors.toList());
    }
}

