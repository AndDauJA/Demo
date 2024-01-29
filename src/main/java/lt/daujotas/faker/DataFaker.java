package lt.daujotas.faker;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lt.daujotas.entities.Product;
import lt.daujotas.services.ServiceForProduct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Service
public class DataFaker {
    private static final int MAX_COUNT = 100;
    private final ServiceForProduct serviceForProduct;

    public DataFaker(ServiceForProduct serviceForProduct) {
        this.serviceForProduct = serviceForProduct;
    }


    @Transactional
    public void initClient() {
        Faker faker = new Faker();

        for (int i = 0; i < MAX_COUNT; i++) {

            String name = faker.lorem().word();
            int currency = faker.number().numberBetween(1, 5);
            String sku = faker.lorem().word();
            String discription = faker.lordOfTheRings().character();
            int numbers = faker.number().numberBetween(1000, 10000);
            int rating=faker.number().numberBetween(1, 10);
            Instant createdAt = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS).toInstant();
            int price=faker.number().randomDigit();

            serviceForProduct.saveProduct(Product.builder()
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
//Papildziau duomenimins


}
