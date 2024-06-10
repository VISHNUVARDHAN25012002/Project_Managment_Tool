package com.example.controller;


import com.example.entity.UserGroup;
import com.example.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usergroups")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping
    public String getAllUserGroups(Model model) {
        List<UserGroup> userGroups = userGroupService.getAllUserGroups();
        model.addAttribute("userGroups", userGroups);
        return "usergroups";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("userGroup", new UserGroup());
        return "create_usergroup";
    }

    @PostMapping
    public String createUserGroup(@ModelAttribute UserGroup userGroup) {
        userGroupService.createUserGroup(userGroup);
        return "redirect:/usergroups";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        UserGroup userGroup = userGroupService.getUserGroupById(id).orElseThrow(() -> new RuntimeException("UserGroup not found with id " + id));
        model.addAttribute("userGroup", userGroup);
        return "edit_usergroup";
    }

    @PostMapping("/update/{id}")
    public String updateUserGroup(@PathVariable Long id, @ModelAttribute UserGroup userGroup) {
        userGroupService.updateUserGroup(id, userGroup);
        return "redirect:/usergroups";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserGroup(@PathVariable Long id) {
        userGroupService.deleteUserGroup(id);
        return "redirect:/usergroups";
    }
}
