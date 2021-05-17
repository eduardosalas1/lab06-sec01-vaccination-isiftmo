package cs.lab.lab06sec01vaccinationisiftmo;

import data.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"controller", "business", "config"})
@EntityScan("data")
@EnableJpaRepositories("data.repositories")
public class Lab06Sec01VaccinationIsiftmoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab06Sec01VaccinationIsiftmoApplication.class, args);
    }


}
