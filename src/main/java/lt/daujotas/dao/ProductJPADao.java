package lt.daujotas.dao;

import lt.daujotas.entities.Product;
import lt.daujotas.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductJPADao implements ProductDao {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.empty();
    }


    @Override
    public Page<Product> getProductByName(String name,Pageable pageable) {
        return productRepository.findByName(name, pageable);
    }

    @Override
    public Page<Product> getProductByDescription(String desription, Pageable pageable) {
        return productRepository.findByDescription(desription, pageable);
    }

    @Override
    public Page<Product> getProductByCurrencyIds(List<Integer> currencyIds, Pageable pageable) {
        return (Page<Product>) productRepository.findByCurrencyIdIn(currencyIds,pageable);
    }

    @Override
    public Page<Product> getProductsByNameAndDescription(String name, String description, Pageable pageable) {
        return productRepository.searchProductsByNameAndDescription(name, description,pageable);
    }


    @Override
    public void update(Product product) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void deleteByProductId(Long id) {
        Optional<Product> product = productRepository.findProductById(id);
        product.ifPresent(productRepository::delete);
    }
}
