package com.example.projectManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectManagement.Entity.Employee;
import com.example.projectManagement.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        // Generate formatted employeeId
        String employeeId = generateEmployeeId();
        employee.setEmployeeId(employeeId);

        // Generate temporary password
        String tempPassword = generateTemporaryPassword();
        employee.setPassword(tempPassword); // Assuming you have a password field

        // Save employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Send email
        String subject = "Welcome to the Company";
        String text = "Dear " + employee.getFirstName() + ",\n\n" +
                "Your account has been created. Here are your login details:\n" +
                "Username: " + employee.getEmail() + "\n" +
                "Temporary Password: " + tempPassword + "\n\n" +
                "Please change your password after logging in for the first time.\n\n" +
                "Best regards,\n" +
                "The Team";
        emailService.sendEmail(employee.getEmail(), subject, text);

        return savedEmployee;
    }

    private String generateEmployeeId() {
        // Get the current count of employees
        long count = employeeRepository.count();

        // Generate formatted employeeId (e.g., Emp001, Emp002, ...)
        return "Emp" + String.format("%03d", count + 1);
    }

    private String generateTemporaryPassword() {
        // Generate a simple temporary password. In a real application, use a more secure method.
        return "temp1234";
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
