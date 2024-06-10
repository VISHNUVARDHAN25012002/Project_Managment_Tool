package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.User;
import com.example.repo.EmployeeRepository;
import com.example.repo.ProjectRepository;
import com.example.repo.TaskRepository;
import com.example.repo.UserRepo;
import com.example.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.validateUser(username, password)) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long employeeCount = employeeRepository.count();
        long projectCount = projectRepository.count();
        long taskCount = taskRepository.count();
        model.addAttribute("employeeCount", employeeCount);
        model.addAttribute("projectCount", projectCount);
        model.addAttribute("taskCount", taskCount);
        return "dashboard";
    }
}



