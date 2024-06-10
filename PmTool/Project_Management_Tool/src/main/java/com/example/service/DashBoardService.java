package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.EmployeeRepository;
import com.example.repo.ProjectRepository;
import com.example.repo.TaskRepository;

@Service
public class DashBoardService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private TaskRepository taskRepository;

    public long getEmployeeCount() {
        return employeeRepository.count();
    }

    public long getProjectCount() {
        return projectRepository.count();
    }

    public long getTaskCount() {
        return taskRepository.count();
    }
}
