package pl.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import pl.sda.repository.GradeRepository;
import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "pl.sda.*")
@EntityScan("pl.sda.*")
public class SchoolApplication implements CommandLineRunner {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(gradeRepository.count());
    }
}
