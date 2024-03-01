package com.example.CargollySpringBoot.service.impl;

import com.example.CargollySpringBoot.data.entity.Login;
import com.example.CargollySpringBoot.data.repo.LoginRepo;
import com.example.CargollySpringBoot.model.request.LoginRequest;
import com.example.CargollySpringBoot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private final LoginRepo loginRepo;

    @Autowired
    public LoginServiceImpl(LoginRepo loginRepo) {

        this.loginRepo = loginRepo;
    }

    @Override
    public Login createLogin(LoginRequest loginRequest) {
        Login login = new Login();
        login.setUserName(loginRequest.getUserName());
        login.setPassword(loginRequest.getPassword());
        login.setRole(loginRequest.getRole());
        return loginRepo.save(login);
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepo.findAll();
    }
}
