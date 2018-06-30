package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.StudentGrade;

@Repository
public interface StudentGgradeRepository extends CrudRepository<StudentGrade, Integer> {
}
