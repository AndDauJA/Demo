package com.mtb.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mtb.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByName(String name, Pageable pageable);

    Page<Product> findByDescription(String desription, Pageable pageable);

    Page<Product> findByCurrencyIdIn(List<Integer> currencyIds, Pageable pageable);

    Optional<Product> findProductById(Long id);

    @Query("SELECT p FROM Product p"
            + " JOIN FETCH p.productGenders g WHERE g.code IN :genders")
    Collection<Product> findAllByProductGenders(@Param("genders") String... genders);

    //	@Query("SELECT p FROM Product p JOIN p.productGenders b WHERE b.code = :genders")
//	Collection<Product> findAllByProductGenders(String... genders);
    @Query("SELECT p FROM Product p"
            +" JOIN FETCH p.brand b WHERE b.name IN :brandNames")
    Collection<Product> findAllByProductBrandNames(@Param("brandNames") String... brandNames);

    @Query("SELECT p FROM Product p JOIN FETCH p.productColors b WHERE b.code = :color")
    Collection<Product> findAllByProductColor(Collection<String> color);

    List<Product> findAll();

    Page<Product> searchProductsByNameAndDescription(String name, String description, Pageable pageable);
}
