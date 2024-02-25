package com.example.CargollySpringBoot.service.impl;

import com.example.CargollySpringBoot.service.LoginService;
import com.example.CargollySpringBoot.data.entity.Login;
import com.example.CargollySpringBoot.data.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepo loginRepo;

    @Autowired
    public LoginServiceImpl(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    @Override
    public boolean authenticate(String username, String password) {
        // Find user by username and password
        Login user = loginRepo.findByUsernameAndPassword(username, password);
        return user != null;
    }

    @Override
    public String generateToken(String username) {
        // Generate token logic (you can use JWT or any other token generation mechanism)
        return "GeneratedTokenFor" + username;
    }

    @Override
    public boolean usernameExists(String username) {
        // Check if username exists
        return loginRepo.findByUsername(username) != null;
    }

    @Override
    public boolean register(String username, String password) {
        // Check if username already exists
        if (usernameExists(username)) {
            return false; // Username already exists, registration failed
        }
        // Create new user entity and save it to the database
        Login newUser = new Login(username, password);
        loginRepo.save(newUser);
        return true; // Registration successful
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        // Find user by username
        Login user = loginRepo.findByUsername(username);
        if (user == null) {
            return false; // User not found, password update failed
        }
        // Update user's password
        user.setPassword(newPassword);
        loginRepo.save(user);
        return true; // Password update successful
    }

    @Override
    public boolean deleteUser(String username) {
        // Find user by username
        Login user = loginRepo.findByUsername(username);
        if (user == null) {
            return false; // User not found, deletion failed
        }
        // Delete user
        loginRepo.delete(user);
        return true; // Deletion successful
    }
}
