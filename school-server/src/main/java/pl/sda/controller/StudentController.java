package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping(value = "student/create", consumes = "application/json", produces = "application/json")
    public Student create(@RequestBody Student student) {
        return studentManager.create(student);
    }

    @Override
    @PostMapping(value = "student/update", consumes = "application/json", produces = "application/json")
    public Student edit(@RequestBody Student student) {
        return studentManager.edit(student);
    }

    @Override
    @PostMapping(value = "student/delete", consumes = "application/json", produces = "application/json")
    public Integer delete(@RequestParam Integer id) {
        Student student = studentManager.find(id);
        student.setParent(null);
        studentManager.delete(id);
        return id;
    }

    @Override
    @GetMapping(value = "student/find", consumes = "application/json", produces = "application/json")
    public Student find(@RequestParam Integer id) {
        return studentManager.find(id);
    }

    @GetMapping(value = "student/find/{id}/{firstName}/{lastName}", consumes = "application/json", produces = "application/json")
    public Student find2(
            @PathVariable Integer id,
            @PathVariable String firstName,
            @PathVariable String lastName) {
        return studentManager.find(id);
    }

    @Override
    @GetMapping(value = "student/findAll", consumes = "application/json", produces = "application/json")
    public List<Student> findAll() {
        return studentManager.findAll();
    }


}
