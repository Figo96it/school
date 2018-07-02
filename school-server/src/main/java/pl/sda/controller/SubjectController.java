package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.SubjectApi;
import pl.sda.manager.SubjectManager;
import pl.sda.model.Subject;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class SubjectController implements SubjectApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private SubjectManager subjectManager;

    @Value("${use.mockData}")
    private boolean mockData;

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
