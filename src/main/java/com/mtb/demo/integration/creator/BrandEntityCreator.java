package com.mtb.demo.integration.creator;

import com.mtb.demo.common.domain.BrandDomain;
import com.mtb.demo.entity.Brand;
import com.mtb.demo.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandEntityCreator implements EntityCreator<Brand, BrandDomain> {

    private final BrandRepository brandRepository;

    @Override
    public Brand createFromDomain(final BrandDomain domain) {
        return brandRepository.findByName(domain.name())
                .orElseThrow(() -> new RuntimeException("Brand not found with name: " + domain.name()));
    }
}
