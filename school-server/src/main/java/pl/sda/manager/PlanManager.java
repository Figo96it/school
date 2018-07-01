package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Plan;
import pl.sda.repository.PlanRepository;

import java.util.List;

@Component
public class PlanManager {
    @Autowired
    PlanRepository planRepository;

    public Plan create(Plan plan) {
        return planRepository.save(plan);
    }

    public void delete(Integer id) {
        planRepository.delete(id);
    }

    public Plan edit(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan find(Integer id) {
        return planRepository.findOne(id);
    }

    public List<Plan> findAll() {
        return (List<Plan>) planRepository.findAll();
    }
}
