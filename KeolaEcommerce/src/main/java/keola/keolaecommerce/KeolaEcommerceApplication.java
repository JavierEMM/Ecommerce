package keola.keolaecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "keola.keolaecommerce.Repositories")
public class KeolaEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeolaEcommerceApplication.class, args);
    }

}
