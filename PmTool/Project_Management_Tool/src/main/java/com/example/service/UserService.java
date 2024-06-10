package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean validateUser(String username, String password) {
        User user = findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
