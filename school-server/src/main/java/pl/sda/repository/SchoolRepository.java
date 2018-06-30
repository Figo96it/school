package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.School;

@Repository
public interface SchoolRepository extends CrudRepository<School, Integer> {
}
