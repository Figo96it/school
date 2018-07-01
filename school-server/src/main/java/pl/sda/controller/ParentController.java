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
    public Parent create(Parent parent) {
        return parentManager.create(parent);
    }

    @Override
    @PostMapping("parent/delete")
    public Integer delete(Integer id) {
         parentManager.delete(id);
         return id;
    }

    @Override
    @PostMapping("parent/edit")
    public Parent edit(Parent parent) {
        return parentManager.edit(parent);
    }

    @Override
    @GetMapping("parent/find")
    public Parent find(Integer id) {
        return parentManager.find(id);
    }

    @Override
    @GetMapping("parent/findAll")
    public List<Parent> findAll() {
        return parentManager.findAll();
    }
}
