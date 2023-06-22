package com.esquare.employee.service.service;

import com.esquare.employee.service.model.Employee;
import com.esquare.employee.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveRegisterTechData(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee saveRegisterBehData(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Object getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> fetchEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByUserId(Long userId) {
        return employeeRepository.findByUserId(userId);
    }

    @Override
    public Employee UpdateEmployeeById(Long userId, Employee employee) {
        Employee dbemp = employeeRepository.findByUserId(userId);

        if(Objects.nonNull(employee.getAssessment()) &&
            !"".equalsIgnoreCase(employee.getAssessment())){
            dbemp.setAssessment(employee.getAssessment());
        }
        if(Objects.nonNull(employee.getDate())&&
            !"".equalsIgnoreCase(String.valueOf(employee.getDate()))){
            dbemp.setDate(employee.getDate());
        }
        if(Objects.nonNull(employee.getType())&&
            !"".equalsIgnoreCase(employee.getType())){
            dbemp.setType(employee.getType());
        }
        return employeeRepository.save(dbemp);
    }

    @Override
    @Transactional
    public void DeleteEmployeeByUserId(Long userId) {
        employeeRepository.deleteByUserId(userId);
    }
}
