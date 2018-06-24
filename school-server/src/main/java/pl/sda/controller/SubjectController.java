package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.SubjectApi;
import pl.sda.manager.SubjectManager;
import pl.sda.model.Subject;

import java.util.List;

@RestController
public class SubjectController implements SubjectApi {

    private SubjectManager subjectManager;

    @Autowired
    public SubjectController(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    @Override
    @PostMapping("subject/add")
    public Subject create() {
        return subjectManager.create();
    }

    @Override
    @PostMapping("subject/delete")
    public Subject delete() {
        return subjectManager.delete();
    }

    @Override
    @PostMapping("subject/edit")
    public Subject edit() {
        return subjectManager.edit();
    }

    @Override
    @GetMapping("subject/find")
    public Subject find() {
        return subjectManager.find();
    }

    @Override
    @GetMapping("subject/findAll")
    public List<Subject> findAll() {
        return subjectManager.findAll();
    }
}
