package lt.daujotas.faker;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class DataFaker {
    private static final int MAX_COUNT = 100;
    private final ClientAccountService clientAccountService;
    public DataFaker(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @Transactional
    public void initClient() {
        Faker faker = new Faker();

        for (int i = 0; i < MAX_COUNT; i++) {

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String phoneNu = "+370"+faker.number().numberBetween(10000000, 99999999);

            java.util.Date utilBirthDate = faker.date().birthday();
            Date birthDate = new Date(utilBirthDate.getTime());
            String postAddress = faker.address().fullAddress();
            String email = faker.name().username()+"@"+"gmail.com";
            String username = faker.name().username();
            String password =faker.animal().name();
            clientAccountService.saveClientDto(ClientDto.builder()
                    .userName(username)
                    .firstName(firstName)
                    .lastName(lastName)
                    .middleName(firstName)
                    .phoneNumber(phoneNu)
                    .emailAddress(email)
                    .accountUuid(UUID.randomUUID())
                    .dateofbirth(birthDate)
                    .postAddres(postAddress)
                    .password(password)
                    .repeatPassrowd(password)
                    .build());

        }
    }
//Papildziau duomenimins


}
