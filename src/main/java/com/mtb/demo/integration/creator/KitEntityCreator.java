package com.mtb.demo.integration.creator;

import com.mtb.demo.common.domain.ProductDomain;
import com.mtb.demo.entity.Kit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitEntityCreator implements EntityCreator<Kit, ProductDomain> {

    @Override
    public Kit createFromDomain(ProductDomain domain) {
        return Kit.builder()
                .name(domain.name())
                .sku(domain.sku())
                .description(domain.description())
                .price(domain.price())
                .ratingValue(domain.ratingValue())

                .build();
    }
}
