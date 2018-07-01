package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Employee;
import pl.sda.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class EmployeeManager {
    @Autowired
    EmployeeRepository employeeRepository;

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
}
