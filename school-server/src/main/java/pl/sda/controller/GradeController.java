package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.GradeApi;
import pl.sda.manager.GradeManager;
import pl.sda.model.Grade;

import java.util.List;

@RestController
public class GradeController implements GradeApi {

    private GradeManager gradeManager;

    @Autowired
    public GradeController(GradeManager gradeManager) {
        this.gradeManager = gradeManager;
    }

    @Override
    @PostMapping("grade/create")
    public Grade create() {
        return gradeManager.create();
    }

    @Override
    @PostMapping("grade/update")
    public Grade update() {
        return gradeManager.delete();
    }

    @Override
    @PostMapping("grade/delete")
    public Grade delete() {
        return gradeManager.edit();
    }

    @Override
    @GetMapping("grade/find")
    public Grade find() {
        return gradeManager.find();
    }

    @Override
    @GetMapping("grade/findAll")
    public List<Grade> findAll() {
        return gradeManager.findAll();
    }
}
