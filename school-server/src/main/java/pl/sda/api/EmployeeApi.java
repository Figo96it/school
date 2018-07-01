package pl.sda.api;

import pl.sda.model.Employee;

import java.util.List;

public interface EmployeeApi {

    Employee create(Employee employee);

    void delete(Integer id);

    Employee edit(Employee employee);

    Employee find(Integer id);

    List<Employee> findAll();
}
