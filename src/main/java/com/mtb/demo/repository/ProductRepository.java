package com.mtb.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mtb.demo.entity.Gender;
import com.mtb.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByName(String name, Pageable pageable);

	Page<Product> findByDescription(String desription, Pageable pageable);

	Page<Product> findByCurrencyIdIn(List<Integer> currencyIds, Pageable pageable);

	Optional<Product> findProductById(Long id);

	Page<Product> findProductByProductGendersIn(Collection<Gender> genders, Pageable pageable);

	Page<Product> searchProductsByNameAndDescription(String name, String description, Pageable pageable);
}
