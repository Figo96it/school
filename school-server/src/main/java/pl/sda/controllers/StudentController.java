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
    public Student create() {
        return null;
    }

    @Override
    @PostMapping("student/update")
    public Student update() {
        return null;
    }

    @Override
    @PostMapping("student/delete")
    public Student delete() {
        return null;
    }

    @Override
    @GetMapping("student/find")
    public Student find() {
        return null;
    }

    @Override
    @GetMapping("student/findAll")
    public List<Student> findAll() {
        return null;
    }


}
