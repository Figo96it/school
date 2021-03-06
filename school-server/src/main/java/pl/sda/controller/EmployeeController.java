package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Employee create(@RequestBody Employee employee) {
        return employeeManager.create(employee);
    }

    @Override
    @PostMapping("employee/update")
    public Employee edit(@RequestBody Employee employee) {
        return employeeManager.edit(employee);
    }

    @Override
    @PostMapping("employee/delete")
    public Integer delete(@RequestParam Integer id) {
        employeeManager.delete(id);
        return id;
    }

    @Override
    @GetMapping("employee/find")
    public Employee find(@RequestParam Integer id) {
        return employeeManager.find(id);
    }

    @Override
    @GetMapping("employee/findAll")
    public List<Employee> findAll() {
        return employeeManager.findAll();
    }
}
