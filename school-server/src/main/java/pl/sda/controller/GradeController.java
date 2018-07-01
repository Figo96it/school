package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.GradeApi;
import pl.sda.manager.GradeManager;
import pl.sda.model.Grade;

import javax.persistence.criteria.CriteriaBuilder;
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
    public Grade create(Grade grade) {
        return gradeManager.create(grade);
    }

    @Override
    @PostMapping("grade/update")
    public Grade edit(Grade grade) {
        return gradeManager.edit(grade);
    }

    @Override
    @PostMapping("grade/delete")
    public void delete(Integer id) {
        gradeManager.delete(id);
    }

    @Override
    @GetMapping("grade/find")
    public Grade find(Integer id) {
        return gradeManager.find(id);
    }

    @Override
    @GetMapping("grade/findAll")
    public List<Grade> findAll() {
        return gradeManager.findAll();
    }
}
