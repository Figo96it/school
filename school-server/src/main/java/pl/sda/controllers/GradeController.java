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
    public Grade createGrade() {
        return null;
    }

    @Override
    @PostMapping("grade/update")
    public Grade updateGrade() {
        return null;
    }

    @Override
    @PostMapping("grade/delete")
    public Grade deleteGrade() {
        return null;
    }

    @Override
    @GetMapping("grade/find")
    public Grade findGrade() {
        return null;
    }

    @Override
    @GetMapping("grade/findAll")
    public List<Grade> findAll() {
        return null;
    }
}
