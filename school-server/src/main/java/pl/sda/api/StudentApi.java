package pl.sda.api;

import pl.sda.model.Student;

import java.util.List;

public interface StudentApi {

    Student create(Student student);

    Integer delete(Integer id);

    Student edit(Student student);

    Student find(Integer id);

    List<Student> findAll();
}
