package com.mtb.demo.integration.contextriderwear.api;

import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface ContextRiderWearApi {

    @GetExchange("/products")
    ContextRiderWearProductResponse getProducts();
}
