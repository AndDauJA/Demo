package com.mtb.demo.integration.creator;

import com.mtb.demo.common.domain.VendorDomain;
import com.mtb.demo.entity.Vendor;
import com.mtb.demo.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendorEntityCreator implements EntityCreator<Vendor, VendorDomain> {

        private final VendorRepository vendorRepository;

        @Override
        public Vendor createFromDomain(final VendorDomain domain) {
            return vendorRepository.findByUrl(domain.code())
                    .orElseThrow(() -> new RuntimeException("Vendor not found by url: " + domain.code()));
        }
}
