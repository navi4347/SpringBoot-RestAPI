package com.example.CargollySpringBoot.service;

import com.example.CargollySpringBoot.data.entity.Login;
import com.example.CargollySpringBoot.model.request.LoginRequest;

import java.util.List;

public interface LoginService {

    Login createLogin(LoginRequest login);

    List<Login> getAllLogins();
}
