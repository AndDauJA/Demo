package com.mtb.demo.service;

import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.dto.ProductFilterDto;
import com.mtb.demo.entity.Product;
import com.mtb.demo.mapper.ProductDtoMapper;
import com.mtb.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class KitService {

    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;


    @Transactional
    public List<ProductDTO> getProductByProductFilter(ProductFilterDto productFilterDto) {

        final Collection<String> brandNameFilters = productFilterDto.selectedBrandNameFilter();
        final Collection<String> genderFilters = productFilterDto.selectedGenderFilter();
        final Collection<String> colorFilters = productFilterDto.selectedColorFilter();
        Collection<Product> filteredProductsByGenders = Collections.emptyList();
        Collection<Product> filteredProductsByBrandNames = Collections.emptyList();
        Collection<Product> filteredProductsByColor = Collections.emptyList();

        if (genderFilters != null && !genderFilters.isEmpty()) {
            filteredProductsByGenders = productService.getProductByGenders(genderFilters.toArray(new String[0]));
        }
        if (brandNameFilters != null && !brandNameFilters.isEmpty()) {
            filteredProductsByBrandNames = productService.getProductByBrandNames(brandNameFilters.toArray(new String[0]));
        }
        if (colorFilters != null && !colorFilters.isEmpty()) {
            filteredProductsByColor = productService.getProductByColor(colorFilters.toArray(new String[0]));
        }
//        final Collection<Product> productByGenders = productService.getProductByGenders(genderFilters.toArray(new String[0]));
//        Collection<Product> combinedFilteredProducts = Stream.concat(filteredProductsByGenders.stream(), filteredProductsByBrandNames.stream(),filteredProductsByColor.stream())
//                .collect(Collectors.toSet());

        Collection<Product> combinedFilteredProducts = Stream.concat(
                Stream.concat(filteredProductsByGenders.stream(), filteredProductsByBrandNames.stream()),
                filteredProductsByColor.stream()
        ).collect(Collectors.toSet());
//        List<Product> filteredProducts = productService.getProductsByFilters(
//                productFilterDto.selectedBrandNameFilter(),
//                productFilterDto.selectedGenderFilter(),
//                productFilterDto.selectedColorFilter()
//        );

        return combinedFilteredProducts.stream()
                .map(productDtoMapper::mapToProductDto)
                .collect(Collectors.toList());
//        return filteredProducts.stream()
//                .map(productDtoMapper::mapToProductDto)
//                .collect(Collectors.toList());
    }

    @Transactional
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(productDtoMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ProductDTO> searchProductsByName(String name) {
        List<Product> products = productService.getProductByName(name);
        return products.stream()
                .map(productDtoMapper::mapToProductDto)
                .collect(Collectors.toList());
    }
}

