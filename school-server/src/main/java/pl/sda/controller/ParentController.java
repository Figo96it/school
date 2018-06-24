package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ParentApi;
import pl.sda.manager.ParentManager;
import pl.sda.model.Parent;

import java.util.List;

@RestController
public class ParentController implements ParentApi {

    private ParentManager parentManager;

    @Autowired
    public ParentController(ParentManager parentManager) {
        this.parentManager = parentManager;
    }

    @Override
    @PostMapping("parent/create")
    public Parent create() {
        return parentManager.create();
    }

    @Override
    @PostMapping("parent/delete")
    public Parent delete() {
        return parentManager.delete();
    }

    @Override
    @PostMapping("parent/edit")
    public Parent edit() {
        return parentManager.edit();
    }

    @Override
    @GetMapping("parent/find")
    public Parent find() {
        return parentManager.find();
    }

    @Override
    @GetMapping("parent/findAll")
    public List<Parent> findAll() {
        return parentManager.findAll();
    }
}
