package lt.daujotas.services;

import lt.daujotas.dao.ProductDao;
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

      public void saveProduct (Product product) {

        productDao.save(product);
    }

//    public void updateClient(ClientDto clientDto) {
//
//        ClientDto clientDto1= clientDao.getClientByUsername(clientDto.getUserName()).get();
//        clientDto1.setFirstName(clientDto.getFirstName());
//        clientDao.update(clientDto1);
//    }
//    public Optional<ClientDto> getClientByUserName(String userName) {
//        return clientDao.getClientByUsername(userName);
//    }
//
//
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }
//
//    public Optional<ClientAccountInfo> getClientByUUID(UUID id) {
//        return clientDao.getClientByUUID(id);
//    }
        public Page<Product> getProductByName(String name, Pageable pageable) {
        return productDao.getProductByName(name, pageable);
    }
    public Page<Product> getProductsByDescription(String description, Pageable pageable) {
        return productDao.getProductByDescription( description, pageable);
    }public Page<Product> getProductsByNameAndDescription(String name, String description, Pageable pageable) {
        return productDao.getProductsByNameAndDescription( name, description, pageable);
    }

    public void deleteProductById(Long id){
        productDao.deleteByProductId(id);
    }
//
//    public void deleteClientByUUID(UUID id) {
//        clientDao.deleteClientByUUID(id);
//    }
//
        public Page<Product> getAllClientsPages(Pageable pageable) {
        return productDao.getPage(pageable);
    }
//    public Page<ClientDto> getAllClientsPages(Pageable pageable) {
//        return clientDao.getPage(pageable);
//    }

    //    public Page<Product> getProductByCurrencyId(int currencyId, Pageable pageable) {
//        return productDao.getProductByCurrencyId(currencyId, pageable);
//    }

    public Page<Product> getProductByCurrencyIds(List<Integer> currencyIds, Pageable pageable) {
        return productDao.getProductByCurrencyIds(currencyIds, pageable);
    }


}
