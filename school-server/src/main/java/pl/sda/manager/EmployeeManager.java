package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Employee;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class EmployeeManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public Employee create() {
        return null;
    }

    public Employee delete() {
        return null;
    }

    public Employee edit() {
        return null;
    }

    public Employee find() {
        return null;
    }

    public List<Employee> findAll() {
        return null;
    }
}
