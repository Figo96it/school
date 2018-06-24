package pl.sda.api;

import pl.sda.model.Student;

import java.util.List;

public interface StudentApi {

    Student createStudent();
    Student updateStudent();
    Student deleteStudent();
    Student findStudent();
    List<Student> findAll();
}
