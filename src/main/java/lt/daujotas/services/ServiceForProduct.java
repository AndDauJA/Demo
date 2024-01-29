package lt.daujotas.services;

import lt.daujotas.dao.ProductDao;
import lt.daujotas.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class ServiceForProduct {


    private final ProductDao productDao;
    @Autowired
    public ServiceForProduct(ProductDao productDao) {
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
//    public List<ClientAccountInfo> getAllClients() {
//        return clientDao.getAll();
//    }
//
//    public Optional<ClientAccountInfo> getClientByUUID(UUID id) {
//        return clientDao.getClientByUUID(id);
//    }
//    //    public Optional<ClientAccountInfo> getClientByFirstName(String firstName) {
////        return clientDao.getClientByFirstName(firstName);
////    }
//    public void deleteClientByUserName(String userName){
//        clientDao.deleteByClientUserName(userName);
//    }
//
//    public void deleteClientByUUID(UUID id) {
//        clientDao.deleteClientByUUID(id);
//    }
//
//    //    public Page<ClientAccountInfo> getAllClientsPages(Pageable pageable) {
////        return clientDao.getPage(pageable);
////    }
//    public Page<ClientDto> getAllClientsPages(Pageable pageable) {
//        return clientDao.getPage(pageable);
//    }


}
