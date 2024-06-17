package com.example.department_1.Service;

import com.example.department_1.Entity.Department;
import com.example.department_1.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public <Department> List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return (Department) departmentRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = (Department) departmentRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(departmentDetails.getName());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department department = (Department) departmentRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.delete(department);
    }
}
