package com.dailycodebuffer.springbootbasic.controller;

import com.dailycodebuffer.springbootbasic.model.Employee;
import com.dailycodebuffer.springbootbasic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public Employee saveEmp(@RequestBody Employee employee){
      return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{emp_id}")
    public Employee getEmployeeById(@PathVariable(name = "emp_id") String empId){
        return employeeService.getEmployeeById(empId);
    }

    @DeleteMapping("/{emp_id}")
    public String deleteEmployee(@PathVariable(name = "emp_id") String empId){
        return employeeService.deleteById(empId);
    }
}
