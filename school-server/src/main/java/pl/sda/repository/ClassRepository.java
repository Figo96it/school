package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class,Long> {
}
