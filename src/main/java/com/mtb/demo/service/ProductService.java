package com.mtb.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mtb.demo.entity.Product;
import com.mtb.demo.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final EntityManager entityManager;

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
    public Collection<Product> getProductByColor(String... color){
        return productRepository.findAllByProductColorNames(color);
    }

    public List<Product> getProductsByFilters(Collection<String> genders, Collection<String> brandName, Collection<String> color) {
    return  productRepository.findByMultipleCriteria(color,brandName,genders);
    }

    public List<Product> getProductByName(String name) {
       return productRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Product> searchByMultipleTerms(String searchText) {
        String[] terms = searchText.split("\\s+");
        String query = "SELECT p FROM Product p WHERE ";
        List<String> conditions = new ArrayList<>();

        for (String term : terms) {
            conditions.add("LOWER(p.name) LIKE LOWER(CONCAT('%', :term, '%'))");
        }

        query += String.join(" OR ", conditions);

        // Construct query dynamically with EntityManager or Specifications if using Spring Data JPA
        return executeDynamicQuery(query, terms);  // This is a placeholder for actual query execution logic
    }
    private List<Product> executeDynamicQuery(String jpql, String[] terms) {
        Query query = entityManager.createQuery(jpql, Product.class);
        for (int i = 0; i < terms.length; i++) {
            query.setParameter("term" + i, "%" + terms[i].toLowerCase() + "%");
        }
        return query.getResultList();
    }
}
