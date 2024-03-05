package com.mtb.demo.integration.contextriderwear.mapper;

import com.mtb.demo.common.domain.BrandDomain;
import com.mtb.demo.common.domain.ProductDomain;
import com.mtb.demo.common.domain.VendorDomain;
import com.mtb.demo.common.type.CurrencyType;
import com.mtb.demo.common.type.ProductType;
import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductData;
import org.springframework.stereotype.Component;

@Component
public class ProductDataMapper {

    public ProductDomain mapToDomain(ContextRiderWearProductData contextRiderWearProductData) {
        return ProductDomain.builder()
                .name(contextRiderWearProductData.name())
                .sku(contextRiderWearProductData.sku())
                .description(contextRiderWearProductData.description())
                .price(contextRiderWearProductData.price())
                .ratingValue(contextRiderWearProductData.reviewsRatingSum())
                .type(ProductType.KIT)
                .brand(BrandDomain.builder().name(ContextRiderWearProductData.DEFAULT_BRAND).build())
                .vendor(VendorDomain.builder().code(ContextRiderWearProductData.DEFAULT_VENDOR).build())
                .currency(CurrencyType.GBP)
                .build();
    }
}
