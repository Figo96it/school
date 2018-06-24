package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Parent;

@Repository
public interface ParentsRepository extends CrudRepository<Parent, Integer> {
}
