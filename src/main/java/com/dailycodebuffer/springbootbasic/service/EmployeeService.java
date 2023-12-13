package com.dailycodebuffer.springbootbasic.service;

import com.dailycodebuffer.springbootbasic.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String empId);

    String deleteById(String empId);
}
