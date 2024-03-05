package com.mtb.demo.integration.contextriderwear.dto;

import java.math.BigDecimal;

public record ContextRiderWearProductData(
        String id,
        String name,
        String type,
        String sku,
        String description,
        BigDecimal price,
        int reviewsRatingSum
) {
    public static final String DEFAULT_BRAND = "Context ridewear";
    public static final String DEFAULT_VENDOR = "contextridewear.co.uk"; //FIXME: vendor should be some code or API class type maybe?
}
