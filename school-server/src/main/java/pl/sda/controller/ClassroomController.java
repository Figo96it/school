package pl.sda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.api.ClassroomApi;
import pl.sda.manager.ClassroomManager;
import pl.sda.model.Classroom;

import java.util.List;

@RestController
public class ClassroomController implements ClassroomApi {

    private ClassroomManager classroomManager;

    @Autowired
    public ClassroomController(ClassroomManager classroomManager) {
        this.classroomManager = classroomManager;
    }

    @Override
    @PostMapping("classroom/create")
    public Classroom create(@RequestBody Classroom classroom) {
        return classroomManager.create(classroom);
    }

    @Override
    @PostMapping("classroom/delete")
    public Integer delete(@RequestParam Integer id) {
        classroomManager.delete(id);
        return id;
    }

    @Override
    @PostMapping("classroom/edit")
    public Classroom edit(@RequestBody Classroom classroom) {
        return classroomManager.edit(classroom);
    }

    @Override
    @GetMapping("classroom/findAll")
    public List<Classroom> findAll() {
        return classroomManager.findAll();
    }

    @Override
    @GetMapping("classroom/find")
    public Classroom find(@RequestParam Integer id) {
        return classroomManager.find(id);
    }
}
