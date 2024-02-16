package com.mtb.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mtb.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByName(String name, Pageable pageable);

	Page<Product> findByDescription(String desription, Pageable pageable);

	Page<Product> findByCurrencyIdIn(List<Integer> currencyIds, Pageable pageable);

	Optional<Product> findProductById(Long id);

	@Query("SELECT p FROM Product p"
		   + " JOIN p.productGenders g WHERE g.code IN (:genders)")
	Collection<Product> findAllByProductGenderCodes(String... genders);

	Page<Product> searchProductsByNameAndDescription(String name, String description, Pageable pageable);
}
