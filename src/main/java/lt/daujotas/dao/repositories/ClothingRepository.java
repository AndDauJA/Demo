package lt.daujotas.dao.repositories;

import lt.daujotas.entities.Clothing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, String> {

    Page<Clothing> findByGenderIn (List<String> gender, Pageable pageable);
    Page<Clothing> findBySizeIn (List<String> size, Pageable pageable);
    Page<Clothing>  findByColor (String color, Pageable pageable);
    Page<Clothing> findByBrand(String brandName, Pageable pageable);

    Optional<Clothing> findClothingById(Long id);
}
