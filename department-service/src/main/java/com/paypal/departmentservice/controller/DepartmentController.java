package com.paypal.departmentservice.controller;

import com.paypal.departmentservice.client.EmployeeClient;
import com.paypal.departmentservice.model.Department;
import com.paypal.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody  Department department) {
        LOGGER.info("Adding department to DB !!!!");
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("find all departments !!");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long departmentId) {
        LOGGER.info("find department with id : {}", departmentId);
        return departmentRepository.findById(departmentId);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("find all departments !!");
        List<Department>departments = departmentRepository.findAll();
        departments.forEach(department -> {
            department.setEmployees(
                    employeeClient.findAllEmployeeByDepartment(department.getId())
            );
        });
        return departments;
    }
}
