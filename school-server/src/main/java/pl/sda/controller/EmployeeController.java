package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.EmployeeApi;
import pl.sda.manager.EmployeeManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Employee;

import java.util.ArrayList;
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
    public Employee create(Employee employee) {
        return employeeManager.create(employee);
    }

    @Override
    @PostMapping("employee/update")
    public Employee edit(Employee employee) {
        return employeeManager.edit(employee);
    }

    @Override
    @PostMapping("employee/delete")
    public Integer delete(Integer id) {
        employeeManager.delete(id);
        return id;
    }

    @Override
    @GetMapping("employee/find/id/{id}")
    public Employee find(@PathVariable Integer id) {
        if (mockData) {
            List<Employee> employees = MockDataResolver.findAllEmployees();
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    return employee;
                }
            }
        } else {
            return employeeManager.find(id);
        }
        return employeeManager.find(id);
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

    @Override
    @GetMapping("employee/find/name/{firstName}")
    public List<Employee> findEmployeeByFirstName(@PathVariable String firstName) {
        if (mockData) {
            List<Employee> employees = MockDataResolver.findAllEmployees();
            List<Employee> employeesByFirstName = new ArrayList<Employee>();
            for (Employee employee : employees) {
                if (employee.getFirstName().equals(firstName)) {
                    employeesByFirstName.add(employee);
                }
            }
            return employeesByFirstName;
        } else {
            return employeeManager.findEmployeeByFirstName(firstName);
        }
    }

    @Override
    @GetMapping("employee/find/surname/{lastName}")
    public List<Employee> findEmployeeByLastName(@PathVariable String lastName) {
        if (mockData) {
            List<Employee> employees = MockDataResolver.findAllEmployees();
            List<Employee> employeesBySurname = new ArrayList<Employee>();
            for (Employee employee : employees) {
                if (employee.getLastName().equals(lastName)) {
                    employeesBySurname.add(employee);
                }
            }
            return employeesBySurname;
        } else {
            return employeeManager.findEmployeeByLastName(lastName);
        }
    }
}
