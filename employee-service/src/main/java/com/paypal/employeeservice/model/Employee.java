package com.paypal.employeeservice.model;

public record Employee(Long id, Long departmentId, String name, int age) {
}
