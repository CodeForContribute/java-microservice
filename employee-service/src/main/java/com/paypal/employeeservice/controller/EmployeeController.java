package com.paypal.employeeservice.controller;

import com.paypal.employeeservice.model.Employee;
import com.paypal.employeeservice.repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Adding employee: {}", employee);
        return this.employeeRepository.add(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("find employee with id: {}", id);
        return this.employeeRepository.findById(id);
    }
    @GetMapping("/departments/{departmentId}")
    public List<Employee>findAllEmployeeByDepartment(@PathVariable Long departmentId){
        LOGGER.info("finding all the employee using department id : {}, !!", departmentId);
        return this.employeeRepository.findByDepartment(departmentId);
    }
}
