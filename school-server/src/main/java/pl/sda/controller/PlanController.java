package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.PlanApi;
import pl.sda.model.Plan;

import java.util.List;

@RestController
public class PlanController implements PlanApi {

    @Override
    @PostMapping("plan/add")
    public Plan create() {
        return null;
    }

    @Override
    @PostMapping("plan/delete")
    public Plan delete() {
        return null;
    }

    @Override
    @PostMapping("plan/edit")
    public Plan edit() {
        return null;
    }

    @Override
    @GetMapping("plan/find")
    public Plan find() {
        return null;
    }

    @Override
    @GetMapping("plan/findAll")
    public List<Plan> findAll() {
        return null;
    }
}
