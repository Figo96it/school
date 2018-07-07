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
    @PostMapping("student/create")
    public Student create(@RequestBody Student student) {
        return studentManager.create(student);
    }

    @Override
    @PostMapping("student/update")
    public Student edit(@RequestBody Student student) {
        return studentManager.edit(student);
    }

    @Override
    @PostMapping("student/delete")
    public Integer delete(@RequestParam Integer id) {
        studentManager.delete(id);
        return id;
    }

    @Override
    @GetMapping("student/find")
    public Student find(@RequestParam Integer id) {
        return studentManager.find(id);
    }

    @GetMapping("student/find/{id}/{firstName}/{lastName}")
    public Student find2(
            @PathVariable Integer id,
            @PathVariable String firstName,
            @PathVariable String lastName) {
        return studentManager.find(id);
    }

    @Override
    @GetMapping("student/findAll")
    public List<Student> findAll() {
        return studentManager.findAll();
    }


}
