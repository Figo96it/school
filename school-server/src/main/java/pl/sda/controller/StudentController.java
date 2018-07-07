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
    @Autowired
    private StudentManager studentManager;

    @Autowired
    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    @PostMapping("student/create")
    public Student create(Student student) {
        return studentManager.create(student);
    }

    @Override
    @PostMapping("student/update")
    public Student edit(Student student) {
        return studentManager.edit(student);
    }

    @Override
    @PostMapping("student/delete")
    public Integer delete(Integer id) {
        studentManager.delete(id);
        return id;
    }

    @Override
    @GetMapping("student/find")
    public Student find(Integer id) {
        return studentManager.find(id);
    }

    @Override
    @GetMapping("student/findAll")
    public List<Student> findAll() {
        return studentManager.findAll();
    }


}
