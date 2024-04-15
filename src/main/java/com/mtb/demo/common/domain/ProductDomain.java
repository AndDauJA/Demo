package com.mtb.demo.common.domain;

import com.mtb.demo.common.type.CurrencyType;
import com.mtb.demo.common.type.ProductType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDomain(
        String sku,
        String name,
        String description,
        BrandDomain brand,
        GenderDomain gender,
        VendorDomain vendor,
        ProductType type,
        BigDecimal price,
        CurrencyType currency,
        int ratingValue
) {
}
