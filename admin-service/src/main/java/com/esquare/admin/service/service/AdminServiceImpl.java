package com.esquare.admin.service.service;

import com.esquare.admin.service.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{


    @Autowired
    private RestTemplate restTemplate;

    private static final String EMPLOYEE_URL_MS = "http://localhost:9191/";

    @Override
    public List<Employee> fetchRegisteredList() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                EMPLOYEE_URL_MS + "employee/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {}
        );
        List<Employee> employees = response.getBody();
        return employees;
    }
}
