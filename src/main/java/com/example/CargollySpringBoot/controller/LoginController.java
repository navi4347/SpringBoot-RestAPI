package com.example.CargollySpringBoot.controller;
import com.example.CargollySpringBoot.data.entity.Login;
import com.example.CargollySpringBoot.data.repo.LoginRepo;
import com.example.CargollySpringBoot.model.request.LoginRequest;
import com.example.CargollySpringBoot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginRepo loginRepo;

    @GetMapping("/login")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> loginList = loginRepo.findAll();
        if (!loginList.isEmpty()) {
            return new ResponseEntity<>(loginList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> createLogin(@RequestBody LoginRequest loginRequest) {
        Login savedLogin = loginService.createLogin(loginRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLogin);
    }

}
