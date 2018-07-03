package pl.sda.api;

import pl.sda.model.Employee;

import java.util.List;

public interface EmployeeApi {

    Employee create();

    Employee update();

    Employee delete();

    Employee find(Integer id);

    List<Employee> findAll();

    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeeByLastName(String lastName);
}
