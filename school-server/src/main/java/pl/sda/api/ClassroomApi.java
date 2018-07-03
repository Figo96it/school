package pl.sda.api;

import pl.sda.model.Classroom;

import java.util.List;

public interface ClassroomApi {

    Classroom create();

    Classroom delete();

    Classroom edit();

    List<Classroom> findAll();

    Classroom find(Integer id);

    Classroom findClassroomByClassName(String className);
}
