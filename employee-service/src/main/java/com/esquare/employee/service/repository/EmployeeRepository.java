package com.esquare.employee.service.repository;

import com.esquare.employee.service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
