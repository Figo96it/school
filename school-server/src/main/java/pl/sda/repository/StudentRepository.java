package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Parent;
import pl.sda.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
