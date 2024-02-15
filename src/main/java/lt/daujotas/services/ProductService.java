package lt.daujotas.services;

import lt.daujotas.dao.ClothingDao;
import lt.daujotas.dao.ProductDao;
import lt.daujotas.entities.Clothing;
import lt.daujotas.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {


    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;

    }

    public void saveProduct(Product product) {

        productDao.save(product);
    }

        public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Page<Product> getProductByName(String name, Pageable pageable) {
        return productDao.getProductByName(name, pageable);
    }


    public Page<Product> getProductsByDescription(String description, Pageable pageable) {
        return productDao.getProductByDescription(description, pageable);
    }

    public void deleteProductById(Long id) {
        productDao.deleteByProductId(id);
    }

    public Page<Product> getAllClientsPages(Pageable pageable) {
        return productDao.getPage(pageable);
    }
//
//
    public Page<Product> getProductByCurrencyIds(List<Integer> currencyIds, Pageable pageable) {
        return productDao.getProductByCurrencyIds(currencyIds, pageable);
    }


}
