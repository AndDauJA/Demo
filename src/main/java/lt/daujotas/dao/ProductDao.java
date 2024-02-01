package lt.daujotas.dao;

import lt.daujotas.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    void save (Product product);
    Optional<Product> getProductById(int id);
    Page<Product> getProductByName(String name, Pageable pageable);
    Page<Product> getProductByDescription(String name, Pageable pageable);


    void update(Product product);

    List<Product> getAll();
    Page<Product> getPage(Pageable pageable);

    void deleteByProductId(int id);

}
