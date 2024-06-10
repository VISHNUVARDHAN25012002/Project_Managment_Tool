package com.example.service;


import com.example.entity.UserGroup;
import com.example.repo.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public List<UserGroup> getAllUserGroups() {
        return userGroupRepository.findAll();
    }

    public Optional<UserGroup> getUserGroupById(Long id) {
        return userGroupRepository.findById(id);
    }

    public UserGroup createUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public UserGroup updateUserGroup(Long id, UserGroup userGroupDetails) {
        UserGroup userGroup = userGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("UserGroup not found with id " + id));

        userGroup.setName(userGroupDetails.getName());
        userGroup.setDescription(userGroupDetails.getDescription());

        return userGroupRepository.save(userGroup);
    }

    public void deleteUserGroup(Long id) {
        UserGroup userGroup = userGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("UserGroup not found with id " + id));
        userGroupRepository.delete(userGroup);
    }
}
