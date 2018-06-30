package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Classroom;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {
}
