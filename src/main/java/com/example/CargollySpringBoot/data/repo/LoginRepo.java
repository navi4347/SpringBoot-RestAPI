package com.example.CargollySpringBoot.data.repo;

import com.example.CargollySpringBoot.data.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

    /**
     * Find a login entity by username.
     *
     * @param username The username to search for.
     * @return The login entity if found, null otherwise.
     */
    Login findByUsername(String username);

    /**
     * Find a login entity by both username and password.
     *
     * @param username The username to search for.
     * @param password The password to search for.
     * @return The login entity if found, null otherwise.
     */
    Login findByUsernameAndPassword(String username, String password);
}
