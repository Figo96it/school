package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Parent create(@RequestBody Parent parent) {
        return parentManager.create(parent);
    }

    @Override
    @PostMapping("parent/delete")
    public Integer delete(@RequestParam Integer id) {
        parentManager.delete(id);
        return id;
    }

    @Override
    @PostMapping("parent/edit")
    public Parent edit(@RequestBody Parent parent) {
        return parentManager.edit(parent);
    }

    @Override
    @GetMapping("parent/find")
    public Parent find(@RequestParam Integer id) {
        return parentManager.find(id);
    }

    @Override
    @GetMapping("parent/findAll")
    public List<Parent> findAll() {
        return parentManager.findAll();
    }
}
