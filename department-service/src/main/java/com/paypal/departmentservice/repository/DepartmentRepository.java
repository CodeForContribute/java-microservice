package com.paypal.departmentservice.repository;

import com.paypal.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private final List<Department> departmentList
            = new ArrayList<>();

    public Department addDepartment(Department department) {
        this.departmentList.add(department);
        return department;
    }

    public Department findById(Long departmentId) {
        return this.departmentList.stream()
                .filter(department -> department.getId().equals(departmentId))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departmentList;
    }
}
