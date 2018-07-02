package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.PlanApi;
import pl.sda.manager.PlanManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Plan;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class PlanController implements PlanApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private PlanManager planManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public PlanController(PlanManager planManager) {
        this.planManager = planManager;
    }

    @Override
    @PostMapping("plan/add")
    public Plan create() {
        return planManager.create();
    }

    @Override
    @PostMapping("plan/delete")
    public Plan delete() {
        return planManager.delete();
    }

    @Override
    @PostMapping("plan/edit")
    public Plan edit() {
        return planManager.edit();
    }

    @Override
    @GetMapping("plan/find")
    public Plan find() {
        return planManager.find();
    }

    @Override
    @GetMapping("plan/findAll")
    public List<Plan> findAll() {
        if(mockData){
            return new ArrayList<Plan>();
        }else{
            return planManager.findAll();
        }
    }
}
