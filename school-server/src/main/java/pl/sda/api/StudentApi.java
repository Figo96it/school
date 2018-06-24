package pl.sda.api;

import pl.sda.model.Student;

import java.util.List;

public interface StudentApi {

    Student create();

    Student update();

    Student delete();

    Student find();

    List<Student> findAll();
}
