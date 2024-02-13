package lt.daujotas.faker;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class RandomFaker {
    Random random = new Random();

    public String reandomSize() {


        String[] sizes = {"L", "M", "S", "XL", "XXL", "XS", "XXS"};
        String randomSize = null;
        for (
                int j = 0;
                j < 1; j++) {
            int randomIndex = random.nextInt(sizes.length);
            randomSize = sizes[randomIndex];

        }
        return randomSize;
    }

    public String randomGender() {
        String[] gender = {"Male", "Female", "Kid"};
        String randomGender = null;
        for (
                int k = 0;
                k < 1; k++) {
            int randomIndexG = random.nextInt(gender.length);
            randomGender = gender[randomIndexG];
        }
        return randomGender;
    }

}
