package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Grade;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Integer> {
}
