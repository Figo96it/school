package pl.sda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.SchoolApi;
import pl.sda.model.School;

import java.util.List;

@RestController
public class SchoolController implements SchoolApi {
    @Override
    @PostMapping("school/create")
    public School createSchool() {
        return null;
    }

    @Override
    @PostMapping("school/update")
    public School updateSchool() {
        return null;
    }

    @Override
    @PostMapping("school/delete")
    public School deleteSchool() {
        return null;
    }

    @Override
    @GetMapping("school/find")
    public School findSchool() {
        return null;
    }

    @Override
    @GetMapping("school/findAll")
    public List<School> findAll() {
        return null;
    }
}
