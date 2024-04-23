package com.example.kursach.controller;

import com.example.kursach.entity.Employee;
import com.example.kursach.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employee")
    private List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployess();
    }
    @GetMapping("/employee/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id)
    {
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/employee/{id}")
    private void deleteEmployee(@PathVariable("id") int id)
    {
        employeeService.delete(id);
    }
    @PostMapping("/employee")
    private int saveEmployee(@RequestBody Employee employee)
    {
        employeeService.saveOrUpdate(employee);
        return employee.getId();
    }
    @PutMapping("/employee")
    private Employee update(@RequestBody Employee employee)
    {
        employeeService.saveOrUpdate(employee);
        return employee;
    }
}
