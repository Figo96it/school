package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.StudentApi;
import pl.sda.manager.StudentManager;
import pl.sda.model.Student;

import java.util.List;

@RestController
public class StudentController implements StudentApi {

    private StudentManager studentManager;

    @Autowired
    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    @PostMapping("student/create")
    public Student create() {
        return studentManager.create();
    }

    @Override
    @PostMapping("student/update")
    public Student update() {
        return studentManager.edit();
    }

    @Override
    @PostMapping("student/delete")
    public Student delete() {
        return studentManager.delete();
    }

    @Override
    @GetMapping("student/find")
    public Student find() {
        return studentManager.find();
    }

    @Override
    @GetMapping("student/findAll")
    public List<Student> findAll() {
        return studentManager.findAll();
    }


}
