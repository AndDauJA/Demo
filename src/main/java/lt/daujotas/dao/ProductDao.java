package lt.daujotas.dao;

import lt.daujotas.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    void save (Product product);
    Optional<Product> getClientByFirstName(String name);


    void update(Product product);

    List<Product> getAll();

}
