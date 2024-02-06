package lt.daujotas.dao.repositories;

import lt.daujotas.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findByDescription(String desription, Pageable pageable);
    Page<Product> findProductsByCurrencyId (int currency, Pageable pageable);
    Optional<Product> findProductById (int id);
}
