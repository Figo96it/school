package pl.sda.api;

import pl.sda.model.Student;

import java.util.List;

public interface StudentApi {

    Student create(Student student);

    Integer delete(Integer id);

    Student edit(Student student);

    List<Student> findAll();

    Student find(Integer studentId);

    List<Student> findStudentByFirstName(String firstName);

    List<Student> findStudentByLastName(String lastName);
}
