package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.EmployeeApi;
import pl.sda.model.Employee;

import java.util.List;

@RestController
public class EmployeeController implements EmployeeApi {

    @Override
    @PostMapping("employee/create")
    public Employee create() {
        return null;
    }

    @Override
    @PostMapping("employee/update")
    public Employee update() {
        return null;
    }

    @Override
    @PostMapping("employee/delete")
    public Employee delete() {
        return null;
    }

    @Override
    @GetMapping("employee/find")
    public Employee find() {
        return null;
    }

    @Override
    @GetMapping("employee/findAll")
    public List<Employee> findAll() {
        return null;
    }
}
