package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ParentsApi;
import pl.sda.model.Parents;

import java.util.List;

@RestController
public class ParentsController implements ParentsApi {

    @Override
    @PostMapping("parents/create")
    public Parents create() {
        return null;
    }

    @Override
    @PostMapping("parents/delete")
    public Parents delete() {
        return null;
    }

    @Override
    @PostMapping("parents/edit")
    public Parents edit() {
        return null;
    }

    @Override
    @GetMapping("parents/find")
    public Parents find() {
        return null;
    }

    @Override
    @GetMapping("parents/findAll")
    public List<Parents> findAll() {
        return null;
    }
}
