package com.mtb.demo.integration.mapper;

import com.mtb.demo.entity.Kit;
import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductData;
import org.springframework.stereotype.Component;

@Component
public class ApiProductMapper {
        public Kit mapApiToKit(ContextRiderWearProductData contextRiderWearProductData) {

        return Kit.builder()
                .name(contextRiderWearProductData.name())
                .sku(contextRiderWearProductData.sku())

                .build();
    }


}
