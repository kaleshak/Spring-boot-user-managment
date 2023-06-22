package com.esquare.admin.service.controller;

import com.esquare.admin.service.model.Employee;
import com.esquare.admin.service.service.AdminService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    public static final String ADMIN_SERVICE = "admin";

    @Autowired
    private AdminService adminService;

    @GetMapping
    @CircuitBreaker(name = "ADMIN_SERVICE", fallbackMethod = "listFallback")
    public String registeredList(Model model) {
        List<Employee> registeredEmployees = adminService.fetchRegisteredList();
        logger.info("List the fetched data on the Admin page");
        model.addAttribute("employees", registeredEmployees);
        return "admin";
    }

    public String listFallback(Model model, Exception e) {
        String errorMessage = "Service is currently unavailable. Please try again later.";
        model.addAttribute("errorMessage", errorMessage);
        return "fallback";
    }
}

