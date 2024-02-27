package com.mtb.demo.service;

import java.util.Collection;
import java.util.List;

import com.mtb.demo.entity.Product;
import com.mtb.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getAllClientsPages(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    public Collection<Product> getProductByGenders(String... genders) {
        return productRepository.findAllByProductGenders(genders);
    }
    public Collection<Product> getProductByBrandNames(String... brandName){
        return productRepository.findAllByProductBrandNames(brandName);
    }

}
