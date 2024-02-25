package com.example.CargollySpringBoot.service;

public interface LoginService {

    /**
     * Authenticate a user with the given username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if the user is authenticated, false otherwise.
     */
    boolean authenticate(String username, String password);

    /**
     * Generate a token for the authenticated user.
     *
     * @param username The username of the authenticated user.
     * @return A token string.
     */
    String generateToken(String username);

    /**
     * Check if a username already exists.
     *
     * @param username The username to check.
     * @return true if the username exists, false otherwise.
     */
    boolean usernameExists(String username);

    /**
     * Register a new user with the given username and password.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return true if the registration is successful, false otherwise.
     */
    boolean register(String username, String password);

    /**
     * Update the password for the user with the given username.
     *
     * @param username    The username of the user.
     * @param newPassword The new password.
     * @return true if the password update is successful, false otherwise.
     */
    boolean updatePassword(String username, String newPassword);

    /**
     * Delete the user with the given username.
     *
     * @param username The username of the user to delete.
     * @return true if the deletion is successful, false otherwise.
     */
    boolean deleteUser(String username);
}
