package com.esquare.employee.service.service;

import com.esquare.employee.service.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveRegisterTechData(Employee employee);

    Employee saveRegisterBehData(Employee employee);

    Object getAllEmployees();

    List<Employee> fetchEmployee();

    Employee findEmployeeByUserId(Long userId);

    Employee UpdateEmployeeById(Long userId, Employee employee);

    void DeleteEmployeeByUserId(Long userId);
}
