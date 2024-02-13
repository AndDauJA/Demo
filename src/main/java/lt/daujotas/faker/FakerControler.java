package lt.daujotas.faker;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FakerControler implements ApplicationRunner {

    private final DataFaker dataFaker;
    private final DataFakerClothing dataFakerClothing;


    public FakerControler(DataFaker dataFaker, DataFakerClothing dataFakerClothing) {
        this.dataFaker = dataFaker;
        this.dataFakerClothing = dataFakerClothing;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        dataFaker.initClient();
//        dataFakerClothing.initClothingFaker();
    }
}
