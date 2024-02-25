package com.example.CargollySpringBoot.controller;

import com.example.CargollySpringBoot.model.request.LoginRequest;
import com.example.CargollySpringBoot.model.response.LoginResponse;
import com.example.CargollySpringBoot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
        // Validate request payload
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return a bad request status
            return ResponseEntity.badRequest().build();
        }

        // Call the login service to authenticate the user
        boolean isAuthenticated = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // If authentication is successful, create and return a login response
            String token = loginService.generateToken(loginRequest.getUsername());
            LoginResponse response = new LoginResponse("Login successful", token);
            return ResponseEntity.ok(response);
        } else {
            // If authentication fails, return an unauthorized status
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
