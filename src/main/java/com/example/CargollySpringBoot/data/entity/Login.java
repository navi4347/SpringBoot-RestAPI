package com.example.CargollySpringBoot.data.entity;

import com.example.CargollySpringBoot.enums.LoginRole;
import com.example.CargollySpringBoot.service.util.AppConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = AppConstants.TB_LOGIN,
        schema = AppConstants.SCHEMA_NAME
)
@Builder
public class Login {

    @Id
    private String userName;
    private String password;
    private String role;
}
