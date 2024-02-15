package lt.daujotas.dao;

import lt.daujotas.entities.Clothing;
import lt.daujotas.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClothingDao {

    void save (Clothing clothing);
    Optional<Clothing> getClthingById(Long id);

    Page<Clothing> getClothingByGender(List<String> gender, Pageable pageable);
    Page<Clothing> getClothingBySize(List<String> size, Pageable pageable);
    Page<Clothing> getClothingByColor(List<String> color, Pageable pageable);
    Page<Clothing> getClothingByBrand (String brandName, Pageable pageable);






    void update(Clothing clothing);

    List<Clothing> getAll();

    Page<Clothing> getPage(Pageable pageable);

    void deleteByClothingtId(Long id);
}
