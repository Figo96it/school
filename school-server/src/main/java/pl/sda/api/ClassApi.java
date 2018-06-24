package pl.sda.api;

import pl.sda.model.Class;

import java.util.List;

public interface ClassApi {

    Class create();

    Class delete();

    Class edit();

    List<Class> findAll();

    Class find();
}
