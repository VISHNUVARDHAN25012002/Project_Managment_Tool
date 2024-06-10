/*package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.service.DashBoardService;

@Controller
public class DashBoardController {

    @Autowired
    private DashBoardService dashboardService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username", username);
        model.addAttribute("employeeCount", dashboardService.getEmployeeCount());
        model.addAttribute("projectCount", dashboardService.getProjectCount());
        model.addAttribute("taskCount", dashboardService.getTaskCount());
        return "dashboard";
    }
}
*/