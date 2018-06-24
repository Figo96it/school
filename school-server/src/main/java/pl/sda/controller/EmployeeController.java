package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.EmployeeApi;
import pl.sda.manager.EmployeeManager;
import pl.sda.model.Employee;

import java.util.List;

@RestController
public class EmployeeController implements EmployeeApi {

    private EmployeeManager employeeManager;

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
        return employeeManager.delete();
    }

    @Override
    @PostMapping("employee/delete")
    public Employee delete() {
        return employeeManager.edit();
    }

    @Override
    @GetMapping("employee/find")
    public Employee find() {
        return employeeManager.find();
    }

    @Override
    @GetMapping("employee/findAll")
    public List<Employee> findAll() {
        return employeeManager.findAll();
    }
}
