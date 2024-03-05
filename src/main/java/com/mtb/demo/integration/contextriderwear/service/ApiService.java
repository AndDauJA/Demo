package com.mtb.demo.integration.contextriderwear.service;

import com.mtb.demo.entity.Kit;
import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductData;
import com.mtb.demo.integration.mapper.ApiProductMapper;
import com.mtb.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final ProductRepository productRepository;
    private final ApiProductMapper apiProductMapper;


    public void saveApiToDb(ContextRiderWearProductData contextRiderWearProductData) {
        Kit kit = apiProductMapper.mapApiToKit(contextRiderWearProductData);
        productRepository.save(kit);
    }

}
