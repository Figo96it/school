package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.api.SchoolApi;
import pl.sda.manager.SchoolManager;
import pl.sda.model.School;

import java.util.List;

@RestController
public class SchoolController implements SchoolApi {

    private SchoolManager schoolManager;

    @Autowired
    public SchoolController(SchoolManager schoolManager) {
        this.schoolManager = schoolManager;
    }

    @Override
    @PostMapping("school/create")
    public School create(@RequestBody School school) {
        return schoolManager.create(school);
    }

    @Override
    @PostMapping("school/update")
    public School edit(@RequestBody School school) {
        return schoolManager.edit(school);
    }

    @Override
    @PostMapping("school/delete")
    public Integer delete(@RequestParam Integer id) {
        schoolManager.delete(id);
        return id;
    }

    @Override
    @GetMapping("school/find")
    public School find(@RequestParam Integer id) {
        return schoolManager.find(id);
    }

    @Override
    @GetMapping("school/findAll")
    public List<School> findAll() {
        return schoolManager.findAll();
    }
}
