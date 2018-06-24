package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.SubjectApi;
import pl.sda.model.Subject;

@RestController
public class SubjectController implements SubjectApi {

    @Override
    @PostMapping("subject/add")
    public Subject create() {
        return null;
    }

    @Override
    @PostMapping("subject/delete")
    public Subject delete() {
        return null;
    }

    @Override
    @PostMapping("subject/edit")
    public Subject edit() {
        return null;
    }

    @Override
    @GetMapping("subject/find")
    public Subject find() {
        return null;
    }

    @Override
    @GetMapping("subject/findAll")
    public Subject findAll() {
        return null;
    }
}
