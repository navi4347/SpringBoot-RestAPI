package com.example.CargollySpringBoot.data.repo;

import com.example.CargollySpringBoot.data.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, String> {

}
