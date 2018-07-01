package pl.sda.api;

import pl.sda.model.Plan;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PlanApi {

    Plan create(Plan plan);

    Integer delete(Integer id);

    Plan edit(Plan plan);

    Plan find(Integer id);

    List<Plan> findAll();
}
