package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
