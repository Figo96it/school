package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.*;

@Repository
public interface TestRepository extends CrudRepository<Subject, Integer> {
}
