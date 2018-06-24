package pl.sda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.StudentApi;
import pl.sda.model.Student;

import java.util.List;

@RestController
public class StudentController implements StudentApi {

    @Override
    @PostMapping("student/create")
    public Student createStudent() {
        return null;
    }

    @Override
    @PostMapping("student/update")
    public Student updateStudent() {
        return null;
    }

    @Override
    @PostMapping("school/delete")
    public Student deleteStudent() {
        return null;
    }

    @Override
    @GetMapping("school/find")
    public Student findStudent() {
        return null;
    }

    @Override
    @GetMapping("school/findAll")
    public List<Student> findAll() {
        return null;
    }


}
