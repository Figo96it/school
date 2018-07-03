package pl.sda.api;


import pl.sda.model.Parent;

import java.util.List;

public interface ParentApi {

    Parent create();

    Parent delete();

    Parent edit();

    Parent find(Integer id);

    List<Parent> findAll();

    List<Parent> findParentByFirstName(String firstName);

    List<Parent> findParentByLastName(String surname);
}
