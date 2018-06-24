package pl.sda.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ParentApi;
import pl.sda.model.Parents;

import java.util.List;

@RestController
public class ParentsController implements ParentApi {

    @Override
    @PostMapping("parent/create")
    public Parents creataParent() {
        return null;
    }

    @Override
    @PostMapping("parent/delete")
    public Parents deleteParent() {
        return null;
    }

    @Override
    @PostMapping("parent/edit")
    public Parents editParent() {
        return null;
    }

    @Override
    @PostMapping("class/find")
    public Parents findParent() {
        return null;
    }

    @Override
    @PostMapping("class/findAll")
    public List<Parents> findAllParents() {
        return null;
    }
}
