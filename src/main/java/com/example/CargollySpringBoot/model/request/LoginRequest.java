package com.example.CargollySpringBoot.model.request;

import com.example.CargollySpringBoot.enums.LoginRole;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
    private String role;
}
