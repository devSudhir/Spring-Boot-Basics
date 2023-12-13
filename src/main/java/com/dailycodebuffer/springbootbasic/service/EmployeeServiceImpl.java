package com.dailycodebuffer.springbootbasic.service;

import com.dailycodebuffer.springbootbasic.Exception.EmployeeNotFoundException;
import com.dailycodebuffer.springbootbasic.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {

        if(employee.getId() == null){
            employee.setId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        return employeeList.stream().filter(employee -> employee.getId().equals(empId)).findFirst().orElseThrow(
                ()-> new EmployeeNotFoundException("Employee Not Found With The Id: " + empId));
    }

    @Override
    public String deleteById(String empId) {
        Employee employee = employeeList.stream().filter(emp -> emp.getId().equals(empId)).findFirst().orElseThrow(
                ()-> new EmployeeNotFoundException("Employee id not found with id " + empId));
        employeeList.remove(employee);
        return "Employee deleted successfully";
    }
}
