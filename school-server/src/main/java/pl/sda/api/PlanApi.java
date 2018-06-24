package pl.sda.api;

import pl.sda.model.Plan;

import java.util.List;

public interface PlanApi {
    public Plan createPlan();
    public Plan deletePlan();
    public Plan editPlan();
    public Plan findPlan();
    public List<Plan> findAllPlans();
}
