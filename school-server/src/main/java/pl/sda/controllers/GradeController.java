package pl.sda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.GradeApi;
import pl.sda.model.Grade;

import java.util.List;

@RestController
public class GradeController implements GradeApi {
    @Override
    @PostMapping("grade/create")
    public Grade create() {
        return null;
    }

    @Override
    @PostMapping("grade/update")
    public Grade update() {
        return null;
    }

    @Override
    @PostMapping("grade/delete")
    public Grade delete() {
        return null;
    }

    @Override
    @GetMapping("grade/find")
    public Grade find() {
        return null;
    }

    @Override
    @GetMapping("grade/findAll")
    public List<Grade> findAll() {
        return null;
    }
}
