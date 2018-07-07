package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Employee;
import pl.sda.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class EmployeeManager {
    @Autowired
    EmployeeRepository employeeRepository;

    private static final Logger logger = getLogger(SchoolController.class);

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Integer delete(Integer id) {
        employeeRepository.delete(id);
        return id;
    }

    public Employee edit(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee find(Integer id) {
        return employeeRepository.findOne(id);
    }

    public List<Employee> findAll() {
        return StreamSupport
                .stream(employeeRepository.findAll().spliterator(), false).collect(toList());

    }

    public List<Employee> findEmployeeByLastName(String lastName) {
        return null;
    }

    public List<Employee> findEmployeeByFirstName(String firstName) {
        return null;
    }
}
