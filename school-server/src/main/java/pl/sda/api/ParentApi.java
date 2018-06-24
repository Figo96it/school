package pl.sda.api;


import pl.sda.model.Parent;

import java.util.List;

public interface ParentApi {

    Parent create();

    Parent delete();

    Parent edit();

    Parent find();

    List<Parent> findAll();
}
