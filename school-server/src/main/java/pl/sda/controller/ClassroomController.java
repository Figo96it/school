package pl.sda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @PostMapping("class/create")
    public Classroom create() {
        return classroomManager.create();
    }

    @Override
    @PostMapping("class/delete")
    public Classroom delete() {
        return classroomManager.delete();
    }

    @Override
    @PostMapping("class/edit")
    public Classroom edit() {
        return classroomManager.edit();
    }

    @Override
    @GetMapping("class/findAll")
    public List<Classroom> findAll() {
        return classroomManager.findAll();
    }

    @Override
    @GetMapping("class/find")
    public Classroom find() {
        return classroomManager.find();
    }
}
