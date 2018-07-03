package pl.sda.api;

import pl.sda.model.Student;

import java.util.List;

public interface StudentApi {

    Student create();

    Student update();

    Student delete();

    Student find(Integer studentId);

    List<Student> findAll();

    List<Student> findStudentByFirstName(String firstName);

    List<Student> findStudentByLastName(String lastName);
}
