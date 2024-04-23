package com.example.kursach.repository;

import ch.qos.logback.core.model.INamedModel;
import com.example.kursach.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
