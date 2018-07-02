package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Plan;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PlanManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public Plan create() {
        return null;
    }

    public Plan delete() {
        return null;
    }

    public Plan edit() {
        return null;
    }

    public Plan find() {
        return null;
    }

    public List<Plan> findAll() {
        return null;
    }
}
