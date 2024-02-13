package lt.daujotas.dao;

import lt.daujotas.dao.repositories.ClothingRepository;
import lt.daujotas.entities.Clothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClothingJPADao implements ClothingDao {
    @Autowired
    ClothingRepository clothingRepository;

    @Override
    public void save(Clothing clothing) {
        clothingRepository.save(clothing);

    }

    @Override
    public Optional<Clothing> getClthingById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Clothing> getClothingByGender (List<String> gender, Pageable pageable) {
        return  clothingRepository.findByGenderIn(gender, pageable);
    }

    @Override
    public Page<Clothing> getClothingBySize(List<String> size, Pageable pageable) {
        return clothingRepository.findBySizeIn(size, pageable);
    }

    @Override
    public Page<Clothing> getClothingByColor(List<String> color, Pageable pageable) {
        return clothingRepository.findByColorIn(color, pageable);
    }

    @Override
    public Page<Clothing> getClothingByBrand(String brandName, Pageable pageable) {
        return clothingRepository.findByBrand(brandName, pageable);
    }

    @Override
    public void update(Clothing clothing) {

    }

    @Override
    public List<Clothing> getAll() {
        return null;
    }

    @Override
    public Page<Clothing> getPage(Pageable pageable) {
        return clothingRepository.findAll(pageable);
    }

    @Override
    public void deleteByClothingtId(Long id) {
        Optional<Clothing> cloths =clothingRepository.findClothingById(id);
        cloths.ifPresent(clothingRepository::delete);

    }
}
