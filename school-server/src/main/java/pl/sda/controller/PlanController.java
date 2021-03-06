package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.api.PlanApi;
import pl.sda.manager.PlanManager;
import pl.sda.model.Plan;

import java.util.List;

@RestController
public class PlanController implements PlanApi {

    private PlanManager planManager;

    @Autowired
    public PlanController(PlanManager planManager) {
        this.planManager = planManager;
    }

    @Override
    @PostMapping("plan/add")
    public Plan create(@RequestBody Plan plan) {
        return planManager.create(plan);
    }

    @Override
    @PostMapping("plan/delete")
    public Integer delete(@RequestParam Integer id) {
        planManager.delete(id);
        return id;
    }

    @Override
    @PostMapping("plan/edit")
    public Plan edit(@RequestBody Plan plan) {
        return planManager.edit(plan);
    }

    @Override
    @GetMapping("plan/find")
    public Plan find(@RequestParam Integer id) {
        return planManager.find(id);
    }

    @Override
    @GetMapping("plan/findAll")
    public List<Plan> findAll() {
        return planManager.findAll();
    }
}
