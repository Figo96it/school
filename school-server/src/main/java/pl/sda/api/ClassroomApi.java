package pl.sda.api;

import pl.sda.model.Classroom;

import java.util.List;

public interface ClassroomApi {

    Classroom create(Classroom classroom);

    Integer delete(Integer id);

    Classroom edit(Classroom classroom);

    Classroom find(Integer id);

    List<Classroom> findAll();
}
