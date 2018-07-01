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
    public Subject create(Subject subject) {
        return subjectManager.create(subject);
    }

    @Override
    @PostMapping("subject/delete")
    public Integer delete(Integer id) {
        subjectManager.delete(id);
        return id;
    }

    @Override
    @PostMapping("subject/edit")
    public Subject edit(Subject subject) {
        return subjectManager.edit(subject);
    }

    @Override
    @GetMapping("subject/find")
    public Subject find(Integer id) {
        return subjectManager.find(id);
    }

    @Override
    @GetMapping("subject/findAll")
    public List<Subject> findAll() {
        return subjectManager.findAll();
    }
}
