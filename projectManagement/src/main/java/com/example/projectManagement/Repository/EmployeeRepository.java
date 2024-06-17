package com.example.projectManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectManagement.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
