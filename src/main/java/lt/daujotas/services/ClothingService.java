package lt.daujotas.services;

import lt.daujotas.dao.ClothingDao;
import lt.daujotas.dao.ProductDao;
import lt.daujotas.dao.repositories.ClothingRepository;
import lt.daujotas.entities.Clothing;
import lt.daujotas.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingService {


    private final ClothingDao clothingDao;
    private final ClothingRepository clothingRepository;

    @Autowired
    public ClothingService(ClothingDao clothingDao,
                           ClothingRepository clothingRepository) {
        this.clothingDao = clothingDao;
        this.clothingRepository = clothingRepository;
    }


    public void saveClothing(Clothing clothing) {
        clothingDao.save(clothing);
    }

    public List<Clothing> getAllProducts() {
        return clothingDao.getAll();
    }

    public Page<Clothing> getProductByGender(String gender, Pageable pageable) {
        return clothingRepository.findByGender(gender, pageable);
    }


    public Page<Clothing> getProductsBySize(String size, Pageable pageable) {
        return clothingDao.getClothingBySize(size, pageable);
    }

    public Page<Clothing> getProductsByColor(String color, Pageable pageable) {
        return clothingDao.getClothingByColor(color, pageable);
    }

    public Page<Clothing> getProductsByBrand(String brand, Pageable pageable) {
        return clothingDao.getClothingByBrand(brand, pageable);
    }

    public void deleteProductById(Long id) {
        clothingDao.deleteByClothingtId(id);
    }

    public Page<Clothing> getAllClientsPages(Pageable pageable) {
        return clothingDao.getPage(pageable);
    }

}
