package pl.sda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ClassApi;
import pl.sda.manager.ClassManager;
import pl.sda.model.Class;

import java.util.List;

@RestController
public class ClassController implements ClassApi {

    private ClassManager classManager;

    @Autowired
    public ClassController(ClassManager classManager) {
        this.classManager = classManager;
    }

    @Override
    @PostMapping("class/create")
    public Class create() {
        return classManager.create();
    }

    @Override
    @PostMapping("class/delete")
    public Class delete() {
        return classManager.delete();
    }

    @Override
    @PostMapping("class/edit")
    public Class edit() {
        return classManager.edit();
    }

    @Override
    @GetMapping("class/findAll")
    public List<Class> findAll() {
        return classManager.findAll();
    }

    @Override
    @GetMapping("class/find")
    public Class find() {
        return classManager.find();
    }
}
