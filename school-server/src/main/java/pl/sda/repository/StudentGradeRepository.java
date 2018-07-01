package pl.sda.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.StudentGrade;

import java.util.List;

@Repository
public interface StudentGradeRepository extends CrudRepository<StudentGrade, Integer> {
    List<StudentGrade> findAll();
}
