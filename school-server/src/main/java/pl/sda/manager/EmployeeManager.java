package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Employee;
import pl.sda.repository.EmployeeRepository;

import java.util.List;

@Component
public class EmployeeManager {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Integer id) {
        employeeRepository.delete(id);
    }

    public Employee edit(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee find(Integer id) {
        return employeeRepository.findOne(id);
    }

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
