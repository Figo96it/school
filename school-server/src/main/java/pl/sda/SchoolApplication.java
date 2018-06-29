package pl.sda;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = "pl.sda.*")
@EntityScan("pl.sda.*")
public class SchoolApplication {
    public static void main(String[] args) {
        run(SchoolApplication.class, args);
    }
}
