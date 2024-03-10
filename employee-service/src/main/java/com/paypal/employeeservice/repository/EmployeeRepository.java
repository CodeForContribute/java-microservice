package com.paypal.employeeservice.repository;

import com.paypal.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private List<Employee>employeeList
            = new ArrayList();
    public Employee add(Employee employee){
        this.employeeList.add(employee);
        return employee;
    }
    public Employee findById(Long id){
        return this.employeeList.stream()
                .filter(a ->a.departmentId().equals(id))
                .findFirst()
                .orElseThrow();
    }
    public List<Employee>findAll(){
        return employeeList;
    }
    public List<Employee>findByDepartment(Long departmentId){
        return employeeList.stream()
                .filter(a -> a.departmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

}
