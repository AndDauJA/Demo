package lt.daujotas.faker;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lt.daujotas.entities.Clothing;

import lt.daujotas.entities.Product;
import lt.daujotas.services.ClothingService;
import lt.daujotas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Random;

@Service
public class DataFaker {
    private static final int MAX_COUNT = 100;
    private final ProductService productService;
    private final ClothingService clothingService;
    private final RandomFaker randomFaker;

    @Autowired
    public DataFaker(ProductService productService, ClothingService clothingService, RandomFaker randomFaker) {
        this.productService = productService;
        this.clothingService = clothingService;
        this.randomFaker = randomFaker;
    }


    @Transactional
    public void initClient() {
        Faker faker = new Faker();
        Random random = new Random();
        for (int i = 0; i < MAX_COUNT; i++) {

            String sku = faker.lorem().word();
            int currency = faker.number().numberBetween(1, 5);
            String name = faker.name().name();
            String discription = faker.lordOfTheRings().character();
            int numbers = faker.number().numberBetween(1000, 10000);
            int rating = faker.number().numberBetween(1, 10);
            Instant createdAt = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS).toInstant();
            int price = faker.number().randomDigit();

            productService.saveProduct(Product.builder()
                    .sku(sku)
                    .name(name)
                    .description(discription)
                    .brandId(numbers)
                    .vendorId(numbers)
                    .typeId(numbers)
                    .price(BigDecimal.valueOf(price))
                    .currencyId(currency)
                    .ratingValue(rating)
                    .createdAt(createdAt)
                    .build());

        }

    }

}




