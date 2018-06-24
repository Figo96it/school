package pl.sda.api;

import pl.sda.model.Plan;

import java.util.List;

public interface PlanApi {

    Plan create();

    Plan delete();

    Plan edit();

    Plan find();

    List<Plan> findAll();
}
