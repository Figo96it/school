package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ParentApi;
import pl.sda.model.Parent;

import java.util.List;

@RestController
public class ParentController implements ParentApi {

    @Override
    @PostMapping("parent/create")
    public Parent create() {
        return null;
    }

    @Override
    @PostMapping("parent/delete")
    public Parent delete() {
        return null;
    }

    @Override
    @PostMapping("parent/edit")
    public Parent edit() {
        return null;
    }

    @Override
    @GetMapping("parent/find")
    public Parent find() {
        return null;
    }

    @Override
    @GetMapping("parent/findAll")
    public List<Parent> findAll() {
        return null;
    }
}
