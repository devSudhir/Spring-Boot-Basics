package com.dailycodebuffer.springbootbasic.service;

import com.dailycodebuffer.springbootbasic.Exception.EmployeeNotFoundException;
import com.dailycodebuffer.springbootbasic.entities.EmployeeEntity;
import com.dailycodebuffer.springbootbasic.model.Employee;
import com.dailycodebuffer.springbootbasic.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getId() == null){
            employee.setId(UUID.randomUUID().toString());
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return  employeeEntities.stream().map(empEntity -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(empEntity, employee);
            return employee;
        }).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(String empId) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(empId).orElseThrow(
                        ()-> new EmployeeNotFoundException("Employee not found with this id"));
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteById(String empId) {
        employeeRepository.deleteById(empId);
        return empId + " Deleted";
    }
}
