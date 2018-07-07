package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Plan;
import pl.sda.repository.PlanRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PlanManager {
    @Autowired
    PlanRepository planRepository;

    private static final Logger logger = getLogger(SchoolController.class);

    public Plan create(Plan plan) {
        return planRepository.save(plan);
    }

    public Integer delete(Integer id) {
        planRepository.delete(id);
        return id;
    }

    public Plan edit(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan find(Integer id) {
        return planRepository.findOne(id);
    }

    public List<Plan> findAll() {
        return StreamSupport
                .stream(planRepository.findAll().spliterator(), false).collect(toList());

    }
}
