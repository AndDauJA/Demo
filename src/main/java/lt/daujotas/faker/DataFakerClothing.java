package lt.daujotas.faker;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lt.daujotas.entities.Clothing;
import lt.daujotas.services.ClothingService;
import lt.daujotas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DataFakerClothing {
    private static final int MAX_COUNT = 100;


    private final ClothingService clothingService;
    private final RandomFaker randomFaker;

    @Autowired
    public DataFakerClothing(ClothingService clothingService, RandomFaker randomFaker) {
        this.clothingService = clothingService;
        this.randomFaker = randomFaker;
    }


    @Transactional
    public void initClothingFaker() {
        Faker faker = new Faker();
        for (int i = 0; i < MAX_COUNT; i++) {
            String brand = faker.lorem().word();

            String cloor = faker.color().name();
            String randomSize = randomFaker.reandomSize();
            String randomGender = randomFaker.randomGender();
            clothingService.saveClothing(Clothing.builder()
                    .gender(randomGender)
                    .size(randomSize)
                    .brand(brand)
                    .color(cloor)
                    .build());
        }

    }
}
