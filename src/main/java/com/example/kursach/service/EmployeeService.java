package com.example.kursach.service;

import com.example.kursach.entity.Employee;
import com.example.kursach.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployess()
    {
        List<Employee> employee = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
        return employee;
    }

    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).get();
    }
    public void saveOrUpdate(Employee employee)
    {
        employeeRepository.save(employee);
    }
    public void delete(int id)
    {
        employeeRepository.deleteById(id);
    }
    public void update(Employee employee, int id)
    {
        employeeRepository.save(employee);
    }

}
