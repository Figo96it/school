package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.EmployeeApi;
import pl.sda.manager.EmployeeManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Employee;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class EmployeeController implements EmployeeApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private EmployeeManager employeeManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    @PostMapping("employee/create")
    public Employee create() {
        return employeeManager.create();
    }

    @Override
    @PostMapping("employee/update")
    public Employee update() {
        return employeeManager.edit();
    }

    @Override
    @PostMapping("employee/delete")
    public Employee delete() {
        return employeeManager.delete();
    }

    @Override
    @GetMapping("employee/find")
    public Employee find() {
        return employeeManager.find();
    }

    @Override
    @GetMapping("employee/findAll")
    public List<Employee> findAll() {
        if (mockData) {
            return MockDataResolver.findAllEmployees();
        } else {
            return employeeManager.findAll();
        }
    }
}
