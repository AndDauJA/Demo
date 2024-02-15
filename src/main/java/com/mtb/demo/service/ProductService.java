package com.mtb.demo.service;

import java.util.List;
import java.util.Set;

import com.mtb.demo.entity.Gender;
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

	public Page<Product> getProductByName(String name, Pageable pageable) {
		return productRepository.findByName(name, pageable);
	}

	public Page<Product> getProductsByDescription(String description, Pageable pageable) {
		return productRepository.findByDescription(description, pageable);
	}

	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

	public Page<Product> getAllClientsPages(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Page<Product> getProductByCurrencyIds(List<Integer> currencyIds, Pageable pageable) {
		return productRepository.findByCurrencyIdIn(currencyIds, pageable);
	}

	public Page<Product> getProductByGenders(Set<Gender> genders, Pageable pageable) {
		return productRepository.findProductByProductGendersIn(genders, pageable);
	}
}
