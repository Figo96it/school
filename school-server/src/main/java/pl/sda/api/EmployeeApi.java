package pl.sda.api;

import pl.sda.model.Employee;

import java.util.List;

public interface EmployeeApi {

    Employee create();

    Employee update();

    Employee delete();

    Employee find();

    List<Employee> findAll();
}
