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
    public Plan createPlan() {
        return null;
    }

    @Override
    @PostMapping("plan/delete")
    public Plan deletePlan() {
        return null;
    }

    @Override
    @PostMapping("subject/edit")
    public Plan editPlan() {
        return null;
    }

    @Override
    @GetMapping("subject/find")
    public Plan findPlan() {
        return null;
    }

    @Override
    @GetMapping("subject/findAll")
    public List<Plan> findAllPlans() {
        return null;
    }
}
