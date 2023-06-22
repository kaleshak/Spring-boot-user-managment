package com.esquare.employee.service.controller;

import com.esquare.employee.service.model.Employee;
import com.esquare.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String employee() {
        return "employee";
    }

    @GetMapping("/register_tech")
    public String registerTech(Model model) {
        model.addAttribute("employee", new Employee());
        return "register-tech";
    }

    @GetMapping("/register_beh")
    public String registerBeh(Model model) {
        model.addAttribute("employee", new Employee());
        return "register-beh";
    }

    @PostMapping("/register_tech")
    public String saveRegisterTechData(@ModelAttribute Employee employee, Model model) {
        employee.setType("TECH");
        employeeService.saveRegisterTechData(employee);
        model.addAttribute("msg1", "Technical Assessment Registered Successfully");
        return "redirect:http://localhost:9191/employee";
    }

    @PostMapping("/register_beh")
    public String saveRegisterBehData(@ModelAttribute Employee employee, Model model) {
        employee.setType("BEH");
        employeeService.saveRegisterBehData(employee);
        model.addAttribute("msg2", "Behavioural Assessment Registered Successfully");
        return "redirect:http://localhost:9191/employee";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Employee> fetchEmployee() {
        return employeeService.fetchEmployee();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") Long userId) {
        return employeeService.findEmployeeByUserId(userId);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Transactional
    public String DeleteEmployeeByUserId(@PathVariable("id") Long userId) {
        employeeService.DeleteEmployeeByUserId(userId);
        return "Deleted successfully";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Employee UpdateEmployeeById(@PathVariable("id") Long userId,@RequestBody Employee employee){
        return employeeService.UpdateEmployeeById(userId,employee);
    }
}
