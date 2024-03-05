package com.mtb.demo.integration.contextriderwear.service;

import com.mtb.demo.common.domain.ProductDomain;
import com.mtb.demo.entity.Kit;
import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductData;
import com.mtb.demo.integration.contextriderwear.mapper.ProductDataMapper;
import com.mtb.demo.integration.creator.BrandEntityCreator;
import com.mtb.demo.integration.creator.KitEntityCreator;
import com.mtb.demo.integration.creator.VendorEntityCreator;
import com.mtb.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContextRiderWearDataStoringService {
    private final ProductRepository productRepository;
    private final ProductDataMapper productDataMapper;

    // TODO - this is a good example of a class that is doing too much. It should be refactored to have a single responsibility.
    private final KitEntityCreator kitEntityCreator;
    private final BrandEntityCreator brandEntityCreator;
    private final VendorEntityCreator vendorEntityCreator;

    public void saveApiToDb(ContextRiderWearProductData contextRiderWearProductData) {
        final ProductDomain productDomain = productDataMapper.mapToDomain(contextRiderWearProductData);

        // TODO - we should check if the product already exists in the database,
        //  and if it does, we should update it instead of creating a new one.
        final Kit kit = createAsNew(productDomain);

        productRepository.save(kit);
    }

    private Kit createAsNew(final ProductDomain productDomain) {
        final Kit kit = kitEntityCreator.createFromDomain(productDomain);
        kit.setBrand(brandEntityCreator.createFromDomain(productDomain.brand()));
        kit.setVendor(vendorEntityCreator.createFromDomain(productDomain.vendor()));
        // TODO - do same for Type
        // TODO - do same for Currency
        return kit;
    }

}
