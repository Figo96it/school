package pl.sda.api;


import pl.sda.model.Parent;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ParentApi {

    Parent create(Parent parent);

    void delete(Integer id);

    Parent edit(Parent parent);

    Parent find(Integer id);

    List<Parent> findAll();
}
