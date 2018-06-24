package pl.sda.api;

import pl.sda.model.Employee;

import java.util.List;

public interface EmployeeApi {

    Employee createEmployee();
    Employee updateEmployee();
    Employee deleteEmployee();
    Employee findEmployee();
    List<Employee> findAll();
}
