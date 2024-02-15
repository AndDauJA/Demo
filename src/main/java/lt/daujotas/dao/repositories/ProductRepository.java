package lt.daujotas.dao.repositories;

import lt.daujotas.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findByDescription(String desription, Pageable pageable);
//    List<Product> findProductsByCurrencyId (List<Integer> currencyId, Pageable pageable);
       Page<Product> findByCurrencyIdIn(List<Integer> currencyIds, Pageable pageable);
    Optional<Product> findProductById (Long id);


    Page<Product> searchProductsByNameAndDescription(String name, String description, Pageable pageable);
}
