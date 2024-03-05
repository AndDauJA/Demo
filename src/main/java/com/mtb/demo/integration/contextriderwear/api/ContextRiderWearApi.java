package com.mtb.demo.integration.contextriderwear.api;

import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductImagesResponse;
import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ContextRiderWearApi {

    @GetExchange("/products?sku=GRAV-BL-M")
    ContextRiderWearProductResponse getProducts();

    @GetExchange("/products/{product_id}/images")
    ContextRiderWearProductImagesResponse getProductImages(@PathVariable("product_id") String productId);
}
